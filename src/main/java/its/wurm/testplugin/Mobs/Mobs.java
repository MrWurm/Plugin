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
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    NOVICE_SKELETON(new Items[]{Items.ENCHANTED_BONE}, new float[]{0.1f}, new int[]{1}, 10.0, 13) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            //Equip the skeleton
            ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
            ItemStack main = new ItemStack(Material.BOW);

            skeleton.getEquipment().setHelmet(helmet);
            skeleton.getEquipment().setItemInMainHand(main);


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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    FENCER_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.IRON_SCIMITAR}, new float[]{.07f, .02f}, new int[]{1, 1}, 15.0, 18) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    RENEGADE_PILLAGER(new Items[]{Items.ENCHANTED_EMERALD, Items.RENEGADE_CROSSBOW}, new float[]{.02f, .01f}, new int[]{1, 1}, 12.0, 8) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Pillager pillager = location.getWorld().spawn(location, Pillager.class);
            pillager.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));


            ItemStack main = new ItemStack(Material.CROSSBOW, 1);
            pillager.getEquipment().setItemInMainHand(main);


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
            Double Health = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            pillager.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    MARAUDING_VINDICATOR(new Items[]{Items.ENCHANTED_EMERALD, Items.ENCHANTED_IRON, Items.MARAUDER_AXE}, new float[]{.02f, .05f, .01f}, new int[]{1, 1, 1}, 18.0, 6) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Vindicator vindicator = location.getWorld().spawn(location, Vindicator.class);
            vindicator.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));


            ItemStack main = new ItemStack(Material.IRON_AXE, 1);
            vindicator.getEquipment().setItemInMainHand(main);


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
            Double Health = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = vindicator.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            vindicator.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    SKELETON_GRUNT(new Items[]{Items.ENCHANTED_BONE, Items.HAIR_TRIGGER}, new float[]{.1f, .04f}, new int[]{1, 1}, 16.0, 6) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    CREEPLING(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.SEVERED_CREEPER_HEAD}, new float[]{.04f, .005f}, new int[]{1, 1}, 22.0, 9) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    WOLF_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.MONSTER_MEAT}, new float[]{.08f, .025f, 0.16f}, new int[]{1, 1, 1}, 25.0, 7) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    BEEKEEPER(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.BEEKEEPER_HAT, Items.BEEKEEPER_VEST, Items.BEEKEEPER_PANTS, Items.BEEKEEPER_BOOTS}, new float[]{.07f, .05f, .05f, .05f, .05f}, new int[]{1, 1, 1, 1, 1}, 16.0, 15) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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
        }
    },

    ANGRY_BEE(new Items[]{}, new float[]{}, new int[]{}, 1.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            bee.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            StatFunctions.mobTargetPlayer(bee, plugin, true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    bee.remove();
                }
            }, 600);
        }
    },

    SWARM_MARKER(new Items[]{Items.STINGER}, new float[]{0.02f}, new int[]{1}, 0.0, 10) {
        @Override
        public void createMob(Plugin plugin, Location location) {

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
        }
    },

    BEE_SWARMER(new Items[]{Items.STINGER, Items.SWARMER_HEAD}, new float[]{0.02f, 0.01f}, new int[]{1, 1}, 5.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {

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
            Double Health = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            bee.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            StatFunctions.mobTargetPlayer(bee, plugin, true);
        }
    },

    HONEY_SLIME(new Items[]{Items.ENCHANTED_SLIMEBALL, Items.LIVING_HONEY}, new float[]{0.075f, 0.01f}, new int[]{1, 1}, 15.0, 8) {
        @Override
        public void createMob(Plugin plugin, Location location) {

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
            Double Health = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = slime.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            slime.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            StatFunctions.mobTargetPlayer(slime, plugin, true);
        }
    },

    SWARM_ARCHER(new Items[]{Items.ENCHANTED_BONE, Items.SWARMER_HEAD}, new float[]{.08f, .04f}, new int[]{1, 1}, 18.0, 10) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    HONEYPOT_CREEPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.ENCHANTED_SUGAR, Items.SEVERED_CREEPER_HEAD}, new float[]{.04f, .01f, .005f}, new int[]{1, 1, 1}, 18.0, 6) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    ROTTING_FISHERMAN(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_COD, Items.ENCHANTED_SALMON, Items.ENCHANTED_PUFFERFISH, Items.ENCHANTED_CLOWNFISH}, new float[]{.05f, .035f, .02f, .01f, .0075f}, new int[]{1, 1, 1, 1, 1}, 16.0, 14) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    AQUATIC_ISOPOD(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_COD, Items.SILVERFISH_SCALE}, new float[]{.04f, .025f, .01f}, new int[]{1, 1, 1}, 14.0, 14) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            silverfish.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    SEA_SKELETON(new Items[]{Items.ENCHANTED_BONE, Items.ENCHANTED_KELP}, new float[]{.05f, .012f}, new int[]{1, 1}, 16.0, 9) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    RUSTY_GOLEM(new Items[]{Items.ENCHANTED_COPPER, Items.RUSTY_COG}, new float[]{.08f, .035f}, new int[]{1, 1}, 18.0, 5) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            golem.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(golem, plugin, true);
        }
    },

    ARMOR_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_IRON, Items.ALLOY}, new float[]{.05f, .06f, .01f}, new int[]{1, 1, 1}, 20.0, 20) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    ZOMBIE_CRUSADER(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.HOLY_SHIELD}, new float[]{.08f, .02f}, new int[]{1, 1}, 25.0, 16) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    HUNTER(new Items[]{Items.ENCHANTED_EMERALD, Items.MONSTER_MEAT, Items.HIDE, Items.HUNTER_CAP}, new float[]{.04f, .11f, .08f, .02f}, new int[]{1, 1, 1, 1}, 32.0, 12) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = pillager.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            pillager.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    FOREST_SPIRIT(new Items[]{Items.ENCHANTED_OAK_WOOD, Items.ENCHANTED_BIRCH_WOOD, Items.FOREST_ESSENCE}, new float[]{.09f, .09f, .035f}, new int[]{2, 2, 1}, 25.0, 8) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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


            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 400.0);
            vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 400.0);
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
            Double Health = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            vex.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    WOOD_MITE(new Items[]{Items.ENCHANTED_OAK_WOOD, Items.SILVERFISH_SCALE}, new float[]{.05f, .04f}, new int[]{3, 1}, 28.0, 12) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = silverfish.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            silverfish.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    HOST(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.SILVERFISH_SCALE}, new float[]{.08f, .12f}, new int[]{1, 1}, 25.0, 25) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    FLESH_MAGGOT(new Items[]{}, new float[]{}, new int[]{}, 0.1, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            attack.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attack.remove();
                }
            }, 1200);
        }
    },

    LEAFY_CREEPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.BUSH_SUIT, Items.SEVERED_CREEPER_HEAD}, new float[]{.09f, .05f, .035f}, new int[]{3, 1, 1}, 45.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            creeper.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

        }
    },

    SCOUT(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.HARDWOOD_HANDLE, Items.ENCHANTED_SWEET_BERRIES}, new float[]{.1f, .02f, .06f}, new int[]{1, 1, 1}, 25.0, 12) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    CARNIVOROUS_CONEY(new Items[]{Items.HIDE, Items.ENCHANTED_RABBIT, Items.ENCHANTED_CARROT, Items.LUCKY_FOOT}, new float[]{.12f, .08f, .1f, .04f}, new int[]{1, 1, 1, 1}, 35.0, 6) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = rabbit.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = rabbit.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            rabbit.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    RELENTLESS(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BONE, Items.DEATH_CHARM}, new float[]{.075f, .03f, .04f, .008f}, new int[]{3, 1, 1, 1}, 55.0, 21) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    SANDY_SKELETON(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_BONE, Items.CLUMPED_SAND}, new float[]{.08f, .05f, .04f}, new int[]{3, 3, 1}, 50.0, 16) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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


            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 930.0);
            skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 930.0);
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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    ANTLION(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_ROTTEN_FLESH, Items.CLUMPED_SAND, Items.SCOURGE}, new float[]{.2f, .1f, .03f, .015f}, new int[]{3, 1, 1, 1}, 45.0, 7) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            zombie.setAdult();
            ItemStack air = new ItemStack(Material.AIR);
            zombie.getEquipment().setItemInMainHand(air);
            zombie.getEquipment().setHelmet(air);
            zombie.getEquipment().setItemInMainHand(air);
            zombie.getEquipment().setItemInMainHand(air);
            zombie.getEquipment().setItemInMainHand(air);

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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

        }
    },

    BANDIT_ARCHER(new Items[]{Items.ENCHANTED_BONE, Items.ENCHANTED_GOLD, Items.ENCHANTED_LAPIS, Items.ENCHANTED_EMERALD}, new float[]{.08f, .05f, .04f, .025f}, new int[]{1, 1, 1, 1}, 45.0, 20) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    ANCIENT_PHARAOH(new Items[]{Items.ENCHANTED_GOLD, Items.GOLDEN_SKULL, Items.ENCHANTED_BONE, Items.ONYX}, new float[]{.05f, .02f, .1f, .08f}, new int[]{2, 1, 1, 3}, 80.0, 10) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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
        }
    },

    SAND_WITCH(new Items[]{Items.ENCHANTED_SAND, Items.ENCHANTED_COMPACTED_SAND,Items.SAND_WAND}, new float[]{0.15f, 0.02f, 0.03f}, new int[]{3, 3, 1}, 56.0, 15) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = witch.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = witch.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            witch.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    CACTUS_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_CACTUS, Items.CACTUS_LEATHER}, new float[]{.12f, .2f, .03f}, new int[]{1, 1, 1}, 55.0, 30) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    CAMEL_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_COMPACTED_SAND, Items.SCOURGE}, new float[]{.15f, .1f, .06f}, new int[]{1, 1, 1}, 60.0, 12) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            spider.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    BURROWING_CREEPER(new Items[]{Items.ENCHANTED_GUNPOWDER, Items.SEVERED_CREEPER_HEAD, Items.CLUMPED_SAND, Items.ENCHANTED_COMPACTED_SAND}, new float[]{.05f, .01f, .04f, .24f}, new int[]{1, 1, 1, 3}, 55.0, 15) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = creeper.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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
        }
    },

    WANDERING_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.VENOMOUS_FANG}, new float[]{.2f, .08f, .04f}, new int[]{1, 1, 1}, 55.0, 25) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Spider spider = location.getWorld().spawn(location, Spider.class);
            spider.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));


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
            Double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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
        }
    },

    WEAVER_SPIDER(new Items[]{Items.ENCHANTED_STRING, Items.ENCHANTED_SPIDER_EYE, Items.ENCHANTED_WEB}, new float[]{.24f, .08f, .035f}, new int[]{1, 1, 1}, 50.0, 21) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = spider.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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
        }
    },

    ANGUISHED_SPIRIT(new Items[]{Items.ENCHANTED_ACACIA_WOOD, Items.ENCHANTED_REDSTONE, Items.FRAGMENTED_SOUL_REMNANTS}, new float[]{.15f, .04f, .065f}, new int[]{1, 1, 1}, 55.0, 21) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Husk zombie = location.getWorld().spawn(location, Husk.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));

            Scoreboard manager = Bukkit.getScoreboardManager().getMainScoreboard();
            manager.getTeam("dark_blue").addEntry(zombie.getUniqueId().toString());

            //Equip the zombie
            ItemStack air = new ItemStack(Material.AIR);
            zombie.getEquipment().setHelmet(air);
            zombie.getEquipment().setChestplate(air);
            zombie.getEquipment().setLeggings(air);
            zombie.getEquipment().setBoots(air);
            zombie.getEquipment().setItemInMainHand(air);


            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 210.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 210.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 125.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE, 0.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING, "Anguished Spirit");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING, "mob");
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING, this.name());

            String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                    PersistentDataType.STRING);
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    FROST_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.ENCHANTED_BONE, Items.ENCHANTED_POTATO, Items.ENCHANTED_CARROT}, new float[]{.05f, .01f, .04f, .04f}, new int[]{1, 1, 1, 1}, 8.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    REGEN_ZOMBIE(new Items[]{}, new float[]{}, new int[]{}, 0.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Zombie zombie = location.getWorld().spawn(location, Zombie.class);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

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


            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 180.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 180.0);
            zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 60.0);
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    GROWTH(new Items[]{Items.ENCHANTED_ROTTEN_FLESH, Items.PULSING_TUMOR}, new float[]{0.08f, 0.04f}, new int[]{3, 2}, 7.5, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Endermite attack = location.getWorld().spawn(location, Endermite.class);
            attack.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

            attack.setAI(false);

            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 40.0);
            attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 40.0);
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
            Double Health = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = attack.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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
        }
    },

    BABY_GHAST(new Items[]{Items.ENCHANTED_GHAST_TEAR, Items.ENCHANTED_GUNPOWDER}, new float[]{0.04f, 0.06f}, new int[]{1, 3}, 300.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            vex.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
            vex.setCustomNameVisible(true);

//remember to add fireball function
        }
    },

    BERZERK_ZOMBIE(new Items[]{Items.ENCHANTED_ROTTEN_FLESH}, new float[]{0.06f}, new int[]{1}, 13.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    POTION_ARCHER(new Items[]{Items.ENCHANTED_BONE, Items.RIVER_CLAY, Items.ENCHANTED_GLOWSTONE_DUST, Items.ENCHANTED_GLOW_SAC}, new float[]{0.05f, 0.08f, 0.04f, 0.04f}, new int[]{1, 1, 1, 1}, 10.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));

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
            Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    LOST_GOLEM(new Items[]{Items.ENCHANTED_IRON, Items.ALLOY}, new float[]{0.12f, 0.06f}, new int[]{1, 1}, 36.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            IronGolem golem = location.getWorld().spawn(location, IronGolem.class);
            golem.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));


            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1080.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1080.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 240.0);
            golem.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, 80.0);
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
            Double Health = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = golem.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            golem.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(golem, plugin, true);
        }
    },

    DIRE_WOLF_ALPHA(new Items[]{Items.HIDE, Items.MONSTER_MEAT, Items.RAZOR_CLAW, Items.WOLF_FANG}, new float[]{0.15f, 1f, 0.08f, 0.1f}, new int[]{1, 5, 1, 3}, 25.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));


            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 990.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 990.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 120.0);
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
            Double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(wolf, plugin, true);

            Random random = new Random();
            int choice = random.nextInt(4) + 1;
            for (int i = 0; i < choice; i ++) {
                Mobs.DIRE_WOLF.createMob(plugin, location);
            }
            choice = random.nextInt(2);
            for (int i = 0; i < choice; i ++) {
                Mobs.DIRE_WOLF_PUP.createMob(plugin, location);
            }
        }
    },

    DIRE_WOLF(new Items[]{Items.HIDE, Items.MONSTER_MEAT, Items.WOLF_FANG}, new float[]{0.05f, 1f, 0.08f}, new int[]{1, 3, 1}, 18.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

        }
    },

    DIRE_WOLF_PUP(new Items[]{Items.MONSTER_MEAT}, new float[]{0.25f}, new int[]{1}, 5.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

        }
    },

    MINER_ZOMBIE(new Items[]{Items.ENCHANTED_IRON, Items.ENCHANTED_GOLD,Items.ENCHANTED_LAPIS, Items.ENCHANTED_REDSTONE, Items.ENCHANTED_DIAMOND, Items.SUPER_PICK}, new float[]{0.055f, 0.04f, 0.025f, 0.025f, 0.008f, 0.0065f}, new int[]{1, 1, 1, 1, 1, 1}, 48.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
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
            Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);
        }
    },

    TIMBER_WOLF(new Items[]{Items.HIDE, Items.MONSTER_MEAT, Items.WOLF_FANG, Items.SCRUB}, new float[]{0.09f, 1f, 0.15f, 0.2f}, new int[]{1, 5, 1, 1}, 40.0, 0) {
        @Override
        public void createMob(Plugin plugin, Location location) {
            Wolf wolf = location.getWorld().spawn(location, Wolf.class);
            wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    999999999, 5, true, false));


            wolf.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.5);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, 1280.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, 1280.0);
            wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 110.0);
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
            Double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE);
            Double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE);

            wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                    Health + "/" + MaxHealth);

            StatFunctions.mobTargetPlayer(wolf, plugin, true);
        }
    },
    ;

    public abstract void createMob(Plugin plugin, Location location);

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
