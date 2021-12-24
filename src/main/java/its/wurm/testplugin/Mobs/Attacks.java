package its.wurm.testplugin.Mobs;

import its.wurm.testplugin.Main;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

public class Attacks implements Listener {
    static Main plugin;

    public Attacks(Main plugin) { this.plugin = plugin;}

    public static void createDamageIndicator(Location location, Boolean isCrit, Double damage) {
        ArmorStand stand = location.getWorld().spawn(location, ArmorStand.class);

        stand.setGravity(false);
        stand.setVisible(false);
        stand.setInvulnerable(true);
        stand.setSmall(true);
        if (isCrit == true) {
            stand.setCustomName("§6" + damage);
        }
        if (isCrit == false) {
            stand.setCustomName("§7" + damage);
        }

        stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 8);

        stand.setCustomNameVisible(true);
        stand.hasEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.ADDING);
        stand.hasEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.ADDING);
        stand.hasEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.ADDING);
        stand.hasEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.ADDING);

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                stand.remove();
            }
        }, 8);
    }

    public static void createTnt(Location location, Double damage, int fuse, Entity source, org.bukkit.util.Vector velocity) {
        TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);
        tnt.setFuseTicks(fuse);
        tnt.setSource(source);
        tnt.setVelocity(velocity);
        tnt.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        tnt.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        tnt.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
    }

    public static void createPuffer(Location location, Double damage, Entity source, org.bukkit.util.Vector velocity) {
        PufferFish pufferFish = location.getWorld().spawn(location, PufferFish.class);
        pufferFish.setInvulnerable(true);
        pufferFish.setVelocity(velocity);
        pufferFish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        pufferFish.setPuffState(0);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                pufferFish.setPuffState(2);
            }
        }, 1L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                pufferFish.remove();
            }
        }, 80L);
    }

    public static void createLightning(Location location, Double damage) {
        LightningStrike lightning = location.getWorld().spawn(location, LightningStrike.class);
        lightning.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
    }

    public static void createArrow(Location location, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, Integer id, Integer pierce) {
        Arrow arrow = location.getWorld().spawn(location, Arrow.class);
        arrow.setShooter(source);
        arrow.setVelocity(velocity);
        arrow.setPierceLevel(pierce);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, id);
    }

    public static void createItem(Location location, int time, Material type, boolean pick) {
        Item item = location.getWorld().spawn(location, Item.class);
        ItemStack itemStack = new ItemStack(type, 1);
        if (pick == true) {
            item.setPickupDelay(32000);
        }
        item.setItemStack(itemStack);
        item.setTicksLived(time);
        item.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        item.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
    }

    public static void createSummon(Location location, int lifeTicks, AnimalTamer owner, LivingEntity type, double damage, double health, double defense, String name) {
        Wolf wolf = location.getWorld().spawn(location, Wolf.class);
        wolf.setAge(-666);
        wolf.setAgeLock(true);
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                9999999, 0, true, false));
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                9999999, 5, true, false));
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                9999999, 1, true, false));
        wolf.setOwner(owner);
        wolf.setSilent(true);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE, health);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, health);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, defense);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, name);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER, 13);

        type.setInvulnerable(true);
        type.setAI(false);

        type.setCustomName(ChatColor.GOLD + "" + wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) + "/" + wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE));

        wolf.addPassenger(type);

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                wolf.remove();
                type.remove();
            }
        }, lifeTicks);
    }
}
