package its.wurm.testplugin.Mobs;

import com.sun.javafx.tk.Toolkit;
import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mobs implements Listener {

    static Main plugin;

    public Mobs(Main plugin) { this.plugin = plugin;}


    public static void createDummy(Location location) {
        Zombie zombie = location.getWorld().spawn(location, Zombie.class);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                9999999, 5, true, false));

        zombie.setAI(false);

        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE, 1000000000.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 1000000000.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Dummy");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 0);

        String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
    }

    public static void createChillZombie(Location location) {
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
                PersistentDataType.DOUBLE, 180.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 180.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, 30.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, -0.2);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Frozen Undead");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 1);

        String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
    }

    public static void createFencerZombie(Location location) {
        Zombie zombie = location.getWorld().spawn(location, Zombie.class);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                9999999, 5, true, false));

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
                PersistentDataType.DOUBLE, 250.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 250.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, 50.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Fencer Zombie");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 2);

        String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
    }

    public static void createArmoredZombie(Location location) {
        Zombie zombie = location.getWorld().spawn(location, Zombie.class);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                9999999, 5, true, false));

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
                PersistentDataType.DOUBLE, 230.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 230.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, 25.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 80.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Armored Zombie");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 3);

        String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
    }

    public static void createGrowth(Location location) {
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
                PersistentDataType.DOUBLE, 0.0);
        attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Growth");
        attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Summon");
        attack.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 4);

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
                    Mobs.createRegenZombie(attack.getLocation());
                }
                attack.remove();
            }
        }, 70);
    }

    public static void createRegenZombie(Location location) {
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
                PersistentDataType.DOUBLE, 70.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 70.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, 25.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Relentless Corpse");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 5);

        String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
    }

    public static void createSmolGhast(Location location) {
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
                PersistentDataType.DOUBLE, 2300.0);
        vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 2300.0);
        vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 0.0);
        vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 2.0);
        vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Baby Ghast");
        vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        vex.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 6);

        String Name = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = vex.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        vex.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
        vex.setCustomNameVisible(true);

        Mobs.runProjectile(vex);
    }

    public static void runProjectile(LivingEntity entity) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                entity.launchProjectile(SmallFireball.class, entity.getLocation().getDirection());
                entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_GHAST_WARN, 200, 2);
                if (!entity.isDead()) {
                    Mobs.runProjectile(entity);
                }

            }
        }, 80L);
    }

    public static void createRageZombie(Location location) {
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
                PersistentDataType.DOUBLE, 400.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 400.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, 35.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, -10.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 0.0);
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Raging Zombie");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        zombie.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 7);

        String Name = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = zombie.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        zombie.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
    }

    public static void createNoviceSkele(Location location) {
        Skeleton skeleton = location.getWorld().spawn(location, Skeleton.class);
        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                9999999, 5, true, false));

        //Equip the skeleton
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemStack main = new ItemStack(Material.BOW);

        skeleton.getEquipment().setHelmet(helmet);
        skeleton.getEquipment().setItemInMainHand(main);


        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE, 130.0);
        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 130.0);
        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, 30.0);
        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 0.0);
        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 0.0);
        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Novice Skeleton");
        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "Class"),
                PersistentDataType.STRING, "Mob");
        skeleton.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 8);

        String Name = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = skeleton.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        skeleton.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);
    }
}
