package its.wurm.testplugin.Events;

import its.wurm.testplugin.Bosses.Dragon;
import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
    public void onSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            functions.CheckHealth(entity, plugin);
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
    public void onRespawn(PlayerRespawnEvent event) {
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
                        9999999, 5, true, false));
            }
        }, 3L);
    }

    @EventHandler
    public void onTarget(EntityTargetEvent event) {
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
    }

    @EventHandler
    public void onSplit(SlimeSplitEvent event) {
        Slime entity = event.getEntity();
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            switch (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.STRING)) {

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
        Entity proj = event.getEntity();
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
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Damageable)) {
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

                    if (player.getInventory().getItemInOffHand().getType() == Material.SHIELD && player.getInventory().getItemInMainHand().getType() != Material.SHIELD) {
                        cd = (100.0 * (2 + (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
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
                                if (vic.getInventory().getItemInMainHand().equals(Material.AIR)) {
                                    return;
                                }
                                vic.getWorld().dropItem(attacker.getLocation(), vic.getInventory().getItemInMainHand());
                                ItemStack item = new ItemStack(Material.AIR, 1);
                                vic.getInventory().setItemInMainHand(item);
                            }
                        }
                        break;
                    case "POTION_ARROW":
                        switch (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "effect"),
                                PersistentDataType.INTEGER)) {
                            case 2:
                                living.addPotionEffect(new PotionEffect(PotionEffectType.POISON,
                                        2400, 2));
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
                            living.sendMessage("smite");
                            living.getWorld().spawnParticle(Particle.FLASH, living.getLocation(), 1);
                            living.getWorld().playSound(living.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 100, 1);
                            if (victim instanceof Player) {
                                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                                                PersistentDataType.DOUBLE) - 50);
                            } else {
                                victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                                        PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                                                PersistentDataType.DOUBLE) - 50);
                            }
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                public void run() {
                                    if (victim instanceof Player) {
                                        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                                                PersistentDataType.DOUBLE, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
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
                        if (living.hasPotionEffect(PotionEffectType.GLOWING)) {
                            AfterDamage *= 1.35;
                        }
                        break;
                    case "SAND_ARROW":
                        living.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,
                                45, 0));
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

                    if (player.getInventory().getItemInOffHand().getType() == Material.SHIELD && player.getInventory().getItemInMainHand().getType() != Material.SHIELD) {
                        cd = (100.0 * (2 + (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
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

            AfterDamage = (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) +  functions.reforgeOnDamage(((Player) attacker), plugin, AfterDamage, iscrit, max, (LivingEntity)victim).get(0)) * AfterDamage;

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
                case "RUSTY_GOLEM":
                    attacks.createItem(victim.getLocation(), 5960, Material.EXPOSED_COPPER, true);
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
            }
        }
    }

    @EventHandler
    public void onOtherDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Damageable)) {
            return;
        }

        org.bukkit.entity.Damageable victim = (Damageable) event.getEntity();
        double damage = 0.0;

        String id = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING);
        if (id == null) {
            id = "";
        }

        double MaxHealth = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);
        double Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        String Name = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);

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

        if (id == null) {
            id = "";
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
                event.getCause() == EntityDamageEvent.DamageCause.MELTING) {
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


        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, Health - damage);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {

                        if (!(victim instanceof Player) &&
                            victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                                    PersistentDataType.STRING) != "DAMAGE_INDICATOR") {
                            victim.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                                    victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                            PersistentDataType.DOUBLE) + "/" + victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE));
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
                            }
                        }

                        if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                                PersistentDataType.DOUBLE) < 1.0) {
                            victim.setHealth(0.0);
                        }

                        LivingEntity frame = (LivingEntity) victim;
                        if (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION ||
                            event.getCause() == EntityDamageEvent.DamageCause.CONTACT ||
                            event.getCause() == EntityDamageEvent.DamageCause.DRAGON_BREATH ||
                            event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK ||
                            event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION ||
                            event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING ||
                            event.getCause() == EntityDamageEvent.DamageCause.MAGIC ||
                            event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
                            frame.setNoDamageTicks(0);
                }

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
            }
        }
    }
}

//int, strength, defense, health, crit/chance