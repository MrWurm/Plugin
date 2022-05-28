package its.wurm.testplugin.Mobs;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.Listener;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public enum Mobs implements Listener {
    DUMMY(new Items[]{Items.MENU_GLASS}, new float[]{.5f}, new int[]{1}, 0.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            zombie.setAI(false);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1000000000.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1000000000.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Dummy");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    NOVICE_SKELETON(new Items[]{Items.ENCHANTED_BONE}, new float[]{.125f}, new int[]{1}, 10.0, 13) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
            ItemStack main = new ItemStack(Material.BOW);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setHelmetDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 330.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 330.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 70.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Novice Skeleton");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    FENCER_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.IRON_SCIMITAR}, new float[]{.11f, .05f}, new int[]{1, 1}, 15.0, 18) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGRjMjZmNGJiMjc4MGE5NWM2NjE0YWQ5Yjc0ZmFkN2VhNzdjNDJlMDYyNTM1YWRhNzE0MDIyYTY2ODgxY2Q4MiJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(247, 247, 242));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(247, 247, 242));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(247, 247, 242));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.IRON_SWORD, 1);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 370.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 370.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 30.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.8);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Fencer Zombie");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    RENEGADE_PILLAGER(new Items[]{Items.ENCHANTED_EMERALD, Items.RENEGADE_CROSSBOW}, new float[]{.05f, .05f}, new int[]{1, 1}, 12.0, 8) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Pillager pillager = location.getWorld().spawn(location, Pillager.class);
            pillager.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));


            ItemStack main = new ItemStack(Material.CROSSBOW, 1);
            pillager.getEquipment().setItemInMainHand(main);
            pillager.getEquipment().setItemInMainHandDropChance(0f);


            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 420.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 420.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 60.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Renegade Pillager");
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            pillager.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return pillager;
        }
    },

    MARAUDING_VINDICATOR(new Items[]{Items.ENCHANTED_EMERALD, Items.ENCHANTED_IRON, Items.MARAUDER_AXE}, new float[]{.07f, .12f, .035f}, new int[]{1, 1, 1}, 18.0, 6) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Vindicator vindicator = location.getWorld().spawn(location, Vindicator.class);
            vindicator.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            ItemStack main = new ItemStack(Material.IRON_AXE, 1);
            vindicator.getEquipment().setItemInMainHand(main);
            vindicator.getEquipment().setItemInMainHandDropChance(0f);

            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 400.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 400.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 40.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 30.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Marauding Vindicator");
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            vindicator.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return vindicator;
        }
    },

    SKELETON_GRUNT(new Items[]{Items.ENCHANTED_BONE, Items.HAIR_TRIGGER}, new float[]{.15f, .065f}, new int[]{1, 1}, 16.0, 6) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQxNDY2MTk5YjcyY2JjODg4OWJiOGE1MmUwZjRiYTEzYmNkZDVmYWI5N2VlYjk0ODIxNDE4N2I2MmYwNjQwZCJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(177, 195, 199));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(177, 195, 199));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(177, 195, 199));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.BOW, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
                skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 290.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 290.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 15.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.8);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Skeleton Grunt");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            new BukkitRunnable() {
                public void run()
                {
                    if (skeleton.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (skeleton.getTarget() != null) {
                        Attacks.createArrowStatic(skeleton.getEyeLocation(), plugin, skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), skeleton, new Vector(skeleton.getTarget().getEyeLocation().getX() - skeleton.getEyeLocation().getX(), skeleton.getTarget().getEyeLocation().getY() - skeleton.getEyeLocation().getY(), skeleton.getTarget().getEyeLocation().getZ() - skeleton.getEyeLocation().getZ()).normalize().multiply(1.6), "", 0);
                    }
                }
            }.runTaskTimer(plugin, 10, 12);

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    CREEPLING(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.SEVERED_CREEPER_HEAD}, new float[]{.09f, .005f}, new int[]{1, 1}, 22.0, 9) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Creeper creeper = location.getWorld().spawn(location, Creeper.class);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            creeper.setMaxFuseTicks(25);
            creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.2);

            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 220.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 220.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 360.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Creepling");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return creeper;
        }
    },

    WOLF_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.MONSTER_MEAT, Items.POWDERED_FUZZ}, new float[]{.12f, .07f, .2f, .025f}, new int[]{1, 1, 1, 1}, 25.0, 7) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Spider spider = location.getWorld().spawn(location, Spider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.55);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 570.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 570.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 60.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Wolf Spider");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return spider;
        }
    },

    BEEKEEPER(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.BEEKEEPER_HAT, Items.BEEKEEPER_VEST, Items.BEEKEEPER_PANTS, Items.BEEKEEPER_BOOTS}, new float[]{.14f, .05f, .05f, .05f, .05f}, new int[]{1, 1, 1, 1, 1}, 16.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjE1YmJiOGNjODdlNTU4ZDE1OWZkYWNiYTg4ZjUzNDI5OWZjZWNjODc0ZjYxYmQ3MzMzODk2YTJjYjM0ZmNjMSJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(16, 111, 125));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(16, 111, 125));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(16, 111, 125));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.CAMPFIRE);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 350.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 350.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 25.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Beekeeper");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                Zombie entity = zombie;
                public void run()
                {
                    if (zombie.isDead()) {
                        this.cancel();
                        return;
                    }

                    for (int i = 0; i < 3; i++) {
                        Mobs.ANGRY_BEE.createMob(plugin, entity.getLocation());
                    }
                }
            }.runTaskTimer(plugin, 10, 600);

            return zombie;
        }
    },

    ANGRY_BEE(new Items[]{}, new float[]{}, new int[]{}, 1.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Bee bee = location.getWorld().spawn(location, Bee.class);
            bee.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 60.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 60.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 20.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Angry Bee");
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            bee.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            StatFunctions.mobTargetPlayer(bee, plugin, true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    bee.remove();
                }
            }, 600);

            return bee;
        }
    },

    SWARM_MARKER(new Items[]{}, new float[]{}, new int[]{}, 0.0, 10) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            ArmorStand bee = location.getWorld().spawn(location, ArmorStand.class);
            bee.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 0.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Swarm Marker");
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            for (int i = 0; i < 3; i++) {
                Mobs.BEE_SWARMER.createMob(plugin, location);
            }

            bee.remove();

            return bee;
        }
    },

    BEE_SWARMER(new Items[]{Items.STINGER, Items.SWARMER_HEAD}, new float[]{.06f, .04f}, new int[]{1, 1}, 5.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            Bee bee = location.getWorld().spawn(location, Bee.class);
            bee.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 80.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 80.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 2.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Bee Swarmer");
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            bee.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            StatFunctions.mobTargetPlayer(bee, plugin, true);

            return bee;
        }
    },

    HONEY_SLIME(new Items[]{Items.ENCHANTED_SLIMEBALL, Items.LIVING_HONEY, Items.HONEY_DYE}, new float[]{.125f, .055f, .08f}, new int[]{1, 1, 1}, 15.0, 8) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            MagmaCube slime = location.getWorld().spawn(location, MagmaCube.class);
            slime.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));

            slime.setSize(0);

            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 220.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 220.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 40.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 2.5);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Honey Slime");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            ArmorStand stand = location.getWorld().spawn(location, ArmorStand.class);
            stand.getEquipment().setHelmet(new ItemStack(Material.HONEY_BLOCK));
            stand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.ADDING_OR_CHANGING);
            stand.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.ADDING_OR_CHANGING);
            stand.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.ADDING_OR_CHANGING);
            stand.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.ADDING_OR_CHANGING);
            stand.setInvulnerable(true);
            stand.setInvisible(true);
            stand.setGravity(false);
            stand.setCollidable(false);

            new BukkitRunnable() {
                public void run()
                {
                    if (slime.isDead()) {
                        stand.remove();
                        this.cancel();
                        return;
                    }

                    stand.teleport(new Location(slime.getWorld(), slime.getLocation().getX(), slime.getLocation().getY() - 1.2, slime.getLocation().getZ()));
                    stand.getLocation().setPitch(slime.getLocation().getPitch());
                    stand.getLocation().setYaw(slime.getLocation().getYaw());
                }
            }.runTaskTimer(plugin, 10, 2);

            String Name = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            slime.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            StatFunctions.mobTargetPlayer(slime, plugin, true);

            return slime;
        }
    },

    SWARM_ARCHER(new Items[]{Items.ENCHANTED_BONE, Items.SWARMER_HEAD}, new float[]{.17f, .075f}, new int[]{1, 1}, 18.0, 10) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTc0YTM1MzI0MzhmNzQ2NmE2MDI4NDFiZjUxODcxOWNhYjJlNGNlYjk4ODkyZjIyNjAyOTUxNmExOWQwZGFkZCJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(15, 201, 214));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(0, 0, 0));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(15, 201, 214));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.BOW, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 300.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 300.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 40.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Swarm Archer");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    HONEYPOT_CREEPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.ENCHANTED_SUGAR, Items.SEVERED_CREEPER_HEAD, Items.HONEY_DYE}, new float[]{.14f, .04f, .005f, .06f}, new int[]{1, 1, 1, 1}, 18.0, 6) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Creeper creeper = location.getWorld().spawn(location, Creeper.class);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 0.9);

            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 340.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 340.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 560.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 2.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Honeypot Creeper");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return creeper;
        }
    },

    ROTTING_FISHERMAN(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_COD, Items.ENCHANTED_SALMON, Items.ENCHANTED_PUFFERFISH, Items.ENCHANTED_CLOWNFISH}, new float[]{.11f, .08f, .05f, .035f, .02f}, new int[]{1, 1, 1, 1, 1}, 16.0, 14) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGY1YTc3MTQyNGU4ZWJlZTVjOWIzM2QyNDdiNjUyOTU2MThhMTI3NWNiODliZmY5MjEzYTZlOTQ0ZTJiNiJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(16, 18,16));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(39,54,39));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(16,18,16));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.FISHING_ROD);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 320.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 320.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 35.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Rotting Fisherman");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    AQUATIC_ISOPOD(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_COD, Items.SILVERFISH_SCALE}, new float[]{.09f, .13f, .075f}, new int[]{1, 1, 1}, 14.0, 14) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Silverfish silverfish = location.getWorld().spawn(location, Silverfish.class);
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,
                    9999999, 0, true, false));
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                    9999999, 3, true, false));

            silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.7);

            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 140.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 140.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 40.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 80.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Aquatic Isopod");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            silverfish.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return silverfish;
        }
    },

    SEA_SKELETON(new Items[]{Items.ENCHANTED_BONE, Items.ENCHANTED_KELP}, new float[]{.13f, .25f}, new int[]{1, 1}, 16.0, 9) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGI4ZGZiM2Y4MjUyN2QyYzQ4YWY4MDhhNzIyMjZkMWNhMGRkMGVkYWFiYjU3NGRiZTc4ZGI3N2FjYTJmZDJmIn19fQ==");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(15, 71, 35));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(15, 71, 35));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(15, 71, 35));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.BOW, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 330.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 330.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 75.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Sea Skeleton");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    RUSTY_GOLEM(new Items[]{Items.ENCHANTED_COPPER, Items.RUSTY_COG}, new float[]{.3f, .1f}, new int[]{1, 1}, 18.0, 5) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            IronGolem golem = location.getWorld().spawn(location, IronGolem.class);
            golem.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            golem.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(golem.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 0.7);

            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 550.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 550.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 40.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.6);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Rusty Golem");
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            golem.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(golem, plugin, true);

            return golem;
        }
    },

    ARMOR_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_IRON, Items.ALLOY}, new float[]{.18f, .12f, .035f}, new int[]{1, 1, 1}, 20.0, 20) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
            ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
            ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
            ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
            ItemStack main = new ItemStack(Material.STONE_SWORD, 1);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setHelmetDropChance(0f);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 650.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 650.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 120.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 45.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Armored Zombie");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    ZOMBIE_CRUSADER(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.HOLY_SHIELD}, new float[]{.135f, .035f}, new int[]{1, 1}, 25.0, 16) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjc5ZTE3YjEzNDFlNDIxN2VhYjI2YzdkY2MzMTliZjUxNjY4OTZlY2ZlYjUyMzJhZDM3NjU2NTAzOGRiNSJ9fX0===");
            ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
            ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
            ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);

            ItemStack main = new ItemStack(Material.IRON_SWORD, 1);
            ItemStack off = new ItemStack(Material.SHIELD, 1);

            BlockStateMeta offMeta = (BlockStateMeta) off.getItemMeta();
            Banner banner = (Banner) offMeta.getBlockState();
            banner.setBaseColor(DyeColor.WHITE);
            banner.addPattern(new Pattern(DyeColor.RED, PatternType.STRAIGHT_CROSS));
            offMeta.setBlockState(banner);
            off.setItemMeta(offMeta);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setItemInOffHand(off);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);
            zombie.getEquipment().setItemInOffHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 900.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 900.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 55.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 30.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.5);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Crusader Zombie");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    HUNTER(new Items[]{Items.ENCHANTED_EMERALD, Items.MONSTER_MEAT, Items.HIDE, Items.HUNTER_CAP}, new float[]{.08f, .2f, .12f, .04f}, new int[]{1, 1, 1, 1}, 32.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Pillager pillager = location.getWorld().spawn(location, Pillager.class);
            pillager.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));


            ItemStack main = new ItemStack(Material.CROSSBOW, 1);
            CrossbowMeta mainMeta = (CrossbowMeta) main.getItemMeta();
            List<ItemStack> items = new ArrayList<>();
            items.add(new ItemStack(Material.SPECTRAL_ARROW));
            mainMeta.setChargedProjectiles(items);
            mainMeta.addEnchant(Enchantment.QUICK_CHARGE, 4, false);
            main.setItemMeta(mainMeta);
            pillager.getEquipment().setItemInMainHand(main);
            pillager.getEquipment().setItemInMainHandDropChance(0f);

            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 710.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 710.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 60.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Hunter");
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            pillager.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return pillager;
        }
    },

    FOREST_SPIRIT(new Items[]{Items.ENCHANTED_OAK_WOOD, Items.ENCHANTED_BIRCH_WOOD, Items.FOREST_ESSENCE}, new float[]{.22f, .21f, .035f}, new int[]{2, 2, 1}, 25.0, 8) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Vex vex = location.getWorld().spawn(location, Vex.class);
            vex.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            vex.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));
            vex.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                    9999999, 0, true, false));

            //Equip the vex
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzM4YjBiMGYxZjM1YzU2YjdkNjRlMGUyYjk2NjE4MDFmOTEyZjMxOGZhOWM4YzFkODNlOTE3ZGI0ZjJlNjUyMSJ9fX0=");

            ItemStack main = new ItemStack(Material.OAK_SAPLING, 1);
            ItemStack off = new ItemStack(Material.STICK, 1);

            Scoreboard manager = Bukkit.getScoreboardManager().getMainScoreboard();
            manager.getTeam("dark_green").addEntry(vex.getUniqueId().toString());

            vex.getEquipment().setHelmet(helmet);
            vex.getEquipment().setItemInMainHand(main);
            vex.getEquipment().setItemInOffHand(off);
            vex.getEquipment().setItemInOffHandDropChance(0f);
            vex.getEquipment().setItemInMainHandDropChance(0f);

            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 320.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 320.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 100.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 2.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Forest Spirit");
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            new BukkitRunnable() {
                public void run()
                {
                    if (vex.isDead()) {
                        this.cancel();
                        return;
                    }
                    StatFunctions.staticHeal(plugin, vex, 20);
                }
            }.runTaskTimer(plugin, 0, 10);

            String Name = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            vex.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return vex;
        }
    },

    WOOD_MITE(new Items[]{Items.ENCHANTED_OAK_WOOD, Items.SILVERFISH_SCALE}, new float[]{.125f, .15f}, new int[]{3, 1}, 28.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Silverfish silverfish = location.getWorld().spawn(location, Silverfish.class);
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 2);

            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 270.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 270.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 40.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Wood Mite");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            silverfish.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return silverfish;
        }
    },

    HOST(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.SILVERFISH_SCALE}, new float[]{.12f, .2f}, new int[]{1, 1}, 25.0, 25) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the Zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDRiYjI2MjdiMmRmODg0MjRmM2Q2MDY3NDk3ZGQyMzAzOWM1ODI2OTI5NTllYTE2NDhiYzc2YzFhOGNlYTgwIn19fQ==");
            ItemStack main = new ItemStack(Material.FERMENTED_SPIDER_EYE);
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(74,98,107));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(184,175,94));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(60,72,77));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 630.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 630.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 55.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Host");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    FLESH_MAGGOT(new Items[]{}, new float[]{}, new int[]{}, 0.1, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Silverfish attack = location.getWorld().spawn(location, Silverfish.class);
            attack.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 70.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 70.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 15.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.4);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Flesh Larva");
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            attack.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attack.remove();
                }
            }, 600);

            return attack;
        }
    },

    LEAFY_CREEPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.BUSH_SUIT, Items.SEVERED_CREEPER_HEAD}, new float[]{.21f, .08f, .035f}, new int[]{3, 1, 1}, 45.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Creeper creeper = location.getWorld().spawn(location, Creeper.class);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));

            FallingBlock block = location.getWorld().spawnFallingBlock(location, Bukkit.createBlockData(Material.AZALEA));
            block.setGravity(false);
            block.setDropItem(false);

            new BukkitRunnable() {
                public void run()
                {
                    if (creeper.isDead()) { block.remove(); this.cancel();}
                    block.setTicksLived(1);
                    block.teleport(creeper.getLocation());
                }
            }.runTaskTimer(plugin, 0, 1);

            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 400.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 400.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 680.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Bush Creeper");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return creeper;
        }
    },

    SCOUT(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.HARDWOOD_HANDLE, Items.ENCHANTED_SWEET_BERRIES}, new float[]{.24f, .035f, .09f}, new int[]{1, 1, 1}, 25.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            //Equip the Zombie
            ItemStack helmet = new ItemStack(Material.OAK_BUTTON);
            ItemStack main = new ItemStack(Material.STICK);
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(58, 84, 59));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(35, 48 , 35));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(35, 48 , 35));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setHelmetDropChance(0f);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(60);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 710.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 710.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 50.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Scout");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    CARNIVOROUS_CONEY(new Items[]{Items.HIDE, Items.ENCHANTED_RABBIT, Items.ENCHANTED_CARROT, Items.LUCKY_FOOT}, new float[]{.12f, .1f, .16f, .03f}, new int[]{1, 1, 1, 1}, 35.0, 6) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Rabbit rabbit = location.getWorld().spawn(location, Rabbit.class);
            rabbit.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            rabbit.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(30);
            rabbit.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 550.0);
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 550.0);
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 90.0);
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Carnivorous Coney");
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            rabbit.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = rabbit.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = rabbit.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = rabbit.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            rabbit.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return rabbit;
        }
    },

    RELENTLESS(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BONE, Items.DEATH_CHARM}, new float[]{.4f, .24f, .12f, .008f}, new int[]{3, 1, 1, 1}, 55.0, 21) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Husk zombie = location.getWorld().spawn(location, Husk.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTllNjk1MThjYzFhMzM0NGI2OTc3M2EwOWEyMzdjNjYzODFiODUyNzkxN2Y0YTM4NTBlZThhY2Y0ZWY0MjAzYiJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(33, 125, 158));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(49, 143, 176));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(49, 143, 176));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.TOTEM_OF_UNDYING, 1);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 570.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 570.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 115.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Relentless");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    SANDY_SKELETON(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_BONE, Items.CLUMPED_SAND}, new float[]{.3f, .12f, .07f}, new int[]{3, 3, 1}, 50.0, 16) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQ3ZTg2NGNlODliMGY2NGVmZDMxM2NlMjU4N2NiYjRlNjVkM2RmMThiMmExMjNkYzJhZjJlNTY2ZDAifX19");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(110, 181, 174));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(110, 181, 174));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(110, 181, 174));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.BOW, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1170.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1170.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 235.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Relentless");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    ANTLION(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_ROTTEN_FLESH, Items.CLUMPED_SAND, Items.SCOURGE}, new float[]{.2f, .25f, .08f, .045f}, new int[]{3, 1, 1, 1}, 45.0, 7) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Husk zombie = location.getWorld().spawn(location, Husk.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));
            zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0);
            zombie.setCollidable(false);
            FallingBlock block = location.getWorld().spawnFallingBlock(location, Bukkit.createBlockData(Material.SMOOTH_SANDSTONE_SLAB));
            block.setGravity(false);
            block.setDropItem(false);
            zombie.setSilent(true);
            zombie.setAdult();
            ItemStack air = new ItemStack(Material.AIR);

            zombie.getEquipment().setItemInMainHand(air);
            zombie.getEquipment().setHelmet(air);
            zombie.getEquipment().setChestplate(air);
            zombie.getEquipment().setLeggings(air);
            zombie.getEquipment().setBoots(air);

            new BukkitRunnable() {
                public void run()
                {
                    if (zombie.isDead()) { block.remove(); this.cancel();}
                    block.setTicksLived(1);
                    zombie.teleport(location);
                }
            }.runTaskTimer(plugin, 0, 10);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 200.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 200.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 550.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Antlion");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    BANDIT_ARCHER(new Items[]{Items.ENCHANTED_BONE, Items.ENCHANTED_GOLD, Items.ENCHANTED_LAPIS, Items.ENCHANTED_EMERALD}, new float[]{.2f, .075f, .05f, .03f}, new int[]{1, 1, 1, 1}, 45.0, 20) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2MwYTk2YTQ2MjBkNjgxZjA3Y2U0OWNkYzcwODc0OGQwN2RhNGZjMGQ4MjkyNjliN2FlYzU3MmUyZGNiNDNmZSJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(0, 0, 0));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(55, 55, 65));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(55, 55, 65));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.BOW, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1040.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1040.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 130.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Bandit Archer");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    ANCIENT_PHARAOH(new Items[]{Items.ENCHANTED_GOLD, Items.GOLDEN_SKULL, Items.ENCHANTED_BONE, Items.ONYX}, new float[]{.08f, .05f, .08f, .08f}, new int[]{2, 1, 3, 3}, 80.0, 10) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM0ZGU0NmIzNWJmYjc5NDE4ZTk2NjMzZjRhMWE5YmI1NTQ3YzhlYWQ2YmI4NGQ4MWIyZGUzYjFjZDFiZWMifX19");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(14, 200, 207));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(120, 23, 29));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(14, 200, 207));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.BLAZE_ROD, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 960.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 960.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 110.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 240.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Ancient Pharaoh");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (skeleton.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (skeleton.getTarget() != null) {
                        Snowball snowball = Attacks.createStaticSnowball(plugin, skeleton.getLocation(), skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) * 2.5, skeleton, skeleton.getLocation().getDirection().multiply(0.7), "", Material.PURPLE_GLAZED_TERRACOTTA);
                        Attacks.staticTrail(plugin, snowball, Particle.DRAGON_BREATH);
                        Attacks.staticTrack(plugin, snowball, skeleton, 3, 0.2);
                    }
                }
            }.runTaskTimer(plugin, 10, 320);

            return skeleton;
        }
    },

    SAND_WITCH(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_COMPACTED_SAND, Items.SAND_WAND}, new float[]{.15f, .08f, .03f}, new int[]{3, 3, 1}, 56.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Witch witch = location.getWorld().spawn(location, Witch.class);
            witch.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1080.0);
            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1080.0);
            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 400.0);
            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Sand Witch");
            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            witch.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = witch.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = witch.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = witch.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            witch.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return witch;
        }
    },

    CACTUS_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_CACTUS, Items.CACTUS_LEATHER}, new float[]{.12f, .2f, .03f}, new int[]{2, 2, 1}, 55.0, 30) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Husk zombie = location.getWorld().spawn(location, Husk.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = new ItemStack(Material.CACTUS);
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(14, 71, 23));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(14, 71, 23));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(14, 71, 23));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.WOODEN_SWORD, 1);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setHelmetDropChance(0f);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 770.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 770.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 90.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Relentless");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    CAMEL_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_COMPACTED_SAND, Items.SCOURGE}, new float[]{.12f, .1f, .06f}, new int[]{3, 4, 1}, 60.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Spider spider = location.getWorld().spawn(location, Spider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));


            spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.65);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 890.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 890.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 130.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Camel Spider");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return spider;
        }
    },

    BURROWING_CREEPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.SEVERED_CREEPER_HEAD, Items.CLUMPED_SAND, Items.ENCHANTED_COMPACTED_SAND}, new float[]{.13f, .01f, .05f, .24f}, new int[]{2, 1, 1, 3}, 55.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Creeper creeper = location.getWorld().spawn(location, Creeper.class);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            creeper.setMaxFuseTicks(50);
            creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.2);

            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 880.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 880.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 830.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Burrowing Creeper");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (creeper.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (creeper.getTarget() == null) {
                        creeper.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                                22, 7, true, false));
                        creeper.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                                22, 0, true, true));
                    }
                }
            }.runTaskTimer(plugin, 10, 20);

            return creeper;
        }
    },

    WANDERING_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.VENOMOUS_FANG, Items.POWDERED_FUZZ}, new float[]{.12f, .065f, .04f, .02f}, new int[]{3, 2, 1, 1}, 55.0, 25) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Spider spider = location.getWorld().spawn(location, Spider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                    9999999, 3, true, false));

            spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.35);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1170.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1170.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 85.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Wandering Spider");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (spider.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (spider.getTarget() != null) {
                        spider.setVelocity(new Vector(spider.getTarget().getEyeLocation().getX() - spider.getEyeLocation().getX(), spider.getTarget().getEyeLocation().getY() - spider.getEyeLocation().getY(), spider.getTarget().getEyeLocation().getZ() - spider.getEyeLocation().getZ()).normalize().multiply(2.4));
                    }
                }
            }.runTaskTimer(plugin, 1, 180);

            return spider;
        }
    },

    WEAVER_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.ENCHANTED_WEB, Items.POWDERED_FUZZ}, new float[]{.15f, .08f, .035f, .025f}, new int[]{3, 1, 1, 1}, 50.0, 21) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Spider spider = location.getWorld().spawn(location, Spider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));


            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 960.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 960.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 110.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Weaver Spider");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (spider.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (spider.getTarget() != null) {
                        Snowball snowball = Attacks.createStaticSnowball(plugin, spider.getEyeLocation(), 1.0, spider, new Vector(spider.getTarget().getEyeLocation().getX() - spider.getEyeLocation().getX(), spider.getTarget().getEyeLocation().getY() - spider.getEyeLocation().getY(), spider.getTarget().getEyeLocation().getZ() - spider.getEyeLocation().getZ()).normalize().multiply(1.2), "WEB", Material.COBWEB);
                        new BukkitRunnable() {
                            public void run()
                            {
                                if (snowball.isDead()) {
                                    snowball.getWorld().getBlockAt(snowball.getLocation()).setType(Material.COBWEB);
                                    this.cancel();
                                    return;
                                }
                            }
                        }.runTaskTimer(plugin, 1, 5);
                    }
                }
            }.runTaskTimer(plugin, 1, 360);

            return spider;
        }
    },

    ANGUISHED_SPIRIT(new Items[]{Items.ENCHANTED_ACACIA_WOOD, Items.ENCHANTED_REDSTONE, Items.FRAGMENTED_SOUL_REMNANTS}, new float[]{.2f, .06f, .08f}, new int[]{5, 1, 1}, 55.0, 21) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Piglin piglin = location.getWorld().spawn(location, Piglin.class);
            piglin.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            piglin.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                    9999999, 0, true, false));
            piglin.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));

            Scoreboard manager = Bukkit.getScoreboardManager().getMainScoreboard();
            manager.getTeam("dark_red").addEntry(piglin.getUniqueId().toString());
            piglin.setImmuneToZombification(true);

            //Equip the piglin
            ItemStack air = new ItemStack(Material.AIR);
            piglin.getEquipment().setHelmet(air);
            piglin.getEquipment().setChestplate(air);
            piglin.getEquipment().setLeggings(air);
            piglin.getEquipment().setBoots(air);
            piglin.getEquipment().setItemInMainHand(air);

            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 210.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 210.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 125.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Anguished Spirit");
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = piglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = piglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = piglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            piglin.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            StatFunctions.mobTargetPlayer(piglin, plugin, true);

            return piglin;
        }
    },

    PAINTED_DOG(new Items[]{Items.HIDE, Items.MONSTER_MEAT, Items.SCRUB}, new float[]{.09f, .2f, .075f}, new int[]{1, 3, 2}, 60.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    999999999, 4, true, false));

            wolf.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(wolf.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.4);

            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 970.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 970.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 110.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Painted Dog");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(wolf, plugin, true);

            return wolf;
        }
    },

    PIGMENTED_CREEPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.SEVERED_CREEPER_HEAD, Items.ENCHANTED_LAPIS, Items.MAGENTA_PIGMENT}, new float[]{.125f, .015f, .055f, .125f}, new int[]{1, 1, 1, 1}, 65.0, 18) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Creeper creeper = location.getWorld().spawn(location, Creeper.class);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            creeper.setMaxFuseTicks(40);
            creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.1);

            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1240.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1240.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 810.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Pigmented Creeper");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return creeper;
        }
    },

    HOG_RIDER(new Items[]{Items.HOG_HAMMER, Items.ENCHANTED_BEETROOT, Items.ENCHANTED_GOLD}, new float[]{.03f, .1f, .065f}, new int[]{1, 1, 1}, 25.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            PiglinBrute piglin = location.getWorld().spawn(location, PiglinBrute.class);
            piglin.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            piglin.setImmuneToZombification(true);

            //Equip the piglin
            ItemStack air = new ItemStack(Material.AIR);
            piglin.getEquipment().setHelmet(air);
            piglin.getEquipment().setChestplate(air);
            piglin.getEquipment().setLeggings(air);
            piglin.getEquipment().setBoots(air);
            piglin.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_AXE));
            piglin.getEquipment().setItemInMainHandDropChance(0f);

            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 550.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 550.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 110.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Hog Rider");
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            piglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = piglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = piglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = piglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            piglin.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return piglin;
        }
    },

    HOG(new Items[]{Items.ENCHANTED_PORK, Items.HIDE}, new float[]{.09f, .075f}, new int[]{1, 1}, 25.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Hoglin hoglin = location.getWorld().spawn(location, Hoglin.class);
            hoglin.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            hoglin.setImmuneToZombification(true);
            hoglin.setIsAbleToBeHunted(false);
            hoglin.addPassenger(Mobs.HOG_RIDER.createMob(plugin, location));

            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 870.0);
            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 870.0);
            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 70.0);
            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 30.0);
            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Hog");
            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            hoglin.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = hoglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = hoglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = hoglin.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            hoglin.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return hoglin;
        }
    },

    REGEN_ZOMBIE(new Items[]{}, new float[]{}, new int[]{}, 0.0, 35) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFhYzIyMzAxNTlhODAzZDI4Y2ZkZTY2NjJlYWYzNzlkYTg5YThhMDczYzdiZTIwYzZlN2U0MDhkZDg4NjFkMSJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(56, 75, 166));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(36, 50, 117));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setHelmetDropChance(0f);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 340.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 340.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 70.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Relentless Corpse");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    GROWTH(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.PULSING_TUMOR}, new float[]{.22f, .14f}, new int[]{3, 2}, 7.5, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Endermite attack = location.getWorld().spawn(location, Endermite.class);
            attack.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            attack.setAI(false);

            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 120.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 120.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Growth");
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            attack.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    if (attack.isDead() == false) {
                        Mobs.REGEN_ZOMBIE.createMob(plugin, attack.getLocation());
                    }
                    attack.remove();
                }
            }, 70);

            return attack;
        }
    },

    DARTMAN(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BONE, Items.DART, Items.VINE_PASTE}, new float[]{.1f, .07f, 1f, .04f}, new int[]{3, 1, 32, 1}, 50.0, 25) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY0YjNkMzhmYWE1ZGE0MDg4OGU5NzA1NmE0YTU3MmU5ZDMxMWU5MDZiMjhiNTU1N2M2YjQyNTdkMjY3YzIwOSJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromRGB(36, 74, 43));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromRGB(36, 74, 43));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromRGB(36, 74, 43));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.STICK));
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 920.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 920.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 60.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Dartman");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (zombie.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (zombie.getTarget() != null) {
                        Arrow arrow = Attacks.createArrowStatic(zombie.getEyeLocation(), plugin, zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), zombie, new Vector(zombie.getTarget().getEyeLocation().getX() - zombie.getEyeLocation().getX(), zombie.getTarget().getEyeLocation().getY() - zombie.getEyeLocation().getY(), zombie.getTarget().getEyeLocation().getZ() - zombie.getEyeLocation().getZ()).normalize().multiply(1.6), "Poison Dart", 0);
                        arrow.setColor(Color.fromRGB(43, 186, 69));

                    }
                }
            }.runTaskTimer(plugin, 10, 36);

            return zombie;
        }
    },

    SPEARMAN(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BONE, Items.ENCHANTED_BAMBOO, Items.SPEARHEAD, Items.VINE_PASTE}, new float[]{.12f, .1f, .1f, .06f, .04f}, new int[]{2, 2, 1, 1, 1}, 55.0, 35) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY0YjNkMzhmYWE1ZGE0MDg4OGU5NzA1NmE0YTU3MmU5ZDMxMWU5MDZiMjhiNTU1N2M2YjQyNTdkMjY3YzIwOSJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromRGB(36, 74, 43));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromRGB(36, 74, 43));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromRGB(36, 74, 43));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.BAMBOO));
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1180.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1180.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 100.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Spearman");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "attack"),
                    PersistentDataType.INTEGER, 0);

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (zombie.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (zombie.getTarget() != null && zombie.getLocation().distance(zombie.getTarget().getLocation()) <= 3) {
                        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "attack"),
                                PersistentDataType.INTEGER, 1);
                        zombie.attack(zombie.getTarget());
                    }
                }
            }.runTaskTimer(plugin, 10, 20);

            return zombie;
        }
    },

    PANDA_RIDER(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BAMBOO, Items.ENCHANTED_GOLD, Items.VINE_PASTE}, new float[]{.07f, .05f, .025f, .035f}, new int[]{1, 1, 1, 1}, 30.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the piglin
            ItemStack air = new ItemStack(Material.AIR);
            zombie.getEquipment().setHelmet(air);
            zombie.getEquipment().setChestplate(air);
            zombie.getEquipment().setLeggings(air);
            zombie.getEquipment().setBoots(air);
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_AXE));
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 430.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 430.);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 80.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Panda Jockey");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    PANDA_MOUNT(new Items[]{Items.ENCHANTED_BAMBOO, Items.MONSTER_MEAT, Items.HIDE}, new float[]{.08f, .2f, .04f}, new int[]{1, 1, 1}, 25.0, 21) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Panda panda = location.getWorld().spawn(location, Panda.class);
            panda.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            panda.addPassenger(Mobs.PANDA_RIDER.createMob(plugin, location));
            panda.setMainGene(Panda.Gene.AGGRESSIVE);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 870.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 870.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 120.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 70.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Jockey Panda");
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = panda.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = panda.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = panda.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            panda.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(panda, plugin, true);

            return panda;
        }
    },

    RAGING_PANDA(new Items[]{Items.ENCHANTED_BAMBOO, Items.MONSTER_MEAT, Items.HIDE, Items.STIMULATING_GLAND}, new float[]{.12f, .2f, .09f, .04f}, new int[]{3, 1, 1, 1}, 50.0, 16) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Panda panda = location.getWorld().spawn(location, Panda.class);
            panda.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            panda.setMainGene(Panda.Gene.AGGRESSIVE);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 960.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 960.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 120.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 150.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Raging Panda");
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            panda.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = panda.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = panda.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = panda.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            panda.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(panda, plugin, true);

            return panda;
        }
    },

    JUNGLE_SKELETON(new Items[]{Items.ENCHANTED_BONE, Items.ENCHANTED_GOLD, Items.VINE_PASTE}, new float[]{.12f, .09f, .04f}, new int[]{3, 1, 1}, 55.0, 25) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTNmYTVlYzk2ZDI1YmY2OTJlNTI4MTA0MDViNGJmOGRjYzY4OTdmYTZjMjBkMzY0NmZlZjNjNjRlMDNjNWI1In19fQ==");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromRGB(33, 102, 17));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromRGB(33, 102, 17));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromRGB(17, 61, 7));
            boots.setItemMeta(bootMeta);
            ItemStack main = new ItemStack(Material.BOW, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 860.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 860.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 150.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Jungle Skeleton");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    AMBUSH_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.VENOMOUS_FANG, Items.POWDERED_FUZZ}, new float[]{.1f, .09f, .045f, .03f}, new int[]{3, 1, 1, 1}, 50.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            CaveSpider spider = location.getWorld().spawn(location, CaveSpider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            spider.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));

            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 840.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 840.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 120.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Ambush Spider");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return spider;
        }
    },

    EPSILON(new Items[]{Items.ENCHANTED_DIAMOND, Items.FRAGMENTED_SOUL_REMNANTS, Items.ENCHANTED_JUNGLE_WOOD, Items.ENCHANTED_DEEPSLATE}, new float[]{.003f, .02f, .06f, .16f}, new int[]{1, 1, 1, 1}, 20.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Guardian guardian = location.getWorld().spawn(location, Guardian.class);
            guardian.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 240.0);
            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 240.0);
            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 35.0);
            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 80.0);
            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 2.0);
            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Epsilon");
            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            guardian.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = guardian.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = guardian.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = guardian.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            guardian.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return guardian;
        }
    },

    EPSILON_MARKER(new Items[]{}, new float[]{}, new int[]{}, 0.0, 8) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            ArmorStand stand = location.getWorld().spawn(location, ArmorStand.class);
            stand.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1.0);
            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1.0);
            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 0.0);
            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Swarm Marker");
            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            Ocelot ocelot = location.getWorld().spawn(location, Ocelot.class);
            ocelot.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            ocelot.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));
            ocelot.setSilent(true);
            ocelot.setInvulnerable(true);

            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1.0);
            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1.0);
            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 0.0);
            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Epsilon Mount");
            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            ocelot.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            LivingEntity bottom = Mobs.EPSILON.createMob(plugin, location);
            LivingEntity mid = Mobs.EPSILON.createMob(plugin, location);
            LivingEntity top = Mobs.EPSILON.createMob(plugin, location);
            ocelot.addPassenger(bottom);
            bottom.addPassenger(mid);
            mid.addPassenger(top);
            stand.remove();

            return stand;
        }
    },

    LOST_GOLEM(new Items[]{Items.ENCHANTED_IRON, Items.ALLOY, Items.TITANIUM_PLATE}, new float[]{.15f, .06f, .1f}, new int[]{2, 1, 1}, 60.0, 11) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            IronGolem golem = location.getWorld().spawn(location, IronGolem.class);
            golem.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1080.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1080.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 70.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 160.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.4);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Lost Golem");
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            golem.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(golem, plugin, true);

            return golem;
        }
    },

    CAMO_OOZE(new Items[]{}, new float[]{}, new int[]{}, 20.0, 13) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            Slime slime = location.getWorld().spawn(location, Slime.class);
            slime.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            slime.setSize(2);

            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 480.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 480.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 80.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Camo Ooze");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            slime.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (slime.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (slime.isOnGround()) {
                        slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                                2, 0, true, false));
                    }
                }
            }.runTaskTimer(plugin, 10, 1);

            return slime;
        }
    },

    SMALL_CAMO_OOZE(new Items[]{Items.ENCHANTED_SLIMEBALL, Items.DISCREET_SLUDGE, Items.VINE_PASTE}, new float[]{.08f, .005f, .006f}, new int[]{2, 1, 1}, 10.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            Slime slime = location.getWorld().spawn(location, Slime.class);
            slime.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            slime.setSize(1);

            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 120.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 120.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 25.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Small Camo Ooze");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            slime.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (slime.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (slime.isOnGround()) {
                        slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                                2, 0, true, false));
                    }
                }
            }.runTaskTimer(plugin, 10, 1);

            return slime;
        }
    },

    BLOB_MUTAGEN(new Items[]{Items.ENCHANTED_SLIMEBALL, Items.PULSING_TUMOR, Items.VINE_PASTE}, new float[]{.21f, .09f, .025f}, new int[]{2, 3, 1}, 10.0, 6) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            Slime slime = location.getWorld().spawn(location, Slime.class);
            slime.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            slime.setSize(3);
            Bukkit.getScoreboardManager().getMainScoreboard().getTeam("dark_red").addEntry(slime.getUniqueId().toString());

            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1220.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1220.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 135.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Blob Mutagen");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            slime.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                Item item = location.getWorld().spawn(location, Item.class);
                Random random = new Random();
                int amount = 0;
                public void run()
                {
                    if (slime.isDead()) {
                        item.remove();
                        this.cancel();
                        return;
                    }
                    if (amount % 100 == 0) {
                        item.setTicksLived(1);
                        item.setPickupDelay(110);
                    }

                    item.teleport(slime.getLocation());
                    if (amount % 300 == 0) {
                        switch (random.nextInt(6)) {
                            case 0:
                                item.setItemStack(new ItemStack(Material.ROTTEN_FLESH));
                                break;
                            case 1:
                                item.setItemStack(new ItemStack(Material.QUARTZ));
                                break;
                            case 2:
                                item.setItemStack(new ItemStack(Material.REDSTONE));
                                break;
                            case 3:
                                item.setItemStack(new ItemStack(Material.VINE));
                                break;
                            case 4:
                                item.setItemStack(new ItemStack(Material.JUNGLE_WOOD));
                                break;
                            case 5:
                                item.setItemStack(new ItemStack(Material.BONE_MEAL));
                                break;
                        }
                    }

                    if (amount % 5 == 0) {
                        switch (item.getItemStack().getType()) {
                            case ROTTEN_FLESH:
                                StatFunctions.staticHeal(plugin, slime, 20);
                                break;
                            case QUARTZ:
                                slime.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                                        6, 0, true, false));
                                break;
                            case BONE_MEAL:
                                slime.setInvulnerable(true);
                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    public void run() {
                                        slime.setInvulnerable(false);
                                    }
                                }, 2);
                                break;
                            case JUNGLE_WOOD:
                                if (amount % 10 == 0) {
                                    Mobs.FLESH_MAGGOT.createMob(plugin, slime.getLocation());
                                }
                                break;
                            case REDSTONE:
                                slime.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                                        6, 0, true, false));
                                break;
                        }
                    }
                    amount += 1;
                }
            }.runTaskTimer(plugin, 10, 1);

            return slime;
        }
    },

    ELITE_HUNTER(new Items[]{Items.ENCHANTED_EMERALD, Items.MONSTER_MEAT, Items.HIDE, Items.HUNTER_SHORTBOW}, new float[]{.08f, .3f, .12f, .02f}, new int[]{1, 3, 1, 1}, 55.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Pillager pillager = location.getWorld().spawn(location, Pillager.class);
            pillager.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            ItemStack main = new ItemStack(Material.CROSSBOW, 1);
            CrossbowMeta mainMeta = (CrossbowMeta) main.getItemMeta();
            List<ItemStack> items = new ArrayList<>();
            items.add(new ItemStack(Material.SPECTRAL_ARROW));
            mainMeta.setChargedProjectiles(items);
            mainMeta.addEnchant(Enchantment.QUICK_CHARGE, 3, false);
            main.setItemMeta(mainMeta);
            pillager.getEquipment().setItemInMainHand(main);
            pillager.getEquipment().setItemInMainHandDropChance(0f);

            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1160.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1160.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 100.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Hunter");
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            pillager.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            pillager.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return pillager;
        }
    },

    CREEPER_PURSUER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.SEVERED_CREEPER_HEAD, Items.VINE_PASTE, Items.ENCHANTED_STRING}, new float[]{.14f, .015f, .02f, .05f}, new int[]{2, 1, 1, 3}, 60.0, 18) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Creeper creeper = location.getWorld().spawn(location, Creeper.class);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 0.9);
            creeper.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(60);

            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 890.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 890.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 910.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Creeper Pursuer");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return creeper;
        }
    },

    DIRE_WOLF_ALPHA(new Items[]{Items.HIDE, Items.MONSTER_MEAT, Items.RAZOR_CLAW, Items.WOLF_FANG}, new float[]{.05f, 1f, .08f, .1f}, new int[]{1, 5, 1, 3}, 25.0, 24) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));


            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 740.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 740.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 80.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Dire Wolf Alpha");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(wolf, plugin, true);

            Random random = new Random();
            int choice = random.nextInt(4);
            for (int i = 0; i < choice; i ++) {
                Mobs.DIRE_WOLF.createMob(plugin, location);
            }
            choice = random.nextInt(2);
            for (int i = 0; i < choice; i ++) {
                Mobs.DIRE_WOLF_PUP.createMob(plugin, location);
            }

            return wolf;
        }
    },

    DIRE_WOLF(new Items[]{Items.HIDE, Items.MONSTER_MEAT, Items.WOLF_FANG}, new float[]{.03f, 1f, .08f}, new int[]{1, 2, 1}, 12.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));


            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 410.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 410.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 35.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Dire Wolf");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(wolf, plugin, true);
            return wolf;
        }
    },

    DIRE_WOLF_PUP(new Items[]{Items.MONSTER_MEAT}, new float[]{.25f}, new int[]{1}, 5.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            wolf.setAge(-999);
            wolf.setAgeLock(true);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 120.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 120.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 36.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Dire Wolf Pup");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return wolf;
        }
    },

    TIMBER_WOLF(new Items[]{Items.HIDE, Items.MONSTER_MEAT, Items.WOLF_FANG, Items.SCRUB}, new float[]{.11f, 1f, .1f, .085f}, new int[]{1, 5, 1, 1}, 40.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    999999999, 5, true, false));

            wolf.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.65);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1280.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1280.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 80.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Timber Wolf");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(wolf, plugin, true);

            return wolf;
        }
    },

    UNDEAD_LOGGER(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_SPRUCE_WOOD, Items.BUNDLED_SPRUCE_LOGS, Items.LUMBERJACKS_AXE}, new float[]{.1f, .2f, .03f, .05f}, new int[]{1, 1, 1, 1}, 50.0, 30) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmI0MTI5MjIyNzc0YzNmYTVlODBmNzVhMzFkOGI0ZWU4ODJjOGNlNjE2MzdiM2QwYTIyM2RlMmU0ZTY1NWI0In19fQ==");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromRGB(173, 17, 17));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromRGB(26, 67, 171));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromRGB(74, 27, 15));
            boots.setItemMeta(bootMeta);

            zombie.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).setBaseValue(zombie.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).getBaseValue() * 1.4);
            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 900.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 900.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 105.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Undead Logger");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    MULCHLING(new Items[]{Items.SILVERFISH_SCALE, Items.ENCHANTED_SPRUCE_WOOD, Items.BUNDLED_SPRUCE_LOGS}, new float[]{.08f, .1f, .025f}, new int[]{1, 2, 1}, 55.0, 16) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Silverfish silverfish = location.getWorld().spawn(location, Silverfish.class);
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.35);

            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 680.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 680.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 80.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Muchling");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            silverfish.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            Zombie stand = null;
            List<Material> podzol  = new ArrayList<>();
            podzol.add(Material.PODZOL);
            if (!(StatFunctions.getStaticNearbyBlocksOnly(12, 12, 12, location, podzol).isEmpty())) {
                stand = location.getWorld().spawn(StatFunctions.getStaticNearbyBlocksOnly(12, 12, 12,
                        location, podzol).get(0).getLocation(), Zombie.class);
                stand.setInvisible(true);
                stand.setBaby(true);
                stand.setAI(false);
                stand.setSilent(true);
                stand.setInvulnerable(true);
                stand.setGravity(false);
            }

            Zombie finalStand = stand;
            new BukkitRunnable() {
                public void run()
                {
                    if (silverfish.isDead()) {
                        this.cancel();
                        if (finalStand != null) {
                            finalStand.remove();
                        }
                        return;
                    }
                    if (silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) <= 240 && finalStand != null) {
                        silverfish.setTarget(finalStand);
                    }

                    if (silverfish.getWorld().getBlockAt(new Location(silverfish.getWorld(), silverfish.getLocation().getX(),
                        silverfish.getLocation().getY() - 1, silverfish.getLocation().getZ())).getType() == Material.PODZOL) {
                        StatFunctions.staticHeal(plugin, silverfish, 2);
                    }
                }
            }.runTaskTimer(plugin, 10, 1);

            return silverfish;
        }
    },

    DARK_IRON_ARCHER(new Items[]{Items.ENCHANTED_BONE, Items.ENCHANTED_IRON, Items.DARK_IRON_CORE, Items.GOLDEN_SKULL}, new float[]{.12f, .08f, .075f, .024f}, new int[]{1, 1, 1, 1}, 60.0, 22) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            skeleton.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(50);
            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjQ4ZmE5NGNkZGIyNGIzODQ1MzI4MTM1MWU1OGJiZTM2OGYzMzY1ZGI4ZDc2ZTQ2NDgxNzcxYjIwMjM1Mjk4NiJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
            ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
            ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
            ItemStack main = new ItemStack(Material.BOW, 1);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(chestplate);
            skeleton.getEquipment().setLeggings(leggings);
            skeleton.getEquipment().setBoots(boots);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1140.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1140.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 350.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Dark Iron Archer");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (skeleton.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (skeleton.getTarget() != null) {
                        Attacks.createArrowStatic(skeleton.getEyeLocation(), plugin, skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), skeleton, new Vector(skeleton.getTarget().getEyeLocation().getX() - skeleton.getEyeLocation().getX(), skeleton.getTarget().getEyeLocation().getY() - skeleton.getEyeLocation().getY(), skeleton.getTarget().getEyeLocation().getZ() - skeleton.getEyeLocation().getZ()).normalize().multiply(3.2), "", 0);
                    }
                }
            }.runTaskTimer(plugin, 10, 70);

            return skeleton;
        }
    },

    REVENANT(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BONE, Items.RELENTLESS_LIFEBLOOD, Items.ENCHANTED_IRON}, new float[]{.09f, .08f, .04f, .05f}, new int[]{3, 1, 1, 2}, 55.0, 14) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.65);

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjRiMDIwNDhhMWQ2YmExNjUxYzMxMDUwMDJlZDEzNWViN2U5MTYzYmUyMzk3NzA0NjUyOGE4ODUxZWM0M2I1NCJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromRGB(61, 31, 6));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            chestMeta.setColor(Color.fromRGB(31, 74, 38));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            chestMeta.setColor(Color.fromRGB(31, 74, 38));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_HOE));
            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 980.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 980.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 70.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Revenant");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    HOUNDMASTER(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_STRING, Items.KIBBLE}, new float[]{.075f, .03f, .2f}, new int[]{3, 2, 3}, 30.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = new ItemStack(Material.ACACIA_BUTTON);
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromRGB(138, 163, 46));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            chestMeta.setColor(Color.fromRGB(20, 99, 102));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            chestMeta.setColor(Color.fromRGB(41, 28, 14));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.BONE));
            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setHelmetDropChance(0f);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 810.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 810.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 50.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Houndmaster");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    HOUND(new Items[]{Items.MONSTER_MEAT, Items.ENCHANTED_BONE}, new float[]{.1f, .08f}, new int[]{1, 2}, 20.0, 18) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    999999999, 4, true, false));

            wolf.setLeashHolder(Mobs.HOUNDMASTER.createMob(plugin, location));

            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 660.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 660.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 70.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Hound");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(wolf, plugin, true);

            return wolf;
        }
    },

    HUNTER_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.SPIDER_HELMET, Items.POWDERED_FUZZ}, new float[]{.11f, .08f, .033f, .025f}, new int[]{3, 1, 1, 1}, 50.0, 20) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Spider spider = location.getWorld().spawn(location, Spider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.7);
            spider.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(70.0);
            spider.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).setBaseValue(0.001);

            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1170.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1170.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 90.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Hunter Spider");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return spider;
        }
    },

    DISGRUNTLED_LUMBERJACK(new Items[]{Items.ENCHANTED_EMERALD, Items.ENCHANTED_SPRUCE_WOOD, Items.LUMBERJACKS_AXE}, new float[]{.06f, .15f, .04f}, new int[]{1, 3, 1}, 50.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Vindicator vindicator = location.getWorld().spawn(location, Vindicator.class);
            vindicator.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            ItemStack main = new ItemStack(Material.IRON_AXE, 1);
            vindicator.getEquipment().setItemInMainHand(main);
            vindicator.getEquipment().setItemInMainHandDropChance(0f);

            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1200.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1200.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 110.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 50.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Disgruntled Lumberjack");
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            vindicator.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            vindicator.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return vindicator;
        }
    },

    ARCHER_ELITE(new Items[]{Items.ENCHANTED_BONE, Items.SHORTBOW_CORD, Items.ENCHANTED_FLINT, Items.ELITES_SHIV}, new float[]{.24f, .1f, .3f, .08f}, new int[]{2, 1, 3, 1}, 60.0, 8) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWViYzUwOGU5NTA5ODEzMDA3YWFjYTBhMzQ5Y2RkYmZmMTYzNDhjMmQzOWFjZWU5ZjI0M2UxNDkwNTc4YzkxMCJ9fX0=");
            ItemStack main = new ItemStack(Material.BOW);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setChestplateDropChance(0f);
            skeleton.getEquipment().setLeggingsDropChance(0f);
            skeleton.getEquipment().setBootsDropChance(0f);
            skeleton.getEquipment().setItemInMainHandDropChance(0f);

            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1460.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1460.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 120.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Archer Elite");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"),
                    PersistentDataType.INTEGER, 1);

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (skeleton.isDead()) {
                        this.cancel();
                        return;
                    }
                    if (skeleton.getTarget() != null) {
                        if (skeleton.getTarget().getLocation().distance(skeleton.getLocation()) > 3 &&
                            skeleton.getEquipment().getItemInMainHand().getType() != Material.BOW) {
                            skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
                        }
                        if (skeleton.getTarget().getLocation().distance(skeleton.getLocation()) < 3) {
                            skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                        }
                    }
                }
            }.runTaskTimer(plugin, 10, 15);

            return skeleton;
        }
    },

    SPIDER_QUEEN(new Items[]{Items.ENCHANTED_STRING, Items.WEBSLINGER_SHORTBOW, Items.ENCHANTED_SPIDER_EYE, Items.MONSTER_MEAT, Items.POWDERED_FUZZ}, new float[]{.15f, .06f, .11f, .35f, .075f}, new int[]{1, 1, 1, 1, 1}, 65.0, 5) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Spider spider = location.getWorld().spawn(location, Spider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(spider.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * .85);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 2240.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 2240.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 140.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Spider Queen");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            spider.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return spider;
        }
    },

    ZOMBIE_KNIGHT(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_POTATO, Items.ENCHANTED_IRON, Items.DARK_IRON_CORE}, new float[]{.2f, .11f, .08f, .05f}, new int[]{3, 1, 1, 1}, 100.0, 35) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjkzNDAzMDFhNjAxZjc0OTJhNjEwYzEwOWM0NTBjNDhhNDFjZjVlZTUwNTNmNWFiNzIxZTYxMmFiYTg0YWIyNiJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
            ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
            ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
            ItemStack main = new ItemStack(Material.NETHERITE_SWORD);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHand(main);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1460.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1460.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 200.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 240.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Zombie Knight");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    STONEHILL_GIANT(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_COBBLESTONE, Items.GIANTS_HEART}, new float[]{.4f, 1f, .075f}, new int[]{9, 16, 1}, 100.0, 5) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Giant giant = location.getWorld().spawn(location, Giant.class);
            giant.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));
            Husk pilot = location.getWorld().spawn(location, Husk.class);
            pilot.setInvisible(true);
            pilot.setInvulnerable(true);
            pilot.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(100);
            pilot.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, "GIANT_PILOT");

            giant.addPassenger(pilot);
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 24800.0);
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 24800.0);
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 80.0);
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, -600.0);
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Stonehill Giant");
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            giant.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = giant.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = giant.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = giant.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            giant.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (giant.isDead()) {
                        pilot.remove();
                        this.cancel();
                        return;
                    }

                    List<Entity> entities = giant.getNearbyEntities(2, 6,2);
                    for (int i = 0; i < entities.size(); i++) {
                        if (entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) != null &&
                            entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                    PersistentDataType.STRING).equals("adventurer")) {
                            giant.attack(entities.get(i));
                        }
                    }
                }
            }.runTaskTimer(plugin, 10, 10);

            return giant;
        }
    },

    CRAZED_GOAT(new Items[]{Items.ENCHANTED_MUTTON, Items.ENCHANTED_WOOL, Items.MOUNTAIN_GOAT_BOOTS}, new float[]{.12f, .24f, .06f}, new int[]{2, 3, 1}, 90.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Goat goat = location.getWorld().spawn(location, Goat.class);
            goat.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));
            goat.setScreaming(true);
            goat.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).setBaseValue(goat.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).getBaseValue() * 2.5);
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1850.0);
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1850.0);
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 460.0);
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 60.0);
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Crazed Goat");
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            goat.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = goat.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = goat.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = goat.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            goat.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (goat.isDead()) {
                        this.cancel();
                        return;
                    }
                    List<Entity> entities = goat.getNearbyEntities(goat.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getBaseValue(), goat.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getBaseValue(), goat.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getBaseValue());
                    for (int i = 0; i < entities.size(); i++) {
                        if (entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) != null &&
                            entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                    PersistentDataType.STRING).equals("adventurer")) {
                            goat.setTarget((LivingEntity)entities.get(i));
                            goat.setMemory(MemoryKey.RAM_COOLDOWN_TICKS, 0);
                        }
                    }
                }
            }.runTaskTimer(plugin, 20, 90);

            return goat;
        }
    },

    DEEP_MOUNTAIN_BURROWER(new Items[]{Items.SILVERFISH_SCALE, Items.ENCHANTED_DEEPSLATE_TILES, Items.SUPERSTONE_POWDER}, new float[]{.09f, .13f, .075f}, new int[]{2, 4, 1}, 90.0, 14) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Silverfish silverfish = location.getWorld().spawn(location, Silverfish.class);
            silverfish.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(silverfish.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.4);

            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 580.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 580.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 210.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 410.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Deep Mountain Burrower");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            silverfish.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            silverfish.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return silverfish;
        }
    },

    STONESHELL(new Items[]{Items.SUPERSTONE_POWDER, Items.CONCRETE_GAUNTLET, Items.BARREL_OF_ROCKS}, new float[]{.07f, .035f, .125f}, new int[]{1, 1, 1}, 115.0, 9) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Shulker shulker = location.getWorld().spawn(location, Shulker.class);
            shulker.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            shulker.setColor(DyeColor.GRAY);
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 2260.0);
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 2260.0);
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 305.0);
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 120.0);
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Stoneshell");
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            shulker.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = shulker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = shulker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = shulker.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            shulker.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return shulker;
        }
    },

    SNAPPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.SUPERSTONE_POWDER, Items.SEVERED_CREEPER_HEAD}, new float[]{.08f, .04f, .008f}, new int[]{2, 1, 1}, 100.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Creeper creeper = location.getWorld().spawn(location, Creeper.class);
            creeper.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            creeper.setMaxFuseTicks(20);
            creeper.setPowered(true);
            creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(creeper.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 0.8);

            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1120.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1120.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 1660.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Snapper");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            creeper.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return creeper;
        }
    },

    ALGAE_GOLEM(new Items[]{Items.ENCHANTED_IRON_BLOCK, Items.TITANIUM_PLATE, Items.RUSTY_COG, Items.ENCHANTED_KELP}, new float[]{.05f, .1f, .15f, .4f}, new int[]{1, 1, 1, 5}, 90.0, 12) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            IronGolem golem = location.getWorld().spawn(location, IronGolem.class);
            golem.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            golem.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).setBaseValue(0.1);

            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 2750.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 2750.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 270.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.6);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Algae Golem");
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            golem.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(golem, plugin, true);

            return golem;
        }
    },

    PEAT_MOSS_CREATURE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_GUNPOWDER, Items.COMPACTED_PEAT_MOSS}, new float[]{.1f, .075f, .04f}, new int[]{3, 2, 1}, 95.0, 30) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            zombie.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(70);
            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFjNzNkM2U4MmI2MTc2MWY5NDE1ZTNjNjljNDQxMzE4MjFjODk2MzQ3OTY0NmJhYWFhZmQ2YTA2ODIzZDYyIn19fQ==");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(33, 92, 48));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(18, 41, 23));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(18, 41, 23));
            boots.setItemMeta(bootMeta);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.LILY_PAD));
            zombie.getEquipment().setChestplateDropChance(0f);
            zombie.getEquipment().setLeggingsDropChance(0f);
            zombie.getEquipment().setBootsDropChance(0f);
            zombie.getEquipment().setItemInMainHandDropChance(0f);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 2400.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 2400.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 210.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.7);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Peat Moss Creature");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (zombie.isDead()) {
                        this.cancel();
                        return;
                    }

                    StatFunctions.staticHeal(plugin, zombie, 60);
                    if (zombie.getTarget() != null &&
                        zombie.getTarget().getLocation().distance(zombie.getLocation()) > 10) {
                        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                                30, 2));
                        zombie.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                                30, 7));
                    }
                }
            }.runTaskTimer(plugin, 0, 30);

            return zombie;
        }
    },

        CORRUPTED_MOSQUITO(new Items[]{Items.PULSING_TUMOR, Items.VILE_BLOOD, Items.ENCHANTED_INK_SAC}, new float[]{.2f, .035f, .35f}, new int[]{1, 1, 3}, 90.0, 10) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Phantom phantom = location.getWorld().spawn(location, Phantom.class);
            phantom.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    999999999, 4, true, false));

            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1440.0);
            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1440.0);
            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 330.0);
            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Corrupted Mosquito");
            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            phantom.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = phantom.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = phantom.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = phantom.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            phantom.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(phantom, plugin, true);

            return phantom;
        }
    },

    VILE_LEACH(new Items[]{Items.PULSING_TUMOR, Items.VILE_BLOOD, Items.ENCHANTED_SLIMEBALL}, new float[]{.08f, .05f, .125f}, new int[]{1, 1, 1}, 90.0, 15) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Endermite mite = location.getWorld().spawn(location, Endermite.class);
            mite.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            mite.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,
                    9999999, 0, true, false));

            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 660.0);
            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 660.0);
            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 140.0);
            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Vile Leach");
            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            mite.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = mite.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = mite.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = mite.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            mite.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            new BukkitRunnable() {
                public void run()
                {
                    if (mite.isDead()) {
                        this.cancel();
                        return;
                    }
                    StatFunctions.staticHeal(plugin, mite, 25);
                    StatFunctions.staticUpdateHealth(mite, plugin);
                }
            }.runTaskTimer(plugin, 10, 20);

            return mite;
        }
    },

    VOLATILE_SLIME(new Items[]{}, new float[]{}, new int[]{}, 20.0, 13) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {

            Slime slime = location.getWorld().spawn(location, Slime.class);
            slime.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            slime.setSize(2);

            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 2240.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 2240.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 320.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Volatile Slime");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            slime.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            slime.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return slime;
        }
    },

    FROST_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BONE, Items.ENCHANTED_POTATO, Items.ENCHANTED_CARROT}, new float[]{.12f, .07f, .04f, .04f}, new int[]{1, 1, 1, 1}, 8.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            //Equip the zombie
            Random ran = new Random();
            int choice = ran.nextInt(13) + 1;

            ItemStack helmet = new ItemStack(Material.ICE, 1);
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(184,175,94));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
            legMeta.setColor(Color.fromBGR(184,175,94));
            leggings.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(184,175,94));
            boots.setItemMeta(bootMeta);

            if (choice <= 3) {
                ItemStack item = new ItemStack(Material.ROTTEN_FLESH);
                zombie.getEquipment().setItemInMainHand(item);
            }
            if (choice > 3 && choice <= 6) {
                ItemStack item = new ItemStack(Material.DEAD_BUSH);
                zombie.getEquipment().setItemInMainHand(item);
            }
            if (choice > 6 && choice <= 9) {
                ItemStack item = new ItemStack(Material.WOODEN_SWORD);
                zombie.getEquipment().setItemInMainHand(item);
            }
            if (choice > 9 && choice <= 12) {
                ItemStack item = new ItemStack(Material.COBWEB);
                zombie.getEquipment().setItemInMainHand(item);
            }
            if (choice == 13) {
                ItemStack item = new ItemStack(Material.DEAD_HORN_CORAL);
                zombie.getEquipment().setItemInMainHand(item);
            }

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);

            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 460.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 460.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 80.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.2);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Frozen Undead");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    BABY_GHAST(new Items[]{Items.ENCHANTED_GHAST_TEAR, Items.ENCHANTED_GUNPOWDER}, new float[]{.04f, .06f}, new int[]{1, 3}, 300.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Vex vex = location.getWorld().spawn(location, Vex.class);
            vex.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));
            vex.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                    9999999, 0, true, false));
            vex.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,
                    9999999, 10, true, false));
            vex.setSilent(true);

            ItemStack head1 = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E4YjcxNGQzMmQ3ZjZjZjhiMzdlMjIxYjc1OGI5YzU5OWZmNzY2NjdjN2NkNDViYmM0OWM1ZWYxOTg1ODY0NiJ9fX0=");

            ItemStack air = new ItemStack(Material.AIR, 1);

            vex.getEquipment().setItemInMainHand(air);
            vex.getEquipment().setHelmet(head1);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1300.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1300.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 2.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Baby Ghast");
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            vex.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            vex.setCustomNameVisible(true);

            return vex;

//remember to add fireball function
        }
    },

    BERZERK_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH}, new float[]{.06f}, new int[]{1}, 13.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTE1OTE1YWY0ZWU0NGJlNTE4NzNmMDEwNWRhNmNjZjYwMTgyMmMxNjhiYTcxYmY1OTk3MmRhMDI0NTkwYTNjIn19fQ==");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            bootMeta.setColor(Color.fromBGR(18, 17, 21));
            chestplate.setItemMeta(bootMeta);
            ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
            ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);


            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 900.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 900.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 45.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.2);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Raging Zombie");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },

    POTION_ARCHER(new Items[]{Items.ENCHANTED_BONE, Items.RIVER_CLAY, Items.ENCHANTED_GLOWSTONE_DUST, Items.ENCHANTED_GLOW_SAC}, new float[]{.05f, .08f, .04f, .04f}, new int[]{1, 1, 1, 1}, 10.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
            helmetMeta.setColor(Color.fromBGR(128,28,135));
            helmet.setItemMeta(helmetMeta);
            ItemStack main = new ItemStack(Material.BOW);
            ItemMeta meta = main.getItemMeta();
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            main.setItemMeta(meta);

            ItemStack off = new ItemStack(Material.SPLASH_POTION);
            PotionMeta potionMeta = (PotionMeta) off.getItemMeta();
            potionMeta.setColor(Color.fromBGR(91, 19, 107));
            off.setItemMeta(potionMeta);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setItemInMainHand(main);
            skeleton.getEquipment().setItemInOffHand(off);


            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 720.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 720.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 165.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.6);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Potion Archer");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"),
                    PersistentDataType.INTEGER, 1);

            String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return skeleton;
        }
    },

    MINER_ZOMBIE(new Items[]{Items.ENCHANTED_IRON, Items.ENCHANTED_GOLD,Items.ENCHANTED_LAPIS, Items.ENCHANTED_REDSTONE, Items.ENCHANTED_DIAMOND, Items.SUPER_PICK}, new float[]{.055f, .04f, .025f, .025f, .008f, .0065f}, new int[]{1, 1, 1, 1, 1, 1}, 48.0, 0) {
        @Override
        public LivingEntity createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the zombie
            ItemStack helmet = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE5MzdiY2Q1YmVlYWEzNDI0NDkxM2YyNzc1MDVlMjlkMmU2ZmIzNWYyZTIzY2E0YWZhMmI2NzY4ZTM5OGQ3MyJ9fX0=");
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(27, 36, 38));
            chestplate.setItemMeta(chestMeta);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            LeatherArmorMeta legMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            chestMeta.setColor(Color.fromBGR(27, 36, 38));
            chestplate.setItemMeta(legMeta);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
            bootMeta.setColor(Color.fromBGR(27, 36, 38));
            boots.setItemMeta(bootMeta);

            ItemStack main = new ItemStack(Material.IRON_PICKAXE);

            zombie.getEquipment().setHelmet(helmet);
            zombie.getEquipment().setChestplate(chestplate);
            zombie.getEquipment().setLeggings(leggings);
            zombie.getEquipment().setBoots(boots);
            zombie.getEquipment().setItemInMainHand(main);


            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1700.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1700.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 230.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 150.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 1.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Undead Miner");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            return zombie;
        }
    },
    ;

    public abstract LivingEntity createMob(Plugin plugin, Location location);
    
    Mobs(Items[] item, float[] chance, int[] amount, double xp, int weight) {
        this.item = item;
        this.chance = chance;
        this.amount = amount;
        this.xp = xp;
        this.weight = weight;

    }

    public final Items[] item;
    public final float[] chance;
    public final int[] amount;
    public final double xp;
    public final int weight;

}
