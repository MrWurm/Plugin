package its.wurm.testplugin.Mobs;

import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.List;

public class Attacks implements Listener {

    Plugin plugin;
    StatFunctions functions;

    public Attacks(Plugin plugin) {
        this.plugin = plugin;
        this.functions = new StatFunctions(plugin, this);
    }


    public void trail(Entity tracee, Particle particle) {
        tracee.getWorld().spawnParticle(particle, tracee.getLocation(), 1);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (tracee.isDead()) {
                    return;
                }
                trail(tracee, particle);
            }
        }, 1);
    }

    public void trail(Entity tracee, Particle particle, int amount) {
        tracee.getWorld().spawnParticle(particle, tracee.getLocation(), amount, 0, 0, 0, 0.05);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (tracee.isDead()) {
                    return;
                }
                trail(tracee, particle, amount);
            }
        }, 2);
    }

    public void trail(Entity tracee, Color color, float size) {

        tracee.getWorld().spawnParticle(Particle.REDSTONE, tracee.getLocation(), 1, 0, 0,0, new Particle.DustOptions(color, size));
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (tracee.isDead()) {
                    return;
                }
                trail(tracee, color, size);
            }
        }, 1);
    }

    public void trail(Entity tracee, Color color, float size, int amount) {

        tracee.getWorld().spawnParticle(Particle.REDSTONE, tracee.getLocation(), amount, 0, 0,0, new Particle.DustOptions(color, size));
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (tracee.isDead()) {
                    return;
                }
                trail(tracee, color, size, amount);
            }
        }, 1);
    }

    public static void staticTrail(Plugin plugin, Entity tracee, Particle particle) {
        tracee.getWorld().spawnParticle(particle, tracee.getLocation(), 1);
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (tracee.isDead()) {
                    return;
                }
                staticTrail(plugin, tracee, particle);
            }
        }, 1);
    }

    public void track(Entity projectile, Entity source, double range, double velocity) {

        List<Entity> collection = projectile.getNearbyEntities(range, range, range);

        String type = source.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING);

        if (!collection.isEmpty()) {
            for (int i = 0; i < collection.size(); i++) {
                if (!(collection.get(i) instanceof LivingEntity) ||
                    collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                            PersistentDataType.STRING) == null ||
                    collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                    PersistentDataType.STRING).equals(type)) {
                    collection.remove(i);
                    i -= 1;
                }
            }


            if (!collection.isEmpty()) {
                LivingEntity entity = (LivingEntity) collection.get(0);
                projectile.teleport(projectile.getLocation().setDirection(entity.getEyeLocation().subtract(projectile.getLocation().toVector()).toVector()));
                projectile.setVelocity(projectile.getLocation().getDirection().multiply(velocity));
            }
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (projectile.isDead()) {
                    return;
                }
                track(projectile, source, range, velocity);
            }
        }, 3);
    }

    public static void staticTrack(Plugin plugin, Entity projectile, Entity source, double range, double velocity) {

        List<Entity> collection = projectile.getNearbyEntities(range, range, range);

        String type = source.getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING);

        if (!collection.isEmpty()) {
            for (int i = 0; i < collection.size(); i++) {
                if (!(collection.get(i) instanceof LivingEntity) ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING) == null ||
                        collection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "class"),
                                PersistentDataType.STRING).equals(type)) {
                    collection.remove(i);
                    i -= 1;
                }
            }


            if (!collection.isEmpty()) {
                LivingEntity entity = (LivingEntity) collection.get(0);
                projectile.teleport(projectile.getLocation().setDirection(entity.getEyeLocation().subtract(projectile.getLocation().toVector()).toVector()));
                projectile.setVelocity(projectile.getLocation().getDirection().multiply(velocity));
            }
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (projectile.isDead()) {
                    return;
                }
                staticTrack(plugin, projectile, source, range, velocity);
            }
        }, 3);
    }

    public void createDamageIndicator(Location location, Boolean isCrit, Double damage) {
        ArmorStand stand = location.getWorld().spawn(location, ArmorStand.class);

        stand.setInvulnerable(true);
        stand.setGravity(false);
        stand.setVisible(false);
        stand.setSmall(true);
        if (isCrit == true) {
            stand.setCustomName("§6" + damage);
        }
        if (isCrit == false) {
            stand.setCustomName("§7" + damage);
        }

        stand.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, "DAMAGE_INDICATOR");

        stand.setCustomNameVisible(true);
        stand.hasEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.ADDING);
        stand.hasEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.ADDING);
        stand.hasEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.ADDING);
        stand.hasEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.ADDING);

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                stand.remove();
            }
        }, 8);
    }

    public TNTPrimed createTnt(Location location, Double damage, int fuse, Entity source, org.bukkit.util.Vector velocity) {
        TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);
        tnt.setFuseTicks(fuse);
        tnt.setSource(source);
        tnt.setVelocity(velocity);
        tnt.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        tnt.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        tnt.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
        tnt.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, source.getUniqueId().toString());
        return tnt;
    }

    public AreaEffectCloud createCloud(Location location, Double damage, int delay, Entity source, int duration, float range, Color color, float size) {
        AreaEffectCloud cloud = location.getWorld().spawn(location, AreaEffectCloud.class);

        cloud.setParticle(Particle.REDSTONE, new Particle.DustOptions(color, size));
        cloud.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, 1, 0, true), true);
        cloud.setColor(color);
        cloud.setDuration(duration);
        cloud.setReapplicationDelay(delay);
        cloud.setWaitTime(0);
        cloud.setDurationOnUse(0);
        cloud.setRadiusPerTick(0);
        cloud.setRadiusOnUse(0);
        cloud.setRadius(range);

        cloud.getPersistentDataContainer().set(new NamespacedKey(plugin, "attack"),
                PersistentDataType.INTEGER, 1);
        cloud.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        cloud.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        cloud.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
        cloud.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, source.getUniqueId().toString());
        return cloud;
    }

    public FallingBlock createBlock(Location location, Double damage, Material display, Entity source, boolean cancel) {

        FallingBlock block = location.getWorld().spawnFallingBlock(location, Bukkit.createBlockData(display));

        block.setDropItem(false);
        block.setHurtEntities(true);

        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, source.getUniqueId().toString());

        if (cancel) {
            block.getPersistentDataContainer().set(new NamespacedKey(plugin, "cancel"),
                    PersistentDataType.INTEGER, 1);
        }

        return block;
    }

    public FallingBlock createBlock(Location location, Double damage, Material display, Entity source, boolean cancel, String id) {

        FallingBlock block = location.getWorld().spawnFallingBlock(location, Bukkit.createBlockData(display));

        block.setDropItem(false);
        block.setHurtEntities(true);

        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, source.getUniqueId().toString());
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        if (cancel) {
            block.getPersistentDataContainer().set(new NamespacedKey(plugin, "cancel"),
                    PersistentDataType.INTEGER, 1);
        }

        return block;
    }

    public static FallingBlock createStaticBlock(Plugin plugin, Location location, Double damage, Material display, boolean cancel, String id) {

        FallingBlock block = location.getWorld().spawnFallingBlock(location, Bukkit.createBlockData(display));

        block.setDropItem(false);
        block.setHurtEntities(true);

        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        if (cancel) {
            block.getPersistentDataContainer().set(new NamespacedKey(plugin, "cancel"),
                    PersistentDataType.INTEGER, 1);
        }

        return block;
    }

    public PufferFish createPuffer(Location location, Double damage, Entity source, org.bukkit.util.Vector velocity) {
        PufferFish pufferFish = location.getWorld().spawn(location, PufferFish.class);
        pufferFish.setInvulnerable(true);
        pufferFish.setVelocity(velocity);
        pufferFish.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        pufferFish.setPuffState(2);
        pufferFish.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, source.getUniqueId().toString());

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                pufferFish.remove();
            }
        }, 80);

        return pufferFish;
    }

    public LightningStrike createLightning(Location location, Double damage) {
        LightningStrike lightning = location.getWorld().spawn(location, LightningStrike.class);
        lightning.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        return  lightning;
    }

    public LightningStrike createLightning(Location location, Double damage, Entity player) {
        LightningStrike lightning = location.getWorld().spawn(location, LightningStrike.class);
        lightning.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        lightning.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, player.getUniqueId().toString());
        return lightning;
    }


    public Trident createTrident(Location location, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, String id) {
        Trident arrow = location.getWorld().spawn(location, Trident.class);

        arrow.setShooter(source);
        arrow.setVelocity(velocity);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);
        arrow.setShooter(source);

        return arrow;
    }

    public Snowball createSnowball(Location location, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, String id, Material material) {
        Snowball snowball = location.getWorld().spawn(location, Snowball.class);
        ItemStack item = new ItemStack(material);
        snowball.setShooter(source);
        snowball.setVelocity(velocity);
        snowball.setItem(item);

        snowball.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        snowball.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        return snowball;
    }

    public static Snowball createStaticSnowball(Plugin plugin, Location location, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, String id, Material material) {
        Snowball snowball = location.getWorld().spawn(location, Snowball.class);
        ItemStack item = new ItemStack(material);
        snowball.setShooter(source);
        snowball.setVelocity(velocity);
        snowball.setItem(item);

        snowball.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        snowball.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        return snowball;
    }

    public Arrow createArrow(Location location, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, String id, int pierce) {
        Arrow arrow = location.getWorld().spawn(location, Arrow.class);
        arrow.setShooter(source);
        arrow.setVelocity(velocity);
        arrow.setPierceLevel(pierce);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        return arrow;
    }

    public static Arrow createArrowStatic(Location location, Plugin plugin, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, String id, int pierce) {
        Arrow arrow = location.getWorld().spawn(location, Arrow.class);
        arrow.setShooter(source);
        arrow.setVelocity(velocity);
        arrow.setPierceLevel(pierce);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        return arrow;
    }

    public Arrow createArrow(Location location, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, String id, int pierce, Color color) {
        Arrow arrow = location.getWorld().spawn(location, Arrow.class);
        arrow.setShooter(source);
        arrow.setVelocity(velocity);
        arrow.setPierceLevel(pierce);
        arrow.setColor(color);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        arrow.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        return arrow;
    }

    public WitherSkull createSkull(Location location, Double damage, ProjectileSource source, org.bukkit.util.Vector velocity, String id, boolean charged) {
        WitherSkull skull = location.getWorld().spawn(location, WitherSkull.class);
        skull.setShooter(source);
        skull.setVelocity(velocity);
        skull.setCharged(charged);
        skull.setShooter(source);
        skull.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        skull.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);

        return skull;
    }

    public Item createItem(Location location, int time, Material type, boolean pick) {
        Item item = location.getWorld().spawn(location, Item.class);
        ItemStack itemStack = new ItemStack(type, 1);
        if (pick == true) {
            item.setPickupDelay(32768);
        }
        item.setItemStack(itemStack);
        item.setTicksLived(time);
        item.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, 999999999.0);
        item.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, 999999999.0);
        return item;
    }

    public void createMarkBlock(Location location, int time, String team) {
        location = new Location(location.getWorld(), location.getX() + 0.5, location.getY(), location.getZ() + 0.5);
        Shulker block = location.getWorld().spawn(location, Shulker.class);

        block.setSilent(true);
        block.setCollidable(false);
        block.setInvulnerable(true);
        block.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                9999999, 0, true, false));
        block.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, "block");
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
        block.setGlowing(true);
        block.setGravity(false);
        block.setAI(false);
        Team blockTeam = board.getTeam(team);
        blockTeam.addEntry(block.getUniqueId().toString());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                block.remove();
            }
        }, time);
    }

    public void createSummon(Location location, int lifeTicks, AnimalTamer owner, LivingEntity type, double damage, double health, double defense, String name, String id) {
        Wolf wolf = location.getWorld().spawn(location, Wolf.class);
        wolf.setAge(-666);
        wolf.setAgeLock(true);
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                9999999, 0, true, false));
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                9999999, 5, true, false));
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                9999999, 1, true, false));
        wolf.setOwner(owner);
        wolf.setSilent(true);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE, health);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, health);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, defense);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, name);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING, "adventurer");
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, owner.getUniqueId().toString());


        type.setInvulnerable(true);
        type.setAI(false);

        type.setCustomName(ChatColor.GOLD + "" + wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
            PersistentDataType.STRING) + "" + ChatColor.RED + " ❤" +
        wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
            PersistentDataType.DOUBLE) + "/" + wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
            PersistentDataType.DOUBLE));

        type.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING, "adventurer");
        wolf.addPassenger(type);


        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                wolf.remove();
                type.remove();
            }
        }, lifeTicks);
    }

    public Wolf createSpiritWolf(Plugin plugin, Player player, double health, double damage, double defense, double speed, String id) {
        double mod = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Invocation"),
                PersistentDataType.DOUBLE) / 100 + 1;
        Wolf wolf = player.getLocation().getWorld().spawn(player.getLocation(), Wolf.class);
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                9999999, 5, true, false));
        wolf.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                9999999, 0, true, false));
        if (speed > 0) {
            wolf.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);

        }

        wolf.setOwner(player);

        wolf.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,
                9999999, 0, true, false));



        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE, health * mod);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE, health * mod);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE, damage * mod);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                PersistentDataType.DOUBLE, defense * mod);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                PersistentDataType.DOUBLE, 0.0);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING, "Spirit Wolf");
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "class"),
                PersistentDataType.STRING, "adventurer");
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING, id);
        wolf.getPersistentDataContainer().set(new NamespacedKey(plugin, "owner"),
                PersistentDataType.STRING, player.getUniqueId().toString());

        String Name = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                PersistentDataType.STRING);
        Double Health = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE);
        Double MaxHealth = wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE);

        wolf.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                Health + "/" + MaxHealth);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {
                if (wolf.isDead()) {
                    return;
                }
                functions.heal(plugin, wolf, wolf.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)/40);
            }
        }, 30, 10);
        return wolf;
    }
}
