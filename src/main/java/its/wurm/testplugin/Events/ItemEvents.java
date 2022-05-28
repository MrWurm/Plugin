package its.wurm.testplugin.Events;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Inventories.AnvilGUI;
import its.wurm.testplugin.Inventories.BrewingStandGUI;
import its.wurm.testplugin.Inventories.FormatSackGUI;
import its.wurm.testplugin.Inventories.SacksGUI;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.persistentDataContainers.stringList;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.apache.commons.lang.ArrayUtils;
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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

public class ItemEvents implements Listener {

    Plugin plugin;
    SkillEvents skills;
    Attacks attacks;
    StatFunctions functions;

    public ItemEvents(Plugin plugin, SkillEvents skills) {
        this.plugin = plugin;
        this.skills = skills;
        this.attacks = new Attacks(plugin);
        this.functions = new StatFunctions(plugin, attacks);
        new BukkitRunnable() {
            public void run()
            {
                pets = functions.getPets();
            }
        }.runTaskTimer(plugin, 1, 40);
    }

    Map<Player, List<String>> itemName = new HashMap<>();
    Map<Player, List<ItemStack>> items = new HashMap<>();
    static Map<Player, ItemStack> pets = new HashMap<>();
    static Map<Player, ArmorStand> stand = new HashMap<>();

    Map<Player, Long> cooldown_shortbow = new HashMap<>();
    Map<Player, Long> cooldown_sticky = new HashMap<>();
    Map<Player, Long> cooldown_heal = new HashMap<>();
    Map<Player, Long> cooldown_rift = new HashMap<>();
    Map<Player, Long> cooldown_scan = new HashMap<>();
    Map<Player, Long> cooldown_echo = new HashMap<>();
    Map<Player, Long> cooldown_grapple = new HashMap<>();
    Map<Player, Long> cooldown_lasso = new HashMap<>();
    Map<Player, Long> cooldown_hunt = new HashMap<>();
    Map<Player, Long> cooldown_stinger = new HashMap<>();
    Map<Player, Long> cooldown_mite_wand = new HashMap<>();
    Map<Player, Location> echo_ward = new HashMap<>();
    Map<Player, Long> cooldown_forest = new HashMap<>();
    Map<Player, Long> cooldown_staff = new HashMap<>();
    Map<Location, BrewingStandGUI> brewingstands = new HashMap<>();
    Random random = new Random();

    public void workBenchGUI(Player player) {
        player.openWorkbench(null, true);

    }

    public List<Object> returnMaps() {
        List<Object> list = new ArrayList<>();
        list.add(brewingstands);
        return list;
    }
    public void simulateBreak(Block block, Player player) {
        skills.doubleDrop(player, block);
        skills.blockXp(block, player);
    }

    public double magicScale(double base, Player player) {
        return (1 + (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Thaumaturgy"),
                PersistentDataType.DOUBLE) * 0.05)) * base;
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
        echo_ward.put(player, location);
    }

    public void warpNether(Player player) {
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)) {
            player.sendMessage(ChatColor.RED + "You cannot fast travel while injured");
        }

        Location location = new Location(Bukkit.getWorld("world_the_nether"), 0, 100, 0);

        player.teleport(location);
        echo_ward.put(player, location);
    }

    public boolean applySack(ItemStack item, Player player, int index, String current, String requirement, List<String> types, boolean first, int upgrade, boolean addition) {
        String[] sacks = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sacksUnlocked"),
                new stringList());
        String[] materials = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMaterial"),
                new stringList());
        int[] max = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMax"),
                PersistentDataType.INTEGER_ARRAY);
        int[] amount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackAmount"),
                PersistentDataType.INTEGER_ARRAY);
        if (sacks[index].contains(requirement)) {
            if (addition) {
                sacks[index] = sacks[index] + current;
            } else {
                sacks[index] = current;
            }
            if (first) {
                materials = Arrays.copyOf(materials, materials.length + types.size());
                max = Arrays.copyOf(max, max.length + types.size());
                amount = Arrays.copyOf(amount, amount.length + types.size());
                for (int i = 0; i < types.size(); i++) {
                    materials[materials.length - (i + 1)] = types.get(i);
                    max[max.length - (i + 1)] = upgrade;
                    amount[amount.length - (i + 1)] = 0;
                }
            } else {
                for (int i = 0; i < materials.length; i++) {
                    if (addition) {
                        max[i] += upgrade;
                    } else {
                        max[i] = upgrade;
                    }
                }
            }
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_FRAME_REMOVE_ITEM, 40, 1);
            item.setAmount(item.getAmount() - 1);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sacksUnlocked"),
                    new stringList(), sacks);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackMaterial"),
                    new stringList(), materials);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackMax"),
                    PersistentDataType.INTEGER_ARRAY, max);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackAmount"),
                    PersistentDataType.INTEGER_ARRAY, amount);
            return true;
        } else {
            player.sendMessage(ChatColor.RED + "Invalid upgrade");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return false;
        }
    }

    public void warpEnd(Player player) {
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)) {
            player.sendMessage(ChatColor.RED + "You cannot fast travel while injured");
        }

        Location location = new Location(Bukkit.getWorld("world_the_end"), 0.5, 65, 0.5);

        player.teleport(location);
        echo_ward.put(player, location);
    }

    public void tntWand(Player player, boolean main) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double damage = 10;
        double cost = 50;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        damage = magicScale(damage,  player);
        attacks.createTnt(player.getEyeLocation(), damage, 70, player, player.getLocation().getDirection().multiply(2));
        player.sendMessage(ChatColor.GREEN + "Used Tnt Hurl");
    }



    public void clusterBomb(Player player, boolean main) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double damage = 250;
        double cost = 90;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        damage = magicScale(damage, player);
        ItemStack item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWIyMGZmMTczYmQxN2IyYzRmMmViMjFmM2M0YjQzODQxYTE0YjMxZGZiZmQzNTRhM2JlYzgyNjNhZjU2MmIifX19");
        ArmorStand primary = player.getEyeLocation().getWorld().spawn(player.getEyeLocation(), ArmorStand.class);
        primary.setInvulnerable(true);
        primary.setInvisible(true);
        primary.getEquipment().setHelmet(item);
        List<String> targets = new ArrayList<>();
        targets.add("mob");
        targets.add("boss");
        targets.add("animal");
        primary.setVelocity(player.getEyeLocation().getDirection().multiply(2.1));
        double finalDamage = damage;
        new BukkitRunnable() {
            public void run()
            {
                if (primary.isDead()) {
                    this.cancel();
                    return;
                }
                if (primary.isOnGround() ||
                    functions.findEntity(primary.getLocation(), .2) != null) {
                    attacks.createExplosion(primary.getLocation(), finalDamage, 4f, false, false, player);
                    for (int i = 0; i < 3; i++) {
                        Random random = new Random();
                        ArmorStand sub = primary.getEyeLocation().getWorld().spawn(primary.getEyeLocation(), ArmorStand.class);
                        sub.setInvulnerable(true);
                        sub.setSmall(true);
                        sub.setInvisible(true);
                        sub.getEquipment().setHelmet(item);
                        sub.setVelocity(primary.getLocation().getDirection().multiply(1.4).rotateAroundX(random.nextInt(360)));
                        new BukkitRunnable() {
                            public void run()
                            {
                                if (sub.isDead()) {
                                    this.cancel();
                                    return;
                                }
                                if (sub.isOnGround() ||
                                    functions.findEntity(sub.getLocation(), .25) != null) {
                                    attacks.createExplosion(sub.getLocation(), finalDamage * .4, 1.6f, false, false, player);
                                    sub.remove();
                                }
                            }
                        }.runTaskTimer(plugin, 25, 4);
                    }
                    primary.remove();
                }
            }
        }.runTaskTimer(plugin, 0, 4);

        player.sendMessage(ChatColor.GREEN + "Used Cluster Bomb");
    }

    public void superMeal(Block block, BlockFace face) {
        if (block.getBlockData() instanceof Ageable) {
            Ageable data = ((Ageable)block.getBlockData());
            data.setAge(data.getMaximumAge());
            block.setBlockData(data);
            return;
        }
        if (block.getBlockData() instanceof Sapling) {
            Sapling data = ((Sapling)block.getBlockData());
            data.setStage(data.getMaximumStage());
            block.setBlockData(data);
            return;
        }
        block.applyBoneMeal(face);
    }

    public void rift(Player player, boolean main) {

        if (cooldown_rift.containsKey(player)) {
            if (cooldown_rift.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_rift.get(player) - System.currentTimeMillis()) / 1000;
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

        List<Double> apply = functions.reforgeOnCast(player, plugin, magic, cooldown, cost, main);
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
        cooldown_rift.put(player, System.currentTimeMillis() + ((long)cooldown * 1000));

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

    public void miteWand (Player player, boolean main) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double cooldown = 10;
        double cost = 120;
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, cooldown, cost, main);
        cooldown /= apply.get(2);
        cost *= apply.get(1);
        if (cooldown_mite_wand.containsKey(player)) {
            if (cooldown_mite_wand.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_mite_wand.get(player) - System.currentTimeMillis()) / 1000;
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
        cooldown_mite_wand.put(player, System.currentTimeMillis() + ((long)cooldown * 1000));
    }

    public void stickyBomb(Player player, boolean main) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double cooldown = 5;
        double damage = 2700;
        double cost = 200;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, cooldown, cost, main);
        cooldown /= apply.get(2);
        cost *= apply.get(1);
        if (cooldown_sticky.containsKey(player)) {
            if (cooldown_sticky.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_sticky.get(player) - System.currentTimeMillis()) / 1000;
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

        Snowball snowball = attacks.createSnowball(player.getEyeLocation(), damage * .05,
            player, player.getLocation().getDirection().multiply(1.6), "STICKY_BOMB", Material.SLIME_SPAWN_EGG);
        attacks.track(snowball, player, 0.5, 0.8);

        new BukkitRunnable() {
            Snowball projectile = snowball;
            int iterations = 0;
            Entity target = null;
            float offset = (random.nextInt(9) + -4)/10;
            public void run()
            {
                iterations += 1;
                if (projectile.isDead() || iterations >= 15) {
                    attacks.createExplosion(projectile.getLocation(), projectile.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE) * 20, 11f, false, false, player);
                    projectile.remove();
                    this.cancel();
                    return;
                }
                if (target != null) {
                    projectile.teleport(new Location(target.getWorld(), target.getLocation().getX() + offset,
                        target.getLocation().getY() + 0.5, target.getLocation().getZ() + offset));
                } else {
                    if (functions.findEntityExcept(projectile.getLocation(), 1, new ArrayList<>(Arrays.asList("adventurer"))) != null) {
                        target = functions.findEntityExcept(projectile.getLocation(), 1, new ArrayList<>(Arrays.asList("adventurer")));
                        projectile.setGravity(false);
                    }
                }
            }
        }.runTaskTimer(plugin, 12, 4);

        player.sendMessage(ChatColor.GREEN + "Used Sticky Bomb");
        cooldown_sticky.put(player, System.currentTimeMillis() + ((long)cooldown * 1000));

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

    public void pufferCanon(Player player, boolean main) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double damage = 25;
        double cost = 25;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);

        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        damage = magicScale(damage, player);
        attacks.createPuffer(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(3));
        player.sendMessage(ChatColor.GREEN + "Used Puffer Projectile");
    }

    public void prosperousGrove(Player player, boolean main) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120, main);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player)) {
            if (cooldown_forest.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player) - System.currentTimeMillis()) / 1000;
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

        cooldown_forest.put(player, System.currentTimeMillis() + (cooldown * 1000));
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

    public void vampireBrambles(Player player, boolean main) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120, main);
        double cost = apply.get(1) * 120;
        double damage = apply.get(0) * 25;
        damage = magicScale(damage, player);
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player)) {
            if (cooldown_forest.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player) - System.currentTimeMillis()) / 1000;
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

        cooldown_forest.put(player, System.currentTimeMillis() + (cooldown * 1000));
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

    public void proliferatingSapling(Player player, boolean main) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120, main);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player)) {
            if (cooldown_forest.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player) - System.currentTimeMillis()) / 1000;
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

        cooldown_forest.put(player, System.currentTimeMillis() + (cooldown * 1000));
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

    public void bindingVines(Player player, boolean main) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120, main);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player)) {
            if (cooldown_forest.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player) - System.currentTimeMillis()) / 1000;
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

        cooldown_forest.put(player, System.currentTimeMillis() + (cooldown * 1000));
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

    public void invigoratingFumes(Player player, boolean main) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 18, 120, main);
        double cost = apply.get(1) * 120;
        long cooldown = Math.round(apply.get(2) * 18);
        if (cooldown_forest.containsKey(player)) {
            if (cooldown_forest.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_forest.get(player) - System.currentTimeMillis()) / 1000;
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

        cooldown_forest.put(player, System.currentTimeMillis() + (cooldown * 1000));
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

    public void litchScimitar(Player player, boolean main) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        double damage = 40;
        double cost = 75;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);

        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        damage = magicScale(damage, player);
        attacks.track(attacks.createSkull(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(0.7), "", false), player, 3, 0.7);
        player.sendMessage(ChatColor.GREEN + "Used Oppressing Skull");
    }

    public void shortArrow(Player player, double velocity, String id, int pierce, long time) {
        if (cooldown_shortbow.containsKey(player)) {
            if (cooldown_shortbow.get(player) > System.currentTimeMillis()) {
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
        List<Object> list = functions.reforgeOnShoot(player, plugin, velocity, iscrit, time, true);
        damage *= (Double) list.get(0);
        velocity *= (Double) list.get(1);
        double mod = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "AttackSpeed"),
                PersistentDataType.DOUBLE)/200);
        if (mod > 0) {
            time = Math.round(((time * (Double)list.get(3))) * ((mod * -1) + 1));
        } else {
            time = Math.round(((time * (Double)list.get(3))) / (mod + 1));
        }
        cooldown_shortbow.put(player, System.currentTimeMillis() + (time));
        Arrow arrow = attacks.createArrow(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(velocity), id, pierce);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"),
                PersistentDataType.STRING, (String) list.get(2));
        functions.arrowChanges(player, plugin, arrow, true, velocity);

    }

    public void shortArrow(Player player, double velocity, String id, int pierce, long time, Color color) {
        if (cooldown_shortbow.containsKey(player)) {
            if (cooldown_shortbow.get(player) > System.currentTimeMillis()) {
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

        List<Object> list = functions.reforgeOnShoot(player, plugin, velocity, iscrit, time, true);
        damage *= (Double) list.get(0);
        velocity *= (Double) list.get(1);
        time = Math.round((time * (Double)list.get(3)));
        cooldown_shortbow.put(player, System.currentTimeMillis() + (time));
        Arrow arrow = attacks.createArrow(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(velocity), id, pierce, color);
        functions.arrowChanges(player, plugin, arrow, true, velocity);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "reforge"),
                PersistentDataType.STRING, (String) list.get(2));
    }

    public void heal(Player player, long cooldown, double heal, int cost, String ability, boolean main) {
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 0, cost, main);
        cost *= apply.get(1);
        cooldown /= apply.get(2);
        if (cooldown_heal.containsKey(player)) {
            if (cooldown_heal.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_heal.get(player) - System.currentTimeMillis()) / 1000;
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

        cooldown_heal.put(player, System.currentTimeMillis() + (cooldown * 1000));
        functions.heal(plugin, player, heal);
        player.sendMessage(ChatColor.GREEN + "Used " + ability);
    }

    public void grapple(Player player) {
        if (cooldown_grapple.containsKey(player)) {
            if (cooldown_grapple.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_grapple.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        cooldown_grapple.put(player, System.currentTimeMillis() + (2 * 1000));
        player.setVelocity(player.getLocation().getDirection().multiply(3));
        player.sendMessage(ChatColor.GREEN + "Used Grapple");
    }

    public void quarterstaffPush(Player player) {
        if (cooldown_staff.containsKey(player)) {
            if (cooldown_staff.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_staff.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, 5);

        Location loc = player.getLocation();
        List<Entity> exclude = new ArrayList<>();
        exclude.add(player);
        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid() || functions.findEntity(loc, 0.35, exclude) != null) {
                if (functions.findEntity(loc, 0.35, exclude) != null) {
                    functions.findEntity(loc, 0.35, exclude).setVelocity(player.getLocation().getDirection().multiply(1.7));
                }
                player.sendMessage(ChatColor.GREEN + "Used Push");
                cooldown_staff.put(player, System.currentTimeMillis() + (3 * 500));
                return;
            }
        }

        player.sendMessage(ChatColor.GREEN + "Used Push");
        cooldown_staff.put(player, System.currentTimeMillis() + (3 * 500));
    }

    public void frenzy(Player player, ItemStack item, boolean main) {
        if (cooldown_stinger.containsKey(player)) {
            if (cooldown_stinger.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_stinger.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double cost = 80;
        long cooldown = 32000;

        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 0, cost, main);
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

        cooldown_stinger.put(player, System.currentTimeMillis() + (32 * 1000));
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);
        player.sendMessage(ChatColor.GREEN + "Used Frenzy");
    }

    public void hunt(Player player) {
        if (cooldown_hunt.containsKey(player)) {
            if (cooldown_hunt.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_hunt.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        List<Entity> collection = player.getNearbyEntities(35, 35, 35);

        cooldown_hunt.put(player, System.currentTimeMillis() + (20 * 1000));
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) instanceof LivingEntity &&
                (collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING) == null ||
                !(collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING).equals("adventurer")))) {
                ((LivingEntity)collection.get(i)).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                        240, 0));
            }
        }
        player.sendMessage(ChatColor.GREEN + "Used Find Prey");
    }

    public void scan(Player player, String string, List<Material> sort, int range, int cooldown) {
        if (cooldown_scan.containsKey(player)) {
            if (cooldown_scan.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_scan.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        cooldown_scan.put(player, System.currentTimeMillis() + (cooldown * 1000));
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
        if (cooldown_echo.containsKey(player)) {
            if (cooldown_echo.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_echo.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        if (player.getLocation().distanceSquared(echo_ward.get(player)) > 120 * 120) {
            player.sendMessage(ChatColor.RED + "Your ward is too far away to teleport to!");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
        player.teleport(echo_ward.get(player));
        player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 2);
        player.sendMessage(ChatColor.GREEN + "Used Echo");
        cooldown_echo.put(player, System.currentTimeMillis() + (3 * 1000));
    }

    public void telport(Player player, int distance, int cost, String ability, boolean main) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);

        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 0, cost, main);
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
        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, distance);

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
                    simulateBreak(loc.getBlock(), player);
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

    public void plantAxe(Player player, Block block, boolean main) {

        if (block.getBlockData() instanceof Sapling) {
            return;
        }

        ItemStack item = player.getInventory().getItemInMainHand();
        if (main == false) {
            item = player.getInventory().getItemInOffHand();
        }
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double cost = 40;
        List<Double> apply = functions.reforgeOnCast(player, plugin, 0, 0, cost, main);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        Block location = block.getWorld().getBlockAt(new Location(block.getWorld(), block.getX(), block.getY() + 1, block.getZ()));
        if (!(block.getType() == Material.DIRT ||
            block.getType() == Material.FARMLAND ||
            block.getType() == Material.GRASS_BLOCK ||
            block.getType() == Material.COARSE_DIRT ||
            block.getType() == Material.ROOTED_DIRT ||
            block.getType() == Material.MOSS_BLOCK) ||
            location.getType().isSolid()) {
            player.sendMessage(ChatColor.RED + "You can not place a sapling here!");
            return;
        }

        switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin,"material"),
                PersistentDataType.STRING)) {
            case "oak":
                location.setType(Material.OAK_SAPLING);
                player.sendMessage(ChatColor.GREEN + "Used Replant");
                break;
            case "dark oak":
                location.setType(Material.DARK_OAK_SAPLING);
                player.sendMessage(ChatColor.GREEN + "Used Replant");
                break;
            case "acacia":
                location.setType(Material.ACACIA_SAPLING);
                player.sendMessage(ChatColor.GREEN + "Used Replant");
                break;
            case "birch":
                location.setType(Material.BIRCH_SAPLING);
                player.sendMessage(ChatColor.GREEN + "Used Replant");
                break;
            case "spruce":
                location.setType(Material.SPRUCE_SAPLING);
                player.sendMessage(ChatColor.GREEN + "Used Replant");
                break;
            case "jungle":
                location.setType(Material.JUNGLE_SAPLING);
                player.sendMessage(ChatColor.GREEN + "Used Replant");
                break;
            default:
                player.sendMessage(ChatColor.RED + "You need to have broken wood with this axe to plant a sapling!");
                return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
            PersistentDataType.DOUBLE) - cost);
    }

    public void breakAdjacent(Player player, Block block) {
        List<Block> adjacent = new ArrayList<>();
        adjacent.add(new Location(block.getWorld(), block.getX() + 1, block.getY(), block.getZ()).getBlock());
        adjacent.add(new Location(block.getWorld(), block.getX() - 1, block.getY(), block.getZ()).getBlock());
        adjacent.add(new Location(block.getWorld(), block.getX(), block.getY() + 1, block.getZ()).getBlock());
        adjacent.add(new Location(block.getWorld(), block.getX(), block.getY() - 1, block.getZ()).getBlock());
        adjacent.add(new Location(block.getWorld(), block.getX(), block.getY(), block.getZ() + 1).getBlock());
        adjacent.add(new Location(block.getWorld(), block.getX(), block.getY(), block.getZ() - 1).getBlock());
        for (int i = 0; i < adjacent.size(); i++) {
            if (adjacent.get(i).getType() == Material.OAK_LOG ||
                adjacent.get(i).getType() == Material.DARK_OAK_LOG ||
                adjacent.get(i).getType() == Material.BIRCH_LOG ||
                adjacent.get(i).getType() == Material.ACACIA_LOG ||
                adjacent.get(i).getType() == Material.SPRUCE_LOG ||
                adjacent.get(i).getType() == Material.JUNGLE_LOG ||
                adjacent.get(i).getType() == Material.WARPED_STEM ||
                adjacent.get(i).getType() == Material.CRIMSON_STEM) {
                simulateBreak(adjacent.get(i), player);
                adjacent.get(i).breakNaturally();
            }
        }
    }

    public void corrosivePick(Player player, Block block) {
        if (block.getType() == Material.BEDROCK ||
            block.getType() == Material.BARRIER ||
            block.getType() == Material.END_PORTAL_FRAME ||
            block.getType() == Material.END_PORTAL ||
            block.getType() == Material.NETHER_PORTAL ||
            block.getType() == Material.COMMAND_BLOCK ||
            block.getType() == Material.CHAIN_COMMAND_BLOCK ||
            block.getType() == Material.REPEATING_COMMAND_BLOCK) {
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,
                1, 0, true, false));
        float time = (1 /block.getBreakSpeed(player)) * 1.5f;
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (block.getWorld().getBlockAt(block.getLocation()).equals(block)) {
                    simulateBreak(block, player);
                    block.breakNaturally();
                }
            }
        }, (long)time);
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
                        simulateBreak(loc.getBlock(), player);
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
                        simulateBreak(loc.getBlock(), player);
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
                        simulateBreak(loc.getBlock(), player);
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
                        simulateBreak(loc.getBlock(), player);
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
                        simulateBreak(loc.getBlock(), player);
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
                        simulateBreak(loc.getBlock(), player);
                        loc.getBlock().breakNaturally(tool);
                    }
                    loc = new Location(Bukkit.getWorld("world"), loc.getX() - 1 ,loc.getY(), loc.getZ());
                }
                break;
        }
    }

    public void reachAttack(Player player, int range) {

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, range);

        Location loc = player.getLocation();
        List<Entity> entities = new ArrayList<>();
        entities.add(player);

        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid() || functions.findEntity(loc, 0.2, entities) != null) {
                if(functions.findEntity(loc, 0.2, entities) != null) {
                    player.attack(functions.findEntity(loc, 0.2, entities));
                }
                return;
            }
        }
        if (functions.findEntity(loc, 0.2, entities) != null) {
            player.attack(functions.findEntity(loc, 0.2, entities));
        }
    }

    public void pierceAttack(Player player, int range, int pierce) {

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, range);

        Location loc = player.getLocation();
        List<Entity> entities = new ArrayList<>();
        entities.add(player);
        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid() || (functions.findEntity(loc, 0.2, entities) != null)) {
                if (functions.findEntity(loc, 0.2, entities) != null) {
                    player.attack(functions.findEntity(loc, 0.2, entities));
                    pierce -= 1;
                    if (pierce == 0) {
                        return;
                    }
                }
            }
        }
        if (functions.findEntity(loc, 0.2, entities) != null) {
            player.attack(functions.findEntity(loc, 0.2, entities));
        }
    }

    public void lassoBasic(Player player) {
        if (cooldown_lasso.containsKey(player)) {
            if (cooldown_lasso.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_lasso.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, 12);
        Villager stand = player.getLocation().getWorld().spawn(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 2, player.getLocation().getZ()), Villager.class);
        stand.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                999999999, 0, true, false));
        stand.setCollidable(false);
        stand.setAI(false);
        stand.setSilent(true);
        stand.setInvulnerable(true);
        stand.setGravity(false);
        stand.setLeashHolder(player);
        List<Entity> exclude = new ArrayList<>();
        exclude.add(player);
        exclude.add(stand);
        new BukkitRunnable() {
            Location loc = player.getLocation();
            public void run()
            {
                if (blocksToAdd.hasNext()) {
                    loc = blocksToAdd.next().getLocation();
                    stand.teleport(loc);
                    if (loc.getBlock().getType().isSolid() || functions.findEntity(loc, 0.4, exclude) != null) {
                        if (functions.findEntity(loc, 0.4, exclude) != null) {
                            functions.findEntity(loc, 0.4, exclude).setLeashHolder(player);
                            new BukkitRunnable() {
                                LivingEntity target = functions.findEntity(loc, 0.4, exclude);
                                public void run()
                                {
                                    if (player.getLocation().distance(target.getLocation()) <= 2) {
                                        target.setLeashHolder(null);
                                        this.cancel();
                                        return;
                                    }
                                    target.setLeashHolder(player);
                                    target.setVelocity(new Vector(player.getEyeLocation().getX() - target.getEyeLocation().getX(), player.getEyeLocation().getY() - target.getEyeLocation().getY(), player.getEyeLocation().getZ() - target.getEyeLocation().getZ()).normalize().multiply(0.7));
                                }
                            }.runTaskTimer(plugin, 2, 1);
                            stand.remove();
                            this.cancel();
                            return;
                        }
                    }
                } else {
                    if (functions.findEntity(loc, 0.4, exclude) != null) {
                        functions.findEntity(loc, 0.4, exclude).setLeashHolder(player);
                        new BukkitRunnable() {
                            LivingEntity target = functions.findEntity(loc, 0.4, exclude);
                            public void run()
                            {
                                if (player.getLocation().distance(target.getLocation()) <= 2) {
                                    target.setLeashHolder(null);
                                    this.cancel();
                                    return;
                                }
                                target.setVelocity(new Vector(player.getEyeLocation().getX() - target.getEyeLocation().getX(), player.getEyeLocation().getY() - target.getEyeLocation().getY(), player.getEyeLocation().getZ() - target.getEyeLocation().getZ()).normalize().multiply(0.7));
                            }
                        }.runTaskTimer(plugin, 2, 1);

                    }
                    stand.teleport(loc);
                    stand.remove();
                    this.cancel();
                    return;
                }
            }
        }.runTaskTimer(plugin, 0, 1);
        cooldown_lasso.put(player, System.currentTimeMillis() + (4 * 1000));
        player.sendMessage(ChatColor.GREEN + "Used Lasso");
    }

    public void lassoAdvanced(Player player) {
        if (cooldown_lasso.containsKey(player)) {
            if (cooldown_lasso.get(player) > System.currentTimeMillis()) {
                long timeleft = (cooldown_lasso.get(player) - System.currentTimeMillis()) / 1000;
                player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
                return;
            }
        }

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, 12);
        Villager stand = player.getLocation().getWorld().spawn(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 2 , player.getLocation().getZ()), Villager.class);
        stand.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                999999999, 0, true, false));
        stand.setCollidable(false);
        stand.setAI(false);
        stand.setSilent(true);
        stand.setInvulnerable(true);
        stand.setGravity(false);
        stand.setLeashHolder(player);
        List<Entity> exclude = new ArrayList<>();
        exclude.add(player);
        exclude.add(stand);
        new BukkitRunnable() {
            Location loc = player.getLocation();
            List<Entity> entities = new ArrayList<>();
            public void run()
            {
                if (blocksToAdd.hasNext()) {
                    loc = blocksToAdd.next().getLocation();
                    stand.teleport(loc);
                    if (loc.getBlock().getType().isSolid() || functions.findEntity(loc, 1, exclude) != null) {
                        if (functions.findEntity(loc, 1, exclude) != null) {
                            entities.add(functions.findEntity(loc, 1, exclude));
                        }
                    }
                } else {
                    if (functions.findEntity(loc, 1, exclude) != null) {
                        functions.findEntity(loc, 1, exclude).setLeashHolder(player);
                        for (int i = 0; i < entities.size(); i++) {
                            LivingEntity target1 = (LivingEntity)entities.get(i);
                            new BukkitRunnable() {
                                public void run() {
                                    if (player.getLocation().distance(target1.getLocation()) <= 2) {
                                        target1.setLeashHolder(null);
                                        this.cancel();
                                        return;
                                    }
                                    target1.setVelocity(new Vector(player.getEyeLocation().getX() - target1.getEyeLocation().getX(), player.getEyeLocation().getY() - target1.getEyeLocation().getY(), player.getEyeLocation().getZ() - target1.getEyeLocation().getZ()).normalize().multiply(0.7));
                                }
                            }.runTaskTimer(plugin, 2, 1);
                        }
                    }
                    stand.teleport(loc);
                    stand.remove();
                    this.cancel();
                    return;
                }
            }
        }.runTaskTimer(plugin, 0, 1);
        cooldown_lasso.put(player, System.currentTimeMillis() + (6 * 1000));
        player.sendMessage(ChatColor.GREEN + "Used Hooked Lasso");
    }


    public void lightningWand(Player player, boolean main) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 10;
        double cost = 45;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, 60);

        Location loc = player.getLocation();

        damage = magicScale(damage, player);
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

    public void sandWand(Player player, boolean main) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 50;
        double cost = 40;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, 12);

        Location loc = player.getLocation();

        damage = magicScale(damage, player);
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

    public void duneWand(Player player, boolean main) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 120;
        double cost = 150;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, 15);

        Location loc = player.getLocation();

        damage = magicScale(damage, player);
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

    public void prismaticWand(Player player, boolean main) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double damage = 90;
        double cost = 210;
        List<Double> apply = functions.reforgeOnCast(player, plugin, damage, 0, cost, main);
        damage *= apply.get(0);
        cost *= apply.get(1);
        if (mana < cost) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - cost);

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 0.5, 12);

        Location loc = player.getLocation();
        damage = magicScale(damage, player);
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
    public void onEdit(PlayerEditBookEvent event) {
        Player player = event.getPlayer();
        BookMeta meta = event.getNewBookMeta();
        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "bookType"), PersistentDataType.STRING) != null) {
            switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "bookType"), PersistentDataType.STRING)) {
                case "ModifyEquipment":
                    ItemStack playerItem = player.getInventory().getItem(EquipmentSlot.valueOf(meta.getPersistentDataContainer().
                            get(new NamespacedKey(plugin, "slot"), PersistentDataType.STRING)));
                    ItemMeta playerMeta = playerItem.getItemMeta();
                    playerMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, meta.getPersistentDataContainer().
                            get(new NamespacedKey(plugin, "key"), PersistentDataType.STRING)), PersistentDataType.STRING, meta.getPage(0));
                    playerItem.setItemMeta(playerMeta);
                    Items.values()[playerMeta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)].updateItem(plugin, playerItem);
                    event.setCancelled(true);
                    break;
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        itemName.put(player, new ArrayList<>());
        items.put(player, new ArrayList<>());
        ArmorStand petStand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
        petStand.setInvulnerable(true);
        petStand.setCollidable(false);
        petStand.setGravity(false);
        petStand.setVisible(false);
        petStand.setCustomNameVisible(true);
        petStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
        petStand.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.REMOVING_OR_CHANGING);
        petStand.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.REMOVING_OR_CHANGING);
        petStand.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.REMOVING_OR_CHANGING);
        stand.put(player, petStand);
        functions.updatePet(player);

        cooldown_heal.put(player, System.currentTimeMillis() + (8 * 1000));
        cooldown_grapple.put(player, System.currentTimeMillis() + (5 * 500));
        cooldown_lasso.put(player, System.currentTimeMillis() + (4 * 1000));
        cooldown_hunt.put(player, System.currentTimeMillis() + (20 * 1000));
        cooldown_staff.put(player, System.currentTimeMillis() + (3 * 500));
        cooldown_forest.put(player, System.currentTimeMillis() + (18 * 1000));
        cooldown_stinger.put(player, System.currentTimeMillis() + (32 * 1000));
        cooldown_rift.put(player, System.currentTimeMillis() + (15 * 1000));
        cooldown_sticky.put(player, System.currentTimeMillis() + (5 * 1000));
        cooldown_scan.put(player, System.currentTimeMillis() + (1 * 1000));
        cooldown_echo.put(player, System.currentTimeMillis() + (3 * 1000));
        cooldown_shortbow.put(player, System.currentTimeMillis() + (400));
        cooldown_mite_wand.put(player, System.currentTimeMillis() + (40 * 1000));
        echo_ward.put(player, player.getLocation());
        player.setFlying(false);
        player.setInvisible(false);
        new BukkitRunnable() {
            int time = 0;
            String main = "";
            String mainRef = "";
            List<Object> mainEnchant;
            String off = "";
            String offRef = "";
            List<Object> offEnchant;
            String helmet = "";
            String helmetRef = "";
            List<Object> helmetEnchant;
            String chest = "";
            String chestRef = "";
            List<Object> chestEnchant;
            String legs = "";
            String legsRef = "";
            List<Object> legsEnchant;
            String boots = "";
            String bootsRef = "";
            List<Object> bootsEnchant;
            String[] effects;
            int[] levels;
            long[] durations;
            ItemStack pet;
            public void run() {
                if (!player.isOnline()) {
                    stand.get(player).remove();
                    this.cancel();
                    return;
                }
                time += 1;
                main = "";
                mainRef = "";
                mainEnchant = new ArrayList<>();
                off = "";
                offRef = "";
                offEnchant = new ArrayList<>();
                helmet = "";
                helmetRef = "";
                helmetEnchant = new ArrayList<>();
                chest = "";
                chestRef = "";
                chestEnchant = new ArrayList<>();
                legs = "";
                legsRef = "";
                legsEnchant = new ArrayList<>();
                boots = "";
                bootsRef = "";
                bootsEnchant = new ArrayList<>();
                if (pets.get(player) != null) {
                    pet = pets.get(player);
                } else {
                    pet = new ItemStack(Material.AIR);
                }
                ArmorStand armorStand = stand.get(player);
                if (pets.get(player) != null &&
                    pets.get(player).getItemMeta() != null) {
                    armorStand.setCustomNameVisible(true);
                    armorStand.setCustomName(pets.get(player).getItemMeta().getDisplayName());
                } else {
                    armorStand.setCustomNameVisible(false);
                    armorStand.setCustomName(" ");
                }
                armorStand.getEquipment().setHelmet(pet);

                Location location = player.getLocation();

                Vector dir = location.getDirection();
                Location pointInFront = location.clone().add(dir.clone().multiply(-0.4));

                Vector up = new Vector(0, 1, 0);
                Vector perpendicular = dir.clone().crossProduct(up).multiply(-0.6);

                Location actualLocation = pointInFront.clone().subtract(perpendicular);
                actualLocation.setY(actualLocation.getY() + 0.4);

                armorStand.teleport(actualLocation);

                effects = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionEffects"),
                        new stringList());
                levels = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionLevels"),
                        PersistentDataType.INTEGER_ARRAY);
                durations = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionDurations"),
                        PersistentDataType.LONG_ARRAY);

                if (time % 10 == 0) {
                    List<ItemStack> list = new ArrayList<>();
                    List<String> listName = new ArrayList<>();
                    for (int i = 0; i < 36; i++) {
                        if (player.getInventory().getItem(i) != null &&
                                player.getInventory().getItem(i).getItemMeta() != null &&
                                player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer() != null &&
                                player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                        PersistentDataType.STRING) != null) {
                            list.add(player.getInventory().getItem(i));
                            listName.add(player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING));

                        }
                    }
                    items.put(player, list);
                    itemName.put(player, listName);
                }


                if (player.getInventory().getItemInMainHand() != null &&
                        player.getInventory().getItemInMainHand().getItemMeta() != null &&
                        player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null) {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                        main = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING);
                        mainEnchant.add(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                new stringList()));
                        mainEnchant.add(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                                PersistentDataType.INTEGER_ARRAY));
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
                        offEnchant.add(player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                new stringList()));
                        offEnchant.add(player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                                PersistentDataType.INTEGER_ARRAY));
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
                        helmetEnchant.add(player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                new stringList()));
                        helmetEnchant.add(player.getInventory().getHelmet().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                                PersistentDataType.INTEGER_ARRAY));
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
                        chestEnchant.add(player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                new stringList()));
                        chestEnchant.add(player.getInventory().getChestplate().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                                PersistentDataType.INTEGER_ARRAY));
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
                        legsEnchant.add(player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                new stringList()));
                        legsEnchant.add(player.getInventory().getLeggings().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                                PersistentDataType.INTEGER_ARRAY));
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
                        bootsEnchant.add(player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                                new stringList()));
                        bootsEnchant.add(player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
                                PersistentDataType.INTEGER_ARRAY));
                    }
                    if (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                            PersistentDataType.STRING) != null) {
                        bootsRef = player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                                PersistentDataType.STRING);
                    }
                }

                if (boots.equals("Mountain Goat Boots")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                            20, 3, true, false));
                }

                if (bootsEnchant.size() > 0 &&
                    Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Leaping") != -1) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                            20, ((int[])bootsEnchant.get(1))[Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Leaping")], true, false));
                }

                if (mainEnchant.size() > 0 &&
                    Arrays.asList((String[])mainEnchant.get(0)).indexOf("Cleanse") != -1 && time % 4 == 0) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) -
                            (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE) * 0.04));
                    if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) < 0) {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE, 1.0);
                    }
                    double scale = ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Cleanse")] * 0.016;
                    double intAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                            PersistentDataType.DOUBLE) * scale;
                    double invAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                            PersistentDataType.DOUBLE) * scale;
                    double thaAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                            PersistentDataType.DOUBLE) * scale;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusIntelligence"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                                PersistentDataType.DOUBLE) + intAmount);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusInvocation"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                                PersistentDataType.DOUBLE) + invAmount);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusThaumaturgy"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                PersistentDataType.DOUBLE) + thaAmount);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusIntelligence"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                                        PersistentDataType.DOUBLE) - intAmount);
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusInvocation"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                                        PersistentDataType.DOUBLE) - invAmount);
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                        PersistentDataType.DOUBLE) - thaAmount);
                        }
                    }, 20);
                }

                if (offEnchant.size() > 0 &&
                        Arrays.asList((String[])offEnchant.get(0)).indexOf("Cleanse") != -1 && time % 4 == 0) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) -
                                    (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                            PersistentDataType.DOUBLE) * 0.04));
                    if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) < 0) {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE, 1.0);
                    }
                    double scale = ((int[])offEnchant.get(1))[Arrays.asList((String[])offEnchant.get(0)).indexOf("Cleanse")] * 0.016;
                    double intAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                            PersistentDataType.DOUBLE) * scale;
                    double invAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                            PersistentDataType.DOUBLE) * scale;
                    double thaAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                            PersistentDataType.DOUBLE) * scale;
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusIntelligence"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                                    PersistentDataType.DOUBLE) + intAmount);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusInvocation"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                                    PersistentDataType.DOUBLE) + invAmount);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusThaumaturgy"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                    PersistentDataType.DOUBLE) + thaAmount);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusIntelligence"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                                            PersistentDataType.DOUBLE) - intAmount);
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusInvocation"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                                            PersistentDataType.DOUBLE) - invAmount);
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                            PersistentDataType.DOUBLE) - thaAmount);
                        }
                    }, 20);
                }

                if (time % 4 == 0 &&
                    helmetEnchant.size() > 0 &&
                    Arrays.asList((String[])helmetEnchant.get(0)).indexOf("Channel") != -1) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE) + (((int[])helmetEnchant.get(1))[Arrays.asList((String[])helmetEnchant.get(0)).indexOf("Channel")] * .1 * player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE)));
                }
                if (time % 4 == 0 &&
                    chestEnchant.size() > 0 &&
                    Arrays.asList((String[])chestEnchant.get(0)).indexOf("Channel") != -1) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE) + (((int[])chestEnchant.get(1))[Arrays.asList((String[])chestEnchant.get(0)).indexOf("Channel")] * .1 * player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE)));
                }
                if (time % 4 == 0 &&
                    legsEnchant.size() > 0 &&
                    Arrays.asList((String[])legsEnchant.get(0)).indexOf("Channel") != -1) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE) + (((int[])legsEnchant.get(1))[Arrays.asList((String[])legsEnchant.get(0)).indexOf("Channel")] * .1 * player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE)));
                }
                if (time % 4 == 0 &&
                    bootsEnchant.size() > 0 &&
                    Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Channel") != -1) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE) + (((int[])bootsEnchant.get(1))[Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Channel")] * .1 * player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE)));
                }

                if (offEnchant.size() > 0 &&
                    Arrays.asList((String[])offEnchant.get(0)).indexOf("Cleanse") != -1 && time % 4 == 0) {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) -
                                    (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                            PersistentDataType.DOUBLE) * 0.04));
                    if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) < 0) {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE, 1.0);
                    }
                    double scale = ((int[])offEnchant.get(1))[Arrays.asList((String[])offEnchant.get(0)).indexOf("Cleanse")] * 0.016;
                    double intAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                            PersistentDataType.DOUBLE) * scale;
                    double invAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                            PersistentDataType.DOUBLE) * scale;
                    double thaAmount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                            PersistentDataType.DOUBLE) * scale;

                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusIntelligence"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                                    PersistentDataType.DOUBLE) + intAmount);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusInvocation"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                                    PersistentDataType.DOUBLE) + invAmount);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusThaumaturgy"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                    PersistentDataType.DOUBLE) + thaAmount);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusIntelligence"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusIntelligence"),
                                            PersistentDataType.DOUBLE) - intAmount);
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusInvocation"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusInvocation"),
                                            PersistentDataType.DOUBLE) - invAmount);
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "BonusThaumaturgy"),
                                            PersistentDataType.DOUBLE) - thaAmount);
                        }
                    }, 20);
                }

                 switch (helmetRef) {
                    case "Illuminating":
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,
                                6, 0, true, false));
                        break;
                }
                switch (main) {
                    case "Lucky Pottery Shard":
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,
                                20, 0, true, false));
                        break;
                    case "Solar Pickaxe":
                        if (player.getLocation().getBlock().getLightFromSky() == 15 && player.getWorld().getTime() <= 13000) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
                                    6, 1, true, false));
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
                                PersistentDataType.DOUBLE) + 65);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
                                        PersistentDataType.DOUBLE) - 65);
                                }
                            }, 5);
                        }
                        break;
                    case "Torrent":
                        if (player.isInWater()) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 6, 3, true, false));
                        }
                        break;
                    case "Magmaton Furnace F2713":
                        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                PersistentDataType.INTEGER) > 0) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
                                    6, 3, true, false));
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
                                    PersistentDataType.DOUBLE) + 40);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"),
                                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"),
                                        PersistentDataType.DOUBLE) - 40);
                                }
                            }, 5);
                        }
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
                            ((Creeper)entity).setMaxFuseTicks((int) Math.round(time * 1.35));

                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                Creeper creeper = (Creeper) entity;
                                public void run() {
                                    creeper.setMaxFuseTicks(time);
                                }
                            }, 20);
                        }
                    }
                }

                if (time % 4 == 0 && helmet.equals("Saturated Creeper Mask")) {
                    List<Entity> entities = player.getNearbyEntities(6, 6, 6);
                    for (int i = 0; i < entities.size(); ++i) {
                        Entity entity = entities.get(i);
                        if (entity instanceof Creeper) {
                            int time = ((Creeper)entity).getMaxFuseTicks();
                            ((Creeper)entity).setMaxFuseTicks((int) Math.round(time * 1.6));

                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                Creeper creeper = (Creeper) entity;
                                public void run() {
                                    creeper.setMaxFuseTicks(time);
                                }
                            }, 20);
                        }
                    }
                }

                if (time % 4 == 0 && helmet.equals("Intricate Creeper Mask")) {
                    List<Entity> entities = player.getNearbyEntities(6, 6, 6);
                    for (int i = 0; i < entities.size(); ++i) {
                        Entity entity = entities.get(i);
                        if (entity instanceof Creeper) {
                            int time = ((Creeper)entity).getMaxFuseTicks();
                            ((Creeper)entity).setMaxFuseTicks((int) Math.round(time * 2.1));

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

                if (itemName.get(player).contains("Lucky Foot") && time % 4 == 0) {
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

                for (int i = 0; i < durations.length; i++) {
                    if (durations[i] <= System.currentTimeMillis()) {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionEffects"),
                                new stringList(), (String[])ArrayUtils.removeElement(effects, effects[i]));
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionLevels"),
                                PersistentDataType.INTEGER_ARRAY, ArrayUtils.removeElement(levels, levels[i]));
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionDurations"),
                                PersistentDataType.LONG_ARRAY, ArrayUtils.removeElement(durations, durations[i]));
                        functions.effectRemoved(effects[i], levels[i], player);
                    }
                }
            }
        }.runTaskTimer(plugin, 60, 5);
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent event) {
        Item item = event.getItem();
        ItemStack itemStack = item.getItemStack();
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<>();
        if (meta.getLore() == null) {
            switch (itemStack.getType()) {
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
            itemStack.setItemMeta(meta);
        }

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getOpenInventory().getTopInventory() != null &&
                player.getOpenInventory().getTopInventory().getHolder() instanceof FormatSackGUI) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        ((FormatSackGUI)player.getOpenInventory().getTopInventory().getHolder()).reloadInventory();
                    }
                }, 1);
            }
            String[] materials = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMaterial"),
                    new stringList());
            int[] max = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackMax"),
                    PersistentDataType.INTEGER_ARRAY);
            int[] amount = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "sackAmount"),
                    PersistentDataType.INTEGER_ARRAY);
            String name = itemStack.getType().toString();
            if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING) != null) {
                name = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING);
            }

            int index = Arrays.asList(materials).indexOf(name);
            if (index == -1) {
                return;
            }
            int maxItem = max[index];
            int amountItem = amount[index];
            if (maxItem > amountItem) {
                event.setCancelled(true);
                if (maxItem >= amountItem + itemStack.getAmount()) {
                    amountItem += itemStack.getAmount();
                    item.remove();
                } else {
                    itemStack.setAmount(amountItem + itemStack.getAmount() - maxItem);
                    amountItem = maxItem;
                }
            }

            amount[index] = amountItem;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "sackAmount"),
                    PersistentDataType.INTEGER_ARRAY, amount);
        }

        if (!item.isDead()) {
            item.setItemStack(itemStack);
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
                echo_ward.put(player, player.getLocation());
                player.sendMessage(ChatColor.GREEN + "Placed Echo Ward");
            }
        }
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getPlayer();

        ItemStack pet;
        if (pets.get(player) != null) {
            pet = pets.get(player);
        } else {
            pet = null;
        }

        if (pet != null &&
            pet.getItemMeta() != null) {
            switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "Cow":
                    switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                            PersistentDataType.STRING)) {
                        case "MYTHIC":
                        case "LEGENDARY":
                            player.setSaturation((float) (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                PersistentDataType.INTEGER) * .015 + player.getSaturation()));
                            break;
                        case "EPIC":
                            player.setSaturation((float) (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                    PersistentDataType.INTEGER) * .009 + player.getSaturation()));
                            break;
                        case "RARE":
                            player.setSaturation((float) (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                    PersistentDataType.INTEGER) * .006 + player.getSaturation()));
                            break;
                    }
                    break;
            }
        }

        if (item.getItemMeta() != null &&
            item.getItemMeta().getPersistentDataContainer() != null &&
            item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            String[] type = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionEffects"),
                    new stringList());
            int[] level = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionLevels"),
                    PersistentDataType.INTEGER_ARRAY);
            long[] duration = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "potionDurations"),
                    PersistentDataType.LONG_ARRAY);
            switch (item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "Potion of ":
                    String itemType = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "effect"),
                            PersistentDataType.STRING);
                    int itemLevel = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "power"),
                            PersistentDataType.INTEGER);
                    long itemDuration = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "duration"),
                            PersistentDataType.LONG);

                    int index = Arrays.asList(type).indexOf(itemType);

                    if (index != -1) {
                        if (level[index] >= itemLevel ||
                            duration[index] >= itemDuration + System.currentTimeMillis()) {
                            functions.effectRemoved(type[index], level[index], player);
                            level[index] = itemLevel;
                            duration[index] = itemDuration + System.currentTimeMillis();
                            functions.effectAdd(itemType, itemLevel, player);
                        } else {
                            event.setCancelled(true);
                        }
                    } else {
                        level = Arrays.copyOf(level, level.length + 1);
                        level[level.length - 1] = itemLevel;
                        duration = Arrays.copyOf(duration, duration.length + 1);
                        duration[duration.length - 1] = itemDuration + System.currentTimeMillis();
                        type = Arrays.copyOf(type, type.length + 1);
                        type[type.length - 1] = itemType;
                        functions.effectAdd(itemType, itemLevel, player);
                    }
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionEffects"),
                            new stringList(), type);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionLevels"),
                            PersistentDataType.INTEGER_ARRAY, level);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "potionDurations"),
                            PersistentDataType.LONG_ARRAY, duration);
                    break;
            }
        }
    }
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR ||
            event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            boolean mainHand = true;
            if (event.getHand() == EquipmentSlot.OFF_HAND) {
                mainHand = false;
            }
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
                block.getType() == Material.ANVIL ||
                block.getType() == Material.CHIPPED_ANVIL ||
                block.getType() == Material.DAMAGED_ANVIL ||
                block.getType() == Material.BREWING_STAND ||
                block.getBlockData() instanceof Chest)) {
                if (block.getType() == Material.ANVIL ||
                    block.getType() == Material.CHIPPED_ANVIL ||
                    block.getType() == Material.DAMAGED_ANVIL) {
                    event.setCancelled(true);
                    event.getPlayer().openInventory(new AnvilGUI(plugin).getInventory());
                }
                if (block.getType() == Material.BREWING_STAND) {
                    BlockState stand = block.getState();
                    if (!(brewingstands.containsKey(block.getLocation()))) {
                        if (((TileState)stand).getPersistentDataContainer().get(new NamespacedKey(plugin, "StoredItems"),
                            PersistentDataType.BYTE_ARRAY) == null) {
                            try {
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                BukkitObjectOutputStream outputStream = new BukkitObjectOutputStream(stream);
                                outputStream.writeObject(new ItemStack[] {null, null, null, null});
                                outputStream.flush();
                                ((TileState)stand).getPersistentDataContainer().set(new NamespacedKey(plugin, "StoredItems"),
                                        PersistentDataType.BYTE_ARRAY, stream.toByteArray());
                                stand.update();
                            } catch (IOException exception) {
                                System.out.println(ChatColor.RED + "Failed to store item");
                            }
                        }
                        brewingstands.put(block.getLocation(), new BrewingStandGUI(plugin, block));
                    }
                    event.setCancelled(true);
                    event.getPlayer().openInventory(brewingstands.get(block.getLocation()).getInventory());
                }
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
                if (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                        PersistentDataType.STRING) != null &&
                    event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                            PersistentDataType.STRING).equals("pet")) {
                    ItemStack[] pets = new ItemStack[]{};
                    try {
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(player.getPersistentDataContainer().get(new NamespacedKey(plugin, "availablePets"),
                                PersistentDataType.BYTE_ARRAY));
                        BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);
                        pets = (ItemStack[])objectInputStream.readObject();
                    } catch (IOException | ClassNotFoundException exception) {
                        System.out.println(ChatColor.RED + "Failed to load pets");
                    }
                    pets = Arrays.copyOf(pets, pets.length + 1);
                    pets[pets.length - 1] = event.getItem();
                    pets[pets.length - 1].setAmount(1);

                    try {
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        BukkitObjectOutputStream outputStream = new BukkitObjectOutputStream(stream);
                        outputStream.writeObject(pets);
                        outputStream.flush();
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "availablePets"),
                                PersistentDataType.BYTE_ARRAY, stream.toByteArray());
                    } catch (IOException exception) {
                        System.out.println(ChatColor.RED + "Failed to save items");
                    }
                    event.getItem().setAmount(event.getItem().getAmount() - 1);
                    return;
                }

                switch (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Lesser Wand of Healing":
                        heal(player, 8, 40, 20, "Minor Heal", mainHand);
                        break;
                    case "Wand of Healing":
                        heal(player, 8, 75, 35, "Heal", mainHand);
                        break;
                    case "Greater Wand of Healing":
                        heal(player, 7, 100, 40, "Major Heal", mainHand);
                        break;
                    case "Chain Heal Wand":
                        heal(player, 2, 40, 25, "Major Heal", mainHand);
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
                        telport(player, 7, 40, "Instant Transmission", mainHand);
                        break;
                    case "Tnt Wand":
                        tntWand(player, mainHand);
                        break;
                    case "Staff of Explosives":
                        clusterBomb(player, mainHand);
                        break;
                    case "Pufferfish Canon":
                        pufferCanon(player, mainHand);
                        break;
                    case "Hunter Shortbow":
                        if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                            break;
                        }
                        shortArrow(player, 2.85, "HUNTER_ARROW", 0, 410);
                        break;
                    case "Bamboo Shortbow":
                        if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                            break;
                        }
                        shortArrow(player, 2.4, "BAMBOO_ARROW", 0, 270);
                        break;
                    case "Webslinger Shortbow":
                        if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                            break;
                        }
                        if (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "shots"),
                                PersistentDataType.INTEGER) % 8 == 0) {
                            shortArrow(player, 1.8, "WEB_ARROW", 0, 330, Color.fromRGB(87, 82, 70));
                        } else {
                            shortArrow(player, 1.8, "", 0, 330);
                        }
                        break;
                    case "Potion Shortbow":
                        if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                            break;
                        }
                        int choice = random.nextInt(3) + 1;
                        switch (choice) {
                            case 1:
                                shortArrow(player, 2.7, "DEATH_POTION_ARROW", 0, 310, Color.fromBGR(102, 24, 88));
                                break;
                            case 2:
                                shortArrow(player, 2.7, "POISON_POTION_ARROW", 0, 310, Color.fromBGR(28, 140, 67));
                                break;
                            case 3:
                                shortArrow(player, 2.7, "PIERCE_POTION_ARROW", 2, 310, Color.fromBGR(207, 180, 64));
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
                        echo_ward.put(player, location);
                        break;
                    case "Lightning Wand":
                        lightningWand(player, mainHand);
                        break;
                    case "Sand Wand":
                        sandWand(player, mainHand);
                        break;
                    case "Dune Wand":
                        duneWand(player, mainHand);
                        break;
                    case "Prismatic Wand":
                        prismaticWand(player, mainHand);
                        break;
                    case "Grappling Hook":
                        cancel = true;
                        grapple(player);
                        break;
                    case "Wand of Maggots":
                        miteWand(player, mainHand);
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
                        rift(player, mainHand);
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
                        litchScimitar(player, mainHand);
                        break;
                    case "Stinger":
                        frenzy(player, event.getItem(), mainHand);
                        break;
                    case "Prosperous Grove":
                        prosperousGrove(player, mainHand);
                        break;
                    case "Leaching Brambles":
                        vampireBrambles(player, mainHand);
                        break;
                    case "Proliferating Sapling":
                        proliferatingSapling(player, mainHand);
                        break;
                    case "Lashing Vines":
                        bindingVines(player, mainHand);
                        break;
                    case "Pungent Herbs":
                        invigoratingFumes(player, mainHand);
                        break;
                    case "Bush Suit":
                        blockHelmet(player, event.getItem());
                        break;
                    case "Dart":
                        shortArrow(player, 4, "", 5, 1);
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                        break;
                    case "Quarterstaff":
                        quarterstaffPush(player);
                        break;
                    case "Scruffy Lasso":
                        lassoBasic(player);
                        break;
                    case "Snaggletooth Lasso":
                        lassoAdvanced(player);
                        break;
                    case "Grove Axe":
                        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            plantAxe(player, event.getClickedBlock(), mainHand);
                        }
                        break;
                        case "Compacted Peat Moss":
                        if (block != null &&
                            event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                PersistentDataType.INTEGER) > 0) {
                            superMeal(block, event.getBlockFace());
                            meta = event.getItem().getItemMeta();
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "fuel"),
                                    PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                    PersistentDataType.INTEGER) - 1);
                            event.getItem().setItemMeta(meta);
                            value = Items.values()[event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                            value.updateItem(plugin, event.getItem());
                            player.playSound(player.getLocation(), Sound.ITEM_BONE_MEAL_USE, 40, 1);
                        }
                        break;
                    case "Drawstring Bag":
                        player.openInventory(new SacksGUI(plugin, player).getInventory());
                        break;
                    case "Tiny Rock Sack":
                        applySack(event.getItem(), player, 0, "Tiny Rock Sack", "-",
                        new ArrayList<>(Arrays.asList("STONE", "GRANITE", "DIORITE", "ANDESITE", "DEEPSLATE", "COBBLED_DEEPSLATE", "CALCITE",
                            "TUFF", "COBBLESTONE", "DRIPSTONE_BLOCK", "POINTED_DRIPSTONE", "NETHERRACK", "BASALT", "POLISHED_BASALT", "SMOOTH_BASALT",
                            "MAGMA_BLOCK", "BLACKSTONE", "OBSIDIAN", "END_STONE", "SANDSTONE", "RED_SANDSTONE")), true, 640, false);
                        break;
                    case "Small Rock Sack":
                        applySack(event.getItem(), player, 0, "Small Rock Sack", "Tiny Rock Sack",
                        new ArrayList<>(Arrays.asList("STONE", "GRANITE", "DIORITE", "ANDESITE", "DEEPSLATE", "COBBLED_DEEPSLATE", "CALCITE",
                            "TUFF", "COBBLESTONE", "DRIPSTONE_BLOCK", "POINTED_DRIPSTONE", "NETHERRACK", "BASALT", "POLISHED_BASALT", "SMOOTH_BASALT",
                            "MAGMA_BLOCK", "BLACKSTONE", "OBSIDIAN", "END_STONE", "SANDSTONE", "RED_SANDSTONE")), false, 1280, false);
                        break;
                    case "Medium Rock Sack":
                        applySack(event.getItem(), player, 0, "Medium Rock Sack", "Small Rock Sack",
                        new ArrayList<>(Arrays.asList("STONE", "GRANITE", "DIORITE", "ANDESITE", "DEEPSLATE", "COBBLED_DEEPSLATE", "CALCITE",
                            "TUFF", "COBBLESTONE", "DRIPSTONE_BLOCK", "POINTED_DRIPSTONE", "NETHERRACK", "BASALT", "POLISHED_BASALT", "SMOOTH_BASALT",
                            "MAGMA_BLOCK", "BLACKSTONE", "OBSIDIAN", "END_STONE", "SANDSTONE", "RED_SANDSTONE")), false, 2560, false);
                        break;
                    case "Large Rock Sack":
                        applySack(event.getItem(), player, 0, "Large Rock Sack", "Medium Rock Sack",
                        new ArrayList<>(Arrays.asList("STONE", "GRANITE", "DIORITE", "ANDESITE", "DEEPSLATE", "COBBLED_DEEPSLATE", "CALCITE",
                            "TUFF", "COBBLESTONE", "DRIPSTONE_BLOCK", "POINTED_DRIPSTONE", "NETHERRACK", "BASALT", "POLISHED_BASALT", "SMOOTH_BASALT",
                            "MAGMA_BLOCK", "BLACKSTONE", "OBSIDIAN", "END_STONE", "SANDSTONE", "RED_SANDSTONE")), false, 5120, false);
                        break;
                    case "Gigantic Rock Sack":
                        applySack(event.getItem(), player, 0, "Gigantic Rock Sack", "Large Rock Sack",
                        new ArrayList<>(Arrays.asList("STONE", "GRANITE", "DIORITE", "ANDESITE", "DEEPSLATE", "COBBLED_DEEPSLATE", "CALCITE",
                            "TUFF", "COBBLESTONE", "DRIPSTONE_BLOCK", "POINTED_DRIPSTONE", "NETHERRACK", "BASALT", "POLISHED_BASALT", "SMOOTH_BASALT",
                            "MAGMA_BLOCK", "BLACKSTONE", "OBSIDIAN", "END_STONE", "SANDSTONE", "RED_SANDSTONE")), false, 10240, false);
                        break;
                    case "Humongous Rock Sack":
                        applySack(event.getItem(), player, 0, "Humongous Rock Sack", "Gigantic Rock Sack",
                        new ArrayList<>(Arrays.asList("STONE", "GRANITE", "DIORITE", "ANDESITE", "DEEPSLATE", "COBBLED_DEEPSLATE", "CALCITE",
                            "TUFF", "COBBLESTONE", "DRIPSTONE_BLOCK", "POINTED_DRIPSTONE", "NETHERRACK", "BASALT", "POLISHED_BASALT", "SMOOTH_BASALT",
                            "MAGMA_BLOCK", "BLACKSTONE", "OBSIDIAN", "END_STONE", "SANDSTONE", "RED_SANDSTONE")), false, 20480, false);
                        break;
                    case "Rock Sack Extension":
                        applySack(event.getItem(), player, 0, ChatColor.DARK_GRAY + "+", "Humongous Rock Sack",
                        new ArrayList<>(Arrays.asList("STONE", "GRANITE", "DIORITE", "ANDESITE", "DEEPSLATE", "COBBLED_DEEPSLATE", "CALCITE",
                            "TUFF", "COBBLESTONE", "DRIPSTONE_BLOCK", "POINTED_DRIPSTONE", "NETHERRACK", "BASALT", "POLISHED_BASALT", "SMOOTH_BASALT",
                            "MAGMA_BLOCK", "BLACKSTONE", "OBSIDIAN", "END_STONE", "SANDSTONE", "RED_SANDSTONE")), false, 1280, true);
                        break;
                    case "Tiny Mineral Sack":
                        applySack(event.getItem(), player, 1, "Tiny Mineral Sack", "-",
                        new ArrayList<>(Arrays.asList("COAL", "DIAMOND", "EMERALD", "LAPIS_LAZULI", "REDSTONE", "QUARTZ", "AMETHYST_BLOCK",
                            "AMETHYST_SHARD", "RAW_IRON", "IRON_INGOT", "RAW_COPPER", "COPPER_INGOT", "RAW_GOLD", "GOLD_INGOT", "GOLD_NUGGET",
                            "GLOWSTONE_DUST", "ANCIENT_DEBRIS", "NETHERITE_SCRAP")), true, 640, false);
                        break;
                    case "Small Mineral Sack":
                        applySack(event.getItem(), player, 1, "Small Mineral Sack", "Tiny Mineral Sack",
                        new ArrayList<>(Arrays.asList("COAL", "DIAMOND", "EMERALD", "LAPIS_LAZULI", "REDSTONE", "QUARTZ", "AMETHYST_BLOCK",
                            "AMETHYST_SHARD", "RAW_IRON", "IRON_INGOT", "RAW_COPPER", "COPPER_INGOT", "RAW_GOLD", "GOLD_INGOT", "GOLD_NUGGET",
                            "GLOWSTONE_DUST", "ANCIENT_DEBRIS", "NETHERITE_SCRAP")), false, 1280, false);
                        break;
                    case "Medium Mineral Sack":
                        applySack(event.getItem(), player, 1, "Medium Mineral Sack", "Small Mineral Sack",
                        new ArrayList<>(Arrays.asList("COAL", "DIAMOND", "EMERALD", "LAPIS_LAZULI", "REDSTONE", "QUARTZ", "AMETHYST_BLOCK",
                            "AMETHYST_SHARD", "RAW_IRON", "IRON_INGOT", "RAW_COPPER", "COPPER_INGOT", "RAW_GOLD", "GOLD_INGOT", "GOLD_NUGGET",
                            "GLOWSTONE_DUST", "ANCIENT_DEBRIS", "NETHERITE_SCRAP")), false, 2560, false);
                        break;
                    case "Large Mineral Sack":
                        applySack(event.getItem(), player, 1, "Large Mineral Sack", "Medium Mineral Sack",
                        new ArrayList<>(Arrays.asList("COAL", "DIAMOND", "EMERALD", "LAPIS_LAZULI", "REDSTONE", "QUARTZ", "AMETHYST_BLOCK",
                            "AMETHYST_SHARD", "RAW_IRON", "IRON_INGOT", "RAW_COPPER", "COPPER_INGOT", "RAW_GOLD", "GOLD_INGOT", "GOLD_NUGGET",
                            "GLOWSTONE_DUST", "ANCIENT_DEBRIS", "NETHERITE_SCRAP")), false, 5120, false);
                        break;
                    case "Gigantic Mineral Sack":
                        applySack(event.getItem(), player, 1, "Gigantic Mineral Sack", "Large Mineral Sack",
                        new ArrayList<>(Arrays.asList("COAL", "DIAMOND", "EMERALD", "LAPIS_LAZULI", "REDSTONE", "QUARTZ", "AMETHYST_BLOCK",
                            "AMETHYST_SHARD", "RAW_IRON", "IRON_INGOT", "RAW_COPPER", "COPPER_INGOT", "RAW_GOLD", "GOLD_INGOT", "GOLD_NUGGET",
                            "GLOWSTONE_DUST", "ANCIENT_DEBRIS", "NETHERITE_SCRAP")), false, 10240, false);
                        break;
                    case "Humongous Mineral Sack":
                        applySack(event.getItem(), player, 1, "Humongous Mineral Sack", "Gigantic Mineral Sack",
                        new ArrayList<>(Arrays.asList("COAL", "DIAMOND", "EMERALD", "LAPIS_LAZULI", "REDSTONE", "QUARTZ", "AMETHYST_BLOCK",
                            "AMETHYST_SHARD", "RAW_IRON", "IRON_INGOT", "RAW_COPPER", "COPPER_INGOT", "RAW_GOLD", "GOLD_INGOT", "GOLD_NUGGET",
                            "GLOWSTONE_DUST", "ANCIENT_DEBRIS", "NETHERITE_SCRAP")), false, 20480, false);
                        break;
                    case "Mineral Sack Extension":
                        applySack(event.getItem(), player, 1, ChatColor.AQUA + "+", "Humongous Mineral Sack",
                        new ArrayList<>(Arrays.asList("COAL", "DIAMOND", "EMERALD", "LAPIS_LAZULI", "REDSTONE", "QUARTZ", "AMETHYST_BLOCK",
                            "AMETHYST_SHARD", "RAW_IRON", "IRON_INGOT", "RAW_COPPER", "COPPER_INGOT", "RAW_GOLD", "GOLD_INGOT", "GOLD_NUGGET",
                            "GLOWSTONE_DUST", "ANCIENT_DEBRIS", "NETHERITE_SCRAP")), false, 1280, true);
                        break;
                    case "Tiny Lumber Sack":
                        applySack(event.getItem(), player, 2, "Tiny Lumber Sack", "-",
                        new ArrayList<>(Arrays.asList("OAK_LOG", "SPRUCE_LOG", "BIRCH_LOG", "JUNGLE_LOG", "ACACIA_LOG", "DARK_OAK_LOG", "CRIMSON_STEM",
                            "WARPED_STEM", "OAK_LEAVES", "SPRUCE_LEAVES", "BIRCH_LEAVES", "JUNGLE_LEAVES", "ACACIA_LEAVES", "DARK_OAK_LEAVES", "WARPED_WART_BLOCK",
                            "NETHER_WART_BLOCK", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "MUSHROOM_STEM", "SHROOMLIGHT")), true, 640, false);
                        break;
                    case "Small Lumber Sack":
                        applySack(event.getItem(), player, 2, "Small Lumber Sack", "Tiny Lumber Sack",
                        new ArrayList<>(Arrays.asList("OAK_LOG", "SPRUCE_LOG", "BIRCH_LOG", "JUNGLE_LOG", "ACACIA_LOG", "DARK_OAK_LOG", "CRIMSON_STEM",
                            "WARPED_STEM", "OAK_LEAVES", "SPRUCE_LEAVES", "BIRCH_LEAVES", "JUNGLE_LEAVES", "ACACIA_LEAVES", "DARK_OAK_LEAVES", "WARPED_WART_BLOCK",
                            "NETHER_WART_BLOCK", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "MUSHROOM_STEM", "SHROOMLIGHT")), false, 1280, false);
                        break;
                    case "Medium Lumber Sack":
                        applySack(event.getItem(), player, 2, "Medium Lumber Sack", "Small Lumber Sack",
                        new ArrayList<>(Arrays.asList("OAK_LOG", "SPRUCE_LOG", "BIRCH_LOG", "JUNGLE_LOG", "ACACIA_LOG", "DARK_OAK_LOG", "CRIMSON_STEM",
                            "WARPED_STEM", "OAK_LEAVES", "SPRUCE_LEAVES", "BIRCH_LEAVES", "JUNGLE_LEAVES", "ACACIA_LEAVES", "DARK_OAK_LEAVES", "WARPED_WART_BLOCK",
                            "NETHER_WART_BLOCK", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "MUSHROOM_STEM", "SHROOMLIGHT")), false, 2560, false);
                        break;
                    case "Large Lumber Sack":
                        applySack(event.getItem(), player, 2, "Large Lumber Sack", "Medium Lumber Sack",
                        new ArrayList<>(Arrays.asList("OAK_LOG", "SPRUCE_LOG", "BIRCH_LOG", "JUNGLE_LOG", "ACACIA_LOG", "DARK_OAK_LOG", "CRIMSON_STEM",
                            "WARPED_STEM", "OAK_LEAVES", "SPRUCE_LEAVES", "BIRCH_LEAVES", "JUNGLE_LEAVES", "ACACIA_LEAVES", "DARK_OAK_LEAVES", "WARPED_WART_BLOCK",
                            "NETHER_WART_BLOCK", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "MUSHROOM_STEM", "SHROOMLIGHT")), false, 5120, false);
                        break;
                    case "Gigantic Lumber Sack":
                        applySack(event.getItem(), player, 2, "Gigantic Lumber Sack", "Large Lumber Sack",
                        new ArrayList<>(Arrays.asList("OAK_LOG", "SPRUCE_LOG", "BIRCH_LOG", "JUNGLE_LOG", "ACACIA_LOG", "DARK_OAK_LOG", "CRIMSON_STEM",
                            "WARPED_STEM", "OAK_LEAVES", "SPRUCE_LEAVES", "BIRCH_LEAVES", "JUNGLE_LEAVES", "ACACIA_LEAVES", "DARK_OAK_LEAVES", "WARPED_WART_BLOCK",
                            "NETHER_WART_BLOCK", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "MUSHROOM_STEM", "SHROOMLIGHT")), false, 10240, false);
                        break;
                    case "Humongous Lumber Sack":
                        applySack(event.getItem(), player, 2, "Humongous Lumber Sack", "Gigantic Lumber Sack",
                        new ArrayList<>(Arrays.asList("OAK_LOG", "SPRUCE_LOG", "BIRCH_LOG", "JUNGLE_LOG", "ACACIA_LOG", "DARK_OAK_LOG", "CRIMSON_STEM",
                            "WARPED_STEM", "OAK_LEAVES", "SPRUCE_LEAVES", "BIRCH_LEAVES", "JUNGLE_LEAVES", "ACACIA_LEAVES", "DARK_OAK_LEAVES", "WARPED_WART_BLOCK",
                            "NETHER_WART_BLOCK", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "MUSHROOM_STEM", "SHROOMLIGHT")), false, 20480, false);
                        break;
                    case "Lumber Sack Extension":
                        applySack(event.getItem(), player, 2, ChatColor.GOLD + "+", "Humongous Lumber Sack",
                        new ArrayList<>(Arrays.asList("OAK_LOG", "SPRUCE_LOG", "BIRCH_LOG", "JUNGLE_LOG", "ACACIA_LOG", "DARK_OAK_LOG", "CRIMSON_STEM",
                            "WARPED_STEM", "OAK_LEAVES", "SPRUCE_LEAVES", "BIRCH_LEAVES", "JUNGLE_LEAVES", "ACACIA_LEAVES", "DARK_OAK_LEAVES", "WARPED_WART_BLOCK",
                            "NETHER_WART_BLOCK", "BROWN_MUSHROOM_BLOCK", "RED_MUSHROOM_BLOCK", "MUSHROOM_STEM", "SHROOMLIGHT")), false, 1280, true);
                        break;
                    case "Tiny Foraging Sack":
                        applySack(event.getItem(), player, 3, "Tiny Foraging Sack", "-",
                        new ArrayList<>(Arrays.asList("BROWN_MUSHROOM", "RED_MUSHROOM", "BAMBOO", "STICK", "SWEET_BERRIES", "GLOW_BERRIES", "MOSS_BLOCK",
                            "CHORUS_FLOWER", "CHORUS_FRUIT", "APPLE", "WARPED_FUNGUS", "CRIMSON_FUNGUS", "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING",
                            "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "AZALEA", "FLOWERING_AZALEA", "SMALL_DRIPLEAF", "BIG_DRIPLEAF", "VINE",
                            "GLOW_LICHEN")), true, 640, false);
                        break;
                    case "Small Foraging Sack":
                        applySack(event.getItem(), player, 3, "Small Foraging Sack", "Tiny Foraging Sack",
                        new ArrayList<>(Arrays.asList("BROWN_MUSHROOM", "RED_MUSHROOM", "BAMBOO", "STICK", "SWEET_BERRIES", "GLOW_BERRIES", "MOSS_BLOCK",
                            "CHORUS_FLOWER", "CHORUS_FRUIT", "APPLE", "WARPED_FUNGUS", "CRIMSON_FUNGUS", "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING",
                            "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "AZALEA", "FLOWERING_AZALEA", "SMALL_DRIPLEAF", "BIG_DRIPLEAF", "VINE",
                            "GLOW_LICHEN")), false, 1280, false);
                        break;
                    case "Medium Foraging Sack":
                        applySack(event.getItem(), player, 3, "Medium Foraging Sack", "Small Foraging Sack",
                        new ArrayList<>(Arrays.asList("BROWN_MUSHROOM", "RED_MUSHROOM", "BAMBOO", "STICK", "SWEET_BERRIES", "GLOW_BERRIES", "MOSS_BLOCK",
                            "CHORUS_FLOWER", "CHORUS_FRUIT", "APPLE", "WARPED_FUNGUS", "CRIMSON_FUNGUS", "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING",
                            "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "AZALEA", "FLOWERING_AZALEA", "SMALL_DRIPLEAF", "BIG_DRIPLEAF", "VINE",
                            "GLOW_LICHEN")), false, 2560, false);
                        break;
                    case "Large Foraging Sack":
                        applySack(event.getItem(), player, 3, "Large Foraging Sack", "Medium Foraging Sack",
                        new ArrayList<>(Arrays.asList("BROWN_MUSHROOM", "RED_MUSHROOM", "BAMBOO", "STICK", "SWEET_BERRIES", "GLOW_BERRIES", "MOSS_BLOCK",
                            "CHORUS_FLOWER", "CHORUS_FRUIT", "APPLE", "WARPED_FUNGUS", "CRIMSON_FUNGUS", "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING",
                            "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "AZALEA", "FLOWERING_AZALEA", "SMALL_DRIPLEAF", "BIG_DRIPLEAF", "VINE",
                            "GLOW_LICHEN")), false, 5120, false);
                        break;
                    case "Gigantic Foraging Sack":
                        applySack(event.getItem(), player, 3, "Gigantic Foraging Sack", "Large Foraging Sack",
                        new ArrayList<>(Arrays.asList("BROWN_MUSHROOM", "RED_MUSHROOM", "BAMBOO", "STICK", "SWEET_BERRIES", "GLOW_BERRIES", "MOSS_BLOCK",
                            "CHORUS_FLOWER", "CHORUS_FRUIT", "APPLE", "WARPED_FUNGUS", "CRIMSON_FUNGUS", "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING",
                            "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "AZALEA", "FLOWERING_AZALEA", "SMALL_DRIPLEAF", "BIG_DRIPLEAF", "VINE",
                            "GLOW_LICHEN")), false, 10240, false);
                        break;
                    case "Humongous Foraging Sack":
                        applySack(event.getItem(), player, 3, "Humongous Foraging Sack", "Gigantic Foraging Sack",
                        new ArrayList<>(Arrays.asList("BROWN_MUSHROOM", "RED_MUSHROOM", "BAMBOO", "STICK", "SWEET_BERRIES", "GLOW_BERRIES", "MOSS_BLOCK",
                            "CHORUS_FLOWER", "CHORUS_FRUIT", "APPLE", "WARPED_FUNGUS", "CRIMSON_FUNGUS", "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING",
                            "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "AZALEA", "FLOWERING_AZALEA", "SMALL_DRIPLEAF", "BIG_DRIPLEAF", "VINE",
                            "GLOW_LICHEN")), false, 20480, false);
                        break;
                    case "Foraging Sack Extension":
                        applySack(event.getItem(), player, 3, ChatColor.GREEN + "+", "Humongous Foraging Sack",
                        new ArrayList<>(Arrays.asList("BROWN_MUSHROOM", "RED_MUSHROOM", "BAMBOO", "STICK", "SWEET_BERRIES", "GLOW_BERRIES", "MOSS_BLOCK",
                            "CHORUS_FLOWER", "CHORUS_FRUIT", "APPLE", "WARPED_FUNGUS", "CRIMSON_FUNGUS", "OAK_SAPLING", "SPRUCE_SAPLING", "BIRCH_SAPLING",
                            "JUNGLE_SAPLING", "ACACIA_SAPLING", "DARK_OAK_SAPLING", "AZALEA", "FLOWERING_AZALEA", "SMALL_DRIPLEAF", "BIG_DRIPLEAF", "VINE",
                            "GLOW_LICHEN")), false, 1280, true);
                        break;
                    case "Tiny Agriculture Sack":
                        applySack(event.getItem(), player, 4, "Tiny Agriculture Sack", "-",
                        new ArrayList<>(Arrays.asList("CARROT", "POTATO", "BEETROOT", "BEETROOT_SEEDS", "WHEAT", "WHEAT_SEEDS", "MELON_SLICE",
                            "MELON", "COCOA_BEANS", "PUMPKIN", "KELP", "SUGAR_CANE", "CACTUS", "NETHER_WART")), true, 640, false);
                        break;
                    case "Small Agriculture Sack":
                        applySack(event.getItem(), player, 4, "Small Agriculture Sack", "Tiny Agriculture Sack",
                        new ArrayList<>(Arrays.asList("CARROT", "POTATO", "BEETROOT", "BEETROOT_SEEDS", "WHEAT", "WHEAT_SEEDS", "MELON_SLICE",
                            "MELON", "COCOA_BEANS", "PUMPKIN", "KELP", "SUGAR_CANE", "CACTUS", "NETHER_WART")), false, 1280, false);
                        break;
                    case "Medium Agriculture Sack":
                        applySack(event.getItem(), player, 4, "Medium Agriculture Sack", "Small Agriculture Sack",
                        new ArrayList<>(Arrays.asList("CARROT", "POTATO", "BEETROOT", "BEETROOT_SEEDS", "WHEAT", "WHEAT_SEEDS", "MELON_SLICE",
                            "MELON", "COCOA_BEANS", "PUMPKIN", "KELP", "SUGAR_CANE", "CACTUS", "NETHER_WART")), false, 2560, false);
                        break;
                    case "Large Agriculture Sack":
                        applySack(event.getItem(), player, 4, "Large Agriculture Sack", "Medium Agriculture Sack",
                        new ArrayList<>(Arrays.asList("CARROT", "POTATO", "BEETROOT", "BEETROOT_SEEDS", "WHEAT", "WHEAT_SEEDS", "MELON_SLICE",
                            "MELON", "COCOA_BEANS", "PUMPKIN", "KELP", "SUGAR_CANE", "CACTUS", "NETHER_WART")), false, 5120, false);
                        break;
                    case "Gigantic Agriculture Sack":
                        applySack(event.getItem(), player, 4, "Gigantic Agriculture Sack", "Large Agriculture Sack",
                        new ArrayList<>(Arrays.asList("CARROT", "POTATO", "BEETROOT", "BEETROOT_SEEDS", "WHEAT", "WHEAT_SEEDS", "MELON_SLICE",
                            "MELON", "COCOA_BEANS", "PUMPKIN", "KELP", "SUGAR_CANE", "CACTUS", "NETHER_WART")), false, 10240, false);
                        break;
                    case "Humongous Agriculture Sack":
                        applySack(event.getItem(), player, 4, "Humongous Agriculture Sack", "Gigantic Agriculture Sack",
                        new ArrayList<>(Arrays.asList("CARROT", "POTATO", "BEETROOT", "BEETROOT_SEEDS", "WHEAT", "WHEAT_SEEDS", "MELON_SLICE",
                            "MELON", "COCOA_BEANS", "PUMPKIN", "KELP", "SUGAR_CANE", "CACTUS", "NETHER_WART")), false, 20480, false);
                        break;
                    case "Agriculture Sack Extension":
                        applySack(event.getItem(), player, 4, ChatColor.YELLOW + "+", "Humongous Agriculture Sack",
                        new ArrayList<>(Arrays.asList("CARROT", "POTATO", "BEETROOT", "BEETROOT_SEEDS", "WHEAT", "WHEAT_SEEDS", "MELON_SLICE",
                            "MELON", "COCOA_BEANS", "PUMPKIN", "KELP", "SUGAR_CANE", "CACTUS", "NETHER_WART")), false, 1280, true);
                        break;
                    case "Tiny Husbandry Sack":
                        applySack(event.getItem(), player, 5, "Tiny Husbandry Sack", "-",
                        new ArrayList<>(Arrays.asList("CHICKEN", "FEATHER", "EGG", "BEEF", "LEATHER", "PORKCHOP", "WHITE_WOOL",
                            "MUTTON", "RABBIT", "RABBIT_FOOT", "RABBIT_HIDE", "SCUTE", "TURTLE_EGG", "HONEY_BOTTLE", "HONEYCOMB")), true, 640, false);
                        break;
                    case "Small Husbandry Sack":
                        applySack(event.getItem(), player, 5, "Small Husbandry Sack", "Tiny Husbandry Sack",
                        new ArrayList<>(Arrays.asList("CHICKEN", "FEATHER", "EGG", "BEEF", "LEATHER", "PORKCHOP", "WHITE_WOOL",
                            "MUTTON", "RABBIT", "RABBIT_FOOT", "RABBIT_HIDE", "SCUTE", "TURTLE_EGG", "HONEY_BOTTLE", "HONEYCOMB")), false, 1280, false);
                        break;
                    case "Medium Husbandry Sack":
                        applySack(event.getItem(), player, 5, "Medium Husbandry Sack", "Small Husbandry Sack",
                        new ArrayList<>(Arrays.asList("CHICKEN", "FEATHER", "EGG", "BEEF", "LEATHER", "PORKCHOP", "WHITE_WOOL",
                            "MUTTON", "RABBIT", "RABBIT_FOOT", "RABBIT_HIDE", "SCUTE", "TURTLE_EGG", "HONEY_BOTTLE", "HONEYCOMB")), false, 2560, false);
                        break;
                    case "Large Husbandry Sack":
                        applySack(event.getItem(), player, 5, "Large Husbandry Sack", "Medium Husbandry Sack",
                        new ArrayList<>(Arrays.asList("CHICKEN", "FEATHER", "EGG", "BEEF", "LEATHER", "PORKCHOP", "WHITE_WOOL",
                            "MUTTON", "RABBIT", "RABBIT_FOOT", "RABBIT_HIDE", "SCUTE", "TURTLE_EGG", "HONEY_BOTTLE", "HONEYCOMB")), false, 5120, false);
                        break;
                    case "Gigantic Husbandry Sack":
                        applySack(event.getItem(), player, 5, "Gigantic Husbandry Sack", "Large Husbandry Sack",
                        new ArrayList<>(Arrays.asList("CHICKEN", "FEATHER", "EGG", "BEEF", "LEATHER", "PORKCHOP", "WHITE_WOOL",
                            "MUTTON", "RABBIT", "RABBIT_FOOT", "RABBIT_HIDE", "SCUTE", "TURTLE_EGG", "HONEY_BOTTLE", "HONEYCOMB")), false, 10240, false);
                        break;
                    case "Humongous Husbandry Sack":
                        applySack(event.getItem(), player, 5, "Humongous Husbandry Sack", "Gigantic Husbandry Sack",
                        new ArrayList<>(Arrays.asList("CHICKEN", "FEATHER", "EGG", "BEEF", "LEATHER", "PORKCHOP", "WHITE_WOOL",
                            "MUTTON", "RABBIT", "RABBIT_FOOT", "RABBIT_HIDE", "SCUTE", "TURTLE_EGG", "HONEY_BOTTLE", "HONEYCOMB")), false, 20480, false);
                        break;
                    case "Husbandry Sack Extension":
                        applySack(event.getItem(), player, 5, ChatColor.YELLOW + "+", "Humongous Husbandry Sack",
                        new ArrayList<>(Arrays.asList("CHICKEN", "FEATHER", "EGG", "BEEF", "LEATHER", "PORKCHOP", "WHITE_WOOL",
                            "MUTTON", "RABBIT", "RABBIT_FOOT", "RABBIT_HIDE", "SCUTE", "TURTLE_EGG", "HONEY_BOTTLE", "HONEYCOMB")), false, 1280, true);
                        break;
                    case "Tiny Cryptozoology Sack":
                        applySack(event.getItem(), player, 6, "Tiny Cryptozoology Sack", "-",
                        new ArrayList<>(Arrays.asList("STRING", "SPIDER_EYE", "ROTTEN_FLESH", "BONE", "BONE_BLOCK", "GUNPOWDER", "SLIME_BALL",
                            "Monster Meat", "Pulsing Tumor")), true, 640, false);
                        break;
                    case "Small Cryptozoology Sack":
                        applySack(event.getItem(), player, 6, "Small Cryptozoology Sack", "Tiny Cryptozoology Sack",
                        new ArrayList<>(Arrays.asList("STRING", "SPIDER_EYE", "ROTTEN_FLESH", "BONE", "BONE_BLOCK", "GUNPOWDER", "SLIME_BALL",
                            "Monster Meat", "Pulsing Tumor")), false, 1280, false);
                        break;
                    case "Medium Cryptozoology Sack":
                        applySack(event.getItem(), player, 6, "Medium Cryptozoology Sack", "Small Cryptozoology Sack",
                        new ArrayList<>(Arrays.asList("STRING", "SPIDER_EYE", "ROTTEN_FLESH", "BONE", "BONE_BLOCK", "GUNPOWDER", "SLIME_BALL",
                            "Monster Meat", "Pulsing Tumor")), false, 2560, false);
                        break;
                    case "Large Cryptozoology Sack":
                        applySack(event.getItem(), player, 6, "Large Cryptozoology Sack", "Medium Cryptozoology Sack",
                        new ArrayList<>(Arrays.asList("STRING", "SPIDER_EYE", "ROTTEN_FLESH", "BONE", "BONE_BLOCK", "GUNPOWDER", "SLIME_BALL",
                            "Monster Meat", "Pulsing Tumor")), false, 5120, false);
                        break;
                    case "Gigantic Cryptozoology Sack":
                        applySack(event.getItem(), player, 6, "Gigantic Cryptozoology Sack", "Large Cryptozoology Sack",
                        new ArrayList<>(Arrays.asList("STRING", "SPIDER_EYE", "ROTTEN_FLESH", "BONE", "BONE_BLOCK", "GUNPOWDER", "SLIME_BALL",
                            "Monster Meat", "Pulsing Tumor")), false, 10240, false);
                        break;
                    case "Humongous Cryptozoology Sack":
                        applySack(event.getItem(), player, 6, "Humongous Cryptozoology Sack", "Gigantic Cryptozoology Sack",
                        new ArrayList<>(Arrays.asList("STRING", "SPIDER_EYE", "ROTTEN_FLESH", "BONE", "BONE_BLOCK", "GUNPOWDER", "SLIME_BALL",
                            "Monster Meat", "Pulsing Tumor")), false, 20480, false);
                        break;
                    case "Cryptozoology Sack Extension":
                        applySack(event.getItem(), player, 6, ChatColor.DARK_BLUE + "+", "Humongous Cryptozoology Sack",
                        new ArrayList<>(Arrays.asList("STRING", "SPIDER_EYE", "ROTTEN_FLESH", "BONE", "BONE_BLOCK", "GUNPOWDER", "SLIME_BALL",
                            "Monster Meat", "Pulsing Tumor")), false, 1280, true);
                        break;
                    case "Tiny Demonology Sack":
                        applySack(event.getItem(), player, 7, "Tiny Demonology Sack", "-",
                        new ArrayList<>(Arrays.asList("BLAZE_ROD", "GHAST_TEAR", "BLAZE_POWDER", "MAGMA_CREAM", "Hide")), true, 640, false);
                        break;
                    case "Small Demonology Sack":
                        applySack(event.getItem(), player, 7, "Small Demonology Sack", "Tiny Demonology Sack",
                        new ArrayList<>(Arrays.asList("BLAZE_ROD", "GHAST_TEAR", "BLAZE_POWDER", "MAGMA_CREAM", "Hide")), false, 1280, false);
                        break;
                    case "Medium Demonology Sack":
                        applySack(event.getItem(), player, 7, "Medium Demonology Sack", "Small Demonology Sack",
                        new ArrayList<>(Arrays.asList("BLAZE_ROD", "GHAST_TEAR", "BLAZE_POWDER", "MAGMA_CREAM", "Hide")), false, 2560, false);
                        break;
                    case "Large Demonology Sack":
                        applySack(event.getItem(), player, 7, "Large Demonology Sack", "Medium Demonology Sack",
                        new ArrayList<>(Arrays.asList("BLAZE_ROD", "GHAST_TEAR", "BLAZE_POWDER", "MAGMA_CREAM", "Hide")), false, 5120, false);
                        break;
                    case "Gigantic Demonology Sack":
                        applySack(event.getItem(), player, 7, "Gigantic Demonology Sack", "Large Demonology Sack",
                        new ArrayList<>(Arrays.asList("BLAZE_ROD", "GHAST_TEAR", "BLAZE_POWDER", "MAGMA_CREAM", "Hide")), false, 10240, false);
                        break;
                    case "Humongous Demonology Sack":
                        applySack(event.getItem(), player, 7, "Humongous Demonology Sack", "Gigantic Demonology Sack",
                        new ArrayList<>(Arrays.asList("BLAZE_ROD", "GHAST_TEAR", "BLAZE_POWDER", "MAGMA_CREAM", "Hide")), false, 20480, false);
                        break;
                    case "Demonology Sack Extension":
                        applySack(event.getItem(), player, 7, ChatColor.DARK_RED + "+", "Humongous Demonology Sack",
                        new ArrayList<>(Arrays.asList("BLAZE_ROD", "GHAST_TEAR", "BLAZE_POWDER", "MAGMA_CREAM", "Hide")), false, 1280, true);
                        break;
                    case "Tiny Xenoarchaeology Sack":
                        applySack(event.getItem(), player, 8, "Tiny Xenoarchaeology Sack", "-",
                        new ArrayList<>(Arrays.asList("ENDER_PEARL", "ENDER_EYE", "SHULKER_SHELL", "PHANTOM_MEMBRANE")), true, 640, false);
                        break;
                    case "Small Xenoarchaeology Sack":
                        applySack(event.getItem(), player, 8, "Small Xenoarchaeology Sack", "Tiny Xenoarchaeology Sack",
                        new ArrayList<>(Arrays.asList("ENDER_PEARL", "ENDER_EYE", "SHULKER_SHELL", "PHANTOM_MEMBRANE")), false, 1280, false);
                        break;
                    case "Medium Xenoarchaeology Sack":
                        applySack(event.getItem(), player, 8, "Medium Xenoarchaeology Sack", "Small Xenoarchaeology Sack",
                        new ArrayList<>(Arrays.asList("ENDER_PEARL", "ENDER_EYE", "SHULKER_SHELL", "PHANTOM_MEMBRANE")), false, 2560, false);
                        break;
                    case "Large Xenoarchaeology Sack":
                        applySack(event.getItem(), player, 8, "Large Xenoarchaeology Sack", "Medium Xenoarchaeology Sack",
                        new ArrayList<>(Arrays.asList("ENDER_PEARL", "ENDER_EYE", "SHULKER_SHELL", "PHANTOM_MEMBRANE")), false, 5120, false);
                        break;
                    case "Gigantic Xenoarchaeology Sack":
                        applySack(event.getItem(), player, 8, "Gigantic Xenoarchaeology Sack", "Large Xenoarchaeology Sack",
                        new ArrayList<>(Arrays.asList("ENDER_PEARL", "ENDER_EYE", "SHULKER_SHELL", "PHANTOM_MEMBRANE")), false, 10240, false);
                        break;
                    case "Humongous Xenoarchaeology Sack":
                        applySack(event.getItem(), player, 8, "Humongous Xenoarchaeology Sack", "Gigantic Xenoarchaeology Sack",
                        new ArrayList<>(Arrays.asList("ENDER_PEARL", "ENDER_EYE", "SHULKER_SHELL", "PHANTOM_MEMBRANE")), false, 20480, false);
                        break;
                    case "Xenoarchaeology Sack Extension":
                        applySack(event.getItem(), player, 8, ChatColor.LIGHT_PURPLE + "+", "Humongous Xenoarchaeology Sack",
                        new ArrayList<>(Arrays.asList("ENDER_PEARL", "ENDER_EYE", "SHULKER_SHELL", "PHANTOM_MEMBRANE")), false, 1280, true);
                        break;
                    case "Tiny Fishing Sack":
                        applySack(event.getItem(), player, 9, "Tiny Fishing Sack", "-",
                        new ArrayList<>(Arrays.asList("COD", "SALMON", "PUFFERFISH", "TROPICAL_FISH", "NAUTILUS_SHELL", "INK_SAC", "GLOW_INK_SAC", "Seastone Shard")), true, 640, false);
                        break;
                    case "Small Fishing Sack":
                        applySack(event.getItem(), player, 9, "Small Fishing Sack", "Tiny Fishing Sack",
                        new ArrayList<>(Arrays.asList("COD", "SALMON", "PUFFERFISH", "TROPICAL_FISH", "NAUTILUS_SHELL", "INK_SAC", "GLOW_INK_SAC", "Seastone Shard")), false, 1280, false);
                        break;
                    case "Medium Fishing Sack":
                        applySack(event.getItem(), player, 9, "Medium Fishing Sack", "Small Fishing Sack",
                        new ArrayList<>(Arrays.asList("COD", "SALMON", "PUFFERFISH", "TROPICAL_FISH", "NAUTILUS_SHELL", "INK_SAC", "GLOW_INK_SAC", "Seastone Shard")), false, 2560, false);
                        break;
                    case "Large Fishing Sack":
                        applySack(event.getItem(), player, 9, "Large Fishing Sack", "Medium Fishing Sack",
                        new ArrayList<>(Arrays.asList("COD", "SALMON", "PUFFERFISH", "TROPICAL_FISH", "NAUTILUS_SHELL", "INK_SAC", "GLOW_INK_SAC", "Seastone Shard")), false, 5120, false);
                        break;
                    case "Gigantic Fishing Sack":
                        applySack(event.getItem(), player, 9, "Gigantic Fishing Sack", "Large Fishing Sack",
                        new ArrayList<>(Arrays.asList("COD", "SALMON", "PUFFERFISH", "TROPICAL_FISH", "NAUTILUS_SHELL", "INK_SAC", "GLOW_INK_SAC", "Seastone Shard")), false, 10240, false);
                        break;
                    case "Humongous Fishing Sack":
                        applySack(event.getItem(), player, 9, "Humongous Fishing Sack", "Gigantic Fishing Sack",
                        new ArrayList<>(Arrays.asList("COD", "SALMON", "PUFFERFISH", "TROPICAL_FISH", "NAUTILUS_SHELL", "INK_SAC", "GLOW_INK_SAC", "Seastone Shard")), false, 20480, false);
                        break;
                    case "Fishing Sack Extension":
                        applySack(event.getItem(), player, 9, ChatColor.DARK_AQUA + "+", "Humongous Fishing Sack",
                        new ArrayList<>(Arrays.asList("COD", "SALMON", "PUFFERFISH", "TROPICAL_FISH", "NAUTILUS_SHELL", "INK_SAC", "GLOW_INK_SAC", "Seastone Shard")), false, 1280, true);
                        break;
                    case "Tiny Excavating Sack":
                        applySack(event.getItem(), player, 10, "Tiny Excavating Sack", "-",
                        new ArrayList<>(Arrays.asList("SAND", "RED_SAND", "SOUL_SAND", "SOUL_SOIL", "FLINT", "GRAVEL", "SNOWBALL", "SNOW", "PODZOL",
                            "MYCELIUM", "GRASS_BLOCK", "DIRT", "COARSE_DIRT", "ROOTED_DIRT", "Mud Ball", "CLAY_BALL", "CLAY")), true, 640, false);
                        break;
                    case "Small Excavating Sack":
                        applySack(event.getItem(), player, 10, "Small Excavating Sack", "Tiny Excavating Sack",
                        new ArrayList<>(Arrays.asList("SAND", "RED_SAND", "SOUL_SAND", "SOUL_SOIL", "FLINT", "GRAVEL", "SNOWBALL", "SNOW", "PODZOL",
                            "MYCELIUM", "GRASS_BLOCK", "DIRT", "COARSE_DIRT", "ROOTED_DIRT", "Mud Ball", "CLAY_BALL", "CLAY")), false, 1280, false);
                        break;
                    case "Medium Excavating Sack":
                        applySack(event.getItem(), player, 10, "Medium Excavating Sack", "Small Excavating Sack",
                        new ArrayList<>(Arrays.asList("SAND", "RED_SAND", "SOUL_SAND", "SOUL_SOIL", "FLINT", "GRAVEL", "SNOWBALL", "SNOW", "PODZOL",
                            "MYCELIUM", "GRASS_BLOCK", "DIRT", "COARSE_DIRT", "ROOTED_DIRT", "Mud Ball", "CLAY_BALL", "CLAY")), false, 2560, false);
                        break;
                    case "Large Excavating Sack":
                        applySack(event.getItem(), player, 10, "Large Excavating Sack", "Medium Excavating Sack",
                        new ArrayList<>(Arrays.asList("SAND", "RED_SAND", "SOUL_SAND", "SOUL_SOIL", "FLINT", "GRAVEL", "SNOWBALL", "SNOW", "PODZOL",
                            "MYCELIUM", "GRASS_BLOCK", "DIRT", "COARSE_DIRT", "ROOTED_DIRT", "Mud Ball", "CLAY_BALL", "CLAY")), false, 5120, false);
                        break;
                    case "Gigantic Excavating Sack":
                        applySack(event.getItem(), player, 10, "Gigantic Excavating Sack", "Large Excavating Sack",
                        new ArrayList<>(Arrays.asList("SAND", "RED_SAND", "SOUL_SAND", "SOUL_SOIL", "FLINT", "GRAVEL", "SNOWBALL", "SNOW", "PODZOL",
                            "MYCELIUM", "GRASS_BLOCK", "DIRT", "COARSE_DIRT", "ROOTED_DIRT", "Mud Ball", "CLAY_BALL", "CLAY")), false, 10240, false);
                        break;
                    case "Humongous Excavating Sack":
                        applySack(event.getItem(), player, 10, "Humongous Excavating Sack", "Gigantic Excavating Sack",
                        new ArrayList<>(Arrays.asList("SAND", "RED_SAND", "SOUL_SAND", "SOUL_SOIL", "FLINT", "GRAVEL", "SNOWBALL", "SNOW", "PODZOL",
                            "MYCELIUM", "GRASS_BLOCK", "DIRT", "COARSE_DIRT", "ROOTED_DIRT", "Mud Ball", "CLAY_BALL", "CLAY")), false, 20480, false);
                        break;
                    case "Excavating Sack Extension":
                        applySack(event.getItem(), player, 10, ChatColor.WHITE + "+", "Humongous Excavating Sack",
                        new ArrayList<>(Arrays.asList("SAND", "RED_SAND", "SOUL_SAND", "SOUL_SOIL", "FLINT", "GRAVEL", "SNOWBALL", "SNOW", "PODZOL",
                            "MYCELIUM", "GRASS_BLOCK", "DIRT", "COARSE_DIRT", "ROOTED_DIRT", "Mud Ball", "CLAY_BALL", "CLAY")), false, 1280, true);
                        break;
                    case "Sticky Bomb Launcher":
                        stickyBomb(player, mainHand);
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
    public void onRightClickEntity(PlayerInteractEntityEvent event) {
        boolean mainHand = true;
        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            mainHand = false;
        }
        ItemStack item;
        ItemStack eventItem;
        ItemMeta meta;

        boolean cancel = false;
        Entity interacted = event.getRightClicked();

        if (interacted != null && (
            interacted instanceof Villager ||
            interacted instanceof ArmorStand ||
            interacted instanceof Boat ||
            interacted instanceof Minecart ||
            interacted instanceof Llama ||
            interacted instanceof ChestedHorse)) {
            if (interacted instanceof Villager &&
                ((Villager)interacted).getProfession() == Villager.Profession.NONE ||
                ((Villager)interacted).getProfession() == Villager.Profession.NITWIT) {
            } else {
                event.setCancelled(true);
                return;
            }
        }

        if (mainHand) {
            eventItem = event.getPlayer().getInventory().getItemInMainHand();
        } else {
            eventItem = event.getPlayer().getInventory().getItemInOffHand();
        }

        if (event.getPlayer() != null && (
            eventItem.getType() == Material.FISHING_ROD ||
            eventItem.getType() == Material.SPYGLASS ||
            eventItem.getType() == Material.CROSSBOW ||
            eventItem.getType() == Material.TRIDENT ||
            eventItem.getType() == Material.SHIELD ||
            eventItem.getType() == Material.POTION ||
            eventItem.getType() == Material.WHITE_SHULKER_BOX ||
            eventItem.getType() == Material.ORANGE_SHULKER_BOX ||
            eventItem.getType() == Material.MAGENTA_SHULKER_BOX ||
            eventItem.getType() == Material.LIGHT_BLUE_SHULKER_BOX ||
            eventItem.getType() == Material.YELLOW_SHULKER_BOX ||
            eventItem.getType() == Material.LIME_SHULKER_BOX ||
            eventItem.getType() == Material.PINK_SHULKER_BOX ||
            eventItem.getType() == Material.GRAY_SHULKER_BOX ||
            eventItem.getType() == Material.LIGHT_GRAY_SHULKER_BOX ||
            eventItem.getType() == Material.CYAN_SHULKER_BOX ||
            eventItem.getType() == Material.PURPLE_SHULKER_BOX ||
            eventItem.getType() == Material.BLUE_SHULKER_BOX ||
            eventItem.getType() == Material.BROWN_SHULKER_BOX ||
            eventItem.getType() == Material.GREEN_SHULKER_BOX ||
            eventItem.getType() == Material.RED_SHULKER_BOX ||
            eventItem.getType() == Material.BLACK_SHULKER_BOX)) {
            cancel = false;
        }

        Player player = event.getPlayer();
        if (eventItem != null &&
            eventItem.getItemMeta() != null &&
            eventItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING) != null) {
            if (eventItem != null && (
                eventItem.getType() != Material.FISHING_ROD &&
                eventItem.getType() != Material.SPYGLASS &&
                eventItem.getType() != Material.CROSSBOW &&
                eventItem.getType() != Material.TRIDENT &&
                eventItem.getType() != Material.SHIELD &&
                eventItem.getType() != Material.POTION)) {
                cancel = true;
            }
            switch (eventItem.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
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

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Random ran = new Random();
        Player player = event.getEntity();
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

        if (chestRef.equals("Tenacious") && player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) != 0) {
            player.setInvulnerable(true);
            player.setHealth(20);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.setInvulnerable(false);
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, 0.0);
                    player.damage(1);
                }
            }, 100);
            return;
        }

        if (itemName.get(player).contains("Death Charm") &&
            ran.nextInt(50) == 0 && player.getInventory().contains(Items.DEATH_CHARM.getItem(plugin))) {
            player.setHealth(20);

            player.sendMessage(ChatColor.GREEN + "Your charm brought you back from the brink of death");
            player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 80, 0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE) / 5);
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
                        case "Quarterstaff":
                            reachAttack(player, 5);
                            break;
                        case "Flimsy Bamboo Spear":
                        case "Brittle Bone Spear":
                        case "Amethyst Spear":
                            reachAttack(player, 6);
                            break;
                        case "Bone Spear":
                        case "Bamboo Spear":
                            reachAttack(player, 7);
                            break;
                        case "Hunter Shortbow":
                            hunt(player);
                            break;
                        case "Drawstring Bag":
                            player.openInventory(new SacksGUI(plugin, player).getInventory());
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
                        case "Corrosive Pickaxe":
                            corrosivePick(player, block);
                            break;
                        case "Laser Drill X2085":
                            drill(player);
                            break;
                        case "Hunter Shortbow":
                            hunt(player);
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
                                simulateBreak(block, player);
                                block.breakNaturally();
                            }
                            break;
                        case "Quarterstaff":
                            reachAttack(player, 5);
                            break;
                        case "Flimsy Bamboo Spear":
                        case "Amethyst Spear":
                        case "Brittle Bone Spear":
                            reachAttack(player, 6);
                            break;
                        case "Bamboo Spear":
                        case "Bone Spear":
                            reachAttack(player, 7);
                            break;
                        case "Forester's Axe":
                        case "Lumberjack's Axe":
                            if (block.getType() == Material.AZALEA_LEAVES ||
                                block.getType() == Material.OAK_LEAVES ||
                                block.getType() == Material.DARK_OAK_LEAVES ||
                                block.getType() == Material.SPRUCE_LEAVES ||
                                block.getType() == Material.BIRCH_LEAVES ||
                                block.getType() == Material.ACACIA_LEAVES ||
                                block.getType() == Material.JUNGLE_LEAVES ||
                                block.getType() == Material.WARPED_WART_BLOCK ||
                                block.getType() == Material.NETHER_WART_BLOCK) {
                                simulateBreak(block, player);
                                block.breakNaturally();
                            }
                        case "Grove Axe":
                            ItemMeta groveMeta = player.getInventory().getItemInMainHand().getItemMeta();
                            switch (block.getType()) {
                                case OAK_LOG:
                                case OAK_WOOD:
                                case OAK_LEAVES:
                                case OAK_SAPLING:
                                    groveMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,"material"), PersistentDataType.STRING, "oak");
                                    break;
                                case DARK_OAK_LOG:
                                case DARK_OAK_WOOD:
                                case DARK_OAK_LEAVES:
                                case DARK_OAK_SAPLING:
                                    groveMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,"material"), PersistentDataType.STRING, "dark oak");
                                    break;
                                case BIRCH_LOG:
                                case BIRCH_WOOD:
                                case BIRCH_LEAVES:
                                case BIRCH_SAPLING:
                                    groveMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,"material"), PersistentDataType.STRING, "birch");
                                    break;
                                case SPRUCE_LOG:
                                case SPRUCE_WOOD:
                                case SPRUCE_LEAVES:
                                case SPRUCE_SAPLING:
                                    groveMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,"material"), PersistentDataType.STRING, "spruce");
                                    break;
                                case ACACIA_LOG:
                                case ACACIA_WOOD:
                                case ACACIA_LEAVES:
                                case ACACIA_SAPLING:
                                    groveMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,"material"), PersistentDataType.STRING, "acacia");
                                    break;
                                case JUNGLE_LOG:
                                case JUNGLE_WOOD:
                                case JUNGLE_LEAVES:
                                case JUNGLE_SAPLING:
                                    groveMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,"material"), PersistentDataType.STRING, "jungle");
                                    break;
                            }
                            player.getInventory().getItemInMainHand().setItemMeta(groveMeta);
                            break;
                        case "Imbalanced Pickaxe":
                            if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "broken"),
                                    PersistentDataType.INTEGER) % 5 == 0 && block.getBreakSpeed(player) != 0) {
                                simulateBreak(block, player);
                                block.breakNaturally();
                            }
                            break;
                        case "Aether Drive F117":
                            if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                    PersistentDataType.INTEGER) > 0 && block.getBreakSpeed(player) != 0) {
                                int amount = 1;
                                switch (block.getType()) {
                                    case MAGMA_BLOCK:
                                    case BASALT:
                                    case POLISHED_BASALT:
                                    case SMOOTH_BASALT:
                                    case COBBLESTONE:
                                    case MOSSY_COBBLESTONE:
                                    case BLACKSTONE:
                                    case AMETHYST_BLOCK:
                                    case AMETHYST_CLUSTER:
                                    case BUDDING_AMETHYST:
                                        amount = 2;
                                        break;
                                    case BONE_BLOCK:
                                    case GLOWSTONE:
                                    case NETHER_GOLD_ORE:
                                    case END_STONE:
                                    case NETHER_QUARTZ_ORE:
                                        amount = 3;
                                        break;
                                    case COAL_ORE:
                                    case IRON_ORE:
                                    case COPPER_ORE:
                                    case REDSTONE_ORE:
                                    case GOLD_ORE:
                                    case LAPIS_ORE:
                                    case DEEPSLATE:
                                    case DIAMOND_ORE:
                                    case EMERALD_ORE:
                                        amount = 5;
                                        break;
                                    case DEEPSLATE_COAL_ORE:
                                    case DEEPSLATE_IRON_ORE:
                                    case DEEPSLATE_COPPER_ORE:
                                    case DEEPSLATE_REDSTONE_ORE:
                                    case DEEPSLATE_GOLD_ORE:
                                    case DEEPSLATE_LAPIS_ORE:
                                    case DEEPSLATE_DIAMOND_ORE:
                                    case DEEPSLATE_EMERALD_ORE:
                                    case RAW_COPPER_BLOCK:
                                    case RAW_GOLD_BLOCK:
                                    case RAW_IRON_BLOCK:
                                        amount = 8;
                                        break;
                                    case OBSIDIAN:
                                    case ANCIENT_DEBRIS:
                                        amount = 20;
                                        break;

                                }
                                if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                        PersistentDataType.INTEGER) < amount) {
                                    return;
                                }
                                simulateBreak(block, player);
                                block.breakNaturally();
                                ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
                                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "fuel"),
                                        PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                                PersistentDataType.INTEGER) - amount);
                                player.getInventory().getItemInMainHand().setItemMeta(meta);
                                Items value = Items.values()[player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                                value.updateItem(plugin, player.getInventory().getItemInMainHand());
                            }
                            break;
                        case "Drawstring Bag":
                            player.openInventory(new SacksGUI(plugin, player).getInventory());
                            break;
                    }
                }
            }
        }
    }


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (itemName.get(player).contains("Feather Charm")) {
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
                            functions.updateHealth((LivingEntity)event.getHook().getHookedEntity());
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
                            functions.updateHealth((LivingEntity)event.getHook().getHookedEntity());
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
        echo_ward.put(player, player.getLocation());
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
        echo_ward.put(player, player.getLocation());
    }

    @EventHandler
    public void onEffect(EntityPotionEffectEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity();
        if (event.getAction() == EntityPotionEffectEvent.Action.ADDED) {

            ItemStack pet;
            if (pets.get(player) != null) {
                pet = pets.get(player);
            } else {
                pet = null;
            }
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

            if (pet != null &&
                    pet.getItemMeta() != null) {
                switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Cow":
                        if ((pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                PersistentDataType.STRING).equals("LEGENDARY") ||
                            pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                    PersistentDataType.STRING).equals("MYTHIC")) &&
                            event.getModifiedType().equals(PotionEffectType.POISON) ||
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
        ItemMeta meta;
        Items value;
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
                        PersistentDataType.STRING).equals("block")) {
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
                    case "Magmaton Furnace F2713":
                        if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                PersistentDataType.INTEGER) > 0) {
                            meta = player.getInventory().getItemInMainHand().getItemMeta();
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "fuel"),
                                PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "fuel"),
                                PersistentDataType.INTEGER) - 1);
                            player.getInventory().getItemInMainHand().setItemMeta(meta);
                            value = Items.values()[player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                            value.updateItem(plugin, player.getInventory().getItemInMainHand());
                        }
                        break;
                    case "Dull Pickaxe":
                        meta = player.getInventory().getItemInMainHand().getItemMeta();
                        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "broken"),
                                PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "broken"),
                                PersistentDataType.INTEGER) + 1);
                        if (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "broken"),
                                PersistentDataType.INTEGER) >= meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "next"),
                                PersistentDataType.INTEGER)) {
                            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "broken"),
                                    PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "broken"),
                                    PersistentDataType.INTEGER) - meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "next"),
                                    PersistentDataType.INTEGER));

                            switch (meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "next"),
                                    PersistentDataType.INTEGER)) {
                                case 100:
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "next"),
                                            PersistentDataType.INTEGER, 250);
                                    functions.addEnchant(player.getInventory().getItemInMainHand(), "Efficiency", 1);
                                    break;
                                case 250:
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "next"),
                                            PersistentDataType.INTEGER, 400);
                                    functions.addEnchant(player.getInventory().getItemInMainHand(), "Efficiency", 2);
                                    break;
                                case 400:
                                    meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                                            PersistentDataType.STRING, "Sharpened Pickaxe");
                                    functions.addEnchant(player.getInventory().getItemInMainHand(), "Efficiency", 3);
                            }
                        }
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                        value = Items.values()[player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)];
                        value.updateItem(plugin, player.getInventory().getItemInMainHand());
                        break;
                    case "Forester's Axe":
                        if ((block.getType() == Material.OAK_LOG ||
                            block.getType() == Material.DARK_OAK_LOG ||
                            block.getType() == Material.SPRUCE_LOG ||
                            block.getType() == Material.BIRCH_LOG ||
                            block.getType() == Material.ACACIA_LOG ||
                            block.getType() == Material.JUNGLE_LOG ||
                            block.getType() == Material.WARPED_STEM ||
                            block.getType() == Material.CRIMSON_STEM)) {
                            breakAdjacent(player, block);
                        }
                        break;
                    case "Woodcutter's Axe":
                        if (random.nextInt(5) >= 2 &&
                            (block.getType() == Material.OAK_LOG ||
                            block.getType() == Material.DARK_OAK_LOG ||
                            block.getType() == Material.SPRUCE_LOG ||
                            block.getType() == Material.BIRCH_LOG ||
                            block.getType() == Material.ACACIA_LOG ||
                            block.getType() == Material.JUNGLE_LOG ||
                            block.getType() == Material.WARPED_STEM ||
                            block.getType() == Material.CRIMSON_STEM)) {
                            breakAdjacent(player, block);
                        }
                        break;
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
                    }, 20);
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