package its.wurm.testplugin.Mobs;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Main;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.Potion;
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

    public static void createTnt(Location location, Double damage, int fuse, Entity source, int blast) {
        TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);
        tnt.setFuseTicks(fuse);
        tnt.setSource(source);
    }
}
