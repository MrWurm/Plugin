package its.wurm.testplugin.statFunctions;

import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class StatFunctions {

    Plugin plugin;
    Attacks attacks;

    public StatFunctions(Plugin plugin, Attacks attacks) {
        this.plugin = plugin;
        this.attacks = attacks;
    }

    public LivingEntity findEntity(Location location, double range) {
        List<Entity> collection = (List<Entity>) location.getWorld().getNearbyEntities(location, range, range, range);
        for (int entity = 0; entity < collection.size(); ++entity) {
            if (collection.get(entity) instanceof LivingEntity) {
                return (LivingEntity) collection.get(entity);
            }
        }
        return null;
    }

    public void createTeam(Scoreboard board, String name, ChatColor color) {
        if (board.getTeam(name) != null) {
            return;
        }
        Team team = board.registerNewTeam(name);
        team.setColor(color);
    }

    public void heal(Plugin plugin, Entity entity, double amount) {
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE) == null) {
            return;
        }
        entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) + (amount * entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                    PersistentDataType.DOUBLE)));

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE) < entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE)) {
            entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE));
        }
    }

    public static void staticHeal(Plugin plugin, Entity entity, double amount) {
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE) == null) {
            return;
        }
        entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE) + (amount * entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                        PersistentDataType.DOUBLE)));

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE) < entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE)) {
            entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE));
        }
    }

    public List<Block> getNearbyBlocks(int RangeX, int RangeY, int RangeZ, Location location) {
        List<Block> list = new ArrayList<>();

        int RoundedX = (int)Math.round(location.getX());
        int RoundedY = (int)Math.round(location.getY());
        int RoundedZ = (int)Math.round(location.getZ());
        for (int deltaY = RangeY * -1; deltaY < RangeY; ++deltaY) {
            int finalY = RoundedY + deltaY;
            for (int deltaX = RangeX * -1; deltaX < RangeX; ++deltaX) {
                int finalX = RoundedX + deltaX;
                for (int deltaZ = RangeZ * -1; deltaZ < RangeZ; ++deltaZ) {
                    if (location.getWorld().getBlockAt(location) != null) {
                        list.add(location.getWorld().getBlockAt(finalX, finalY, RoundedZ - deltaZ));
                    }
                }
            }
        }

        return list;
    }

    public List<Block> getNearbyBlocksOnly(int RangeX, int RangeY, int RangeZ, Location location, List<Material> included) {
        List<Block> list = new ArrayList<>();

        int RoundedX = (int)Math.round(location.getX());
        int RoundedY = (int)Math.round(location.getY());
        int RoundedZ = (int)Math.round(location.getZ());
        for (int deltaY = RangeY * -1; deltaY < RangeY; ++deltaY) {
            int finalY = RoundedY + deltaY;
            for (int deltaX = RangeX * -1; deltaX < RangeX; ++deltaX) {
                int finalX = RoundedX + deltaX;
                for (int deltaZ = RangeZ * -1; deltaZ < RangeZ; ++deltaZ) {
                    Block block = location.getWorld().getBlockAt(finalX, finalY, RoundedZ - deltaZ);
                    if (block != null &&
                        included.contains(block.getType())) {
                        list.add(block);
                    }
                }
            }
        }

        return list;
    }

    public List<Block> getNearbyBlocksExcept(int RangeX, int RangeY, int RangeZ, Location location, List<Material> excluded) {
        List<Block> list = new ArrayList<>();

        int RoundedX = (int)Math.round(location.getX());
        int RoundedY = (int)Math.round(location.getY());
        int RoundedZ = (int)Math.round(location.getZ());
        for (int deltaY = RangeY * -1; deltaY < RangeY; ++deltaY) {
            int finalY = RoundedY + deltaY;
            for (int deltaX = RangeX * -1; deltaX < RangeX; ++deltaX) {
                int finalX = RoundedX + deltaX;
                for (int deltaZ = RangeZ * -1; deltaZ < RangeZ; ++deltaZ) {
                    Block block = location.getWorld().getBlockAt(finalX, finalY, RoundedZ - deltaZ);
                    if (block != null &&
                        (!excluded.contains(block.getType()))) {
                        list.add(block);
                    }
                }
            }
        }

        return list;
    }

    public Object CheckDamage(EntityDamageByEntityEvent event, Plugin plugin) {
        Entity entity = event.getDamager();
        Player player;
        if (entity instanceof Player) {
            player = (Player) entity;
            return player;
        }

        if (entity instanceof Projectile &&
            ((Projectile) entity).getShooter() instanceof Player) {
            player = (Player) ((Projectile) entity).getShooter();
            return player;
        }

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING) != null) {
            UUID uuid = UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                    PersistentDataType.STRING));
            if (Bukkit.getEntity(uuid) instanceof Player) {
                player = Bukkit.getPlayer(uuid);
                return player;
            }
        }
        return false;
    }


    public void CheckHealth(Entity entity, Main plugin) {

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE) == null) {
            //Check if the entity is a creature (you are not giving health to things like arrows for example
            if (entity instanceof LivingEntity) {

                org.bukkit.entity.LivingEntity creature = (LivingEntity) entity;

                creature.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                        9999999, 4, true, false));

                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE, ((LivingEntity) entity).getHealth());
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE, ((LivingEntity) entity).getHealth());
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                        PersistentDataType.DOUBLE, 0.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                        PersistentDataType.DOUBLE, 0.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                        PersistentDataType.STRING, "" + entity.getType());

                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING, "basic");

                if (entity instanceof Mob) {
                    entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING, "mob");
                }
                if (entity instanceof Animals) {
                    entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING, "animal");
                }


                String Name = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                        PersistentDataType.STRING);
                Double Health = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE);
                Double MaxHealth = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE);

                entity.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                        Health + "/" + MaxHealth);
            } else {
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE, 1.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE, 1.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                        PersistentDataType.DOUBLE, 0.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                        PersistentDataType.DOUBLE, 0.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                        PersistentDataType.STRING, "" + entity.getType());
            }
        }
        //Check if the entity does not have a damage container and add one if it does not have it
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE) == null) {
            entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 2.0);

            if (entity instanceof Projectile &&
                ((Projectile) entity).getShooter() != null &&
                ((Projectile) entity).getShooter() instanceof Entity) {
                Entity source = (Entity) ((Projectile) entity).getShooter();

                    if (source instanceof Player) {
                        double itemDamage = 0.0;
                        if (entity instanceof Arrow ||
                            entity instanceof SpectralArrow ||
                            entity instanceof ThrownPotion) {
                            itemDamage = source.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE);
                        }

                        if (((Player)source).getInventory().getItemInMainHand() != null &&
                            ((((Player)source).getInventory().getItemInMainHand().getType() == Material.TRIDENT) ||
                            ((Player)source).getInventory().getItemInMainHand().getType() == Material.BOW) ||
                            ((Player)source).getInventory().getItemInMainHand().getType() == Material.CROSSBOW) {
                            if (((Player)source).getInventory().getItemInMainHand().getItemMeta() != null &&
                                ((Player)source).getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
                                ((Player)source).getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE) != null) {
                                itemDamage = ((Player)source).getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE);
                            }
                        } else if (((Player)source).getInventory().getItemInOffHand() != null &&
                                    ((Player)source).getInventory().getItemInOffHand().getItemMeta() != null &&
                                    ((Player)source).getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer() != null &&
                                    ((Player)source).getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                        PersistentDataType.DOUBLE) != null &&
                                    ((Player)source).getInventory().getItemInMainHand().getType() != Material.SNOWBALL &&
                                    ((Player)source).getInventory().getItemInMainHand().getType() != Material.EGG &&
                                    ((Player)source).getInventory().getItemInMainHand().getType() != Material.SPLASH_POTION &&
                                    ((Player)source).getInventory().getItemInMainHand().getType() != Material.LINGERING_POTION &&
                                    ((Player)source).getInventory().getItemInMainHand().getType() != Material.FIREWORK_ROCKET) {

                                itemDamage = ((Player)source).getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                        PersistentDataType.DOUBLE);
                        }

                        boolean iscrit = false;
                        Random crit = new Random();
                        int choice = crit.nextInt(100) + 1;
                        if (choice <= source.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                                PersistentDataType.DOUBLE)) {
                            iscrit = true;
                        }
                        double AfterDamage = (source.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                                PersistentDataType.DOUBLE)/20) + 5 + itemDamage;
                        AfterDamage = ((source.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                                PersistentDataType.DOUBLE)/100) + 1) * AfterDamage;

                        AfterDamage = source.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                                PersistentDataType.DOUBLE) + 1 * AfterDamage;

                        if (choice <= source.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                                PersistentDataType.DOUBLE)) {
                            Double dmg = source.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                                    PersistentDataType.DOUBLE)/100;

                            AfterDamage = (dmg + 1) * AfterDamage;
                        }

                        entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE, AfterDamage);

                    } else {
                        entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE, source.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE));
                    }
            }
        }
    }

    public void ShowStat(Player player, Main plugin) {
        String message = String.format(
                "§c %.1f/%.1f ❤",

                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE),
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)

        );

        String message2 = String.format(
                "§b %.1f/%.1f ✎",

                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE),
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE)

        );
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message + "  " + message2));
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)) {

            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE));
        }

        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                PersistentDataType.DOUBLE)) {

            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE));
        }
    }

    public boolean checkType(ItemStack item, String category, Plugin plugin) {
        String type = "null";
        boolean True = false;
        if (item.getItemMeta() != null &&
                item.getItemMeta() != null &&
                item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                        PersistentDataType.STRING) != null) {
            type = item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "type"),
                    PersistentDataType.STRING);
        }

        if (category.equals("Armor")) {
            switch (type) {
                case "helmet":
                case "chestplate":
                case "leggings":
                case "boots":
                    True = true;
                    break;
                default:
                    break;
            }
        }

        if (type == category) {
            True = true;
        }

        return True;
    }

    public void targetPlayer(Mob entity, Plugin plugin, boolean repeat) {
        LivingEntity target = entity.getTarget();
        if (target != null &&
            !(target instanceof Player)) {
            entity.setTarget(null);
        }

        if (target == null) {
            double range = entity.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getValue();
            List<Entity> collection = entity.getNearbyEntities(range, range, range);

            if (!collection.isEmpty()) {
                for (int i = 0; i < collection.size(); i++) {
                    if (!(collection.get(i) instanceof LivingEntity) ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) != null && (
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) == "boss" ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) == "animal" ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) == entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING))) {
                        collection.remove(i);
                        i -= 1;
                    }
                }
                if (!collection.isEmpty()) {
                    LivingEntity player = (LivingEntity) collection.get(0);
                    entity.setTarget(player);
                }
            }
        }

        if (repeat) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    if (entity.isDead()) {
                        return;
                    }
                    targetPlayer(entity, plugin, true);
                }
            }, 10);
        }
    }

    public static void mobTargetPlayer(Mob entity, Plugin plugin, boolean repeat) {
        LivingEntity target = entity.getTarget();
        if (target != null &&
                target instanceof Mob) {
            entity.setTarget(null);
        }
        if (target == null) {
            double range = entity.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getValue();
            List<Entity> collection = entity.getNearbyEntities(range, range, range);

            if (!collection.isEmpty()) {
                for (int i = 0; i < collection.size(); i++) {
                    if (!(collection.get(i) instanceof LivingEntity) ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) != null && (
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) == "boss" ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) == "animal" ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) == entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING))) {
                        collection.remove(i);
                        i -= 1;
                    }
                }
                if (!collection.isEmpty()) {
                    LivingEntity player = (LivingEntity) collection.get(0);
                    entity.setTarget(player);
                }
            }
        }

        if (repeat) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    if (entity.isDead()) {
                        return;
                    }
                    mobTargetPlayer(entity, plugin, true);
                }
            }, 10);
        }
    }

    public void targetMob(Mob entity, Plugin plugin, boolean repeat) {
        LivingEntity target = entity.getTarget();

        if (target == null) {
            double range = entity.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getValue();
            List<Entity> collection = entity.getNearbyEntities(range, range, range);

            if (!collection.isEmpty()) {
                for (int i = 0; i < collection.size(); i++) {
                    if (!(collection.get(i) instanceof LivingEntity) ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) != null && (
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) == "animal" ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) == entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING))) {
                        collection.remove(i);
                        i -= 1;
                    }
                }
                if (!collection.isEmpty()) {
                    LivingEntity kill = (LivingEntity) collection.get(0);
                    entity.setTarget(kill);
                }
            }
        }

        if (repeat) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    if (entity.isDead()) {
                        return;
                    }
                    targetMob(entity, plugin, true);
                }
            }, 10);
        }
    }

    //check on bow shot reforges/sets/effects for the player
    public List<Object> reforgeOnShoot(Player player, Plugin plugin, double speed, boolean crit, long cooldown) {
        double time = 1.0;
        double power = 1.0;
        double velocity = 1.0;
        Location location;
        Random random = new Random();
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

        if (helmet.equals("Hunter's Cap")) {
            power += 0.1;
        }
        switch (mainRef) {
            case "Repeating":
                time -= 0.2;
                break;
        }

        List<Object> values = new ArrayList<>();
        values.add(power);
        values.add(velocity);
        values.add(mainRef);
        values.add(time);
        return values;
    }


    //check on bow shot reforges/sets/effects for the player
    public void arrowChanges(Player player, Plugin plugin, Arrow arrow) {
        Location location;
        Random random = new Random();
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

        switch (main) {
            case "Shortbow":
                //attacks.track(arrow, player, 5, 0.3);
                break;
        }
    }


    //check on bow shot reforges/sets/effects for the player
    public List<Double> reforgeOnBlock(Player player, Plugin plugin, double cooldown, double damage, boolean mainHand, Entity attacker) {
        double time = 1.0;

        Location location;
        Random random = new Random();
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

        if (mainHand) {
            switch (main) {
                case "Cactus Shield":

                    if (attacker instanceof LivingEntity) {
                        if (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE) != null) {
                            double health = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE);
                            attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, health - (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                                            PersistentDataType.DOUBLE) * 2));

                        }
                        ((LivingEntity) attacker).damage(1);
                    }
                    break;
                case "Sparkling Shield":
                    if (attacker instanceof LivingEntity) {

                        ((LivingEntity) attacker).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                        player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                                PersistentDataType.DOUBLE).intValue() / 25, 5, true, false));
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
                        }, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                                PersistentDataType.DOUBLE).intValue() / 25);
                    }
                    break;
                case "Holy Shield":
                    if (attacker instanceof LivingEntity) {

                        double defense = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                PersistentDataType.DOUBLE) / 10;
                        ((LivingEntity)attacker).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                                240, 5, true, false));
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                        PersistentDataType.DOUBLE) - defense);
                        if (((LivingEntity)attacker).hasPotionEffect(PotionEffectType.GLOWING) == false) {
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
            }
        } else {
            switch (off) {
                case "Cactus Shield":

                    if (attacker instanceof LivingEntity) {
                        if (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE) != null) {
                            double health = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE);
                            attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, health - (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                                            PersistentDataType.DOUBLE) * 2));

                        }
                        ((LivingEntity) attacker).damage(1);
                    }
                    break;
                case "Sparkling Shield":
                    if (attacker instanceof LivingEntity) {

                        ((LivingEntity) attacker).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                                        PersistentDataType.DOUBLE).intValue() / 25, 5, true, false));
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
                        }, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                                PersistentDataType.DOUBLE).intValue() / 25);
                    }
                    break;
                case "Holy Shield":
                    if (attacker instanceof LivingEntity) {

                        double defense = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                PersistentDataType.DOUBLE) / 10;
                        ((LivingEntity)attacker).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                                240, 5, true, false));
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                        PersistentDataType.DOUBLE) - defense);
                        if (((LivingEntity)attacker).hasPotionEffect(PotionEffectType.GLOWING) == false) {
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
            }
        }

        List<Double> values = new ArrayList<>();
        values.add(time);
        return values;
    }

    //check on deal damage reforges/sets/effects for the player
    public List<Double> reforgeOnDamage(Player player, Plugin plugin, double damage, boolean crit, boolean max, LivingEntity victim) {
        double power = 1.0;
        if (player.getAttackCooldown() > 0.35) {
            Location location;
            Random random = new Random();
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

            switch (mainRef) {
                case "Sharp":
                    if (crit) {
                        power += 0.15;
                    }
                    break;
                case "Venomous":
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                            80, 3));
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                            80, 0));
                    break;
                default:
                    break;
            }

            switch (main) {
                case "Rift Lance":
                    if (crit && random.nextInt(5) + 1 == 1) {
                        location = new Location(victim.getWorld(), victim.getLocation().getX() + random.nextInt(6) - 5, victim.getLocation().getY() + random.nextInt(3) + 1, victim.getLocation().getZ() + random.nextInt(6) - 5);
                        victim.teleport(location);
                    }
                    break;
                case "Moon Glove":
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,
                            40, 6));
                    break;
                case "Dev Hammer":
                    victim.remove();
                    break;
                case "Meat Cleaver":
                    int choice = random.nextInt(5);
                    switch (choice) {
                        case 0:
                            attacks.createItem(victim.getLocation(), 5955, Material.ROTTEN_FLESH, true);
                            break;
                        case 1:
                            attacks.createItem(victim.getLocation(), 5955, Material.BONE, true);
                            break;
                        case 2:
                            attacks.createItem(victim.getLocation(), 5955, Material.DRIED_KELP, true);
                            break;
                        case 3:
                            attacks.createItem(victim.getLocation(), 5955, Material.STRING, true);
                            break;
                        case 4:
                            attacks.createItem(victim.getLocation(), 5955, Material.FEATHER, true);
                            break;
                    }
                    victim.getWorld().spawnParticle(Particle.ITEM_CRACK, victim.getLocation(), 2, new ItemStack(Material.REDSTONE_BLOCK));
                    break;
                case "Slated Scimitar":
                    if (random.nextInt(20) == 0) {
                        victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                                30, 7, true, false));
                    }
                    break;
                case "Wither Scimitar":
                case "Litch Scimitar":
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,
                            240, 1, true, false));
                    break;
                case "Lithium Scimitar":
                    player.setInvulnerable(true);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            player.setInvulnerable(false);
                        }
                    }, 2);
                    break;
                case "Marauder Axe":
                    if (max) {
                        power += 0.5;
                    }
                    break;
                case "Stinger":
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                            300, 2, true, false));
                    break;
            }

            if (crit && helmet.equals("Studded Onyx Helmet") && chest.equals("Studded Onyx Chestplate") && legs.equals("Studded Onyx Leggings") && boots.equals("Studded Onyx Boots")) {
                heal(plugin, player, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE) / 30);
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                                PersistentDataType.DOUBLE) / 25) + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                                PersistentDataType.DOUBLE));
            }
        }

        List<Double> value = new ArrayList<>();
        value.add(power);
        return value;
    }

    //check on deal damage reforges/sets/effects for the player
    public void reforgeOnKill(Player player, Plugin plugin, Entity victim, String id) {
        Location location;
        Random random = new Random();
        if (id == null) {
            id = "";
        }
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

        switch (id) {
            case "BAMBOO_ARROW":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                    PersistentDataType.DOUBLE) + 8);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                                PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                                        PersistentDataType.DOUBLE) - 8));
                    }
                }, 200);
            break;
        }

        if (id.equals("Player")) {
            switch (main) {
                case "Ceremonial Scimitar":
                    heal(plugin, player, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE)/20);
                    break;
            }
        }

        return;
    }

    //check on ability reforges/sets/effects for player
    public List<Double> reforgeOnCast(Player player, Plugin plugin, double damage, double cooldown, double price) {
        double power = 1.0;
        double cost = 1.0;
        double speed = 1.0;
        Random random = new Random();
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

        switch (mainRef) {
            case "Antique":
                power += 0.4;
                cost += 1;
                break;
        }

        switch (offRef) {
            case "Antique":
                power += 0.4;
                cost += 1;
                break;
        }

        List<Double> value = new ArrayList<>();
        value.add(power);
        value.add(cost);
        value.add(speed);
        return value;
    }

    //check when player is damaged
    public List<Double> reforgeOnDamaged(Player player, Plugin plugin, double damage, Entity attacker) {
        double reduction = 1.0;

        Random random = new Random();
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

        if (attacker instanceof Bee && helmet.equals("Beekeeper Hat")) {
            reduction -= 0.1;
        }

        if (attacker instanceof Bee && chest.equals("Beekeeper Vest")) {
            reduction -= 0.1;
        }

        if (attacker instanceof Bee && legs.equals("Beekeeper Pants")) {
            reduction -= 0.1;
        }

        if (attacker instanceof Bee && boots.equals("Beekeeper Boots")) {
            reduction -= 0.1;
        }

        if (attacker instanceof LivingEntity && helmet.equals("Cactus Helmet") && chest.equals("Cactus Chestplate") && legs.equals("Cactus Leggings") && boots.equals("Cactus Boots")) {
            attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) - (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE) /10));
            ((LivingEntity)attacker).damage(1);
        }

        switch (helmetRef) {
            case "Meaty":
                switch (random.nextInt(4)) {
                    case 0:
                        player.playSound(player.getLocation(), Sound.ENTITY_COD_FLOP, 35, 1);
                        break;
                    case 1:
                        player.playSound(player.getLocation(), Sound.ENTITY_PUFFER_FISH_FLOP, 35, 1);
                        break;
                    case 2:
                        player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 35, 1);
                        break;
                    case 3:
                        player.playSound(player.getLocation(), Sound.ENTITY_TROPICAL_FISH_FLOP, 35, 1);
                        break;
                }
                break;
            case "Gooey":
                if (attacker instanceof LivingEntity) {
                    Double speed = 0.0;
                    if (attacker instanceof Player) {
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE) - 0.025);
                    } else {
                        speed = ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue();
                        ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed * 0.975);
                    }

                    Double finalSpeed = speed;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            if (attacker instanceof Player) {
                                attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                                PersistentDataType.DOUBLE) + 0.025);
                            } else {
                                ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + (finalSpeed * 0.025));
                            }
                        }
                    }, 100);


                    new BukkitRunnable() {
                        int iterations = 0;
                        public void run() {
                            if (iterations <= 20) {
                                this.cancel();
                                return;
                            }
                                attacker.getWorld().spawnParticle(Particle.DRIPPING_HONEY, attacker.getLocation(), 5);
                                iterations += 1;
                        }
                    }.runTaskTimer(plugin, 0, 5);
                }
                break;
        }

        switch (chestRef) {
            case "Meaty":
                switch (random.nextInt(4)) {
                    case 0:
                        player.playSound(player.getLocation(), Sound.ENTITY_COD_FLOP, 35, 1);
                        break;
                    case 1:
                        player.playSound(player.getLocation(), Sound.ENTITY_PUFFER_FISH_FLOP, 35, 1);
                        break;
                    case 2:
                        player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 35, 1);
                        break;
                    case 3:
                        player.playSound(player.getLocation(), Sound.ENTITY_TROPICAL_FISH_FLOP, 35, 1);
                        break;
                }
                break;
            case "Gooey":
                if (attacker instanceof LivingEntity) {
                    Double speed = 0.0;
                    if (attacker instanceof Player) {
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE) - 0.025);
                    } else {
                        speed = ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue();
                        ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed * 0.975);
                    }

                    Double finalSpeed = speed;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            if (attacker instanceof Player) {
                                attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                                PersistentDataType.DOUBLE) + 0.025);
                            } else {
                                ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + (finalSpeed * 0.025));
                            }
                        }
                    }, 100);


                    new BukkitRunnable() {
                        int iterations = 0;
                        public void run() {
                            if (iterations <= 20) {
                                this.cancel();
                                return;
                            }
                            attacker.getWorld().spawnParticle(Particle.DRIPPING_HONEY, attacker.getLocation(), 5);
                            iterations += 1;
                        }
                    }.runTaskTimer(plugin, 0, 5);
                }
                break;
        }

        switch (legsRef) {
            case "Meaty":
                switch (random.nextInt(4)) {
                    case 0:
                        player.playSound(player.getLocation(), Sound.ENTITY_COD_FLOP, 35, 1);
                        break;
                    case 1:
                        player.playSound(player.getLocation(), Sound.ENTITY_PUFFER_FISH_FLOP, 35, 1);
                        break;
                    case 2:
                        player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 35, 1);
                        break;
                    case 3:
                        player.playSound(player.getLocation(), Sound.ENTITY_TROPICAL_FISH_FLOP, 35, 1);
                        break;
                }
                break;
            case "Gooey":
                if (attacker instanceof LivingEntity) {
                    Double speed = 0.0;
                    if (attacker instanceof Player) {
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE) - 0.025);
                    } else {
                        speed = ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue();
                        ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed * 0.975);
                    }

                    Double finalSpeed = speed;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            if (attacker instanceof Player) {
                                attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                                PersistentDataType.DOUBLE) + 0.025);
                            } else {
                                ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + (finalSpeed * 0.025));
                            }
                        }
                    }, 100);


                    new BukkitRunnable() {
                        int iterations = 0;
                        public void run() {
                            if (iterations <= 20) {
                                this.cancel();
                                return;
                            }
                            attacker.getWorld().spawnParticle(Particle.DRIPPING_HONEY, attacker.getLocation(), 5);
                            iterations += 1;
                        }
                    }.runTaskTimer(plugin, 0, 5);
                }
                break;
        }

        switch (bootsRef) {
            case "Meaty":
                switch (random.nextInt(4)) {
                    case 0:
                        player.playSound(player.getLocation(), Sound.ENTITY_COD_FLOP, 35, 1);
                        break;
                    case 1:
                        player.playSound(player.getLocation(), Sound.ENTITY_PUFFER_FISH_FLOP, 35, 1);
                        break;
                    case 2:
                        player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 35, 1);
                        break;
                    case 3:
                        player.playSound(player.getLocation(), Sound.ENTITY_TROPICAL_FISH_FLOP, 35, 1);
                        break;
                }
                break;
            case "Gooey":
                if (attacker instanceof LivingEntity) {
                    Double speed = 0.0;
                    if (attacker instanceof Player) {
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE) - 0.025);
                    } else {
                        speed = ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue();
                        ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed * 0.975);
                    }

                    Double finalSpeed = speed;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            if (attacker instanceof Player) {
                                attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                        PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                                PersistentDataType.DOUBLE) + 0.025);
                            } else {
                                ((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(((LivingEntity)attacker).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + (finalSpeed * 0.025));
                            }
                        }
                    }, 100);


                    new BukkitRunnable() {
                        int iterations = 0;
                        public void run() {
                            iterations += 1;
                            if (iterations <= 20) {
                                this.cancel();
                                return;
                            }
                            attacker.getWorld().spawnParticle(Particle.DRIPPING_HONEY, attacker.getLocation(), 25);
                        }
                    }.runTaskTimer(plugin, 1, 5);
                }
                break;
        }

        List<Double> value = new ArrayList<>();
        value.add(reduction);
        return value;
    }
}
