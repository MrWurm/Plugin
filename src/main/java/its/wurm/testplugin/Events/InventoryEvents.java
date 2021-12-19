package its.wurm.testplugin.Events;
import its.wurm.testplugin.Inventories.FormatRecipesGUI;
import its.wurm.testplugin.Inventories.*;
import its.wurm.testplugin.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class InventoryEvents implements Listener {

    static Plugin plugin;

    public InventoryEvents(Plugin plugin) { this.plugin = plugin;}

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getClickedInventory() == null) {
            return;
        }

        //Main GUI
        if (e.getClickedInventory().getHolder() instanceof MainGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getSlot() == 25) {
                //open Ender Chest gui
                player.openInventory(player.getEnderChest());
            }

            if (e.getSlot() == 30) {
                //open Recipes gui
                RecipeSelectGUI gui = new RecipeSelectGUI(plugin);
                player.openInventory(gui.getInventory());
            }


            //close the gui
            if (e.getSlot() == 49) {
                player.closeInventory();
            }
        }
        if (e.getClickedInventory().getHolder() instanceof RecipeSelectGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                //open weapon gui
                WeaponsSelectGUI gui = new WeaponsSelectGUI(plugin);
                player.openInventory(gui.getInventory());
            }
            if (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) {
                //open armor gui
                ArmorSelectGUI gui = new ArmorSelectGUI(plugin);
                player.openInventory(gui.getInventory());
            }
            if (e.getCurrentItem().getType() == Material.POWDER_SNOW_BUCKET) {
                //open misc gui
                MiscSelectGUI gui = new MiscSelectGUI(plugin);
                player.openInventory(gui.getInventory());
            }
            if (e.getCurrentItem().getType() == Material.COAL) {
                //open materials gui
                MaterialsSelectGUI gui = new MaterialsSelectGUI(plugin);
                player.openInventory(gui.getInventory());
            }
        }

        //recipe gui cancel and goback
        Object gui = e.getClickedInventory().getHolder();
        if (gui instanceof FormatRecipesGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return; }

            if (e.getSlot() == 49) {
                //go back
                player.openInventory(((FormatRecipesGUI)gui).getBackArrow());
            }
        }
        //weapon gui recipes
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof WeaponsSelectGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getSlot() == 0) {
                //open Stone Saber recipe gui
                player.openInventory(FormatRecipesGUI.newStoneSaberGUI(plugin).getInventory());
            }

            if (e.getSlot() == 1) {
                //open Iron Saber recipe gui
                player.openInventory(FormatRecipesGUI.newIronSaberGUI(plugin).getInventory());
            }

            if (e.getSlot() == 2) {
                //open Golden Saber recipe gui
                player.openInventory(FormatRecipesGUI.newGoldSaberGUI(plugin).getInventory());
            }

            if (e.getSlot() == 3) {
                //open Diamond Saber recipe gui
                player.openInventory(FormatRecipesGUI.newDiamondSaberGUI(plugin).getInventory());
            }

            if (e.getSlot() == 4) {
                //open Netherite Saber recipe gui
                player.openInventory(FormatRecipesGUI.newNetheriteSaberGUI(plugin).getInventory());
            }

            if (e.getSlot() == 5) {
                //open Tnt Wand recipe gui
                player.openInventory(FormatRecipesGUI.newTntWandGUI(plugin).getInventory());
            }

            if (e.getSlot() == 6) {
                //open Pufferfish Canon recipe gui
                player.openInventory(FormatRecipesGUI.newPuferFishCanonGUI(plugin).getInventory());
            }

            if (e.getSlot() == 7) {
                //open Aspect of The end recipe gui
                player.openInventory(FormatRecipesGUI.newAspectofTheEndGUI(plugin).getInventory());
            }

            if (e.getSlot() == 8) {
                //open Meat Cleaver recipe gui
                player.openInventory(FormatRecipesGUI.newMeatCleaverGUI(plugin).getInventory());
            }

            if (e.getSlot() == 14) {
                //open Cactus Shield recipe gui
                player.openInventory(FormatRecipesGUI.newCactusShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 15) {
                //open Sparkling Shield recipe gui
                player.openInventory(FormatRecipesGUI.newSparkleShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 16) {
                //open Copper Shield recipe gui
                player.openInventory(FormatRecipesGUI.newCopperShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 17) {
                //open Iron Shield recipe gui
                player.openInventory(FormatRecipesGUI.newIronShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 23) {
                //open Lapis Shield recipe gui
                player.openInventory(FormatRecipesGUI.newLapisShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 24) {
                //open Redstone Shield recipe gui
                player.openInventory(FormatRecipesGUI.newRedstoneShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 25) {
                //open Diamond Shield recipe gui
                player.openInventory(FormatRecipesGUI.newDiamondShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 26) {
                //open Emerald Shield recipe gui
                player.openInventory(FormatRecipesGUI.newEmeraldShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 32) {
                //open Netherite Shield recipe gui
                player.openInventory(FormatRecipesGUI.newNetheriteShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui0 = new RecipeSelectGUI(plugin);
                player.openInventory(gui0.getInventory());
            }
        }
        //armor gui recipes
        if (e.getClickedInventory().getHolder() instanceof ArmorSelectGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getSlot() == 0) {
                //open The Drip recipe gui
                player.openInventory(FormatRecipesGUI.newDripRecipeGUI(plugin).getInventory());
            }

            if (e.getSlot() == 1) {
                //open Supreme Drip recipe gui
                player.openInventory(FormatRecipesGUI.newSupremeDripRecipeGUI(plugin).getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui0 = new RecipeSelectGUI(plugin);
                player.openInventory(gui0.getInventory());
            }
        }

        //misc gui recipes
        if (e.getClickedInventory().getHolder() instanceof MiscSelectGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getSlot() == 0) {
                //open Feather Charm recipe gui
                player.openInventory(FormatRecipesGUI.newfCharmGUI(plugin).getInventory());
            }

            if (e.getSlot() == 1) {
                //open Meaty Stew recipe gui
                player.openInventory(FormatRecipesGUI.newMeatyStewGUI(plugin).getInventory());
            }

            if (e.getSlot() == 2) {
                //open Magic Stew recipe gui
                player.openInventory(FormatRecipesGUI.newMagicStewGUI(plugin).getInventory());
            }


            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui0 = new RecipeSelectGUI(plugin);
                player.openInventory(gui0.getInventory());
            }
        }

        //materials recipes gui
        if (e.getClickedInventory().getHolder() instanceof MaterialsSelectGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }

            if (e.getSlot() == 0) {
                //open Enchanted Dripstone recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedDripstoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 1) {
                //open Enchanted Dripstone Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedDripstoneRecipeGUI(plugin).getInventory());
            }

            if (e.getSlot() == 2) {
                //open Enchanted Coal recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCoalGUI(plugin).getInventory());
            }

            if (e.getSlot() == 3) {
                //open Enchanted Coal Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedCoalGUI(plugin).getInventory());
            }

            if (e.getSlot() == 4) {
                //open Enchanted Deepslate recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedDeepslateGUI(plugin).getInventory());
            }

            if (e.getSlot() == 5) {
                //open Enchanted Polished Deepslate recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedDeepslateGUI(plugin).getInventory());
            }

            if (e.getSlot() == 6) {
                //open Enchanted Deepslate Tiles recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedDeepslateGUI(plugin).getInventory());
            }

            if (e.getSlot() == 7) {
                //open Enchanted Bamboo recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBambooGUI(plugin).getInventory());
            }

            if (e.getSlot() == 8) {
                //open Bamboo Bundle recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedBambooGUI(plugin).getInventory());
            }

            if (e.getSlot() == 9) {
                //open Enchanted Iron recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedIronGUI(plugin).getInventory());
            }

            if (e.getSlot() == 10) {
                //open Enchanted Iron Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedIronGUI(plugin).getInventory());
            }

            if (e.getSlot() == 11) {
                //open Enchanted Feather recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedFeatherGUI(plugin).getInventory());
            }

            if (e.getSlot() == 12) {
                //open Enchanted Phantom Membrane recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedMembraneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 13) {
                //open Enchanted Gold recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedGoldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 14) {
                //open Enchanted Gold Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedGoldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 15) {
                //open Enchanted Sand recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSandGUI(plugin).getInventory());
            }

            if (e.getSlot() == 16) {
                //open Enchanted Compacted Sand recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedSandGUI(plugin).getInventory());
            }

            if (e.getSlot() == 17) {
                //open Enchanted Sandstone recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedSandGUI(plugin).getInventory());
            }

            if (e.getSlot() == 18) {
                //open Enchanted Copper recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCopperGUI(plugin).getInventory());
            }

            if (e.getSlot() == 19) {
                //open Enchanted Copper Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedCopperGUI(plugin).getInventory());
            }

            if (e.getSlot() == 20) {
                //open Enchanted Cut Copper Block recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedCopperGUI(plugin).getInventory());
            }

            if (e.getSlot() == 21) {
                //open Enchanted Quartz recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedQuartzGUI(plugin).getInventory());
            }

            if (e.getSlot() == 22) {
                //open Enchanted Quartz Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedQuartzGUI(plugin).getInventory());
            }

            if (e.getSlot() == 23) {
                //open Enchanted Quartz Sculpture recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedQuartzGUI(plugin).getInventory());
            }

            if (e.getSlot() == 24) {
                //open Enchanted Cobblestone recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCobbleGUI(plugin).getInventory());
            }

            if (e.getSlot() == 25) {
                //open Enchanted Diamond recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedDiamondGUI(plugin).getInventory());
            }

            if (e.getSlot() == 26) {
                //open Enchanted Emerald recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedEmeraldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 27) {
                //open Alloy recipe gui
                player.openInventory(FormatRecipesGUI.newAlloyGUI(plugin).getInventory());
            }

            if (e.getSlot() == 28) {
                //open Enchanted Chicken recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedChickenGUI(plugin).getInventory());
            }

            if (e.getSlot() == 29) {
                //open Enchanted Beef recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBeefGUI(plugin).getInventory());
            }

            if (e.getSlot() == 30) {
                //open Enchanted Pork recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedPorkGUI(plugin).getInventory());
            }

            if (e.getSlot() == 31) {
                //open Enchanted Rabbit recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedRabbitGUI(plugin).getInventory());
            }

            if (e.getSlot() == 32) {
                //open Enchanted Mutton recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedMuttonGUI(plugin).getInventory());
            }

            if (e.getSlot() == 33) {
                //open Enchanted Wool recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedWoolGUI(plugin).getInventory());
            }

            if (e.getSlot() == 34) {
                //open Enchanted Cod recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCodGUI(plugin).getInventory());
            }

            if (e.getSlot() == 35) {
                //open Enchanted Cooked Cod recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedCodGUI(plugin).getInventory());
            }
            if (e.getSlot() == 36) {
                //open Enchanted Salmon recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSalmonGUI(plugin).getInventory());
            }

            if (e.getSlot() == 37) {
                //open Enchanted Chicken recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedSalmonGUI(plugin).getInventory());
            }

            if (e.getSlot() == 38) {
                //open Enchanted Kelp recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedKelpGUI(plugin).getInventory());
            }

            if (e.getSlot() == 39) {
                //open Enchanted Dried Kelp recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedKelpGUI(plugin).getInventory());
            }

            if (e.getSlot() == 40) {
                //open Enchanted Kelp Block recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedKelpGUI(plugin).getInventory());
            }

            if (e.getSlot() == 41) {
                //open Enchanted Clownfish recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedClownGUI(plugin).getInventory());
            }

            if (e.getSlot() == 42) {
                //open Enchanted Pufferfish recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedPufferGUI(plugin).getInventory());
            }

            if (e.getSlot() == 43) {
                //open Enchanted Lapis recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedLapisGUI(plugin).getInventory());
            }

            if (e.getSlot() == 44) {
                //open Enchanted Lapis Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedLapisGUI(plugin).getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui1 = new RecipeSelectGUI(plugin);
                player.openInventory(gui1.getInventory());
            }

            if (e.getSlot() == 53) {
                //next page
                MaterialsSelectGUI2 gui1 = new MaterialsSelectGUI2(plugin);
                player.openInventory(gui1.getInventory());
            }
        }

        //materials recipes gui 2
        if (e.getClickedInventory().getHolder() instanceof MaterialsSelectGUI2) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }

            if (e.getSlot() == 0) {
                //open Enchanted Redstone recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedRedstoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 1) {
                //open Enchanted Redstone Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedRedstoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 2) {
                //open Enchanted Netherite Scrap recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedNetheriteGUI(plugin).getInventory());
            }

            if (e.getSlot() == 3) {
                //open Enchanted Netherite Ingot recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedNetheriteGUI(plugin).getInventory());
            }

            if (e.getSlot() == 4) {
                //open Enchanted Netherite Block recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedNetheriteGUI(plugin).getInventory());
            }

            if (e.getSlot() == 5) {
                //open Enchanted Bone recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 6) {
                //open Enchanted Bone Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedBoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 7) {
                //open Enchanted String recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedStringGUI(plugin).getInventory());
            }

            if (e.getSlot() == 8) {
                //open Enchanted Web recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedStringGUI(plugin).getInventory());
            }

            if (e.getSlot() == 9) {
                //open Enchanted String recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSpiderEyeGUI(plugin).getInventory());
            }

            if (e.getSlot() == 10) {
                //open Enchanted Amethyst recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedAmethystGUI(plugin).getInventory());
            }

            if (e.getSlot() == 11) {
                //open Enchanted Amethyst Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedAmethystGUI(plugin).getInventory());
            }

            if (e.getSlot() == 12) {
                //open Enchanted Ink Sac recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedInkGUI(plugin).getInventory());
            }

            if (e.getSlot() == 13) {
                //open Enchanted Ink Sac recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedInkGUI(plugin).getInventory());
            }

            if (e.getSlot() == 14) {
                //open Enchanted Cocoa Beans recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCocoaGUI(plugin).getInventory());
            }

            if (e.getSlot() == 15) {
                //open Enchanted Snowball recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSnowGUI(plugin).getInventory());
            }

            if (e.getSlot() == 16) {
                //open Enchanted Snow recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedSnowGUI(plugin).getInventory());
            }

            if (e.getSlot() == 17) {
                //open Snow Mound recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedSnowGUI(plugin).getInventory());
            }

            if (e.getSlot() == 18) {
                //open Enchanted Gunpowder recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedGunpowderGUI(plugin).getInventory());
            }

            if (e.getSlot() == 19) {
                //open Enchanted Powder Ball recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedGunpowderGUI(plugin).getInventory());
            }

            if (e.getSlot() == 20) {
                //open Enchanted Tnt recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedTntGUI(plugin).getInventory());
            }

            if (e.getSlot() == 21) {
                //open Enchanted Clay recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedClayGUI(plugin).getInventory());
            }

            if (e.getSlot() == 22) {
                //open Enchanted Clay Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedClayGUI(plugin).getInventory());
            }

            if (e.getSlot() == 23) {
                //open Enchanted Glowstone Dust recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedGlowstoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 24) {
                //open Enchanted Glowstone recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedGlowstoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 25) {
                //open Enchanted BlazePowder recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBlazeGUI(plugin).getInventory());
            }

            if (e.getSlot() == 26) {
                //open Enchanted Blaze Rod recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedBlazeGUI(plugin).getInventory());
            }

            if (e.getSlot() == 27) {
                //open Enchanted Ender Pearl recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedPearlGUI(plugin).getInventory());
            }

            if (e.getSlot() == 28) {
                //open Enchanted Eye of Ender recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedPearlGUI(plugin).getInventory());
            }

            if (e.getSlot() == 29) {
                //open Enchanted Wart recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedWartGUI(plugin).getInventory());
            }

            if (e.getSlot() == 30) {
                //open Enchanted Sweet Berries recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBerriesGUI(plugin).getInventory());
            }

            if (e.getSlot() == 31) {
                //open Enchanted Sugar Cane recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCaneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 32) {
                //open Enchanted Sugar recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedSugarGUI(plugin).getInventory());
            }

            if (e.getSlot() == 33) {
                //open Enchanted Chorus Fruit recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedFruitGUI(plugin).getInventory());
            }

            if (e.getSlot() == 34) {
                //open Enchanted Popped Chorus Fruit recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedFruitGUI(plugin).getInventory());
            }

            if (e.getSlot() == 35) {
                //open Enchanted Carrot recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCarrotGUI(plugin).getInventory());
            }

            if (e.getSlot() == 36) {
                //open Enchanted Golden Carrot Fruit recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedCarrotGUI(plugin).getInventory());
            }

            if (e.getSlot() == 37) {
                //open Enchanted Potato recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedPotatoGUI(plugin).getInventory());
            }

            if (e.getSlot() == 38) {
                //open Enchanted Baked Potato recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedPotatoGUI(plugin).getInventory());
            }

            if (e.getSlot() == 39) {
                //open Enchanted Beetroot recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBeetGUI(plugin).getInventory());
            }

            if (e.getSlot() == 40) {
                //open Enchanted Beetroot Soup recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedBeetGUI(plugin).getInventory());
            }

            if (e.getSlot() == 41) {
                //open Enchanted Melon Slice recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedMelonGUI(plugin).getInventory());
            }

            if (e.getSlot() == 42) {
                //open Enchanted Melon recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedMelonGUI(plugin).getInventory());
            }

            if (e.getSlot() == 43) {
                //open Enchanted Red Mushroom recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedRedMushroomGUI(plugin).getInventory());
            }

            if (e.getSlot() == 44) {
                //open Enchanted Melon Slice recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBrownMushroomGUI(plugin).getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui1 = new RecipeSelectGUI(plugin);
                player.openInventory(gui1.getInventory());
            }


            if (e.getSlot() == 45) {
                //previous page
                MaterialsSelectGUI gui1 = new MaterialsSelectGUI(plugin);
                player.openInventory(gui1.getInventory());
            }

            if (e.getSlot() == 53) {
                //next page
                MaterialsSelectGUI3 gui1 = new MaterialsSelectGUI3(plugin);
                player.openInventory(gui1.getInventory());
            }
        }

        //materials recipes gui 3
        if (e.getClickedInventory().getHolder() instanceof MaterialsSelectGUI3) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }

            if (e.getSlot() == 0) {
                //open Enchanted Flint recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedFlintGUI(plugin).getInventory());
            }

            if (e.getSlot() == 1) {
                //open Enchanted Pumpkin recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedPumpkinGUI(plugin).getInventory());
            }

            if (e.getSlot() == 2) {
                //open Enchanted Cactus recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCactusGUI(plugin).getInventory());
            }

            if (e.getSlot() == 3) {
                //open Enchanted Soul Sand recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSoulSandGUI(plugin).getInventory());
            }

            if (e.getSlot() == 4) {
                //open Enchanted Soul Soil recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSoulSoilGUI(plugin).getInventory());
            }

            if (e.getSlot() == 5) {
                //open Enchanted Oak Wood recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedOakGUI(plugin).getInventory());
            }

            if (e.getSlot() == 6) {
                //open Enchanted Dark Oak Wood recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedDarkOakGUI(plugin).getInventory());
            }

            if (e.getSlot() == 7) {
                //open Enchanted Birch Wood recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBirchGUI(plugin).getInventory());
            }

            if (e.getSlot() == 8) {
                //open Enchanted Spruce Wood recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSpruceGUI(plugin).getInventory());
            }

            if (e.getSlot() == 9) {
                //open Enchanted Acacia Wood recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedAcaciaGUI(plugin).getInventory());
            }

            if (e.getSlot() == 10) {
                //open Enchanted Jungle Wood recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedJungleGUI(plugin).getInventory());
            }

            if (e.getSlot() == 11) {
                //open Enchanted Warped Stem recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedWarpedGUI(plugin).getInventory());
            }

            if (e.getSlot() == 12) {
                //open Enchanted Crimson Stem recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCrimsonGUI(plugin).getInventory());
            }

            if (e.getSlot() == 13) {
                //open Enchanted Endstone recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedEndStoneGUI(plugin).getInventory());
            }

            if (e.getSlot() == 14) {
                //open Enchanted Rotten Flesh recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedFleshGUI(plugin).getInventory());
            }

            if (e.getSlot() == 15) {
                //open Simple Shield Base recipe gui
                player.openInventory(FormatRecipesGUI.newSimpleShieldGUI(plugin).getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui1 = new RecipeSelectGUI(plugin);
                player.openInventory(gui1.getInventory());
            }

            if (e.getSlot() == 45) {
                //previous page
                MaterialsSelectGUI2 gui2 = new MaterialsSelectGUI2(plugin);
                player.openInventory(gui2.getInventory());
            }
        }
    }
}
