package its.wurm.testplugin.Events;
import its.wurm.testplugin.Inventories.FormatRecipesGUI;
import its.wurm.testplugin.Inventories.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof RecipeSelectGUI) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                //open weapon gui
                WeaponsSelectGUI gui = new WeaponsSelectGUI();
                player.openInventory(gui.getInventory());
            }
            if (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) {
                //open armor gui
                ArmorSelectGUI gui = new ArmorSelectGUI();
                player.openInventory(gui.getInventory());
            }
            if (e.getCurrentItem().getType() == Material.POWDER_SNOW_BUCKET) {
                //open misc gui
                MiscSelectGUI gui = new MiscSelectGUI();
                player.openInventory(gui.getInventory());
            }
            if (e.getCurrentItem().getType() == Material.COAL) {
                //open materials gui
                MaterialsSelectGUI gui = new MaterialsSelectGUI();
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
                player.openInventory(FormatRecipesGUI.newStoneSaberGUI().getInventory());
            }

            if (e.getSlot() == 1) {
                //open Iron Saber recipe gui
                player.openInventory(FormatRecipesGUI.newIronSaberGUI().getInventory());
            }

            if (e.getSlot() == 2) {
                //open Golden Saber recipe gui
                player.openInventory(FormatRecipesGUI.newGoldSaberGUI().getInventory());
            }

            if (e.getSlot() == 3) {
                //open Diamond Saber recipe gui
                player.openInventory(FormatRecipesGUI.newDiamondSaberGUI().getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui0 = new RecipeSelectGUI();
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
                player.openInventory(FormatRecipesGUI.newDripRecipeGUI().getInventory());
            }

            if (e.getSlot() == 1) {
                //open Supreme Drip recipe gui
                player.openInventory(FormatRecipesGUI.newSupremeDripRecipeGUI().getInventory());
            }

            if (e.getSlot() == 2) {
                //open Spectral Wings recipe gui
                player.openInventory(FormatRecipesGUI.newSpectralWingsGUI().getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui0 = new RecipeSelectGUI();
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
                player.openInventory(FormatRecipesGUI.newfCharmGUI().getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui0 = new RecipeSelectGUI();
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
                player.openInventory(FormatRecipesGUI.newEnchantedDripstoneGUI().getInventory());
            }

            if (e.getSlot() == 1) {
                //open Enchanted Dripstone Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedDripstoneRecipeGUI().getInventory());
            }

            if (e.getSlot() == 2) {
                //open Enchanted Coal recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCoalGUI().getInventory());
            }

            if (e.getSlot() == 3) {
                //open Enchanted Coal Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedCoalGUI().getInventory());
            }

            if (e.getSlot() == 4) {
                //open Enchanted Deepslate recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedDeepslateGUI().getInventory());
            }

            if (e.getSlot() == 5) {
                //open Enchanted Polished Deepslate recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedDeepslateGUI().getInventory());
            }

            if (e.getSlot() == 6) {
                //open Enchanted Deepslate Tiles recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedDeepslateGUI().getInventory());
            }

            if (e.getSlot() == 7) {
                //open Enchanted Bamboo recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBambooGUI().getInventory());
            }

            if (e.getSlot() == 8) {
                //open Bamboo Bundle recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedBambooGUI().getInventory());
            }

            if (e.getSlot() == 9) {
                //open Enchanted Iron recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedIronGUI().getInventory());
            }

            if (e.getSlot() == 10) {
                //open Enchanted Iron Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedIronGUI().getInventory());
            }

            if (e.getSlot() == 11) {
                //open Enchanted Feather recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedFeatherGUI().getInventory());
            }

            if (e.getSlot() == 12) {
                //open Enchanted Phantom Membrane recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedMembraneGUI().getInventory());
            }

            if (e.getSlot() == 13) {
                //open Enchanted Gold recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedGoldGUI().getInventory());
            }

            if (e.getSlot() == 14) {
                //open Enchanted Gold Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedGoldGUI().getInventory());
            }

            if (e.getSlot() == 15) {
                //open Enchanted Sand recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSandGUI().getInventory());
            }

            if (e.getSlot() == 16) {
                //open Enchanted Compacted Sand recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedSandGUI().getInventory());
            }

            if (e.getSlot() == 17) {
                //open Enchanted Sandstone recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedSandGUI().getInventory());
            }

            if (e.getSlot() == 18) {
                //open Enchanted Copper recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCopperGUI().getInventory());
            }

            if (e.getSlot() == 19) {
                //open Enchanted Copper Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedCopperGUI().getInventory());
            }

            if (e.getSlot() == 20) {
                //open Enchanted Cut Copper Block recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedCopperGUI().getInventory());
            }

            if (e.getSlot() == 21) {
                //open Enchanted Quartz recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedQuartzGUI().getInventory());
            }

            if (e.getSlot() == 22) {
                //open Enchanted Quartz Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedQuartzGUI().getInventory());
            }

            if (e.getSlot() == 23) {
                //open Enchanted Quartz Sculpture recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedQuartzGUI().getInventory());
            }

            if (e.getSlot() == 24) {
                //open Enchanted Cobblestone recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCobbleGUI().getInventory());
            }

            if (e.getSlot() == 25) {
                //open Enchanted Diamond recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedDiamondGUI().getInventory());
            }

            if (e.getSlot() == 26) {
                //open Enchanted Emerald recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedEmeraldGUI().getInventory());
            }

            if (e.getSlot() == 27) {
                //open Alloy recipe gui
                player.openInventory(FormatRecipesGUI.newAlloyGUI().getInventory());
            }

            if (e.getSlot() == 28) {
                //open Enchanted Chicken recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedChickenGUI().getInventory());
            }

            if (e.getSlot() == 29) {
                //open Enchanted Beef recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedBeefGUI().getInventory());
            }

            if (e.getSlot() == 30) {
                //open Enchanted Pork recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedPorkGUI().getInventory());
            }

            if (e.getSlot() == 31) {
                //open Enchanted Rabbit recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedRabbitGUI().getInventory());
            }

            if (e.getSlot() == 32) {
                //open Enchanted Mutton recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedMuttonGUI().getInventory());
            }

            if (e.getSlot() == 33) {
                //open Enchanted Wool recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedWoolGUI().getInventory());
            }

            if (e.getSlot() == 34) {
                //open Enchanted Cod recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedCodGUI().getInventory());
            }

            if (e.getSlot() == 35) {
                //open Enchanted Cooked Cod recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedCodGUI().getInventory());
            }
            if (e.getSlot() == 36) {
                //open Enchanted Salmon recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedSalmonGUI().getInventory());
            }

            if (e.getSlot() == 37) {
                //open Enchanted Chicken recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedSalmonGUI().getInventory());
            }

            if (e.getSlot() == 38) {
                //open Enchanted Kelp recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedKelpGUI().getInventory());
            }

            if (e.getSlot() == 39) {
                //open Enchanted Dried Kelp recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedKelpGUI().getInventory());
            }

            if (e.getSlot() == 40) {
                //open Enchanted Kelp Block recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedKelpGUI().getInventory());
            }

            if (e.getSlot() == 41) {
                //open Enchanted Clownfish recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedClownGUI().getInventory());
            }

            if (e.getSlot() == 42) {
                //open Enchanted Pufferfish recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedPufferGUI().getInventory());
            }

            if (e.getSlot() == 43) {
                //open Enchanted Lapis recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedLapisGUI().getInventory());
            }

            if (e.getSlot() == 44) {
                //open Enchanted Lapis Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedLapisGUI().getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui1 = new RecipeSelectGUI();
                player.openInventory(gui1.getInventory());
            }

            if (e.getSlot() == 53) {
                //next page
                MaterialsSelectGUI2 gui1 = new MaterialsSelectGUI2();
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
                player.openInventory(FormatRecipesGUI.newEnchantedRedstoneGUI().getInventory());
            }

            if (e.getSlot() == 1) {
                //open Enchanted Redstone Block recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedRedstoneGUI().getInventory());
            }

            if (e.getSlot() == 2) {
                //open Enchanted Netherite Scrap recipe gui
                player.openInventory(FormatRecipesGUI.newEnchantedNetheriteGUI().getInventory());
            }

            if (e.getSlot() == 3) {
                //open Enchanted Netherite Ingot recipe gui
                player.openInventory(FormatRecipesGUI.newsEnchantedNetheriteGUI().getInventory());
            }

            if (e.getSlot() == 4) {
                //open Enchanted Netherite Block recipe gui
                player.openInventory(FormatRecipesGUI.newvsEnchantedNetheriteGUI().getInventory());
            }

            if (e.getSlot() == 49) {
                //go back
                RecipeSelectGUI gui1 = new RecipeSelectGUI();
                player.openInventory(gui1.getInventory());
            }

            if (e.getSlot() == 45) {
                //previous page
                MaterialsSelectGUI gui1 = new MaterialsSelectGUI();
                player.openInventory(gui1.getInventory());
            }
        }
    }
}
