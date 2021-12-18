package its.wurm.testplugin.Events;

import its.wurm.testplugin.Main;
import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import java.util.Random;

public class StatEvents implements Listener {

    Main plugin;

    public StatEvents(Main plugin) { this.plugin = plugin;}

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            StatFunctions.CheckHealth(entity, plugin);
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Double MaxHealth = event.getPlayer().getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);
        event.getPlayer().getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, MaxHealth);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                        9999999, 5, true, false));
            }
        }, 3L);
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        Entity shooter = event.getEntity();
        Entity proj = event.getProjectile();
        Double dmg = shooter.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        proj.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, dmg);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.ARMOR_STAND && event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER) != null && event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER) == 8) {
            return;
        }
        if (!(event.getEntity() instanceof Damageable)) {
            return;
        }

        org.bukkit.entity.Damageable victim = (Damageable) event.getEntity();

        org.bukkit.entity.LivingEntity living = (LivingEntity) victim;
        living.setNoDamageTicks(1);

        Entity attacker = event.getDamager();
        Double Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);

        if (!(attacker instanceof Player)) {
            if (victim instanceof Player) {
                Player player = ((Player) victim).getPlayer();
                if (player.isBlocking() &&
                    player.getCooldown(Material.SHIELD) == 0 &&
                    player.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD) != 0) {
                    Attacks.createDamageIndicator(victim.getLocation(), false, 0.0);
                    player.setStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD, 0);
                    Double cd = 120.0;

                    if (player.getInventory().getItemInOffHand().getType() == Material.SHIELD) {
                        cd = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) / player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                                PersistentDataType.DOUBLE);
                    }

                    if (player.getInventory().getItemInMainHand().getType() == Material.SHIELD) {
                        cd = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                                PersistentDataType.DOUBLE) / player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                                PersistentDataType.DOUBLE);
                    }


                    int cooldown = cd.intValue();
                    player.setCooldown(Material.SHIELD, cooldown);
                    return;
                }
            }


            Double AfterDamage = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) + 100;
            AfterDamage = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) / AfterDamage;
            AfterDamage = AfterDamage + 1.0;

            AfterDamage = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE) / AfterDamage;
            Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) - AfterDamage;

            Attacks.createDamageIndicator(victim.getLocation(), false, AfterDamage);
        }

        if (attacker instanceof Player) {

            if (victim instanceof Player) {
                Player player = ((Player) victim).getPlayer();
                if (player.isBlocking() &&
                    player.getCooldown(Material.SHIELD) == 0 &&
                    player.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD) != 0) {
                    Attacks.createDamageIndicator(victim.getLocation(), false, 0.0);
                    player.setStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD, 0);
                    Double cd = 120.0;

                    if (player.getInventory().getItemInOffHand().getType() == Material.SHIELD) {
                        cd = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE) / player.getInventory().getItemInOffHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                            PersistentDataType.DOUBLE);
                    }

                    if (player.getInventory().getItemInMainHand().getType() == Material.SHIELD) {
                        cd = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                            PersistentDataType.DOUBLE) / player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "Integrity"),
                            PersistentDataType.DOUBLE);
                    }


                    int cooldown = cd.intValue();
                    player.setCooldown(Material.SHIELD, cooldown);
                    return;
                }
            }

            boolean iscrit = false;
            Double AfterDamage = (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/20) + 5 + attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE);
            AfterDamage = ((attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Strength"),
                    PersistentDataType.DOUBLE)/100) + 1) * AfterDamage;
            AfterDamage = (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 1) * AfterDamage;
            Random crit = new Random();
            int choice = crit.nextInt(100) + 1;
            if (choice <= attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "CritChance"),
                    PersistentDataType.DOUBLE)) {
                iscrit = true;
                Double dmg = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Crit"),
                        PersistentDataType.DOUBLE)/100;

                AfterDamage = (dmg + 1) * AfterDamage;
            }
            Double def = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) + 100;
            def = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                    PersistentDataType.DOUBLE) / def;
            AfterDamage = AfterDamage/(def + 1.0);
            Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) - AfterDamage;

            Attacks.createDamageIndicator(victim.getLocation(), iscrit, AfterDamage);
        }

        if (victim instanceof Player) {
            Player player = ((Player) victim).getPlayer();
            StatFunctions.ShowStat(player, plugin);
        }

        Double MaxHealth = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);
        Double Damage = attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE);
        Double Defense = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE);
        String Name = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);

        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, Health);

        if (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER) != null) {
            switch (attacker.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.INTEGER)) {
                //Frost Attack of the Chill Zombie
                case 1:
                    victim.setFreezeTicks(110);
                    break;
                //Disarming Attack of the Fencer Zombie
                case 2:
                    Random ran = new Random();
                    int choice = ran.nextInt(3) + 1;
                    if (choice == 3) {
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
                case 9:
                    if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) < 1) {
                        org.bukkit.entity.Arrow arrow = (Arrow) event.getDamager();
                        ProjectileSource source = arrow.getShooter();
                        org.bukkit.entity.Player player = (Player) source;
                        player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBase"),
                                PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBase"),
                                PersistentDataType.DOUBLE) + 8);
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "SpeedBase"),
                                        PersistentDataType.DOUBLE, (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "SpeedBase"),
                                        PersistentDataType.DOUBLE) - 8));
                            }
                        }, 200);
                    }
                    break;
                default:
                    return;
            }
        }

        if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.INTEGER) != null) {
            switch (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.INTEGER)) {
                case 3:
                    victim.getWorld().playSound(victim.getLocation(), Sound.BLOCK_ANVIL_PLACE, 120, 0);
                    break;
                case 5:
                    if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) < 1.0) {
                        Mobs.createGrowth(victim.getLocation());
                    }
                    break;
                case 7:
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
                default:
                    return;
            }
        }
    }

    @EventHandler
    public void onOtherDamage(EntityDamageEvent event) {
        org.bukkit.entity.Damageable victim = (Damageable) event.getEntity();

        Double MaxHealth = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);
        Double Health = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        String Name = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);

        victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, Health);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (event.getCause() == EntityDamageEvent.DamageCause.CRAMMING ||
                    event.getCause() == EntityDamageEvent.DamageCause.DROWNING ||
                    event.getCause() == EntityDamageEvent.DamageCause.DRYOUT ||
                    event.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) {
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, Health - (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE) / 20) - 10);
                    Attacks.createDamageIndicator(victim.getLocation(), false, (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) / 20) - 10);
                }

                if (event.getCause() == EntityDamageEvent.DamageCause.FIRE ||
                    event.getCause() == EntityDamageEvent.DamageCause.POISON ||
                    event.getCause() == EntityDamageEvent.DamageCause.FREEZE ||
                    event.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR ||
                    event.getCause() == EntityDamageEvent.DamageCause.MELTING) {
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, Health - victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE) / 35);
                    Attacks.createDamageIndicator(victim.getLocation(), false, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) / 35);
                }

                if (event.getCause() == EntityDamageEvent.DamageCause.WITHER ||
                        event.getCause() == EntityDamageEvent.DamageCause.LAVA) {
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, Health - victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE) / 18);
                    Attacks.createDamageIndicator(victim.getLocation(), false, victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) / 18);
                }

                if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    float distance = victim.getFallDistance();
                    victim.sendMessage("fell " + distance);
                    victim.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE, Health - ((victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                                    PersistentDataType.DOUBLE) / 100) * distance));
                    Attacks.createDamageIndicator(victim.getLocation(), false, ((victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE) / 100) * distance));
                }

                double afterHealth = victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE);

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
                if (!(victim instanceof Player)) {
                    victim.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                            afterHealth + "/" + MaxHealth);
                }

                if (afterHealth < 1.0) {
                    victim.setHealth(0.0);
                }
            }
        }, 1);
    }
}

//int, strength, defense, health, crit/chance