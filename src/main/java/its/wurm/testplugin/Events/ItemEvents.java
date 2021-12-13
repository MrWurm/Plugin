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
    Map<String, Location> echo_ward = new HashMap<String, Location>();

    public void testFireBall(Player player) {
        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 40);
        player.sendMessage("§cTest Ability Activate!");
    }

    public void tntWand(Player player) {
        Attacks.createTnt(player.getEyeLocation(), 100.0, 70, player, player.getLocation().getDirection().multiply(2));
        player.sendMessage(ChatColor.GREEN + "Used Tnt Hurl");
    }

    public void pufferCanon(Player player) {
        Attacks.createPuffer(player.getEyeLocation(), 100.0, player, player.getLocation().getDirection().multiply(3));
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
                return;
            }
        }

        cooldown_heal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
        double hp = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) + 50;
        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, hp);
        player.sendMessage(ChatColor.GREEN + "Used Minor Heal");
    }

    public void echoStone(Player player) {
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
    }

    public void aote(Player player) {
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
    }

    public void eatMeatStew(Player player, ItemStack item) {
        double strength = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                PersistentDataType.DOUBLE);
        int soup = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthSoup"),
                PersistentDataType.INTEGER);
        if (soup == 3) {
            player.sendMessage(ChatColor.RED + "You have already eaten enough Meaty Stew!");
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

    @EventHandler
    public void setCooldown(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        cooldown_heal.put(player.getName(), System.currentTimeMillis() + (8 * 1000));
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
                            if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                                break;
                            }
                            shortArrow(player, 2.4, 9, 0, 270l);
                            break;
                        case "Meaty Stew":
                            eatMeatStew(player, event.getItem());
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
                            testFireBall(player);
                            break;
                        case "Lesser Wand of Healing":
                            lesserHealWand(player);
                            break;
                        case "Echo Stone":
                            echoStone(player);
                            break;
                        case "Test Shortbow":
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
                            if (event.getItem().equals(player.getInventory().getItemInOffHand())) {
                                break;
                            }
                            shortArrow(player, 2.4, 9, 0, 270l);
                            break;
                        case "Meaty Stew":
                            eatMeatStew(player, event.getItem());
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
                        return;
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
                        player.getInventory().contains(Items.SWOERS_WILL.getItem(plugin))) {
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