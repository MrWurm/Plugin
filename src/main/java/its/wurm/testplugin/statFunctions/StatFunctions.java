package its.wurm.testplugin.statFunctions;

import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.persistentDataContainers.stringList;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

public class StatFunctions {

    Plugin plugin;
    Attacks attacks;

    public StatFunctions(Plugin plugin, Attacks attacks) {
        this.plugin = plugin;
        this.attacks = attacks;
    }

    static Map<Player, ItemStack> pets = new HashMap<>();
    Map<Player, List<LivingEntity>> dot_enchant = new HashMap<>();

    public void addPlayer(Player player) {
        dot_enchant.put(player, new ArrayList<>());
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

    public LivingEntity findEntity(Location location, double range, List<Entity> exclude) {
        List<Entity> collection = (List<Entity>) location.getWorld().getNearbyEntities(location, range, range, range);
        for (int entity = 0; entity < collection.size(); ++entity) {
            if (!(exclude.contains(collection.get(entity))) && collection.get(entity) instanceof LivingEntity) {
                return (LivingEntity) collection.get(entity);
            }
        }
        return null;
    }

    public LivingEntity findEntityExcept(Location location, double range, List<String> exclude) {
        List<Entity> collection = (List<Entity>) location.getWorld().getNearbyEntities(location, range, range, range);
        for (int entity = 0; entity < collection.size(); entity++) {
            if (collection.get(entity).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null &&
                !(exclude.contains(collection.get(entity).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING).equals(exclude)))) {
                return (LivingEntity) collection.get(entity);
            }
        }
        return null;
    }

    public LivingEntity findEntityOnly(Location location, double range, List<String> only) {
        List<Entity> collection = (List<Entity>) location.getWorld().getNearbyEntities(location, range, range, range);
        for (int entity = 0; entity < collection.size(); entity++) {
            if (collection.get(entity).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null &&
                only.contains(collection.get(entity).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                        PersistentDataType.STRING))) {
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

        if (!(entity instanceof Player)) {
            entity.setCustomName(ChatColor.GOLD + "" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) + "/" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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

        if (!(entity instanceof Player)) {
            entity.setCustomName(ChatColor.GOLD + "" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) + "/" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
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

    public static List<Block> getStaticNearbyBlocksOnly(int RangeX, int RangeY, int RangeZ, Location location, List<Material> included) {
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

    public void CheckHealth(Entity entity, Plugin plugin) {

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
                                PersistentDataType.STRING).equals("boss") ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING).equals("animal") ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING).equals(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING)))) {
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
        if (target != null ||
            (target != null &&
            target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING) != null && (
            target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING).equals("boss") ||
            target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING).equals("animal") ||
            target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING).equals(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING))))) {
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
                            PersistentDataType.STRING).equals("boss") ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING).equals("animal") ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING).equals(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING)))) {
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
        if (target != null ||
            (target != null &&
            target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null && (
            target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("animal") ||
            target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING))))) {
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
                            PersistentDataType.STRING).equals("animal") ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING).equals(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING)))) {
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
    public List<Object> reforgeOnShoot(Player player, Plugin plugin, double speed, boolean crit, long cooldown, boolean source) {
        double time = 1.0;
        double power = 1.0;
        double velocity = 1.0;
        Location location;
        Random random = new Random();
        String main = "";
        String mainRef = "";
        List<Object> mainEnchant = new ArrayList<>();
        String off = "";
        String offRef = "";
        List<Object> offEnchant = new ArrayList<>();
        String helmet = "";
        String helmetRef = "";
        List<Object> helmetEnchant = new ArrayList<>();
        String chest = "";
        String chestRef = "";
        List<Object> chestEnchant = new ArrayList<>();
        String legs = "";
        String legsRef = "";
        List<Object> legsEnchant = new ArrayList<>();
        String boots = "";
        String bootsRef = "";
        List<Object> bootsEnchant = new ArrayList<>();

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

        if (player.getInventory().getItemInMainHand() != null &&
            player.getInventory().getItemInMainHand().getItemMeta() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer() != null &&
            player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "shots"),
                    PersistentDataType.INTEGER) != null) {
            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "shots"),
                PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "shots"),
                PersistentDataType.INTEGER) + 1);
            player.getInventory().getItemInMainHand().setItemMeta(meta);
        }
        if (helmet.equals("Hunter's Cap")) {
            power += 0.1;
        }
        switch (mainRef) {
            case "Repeating":
                time -= 0.2;
                break;
            case "Sawed-Off":
                power += 1;
                break;
        }

        if (mainEnchant.size() > 0 &&
            Arrays.asList((String[])mainEnchant.get(0)).indexOf("Barrage") != -1) {
            cooldown -= ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Barrage")] * .03;
        }

        if (mainEnchant.size() > 0 &&
            Arrays.asList((String[])mainEnchant.get(0)).indexOf("Velocity") != -1) {
            velocity += ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Velocity")] * .05;
        }

        if (time < 0) {
            time = 0;
        }
        if (power < 0) {
            power = 0;
        }
        if (velocity < 0) {
            velocity = 0;
        }
        List<Object> values = new ArrayList<>();
        values.add(power);
        values.add(velocity);
        values.add(mainRef);
        values.add(time);
        return values;
    }


    //check on bow shot reforges/sets/effects for the player
    public void arrowChanges(Player player, Plugin plugin, Arrow arrow, boolean source, double velocity) {
        Location location;
        Random random = new Random();
        String main = "";
        String mainRef = "";
        List<Object> mainEnchant = new ArrayList<>();
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
                attacks.track(arrow, player, 3, 0.24);
                break;
        }

        switch (mainRef) {
            case "Sawed-Off":
                arrow.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(random.nextInt(31) - 15)));
                break;
        }

        if (mainEnchant.size() > 0 &&
            Arrays.asList((String[])mainEnchant.get(0)).indexOf("Pierce") != -1) {
            arrow.setPierceLevel(arrow.getPierceLevel() + ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Pierce")]);
        }

        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "enchantments"),
                new stringList(), (String[])mainEnchant.get(0));
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "levels"),
                PersistentDataType.INTEGER_ARRAY, (int[])mainEnchant.get(1));

        if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Recursive") != -1) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    if (((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Recursive")] * 4 >= new Random().nextInt(100)) {
                            Arrow arrow2 = attacks.createArrow(player.getEyeLocation(), arrow.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), player, player.getLocation().getDirection().multiply(velocity),
                            arrow.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING), arrow.getPierceLevel());
                        arrowChanges(player, plugin, arrow2, false, velocity);
                    }
                }
            }, 3);
        }
    }


    //check on bow shot reforges/sets/effects for the player
    public List<Double> reforgeOnBlock(Player player, Plugin plugin, double cooldown, double damage, boolean mainHand, Entity attacker) {
        double time = 1.0;

        Location location;
        Random random = new Random();
        String main = "";
        String mainRef = "";
        List<Object> mainEnchant = new ArrayList<>();
        String off = "";
        String offRef = "";
        List<Object> offEnchant = new ArrayList<>();
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
                mainEnchant.add(player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentName"),
                        new stringList()));
                mainEnchant.add(player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentPower"),
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

            switch (mainRef) {
                case "Stimulating":
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                                    PersistentDataType.DOUBLE) + (damage/10));
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                                    PersistentDataType.DOUBLE) + 20);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                                            PersistentDataType.DOUBLE) - (damage/5));
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                                            PersistentDataType.DOUBLE) - 20);
                        }
                    }, (long)cooldown);
                    break;
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Repair") != -1) {
                time -= ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Repair")] * .04;
            }

            if (offEnchant.size() > 0 &&
                    Arrays.asList((String[])offEnchant.get(0)).indexOf("Poison") != -1 &&
                    attacker instanceof LivingEntity) {
                ((LivingEntity)attacker).addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                        60, 1));
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
            switch (offRef) {
                case "Stimulating":
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                                    PersistentDataType.DOUBLE) + (damage/10));
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                                    PersistentDataType.DOUBLE) + 20);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"),
                                            PersistentDataType.DOUBLE) - (damage/5));
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBonus"),
                                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBonus"),
                                            PersistentDataType.DOUBLE) - 20);
                        }
                    }, (long)cooldown);
                    break;
            }

            if (offEnchant.size() > 0 &&
                Arrays.asList((String[])offEnchant.get(0)).indexOf("Repair") != -1) {
                time -= ((int[])offEnchant.get(1))[Arrays.asList((String[])offEnchant.get(0)).indexOf("Repair")] * .04;
            }

            if (offEnchant.size() > 0 &&
                Arrays.asList((String[])offEnchant.get(0)).indexOf("Poison") != -1 &&
                attacker instanceof LivingEntity) {
                ((LivingEntity)attacker).addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                        60, 1));
            }
        }

        if (time < 0) {
            time = 0;
        }
        List<Double> values = new ArrayList<>();
        values.add(time);
        return values;
    }

    //check on deal damage reforges/sets/effects for the player
    public List<Object> reforgeOnDamage(Player player, Plugin plugin, double damage, boolean crit, boolean max, LivingEntity victim) {
        double power = 1.0;
        boolean cancel = false;
        if (player.getAttackCooldown() > 0.35) {
            Location location;
            Random random = new Random();
            String main = "";
            String mainRef = "";
            List<Object> mainEnchant = new ArrayList<>();
            String off = "";
            String offRef = "";
            List<Object> offEnchant = new ArrayList<>();
            String helmet = "";
            String helmetRef = "";
            List<Object> helmetEnchant = new ArrayList<>();
            String chest = "";
            String chestRef = "";
            List<Object> chestEnchant = new ArrayList<>();
            String legs = "";
            String legsRef = "";
            List<Object> legsEnchant = new ArrayList<>();
            String boots = "";
            String bootsRef = "";
            List<Object> bootsEnchant = new ArrayList<>();
            ItemStack pet;
            if (pets.get(player) != null) {
                pet = pets.get(player);
            } else {
                pet = new ItemStack(Material.AIR);
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

            if (pet.getType() != Material.AIR) {
                switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Alien":
                        if (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                PersistentDataType.STRING).equals("RARE") ||
                            pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                    PersistentDataType.STRING).equals("EPIC") ||
                            pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                    PersistentDataType.STRING).equals("LEGENDARY") ||
                            pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                                    PersistentDataType.STRING).equals("MYTHIC")) {
                            new BukkitRunnable() {
                                public void run() {
                                    if (victim.isDead()) {
                                        this.cancel();
                                        return;
                                    }
                                    attacks.createLightning(victim.getLocation(), damage);
                                }
                            }.runTaskTimer(plugin, 50, 20);
                            if (victim instanceof Cow &&
                                victim.hasPotionEffect(PotionEffectType.LEVITATION)) {
                                player.kickPlayer(ChatColor.WHITE + "Bogos Binted");
                            }
                        }
                    break;
                }
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Smite") != -1 &&
                (victim.getType() == EntityType.SKELETON_HORSE ||
                victim.getType() == EntityType.ZOMBIFIED_PIGLIN ||
                victim.getType() == EntityType.DROWNED ||
                victim.getType() == EntityType.GIANT ||
                victim.getType() == EntityType.HUSK ||
                victim.getType() == EntityType.PHANTOM ||
                victim.getType() == EntityType.SKELETON ||
                victim.getType() == EntityType.STRAY ||
                victim.getType() == EntityType.WITHER ||
                victim.getType() == EntityType.WITHER_SKELETON ||
                victim.getType() == EntityType.ZOGLIN ||
                victim.getType() == EntityType.ZOMBIE ||
                victim.getType() == EntityType.ZOMBIE_VILLAGER)) {
                power += ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Smite")] * .12;
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Bane of Arthropods") != -1 &&
                (victim.getType() == EntityType.BEE ||
                victim.getType() == EntityType.CAVE_SPIDER ||
                victim.getType() == EntityType.SPIDER ||
                victim.getType() == EntityType.ENDERMITE ||
                victim.getType() == EntityType.SILVERFISH)) {
                power += ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Bane of Arthropods")] * .12;
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Exorcism") != -1 &&
                (victim.getType() == EntityType.ENDERMAN ||
                victim.getType() == EntityType.VEX ||
                victim.getType() == EntityType.BLAZE ||
                victim.getType() == EntityType.GHAST)) {
                power += ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Exorcism")] * .12;
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Cubism") != -1 &&
                (victim.getType() == EntityType.SLIME ||
                victim.getType() == EntityType.MAGMA_CUBE ||
                victim.getType() == EntityType.CREEPER ||
                victim.getType() == EntityType.SHULKER)) {
                power += ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Cubism")] * .08;
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Execute") != -1) {
                power += ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Execute")] * .2 *
                    (1 - ((victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE) - victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE))/victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE)));
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Pulverize") != -1) {
                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE) * (((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Pulverize")] * .0025 *
                    player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                            PersistentDataType.DOUBLE) * damage));
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Shred") != -1) {
                if (victim instanceof Player) {
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBonus"),
                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBonus"),
                        PersistentDataType.DOUBLE) - 5);
                } else {
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                        PersistentDataType.DOUBLE) - 5);
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        if (victim instanceof Player) {
                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBonus"),
                                PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBonus"),
                                PersistentDataType.DOUBLE) + 5);
                        } else {
                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                PersistentDataType.DOUBLE) + 5);
                        }
                    }
                }, ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Shred")] * 2);
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
                case "Hog Hammer":
                    if (victim.getPassengers() != null || victim.getVehicle() != null) {
                        power += 0.35;
                    }
                    break;
                case "Amethyst Spear":
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                            60, 1, true, false));
                    break;
                case "Elite's Shiv":
                    if (player.getLocation().distance(victim.getLocation()) > 2) {
                        cancel = true;
                    }
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

            if (power < 0) {
                power = 0;
            }
            Double powerDot = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) * damage * power;
            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Fire Aspect") != -1 &&
                !(dot_enchant.get(player).contains(victim))) {
                victim.setFireTicks(victim.getFireTicks() + 100);
                List<LivingEntity> list = dot_enchant.get(player);
                list.add(victim);
                dot_enchant.put(player, list);
                new BukkitRunnable() {
                    int iterations = 0;
                    double amount = powerDot *
                        ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Fire Aspect")] * .015;
                    public void run()
                    {
                        if (victim.isDead() || iterations >= 5) {
                            List<LivingEntity> list = dot_enchant.get(player);
                            list.remove(victim);
                            dot_enchant.put(player, list);
                            this.cancel();
                            return;
                        }
                        iterations += 1;
                        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) - amount);
                        updateHealth(victim);
                    }
                }.runTaskTimer(plugin, 20, 20);
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Venomous") != -1 &&
                    !(dot_enchant.get(player).contains(victim))) {
                victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                        100, 0, true, false));
                double speed = victim.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() * 0.05 *
                    ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Venomous")];
                victim.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(victim.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() - speed);
                List<LivingEntity> list = dot_enchant.get(player);
                list.add(victim);
                dot_enchant.put(player, list);
                new BukkitRunnable() {
                    int iterations = 0;
                    double amount = powerDot * ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Venomous")] * .006;
                    public void run()
                    {
                        if (victim.isDead() || iterations >= 5) {
                            victim.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(victim.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() + speed);
                            List<LivingEntity> list = dot_enchant.get(player);
                            list.remove(victim);
                            dot_enchant.put(player, list);
                            this.cancel();
                            return;
                        }
                        iterations += 1;
                        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) - amount);
                        updateHealth(victim);
                    }
                }.runTaskTimer(plugin, 20, 20);
            }

            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Decay") != -1 &&
                    !(dot_enchant.get(player).contains(victim))) {
                victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER,
                        160, 0, true, false));
                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                                PersistentDataType.DOUBLE) - (((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Decay")] * .01));
                List<LivingEntity> list = dot_enchant.get(player);
                list.add(victim);
                dot_enchant.put(player, list);
                new BukkitRunnable() {
                    int iterations = 0;
                    double amount = powerDot * ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Decay")] * .0075;
                    public void run()
                    {
                        if (victim.isDead() || iterations >= 8) {
                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                                PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                                PersistentDataType.DOUBLE) + (((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Decay")] * .01));
                            List<LivingEntity> list = dot_enchant.get(player);
                            list.remove(victim);
                            dot_enchant.put(player, list);
                            this.cancel();
                            return;
                        }
                        iterations += 1;
                        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) - amount);
                        updateHealth(victim);
                    }
                }.runTaskTimer(plugin, 20, 20);
            }
        }


        if (power < 0) {
            power = 0;
        }
        List<Object> value = new ArrayList<>();
        value.add(power);
        value.add(cancel);
        return value;
    }

    public void updateHealth(LivingEntity entity) {
        entity.setCustomName(ChatColor.GOLD + "" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE) + "/" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE));
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) <= 1) {
            entity.setHealth(0);
        }
    }

    public static void staticUpdateHealth(LivingEntity entity, Plugin plugin) {
        entity.setCustomName(ChatColor.GOLD + "" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
                entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE) + "/" + entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE));
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) <= 1) {
            entity.setHealth(0);
        }
    }

    //check on deal damage reforges/sets/effects for the player
    public void reforgeOnKill(Player player, Plugin plugin, Entity victim, String id) {
        Location location;
        ItemStack item;
        ItemMeta meta;
        Random random = new Random();
        if (id == null) {
            id = "";
        }
        List<ItemStack> listItem = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            if (player.getInventory().getItem(i) != null &&
                    player.getInventory().getItem(i).getItemMeta() != null &&
                    player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer() != null &&
                    player.getInventory().getItem(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                listItem.add(player.getInventory().getItem(i));
            }
        }

        List<String> listName = new ArrayList<>();
        for (int i = 0; i < listItem.size(); i++) {
            listName.add(listItem.get(i).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING));
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

        if (listName.contains("NFT Mint")) {
            boolean cont = true;
            item = Items.NFT.getItem(plugin);
            meta = item.getItemMeta();
            if (cont && victim instanceof Player && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "minted"),
                    PersistentDataType.INTEGER) == null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "name"),
                        PersistentDataType.STRING, (((Player) victim).getDisplayName()));
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "uuid"),
                        PersistentDataType.STRING, victim.getUniqueId().toString());
                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "minted"),
                        PersistentDataType.INTEGER, 1);
                cont = false;
                Bukkit.broadcastMessage("player");
            }

            if (cont && random.nextInt(20) == 0 && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) == null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "name"),
                        PersistentDataType.STRING, victim.getType().toString());
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "uuid"),
                        PersistentDataType.STRING, victim.getUniqueId().toString());
                cont = false;
            }

            if (cont && random.nextInt(40) == 0 && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("animal")) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "name"),
                        PersistentDataType.STRING, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"),
                                PersistentDataType.STRING));
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "uuid"),
                        PersistentDataType.STRING, victim.getUniqueId().toString());
                cont = false;
            }

            if (cont && random.nextInt(100) == 0 && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("mob")) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "name"),
                        PersistentDataType.STRING, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"),
                                PersistentDataType.STRING));
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "uuid"),
                        PersistentDataType.STRING, victim.getUniqueId().toString());
                cont = false;
            }

            if (cont && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null &&
                    victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("boss")) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "name"),
                        PersistentDataType.STRING, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"),
                                PersistentDataType.STRING));
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "uuid"),
                        PersistentDataType.STRING, victim.getUniqueId().toString());
                cont = false;
            }

            if (cont && victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING) != null &&
                    !(victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("mob")) &&
                    !(victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("animal")) &&
                    !(victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals("boss"))) {
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "name"),
                        PersistentDataType.STRING, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "name"),
                                PersistentDataType.STRING));
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "uuid"),
                        PersistentDataType.STRING, victim.getUniqueId().toString());
                cont = false;
            }

            if (!cont) {
                item.setItemMeta(meta);
                Items.NFT.updateItem(plugin, item);
                player.getInventory().addItem(item);
            }
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
    public List<Double> reforgeOnCast(Player player, Plugin plugin, double damage, double cooldown, double price, boolean hand) {
        double power = 1.0;
        double cost = 1.0;
        double speed = 1.0;
        Random random = new Random();
        String main = "";
        List<Object> mainEnchant = new ArrayList<>();
        String mainRef = "";
        String off = "";
        List<Object> offEnchant = new ArrayList<>();
        String offRef = "";
        String helmet = "";
        String helmetRef = "";
        String chest = "";
        String chestRef = "";
        String legs = "";
        String legsRef = "";
        String boots = "";
        String bootsRef = "";
        ItemStack pet;
        if (pets.get(player) != null) {
            pet = pets.get(player);
        } else {
            pet = new ItemStack(Material.AIR);
        }

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        double cap = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                PersistentDataType.DOUBLE);

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

        if ((helmet.equals("Invoker Hood") || helmet.equals("Incanter Hood") || helmet.equals("Mystic Hood") || helmet.equals("Chanter Hood")) &&
            (chest.equals("Invoker Robes") || chest.equals("Incanter Robes") || chest.equals("Mystic Robes") || chest.equals("Chanter Robes")) &&
            (legs.equals("Invoker Trousers") || legs.equals("Incanter Trousers") || legs.equals("Mystic Trousers") || legs.equals("Chanter Trousers")) &&
            (boots.equals("Invoker Boots") || boots.equals("Incanter Boots") || boots.equals("Mystic Boots") || boots.equals("Chanter Boots"))) {
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBonus"),
                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBonus"),
                PersistentDataType.DOUBLE) + price / 12.5);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBonus"),
                            PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBonus"),
                            PersistentDataType.DOUBLE) - price / 12.5));
                }
            }, 240);
        }

        if (pet != null) {
            switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "Alien":
                    switch (pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                            PersistentDataType.STRING)) {
                        case "LEGENDARY":
                        case "MYTHIC":
                            cost -= pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                    PersistentDataType.INTEGER) * 0.0099;
                            break;
                        case "EPIC":
                            cost -= pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                    PersistentDataType.INTEGER) * 0.009;
                            break;
                        case "RARE":
                            cost -= pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                    PersistentDataType.INTEGER) * 0.0083;
                            break;
                        case "UNCOMMON":
                            cost -= pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                    PersistentDataType.INTEGER) * 0.0071;
                            break;
                        case "COMMON":
                            cost -= pet.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "level"),
                                    PersistentDataType.INTEGER) * 0.0063;
                            break;
                    }
            }
        }
        if (hand) {
            switch (mainRef) {
                case "Antique":
                    power += 0.4;
                    cost += 1;
                    break;
            }
            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Wisdom") != -1) {
                cost -= ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Wisdom")] * .04;
            }
            if (mainEnchant.size() > 0 &&
                Arrays.asList((String[])mainEnchant.get(0)).indexOf("Astute") != -1) {
                speed -= ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Astute")] * .05;
            }
        } else {
            switch (offRef) {
                case "Antique":
                    power += 0.4;
                    cost += 1;
                    break;
            }
            if (offEnchant.size() > 0 &&
                Arrays.asList((String[])offEnchant.get(0)).indexOf("Wisdom") != -1) {
                cost -= ((int[])offEnchant.get(1))[Arrays.asList((String[])offEnchant.get(0)).indexOf("Wisdom")] * .04;
            }
            if (offEnchant.size() > 0 &&
                Arrays.asList((String[])offEnchant.get(0)).indexOf("Astute") != -1) {
                speed -= ((int[])offEnchant.get(1))[Arrays.asList((String[])offEnchant.get(0)).indexOf("Astute")] * .05;
            }
        }

        if (power < 0) {
            power = 0;
        }
        if (cost < 0) {
            cost = 0;
        }
        if (speed < 0) {
            speed = 0;
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
        List<Object> mainEnchant = new ArrayList<>();
        String off = "";
        String offRef = "";
        List<Object> offEnchant = new ArrayList<>();
        String helmet = "";
        String helmetRef = "";
        List<Object> helmetEnchant = new ArrayList<>();
        String chest = "";
        String chestRef = "";
        List<Object> chestEnchant = new ArrayList<>();
        String legs = "";
        String legsRef = "";
        List<Object> legsEnchant = new ArrayList<>();
        String boots = "";
        String bootsRef = "";
        List<Object> bootsEnchant = new ArrayList<>();

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

        if (chestEnchant.size() > 0 &&
            Arrays.asList((String[])chestEnchant.get(0)).indexOf("Stalwart") != -1) {
            reduction += ((int[])chestEnchant.get(1))[Arrays.asList((String[])chestEnchant.get(0)).indexOf("Stalwart")] * .03;
        }

        if (helmetEnchant.size() > 0 &&
            Arrays.asList((String[])helmetEnchant.get(0)).indexOf("Resolute") != -1) {
            reduction += ((int[])helmetEnchant.get(1))[Arrays.asList((String[])helmetEnchant.get(0)).indexOf("Resolute")] * .004;
        }
        if (chestEnchant.size() > 0 &&
            Arrays.asList((String[])chestEnchant.get(0)).indexOf("Resolute") != -1) {
            reduction += ((int[])chestEnchant.get(1))[Arrays.asList((String[])chestEnchant.get(0)).indexOf("Resolute")] * .03;
        }
        if (legsEnchant.size() > 0 &&
            Arrays.asList((String[])legsEnchant.get(0)).indexOf("Resolute") != -1) {
            reduction += ((int[])legsEnchant.get(1))[Arrays.asList((String[])legsEnchant.get(0)).indexOf("Resolute")] * .03;
        }
        if (bootsEnchant.size() > 0 &&
            Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Resolute") != -1) {
            reduction += ((int[])bootsEnchant.get(1))[Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Resolute")] * .03;
        }

        if (mainEnchant.size() > 0 &&
            Arrays.asList((String[])mainEnchant.get(0)).indexOf("Fortify") != -1) {
            reduction += ((int[])mainEnchant.get(1))[Arrays.asList((String[])mainEnchant.get(0)).indexOf("Fortify")] * .04;
        }
        if (offEnchant.size() > 0 &&
            Arrays.asList((String[])offEnchant.get(0)).indexOf("Fortify") != -1 &&
            (!(mainEnchant.size() > 0) ||
            !(Arrays.asList((String[])mainEnchant.get(0)).indexOf("Fortify") != -1))) {
            reduction += ((int[])offEnchant.get(1))[Arrays.asList((String[])offEnchant.get(0)).indexOf("Fortify")] * .02;
        }

        if (helmetEnchant.size() > 0 &&
            Arrays.asList((String[])helmetEnchant.get(0)).indexOf("Masochism") != -1) {
            double mod = ((int[])helmetEnchant.get(1))[Arrays.asList((String[])helmetEnchant.get(0)).indexOf("Masochism")] * .002;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                PersistentDataType.DOUBLE) + mod);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE) - mod);
                }
            }, 100);
        }
        if (chestEnchant.size() > 0 &&
                Arrays.asList((String[])chestEnchant.get(0)).indexOf("Masochism") != -1) {
            double mod = ((int[])chestEnchant.get(1))[Arrays.asList((String[])chestEnchant.get(0)).indexOf("Masochism")] * .002;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                            PersistentDataType.DOUBLE) + mod);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE) - mod);
                }
            }, 100);
        }
        if (legsEnchant.size() > 0 &&
                Arrays.asList((String[])legsEnchant.get(0)).indexOf("Masochism") != -1) {
            double mod = ((int[])legsEnchant.get(1))[Arrays.asList((String[])legsEnchant.get(0)).indexOf("Masochism")] * .002;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                            PersistentDataType.DOUBLE) + mod);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE) - mod);
                }
            }, 100);
        }
        if (bootsEnchant.size() > 0 &&
                Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Masochism") != -1) {
            double mod = ((int[])bootsEnchant.get(1))[Arrays.asList((String[])bootsEnchant.get(0)).indexOf("Masochism")] * .002;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                            PersistentDataType.DOUBLE) + mod);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifierBonus"),
                        PersistentDataType.DOUBLE) - mod);
                }
            }, 100);
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
            case "Camouflaged":
                if (random.nextInt(40) == 0) {reduction -= 10;}
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
            case "Camouflaged":
                if (random.nextInt(40) == 0) {reduction -= 10;}
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
            case "Camouflaged":
                if (random.nextInt(40) == 0) {reduction -= 10;}
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
            case "Camouflaged":
                if (random.nextInt(40) == 0) {reduction -= 10;}
                break;
        }

        if (helmet.equals("Silverfish Helmet") && random.nextInt(20) == 0) {
            Silverfish summon = player.getLocation().getWorld().spawn(player.getLocation(), Silverfish.class);
            double mod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE) / 100 + 1;

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE) / .05) * mod);
            double strength = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
            strength *= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/100;
            strength *= (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 1) * mod;
            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, strength);
        }

        if (chest.equals("Silverfish Chestplate") && random.nextInt(20) == 0) {
            Silverfish summon = player.getLocation().getWorld().spawn(player.getLocation(), Silverfish.class);
            double mod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE) / 100 + 1;

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                            PersistentDataType.DOUBLE) / .05) * mod);
            double strength = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
            strength *= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/100;
            strength *= (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 1) * mod;
            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, strength);
        }

        if (legs.equals("Silverfish Leggings") && random.nextInt(20) == 0) {
            Silverfish summon = player.getLocation().getWorld().spawn(player.getLocation(), Silverfish.class);
            double mod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE) / 100 + 1;

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                            PersistentDataType.DOUBLE) / .05) * mod);
            double strength = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
            strength *= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/100;
            strength *= (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 1) * mod;
            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, strength);
        }

        if (boots.equals("Silverfish Boots") && random.nextInt(20) == 0) {
            Silverfish summon = player.getLocation().getWorld().spawn(player.getLocation(), Silverfish.class);
            double mod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                    PersistentDataType.DOUBLE) / 100 + 1;

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) / .05) * mod);

            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                            PersistentDataType.DOUBLE) / .05) * mod);
            double strength = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
            strength *= player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/100;
            strength *= (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 1) * mod;
            summon.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, strength);
        }
        if (reduction < 0) {
            reduction = 0;
        }

        List<Double> value = new ArrayList<>();
        value.add(reduction);
        return value;
    }

    public void addEnchant(ItemStack item, String enchantment, int level) {
        ItemMeta meta = item.getItemMeta();
        String[] listName = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentName"), new stringList());
        int[] listPower = meta.getPersistentDataContainer().get(new NamespacedKey(plugin,"enchantmentPower"), PersistentDataType.INTEGER_ARRAY);

        int index = Arrays.asList(listName).indexOf(enchantment);
        if (index != -1) {
            listPower[index] = level;
        } else {
            listPower = Arrays.copyOf(listPower, listPower.length + 1);
            listPower[listPower.length - 1] = level;
            listName = Arrays.copyOf(listName, listName.length + 1);
            listName[listName.length - 1] = enchantment;
        }

        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentName"), new stringList(), listName);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin,"enchantmentPower"), PersistentDataType.INTEGER_ARRAY, listPower);
        item.setItemMeta(meta);
        Items.values()[meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "ordinal"), PersistentDataType.INTEGER)].updateItem(plugin, item);
    }

    public void effectRemoved(String effect, int level, Player player) {
        switch (effect) {
            case "Strength":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE)
                    - (level * 20));
                break;
            case "Speed":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE)
                    - (level * 5));
                break;
            case "Luck":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBonus"), PersistentDataType.DOUBLE)
                    - (level * 4));
                break;
            case "Invigoration":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBonus"), PersistentDataType.DOUBLE)
                    - (level * 100));
                break;
            case "Harvesting":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmBonus"), PersistentDataType.DOUBLE)
                    - (level * 6));
                break;
            case "Spelunking":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"), PersistentDataType.DOUBLE)
                    - (level * 6));
                break;
            case "Eminence":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntelligenceBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceBonus"), PersistentDataType.DOUBLE)
                    - (level * 40));
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationBonus"), PersistentDataType.DOUBLE)
                    - (level * 12));
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBonus"), PersistentDataType.DOUBLE)
                    - (level * 12));
                break;
            case "Jump Boost":
                player.removePotionEffect(PotionEffectType.JUMP);
                break;
            case "Fire Resistance":
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                break;
            case "Water Breathing":
                player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                break;
            case "Slow Falling":
                player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                break;
            case "Night Vision":
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                break;
        }
    }

    public void effectAdd(String effect, int level, Player player) {
        switch (effect) {
            case "Strength":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE,
            player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE)
                + (level * 20));
                break;
            case "Speed":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBonus"), PersistentDataType.DOUBLE)
                    + (level * 5));
                break;
            case "Luck":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MagicBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MagicBonus"), PersistentDataType.DOUBLE)
                    + (level * 4));
                break;
            case "Invigoration":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBonus"), PersistentDataType.DOUBLE)
                    + (level * 100));
                break;
            case "Harvesting":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmBonus"), PersistentDataType.DOUBLE)
                    + (level * 6));
                break;
            case "Spelunking":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineBonus"), PersistentDataType.DOUBLE)
                    + (level * 6));
                break;
            case "Eminence":
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntelligenceBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntelligenceBonus"), PersistentDataType.DOUBLE)
                    + (level * 40));
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "InvocationBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "InvocationBonus"), PersistentDataType.DOUBLE)
                    + (level * 12));
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ThaumaturgyBonus"), PersistentDataType.DOUBLE,
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ThaumaturgyBonus"), PersistentDataType.DOUBLE)
                    + (level * 12));
                break;
            case "Jump Boost":
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                        9999999, level - 1, true, false));
                break;
            case "Fire Resistance":
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,
                        9999999, 0, true, false));
                break;
            case "Water Breathing":
                player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,
                        9999999, 0, true, false));
                break;
            case "Slow Falling":
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,
                        9999999, level - 1, true, false));
                break;
            case "Night Vision":
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,
                        9999999, 0, true, false));
                break;
        }
    }

    public ItemStack createPotions(String ingredient, String base, String inhibitor, String amplifier, String additive, String configuration) {
        ItemStack potion = Items.EMPTY_POTION.getItem(plugin);
        PotionMeta meta = (PotionMeta)potion.getItemMeta();
        int power;
        long duration = 300000;
        switch (ingredient) {
            case "BLAZE_POWDER":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Strength");
                meta.setColor(Color.fromRGB(161, 26, 26));
                break;
            case "Enchanted Blaze Powder":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Strength");
                meta.setColor(Color.fromRGB(161, 26, 26));
                break;
            case "Enchanted Blaze Rod":
                power = 5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Strength");
                meta.setColor(Color.fromRGB(161, 26, 26));
                break;
            case "SUGAR":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Speed");
                meta.setColor(Color.fromRGB(230, 222, 216));
                break;
            case "Enchanted Sugar Cane":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Speed");
                meta.setColor(Color.fromRGB(230, 222, 216));
                break;
            case "Enchanted Sugar":
                power = 5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Speed");
                meta.setColor(Color.fromRGB(230, 222, 216));
                break;
            case "RABBIT_FOOT":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Jump Boost");
                meta.setColor(Color.fromRGB(137, 247, 82));
                break;
            case "Enchanted Rabbit":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Jump Boost");
                meta.setColor(Color.fromRGB(137, 247, 82));
                break;
            case "Enchanted Iron":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Ironskin");
                meta.setColor(Color.fromRGB(55, 59, 53));
                break;
            case "Enchanted Iron Block":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Ironskin");
                meta.setColor(Color.fromRGB(55, 59, 53));
                break;
            case "Pure Iron Nugget":
                power = 5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Ironskin");
                meta.setColor(Color.fromRGB(55, 59, 53));
                break;
            case "MAGMA_CREAM":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Fire Resistance");
                meta.setColor(Color.fromRGB(255, 179, 0));
                break;
            case "Enchanted Magma Cream":
                power = 1;
                duration *= 1.5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Fire Resistance");
                meta.setColor(Color.fromRGB(255, 179, 0));
                break;
            case "Enchanted Magma Block":
                power = 1;
                duration *= 3.7;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Fire Resistance");
                meta.setColor(Color.fromRGB(255, 179, 0));
                break;
            case "PUFFERFISH":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Water Breathing");
                meta.setColor(Color.fromRGB(12, 93, 242));
                break;
            case "Enchanted Pufferfish":
                power = 1;
                duration *= 1.5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Water Breathing");
                meta.setColor(Color.fromRGB(12, 93, 242));
                break;
            case "GOLDEN_CARROT":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Night Vision");
                meta.setColor(Color.fromRGB(25, 67, 145));
                break;
            case "Enchanted Carrot":
                power = 1;
                duration *= 1.5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Night Vision");
                meta.setColor(Color.fromRGB(25, 67, 145));
                break;
            case "Enchanted Golden Carrot":
                power = 1;
                duration *= 3.7;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Night Vision");
                meta.setColor(Color.fromRGB(25, 67, 145));
                break;
            case "FEATHER":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Slow Falling");
                meta.setColor(Color.fromRGB(207, 227, 222));
                break;
            case "Enchanted Feather":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Slow Falling");
                meta.setColor(Color.fromRGB(207, 227, 222));
                break;
            case "Feather Charm":
                power = 5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Slow Falling");
                meta.setColor(Color.fromRGB(207, 227, 222));
                break;
            case "GHAST_TEAR":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Regeneration");
                meta.setColor(Color.fromRGB(196, 104, 129));
                break;
            case "Enchanted Ghast Tear":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Regeneration");
                meta.setColor(Color.fromRGB(196, 104, 129));
                break;
            case "Distilled Soul Essence":
                power = 5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Regeneration");
                meta.setColor(Color.fromRGB(196, 104, 129));
                break;
            case "DIAMOND":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Spelunking");
                meta.setColor(Color.fromRGB(75, 148, 110));
                break;
            case "Enchanted Diamond":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Spelunking");
                meta.setColor(Color.fromRGB(75, 148, 110));
                break;
            case "Gemstone":
                power = 5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Spelunking");
                meta.setColor(Color.fromRGB(75, 148, 110));
                break;
            case "POTATO":
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Harvesting");
                meta.setColor(Color.fromRGB(201, 173, 32));
                break;
            case "Enchanted Potato":
                power = 3;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Harvesting");
                meta.setColor(Color.fromRGB(201, 173, 32));
                break;
            case "Enchanted Baked Potato":
                power = 5;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Harvesting");
                meta.setColor(Color.fromRGB(201, 173, 32));
                break;
            default:
                power = 1;
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Emptiness");
                meta.setColor(Color.fromRGB(84, 44, 14));
                break;
        }

        switch (base) {
            case "NETHER_WART":
            case "Enchanted Nether Wart":
                break;
            default:
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"), PersistentDataType.STRING, "Failure");
                break;
        }

        switch (amplifier) {
            case "GLOWSTONE_DUST":
                power += 1;
                break;
            case "Enchanted Glowstone Dust":
                power += 2;
                break;
            case "Enchanted Glowstone":
                power += 3;
                break;
            case "Luminous Quartz":
                power += 4;
                break;
        }

        switch (inhibitor) {
            case "REDSTONE":
                duration *= 1.2;
                break;
            case "Enchanted Redstone":
                duration *= 1.8;
                break;
            case "Enchanted Redstone Block":
                duration *= 4.6;
                break;
            case "Mineral Cluster":
                duration *= 15.4;
                break;
        }

        if (additive != "") {
            meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "additive"), PersistentDataType.STRING, additive);
        }

        switch (power) {
            case 1:
            case 2:
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "COMMON");
                break;
            case 3:
            case 4:
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "UNCOMMON");
                break;
            case 5:
            case 6:
            case 7:
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "RARE");
                break;
            case 8:
            case 9:
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "EPIC");
                break;
            case 10:
                meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING, "LEGENDARY");
                break;
        }
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "power"), PersistentDataType.INTEGER, power);
        meta.getPersistentDataContainer().set(new NamespacedKey(plugin, "duration"), PersistentDataType.LONG, duration);
        potion.setItemMeta(meta);
        Items.EMPTY_POTION.updateItem(plugin, potion);
        return potion;
    }

    public Map<Player, ItemStack> updatePet(Player player) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Pet"),
                    PersistentDataType.BYTE_ARRAY));
            BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);
            pets.put(player, (ItemStack)objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(ChatColor.RED + "Failed to load pet");
            pets.put(player, new ItemStack(Material.AIR));
        }

        return pets;
    }

    public void pushPet(Player player, ItemStack pet) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Pet"),
                    PersistentDataType.BYTE_ARRAY));
            BukkitObjectInputStream objectInputStream = new BukkitObjectInputStream(inputStream);
            pets.put(player, (ItemStack)objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(ChatColor.RED + "Failed to load pet");
            pets.put(player, new ItemStack(Material.AIR));
        }
    }

    public Map<Player, ItemStack> getPets() {
        return pets;
    }
}
