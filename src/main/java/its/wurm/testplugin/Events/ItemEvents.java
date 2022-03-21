package its.wurm.testplugin.Events;


import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.*;
import org.bukkit.block.Hopper;
import org.bukkit.block.Jukebox;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.Powerable;
import org.bukkit.block.data.type.*;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Chest;
import org.bukkit.block.data.type.EnderChest;
import org.bukkit.block.data.type.Furnace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;

import java.util.*;

public class ItemEvents implements Listener{

    Plugin plugin;

    public ItemEvents(Plugin plugin) {
        this.plugin = plugin;
        this.attacks = new Attacks(plugin);
        this.functions = new StatFunctions(plugin, attacks);
    }

    Attacks attacks;
    StatFunctions functions;

    Map<String, List<String>> items = new HashMap<>();

    Map<String, Long> cooldown_shortbow = new HashMap<>();
    Map<String, Long> cooldown_heal = new HashMap<>();
    Map<String, Long> cooldown_rift = new HashMap<>();
    Map<String, Long> cooldown_scan = new HashMap<>();
    Map<String, Long> cooldown_echo = new HashMap<>();
    Map<String, Long> cooldown_grapple = new HashMap<>();
    Map<String, Long> cooldown_stinger = new HashMap<>();
    Map<String, Long> cooldown_mite_wand = new HashMap<>();
    Map<String, Location> echo_ward = new HashMap<>();
    Map<String, Long> cooldown_forest = new HashMap<>();
    Random random = new Random();

    public void workBenchGUI(Player player) {
        player.openWorkbench(null, true);

    }

    public double magicScale(double base, double scale, Player player) {
        return (1 + (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) * scale)) * base;
    }
    public void warpWorld(Player player) {
            if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)) {
            player.sendMessage(ChatColor.RED + "You cannot fast travel while injured");
        }

        Location location = new Location(Bukkit.getWorld("world"), 0, 70, 0);
        if (player.getBedSpawnLocation() != null) {
            location = player.getBedSpawnLocation();
        }

        player.teleport(location);
        echo_ward.put(player.getName(), location);
    }

    public void warpNether(Player player) {
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)) {
            player.sendMessage(ChatColor.RED + "You cannot fast travel while injured");
        }

        Location location = new Location(Bukkit.getWorld("world_the_nether"), 0, 100, 0);

        player.teleport(location);
        echo_ward.put(player.getName(), location);
    }

    public void warpEnd(Player player) {
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)) {
            player.sendMessage(ChatColor.RED + "You cannot fast travel while injured");
        }

        Location location = new Location(Bukkit.getWorld("world_the_end"), 0.5, 65, 0.5);

        player.teleport(location);
        echo_ward.put(player.getName(), location);
    }

    public void tntWand(Player player) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double damage = 10;
        double cost = 50;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        damage = magicScale(damage, 0.02, player);
        attacks.createTnt(player.getEyeLocation(), damage, 70, player, player.getLocation().getDirection().multiply(2));
        player.sendMessage(ChatColor.GREEN + "Used Tnt Hurl");
    }

    public void rift(Player player) {

        if (cooldown_rift.containsKey(player.getName())) {
            if (cooldown_rift.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_rift.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }
        double cooldown = 15.0;

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double mod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) / 100 + 1;

        double magic = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) * 0.04) + 1) * 120;

        double cost = 120;

        List<Double> apply = functions.reforgeOnCast(player, plugin, magic, cooldown, cost);
        cooldown /= apply.get(2);
        cost *= apply.get(1);
        magic *= apply.get(0);

        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        int generation = (int) mod + 2;

        double health = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)/12) * mod;
        double defense = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE)/12) * mod;
        double damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        damage *= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/100;
        damage *= (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) + 1) * mod;
        Location location = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 3, player.getLocation().getZ());
        Marker marker = player.getLocation().getWorld().spawn(location, Marker.class);
        marker.getLocation().setDirection(player.getLocation().getDirection());
        attacks.trail(marker, Particle.SMOKE_NORMAL, 20);
        cooldown_rift.put(player.getName(), System.currentTimeMillis() + ((long)cooldown * 1000));

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);
        repeat(generation, damage, defense, health, magic, marker, player);
    }

    public void repeat(int generations, double damage, double defense, double health, double magic, Marker marker, Player player) {
        if (generations == 0) {
            marker.remove();
            return;
        }

        generations -= 1;
        int confusion = generations;

        Snowball snowball = attacks.createSnowball(marker.getLocation(), magic, player, marker.getLocation().getDirection().multiply(0.8), "", Material.CRYING_OBSIDIAN);
        attacks.trail(snowball, Particle.SMOKE_NORMAL, 3);
        attacks.track(snowball, player, 12.0, 0.8);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                Snowball snowball = attacks.createSnowball(marker.getLocation(), magic, player, marker.getLocation().getDirection().multiply(0.8), "", Material.CRYING_OBSIDIAN);
                attacks.trail(snowball, Particle.SMOKE_NORMAL, 3);
                attacks.track(snowball, player, 12.0, 0.8);
            }
        }, 5);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                Snowball snowball = attacks.createSnowball(marker.getLocation(), magic, player, marker.getLocation().getDirection().multiply(0.8), "", Material.CRYING_OBSIDIAN);
                attacks.trail(snowball, Particle.SMOKE_NORMAL, 3);
                attacks.track(snowball, player, 12.0, 0.8);
            }
        }, 10);

        Endermite summon = player.getLocation().getWorld().spawn(player.getLocation(), Endermite.class);
        attacks.createSummon(marker.getLocation(), 240, player, summon, damage, health, defense, "", "");

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                repeat(confusion, damage, defense, health, magic, marker, player);
            }
        }, 40);
    }

    public void blockHelmet (Player player, ItemStack item) {
        if (player.getInventory().getHelmet() != null) {
            return;
        }
        ItemStack copy = item.clone();
        copy.setAmount(1);
        player.getInventory().setHelmet(copy);
        item.setAmount(item.getAmount() - 1);
    }
    public void miteWand (Player player) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double cooldown = 10;
        double cost = 120;
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, cooldown, cost);
        cooldown /= apply.get(2);
        cost *= apply.get(1);
        if (cooldown_mite_wand.containsKey(player.getName())) {
            if (cooldown_mite_wand.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_mite_wand.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                return;
            }
        }

        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        mite(player, 10, 3, "Maggot", "MAGGOT");
        player.sendMessage(ChatColor.GREEN + "Used Swarm Summon");
        cooldown_mite_wand.put(player.getName(), System.currentTimeMillis() + ((long)cooldown * 1000));

    }

    public void mite(Player player, int power, int amount, String name, String id) {

        double mod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) / 100 + 1;

        double health = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)/power) * mod;
        double defense = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE)/power) * mod;
        double damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        damage *= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/100;
        damage *= (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) + 1) * mod;

        for (int i = 0; i < amount; i++) {
            Silverfish summon = player.getLocation().getWorld().spawn(player.getLocation(), Silverfish.class);
            attacks.createSummon(player.getLocation(), 400, player, summon, damage, health, defense, name, id);
        }
    }

    public void boneNeedle(Player player) {
        double health = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        if (health <= 20) {
            player.sendMessage(ChatColor.RED + "You do not have enough health to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE) + 12);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, health - 20);
        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_DRINK, 40, 1);
        player.sendMessage(ChatColor.GREEN + "Used Blood Sacrifice");
    }

    public void pufferCanon(Player player) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double damage = 25;
        double cost = 25;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost);
        damage *= apply.get(0);
        cost *= apply.get(1);

        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        damage = magicScale(damage, 0.05, player);
        attacks.createPuffer(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(3));
        player.sendMessage(ChatColor.GREEN + "Used Puffer Projectile");
    }

    public void prosperousGrove(Player player) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player.getName())) {
            if (cooldown_forest.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        cooldown_forest.put(player.getName(), System.currentTimeMillis() + (cooldown * 1000));
        player.sendMessage(ChatColor.GREEN + "Used Spirits of the Orchard");

        functions.heal(plugin, player, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)/12.5);
        player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation(), 25);

        List<Entity> entities = player.getNearbyEntities(7, 7, 7);
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof LivingEntity &&
                    entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null &&
                    entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("adventurer")) {
                functions.heal(plugin, entities.get(i), entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)/12.5);
                entities.get(i).getWorld().spawnParticle(Particle.VILLAGER_HAPPY, entities.get(i).getLocation(), 25);
            }
        }
    }

    public void vampireBrambles(Player player) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120);
        double cost = apply.get(1) * 120;
        double damage = apply.get(0) * 25;
        damage = magicScale(damage, 0.025, player);
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player.getName())) {
            if (cooldown_forest.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        cooldown_forest.put(player.getName(), System.currentTimeMillis() + (cooldown * 1000));
        player.sendMessage(ChatColor.GREEN + "Used Vampire Thorns");

        List<Entity> entities = player.getNearbyEntities(7, 7, 7);
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof LivingEntity &&
                entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING) == null ||
                !(entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING).equals("adventurer"))) {
                LivingEntity entity = (LivingEntity)entities.get(i);
                entity.damage(1);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE) - damage);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) - 25);
                entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() - 0.15);
                functions.heal(plugin, player, damage/10);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                        PersistentDataType.DOUBLE) + 25);
                        entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + 0.15);
                    }
                }, 100);

            }
        }
    }

    public void proliferatingSapling(Player player) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player.getName())) {
            if (cooldown_forest.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        cooldown_forest.put(player.getName(), System.currentTimeMillis() + (cooldown * 1000));
        player.sendMessage(ChatColor.GREEN + "Used Rapid Growth");

        new BukkitRunnable() {
            int iterations = 0;
            public void run() {
                if (iterations >= 6) {
                    this.cancel();
                    return;
                }
                functions.heal(plugin, player, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)/20);
                iterations += 1;
            }
        }.runTaskTimer(plugin, 0, 20);

    }

    public void bindingVines(Player player) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player.getName())) {
            if (cooldown_forest.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        cooldown_forest.put(player.getName(), System.currentTimeMillis() + (cooldown * 1000));
        player.sendMessage(ChatColor.GREEN + "Used Binding Vines");

        List<Entity> entities = player.getNearbyEntities(10, 10, 10);
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof LivingEntity &&
                entities.get(i).isOnGround() &&
                entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING) == null ||
                !(entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING).equals("adventurer"))) {
                LivingEntity entity = (LivingEntity)entities.get(i);
                entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                        100, 4, true, false));
                Double speed = entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue();
                entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {

                        entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + speed);
                    }
                }, 120);

            }
        }
    }

    public void invigoratingFumes(Player player) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player.getName())) {
            if (cooldown_forest.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        cooldown_forest.put(player.getName(), System.currentTimeMillis() + (cooldown * 1000));
        player.sendMessage(ChatColor.GREEN + "Used Invigorating Fumes");

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
            PersistentDataType.DOUBLE) + 50);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
            PersistentDataType.DOUBLE) + 50);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
            PersistentDataType.DOUBLE) + 50);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                    PersistentDataType.DOUBLE) - 50);
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                    PersistentDataType.DOUBLE) - 50);
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
                    PersistentDataType.DOUBLE) - 50);
            }
        }, 100);

        List<Entity> entities = player.getNearbyEntities(5, 5, 5);
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof LivingEntity &&
                entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING) != null &&
                entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING).equals("adventurer")) {
                if (entities.get(i) instanceof Player) {
                    Player target = (Player) entities.get(i);
                    target.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                        PersistentDataType.DOUBLE) + 50);
                    target.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                        PersistentDataType.DOUBLE) + 50);
                    target.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
                        PersistentDataType.DOUBLE) + 50);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            target.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                                PersistentDataType.DOUBLE) - 50);
                            target.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                                PersistentDataType.DOUBLE) - 50);
                            target.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
                                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
                                PersistentDataType.DOUBLE) - 50);
                        }
                    }, 100);
                } else {
                    LivingEntity entity = (LivingEntity) entities.get(i);
                    entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) + 50);
                    entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + 0.4);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                            PersistentDataType.DOUBLE) - 50);
                            entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() - 0.4);
                        }
                    }, 100);
                }
            }
        }
    }

    public void litchScimitar(Player player) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double damage = 40;
        double cost = 75;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost);
        damage *= apply.get(0);
        cost *= apply.get(1);

        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        damage = magicScale(damage, 0.04, player);
        attacks.track(attacks.createSkull(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(0.7), "", false), player, 3, 0.7);
        player.sendMessage(ChatColor.GREEN + "Used Oppressing Skull");
    }

    public void shortArrow(Player player, double velocity, String id, int pierce, long time) {
        if (cooldown_shortbow.containsKey(player.getName())) {
            if (cooldown_shortbow.get(player.getName()) > System.currentTimeMillis()) {
                return;
            }
        }


        boolean iscrit = false;
        double damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        damage = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/100) + 1) * damage;
        damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) + 1) * damage;
        Random crit = new Random();
        int choice = crit.nextInt(100) + 1;
        if (choice <= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                PersistentDataType.DOUBLE)) {
            iscrit = true;
            double dmg = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE)/100;

            damage = (dmg + 1) * damage;
        }
        List<Object> list = functions.reforgeOnShoot(player, plugin, velocity, iscrit, time);
        damage *= (Double) list.get(0);
        velocity *= (Double) list.get(1);
        time = Math.round((time * (Double)list.get(3)));
        cooldown_shortbow.put(player.getName(), System.currentTimeMillis() + (time));
        Arrow arrow = attacks.createArrow(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(velocity), id, pierce);
        functions.arrowChanges(player, plugin, arrow);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"),
                PersistentDataType.STRING, (String) list.get(2));
    }

    public void shortArrow(Player player, double velocity, String id, int pierce, long time, Color color) {
        if (cooldown_shortbow.containsKey(player.getName())) {
            if (cooldown_shortbow.get(player.getName()) > System.currentTimeMillis()) {
                return;
            }
        }

        boolean iscrit = false;
        double damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        damage = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/100) + 1) * damage;
        damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) + 1) * damage;
        Random crit = new Random();
        int choice = crit.nextInt(100) + 1;
        if (choice <= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                PersistentDataType.DOUBLE)) {
            iscrit = true;
            double dmg = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE)/100;

            damage = (dmg + 1) * damage;
        }

        List<Object> list = functions.reforgeOnShoot(player, plugin, velocity, iscrit, time);
        damage *= (Double) list.get(0);
        velocity *= (Double) list.get(1);
        time = Math.round((time * (Double)list.get(3)));
        cooldown_shortbow.put(player.getName(), System.currentTimeMillis() + (time));
        Arrow arrow = attacks.createArrow(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(velocity), id, pierce, color);
        functions.arrowChanges(player, plugin, arrow);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"),
                PersistentDataType.STRING, (String) list.get(2));
    }

    public void heal(Player player, long cooldown, double heal, int cost, String ability) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 0, cost);
        cost *= apply.get(1);
        cooldown /= apply.get(2);
        if (cooldown_heal.containsKey(player.getName())) {
            if (cooldown_heal.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_heal.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        cooldown_heal.put(player.getName(), System.currentTimeMillis() + (cooldown * 1000));
        functions.heal(plugin, player, heal);
        player.sendMessage(ChatColor.GREEN + "Used " + ability);
    }

    public void grapple(Player player) {
        if (cooldown_grapple.containsKey(player.getName())) {
            if (cooldown_grapple.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_grapple.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        cooldown_grapple.put(player.getName(), System.currentTimeMillis() + (2 * 1000));
        player.setVelocity(player.getLocation().getDirection().multiply(3));
        player.sendMessage(ChatColor.GREEN + "Used Grapple");
    }

    public void frenzy(Player player, ItemStack item) {
        if (cooldown_stinger.containsKey(player.getName())) {
            if (cooldown_stinger.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_stinger.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double cost = 80;
        long cooldown = 32000;

        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 0, cost);
        cost *= apply.get(1);
        cooldown *= apply.get(2);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        item.setType(Material.BLAZE_ROD);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
            PersistentDataType.DOUBLE) + 120);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
            PersistentDataType.DOUBLE) + 100);
        player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,
                180, 1, true, false));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                    PersistentDataType.DOUBLE) - 120));
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "AttackSpeedBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeedBonus"),
                    PersistentDataType.DOUBLE) - 100);
                item.setType(Material.STICK);
            }
        }, 180);

        cooldown_stinger.put(player.getName(), System.currentTimeMillis() + (32 * 1000));
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);
        player.sendMessage(ChatColor.GREEN + "Used Frenzy");
    }

    public void scan(Player player, String string, List<Material> sort, int range, int cooldown) {
        if (cooldown_scan.containsKey(player.getName())) {
            if (cooldown_scan.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_scan.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        cooldown_scan.put(player.getName(), System.currentTimeMillis() + (cooldown * 1000));
        List<Block> blocks = functions.getNearbyBlocksOnly(range, range, range, player.getLocation(), sort);
        for (int i = 0; i < blocks.size(); i++) {
            switch (blocks.get(i).getType()) {
                case COAL_ORE:
                case DEEPSLATE_COAL_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "black");
                    break;
                case COPPER_ORE:
                case DEEPSLATE_COPPER_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "gold");
                    break;
                case IRON_ORE:
                case DEEPSLATE_IRON_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "gray");
                    break;
                case GOLD_ORE:
                case DEEPSLATE_GOLD_ORE:
                case NETHER_GOLD_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "yellow");
                    break;
                case REDSTONE_ORE:
                case DEEPSLATE_REDSTONE_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "red");
                    break;
                case LAPIS_ORE:
                case DEEPSLATE_LAPIS_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "blue");
                    break;
                case NETHER_QUARTZ_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "white");
                    break;
                case DIAMOND_ORE:
                case DEEPSLATE_DIAMOND_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "aqua");
                    break;
                case EMERALD_ORE:
                case DEEPSLATE_EMERALD_ORE:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "green");
                    break;
                case ANCIENT_DEBRIS:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "dark_red");
                    break;
                case CHEST:
                    attacks.createMarkBlock(blocks.get(i).getLocation(), 400, "dark_green");
                    break;
            }
        }
        player.sendMessage(ChatColor.GREEN + "Used " + string);
    }

    public void echoStone(Player player) {
        if (cooldown_echo.containsKey(player.getName())) {
            if (cooldown_echo.get(player.getName()) > System.currentTimeMillis()) {
                long timeleft = (cooldown_echo.get(player.getName()) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        if (player.getLocation().distanceSquared(echo_ward.get(player.getName())) > 120 * 120) {
            player.sendMessage(ChatColor.RED + "Your ward is too far away to teleport to!");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
        player.teleport(echo_ward.get(player.getName()));
        player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 2);
        player.sendMessage(ChatColor.GREEN + "Used Echo");
        cooldown_echo.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
    }

    public void telport(Player player, int distance, int cost, String ability) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 0, cost);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 1, distance);

        Location loc = player.getLocation();
        float pitch = player.getLocation().getPitch();
        float yaw = player.getLocation().getYaw();

        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid()) {
                player.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 90, 1);
                loc.setYaw(yaw);
                loc.setPitch(pitch);
                player.teleport(loc);
                return;
            }
        }
        player.playSound(loc, Sound.ENTITY_ENDERMAN_TELEPORT, 90, 1);
        loc.setYaw(yaw);
        loc.setPitch(pitch);
        player.teleport(loc);
        player.sendMessage(ChatColor.GREEN + "Used " + ability);

    }

    public void drill(Player player) {

        int distance = 11;
        ItemStack tool = new ItemStack(Material.DIAMOND_PICKAXE);
        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 1, distance);

        Location loc = player.getLocation();

        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid()) {
                if (loc.getBlock().getType() != Material.BEDROCK &&
                    loc.getBlock().getType() != Material.COMMAND_BLOCK &&
                    loc.getBlock().getType() != Material.REPEATING_COMMAND_BLOCK &&
                    loc.getBlock().getType() != Material.CHAIN_COMMAND_BLOCK &&
                    loc.getBlock().getType() != Material.END_PORTAL_FRAME &&
                    loc.getBlock().getType() != Material.END_PORTAL &&
                    loc.getBlock().getType() != Material.BARRIER &&
                    loc.getBlock().getType() != Material.NETHER_PORTAL) {

                    loc.getBlock().breakNaturally(tool);
                }
                return;
            }
            else {
                Particle.DustOptions dust = new Particle.DustOptions(Color.RED, 0.3f);
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0,0, dust);
            }
        }
    }

    public void superPick(Player player, Block block) {
        ItemStack tool = new ItemStack(Material.IRON_PICKAXE);
        Location loc = block.getLocation();
        switch (player.getFacing()) {
            case UP:
                for (int i = 0; i < 5; ++i) {
                    if (loc.getBlock().getType() != Material.BEDROCK &&
                        loc.getBlock().getType() != Material.COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.REPEATING_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.CHAIN_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.END_PORTAL_FRAME &&
                        loc.getBlock().getType() != Material.END_PORTAL &&
                        loc.getBlock().getType() != Material.BARRIER &&
                        loc.getBlock().getType() != Material.NETHER_PORTAL) {
                        loc.getBlock().breakNaturally(tool);
                    }
                    loc = new Location(Bukkit.getWorld("world"), loc.getX(),loc.getY() + 1, loc.getZ());
                }
                break;
            case DOWN:
                for (int i = 0; i < 5; ++i) {
                    if (loc.getBlock().getType() != Material.BEDROCK &&
                        loc.getBlock().getType() != Material.COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.REPEATING_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.CHAIN_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.END_PORTAL_FRAME &&
                        loc.getBlock().getType() != Material.END_PORTAL &&
                        loc.getBlock().getType() != Material.BARRIER &&
                        loc.getBlock().getType() != Material.NETHER_PORTAL) {
                        loc.getBlock().breakNaturally(tool);
                    }
                    loc = new Location(Bukkit.getWorld("world"), loc.getX(),loc.getY() - 1, loc.getZ());
                }
                break;
            case NORTH:
                for (int i = 0; i < 5; ++i) {
                    if (loc.getBlock().getType() != Material.BEDROCK &&
                        loc.getBlock().getType() != Material.COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.REPEATING_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.CHAIN_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.END_PORTAL_FRAME &&
                        loc.getBlock().getType() != Material.END_PORTAL &&
                        loc.getBlock().getType() != Material.BARRIER &&
                        loc.getBlock().getType() != Material.NETHER_PORTAL) {
                        loc.getBlock().breakNaturally(tool);
                    }
                    loc = new Location(Bukkit.getWorld("world"), loc.getX(),loc.getY(), loc.getZ() - 1);
                }
                break;
            case SOUTH:
                for (int i = 0; i < 5; ++i) {
                    if (loc.getBlock().getType() != Material.BEDROCK &&
                        loc.getBlock().getType() != Material.COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.REPEATING_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.CHAIN_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.END_PORTAL_FRAME &&
                        loc.getBlock().getType() != Material.END_PORTAL &&
                        loc.getBlock().getType() != Material.BARRIER &&
                        loc.getBlock().getType() != Material.NETHER_PORTAL) {
                        loc.getBlock().breakNaturally(tool);
                    }
                    loc = new Location(Bukkit.getWorld("world"), loc.getX(),loc.getY(), loc.getZ() + 1);
                }
                break;
            case EAST:
                for (int i = 0; i < 5; ++i) {
                    if (loc.getBlock().getType() != Material.BEDROCK &&
                        loc.getBlock().getType() != Material.COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.REPEATING_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.CHAIN_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.END_PORTAL_FRAME &&
                        loc.getBlock().getType() != Material.END_PORTAL &&
                        loc.getBlock().getType() != Material.BARRIER &&
                        loc.getBlock().getType() != Material.NETHER_PORTAL) {
                        loc.getBlock().breakNaturally(tool);
                    }
                    loc = new Location(Bukkit.getWorld("world"), loc.getX() + 1,loc.getY(), loc.getZ());
                }
                break;
            case WEST:
            default:
                for (int i = 0; i < 5; ++i) {
                    if (loc.getBlock().getType() != Material.BEDROCK &&
                        loc.getBlock().getType() != Material.COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.REPEATING_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.CHAIN_COMMAND_BLOCK &&
                        loc.getBlock().getType() != Material.END_PORTAL_FRAME &&
                        loc.getBlock().getType() != Material.END_PORTAL &&
                        loc.getBlock().getType() != Material.BARRIER &&
                        loc.getBlock().getType() != Material.NETHER_PORTAL) {
                        loc.getBlock().breakNaturally(tool);
                    }
                    loc = new Location(Bukkit.getWorld("world"), loc.getX() - 1 ,loc.getY(), loc.getZ());
                }
                break;
        }
    }

    public void lightningWand(Player player) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 10;
        double cost = 45;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 1, 60);

        Location loc = player.getLocation();

        damage = magicScale(damage, 0.025, player);
        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid() || (functions.findEntity(loc, 0.2) != null && !(functions.findEntity(loc, 0.2) instanceof Player))) {
                attacks.createLightning(loc, damage, player);
                player.sendMessage(ChatColor.GREEN + "Used Lightning Strike");
                return;
            }
        }
        attacks.createLightning(loc, damage, player);
        player.sendMessage(ChatColor.GREEN + "Used Lightning Strike");

    }

    public void sandWand(Player player) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 50;
        double cost = 40;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 1, 12);

        Location loc = player.getLocation();

        damage = magicScale(damage, 0.04, player);
        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid() || (functions.findEntity(loc, 0.2) != null && !(functions.findEntity(loc, 0.2) instanceof Player))) {
               if (functions.findEntity(loc, 1.5) != null) {
                   LivingEntity entity = functions.findEntity(loc, 1.5);
                   attacks.createBlock(new Location(entity.getWorld(), entity.getLocation().getX(), entity.getLocation().getY() + 5, entity.getLocation().getZ()), damage, Material.SAND, player, true);
               } else {
                   attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ()), damage, Material.SAND, player, true);
               }
                player.sendMessage(ChatColor.GREEN + "Used Summon Sand");
                return;
            }
        }
        if (functions.findEntity(loc, 1.5) != null) {
            LivingEntity entity = functions.findEntity(loc, 1.5);
            attacks.createBlock(new Location(entity.getWorld(), entity.getLocation().getX(), entity.getLocation().getY() + 5, entity.getLocation().getZ()), damage, Material.SAND, player, true);
        } else {
            attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ()), damage, Material.SAND, player, true);
        }
        player.sendMessage(ChatColor.GREEN + "Used Summon Sand");

    }

    public void duneWand(Player player) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 120;
        double cost = 150;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 1, 15);

        Location loc = player.getLocation();

        damage = magicScale(damage, 0.04, player);
        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid() || (functions.findEntity(loc, 0.2) != null && !(functions.findEntity(loc, 0.2) instanceof Player))) {
                if (functions.findEntity(loc, 1.5) != null) {
                    LivingEntity entity = functions.findEntity(loc, 1.5);
                    Location location = entity.getLocation();
                    attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() + 2), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 5, location.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() + 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 5, location.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() + 2, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() - 2, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 5, location.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() - 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 5, location.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() - 2), damage, Material.SMOOTH_SANDSTONE, player, true);

                } else {
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() + 2), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 5, loc.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() + 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 5, loc.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 5, loc    .getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 5, loc.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() - 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 5, loc.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
                    attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() - 2), damage, Material.SMOOTH_SANDSTONE, player, true);
                }
                player.sendMessage(ChatColor.GREEN + "Used Invoke Dune");
                return;
            }
        }

        if (functions.findEntity(loc, 1.5) != null) {
            LivingEntity entity = functions.findEntity(loc, 1.5);
            Location location = entity.getLocation();
            attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() + 2), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 5, location.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() + 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 5, location.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() + 2, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() - 2, location.getY() + 5, location.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 5, location.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() - 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 5, location.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 5, location.getZ() - 2), damage, Material.SMOOTH_SANDSTONE, player, true);

        } else {
            attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() + 2), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 5, loc.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() + 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 5, loc.getZ() + 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 5, loc    .getZ()), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 5, loc.getZ()), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 5, loc.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() - 1), damage, Material.SMOOTH_RED_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 5, loc.getZ() - 1), damage, Material.SMOOTH_SANDSTONE, player, true);
            attacks.createBlock(new Location(loc.getWorld(), loc.getX(), loc.getY() + 5, loc.getZ() - 2), damage, Material.SMOOTH_SANDSTONE, player, true);
        }
        player.sendMessage(ChatColor.GREEN + "Used Invoke Dune");

    }

    public void prismaticWand(Player player) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 90;
        double cost = 210;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 1, 12);

        Location loc = player.getLocation();
        damage = magicScale(damage, 0.04, player);
        double dmg = damage;
        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid() || (functions.findEntity(loc, 0.2) != null && !(functions.findEntity(loc, 0.2) instanceof Player))) {
                if (functions.findEntity(loc, 1.5) != null) {
                    LivingEntity entity = functions.findEntity(loc, 1.5);
                    Location location = entity.getLocation();

                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ() + 1), damage, Material.RED_CONCRETE_POWDER, player, true, "red"), Color.RED, 1f, 8);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 7, location.getZ() + 1), dmg, Material.ORANGE_CONCRETE_POWDER, player, true, "orange"), Color.ORANGE, 1f, 8);
                            }
                        }, 2);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 7, location.getZ() + 1), dmg, Material.YELLOW_CONCRETE_POWDER, player, true, "yellow"), Color.YELLOW, 1f, 8);
                        }
                    }, 4);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 7, location.getZ()), dmg, Material.LIME_CONCRETE_POWDER, player, true, "green"), Color.GREEN, 1f, 8);
                        }
                    }, 6);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 7, location.getZ() - 1), dmg, Material.LIGHT_BLUE_CONCRETE_POWDER, player, true, "aqua"), Color.AQUA, 1f, 8);
                        }
                    }, 8);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 7, location.getZ() - 1), dmg, Material.BLUE_CONCRETE_POWDER, player, true, "blue"), Color.BLUE, 1f, 8);
                        }
                    }, 10);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ() - 1), dmg, Material.MAGENTA_CONCRETE_POWDER, player, true, "magenta"), Color.FUCHSIA, 1f, 8);
                        }
                    }, 12);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ()), dmg, Material.PURPLE_CONCRETE_POWDER, player, true, "purple"), Color.PURPLE, 1f, 8);

                        }
                    }, 14);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ() + 1), dmg, Material.WHITE_CONCRETE_POWDER, player, true, "white"), Color.WHITE, 1f, 8);

                        }
                    }, 16);

                } else {
                    Location LOC = loc;
                    attacks.trail(attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 7, loc.getZ() + 1), damage, Material.RED_CONCRETE_POWDER, player, true, "red"), Color.RED, 1f, 8);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX(), LOC.getY() + 7, LOC.getZ() + 1), dmg, Material.ORANGE_CONCRETE_POWDER, player, true, "orange"), Color.ORANGE, 1f, 8);
                        }
                    }, 2);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() + 1, LOC.getY() + 7, LOC.getZ() + 1), dmg, Material.YELLOW_CONCRETE_POWDER, player, true, "yellow"), Color.YELLOW, 1f, 8);
                        }
                    }, 4);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() + 1, LOC.getY() + 7, LOC.getZ()), dmg, Material.LIME_CONCRETE_POWDER, player, true, "green"), Color.GREEN,  1f, 8);
                        }
                    }, 6);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() + 1, LOC.getY() + 7, LOC.getZ() - 1), dmg, Material.LIGHT_BLUE_CONCRETE_POWDER, player, true, "aqua"), Color.AQUA, 1f, 8);
                        }
                    }, 8);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX(), LOC.getY() + 7, LOC.getZ() - 1), dmg, Material.BLUE_CONCRETE_POWDER, player, true, "blue"), Color.BLUE, 1f, 8);
                        }
                    }, 10);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() - 1, LOC.getY() + 7, LOC.getZ() - 1), dmg, Material.MAGENTA_CONCRETE_POWDER, player, true, "magenta"), Color.FUCHSIA,  1f, 8);
                        }
                    }, 12);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() - 1, LOC.getY() + 7, LOC.getZ()), dmg, Material.PURPLE_CONCRETE_POWDER, player, true, "purple"), Color.PURPLE, 1f, 8);

                        }
                    }, 14);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() - 1, LOC.getY() + 7, LOC.getZ() + 1), dmg, Material.WHITE_CONCRETE_POWDER, player, true, "white"), Color.WHITE, 1f, 8);

                        }
                    }, 16);
                }
                player.sendMessage(ChatColor.GREEN + "Used Chromatic Sands");
                return;
            }
        }

        if (functions.findEntity(loc, 1.5) != null) {
            LivingEntity entity = functions.findEntity(loc, 1.5);
            Location location = entity.getLocation();

            attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ() + 1), damage, Material.RED_CONCRETE_POWDER, player, true, "red"), Color.RED, 1f, 8);

            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 7, location.getZ() + 1), dmg, Material.ORANGE_CONCRETE_POWDER, player, true, "orange"), Color.ORANGE, 1f, 8);
                }
            }, 2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 7, location.getZ() + 1), dmg, Material.YELLOW_CONCRETE_POWDER, player, true, "yellow"), Color.YELLOW, 1f, 8);
                }
            }, 4);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 7, location.getZ()), dmg, Material.LIME_CONCRETE_POWDER, player, true, "green"), Color.GREEN, 1f, 8);
                }
            }, 6);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() + 1, location.getY() + 7, location.getZ() - 1), dmg, Material.LIGHT_BLUE_CONCRETE_POWDER, player, true, "aqua"), Color.AQUA, 1f, 8);
                }
            }, 8);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX(), location.getY() + 7, location.getZ() - 1), dmg, Material.BLUE_CONCRETE_POWDER, player, true, "blue"), Color.BLUE, 1f, 8);
                }
            }, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ() - 1), dmg, Material.MAGENTA_CONCRETE_POWDER, player, true, "magenta"), Color.FUCHSIA, 1f, 8);
                }
            }, 12);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ()), dmg, Material.PURPLE_CONCRETE_POWDER, player, true, "purple"), Color.PURPLE, 1f, 8);
                }
            }, 14);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(entity.getWorld(), location.getX() - 1, location.getY() + 7, location.getZ() + 1), dmg, Material.WHITE_CONCRETE_POWDER, player, true, "white"), Color.WHITE, 1f, 8);
                }
            }, 16);

        } else {
            Location LOC = loc;
            attacks.trail(attacks.createBlock(new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 7, loc.getZ() + 1), damage, Material.RED_CONCRETE_POWDER, player, true, "red"), Color.RED, 1f, 8);

            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX(), LOC.getY() + 7, LOC.getZ() + 1), dmg, Material.ORANGE_CONCRETE_POWDER, player, true, "orange"), Color.ORANGE, 1f, 8);
                }
            }, 2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() + 1, LOC.getY() + 7, LOC.getZ() + 1), dmg, Material.YELLOW_CONCRETE_POWDER, player, true, "yellow"), Color.YELLOW, 1f, 8);
                }
            }, 4);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() + 1, LOC.getY() + 7, LOC.getZ()), dmg, Material.LIME_CONCRETE_POWDER, player, true, "green"), Color.GREEN, 1f, 8);
                }
            }, 6);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() + 1, LOC.getY() + 7, LOC.getZ() - 1), dmg, Material.LIGHT_BLUE_CONCRETE_POWDER, player, true, "aqua"), Color.AQUA, 1f, 8);
                }
            }, 8);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX(), LOC.getY() + 7, LOC.getZ() - 1), dmg, Material.BLUE_CONCRETE_POWDER, player, true, "blue"), Color.BLUE, 1f, 8);
                }
            }, 10);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() - 1, LOC.getY() + 7, LOC.getZ() - 1), dmg, Material.MAGENTA_CONCRETE_POWDER, player, true, "magenta"), Color.FUCHSIA, 1f, 8);
                }
            }, 12);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() - 1, LOC.getY() + 7, LOC.getZ()), dmg, Material.PURPLE_CONCRETE_POWDER, player, true, "purple"), Color.PURPLE, 1f, 8);
                }
            }, 14);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    attacks.trail(attacks.createBlock(new Location(LOC.getWorld(), LOC.getX() - 1, LOC.getY() + 7, LOC.getZ() + 1), dmg, Material.WHITE_CONCRETE_POWDER, player, true, "white"), Color.WHITE, 1f, 8);
                }
            }, 16);
        }

        player.sendMessage(ChatColor.GREEN + "Used Chromatic Sands");

    }

    public void eatStew(Player player, ItemStack item, String stat, int amount, String type) {
        double base = player.getPersistentDataContainer().get(new NamespacedKey(plugin, stat + "Base"),
                PersistentDataType.DOUBLE);
        int soup = player.getPersistentDataContainer().get(new NamespacedKey(plugin, stat + "Soup"),
                PersistentDataType.INTEGER);
        if (soup == 3) {
            player.sendMessage(ChatColor.RED + "You have already eaten enough " + type + " !");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }
        player.sendMessage(ChatColor.GREEN + "Yum! You ate the " + type + " and gained +" + amount + " " + stat);

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, stat + "Base"),
                PersistentDataType.DOUBLE, base + amount);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, stat + "Soup"),
                PersistentDataType.INTEGER, soup + 1);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 70, 2);
        item.setAmount(0);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        items.put(player.getName(), new ArrayList<>());

        cooldown_heal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
        cooldown_grapple.put(player.getName(), System.currentTimeMillis() + (5 * 500));
        cooldown_forest.put(player.getName(), System.currentTimeMillis() + (18 * 1000));
        cooldown_stinger.put(player.getName(), System.currentTimeMillis() + (32 * 1000));
        cooldown_rift.put(player.getName(), System.currentTimeMillis() + (15 * 1000));
        cooldown_scan.put(player.getName(), System.currentTimeMillis() + (1 * 1000));
        cooldown_echo.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
        cooldown_shortbow.put(player.getName(), System.currentTimeMillis() + (400));
        cooldown_mite_wand.put(player.getName(), System.currentTimeMillis() + (40 * 1000));

        echo_ward.put(player.getName(), player.getLocation());
        player.setFlying(false);
        player.setInvisible(false);
        new BukkitRunnable() {
            int time = 0;
            String main = "";
            String mainRef = "";
            String off = "";
            String offRef = "";
            String helmet = "";
            String helmetRef = "";
            String chest = "";
            String chestRef = "";
            String legs = "";
            String legsRef = "";
            String boots = "";
            String bootsRef = "";
            public void run() {
                if (!player.isOnline()) {
                    this.cancel();
                    return;
                }
                time += 1;
                main = "";
                mainRef = "";
                off = "";
                offRef = "";
                helmet = "";
                helmetRef = "";
                chest = "";
                chestRef = "";
                legs = "";
                legsRef = "";
                boots = "";
                bootsRef = "";

                if (time % 10 == 0) {
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i < 36; i++) {
                        if (player.getInventory().getItem(i) != null &&
                                player.getInventory().getItem(i).getItemMeta() != null &&
                                player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer() != null &&
                                player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                        PersistentDataType.STRING) != null) {
                            list.add(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING));
                        }
                    }
                    items.put(player.getName(), list);
                }

                if (player.getInventory().getItemInMainHand() != null &&
                        player.getInventory().getItemInMainHand().getItemMeta() != null &&
                        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        main = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                            PersistentDataType.STRING) != null) {
                        mainRef = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                                PersistentDataType.STRING);
                    }
                }

                if (player.getInventory().getItemInOffHand() != null &&
                        player.getInventory().getItemInOffHand().getItemMeta() != null &&
                        player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null) {
                    if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        off = player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    if (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                            PersistentDataType.STRING) != null) {
                        offRef = player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                                PersistentDataType.STRING);
                    }
                }

                if (player.getInventory().getHelmet() != null &&
                        player.getInventory().getHelmet().getItemMeta() != null &&
                        player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null) {
                    if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        helmet = player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    if (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                            PersistentDataType.STRING) != null) {
                        helmetRef = player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                                PersistentDataType.STRING);
                    }
                }

                if (player.getInventory().getChestplate() != null &&
                        player.getInventory().getChestplate().getItemMeta() != null &&
                        player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null) {
                    if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        chest = player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    if (player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                            PersistentDataType.STRING) != null) {
                        chestRef = player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                                PersistentDataType.STRING);
                    }
                }

                if (player.getInventory().getLeggings() != null &&
                        player.getInventory().getLeggings().getItemMeta() != null &&
                        player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null) {
                    if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        legs = player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    if (player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                            PersistentDataType.STRING) != null) {
                        legsRef = player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                                PersistentDataType.STRING);
                    }
                }

                if (player.getInventory().getBoots() != null &&
                        player.getInventory().getBoots().getItemMeta() != null &&
                        player.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null) {
                    if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        boots = player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                    }
                    if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                            PersistentDataType.STRING) != null) {
                        bootsRef = player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                                PersistentDataType.STRING);
                    }
                }

                switch (main) {
                    case "Lucky Pottery Shard":
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,
                                20, 0, true, false));
                        break;
                }
                switch (off) {
                    case "Lucky Pottery Shard":
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,
                                20, 0, true, false));
                        break;
                }

                if (time % 4 == 0 && helmet.equals("Severed Creeper Head")) {
                    List<Entity> entities = player.getNearbyEntities(5, 5, 5);
                    for (int i = 0; i < entities.size(); ++i) {
                        Entity entity = entities.get(i);
                        if (entity instanceof Creeper) {
                            int time = ((Creeper)entity).getMaxFuseTicks();
                            ((Creeper)entity).setMaxFuseTicks((int) Math.round(time * 1.2));

                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                Creeper creeper = (Creeper) entity;
                                public void run() {
                                    creeper.setMaxFuseTicks(time);
                                }
                            }, 20);
                        }
                    }
                }

                if (player.isSneaking() && helmet.equals("Bush Suit")) {
                    FallingBlock block = player.getLocation().getWorld().spawnFallingBlock(player.getLocation(), Bukkit.createBlockData(Material.AZALEA));
                    block.setDropItem(false);
                    block.setGravity(false);
                    new BukkitRunnable() {
                        int iterations = 0;
                        public void run()
                        {
                            if (iterations >= 5 || player.isDead()) {
                                block.remove();
                                this.cancel();
                            }
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                                    5, 0, true, false));
                            block.teleport(player.getLocation());
                            iterations += 1;
                        }
                    }.runTaskTimer(plugin, 0, 1);
                }

                if (time % 20 == 0 && helmet.equals("Beekeeper Hat") && chest.equals("Beekeeper Vest") && legs.equals("Beekeeper Pants") && boots.equals("Beekeeper Boots")) {
                    double modifier = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                                        PersistentDataType.DOUBLE) / 50) + 1;
                    Bee bee = player.getLocation().getWorld().spawn(player.getLocation(), Bee.class);
                    bee.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                            9999999, 4, true, false));


                    bee.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(bee.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 1.55);
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE, 40.0 * modifier);
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, 40.0 * modifier);
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE, 100.0 * modifier);
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                            PersistentDataType.DOUBLE, 0.0);
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                            PersistentDataType.DOUBLE, 0.0);
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                            PersistentDataType.STRING, "Player Bee");
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING, "adventurer");
                    bee.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING, "MASTER_BEE");

                    String Name = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                            PersistentDataType.STRING);
                    Double Health = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE);
                    Double MaxHealth = bee.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE);

                    bee.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                            Health + "/" + MaxHealth);

                    functions.targetMob(bee, plugin, true);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            bee.remove();
                        }
                    }, 160);
                }

                if (items.get(player.getName()).contains("Lucky Foot") && time % 4 == 0) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBonus"),
                        PersistentDataType.DOUBLE) + 15);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBonus"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBonus"),
                                    PersistentDataType.DOUBLE) - 15);
                        }
                    }, 20);
                }

                if (time % 4 == 0 && helmet.equals("Onyx Helmet") && chest.equals("Onyx Chestplate") && legs.equals("Onyx Leggings") && boots.equals("Onyx Boots")) {
                    List<Entity> entities = player.getNearbyEntities(3, 3, 3);
                    for (int i = 0; i < entities.size(); ++i) {
                        if (entities.get(i) instanceof LivingEntity && (entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) == null || entities.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) != "adventurer")) {
                            LivingEntity selected = (LivingEntity) entities.get(i);
                            double damage = selected.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE);
                            double speed = selected.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue();
                            selected.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed * 0.9);
                            selected.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE, damage * 0.9);
                            selected.getWorld().spawnParticle(Particle.DRIPPING_OBSIDIAN_TEAR, selected.getLocation(), 8);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    selected.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(selected.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + (speed * 0.1));
                                    selected.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                            PersistentDataType.DOUBLE, selected.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                                    PersistentDataType.DOUBLE) + (damage * 0.1));
                                }
                            }, 20);
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 60, 5);
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent event) {
        Item item = event.getItem();
        if (item.getItemStack().getItemMeta().getLore() == null) {
            ItemMeta meta = item.getItemStack().getItemMeta();
            List<String> lore = new ArrayList<>();
            switch (item.getItemStack().getType()) {
                case DIAMOND:
                case EMERALD:
                case ANCIENT_DEBRIS:
                case NETHERITE_INGOT:
                case CONDUIT:
                case MUSIC_DISC_11:
                case MUSIC_DISC_13:
                case MUSIC_DISC_BLOCKS:
                case MUSIC_DISC_CAT:
                case MUSIC_DISC_CHIRP:
                case MUSIC_DISC_FAR:
                case MUSIC_DISC_MALL:
                case MUSIC_DISC_MELLOHI:
                case MUSIC_DISC_PIGSTEP:
                case MUSIC_DISC_STAL:
                case MUSIC_DISC_STRAD:
                case MUSIC_DISC_WAIT:
                case MUSIC_DISC_WARD:
                case BEACON:
                case HEART_OF_THE_SEA:
                case NETHER_STAR:
                case DIAMOND_BLOCK:
                case EMERALD_BLOCK:
                case JUKEBOX:
                case ENCHANTING_TABLE:
                case ENCHANTED_GOLDEN_APPLE:
                    lore.add(ChatColor.GREEN.toString() + ChatColor.BOLD + "UNCOMMON");
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
                    break;
                default:
                    lore.add(ChatColor.WHITE.toString() + ChatColor.BOLD + "COMMON");
                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
                    break;
            }
            meta.setLore(lore);
            item.getItemStack().setItemMeta(meta);
        }
    }

    @EventHandler
    public void onCrouch(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();

        //Set Echo Ward (Echo Stone)
        if (player.isSneaking()) {
            if (player.getInventory().getItemInMainHand() != null &&
            player.getInventory().getItemInMainHand().getItemMeta() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING) != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING).equals("Echo Stone")) {
                echo_ward.put(player.getName(), player.getLocation());
                player.sendMessage(ChatColor.GREEN + "Placed Echo Ward");
            }
        }

    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR ||
            event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            ItemStack item;
            ItemMeta meta;

            boolean cancel = false;
            Block block = event.getClickedBlock();

            if (block != null &&
                block.getBlockData() != null && (
                block.getBlockData() instanceof Powerable ||
                block.getBlockData() instanceof Grindstone ||
                block.getBlockData() instanceof Hopper ||
                block.getBlockData() instanceof Jukebox ||
                block.getBlockData() instanceof NoteBlock ||
                block.getBlockData() instanceof Bed ||
                block.getBlockData() instanceof Furnace ||
                block.getBlockData() instanceof Cake ||
                block.getBlockData() instanceof EnderChest ||
                block.getType() == Material.STONECUTTER ||
                block.getType() == Material.DISPENSER ||
                block.getType() == Material.DROPPER ||
                block.getType() == Material.BARREL ||
                block.getType() == Material.SHULKER_BOX  ||
                block.getType() == Material.CRAFTING_TABLE ||
                block.getBlockData() instanceof Chest)) {
                return;
            }

            if (event.getItem() != null && (
                event.getItem().getType() == Material.FISHING_ROD ||
                event.getItem().getType() == Material.SPYGLASS ||
                event.getItem().getType() == Material.CROSSBOW ||
                event.getItem().getType() == Material.TRIDENT ||
                event.getItem().getType() == Material.SHIELD ||
                event.getItem().getType() == Material.POTION ||
                event.getItem().getType() == Material.WHITE_SHULKER_BOX ||
                event.getItem().getType() == Material.ORANGE_SHULKER_BOX ||
                event.getItem().getType() == Material.MAGENTA_SHULKER_BOX ||
                event.getItem().getType() == Material.LIGHT_BLUE_SHULKER_BOX ||
                event.getItem().getType() == Material.YELLOW_SHULKER_BOX ||
                event.getItem().getType() == Material.LIME_SHULKER_BOX ||
                event.getItem().getType() == Material.PINK_SHULKER_BOX ||
                event.getItem().getType() == Material.GRAY_SHULKER_BOX ||
                event.getItem().getType() == Material.LIGHT_GRAY_SHULKER_BOX ||
                event.getItem().getType() == Material.CYAN_SHULKER_BOX ||
                event.getItem().getType() == Material.PURPLE_SHULKER_BOX ||
                event.getItem().getType() == Material.BLUE_SHULKER_BOX ||
                event.getItem().getType() == Material.BROWN_SHULKER_BOX ||
                event.getItem().getType() == Material.GREEN_SHULKER_BOX ||
                event.getItem().getType() == Material.RED_SHULKER_BOX ||
                event.getItem().getType() == Material.BLACK_SHULKER_BOX)) {
                cancel = false;
            }

            Player player = event.getPlayer();
            if (event.getItem() != null &&
                event.getItem().getItemMeta() != null &&
                event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                if (event.getItem() != null && (
                    event.getItem().getType() != Material.FISHING_ROD &&
                    event.getItem().getType() != Material.SPYGLASS &&
                    event.getItem().getType() != Material.CROSSBOW &&
                    event.getItem().getType() != Material.TRIDENT &&
                    event.getItem().getType() != Material.SHIELD &&
                    event.getItem().getType() != Material.POTION)) {
                    cancel = true;
                }
                List<Material> materialList = new ArrayList<>();
                switch (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Lesser Wand of Healing":
                        heal(player, 8L, 40, 20, "Minor Heal");
                        break;
                    case "Wand of Healing":
                        heal(player, 8L, 75, 35, "Heal");
                        break;
                    case "Greater Wand of Healing":
                        heal(player, 7L, 100, 40, "Major Heal");
                        break;
                    case "Chain Heal Wand":
                        heal(player, 2L, 40, 25, "Major Heal");
                    case "Echo Stone":
                        echoStone(player);
                        break;
                    case "Test Shortbow":
                        if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                            break;
                        }
                        shortArrow(player, 2.5, "TRACKING_ARROW", 0, 400);
                        break;
                    case "Aspect of The End":
                        telport(player, 7, 40, "Instant Transmission");
                        break;
                    case "Tnt Wand":
                        tntWand(player);
                        break;
                    case "Pufferfish Canon":
                        pufferCanon(player);
                        break;
                    case "Bamboo Shortbow":
                        if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                            break;
                        }
                        shortArrow(player, 2.4, "BAMBOO_ARROW", 0, 270);
                        break;
                    case "Potion Shortbow":
                        if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                            break;
                        }
                        int choice = random.nextInt(3) + 1;
                        switch (choice) {
                            case 1:
                                shortArrow(player, 2.7, "DEATH_POTION_ARROW", 0, 310L, Color.fromBGR(102, 24, 88));
                                break;
                            case 2:
                                shortArrow(player, 2.7, "POISON_POTION_ARROW", 0, 310L, Color.fromBGR(28, 140, 67));
                                break;
                            case 3:
                                shortArrow(player, 2.7, "PIERCE_POTION_ARROW", 2, 310L, Color.fromBGR(207, 180, 64));
                                break;
                        }
                        break;
                    case "Meaty Stew":
                        eatStew(player, event.getItem(), "Strength", 5, "Meaty Stew");
                        break;
                    case "Magic Stew":
                        eatStew(player, event.getItem(), "Intelligence", 15, "Magic Stew");
                        break;
                    case "Fibrous Stew":
                        eatStew(player, event.getItem(), "Defense", 5, "Fibrous Stew");
                        break;
                    case "Spicy Stew":
                        eatStew(player, event.getItem(), "Crit", 7, "Spicy Stew");
                        break;
                    case "Hearty Stew":
                        eatStew(player, event.getItem(), "Health", 10, "Hearty Stew");
                        break;
                    case "Bone Needle":
                        boneNeedle(player);
                        break;
                    case "Pocket Crafting Table":
                        workBenchGUI(player);
                        break;
                    case "Mini Ender Chest":
                        player.openInventory(player.getEnderChest());
                        break;
                    case "Travel Scroll to The End":
                        warpEnd(player);
                        break;
                    case "Travel Scroll to The Nether":
                        warpNether(player);
                        break;
                    case "Travel Scroll to The Overworld":
                        warpWorld(player);
                        break;
                    case "Warp Scroll":
                        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                PersistentDataType.DOUBLE)) {
                            player.sendMessage(ChatColor.RED + "You cannot fast travel while injured");
                            return;
                        }

                        Location location = new Location(Bukkit.getWorld(event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "world"),
                                PersistentDataType.STRING)), event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "locationX"),
                                PersistentDataType.DOUBLE), event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "locationY"),
                                PersistentDataType.DOUBLE), event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "locationZ"),
                                PersistentDataType.DOUBLE));

                        player.teleport(location);
                        echo_ward.put(player.getName(), location);
                        break;
                    case "Lightning Wand":
                        lightningWand(player);
                        break;
                    case "Sand Wand":
                        sandWand(player);
                        break;
                    case "Dune Wand":
                        duneWand(player);
                        break;
                    case "Prismatic Wand":
                        prismaticWand(player);
                        break;
                    case "Grappling Hook":
                        cancel = true;
                        grapple(player);
                        break;
                    case "Wand of Maggots":
                        miteWand(player);
                        break;
                    case "Small Gnawed Bone":
                        attacks.createSpiritWolf(plugin, player, 300, 40, 0, 0.4, "Lesser Spirit Wolf");
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                        break;
                    case "Large Marred Bone":
                        attacks.createSpiritWolf(plugin, player, 2500, 150, 0, 0.5, "Greater Spirit Wolf");
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                        break;
                    case "Metal Detector":
                        materialList.add(Material.IRON_ORE);
                        materialList.add(Material.DEEPSLATE_IRON_ORE);
                        materialList.add(Material.COPPER_ORE);
                        materialList.add(Material.DEEPSLATE_COPPER_ORE);
                        materialList.add(Material.ANCIENT_DEBRIS);
                        scan(player, "Find Metal", materialList, 8, 15);
                        break;
                    case "Metalloid Detector":
                        materialList.add(Material.IRON_ORE);
                        materialList.add(Material.DEEPSLATE_IRON_ORE);
                        materialList.add(Material.COPPER_ORE);
                        materialList.add(Material.DEEPSLATE_COPPER_ORE);
                        materialList.add(Material.LAPIS_ORE);
                        materialList.add(Material.DEEPSLATE_LAPIS_ORE);
                        materialList.add(Material.GOLD_ORE);
                        materialList.add(Material.DEEPSLATE_GOLD_ORE);
                        materialList.add(Material.NETHER_GOLD_ORE);
                        materialList.add(Material.NETHER_QUARTZ_ORE);
                        materialList.add(Material.ANCIENT_DEBRIS);
                        scan(player, "Find Metalloids", materialList, 8, 12);
                        break;
                    case "Treasure Detector":
                        materialList.add(Material.COAL_ORE);
                        materialList.add(Material.DEEPSLATE_COAL_ORE);
                        materialList.add(Material.IRON_ORE);
                        materialList.add(Material.DEEPSLATE_IRON_ORE);
                        materialList.add(Material.COPPER_ORE);
                        materialList.add(Material.DEEPSLATE_COPPER_ORE);
                        materialList.add(Material.LAPIS_ORE);
                        materialList.add(Material.DEEPSLATE_LAPIS_ORE);
                        materialList.add(Material.REDSTONE_ORE);
                        materialList.add(Material.DEEPSLATE_REDSTONE_ORE);
                        materialList.add(Material.GOLD_ORE);
                        materialList.add(Material.DEEPSLATE_GOLD_ORE);
                        materialList.add(Material.NETHER_GOLD_ORE);
                        materialList.add(Material.NETHER_QUARTZ_ORE);
                        materialList.add(Material.DIAMOND_ORE);
                        materialList.add(Material.DEEPSLATE_DIAMOND_ORE);
                        materialList.add(Material.EMERALD_ORE);
                        materialList.add(Material.DEEPSLATE_EMERALD_ORE);
                        materialList.add(Material.CHEST);
                        materialList.add(Material.ANCIENT_DEBRIS);
                        scan(player, "Find Treasure", materialList, 8, 10);
                        break;
                    case "Barrel of Rocks":
                        String msg = ChatColor.GRAY + "Nothing at all?!? What a " + ChatColor.DARK_RED + ChatColor.BOLD + "scam" + ChatColor.RESET + ChatColor.GRAY + "!";
                        if (random.nextInt(3) == 0) {
                            for (int i = 0; i < random.nextInt(5) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_COBBLESTONE.getItem(plugin));
                                msg = ChatColor.GRAY + "Aww man, just a bunch of" + ChatColor.DARK_GRAY + " j u n k" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(3) == 0) {
                            for (int i = 0; i < random.nextInt(3) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_FLINT.getItem(plugin));
                                msg = ChatColor.GRAY + "Aww man, just a bunch of" + ChatColor.DARK_GRAY + " j u n k" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(3) == 0) {
                            for (int i = 0; i < random.nextInt(4) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_SAND.getItem(plugin));
                                msg = ChatColor.GRAY + "Aww man, just a bunch of" + ChatColor.DARK_GRAY + " j u n k" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(5) == 0) {
                            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_COPPER.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(7) == 0) {
                            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_IRON.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(10) == 0) {
                            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_GOLD.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(12) == 0) {
                            for (int i = 0; i < random.nextInt(4) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_BONE.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(16) == 0) {
                            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_REDSTONE.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(16) == 0) {
                            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_LAPIS.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(18) == 0) {
                            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_COMPACTED_SAND.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(21) == 0) {
                            for (int i = 0; i < random.nextInt(2) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_QUARTZ.getItem(plugin));
                                msg = ChatColor.GRAY + "Oh, this might be worth" + ChatColor.GREEN + " a little" + ChatColor.GRAY + ".";
                            }
                        }
                        if (random.nextInt(25) == 0) {
                            for (int i = 0; i < random.nextInt(3) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_DIAMOND.getItem(plugin));
                                msg = ChatColor.AQUA + "SWEET!" + ChatColor.GRAY + " What a great haul!";
                            }
                        }
                        if (random.nextInt(25) == 0) {
                            for (int i = 0; i < random.nextInt(3) + 1; ++i) {
                                player.getInventory().addItem(Items.ENCHANTED_EMERALD.getItem(plugin));
                                msg = ChatColor.AQUA + "SWEET!" + ChatColor.GRAY + " What a great haul!";
                            }
                        }
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                        player.sendMessage(msg);
                        break;
                    case "Dimensional Cutters":
                        rift(player);
                        break;
                    case "Blank Warp Scroll":
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                        item = Items.WARP_SCROLL.getItem(plugin);
                        Items value = Items.values()[item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"),
                                PersistentDataType.INTEGER)];
                        meta = item.getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "locationX"),
                                PersistentDataType.DOUBLE, player.getLocation().getX());
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "locationY"),
                                PersistentDataType.DOUBLE, player.getLocation().getY());
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "locationZ"),
                                PersistentDataType.DOUBLE, player.getLocation().getZ());
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "world"),
                                PersistentDataType.STRING, player.getLocation().getWorld().getName());
                        item.setItemMeta(meta);
                        value.updateItem(plugin, item);
                        player.getInventory().addItem(item);
                        break;
                    case "Litch Scimitar":
                        litchScimitar(player);
                        break;
                    case "Stinger":
                        frenzy(player, event.getItem());
                        break;
                    case "Prosperous Grove":
                        prosperousGrove(player);
                        break;
                    case "Leaching Brambles":
                        vampireBrambles(player);
                        break;
                    case "Proliferating Sapling":
                        proliferatingSapling(player);
                        break;
                    case "Lashing Vines":
                        bindingVines(player);
                        break;
                    case "Pungent Herbs":
                        invigoratingFumes(player);
                        break;
                    case "Bush Suit":
                        blockHelmet(player, event.getItem());
                        break;
                    case "Stats Guide":
                    case "Monster Meat":
                    case "Cooked Monster Meat":
                        cancel = false;
                }
            }

            if (cancel) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Random ran = new Random();
        Player player = event.getEntity();
        if (items.get(player.getName()).contains("Death Charm") &&
            ran.nextInt(50) == 0 && player.getInventory().contains(Items.DEATH_CHARM.getItem(plugin))) {
            player.setHealth(20);

            player.sendMessage(ChatColor.GREEN + "Your charm brought you back from the brink of death");
            player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 80, 0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)/5);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 4, true, false));
            player.setInvulnerable(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.setInvulnerable(false);
                }
            }, 80);

        }

    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {

        if (event.getEntity() instanceof Player) {
            Player victim = (Player) event.getEntity();
            if (victim.isBlocking() &&
                victim.getCooldown(Material.SHIELD) == 0 &&
                victim.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD) > 0) {


                if (victim.getInventory().getItemInMainHand() != null &&
                    victim.getInventory().getItemInMainHand().getType() == Material.SHIELD &&
                    victim.getInventory().getItemInMainHand().getItemMeta() != null &&
                    victim.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
                    victim.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                    switch (victim.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Holy Shield":
                            if (event.getDamager() instanceof LivingEntity) {
                                LivingEntity attacker = ((LivingEntity) event.getDamager());

                                double defense = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                        PersistentDataType.DOUBLE) / 10;
                                attacker.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                                        240, 5, true, false));
                                attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                        PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                                PersistentDataType.DOUBLE) - defense);
                                if (attacker.hasPotionEffect(PotionEffectType.GLOWING) == false) {
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                        public void run() {
                                            attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                                    PersistentDataType.DOUBLE, defense + attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                                            PersistentDataType.DOUBLE));
                                        }
                                    }, 240L);
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }

                if (victim.getInventory().getItemInOffHand() != null &&
                    victim.getInventory().getItemInMainHand().getType() != Material.SHIELD &&
                    victim.getInventory().getItemInOffHand().getType() == Material.SHIELD &&
                    victim.getInventory().getItemInOffHand().getItemMeta() != null &&
                    victim.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
                    victim.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                    switch (victim.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Cactus Shield":
                            double damage = (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                                    PersistentDataType.DOUBLE) * 2);
                            if (event.getDamager().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) != null) {
                                double health = event.getDamager().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                        PersistentDataType.DOUBLE);
                                event.getDamager().getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                        PersistentDataType.DOUBLE, health - damage);
                                LivingEntity attacker = (LivingEntity) event.getDamager();
                                attacker.damage(1);
                            }
                            break;
                        case "Sparkling Shield":
                            if (event.getDamager() instanceof LivingEntity) {
                                LivingEntity attacker = ((LivingEntity) event.getDamager());
                                double time = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                                        PersistentDataType.DOUBLE) / 5;
                                int timeint = (int)time;
                                attacker.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                                        timeint, 5, true, false));
                                double attack = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                        PersistentDataType.DOUBLE) / 25;
                                attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                        PersistentDataType.DOUBLE, attack * 24);
                                attacker.getWorld().playSound(attacker.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 120, 0);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                    public void run() {
                                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                                PersistentDataType.DOUBLE, attack + attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                                        PersistentDataType.DOUBLE));
                                    }
                                }, timeint);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            if (victim.getInventory().getHelmet() != null &&
                victim.getInventory().getHelmet().getItemMeta() != null &&
                victim.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
                victim.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (victim.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Silverfish Helmet":
                        Random helmRandom = new Random();
                        int helmChoice = helmRandom.nextInt(21);
                        if (helmChoice == 20) {
                            mite(victim, 20, 1, "Flesh Larva", "FLESH_LARVA");
                        }
                        return;
                    default:
                        return;
                }
            }

            if (victim.getInventory().getChestplate() != null &&
                victim.getInventory().getChestplate().getItemMeta() != null &&
                victim.getInventory().getChestplate().getItemMeta().getPersistentDataContainer() != null &&
                victim.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (victim.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Silverfish Chestplate":
                        Random helmRandom = new Random();
                        int helmChoice = helmRandom.nextInt(21);
                        if (helmChoice == 20) {
                            mite(victim, 20, 1, "Flesh Larva", "FLESH_LARVA");
                        }
                        return;
                    default:
                        return;
                }
            }

            if (victim.getInventory().getLeggings() != null &&
                victim.getInventory().getLeggings().getItemMeta() != null &&
                victim.getInventory().getLeggings().getItemMeta().getPersistentDataContainer() != null &&
                victim.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (victim.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Silverfish Leggings":
                        Random helmRandom = new Random();
                        int helmChoice = helmRandom.nextInt(21);
                        if (helmChoice == 20) {
                            mite(victim, 20, 1, "Flesh Larva", "FLESH_LARVA");
                        }
                        return;
                    default:
                        return;
                }
            }

            if (victim.getInventory().getBoots() != null &&
                victim.getInventory().getBoots().getItemMeta() != null &&
                victim.getInventory().getBoots().getItemMeta().getPersistentDataContainer() != null &&
                victim.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (victim.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Silverfish Boots":
                        Random helmRandom = new Random();
                        int helmChoice = helmRandom.nextInt(21);
                        if (helmChoice == 20) {
                            mite(victim, 20, 1, "Flesh Larva", "FLESH_LARVA");
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_AIR) {
            if (event.getItem() != null) {
                Player player = event.getPlayer();
                if (event.getItem() != null &&
                        event.getItem().getItemMeta() != null &&
                        event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING) != null) {
                    switch (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Laser Drill X2085":
                            drill(player);
                            break;
                        default:
                            return;
                    }
                }
            }
        }

        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (event.getItem() != null) {
                Player player = event.getPlayer();
                if (event.getItem() != null &&
                        event.getItem().getItemMeta() != null &&
                        event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING) != null) {
                    switch (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Laser Drill X2085":
                            drill(player);
                            break;
                        case "Wood Cutters":
                            if (block.getType() == Material.OAK_LOG || block.getType() == Material.DARK_OAK_LOG ||
                                block.getType() == Material.SPRUCE_LOG || block.getType() == Material.BIRCH_LOG ||
                                block.getType() == Material.JUNGLE_LOG || block.getType() == Material.ACACIA_LOG ||
                                block.getType() == Material.WARPED_STEM || block.getType() == Material.CRIMSON_STEM ||
                                block.getType() == Material.OAK_WOOD || block.getType() == Material.DARK_OAK_WOOD ||
                                block.getType() == Material.SPRUCE_WOOD || block.getType() == Material.BIRCH_WOOD ||
                                block.getType() == Material.JUNGLE_WOOD || block.getType() == Material.ACACIA_WOOD ||
                                block.getType() == Material.WARPED_HYPHAE || block.getType() == Material.CRIMSON_HYPHAE ||
                                block.getType() == Material.STRIPPED_OAK_LOG || block.getType() == Material.STRIPPED_DARK_OAK_LOG ||
                                block.getType() == Material.STRIPPED_SPRUCE_LOG || block.getType() == Material.STRIPPED_BIRCH_LOG ||
                                block.getType() == Material.STRIPPED_JUNGLE_LOG || block.getType() == Material.STRIPPED_ACACIA_LOG ||
                                block.getType() == Material.STRIPPED_WARPED_STEM || block.getType() == Material.STRIPPED_CRIMSON_STEM ||
                                block.getType() == Material.STRIPPED_OAK_WOOD || block.getType() == Material.STRIPPED_DARK_OAK_WOOD ||
                                block.getType() == Material.STRIPPED_SPRUCE_WOOD || block.getType() == Material.STRIPPED_BIRCH_WOOD ||
                                block.getType() == Material.STRIPPED_JUNGLE_WOOD || block.getType() == Material.STRIPPED_ACACIA_WOOD ||
                                block.getType() == Material.STRIPPED_WARPED_HYPHAE || block.getType() == Material.STRIPPED_CRIMSON_HYPHAE ||
                                block.getType() == Material.BROWN_MUSHROOM_BLOCK || block.getType() == Material.RED_MUSHROOM_BLOCK ||
                                block.getType() == Material.MUSHROOM_STEM) {
                                block.breakNaturally();
                            }
                            break;
                    }
                }
            }
        }
    }


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (items.get(player.getName()).contains("Feather Charm")) {
            if (player.isSneaking()) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,
                        20, 0, true, false));
            }
        }

        //Drip and Supreme Drip particles
        if (player.getInventory().getBoots() != null &&
            player.getInventory().getBoots().getItemMeta() != null &&
            player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING) != null) {
            switch (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "The Drip":
                    if (player.getWorld().getEnvironment() == World.Environment.NETHER) {
                        player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 2);
                    }
                    if (player.getWorld().getEnvironment() == World.Environment.NORMAL) {
                        player.getWorld().spawnParticle(Particle.WATER_SPLASH, player.getLocation(), 2);
                    }
                    if (player.getWorld().getEnvironment() == World.Environment.THE_END) {
                        player.getWorld().spawnParticle(Particle.REVERSE_PORTAL, player.getLocation(), 2);
                    }
                    break;
                case "Supreme Drip™":
                    if (player.getWorld().getEnvironment() == World.Environment.NETHER) {
                        player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 5);
                    }
                    if (player.getWorld().getEnvironment() == World.Environment.NORMAL) {
                        player.getWorld().spawnParticle(Particle.WATER_SPLASH, player.getLocation(), 5);
                    }
                    if (player.getWorld().getEnvironment() == World.Environment.THE_END) {
                        player.getWorld().spawnParticle(Particle.REVERSE_PORTAL, player.getLocation(), 5);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @EventHandler
    public void onFish(PlayerFishEvent event) {

        Player player = event.getPlayer();
        if (event.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
            Entity entity = event.getCaught();
            if (player.getInventory().getItemInMainHand() != null &&
                player.getInventory().getItemInMainHand().getType() == Material.FISHING_ROD &&
                player.getInventory().getItemInMainHand().getItemMeta() != null &&
                player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Kinetic Rod":
                        event.getCaught().setVelocity(player.getLocation().getDirection().multiply(3));
                        break;
                    case "Dimensional Rod":
                        Location loc1 = event.getCaught().getLocation();
                        Location loc2 = player.getLocation();
                        event.getCaught().getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 6);
                        player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 2);

                        event.getCaught().teleport(loc2);
                        player.teleport(loc1);
                        break;
                    case "Scourge":
                        if (event.getHook().getHookedEntity() == null || event.getHook().getHookedEntity().isDead() || event.getHook().isDead()) {
                            return;
                        }

                        if (event.getHook().getHookedEntity() instanceof LivingEntity) {
                            ((LivingEntity)entity).addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                    80, 1, true, false));
                            event.getHook().getHookedEntity().getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                            PersistentDataType.DOUBLE) - (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                                            PersistentDataType.DOUBLE) * 0.4));
                            event.getHook().getHookedEntity().setCustomName(ChatColor.GOLD + "" + event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                                    PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                                    event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                            PersistentDataType.DOUBLE) + "/" + event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE));
                            if (event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) <= 1) {
                                ((LivingEntity)event.getHook().getHookedEntity()).setHealth(0);
                            }
                            event.setCancelled(true);
                        }
                        break;
                    default:
                        return;
                }
            }

            if (player.getInventory().getItemInOffHand() != null &&
                player.getInventory().getItemInOffHand().getType() == Material.FISHING_ROD &&
                player.getInventory().getItemInMainHand().getType() != Material.FISHING_ROD &&
                player.getInventory().getItemInOffHand().getItemMeta() != null &&
                player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {

                switch (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Kinetic Rod":
                        event.getCaught().setVelocity(player.getLocation().getDirection().multiply(4));
                        break;
                    case "Dimensional Rod":
                        Location loc1 = event.getCaught().getLocation();
                        Location loc2 = player.getLocation();

                        event.getCaught().teleport(loc2);
                        player.teleport(loc1);
                        break;
                    case "Scourge":
                        if (event.getHook().getHookedEntity() == null || event.getHook().getHookedEntity().isDead() || event.getHook().isDead()) {
                            return;
                        }

                        if (event.getHook().getHookedEntity() instanceof LivingEntity) {
                            ((LivingEntity)entity).addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                    80, 1, true, false));
                            event.getHook().getHookedEntity().getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                            PersistentDataType.DOUBLE) - (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                                            PersistentDataType.DOUBLE) * 0.4));
                            event.getHook().getHookedEntity().setCustomName(ChatColor.GOLD + "" + event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                                PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                                    event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE) + "/" + event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                PersistentDataType.DOUBLE));
                            if (event.getHook().getHookedEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) <= 1) {
                                ((LivingEntity)event.getHook().getHookedEntity()).setHealth(0);
                            }
                            event.setCancelled(true);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }


    @EventHandler
    public void onRes(EntityResurrectEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        Player player = event.getPlayer();
        echo_ward.put(player.getName(), player.getLocation());
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();

        block.setMetadata("placed", new FixedMetadataValue(plugin, true));
    }

    @EventHandler
    public void onGrow(BlockGrowEvent event) {
        Block block = event.getBlock();

        block.removeMetadata("placed", plugin);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        echo_ward.put(player.getName(), player.getLocation());
    }

    @EventHandler
    public void onEffect(EntityPotionEffectEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity();
        if (event.getAction() == EntityPotionEffectEvent.Action.ADDED) {
            if (player.getInventory().getHelmet() != null &&
                player.getInventory().getHelmet().getItemMeta() != null &&
                player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer() != null &&
                player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Heavenly Snail":
                        if (event.getModifiedType().equals(PotionEffectType.POISON) ||
                            event.getModifiedType().equals(PotionEffectType.WITHER) ||
                            event.getModifiedType().equals(PotionEffectType.SLOW_DIGGING) ||
                            event.getModifiedType().equals(PotionEffectType.HUNGER) ||
                            event.getModifiedType().equals(PotionEffectType.BLINDNESS) ||
                            event.getModifiedType().equals(PotionEffectType.CONFUSION)) {
                            event.setCancelled(true);
                        }
                        break;
                }
            }
        }
    }
    @EventHandler
    public void onPlayerBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Random ran = new Random();

        Location location = new Location(block.getWorld(), block.getLocation().getX() + 0.5,block.getLocation().getY() + 0.5 ,block.getLocation().getZ() + 0.5);
        List<Entity> list = (List<Entity>) location.getWorld().getNearbyEntities(location, 0.1, 0.1, 0.1);
        if (list.isEmpty() != true &&
                list.get(0) instanceof Shulker &&
                list.get(0).getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null &&
                list.get(0).getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) == "block") {
            list.get(0).remove();
        }
        location = block.getLocation();

        if (player.getInventory().getItemInMainHand() != null) {
            if (player.getInventory().getItemInMainHand() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta() != null &&
                    player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                switch (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Chain Pickaxe":
                        superPick(player, block);
                        break;
                    default:
                        return;
                }
            }
        }

        if (block != null) {
            if (block.getBlockData() instanceof Ageable) {
                final Material mat;
                final Material type;
                type = block.getType();
                org.bukkit.block.data.Ageable age = (Ageable) block.getBlockData();
                switch (block.getType()) {
                    case WHEAT:
                        mat = Material.WHEAT_SEEDS;
                        break;
                    case POTATOES:
                        mat = Material.POTATO;
                        break;
                    case CARROTS:
                        mat = Material.CARROT;
                        break;
                    case BEETROOTS:
                        mat = Material.BEETROOT_SEEDS;
                        break;
                    case NETHER_WART:
                        mat = Material.NETHER_WART;
                        break;
                    case SWEET_BERRY_BUSH:
                        mat = Material.SWEET_BERRIES;
                        break;
                    case COCOA:
                        mat = Material.COCOA_BEANS;
                        break;
                    default:
                        return;
                }

                if (age.getAge() == age.getMaximumAge() && player.getInventory().contains(mat) &&
                        player.getInventory().contains(Items.SOWERS_WILL.getItem(plugin))) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            int slot = 0;
                            for (int i = 0; i < 36; ++i) {
                                if (player.getInventory().getItem(i) != null) {
                                    if (player.getInventory().getItem(i).getType() == mat) {
                                        slot = i;
                                        break;
                                    }
                                }
                            }
                            ItemStack item = player.getInventory().getItem(slot);
                            if (item.getAmount() > 1) item.setAmount(item.getAmount() - 1);
                            else item = new ItemStack(Material.AIR);
                            player.getInventory().setItem(slot, item);
                            block.getLocation().getBlock().setType(type);
                        }
                    }, 20L);
                }
            }

            if (block.getType() == Material.WHEAT || block.getType() == Material.CARROTS ||
                block.getType() == Material.POTATOES || block.getType() == Material.BEETROOTS ||
                block.getType() == Material.COCOA || block.getType() == Material.PUMPKIN ||
                block.getType() == Material.MELON || block.getType() == Material.NETHER_WART ) {
                int choice = ran.nextInt(1000) + 1;

                if ((ran.nextInt(1000) + 1) * ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcavatingFortune"),
                        PersistentDataType.DOUBLE)/100) + 1) >= 1000) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " got a tomato!");
                    player.getInventory().addItem(Items.TOMATO.getItem(plugin));
                }
            }
        }
    }
}