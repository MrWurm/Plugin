package its.wurm.testplugin.Events;

import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class VillagerEvents implements Listener {
    Plugin plugin;

    public VillagerEvents(Plugin plugin) {
        this.plugin = plugin;
    }

    public boolean customTrade(ItemStack output, ItemStack first, int exp, Villager villager, int uses, VillagerAcquireTradeEvent event) {
        MerchantRecipe recipe = new MerchantRecipe(output, 0, uses, true, exp, 0.0f);
        recipe.addIngredient(first);

        if (villager.getRecipeCount() > 0 &&
            villager.getRecipes().get(villager.getRecipeCount() - 1).getIngredients().get(0).isSimilar(first) &&
            villager.getRecipes().get(villager.getRecipeCount() - 1).getResult().isSimilar(output)) {
            return true;
        }
        event.setRecipe(recipe);
        return false;
    }

    public boolean customTrade(ItemStack output, ItemStack first, ItemStack second, int exp, Villager villager, int uses, VillagerAcquireTradeEvent event) {
        MerchantRecipe recipe = new MerchantRecipe(output, 0, uses, true, exp, 0.0f);
        recipe.addIngredient(first);
        recipe.addIngredient(second);

        if (villager.getRecipeCount() > 0 &&
            villager.getRecipes().get(villager.getRecipeCount() - 1).getIngredients().get(0).isSimilar(first) &&
            villager.getRecipes().get(villager.getRecipeCount() - 1).getIngredients().get(1).isSimilar(second) &&
            villager.getRecipes().get(villager.getRecipeCount() - 1).getResult().isSimilar(output)) {
            return true;
        }
        event.setRecipe(recipe);
        return false;
    }

    @EventHandler
    public void trade(VillagerAcquireTradeEvent event) {
        if (!(event.getEntity() instanceof Villager)) {
            return;
        }

        Villager villager = (Villager) event.getEntity();
        ItemStack emerald = new ItemStack(Material.EMERALD, 1);
        ItemStack item1;
        ItemStack item2;
        Random random = new Random();
        boolean reroll = true;

        switch (villager.getProfession()) {
            case MASON:
                switch (villager.getVillagerLevel()) {
                    case 1:
                        while (reroll) {
                            switch (random.nextInt(3) + 1) {
                                case 1:
                                    item1 = Items.ENCHANTED_CLAY.getItem(plugin);
                                    item1.setAmount(random.nextInt(3) + 5);
                                    reroll = customTrade(emerald, item1, 2, villager, 32, event);
                                    break;
                                case 2:
                                    emerald.setAmount(random.nextInt(3) + 3);
                                    reroll = customTrade(Items.ENCHANTED_CLAY.getItem(plugin), emerald, 1, villager, 32, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                                case 3:
                                    item1 = Items.ENCHANTED_COPPER.getItem(plugin);
                                    item1.setAmount(random.nextInt(2) + 3);
                                    reroll = customTrade(emerald, item1, 2, villager, 32, event);
                                    break;
                            }
                        }
                        break;
                    case 2:
                        while (reroll) {
                            switch (random.nextInt(4) + 1) {
                                case 1:
                                    item1 = Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin);
                                    item1.setAmount(random.nextInt(5) + 8);
                                    reroll = customTrade(emerald, item1, 3, villager, 32, event);
                                    break;
                                case 2:
                                    emerald.setAmount(random.nextInt(6) + 17);
                                    reroll = customTrade(Items.OLD_VASE.getItem(plugin), emerald, 10, villager, 8, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                                case 3:
                                    emerald.setAmount(random.nextInt(12) + 20);
                                    reroll = customTrade(Items.TERRACOTTA_LEGGINGS.getItem(plugin), Items.ENCHANTED_CLAY_BLOCK.getItem(plugin), emerald, 14, villager, 12, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                                case 4:
                                    emerald.setAmount(random.nextInt(7) + 18);
                                    reroll = customTrade(Items.TERRACOTTA_BOOTS.getItem(plugin), Items.ENCHANTED_CLAY_BLOCK.getItem(plugin), emerald, 14, villager, 12, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;

                            }
                        }
                        break;

                    case 3:
                        while (reroll) {
                            switch (random.nextInt(3) + 1) {
                                case 1:
                                    reroll = customTrade(emerald, Items.ENCHANTED_QUARTZ_BLOCK.getItem(plugin), 5, villager, 32, event);
                                    break;
                                case 2:
                                    emerald.setAmount(random.nextInt(16) + 27);
                                    reroll = customTrade(Items.TERRACOTTA_CHESTPLATE.getItem(plugin), Items.ENCHANTED_CLAY_BLOCK.getItem(plugin), emerald, 25, villager, 12, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                                case 3:
                                    emerald.setAmount(random.nextInt(14) + 25);
                                    reroll = customTrade(Items.TERRACOTTA_HELMET.getItem(plugin), Items.ENCHANTED_CLAY_BLOCK.getItem(plugin), emerald, 8, villager, 16, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;

                            }
                        }
                        break;

                    case 4:
                        while (reroll) {
                            switch (random.nextInt(3) + 1) {
                                case 1:
                                    item1 = Items.RIVER_CLAY.getItem(plugin);
                                    item1.setAmount(random.nextInt(4) + 5);
                                    reroll = customTrade(emerald, Items.RIVER_CLAY.getItem(plugin), 9, villager, 32, event);
                                    break;
                                case 2:
                                    emerald.setAmount(random.nextInt(5) + 9);
                                    reroll = customTrade(Items.ENCHANTED_DEEPSLATE_TILES.getItem(plugin), Items.ENCHANTED_POLISHED_DEEPSLATE.getItem(plugin), emerald, 20, villager, 16, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                                case 3:
                                    emerald.setAmount(random.nextInt(3) + 5);
                                    reroll = customTrade(Items.BARREL_OF_ROCKS.getItem(plugin), emerald, 7, villager, 32, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                            }
                        }
                        break;
                    case 5:
                        while (reroll) {
                            switch (random.nextInt(3) + 1) {
                                case 1:
                                    emerald.setAmount(random.nextInt(13) + 27);
                                    reroll = customTrade(Items.ENCHANTED_QUARTZ_SCULPTURE.getItem(plugin), emerald, 0, villager, 32, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                                case 2:
                                    emerald.setAmount(random.nextInt(21) + 30);
                                    reroll = customTrade(Items.TERRACOTTA_CUDGEL.getItem(plugin), Items.ENCHANTED_CLAY_BLOCK.getItem(plugin), emerald, 0, villager, 12, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                                case 3:
                                    emerald.setAmount(random.nextInt(20) + 32);
                                    reroll = customTrade(Items.LUCKY_POTTERY_SHARD.getItem(plugin), Items.RIVER_CLAY.getItem(plugin), emerald, 0, villager, 12, event);
                                    emerald.setAmount(random.nextInt(1));
                                    break;
                            }
                        }
                        break;
                }
                break;
            case CLERIC:
                switch (villager.getVillagerLevel()) {}
                break;
            case FARMER:
                switch (villager.getVillagerLevel()) {}
                break;
            case LIBRARIAN:
                switch (villager.getVillagerLevel()) {}
                break;
            case CARTOGRAPHER:
                switch (villager.getVillagerLevel()) {}
                break;
            case BUTCHER:
                    switch (villager.getVillagerLevel()) {
                        case 1:
                            while (reroll) {
                                switch (random.nextInt(3) + 1) {
                                    case 1:
                                        item1 = Items.ENCHANTED_CHICKEN.getItem(plugin);
                                        item1.setAmount(random.nextInt(4) + 5);
                                        reroll = customTrade(emerald, item1, 2, villager, 32, event);
                                        break;
                                    case 2:
                                        item1 = Items.ENCHANTED_PORK.getItem(plugin);
                                        item1.setAmount(random.nextInt(3) + 3);
                                        reroll = customTrade(emerald, item1, 2, villager, 32, event);
                                        break;
                                    case 3:
                                        item1 = Items.ENCHANTED_RABBIT.getItem(plugin);
                                        item1.setAmount(random.nextInt(4) + 5);
                                        reroll = customTrade(emerald, item1, 2, villager, 32, event);
                                        break;
                                    case 4:
                                        emerald.setAmount(random.nextInt(9) + 12);
                                        reroll = customTrade(Items.MEAT_CLEAVER.getItem(plugin), emerald, 9, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                }
                            }
                            break;
                        case 2:
                            while (reroll) {
                                switch (random.nextInt(4) + 1) {
                                    case 1:
                                        item1 = Items.ENCHANTED_COAL.getItem(plugin);
                                        item1.setAmount(random.nextInt(3) + 4);
                                        reroll = customTrade(emerald, item1, 5, villager, 32, event);
                                        break;
                                    case 2:
                                        emerald.setAmount(random.nextInt(3) + 4);
                                        reroll = customTrade(Items.ENCHANTED_CHICKEN.getItem(plugin), emerald, 5, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                    case 3:
                                        emerald.setAmount(random.nextInt(4) + 5);
                                        reroll = customTrade(Items.ENCHANTED_RABBIT.getItem(plugin), emerald, 5, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                    case 4:
                                        emerald.setAmount(random.nextInt(4) + 5);
                                        reroll = customTrade(Items.ENCHANTED_PORK.getItem(plugin), emerald, 5, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                }
                            }
                            break;
                        case 3:
                            while (reroll) {
                                switch (random.nextInt(4) + 1) {
                                    case 1:
                                        item1 = Items.ENCHANTED_BEEF.getItem(plugin);
                                        item1.setAmount(random.nextInt(3) + 4);
                                        reroll = customTrade(emerald, item1, 9, villager, 32, event);
                                        break;
                                    case 2:
                                        item1 = Items.ENCHANTED_MUTTON.getItem(plugin);
                                        item1.setAmount(random.nextInt(3) + 4);
                                        reroll = customTrade(emerald, item1, 9, villager, 32, event);
                                        break;
                                    case 3:
                                        item1 = Items.MONSTER_MEAT.getItem(plugin);
                                        item1.setAmount(random.nextInt(7) + 8);
                                        reroll = customTrade(emerald, item1, 9, villager, 32, event);
                                        break;
                                    case 4:
                                        emerald.setAmount(random.nextInt(5) + 7);
                                        reroll = customTrade(Items.ENCHANTED_PORK.getItem(plugin), emerald, 5, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                }
                            }
                            break;
                        case 4:
                            while (reroll) {
                                switch (random.nextInt(3) + 1) {
                                    case 1:
                                        emerald.setAmount(random.nextInt(5) + 7);
                                        reroll = customTrade(Items.ENCHANTED_MUTTON.getItem(plugin), emerald, 15, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                    case 2:
                                        emerald.setAmount(random.nextInt(5) + 7);
                                        reroll = customTrade(Items.ENCHANTED_BEEF.getItem(plugin), emerald, 15, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                    case 3:
                                        item1 = Items.JERKY.getItem(plugin);
                                        item1.setAmount(random.nextInt(2) + 2);
                                        reroll = customTrade(item1, emerald, 12, villager, 32, event);
                                        break;
                                }
                            }
                            break;
                        case 5:
                            while (reroll) {
                                switch (random.nextInt(2) + 1) {
                                    case 1:
                                        item1 = Items.ENCHANTED_SWEET_BERRIES.getItem(plugin);
                                        item1.setAmount(random.nextInt(2) + 3);
                                        reroll = customTrade(emerald, item1, 0, villager, 32, event);
                                        break;
                                    case 2:
                                        emerald.setAmount(random.nextInt(2) + 2);
                                        reroll = customTrade(emerald, Items.ENCHANTED_KELP_BLOCK.getItem(plugin), 0, villager, 32, event);
                                        emerald.setAmount(random.nextInt(1));
                                        break;
                                }
                            }
                            break;
                        }
                        break;

            case FISHERMAN:
                switch (villager.getVillagerLevel()) {}
                break;
            case ARMORER:
                switch (villager.getVillagerLevel()) {}
                break;
            case WEAPONSMITH:
                switch (villager.getVillagerLevel()) {}
                break;
            case TOOLSMITH:
                switch (villager.getVillagerLevel()) {}
                break;
            case FLETCHER:
                switch (villager.getVillagerLevel()) {}
                break;
            case LEATHERWORKER:
                switch (villager.getVillagerLevel()) {}
                break;

        }
    }
}
