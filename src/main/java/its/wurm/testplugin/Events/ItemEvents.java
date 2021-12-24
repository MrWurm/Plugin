package its.wurm.testplugin.Events;


import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Mobs.Attacks;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;

import java.util.*;

public class ItemEvents implements Listener{
    static Plugin plugin;

    public ItemEvents(Plugin plugin) { this.plugin = plugin;}

    Map<String, Long> cooldown_shortbow = new HashMap<String, Long>();
    Map<String, Long> cooldown_heal = new HashMap<String, Long>();
    Map<String, Long> cooldown_echo = new HashMap<String, Long>();
    Map<String, Long> cooldown_grapple = new HashMap<String, Long>();
    Map<String, Location> echo_ward = new HashMap<String, Location>();

    public void testFireBall(Player player) {
        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 40);
        player.sendMessage("§cTest Ability Activate!");
    }

    public void workBenchGUI(Player player) {
        player.openWorkbench(null, true);

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
        if (mana < 50) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - 50);

        double mod = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) * 0.2) + 1) * 20;
        Attacks.createTnt(player.getEyeLocation(), mod, 70, player, player.getLocation().getDirection().multiply(2));
        player.sendMessage(ChatColor.GREEN + "Used Tnt Hurl");
    }

    public void miteWand (Player player) {
        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < 80) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - 80);

        mite(player, 5, 3);
    }
    public void mite(Player player, int power, int amount) {

        double health = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)/power;
        double defense = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE)/power;
        double damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/20) + 5 + player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        damage = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                PersistentDataType.DOUBLE)/100) + 1) * damage;
        damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                PersistentDataType.DOUBLE) + 1) * damage;

        for (int i = 0; i < amount; i++) {
            Silverfish summon = player.getLocation().getWorld().spawn(player.getLocation(), Silverfish.class);
            Attacks.createSummon(player.getLocation(), 400, player, summon, damage, health, defense, "Wood Mite");
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
        if (mana < 25) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - 25);

        double mod = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) * 0.06) + 1) * 25;

        Attacks.createPuffer(player.getEyeLocation(), mod, player, player.getLocation().getDirection().multiply(3));
        player.sendMessage(ChatColor.GREEN + "Used Puffer Projectile");
    }

    public void shortArrow(Player player, double velocity, int id, int pierce, long time) {
        if (cooldown_shortbow.containsKey(player.getName())) {
            if (cooldown_shortbow.get(player.getName()) > System.currentTimeMillis()) {
                return;
            }
        }

        cooldown_shortbow.put(player.getName(), System.currentTimeMillis() + (time));
        boolean iscrit = false;
        Double damage = (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
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
            Double dmg = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                    PersistentDataType.DOUBLE)/100;

            damage = (dmg + 1) * damage;
        }
        Attacks.createArrow(player.getEyeLocation(), damage, player, player.getLocation().getDirection().multiply(velocity), id, pierce);
    }

    public void lesserHealWand(Player player) {
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
        if (mana < 20) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - 20);

        cooldown_heal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
        double hp = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) + 40;
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, hp);
        player.sendMessage(ChatColor.GREEN + "Used Minor Heal");
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

    public void aote(Player player) {

        double mana = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE);
        if (mana < 40) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - 40);

        int distance = 7;

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
        player.sendMessage(ChatColor.GREEN + "Used Instant Transmission");

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
        if (mana < 45) {
            player.sendMessage(ChatColor.RED + "You need more mana to use this ability");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, mana - 45);

        int distance = 60;

        BlockIterator blocksToAdd = new BlockIterator(player.getLocation(), 1, distance);

        Location loc = player.getLocation();

        double mod = ((player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Intelligence"),
                PersistentDataType.DOUBLE) * 0.0024) + 1) * 3;

        while (blocksToAdd.hasNext()) {
            loc = blocksToAdd.next().getLocation();
            if (loc.getBlock().getType().isSolid()) {
                Attacks.createLightning(loc, mod);
                player.sendMessage(ChatColor.GREEN + "Used Lightning Strike");
                return;
            }
        }
        Attacks.createLightning(loc, mod);
        player.sendMessage(ChatColor.GREEN + "Used Lightning Strike");
        return;

    }

    public void eatMeatStew(Player player, ItemStack item) {
        double strength = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                PersistentDataType.DOUBLE);
        int soup = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthSoup"),
                PersistentDataType.INTEGER);
        if (soup == 3) {
            player.sendMessage(ChatColor.RED + "You have already eaten enough Meaty Stew!");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }
        player.sendMessage(ChatColor.GREEN + "Yum! You ate the Meaty Stew and gained +5 Strength");

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                PersistentDataType.DOUBLE, strength + 5.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthSoup"),
                PersistentDataType.INTEGER, soup + 1);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 70, 2);
        item.setAmount(0);
    }

    public void eatMagicStew(Player player, ItemStack item) {
        double intelligence = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntBase"),
                PersistentDataType.DOUBLE);
        int soup = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "IntSoup"),
                PersistentDataType.INTEGER);
        if (soup == 3) {
            player.sendMessage(ChatColor.RED + "You have already eaten enough Magic Stew!");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 40, 0);
            return;
        }
        player.sendMessage(ChatColor.GREEN + "Yum! You ate the Magic Stew and gained +15 Intelligence");

        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntBase"),
                PersistentDataType.DOUBLE, intelligence + 15.0);
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "IntSoup"),
                PersistentDataType.INTEGER, soup + 1);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 70, 2);
        item.setAmount(0);
    }

    @EventHandler
    public void setCooldown(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        cooldown_heal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
        cooldown_grapple.put(player.getName(), System.currentTimeMillis() + (5 * 500));
        cooldown_echo.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
        cooldown_shortbow.put(player.getName(), System.currentTimeMillis() + (400));
        echo_ward.put(player.getName(), player.getLocation());

    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent event) {
        Item item = event.getItem();
        if (item.getItemStack().getItemMeta().getLore() == null) {
            ItemMeta meta = item.getItemStack().getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("§f§lCOMMON");
            meta.setLore(lore);
            item.getItemStack().setItemMeta(meta);
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        ItemStack item = event.getCurrentItem();
        if (item.getItemMeta().getLore() == null) {
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("§f§lCOMMON");
            meta.setLore(lore);
            item.setItemMeta(meta);
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
    public void onRightClickAir(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                Player player = event.getPlayer();
                if (event.getItem() != null &&
                    event.getItem().getItemMeta() != null &&
                    event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                    switch (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Test Fireball":
                            testFireBall(player);
                            break;
                        case "Lesser Wand of Healing":
                            lesserHealWand(player);
                            break;
                        case "Echo Stone":
                            echoStone(player);
                            break;
                        case "Test Shortbow":
                            event.setCancelled(true);
                            player.launchProjectile(Arrow.class, player.getLocation().getDirection());
                            break;
                        case "Aspect of The End":
                            aote(player);
                            break;
                        case "Tnt Wand":
                            tntWand(player);
                            break;
                        case "Pufferfish Canon":
                            pufferCanon(player);
                            break;
                        case "Bamboo Shortbow":
                            event.setCancelled(true);
                            if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                                break;
                            }
                            shortArrow(player, 2.4, 9, 0, 270l);
                            break;
                        case "Meaty Stew":
                            event.setCancelled(true);
                            eatMeatStew(player, event.getItem());
                            break;
                        case "Magic Stew":
                            event.setCancelled(true);
                            eatMagicStew(player, event.getItem());
                            break;
                        case "Bone Needle":
                            boneNeedle(player);
                            break;
                        case "Pocket Crafting Table":
                            event.setCancelled(true);
                            workBenchGUI(player);
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
                        case "Lightning Wand":
                            lightningWand(player);
                            break;
                        case "Grappling Hook":
                            grapple(player);
                            event.setCancelled(true);
                            break;
                        case "Wand of Maggots":
                            miteWand(player);
                            break;
                        default:
                            return;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onRightClickBlock(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                Player player = event.getPlayer();

                if (event.getItem() != null &&
                    event.getItem().getItemMeta() != null &&
                    event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                    switch (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Test Fireball":
                            event.setCancelled(true);
                            testFireBall(player);
                            break;
                        case "Lesser Wand of Healing":
                            lesserHealWand(player);
                            break;
                        case "Echo Stone":
                            echoStone(player);
                            break;
                        case "Test Shortbow":
                            event.setCancelled(true);
                            player.launchProjectile(Arrow.class, player.getLocation().getDirection());
                            break;
                        case "Aspect of The End":
                            aote(player);
                            break;
                        case "Tnt Wand":
                            tntWand(player);
                            break;
                        case "Pufferfish Canon":
                            pufferCanon(player);
                            break;
                        case "Bamboo Shortbow":
                            event.setCancelled(true);
                            if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                                break;
                            }
                            shortArrow(player, 2.4, 9, 0, 270l);
                            break;
                        case "Meaty Stew":
                            event.setCancelled(true);
                            eatMeatStew(player, event.getItem());
                            break;
                        case "Magic Stew":
                            event.setCancelled(true);
                            eatMagicStew(player, event.getItem());
                            break;
                        case "Bone Needle":
                            boneNeedle(player);
                            break;
                        case "Pocket Crafting Table":
                            event.setCancelled(true);
                            workBenchGUI(player);
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
                        case "Lightning Wand":
                            lightningWand(player);
                            event.setCancelled(true);
                            break;
                        case "Grappling Hook":
                            grapple(player);
                            event.setCancelled(true);
                            break;
                        case "Wand of Maggots":
                            mite(player, 4, 3);
                            event.setCancelled(true);
                            break;
                        default:
                            return;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Random ran = new Random();
        int choice = ran.nextInt(50 ) + 1;
        Player player = event.getEntity();
        if (choice == 1 && player.getInventory().contains(Items.DEATH_CHARM.getItem(plugin))) {
            player.setHealth(20);

            player.sendMessage(ChatColor.GREEN + "You charm brought you back from the brink of death");
            player.playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 80, 0);
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)/5);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                    9999999, 5, true, false));
            player.setInvulnerable(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    player.setInvulnerable(false);
                }
            }, 60l);

        }

    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            Entity target = event.getEntity();
            if (player.getInventory().getItemInMainHand() != null &&
                player.getInventory().getItemInMainHand().getItemMeta() != null &&
                player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Dev Hammer":
                        target.remove();
                        break;

                    case "Moon Glove":
                        if (target instanceof Creature) {
                            ((Creature) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,
                                    40, 6));
                        }
                        if (event.getEntity() instanceof Player) {
                            ((Player) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,
                                    40, 6));
                        }
                        break;
                    case "Meat Cleaver":
                        Random random = new Random();
                        int choice = random.nextInt(5);
                        switch (choice) {
                            case 0:
                                Attacks.createItem(event.getEntity().getLocation(), 5965, Material.ROTTEN_FLESH, true);
                                break;
                            case 1:
                                Attacks.createItem(event.getEntity().getLocation(), 5965, Material.BONE, true);
                                break;
                            case 2:
                                Attacks.createItem(event.getEntity().getLocation(), 5965, Material.DRIED_KELP, true);
                                break;
                            case 3:
                                Attacks.createItem(event.getEntity().getLocation(), 5965, Material.STRING, true);
                                break;
                            case 4:
                                Attacks.createItem(event.getEntity().getLocation(), 5965, Material.FEATHER, true);
                                break;
                        }
                        ItemStack block = new ItemStack(Material.REDSTONE_BLOCK);
                        event.getEntity().getWorld().spawnParticle(Particle.ITEM_CRACK, event.getEntity().getLocation(), 2, block);
                        break;
                    default:
                        break;
                }
            }
        }

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
                                        PersistentDataType.DOUBLE) / 25;
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
                            mite(victim, 10, 1);
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
                            mite(victim, 10, 1);
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
                            mite(victim, 10, 1);
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
                            mite(victim, 10, 1);
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @EventHandler
    public void onLeftClickAir(PlayerInteractEvent event) {
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
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().contains(Items.FEATHER_CHARM.getItem(plugin))) {
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
                    return;
            }
        }
    }

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        if (event.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
            if (player.getInventory().getItemInMainHand() != null &&
                player.getInventory().getItemInMainHand().getType() == Material.FISHING_ROD &&
                player.getInventory().getItemInMainHand().getItemMeta() != null &&
                player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) != null) {
                switch (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    case "Kinetic Rod":
                        event.getCaught().setVelocity(player.getLocation().getDirection().multiply(4));
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
                    default:
                        return;
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
        Player player = event.getPlayer();
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
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Random ran = new Random();

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

                if (choice == 1000) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " got a tomato!");
                    player.getInventory().addItem(Items.TOMATO.getItem(plugin));
                }
            }
        }
    }
}