package its.wurm.testplugin.Events;

import its.wurm.testplugin.Mobs.Attacks;
import its.wurm.testplugin.Mobs.Mobs;
import its.wurm.testplugin.statFunctions.StatFunctions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Biome;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.world.EntitiesLoadEvent;
import org.bukkit.event.world.EntitiesUnloadEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MobSpawnEvent implements Listener {
    Plugin plugin;
    Attacks attacks;
    StatFunctions functions;
    int amount;

    public MobSpawnEvent(Plugin plugin) {
        this.plugin = plugin;
        this.attacks = new Attacks(plugin);
        this.functions = new StatFunctions(plugin, attacks);
        this.amount = 0;

        new BukkitRunnable() {
            int total;
            Entity entity;
            List<Entity> list;
            boolean check;
            public void run()
            {
                total = 0;
                check = false;
                for (int i = 0; i < Bukkit.getWorld("world").getEntities().size(); i++) {
                    entity = Bukkit.getWorld("world").getEntities().get(i);
                    if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) == null) {
                        functions.CheckHealth(entity, plugin);
                    }
                    if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                            PersistentDataType.INTEGER) != null) {
                        total += 1;
                        list = (List<Entity>)Bukkit.getWorld("world").getNearbyEntities(entity.getLocation(), 96, 96, 96);
                        for (int e = 0; e < list.size(); e++) {
                            if (list.get(e) instanceof Player) {
                                check = true;
                            }
                        }
                        if (!check) {
                            entity.remove();
                        }
                    }
                }

                for (int i = 0; i < Bukkit.getWorld("world_nether").getEntities().size(); i++) {
                    entity = Bukkit.getWorld("world_nether").getEntities().get(i);
                    if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) == null) {
                        functions.CheckHealth(entity, plugin);
                    }
                    if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                            PersistentDataType.INTEGER) != null) {
                        total += 1;
                        list = (List<Entity>)Bukkit.getWorld("world_nether").getNearbyEntities(entity.getLocation(), 289, 289, 289);
                        for (int e = 0; e < list.size(); e++) {
                            if (list.get(e) instanceof Player) {
                                check = true;
                            }
                        }
                        if (!check) {
                            entity.remove();
                        }
                    }
                }

                for (int i = 0; i < Bukkit.getWorld("world_the_end").getEntities().size(); i++) {
                    entity = Bukkit.getWorld("world_the_end").getEntities().get(i);
                    if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                            PersistentDataType.DOUBLE) == null) {
                        functions.CheckHealth(entity, plugin);
                    }
                    if (Bukkit.getWorld("world_the_end").getEntities().get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                            PersistentDataType.INTEGER) != null) {
                        total += 1;
                        list = (List<Entity>)Bukkit.getWorld("world_the_end").getNearbyEntities(entity.getLocation(), 289, 289, 289);
                        for (int e = 0; e < list.size(); e++) {
                            if (list.get(e) instanceof Player) {
                                check = true;
                            }
                        }
                        if (!check) {
                            entity.remove();
                        }
                    }
                }

                amount = total;
            }
        }.runTaskTimer(plugin, 0, 120);
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player) && entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) == null) {
            functions.CheckHealth(entity, plugin);
        }
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        LivingEntity creature = event.getEntity();

        if (creature instanceof Player) {
            return;
        }

        List<Mobs> selection = new ArrayList<>();
        int weight = 0;
        Random random = new Random();
        Biome biome = creature.getLocation().getBlock().getBiome();
        if (creature.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                PersistentDataType.STRING) != null) {
            return;
        }

         if ((creature instanceof Monster ||
            creature instanceof Shulker ||
            creature instanceof Hoglin ||
            creature instanceof Ghast ||
            creature instanceof Slime ||
            creature instanceof MagmaCube ||
            creature instanceof Phantom)
                &&
            (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL ||
            event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.VILLAGE_INVASION ||
            event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG ||
            event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NETHER_PORTAL)) {
             creature.remove();

             if (amount <= creature.getWorld().getMonsterSpawnLimit() * Bukkit.getServer().getOnlinePlayers().size()) {
                 switch (biome) {
                     case PLAINS:
                     case SUNFLOWER_PLAINS:
                         selection.add(Mobs.NOVICE_SKELETON);
                         weight += Mobs.NOVICE_SKELETON.weight;
                         selection.add(Mobs.FENCER_ZOMBIE);
                         weight += Mobs.FENCER_ZOMBIE.weight;
                         selection.add(Mobs.RENEGADE_PILLAGER);
                         weight += Mobs.RENEGADE_PILLAGER.weight;
                         selection.add(Mobs.MARAUDING_VINDICATOR);
                         weight += Mobs.MARAUDING_VINDICATOR.weight;
                         selection.add(Mobs.WOLF_SPIDER);
                         weight += Mobs.WOLF_SPIDER.weight;
                         selection.add(Mobs.SKELETON_GRUNT);
                         weight += Mobs.SKELETON_GRUNT.weight;
                         selection.add(Mobs.CREEPLING);
                         weight += Mobs.CREEPLING.weight;
                         break;
                     case FLOWER_FOREST:
                         selection.add(Mobs.BEEKEEPER);
                         weight += Mobs.BEEKEEPER.weight;
                         selection.add(Mobs.WOLF_SPIDER);
                         weight += Mobs.WOLF_SPIDER.weight;
                         selection.add(Mobs.SWARM_MARKER);
                         weight += Mobs.SWARM_MARKER.weight;
                         selection.add(Mobs.HONEY_SLIME);
                         weight += Mobs.HONEY_SLIME.weight;
                         selection.add(Mobs.SWARM_ARCHER);
                         weight += Mobs.SWARM_ARCHER.weight;
                         selection.add(Mobs.HONEYPOT_CREEPER);
                         weight += Mobs.HONEYPOT_CREEPER.weight;
                         break;
                     case BEACH:
                         selection.add(Mobs.ROTTING_FISHERMAN);
                         weight += Mobs.ROTTING_FISHERMAN.weight;
                         selection.add(Mobs.AQUATIC_ISOPOD);
                         weight += Mobs.AQUATIC_ISOPOD.weight;
                         selection.add(Mobs.SEA_SKELETON);
                         weight += Mobs.SEA_SKELETON.weight;
                         selection.add(Mobs.RUSTY_GOLEM);
                         weight += Mobs.RUSTY_GOLEM.weight;
                         break;
                     case WOODED_MOUNTAINS:
                         selection.add(Mobs.ZOMBIE_CRUSADER);
                         weight += Mobs.ZOMBIE_CRUSADER.weight;
                     case WOODED_HILLS:
                     case TALL_BIRCH_HILLS:
                     case BIRCH_FOREST_HILLS:
                         selection.add(Mobs.ARMOR_ZOMBIE);
                         weight += Mobs.ARMOR_ZOMBIE.weight;
                     case BIRCH_FOREST:
                     case FOREST:
                     case TALL_BIRCH_FOREST:
                         selection.add(Mobs.WOLF_SPIDER);
                         weight += Mobs.WOLF_SPIDER.weight;
                         selection.add(Mobs.HUNTER);
                         weight += Mobs.HUNTER.weight;
                         selection.add(Mobs.FOREST_SPIRIT);
                         weight += Mobs.FOREST_SPIRIT.weight;
                         selection.add(Mobs.WOOD_MITE);
                         weight += Mobs.WOOD_MITE.weight;
                         selection.add(Mobs.HOST);
                         weight += Mobs.HOST.weight;
                         selection.add(Mobs.LEAFY_CREEPER);
                         weight += Mobs.LEAFY_CREEPER.weight;
                         selection.add(Mobs.CARNIVOROUS_CONEY);
                         weight += Mobs.CARNIVOROUS_CONEY.weight;
                         selection.add(Mobs.SCOUT);
                         weight += Mobs.SCOUT.weight;
                         break;
                     case DESERT:
                     case DESERT_HILLS:
                     case DESERT_LAKES:
                         selection.add(Mobs.ANTLION);
                         weight += Mobs.ANTLION.weight;
                         selection.add(Mobs.RELENTLESS);
                         weight += Mobs.RELENTLESS.weight;
                         selection.add(Mobs.SANDY_SKELETON);
                         weight += Mobs.SANDY_SKELETON.weight;
                         selection.add(Mobs.BANDIT_ARCHER);
                         weight += Mobs.BANDIT_ARCHER.weight;
                         selection.add(Mobs.ANCIENT_PHARAOH);
                         weight += Mobs.ANCIENT_PHARAOH.weight;
                         selection.add(Mobs.SAND_WITCH);
                         weight += Mobs.SAND_WITCH.weight;
                         selection.add(Mobs.CACTUS_ZOMBIE);
                         weight += Mobs.CACTUS_ZOMBIE.weight;
                         selection.add(Mobs.BURROWING_CREEPER);
                         weight += Mobs.BURROWING_CREEPER.weight;
                         selection.add(Mobs.CAMEL_SPIDER);
                         weight += Mobs.CAMEL_SPIDER.weight;
                         break;
                     case SAVANNA:
                     case SAVANNA_PLATEAU:
                     case SHATTERED_SAVANNA:
                     case SHATTERED_SAVANNA_PLATEAU:
                         selection.add(Mobs.WANDERING_SPIDER);
                         weight += Mobs.WANDERING_SPIDER.weight;
                         selection.add(Mobs.WEAVER_SPIDER);
                         weight += Mobs.WEAVER_SPIDER.weight;
                         selection.add(Mobs.ANGUISHED_SPIRIT);
                         weight += Mobs.ANGUISHED_SPIRIT.weight;
                         selection.add(Mobs.PAINTED_DOG);
                         weight += Mobs.PAINTED_DOG.weight;
                         selection.add(Mobs.PIGMENTED_CREEPER);
                         weight += Mobs.PIGMENTED_CREEPER.weight;
                         selection.add(Mobs.REGEN_ZOMBIE);
                         weight += Mobs.REGEN_ZOMBIE.weight;
                         selection.add(Mobs.HOG);
                         weight += Mobs.HOG.weight;
                         break;
                     case BAMBOO_JUNGLE:
                     case BAMBOO_JUNGLE_HILLS:
                         selection.add(Mobs.PANDA_MOUNT);
                         weight += Mobs.PANDA_MOUNT.weight;
                         selection.add(Mobs.RAGING_PANDA);
                         weight += Mobs.RAGING_PANDA.weight;
                     case JUNGLE:
                     case JUNGLE_EDGE:
                     case JUNGLE_HILLS:
                     case MODIFIED_JUNGLE_EDGE:
                     case MODIFIED_JUNGLE:
                         selection.add(Mobs.DARTMAN);
                         weight += Mobs.DARTMAN.weight;
                         selection.add(Mobs.SPEARMAN);
                         weight += Mobs.SPEARMAN.weight;
                         selection.add(Mobs.JUNGLE_SKELETON);
                         weight += Mobs.JUNGLE_SKELETON.weight;
                         selection.add(Mobs.AMBUSH_SPIDER);
                         weight += Mobs.AMBUSH_SPIDER.weight;
                         selection.add(Mobs.EPSILON_MARKER);
                         weight += Mobs.EPSILON_MARKER.weight;
                         selection.add(Mobs.LOST_GOLEM);
                         weight += Mobs.LOST_GOLEM.weight;
                         selection.add(Mobs.CAMO_OOZE);
                         weight += Mobs.CAMO_OOZE.weight;
                         selection.add(Mobs.BLOB_MUTAGEN);
                         weight += Mobs.BLOB_MUTAGEN.weight;
                         selection.add(Mobs.CREEPER_PURSUER);
                         weight += Mobs.CREEPER_PURSUER.weight;
                         selection.add(Mobs.ELITE_HUNTER);
                         weight += Mobs.ELITE_HUNTER.weight;
                         break;
                     case GIANT_SPRUCE_TAIGA:
                     case GIANT_SPRUCE_TAIGA_HILLS:
                     case GIANT_TREE_TAIGA:
                     case GIANT_TREE_TAIGA_HILLS:
                     case TAIGA:
                     case TAIGA_HILLS:
                     case TAIGA_MOUNTAINS:
                         selection.add(Mobs.DIRE_WOLF_ALPHA);
                         weight += Mobs.DIRE_WOLF_ALPHA.weight;
                         selection.add(Mobs.TIMBER_WOLF);
                         weight += Mobs.TIMBER_WOLF.weight;
                         selection.add(Mobs.UNDEAD_LOGGER);
                         weight += Mobs.UNDEAD_LOGGER.weight;
                         selection.add(Mobs.MULCHLING);
                         weight += Mobs.MULCHLING.weight;
                         selection.add(Mobs.DARK_IRON_ARCHER);
                         weight += Mobs.DARK_IRON_ARCHER.weight;
                         selection.add(Mobs.REVENANT);
                         weight += Mobs.REVENANT.weight;
                         selection.add(Mobs.ELITE_HUNTER);
                         weight += Mobs.ELITE_HUNTER.weight;
                         selection.add(Mobs.HOUNDMASTER);
                         weight += Mobs.HOUNDMASTER.weight;
                         selection.add(Mobs.HUNTER_SPIDER);
                         weight += Mobs.HUNTER_SPIDER.weight;
                         selection.add(Mobs.DISGRUNTLED_LUMBERJACK);
                         weight += Mobs.DISGRUNTLED_LUMBERJACK.weight;
                         selection.add(Mobs.ARCHER_ELITE);
                         weight += Mobs.ARCHER_ELITE.weight;
                         selection.add(Mobs.SPIDER_QUEEN);
                         weight += Mobs.SPIDER_QUEEN.weight;
                         break;
                     case MOUNTAINS:
                     case GRAVELLY_MOUNTAINS:
                     case MOUNTAIN_EDGE:
                     case MODIFIED_GRAVELLY_MOUNTAINS:
                         selection.add(Mobs.LOST_GOLEM);
                         weight += Mobs.LOST_GOLEM.weight;
                         selection.add(Mobs.ZOMBIE_KNIGHT);
                         weight += Mobs.ZOMBIE_KNIGHT.weight;
                         selection.add(Mobs.CRAZED_GOAT);
                         weight += Mobs.CRAZED_GOAT.weight;
                         selection.add(Mobs.DEEP_MOUNTAIN_BURROWER);
                         weight += Mobs.DEEP_MOUNTAIN_BURROWER.weight;
                         selection.add(Mobs.STONEHILL_GIANT);
                         weight += Mobs.STONEHILL_GIANT.weight;
                         selection.add(Mobs.STONESHELL);
                         weight += Mobs.STONESHELL.weight;
                         selection.add(Mobs.SNAPPER);
                         weight += Mobs.SNAPPER.weight;
                         break;
                     case STONE_SHORE:
                         selection.add(Mobs.SNAPPER);
                         weight += Mobs.SNAPPER.weight;
                         selection.add(Mobs.DEEP_MOUNTAIN_BURROWER);
                         weight += Mobs.DEEP_MOUNTAIN_BURROWER.weight;
                         selection.add(Mobs.CRAZED_GOAT);
                         weight += Mobs.CRAZED_GOAT.weight;
                         break;
                 }

                 if (selection.isEmpty()) {
                     return;
                 }
                 int choice = random.nextInt(weight);
                 for (int i = 0; i < selection.size(); i++) {
                     if (random.nextInt(weight) <= selection.get(i).weight) {
                         selection.get(i).createMob(plugin, creature.getLocation()).getPersistentDataContainer().set(new NamespacedKey(plugin, "spawned"),
                                 PersistentDataType.INTEGER, 1);
                         amount += 1;
                         return;
                     } else {
                         weight -= selection.get(i).weight;
                     }
                 }
             }
         }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        Entity victim = event.getEntity();
        if (victim.getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                PersistentDataType.INTEGER) != null) {
            amount -= 1;
        }
    }

    @EventHandler
    public void onUnload(EntitiesUnloadEvent event) {
        List<Entity> selection = event.getEntities();
        for (int i = 0; i < selection.size(); i++) {
            if (selection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                    PersistentDataType.INTEGER) != null) {
                selection.get(i).remove();
                amount -= 1;
            }
        }
    }

    @EventHandler
    public void onLoad(EntitiesLoadEvent event) {
        List<Entity> selection = event.getEntities();
        for (int i = 0; i < selection.size(); i++) {
            if (selection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                    PersistentDataType.INTEGER) != null) {
                if (!(selection.get(i) instanceof Player) && selection.get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.STRING) == null) {
                    functions.CheckHealth(selection.get(i), plugin);
                }
            }
        }
    }

    @EventHandler
    public void onLoad(ServerLoadEvent event) {
        for (int i = 0; i < Bukkit.getWorld("world").getEntities().size(); i++) {
            if (Bukkit.getWorld("world").getEntities().get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                    PersistentDataType.INTEGER) != null) {
                Bukkit.getWorld("world").getEntities().get(i).remove();
            }

            if (Bukkit.getWorld("world").getEntities().get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) == null) {
                functions.CheckHealth(Bukkit.getWorld("world").getEntities().get(i), plugin);
            }
        }
        for (int i = 0; i < Bukkit.getWorld("world_nether").getEntities().size(); i++) {
            if (Bukkit.getWorld("world_nether").getEntities().get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                    PersistentDataType.INTEGER) != null) {
                Bukkit.getWorld("world_nether").getEntities().get(i).remove();
            }

            if (Bukkit.getWorld("world_nether").getEntities().get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) == null) {
                functions.CheckHealth(Bukkit.getWorld("world_nether").getEntities().get(i), plugin);
            }
        }
        for (int i = 0; i < Bukkit.getWorld("world_the_end").getEntities().size(); i++) {
            if (Bukkit.getWorld("world_the_end").getEntities().get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "spawned"),
                    PersistentDataType.INTEGER) != null) {
                Bukkit.getWorld("world_the_end").getEntities().get(i).remove();
            }

            if (Bukkit.getWorld("world_the_end").getEntities().get(i).getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE) == null) {
                functions.CheckHealth(Bukkit.getWorld("world_the_end").getEntities().get(i), plugin);
            }
        }
    }
}
