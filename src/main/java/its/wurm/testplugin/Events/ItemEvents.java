package its.wurm.testplugin.Events;

import its.wurm.testplugin.Items.ItemManager;

import its.wurm.testplugin.Main;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ItemEvents implements Listener{
    static Main plugin;

    public ItemEvents(Main plugin) { this.plugin = plugin;}

    Map<String, Long> cooldown_lheal = new HashMap<String, Long>();
    Map<String, Long> cooldown_echo = new HashMap<String, Long>();
    Map<String, Location> echo_ward = new HashMap<String, Location>();


    @EventHandler
    public void setCooldown(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        cooldown_lheal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
        cooldown_lheal.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
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
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        //boot effects on movement
        if (player.getInventory().contains(ItemManager.fcharm)) {
            if (player.isSneaking()) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,
                        20, 0, true, false));
            }
        }
        //Drip and Supreme Drip particles
        if (!(player.getInventory().getBoots() == null)) {

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

        //Spectral Wings Effects
        if (!(player.getInventory().getChestplate() == null)) {
            if (player.getInventory().getChestplate().getItemMeta().equals(ItemManager.sWings.getItemMeta())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,
                        500, 0, true, false));
                if (player.isGliding()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                            8, 127, true, false));
                }
            }
        }
    }

    @EventHandler
    public void onRightClickAir(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                Player player = event.getPlayer();
                if (player.getItemInUse() != null &&
                    player.getItemInUse().getItemMeta() != null &&
                    player.getItemInUse().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING) != null) {
                    switch (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Test Fireball":
                            player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 40);
                            player.sendMessage("§cTest Ability Activate!");
                            break;
                        case "Lesser Heal Wand":
                            if (cooldown_lheal.containsKey(player.getName())) {
                                if (cooldown_lheal.get(player.getName()) > System.currentTimeMillis()) {
                                    long timeleft = (cooldown_lheal.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                    player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                                    return;
                                }
                            }

                            cooldown_lheal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
                            double hp = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) + 50;
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, hp);
                            player.sendMessage(ChatColor.GREEN + "Used Minor Heal");
                            break;
                        case "Echo Stone":
                            if (cooldown_echo.containsKey(player.getName())) {
                                if (cooldown_echo.get(player.getName()) > System.currentTimeMillis()) {
                                    long timeleft = (cooldown_echo.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                    player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                                    return;
                                }
                            }

                            if (player.getLocation().distanceSquared(echo_ward.get(player.getName())) > 120 * 120) {
                                player.sendMessage(ChatColor.RED + "Your ward is too far away to teleport to!");
                                return;
                            }

                            player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
                            player.teleport(echo_ward.get(player.getName()));
                            player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 2);
                            player.sendMessage(ChatColor.GREEN + "Used Echo");
                            cooldown_echo.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
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
                if (player.getItemInUse() != null &&
                        player.getItemInUse().getItemMeta() != null &&
                        player.getItemInUse().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING) != null) {
                    switch (player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING)) {
                        case "Test Fireball":
                            player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 40);
                            player.sendMessage("§cTest Ability Activate!");
                            break;
                        case "Lesser Heal Wand":
                            if (cooldown_lheal.containsKey(player.getName())) {
                                if (cooldown_lheal.get(player.getName()) > System.currentTimeMillis()) {
                                    long timeleft = (cooldown_lheal.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                    player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                                    return;
                                }
                            }

                            cooldown_lheal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
                            double hp = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) + 50;
                            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, hp);
                            player.sendMessage(ChatColor.GREEN + "Used Minor Heal");
                            break;
                        case "Echo Stone":
                            if (cooldown_echo.containsKey(player.getName())) {
                                if (cooldown_echo.get(player.getName()) > System.currentTimeMillis()) {
                                    long timeleft = (cooldown_echo.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                    player.sendMessage(ChatColor.RED + "This Ability is on cooldown for " + timeleft + " seconds.");
                                    return;
                                }
                            }

                            if (player.getLocation().distanceSquared(echo_ward.get(player.getName())) > 120 * 120) {
                                player.sendMessage(ChatColor.RED + "Your ward is too far away to teleport to!");
                                return;
                            }

                            player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
                            player.teleport(echo_ward.get(player.getName()));
                            player.spawnParticle(Particle.PORTAL, player.getLocation(), 6);
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 2);
                            player.sendMessage(ChatColor.GREEN + "Used Echo");
                            cooldown_echo.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
                            break;
                        default:
                            return;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player.getInventory().getItemInMainHand().getItemMeta() == null) {
                return;
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.hammerDev.getItemMeta())) {
                Entity target = event.getEntity();
                target.remove();

            }
            if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.moon_glove.getItemMeta())) {
                if (event.getEntity() instanceof Creature) {
                    ((Creature) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,
                            40, 6));
                }
                if (event.getEntity() instanceof Player) {
                    ((Player) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,
                            40, 6));
                }
            }
        }
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
    public void onDeath(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        echo_ward.put(player.getName(), player.getLocation());
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Random ran = new Random();

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
                        player.getInventory().contains(ItemManager.sower_contract)) {
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
                    player.getInventory().addItem(ItemManager.tomato);
                }
            }
        }
    }
}