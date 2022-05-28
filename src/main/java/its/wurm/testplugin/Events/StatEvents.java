package its.wurm.testplugin.Events;

import its.wurm.testplugin.Bosses.Dragon;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import its.wurm.testplugin.persistentDataContainers.stringList;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

public class StatEvents implements Listener {

    Main plugin;
    Attacks attacks;
    Dragon dragon;
    StatFunctions functions;

    public StatEvents(Main plugin, Dragon dragon) {
        this.dragon = dragon;
        this.plugin = plugin;
        this.attacks = new Attacks(plugin);
        this.functions = new StatFunctions(this.plugin, this.attacks);
    }

    public void rotate(LivingEntity entity,LivingEntity passenger) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (entity.isDead()) {
                    return;
                }
                passenger.setRotation(entity.getLocation().getPitch(), entity.getLocation().getYaw());
                rotate(entity, passenger);
            }
        }, 1);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        functions.addPlayer(event.getPlayer());
    }
    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Item) {
            Item item = (Item) entity;
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

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "DEATH_POTION_ARROW":
                    entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 1.4);
            }
        }
    }

    @EventHandler
    public void onRespawn (PlayerRespawnEvent event) {
        Double MaxHealth = event.getPlayer().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);
        Double MaxMana = event.getPlayer().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                PersistentDataType.DOUBLE);
        event.getPlayer().getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, MaxHealth);
        event.getPlayer().getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE, MaxMana);
        event.getPlayer().setCooldown(Material.SHIELD, 0);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                        9999999, 4, true, false));
            }
        }, 3L);
    }

    @EventHandler
    public void onTarget (EntityTargetEvent event) {
        Entity entity = event.getEntity();
        Entity target = event.getTarget();
        if (target == null) {
            return;
        }

        if (target.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING) == entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING) &&
            event.getReason() != EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY) {
            event.setCancelled(true);
        }

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "ignore"),
                PersistentDataType.INTEGER) != null &&
            entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "ignore"),
                        PersistentDataType.INTEGER) == 1) {
            event.setCancelled(true);
        }

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "MULCHLING":
                    if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) <= 240 && !(target instanceof ArmorStand)) {
                        event.setCancelled(true);
                    }
                    return;
            }
        }
    }

    @EventHandler
    public void onSplit (SlimeSplitEvent event) {
        Slime entity = event.getEntity();
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "CAMO_OOZE":
                    event.setCount(3);
                    break;
                case "VOLATILE_SLIME":
                    event.setCount(0);
                    break;
            }
        }
    }

    @EventHandler
    public void onTransform(EntityTransformEvent event) {
        EntityTransformEvent.TransformReason reason = event.getTransformReason();
        Random random = new Random();
        List<Entity> entities = event.getTransformedEntities();
        Entity entity = event.getEntity();

        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "CAMO_OOZE":
                    for (int target = 0; target < entities.size(); target++) {
                        entities.get(target).remove();
                        Mobs.SMALL_CAMO_OOZE.createMob(plugin, entity.getLocation());
                    }
                    break;
            }
        }
    }

    @EventHandler
    public void onPlace(EntityChangeBlockEvent event) {
        Block block = event.getBlock();
        Entity entity = event.getEntity();


        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "red":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.RED, 5f);
                    break;
                case "orange":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.ORANGE, 5f);
                    break;
                case "yellow":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.YELLOW, 5f);
                    break;
                case "green":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.GREEN, 5f);
                    break;
                case "aqua":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.AQUA, 5f);
                    break;
                case "blue":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.BLUE, 5f);
                    break;
                case "magenta":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.FUCHSIA, 5f);
                    break;
                case "purple":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.PURPLE, 5f);
                    break;
                case "white":
                    attacks.createCloud(entity.getLocation(), entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE) * 0.25, 20, Bukkit.getPlayer(UUID.fromString(entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "owner"),
                        PersistentDataType.STRING))), 10, 1f, Color.WHITE, 5f);
                    break;
            }
        }
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "cancel"),
                PersistentDataType.INTEGER) != null) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEffect(AreaEffectCloudApplyEvent event) {
        Entity cloud = event.getEntity();
        List<LivingEntity> entities = event.getAffectedEntities();

        if (cloud.getPersistentDataContainer().get(new NamespacedKey(plugin, "attack"),
                PersistentDataType.INTEGER) != null) {
            for (int i = 0; i < entities.size(); ++i) {
                LivingEntity entity = entities.get(i);
                double defense = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) + 100;
                defense = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                        PersistentDataType.DOUBLE) / defense;
                defense += 1;

                double AfterDamage = cloud.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                        PersistentDataType.DOUBLE);
                if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                        PersistentDataType.DOUBLE) > 0) {
                AfterDamage = AfterDamage / defense;
                } else {
                    AfterDamage = AfterDamage * defense;
                }

                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) - AfterDamage);
                functions.updateHealth(entity);
            }
        }
    }

    @EventHandler
    public void onShoot(ProjectileLaunchEvent event) {
        if (!(event.getEntity().getShooter() instanceof Entity)) {
            return;
        }
        Entity shooter = (Entity) event.getEntity().getShooter();
        if (shooter instanceof Player) {
            return;
        }
        Projectile proj = event.getEntity();
        double dmg = shooter.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        Random random = new Random();
        Location location;

        if (shooter.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {

            switch (shooter.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "SAND_WITCH":
                    location = new Location(shooter.getWorld(), ((Mob)shooter).getTarget().getLocation().getX(), ((Mob)shooter).getTarget().getLocation().getY() + 5, ((Mob)shooter).getTarget().getLocation().getZ());
                    attacks.createBlock(location, dmg, Material.SAND, shooter, true);
                    event.setCancelled(true);
                    break;
                case "POTION_ARCHER":
                    proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING, "POTION_ARROW");

                    Skeleton skeleton = (Skeleton) shooter;
                    ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
                    PotionMeta meta = (PotionMeta) item.getItemMeta();

                    switch (random.nextInt(3) + 1) {
                        case 1:
                            meta.setColor(Color.fromBGR(91, 19, 107));
                            proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"),
                                    PersistentDataType.INTEGER, 1);

                            dmg *= 1.4;
                            proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE, dmg);
                            item.setItemMeta(meta);
                            break;
                        case 2:
                            meta.setColor(Color.fromBGR(50, 133, 41));
                            proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"),
                                    PersistentDataType.INTEGER, 2);
                            item.setItemMeta(meta);
                            break;
                        case 3:
                            meta.setColor(Color.fromBGR(10, 22, 48));
                            proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "effect"),
                                    PersistentDataType.INTEGER, 3);
                            item.setItemMeta(meta);
                            break;
                    }

                    skeleton.getEquipment().setItemInOffHand(item);
                    break;

                case "SWARM_ARCHER":
                    proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING, "SWARM_ARROW");
                    break;
                case "SKELETON_GRUNT":
                case "DARK_IRON_ARCHER":
                    event.setCancelled(true);
                    break;
                case "HUNTER":
                    CrossbowMeta metaMain = (CrossbowMeta) ((Pillager)shooter).getEquipment().getItemInMainHand().getItemMeta();
                    List<ItemStack> items = new ArrayList<>();
                    items.add(new ItemStack(Material.SPECTRAL_ARROW));
                    ((Pillager)shooter).getEquipment().getItemInMainHand().setItemMeta(metaMain);
                    break;
                case "SANDY_SKELETON":
                    proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                            PersistentDataType.STRING, "SAND_ARROW");
                    break;
                case "ELITE_HUNTER":
                    CrossbowMeta metaMain1 = (CrossbowMeta) ((Pillager)shooter).getEquipment().getItemInMainHand().getItemMeta();
                    List<ItemStack> items1 = new ArrayList<>();
                    items1.add(new ItemStack(Material.SPECTRAL_ARROW));
                    ((Pillager)shooter).getEquipment().getItemInMainHand().setItemMeta(metaMain1);
                    attacks.track(proj, shooter, 2, 0.32);
                    break;
                case "STONESHELL":
                    attacks.createSnowball(proj.getLocation(), ((Shulker)proj.getShooter()).getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE) * .15, ((Shulker)proj.getShooter()), new Vector(((Shulker)proj.getShooter()).getTarget().getEyeLocation().getX() - proj.getLocation().getX(), ((Shulker)proj.getShooter()).getTarget().getEyeLocation().getY() - proj.getLocation().getY(), ((Shulker)proj.getShooter()).getTarget().getEyeLocation().getZ() - proj.getLocation().getZ()).normalize().multiply(2.1),
                            "", Material.FIRE_CHARGE).setVisualFire(true);
                    proj.remove();
                    break;
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        org.bukkit.entity.Damageable victim = (Damageable) event.getEntity();

        org.bukkit.entity.LivingEntity living = (LivingEntity) victim;
        boolean max = false;
        if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE).equals(victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
            PersistentDataType.DOUBLE))) {
            max = true;
        }
        Entity attacker = event.getDamager();
        double Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);

        if (victim instanceof Player &&
            functions.CheckDamage(event, plugin) instanceof Player &&
            functions.CheckDamage(event, plugin) != victim &&
            ((Player)functions.CheckDamage(event, plugin)).getPersistentDataContainer().get(new NamespacedKey(plugin, "peace"),
                    PersistentDataType.INTEGER) == 1) {

            event.setCancelled(true);
            return;
        }

        if (!(attacker instanceof Player)) {
            if (victim instanceof Player) {
                Player player = ((Player) victim).getPlayer();


                if (player.isBlocking() &&
                    player.getCooldown(Material.SHIELD) == 0 &&
                    player.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD) > 0) {
                    attacks.createDamageIndicator(victim.getLocation(), false, 0.0);
                    player.setStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD, 0);
                    Double cd = 120.0;
                    List<Double> list;

                    if (player.getInventory().getItemInOffHand().getType() == Material.SHIELD && (player.getInventory().getItemInMainHand() == null ||player.getInventory().getItemInMainHand().getType() != Material.SHIELD)) {
                        cd = (100.0 * (2 + (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                                PersistentDataType.DOUBLE)/10)))/((attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) + 100)/attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE));
                        list = functions.reforgeOnBlock(player, plugin, cd, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), false, attacker);
                        cd *= list.get(0);
                    }

                    if (player.getInventory().getItemInMainHand().getType() == Material.SHIELD) {
                        cd = (100.0 * (2 + (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                                PersistentDataType.DOUBLE)/10)))/((attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) + 100)/attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE));
                        list = functions.reforgeOnBlock(player, plugin, cd, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), true, attacker);
                        cd *= list.get(0);
                    }


                    int cooldown = cd.intValue();
                    player.setCooldown(Material.SHIELD, cooldown);
                    return;
                }
            }

            double defense = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) + 100;
            defense = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) / defense;
            defense += 1;

            double AfterDamage = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
            if (victim instanceof Shulker &&
                    ((Shulker)victim).getPeek() == 0f) {
                AfterDamage *= .2;
            }

            if ((attacker instanceof Arrow ||
                attacker instanceof SpectralArrow) &&
                ((Projectile)attacker).getShooter() instanceof Player &&
                attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantments"),
                    new stringList()) != null) {
                Projectile arrow = (Projectile) attacker;
                String[] enchantments = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantments"),
                    new stringList());
                int[] level = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "levels"),
                    PersistentDataType.INTEGER_ARRAY);
                String reforge = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "reforge"),
                    PersistentDataType.STRING);

                switch (reforge) {
                    case "Leaching":
                        functions.heal(plugin, (Entity)arrow.getShooter(), ((Entity)arrow.getShooter()).getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                PersistentDataType.DOUBLE) * .02);
                        break;
                }

                if (enchantments.length > 0 &&
                    Arrays.asList(enchantments).indexOf("Ballistics") != -1 &&
                    !(victim.isOnGround())) {
                    AfterDamage *= 1 + ((level)[Arrays.asList(enchantments).indexOf("Ballistics")] * .09);
                }

                if (enchantments.length > 0 &&
                    Arrays.asList(enchantments).indexOf("Hunter") != -1 &&
                    (victim instanceof Animals ||
                    victim instanceof Bat ||
                    victim instanceof WaterMob ||
                    victim instanceof Zoglin)) {
                    AfterDamage *= 1 + ((level)[Arrays.asList(enchantments).indexOf("Hunter")] * .09);
                }

                if (enchantments.length > 0 &&
                    Arrays.asList(enchantments).indexOf("Dismantle") != -1 &&
                    (victim instanceof Golem ||
                    victim instanceof Wither)) {
                    AfterDamage *= 1 + ((level)[Arrays.asList(enchantments).indexOf("Dismantle")] * .09);
                }

                if (enchantments.length > 0 &&
                    Arrays.asList(enchantments).indexOf("Impair") != -1 &&
                    attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                            PersistentDataType.DOUBLE) > 100) {
                    AfterDamage *= 1 + ((level)[Arrays.asList(enchantments).indexOf("Impair")] * .06);
                }

                if (enchantments.length > 0 &&
                        Arrays.asList(enchantments).indexOf("Splash") != -1) {
                    ArmorStand placeHoldDamager = victim.getWorld().spawn(new Location(victim.getWorld(),
                            victim.getLocation().getX(), victim.getLocation().getY() + 100, victim.getLocation().getZ()), ArmorStand.class);
                    placeHoldDamager.setGravity(false);
                    placeHoldDamager.setInvulnerable(true);
                    placeHoldDamager.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE, 1.0);
                    placeHoldDamager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, 1.0);
                    placeHoldDamager.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE, AfterDamage * ((level)[Arrays.asList(enchantments).indexOf("Splash")] * .02));
                    List<Entity> entities = victim.getNearbyEntities(4, 4, 4);
                    for (int i = 0; i < entities.size(); i++) {

                        if (entities.get(i) instanceof LivingEntity &&
                            entities.get(i) != victim) {
                            ((LivingEntity) entities.get(i)).damage(1, placeHoldDamager);
                            entities.get(i).getWorld().spawnParticle(Particle.WATER_SPLASH,
                                entities.get(i).getLocation(), 12);
                        }
                    }
                    placeHoldDamager.remove();
                }

                if (enchantments.length > 0 &&
                    Arrays.asList(enchantments).indexOf("Leach") != -1) {
                    functions.heal(plugin, (Entity)((Projectile)attacker).getShooter(), AfterDamage * (level)[Arrays.asList(enchantments).indexOf("Leach")] * .02);
                }
            }
            if (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING) != null) {
                Random random = new Random();
                switch (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING)) {
                    //Frost Attack of the Chill Zombie
                    case "FROST_ZOMBIE":
                        victim.setFreezeTicks(110);
                        break;
                    //Full Health Damage Increase From the Marauding Vindicator
                    case "MARAUDING_VINDICATOR":
                        if (max) {
                            AfterDamage *= 1.5;
                        }
                        break;
                        //Disarming Attack of the Fencer Zombie
                    case "FENCER_ZOMBIE":
                        if (random.nextInt(4) == 3) {
                            for (int i = 0; i < 2; ++i) {
                                attacker.getWorld().spawnParticle(Particle.SWEEP_ATTACK, victim.getLocation(), 100);
                                attacker.getWorld().playSound(attacker.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 120, 2);
                            }

                            if (victim instanceof Player) {
                                org.bukkit.entity.Player vic = (Player) event.getEntity();
                                if (vic.getInventory().getItemInMainHand() == null) {
                                    return;
                                }
                                vic.getWorld().dropItem(attacker.getLocation(), vic.getInventory().getItemInMainHand());
                            }
                        }
                        break;
                    case "POTION_ARROW":
                        switch (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "effect"),
                                PersistentDataType.INTEGER)) {
                            case 2:
                                living.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                        2400, 1));
                            case 3:
                                if (victim instanceof Player) {
                                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifier"),
                                            PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                                                    PersistentDataType.DOUBLE) - 0.15);
                                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                                            PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                                                    PersistentDataType.DOUBLE) - 0.15);

                                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                        public void run() {
                                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifier"),
                                                    PersistentDataType.DOUBLE, (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifier"),
                                                            PersistentDataType.DOUBLE) + 0.15));
                                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                                                    PersistentDataType.DOUBLE, (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                                                            PersistentDataType.DOUBLE) + 0.15));
                                        }
                                    }, 200);
                                }
                        }
                        break;
                    case "POISON_POTION_ARROW":
                        living.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                2400, 2));
                        break;
                    case "ZOMBIE_CRUSADER":
                        living.sendMessage(max + "");
                        if (max) {
                            living.getWorld().spawnParticle(Particle.FLASH, living.getLocation(), 1);
                            living.getWorld().playSound(living.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 100, 1);
                            if (victim instanceof Player) {
                                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBonus"),
                                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBonus"),
                                                PersistentDataType.DOUBLE) - 50);
                            } else {
                                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                                PersistentDataType.DOUBLE) - 50);
                            }
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    if (victim instanceof Player) {
                                        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBonus"),
                                                PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBonus"),
                                                        PersistentDataType.DOUBLE) + 50);
                                    } else {
                                        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                                PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                                        PersistentDataType.DOUBLE) + 50);
                                    }
                                }
                            }, 200);
                        }
                        break;
                    case "BEE_SWARMER":
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                ((Bee)attacker).setHasStung(false);
                            }
                        }, 25);
                        break;
                    case "SWARM_ARROW":
                        if (random.nextInt(5) == 4)
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    Mobs.ANGRY_BEE.createMob(plugin, victim.getLocation());
                                }
                            }, 45);
                        break;
                    case "HONEYPOT_CREEPER":
                        if (victim instanceof Player) {
                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                    PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                            PersistentDataType.DOUBLE) - 0.4);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                            PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedModifierBonus"),
                                                    PersistentDataType.DOUBLE) + 0.4);
                                }
                            }, 240);
                        }
                        break;
                    case "AQUATIC_ISOPOD":
                        living.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                80, 1));
                        living.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                                25, 0));
                        break;
                    case "SEA_SKELETON":
                        ((LivingEntity) victim).setRemainingAir(0);
                        break;
                    case "HUNTER":
                    case "ELITE_HUNTER":
                        if (living.hasPotionEffect(PotionEffectType.GLOWING)) {
                            AfterDamage *= 1.35;
                        }
                        break;
                    case "SAND_ARROW":
                        living.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                                45, 0));
                        break;
                    case "PIGMENTED_CREEPER":
                        living.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                                160, 0));
                        living.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                100, 2));
                        living.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,
                                320, 1));
                        break;
                    case "HOG_RIDER":
                        if (attacker.getVehicle() == null) {
                            AfterDamage *= 0.75;
                        }
                        break;
                    case "Poison Dart":
                        living.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                60, 3));
                        break;
                    case "SPEARMAN":
                        if (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "attack"),
                            PersistentDataType.INTEGER) == 1) {
                            attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "attack"),
                                    PersistentDataType.INTEGER, 0);
                            break;
                        } else {
                            event.setCancelled(true);
                            return;
                        }
                    case "AMBUSH_SPIDER":
                        ((LivingEntity)attacker).removePotionEffect(PotionEffectType.INVISIBILITY);
                        break;
                    case "EPSILON":
                        if (victim.getVehicle() != null &&
                            victim.getVehicle() instanceof Ocelot) {
                            victim.getVehicle().remove();
                        }
                        break;
                    case "HUNTER_ARROW":
                        if (victim instanceof Animals ||
                            victim instanceof Bat ||
                            victim instanceof WaterMob ||
                            victim instanceof Zoglin) {
                            AfterDamage *= 1.35;
                        }
                        break;
                    case "TIMBER_WOLF":
                        new BukkitRunnable() {
                            int iterations = 0;
                            public void run()
                            {
                                if (iterations >= 3 || victim.isDead()) {
                                    this.cancel();
                                    return;
                                }
                                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE) - 20);
                                victim.damage(1);
                                victim.getWorld().spawnParticle(Particle.ITEM_CRACK, victim.getLocation(), 2, new ItemStack(Material.REDSTONE_BLOCK));
                                iterations += 1;
                            }
                        }.runTaskTimer(plugin, 1, 20);
                        break;
                    case "UNDEAD_LOGGER":
                        ((LivingEntity)victim).addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                                25, 7, true, false));
                        break;
                    case "WEB_ARROW":
                        ((LivingEntity)victim).addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                                40, 7, true, false));
                        attacks.createItem(victim.getLocation(),5980,  Material.COBWEB, true);
                        break;
                    case "SPIDER_QUEEN":
                        ((LivingEntity)victim).addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
                                35, 2, true, false));
                        ((LivingEntity)victim).addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                90, 1, true, false));
                        break;
                    case "SNAPPER":
                        victim.setVelocity(new Vector(victim.getLocation().getX() - attacker.getLocation().getX(), victim.getLocation().getY() - attacker.getLocation().getY(), victim.getLocation().getZ() - attacker.getLocation().getZ()).normalize().multiply(4));
                        break;
                    case "ALGAE_GOLEM":
                        functions.heal(plugin, attacker, 60);
                        break;
                    case "CORRUPTED_MOSQUITO":
                        new BukkitRunnable() {
                            int iterations = 0;
                            public void run()
                            {
                                if (iterations >= 4 || victim.isDead()) {
                                    this.cancel();
                                    return;
                                }
                                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                                PersistentDataType.DOUBLE) - 15);
                                victim.damage(1);
                                functions.heal(plugin, attacker, 25);
                                victim.getWorld().spawnParticle(Particle.ITEM_CRACK, victim.getLocation(), 2, new ItemStack(Material.COAL_BLOCK));
                                iterations += 1;
                            }
                        }.runTaskTimer(plugin, 1, 30);
                        break;
                    case "VILE_LEACH":
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) + 30);
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                                PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealMod"),
                                        PersistentDataType.DOUBLE) + .05);
                        living.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                120, 2));
                        break;
                }
            }

            if (victim instanceof Player) {
                List<Double> list = functions.reforgeOnDamaged(((Player) victim), plugin, AfterDamage, attacker);
                AfterDamage *= list.get(0);
            }

            if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) > 0) {
            AfterDamage = AfterDamage / defense;
            } else {
                AfterDamage = AfterDamage * defense;
            }

            Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) - AfterDamage;

            if (victim instanceof EnderDragon &&
                functions.CheckDamage(event, plugin) instanceof Player) {
                dragon.playerDamage((Player)functions.CheckDamage(event, plugin), AfterDamage);
            }

            attacks.createDamageIndicator(victim.getLocation(), false, AfterDamage);
        }

        if (attacker instanceof Player) {

            if (victim instanceof Player) {
                Player player = ((Player) victim).getPlayer();
                if (player.isBlocking() &&
                    player.getCooldown(Material.SHIELD) == 0 &&
                    player.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD) != 0) {
                    attacks.createDamageIndicator(victim.getLocation(), false, 0.0);
                    player.setStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD, 0);
                    Double cd = 120.0;
                    double mod = 1.0;
                    List<Double> list;

                    if (player.getInventory().getItemInOffHand().getType() == Material.SHIELD && (player.getInventory().getItemInMainHand() == null ||player.getInventory().getItemInMainHand().getType() != Material.SHIELD)) {
                        cd = (100.0 * (2 + (player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                                PersistentDataType.DOUBLE)/10)))/((attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) + 100)/attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE));
                        list = functions.reforgeOnBlock(player, plugin, cd, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), false, attacker);
                        cd *= list.get(0);
                    }

                    if (player.getInventory().getItemInMainHand().getType() == Material.SHIELD) {
                        cd = (100.0 * (2 + (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                                PersistentDataType.DOUBLE)/10)))/((attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) + 100)/attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE));
                        list = functions.reforgeOnBlock(player, plugin, cd, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE), true, attacker);
                        cd *= list.get(0);
                    }


                    int cooldown = cd.intValue();
                    player.setCooldown(Material.SHIELD, cooldown);
                    return;
                }
            }

            boolean iscrit = false;
            Random crit = new Random();
            int choice = crit.nextInt(100) + 1;
            if (choice <= attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                    PersistentDataType.DOUBLE)) {
                iscrit = true;
            }
            double AfterDamage = (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/20) + 5 + attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
            AfterDamage = ((attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/100) + 1) * AfterDamage;
            if (victim instanceof Shulker &&
                ((Shulker)victim).getPeek() == 0f) {
                AfterDamage *= .2;
            }

            List<Object> apply = functions.reforgeOnDamage(((Player) attacker), plugin, AfterDamage, iscrit, max, (LivingEntity)victim);

            if ((boolean)apply.get(1)) {
                event.setCancelled(true);
                return;
            }
            AfterDamage = (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + (double)apply.get(0)) * AfterDamage;

            if (choice <= attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                    PersistentDataType.DOUBLE)) {
                double dmg = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                        PersistentDataType.DOUBLE)/100;
                AfterDamage = (dmg + 1) * AfterDamage;
            }


            if (victim instanceof Player) {
                List<Double> list = functions.reforgeOnDamaged(((Player) victim), plugin, AfterDamage, attacker);
                AfterDamage *= list.get(0);
            }

            double def = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) + 100;
            def = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) / def;
            def += 1;
            if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) > 0) {
                AfterDamage = AfterDamage / def;
            } else {
                AfterDamage = AfterDamage * def;
            }

            float cooldown = ((Player) attacker).getAttackCooldown();

            if (cooldown < 0.3) {
                return;
            }
            if (cooldown >= 0.3 && cooldown < 0.675) {
                AfterDamage *= cooldown / 1.4;
            }
            if (cooldown >= 0.675 && cooldown < 0.95) {
                AfterDamage *= cooldown / 1.2;
            }
            if (cooldown >= 0.95) {
                AfterDamage *= cooldown;
            }

            if (victim instanceof EnderDragon) {
                dragon.playerDamage((Player) attacker, AfterDamage);
            }

            Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) - AfterDamage;

            attacks.createDamageIndicator(victim.getLocation(), iscrit, AfterDamage);
        }

        if (victim instanceof Player) {
            Player player = ((Player) victim).getPlayer();
            functions.ShowStat(player, plugin);
        }


        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, Health);

        if (functions.CheckDamage(event, plugin) instanceof Player && Health < 1) {
            functions.reforgeOnKill((Player) functions.CheckDamage(event, plugin), plugin, victim, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING));
        }

        if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                //sound of the armored zombie getting hit
                case "ARMOR_ZOMBIE":
                    victim.getWorld().playSound(victim.getLocation(), Sound.BLOCK_ANVIL_PLACE, 120, 0);
                    break;
                //creation of the growth for the regen zombie
                case "REGEN_ZOMBIE":
                    if (Health < 1.0) {
                        Mobs.GROWTH.createMob(plugin, victim.getLocation());
                    }
                    break;
                //speed, damage, and defense gain of the berserk zombie
                case "RAGING_ZOMBIE":
                    double attack = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE) + 10;
                    double defense = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                            PersistentDataType.DOUBLE) + 5;
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE, attack);
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                            PersistentDataType.DOUBLE, defense);
                    org.bukkit.entity.LivingEntity eff = (LivingEntity) victim;
                    eff.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                            60, 2));
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                                    PersistentDataType.DOUBLE, (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                            PersistentDataType.DOUBLE) - 10));
                            victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                    PersistentDataType.DOUBLE, (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                            PersistentDataType.DOUBLE) - 5));
                        }
                    }, 110);
                    break;
                //revive of the relentless
                case "RELENTLESS":
                    if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) < 1.0) {
                        Husk husk = (Husk) victim;
                        if (husk.getEquipment().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING) {
                            event.setCancelled(true);
                            husk.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, husk.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                            PersistentDataType.DOUBLE));
                            husk.getWorld().spawnParticle(Particle.TOTEM, husk.getLocation(), 6);
                            ItemStack item = new ItemStack(Material.AIR);
                            husk.getEquipment().setItemInMainHand(item);
                        }
                    }
                    break;
                case "RUSTY_GOLEM":
                    switch (new Random().nextInt(12)) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            attacks.createItem(victim.getLocation(), 5980, Material.COPPER_INGOT, true);
                            break;
                        case 6:
                        case 7:
                        case 9:
                            attacks.createItem(victim.getLocation(), 5980, Material.EXPOSED_COPPER, true);
                            break;
                        case 10:
                            attacks.createItem(victim.getLocation(), 5980, Material.EXPOSED_CUT_COPPER_STAIRS, true);
                            break;
                        case 11:
                            attacks.createItem(victim.getLocation(), 5980, Material.EXPOSED_CUT_COPPER_SLAB, true);
                            break;
                        case 12:
                            attacks.createItem(victim.getLocation(), 5980, Material.LIGHTNING_ROD, true);
                            break;
                    }
                    living.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.2 * ((victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE)/victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE)) + 1));
                    break;
                case "CACTUS_ZOMBIE":
                    if (attacker instanceof LivingEntity) {
                        attacker.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) - 30);
                        ((LivingEntity)attacker).damage(1);

                    }
                    break;
                case "ANGUISHED_SPIRIT":
                    if (Health > 1) {
                        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                PersistentDataType.DOUBLE));
                    }
                    break;
                case "DEEP_MOUNTAIN_BURROWER":
                    attacks.createSnowball(((LivingEntity) victim).getEyeLocation(), victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE) * .15, (ProjectileSource) victim, victim.getFacing().getDirection().multiply(0.6).rotateAroundX(new Random().nextInt(360)), "", Material.STONE);
                    break;
                case "ALGAE_GOLEM":
                    switch (new Random().nextInt(7)) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            attacks.createItem(victim.getLocation(), 5980, Material.KELP, true);
                            break;
                        case 5:
                            attacks.createItem(victim.getLocation(), 5980, Material.SCUTE, true);
                            break;
                        case 6:
                            attacks.createItem(victim.getLocation(), 5980, Material.SEA_PICKLE, true);
                            break;
                        case 7:
                            attacks.createItem(victim.getLocation(), 5980, Material.SEAGRASS, true);
                    }
                    break;
            }
        }
    }

    @EventHandler
    public void onOtherDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        org.bukkit.entity.LivingEntity victim = (LivingEntity) event.getEntity();
        double damage = 0.0;
        double mod = 1.0;

        Player player;
        if (victim instanceof Player) {
            player = (Player)victim;
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

            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                mod -= .9;
            }
        }
        String id = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING);
        if (id == null) {
            id = "";
        }

        if (id.equals("DAMAGE_INDICATOR")) {
            return;
        }

        double MaxHealth = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);
        double Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);

        if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            float distance = victim.getFallDistance();
            if (victim instanceof Player) {
                damage = (MaxHealth / 100) * distance;
            } else {
                if (!id.equals("boss")) {
                    if (MaxHealth < 1000) {
                        damage = (MaxHealth / 100) * distance;
                    } else {
                        damage = 10 * ((double)distance);
                    }
                }
            }
        }

        if (event.getCause() == EntityDamageEvent.DamageCause.CRAMMING ||
            event.getCause() == EntityDamageEvent.DamageCause.DROWNING ||
            event.getCause() == EntityDamageEvent.DamageCause.DRYOUT ||
            event.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) {
            if (victim instanceof Player) {
                damage = MaxHealth / 20;
            } else {
                if (!id.equals("boss")) {
                    if (MaxHealth < 1000) {
                        damage = MaxHealth / 20;
                    } else {
                        damage = 50;
                    }
                }
            }
        }

        if (event.getCause() == EntityDamageEvent.DamageCause.FIRE ||
            event.getCause() == EntityDamageEvent.DamageCause.POISON ||
            event.getCause() == EntityDamageEvent.DamageCause.FREEZE ||
            event.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR ||
            event.getCause() == EntityDamageEvent.DamageCause.MELTING ||
            event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
            if (victim instanceof Player) {
                damage = MaxHealth / 35;
            } else {
                if (!id.equals("boss")) {
                    if (MaxHealth < 1000) {
                        damage = MaxHealth / 35;
                    } else {
                        damage = 30;
                    }
                }
            }
        }

        if (event.getCause() == EntityDamageEvent.DamageCause.WITHER ||
                event.getCause() == EntityDamageEvent.DamageCause.LAVA) {
            if (victim instanceof Player) {
                damage = MaxHealth / 15;
            } else {
                if (!id.equals("boss")) {
                    if (MaxHealth < 1000) {
                        damage = MaxHealth / 15;
                    } else {
                        damage = 66;
                    }
                }
            }
        }


        if (mod < 0) {
            mod = 0;
        }
        damage *= mod;
        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, Health - damage);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {

                        if (!(victim instanceof Player) &&
                            victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING) != "DAMAGE_INDICATOR") {
                            functions.updateHealth(victim);
                        }
                        if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                PersistentDataType.STRING) != null) {
                            switch (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING)) {
                                //flesh maggot creation of the host
                                case "HOST":
                                    Mobs.FLESH_MAGGOT.createMob(plugin, victim.getLocation());
                                    break;
                                //death of summon clearing mount
                                case "MAGGOT":
                                case "FLESH_LARVA":
                                    LivingEntity passenger = (LivingEntity) event.getEntity().getPassengers().get(0);
                                    if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                            PersistentDataType.DOUBLE) < 1) {
                                        passenger.setHealth(0);
                                    }
                                    passenger.setCustomName(victim.getCustomName());
                                    break;
                                case "VOLATILE_SLIME":
                                    new BukkitRunnable() {
                                        int iterations = 0;
                                        FallingBlock block = attacks.createBlock(victim.getLocation(), 2400.0, Material.SLIME_BLOCK, victim, true);
                                        public void run()
                                        {
                                            block.setGravity(false);
                                            iterations += 1;
                                            if (block.isDead() ||
                                                iterations >= 6) {
                                                block.getWorld().createExplosion(block.getLocation(), 7.2f, false, false, block);
                                                block.remove();
                                                this.cancel();
                                                return;
                                            }

                                            if (iterations % 2 == 0) {
                                                block.remove();
                                                block = attacks.createBlock(block.getLocation(), 2400.0, Material.HONEY_BLOCK, victim, true);
                                                block.setGravity(false);
                                            } else {
                                                block.remove();
                                                block = attacks.createBlock(block.getLocation(), 2400.0, Material.SLIME_BLOCK, victim, true);
                                                block.setGravity(false);
                                            }
                                        }
                                    }.runTaskTimer(plugin, 0, 15);
                                    break;

                            }
                        }

                        if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE) < 1.0) {
                            victim.setHealth(0.0);
                        }

                        victim.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,
                                10, 0, true, false));
                        victim.setNoDamageTicks(0);

            }
        }, 1);
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {
                case "Lesser Spirit Wolf":
                    Wolf wolfLesser = (Wolf) entity;
                    Bukkit.getPlayer(wolfLesser.getOwner().getUniqueId()).getInventory().addItem(Items.LESSER_SPIRIT_BONE_SHARD.getItem(plugin));
                    break;
                case "Greater Spirit Wolf":
                    Wolf wolfGreater = (Wolf) entity;
                    Bukkit.getPlayer(wolfGreater.getOwner().getUniqueId()).getInventory().addItem(Items.GREATER_SPIRIT_BONE_SHARD.getItem(plugin));
                    break;
                case "REVENANT":
                    if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) != 0) {
                    ((LivingEntity) entity).setHealth(20);
                    entity.setInvulnerable(true);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run() {
                            entity.setInvulnerable(false);
                            entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                                    PersistentDataType.DOUBLE, 0.0);
                            ((LivingEntity) entity).setHealth(0);
                        }
                    }, 80);
                }
            }
        }
    }
}

//int, strength, defense, health, crit/chance