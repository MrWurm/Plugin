package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.Items;
import its.wurm.testplugin.persistentDataContainers.stringList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatEnchantmentGUI implements InventoryHolder {

    private Inventory main;
    private Inventory backArrow;
    private List<List<ItemStack>> returnMaterials;
    private List<List<Integer>> returnSize;
    private String returnName;
    private String returnType;
    private List<Object> elements;

    public FormatEnchantmentGUI(
            //Define the plugin
            Plugin plugin,
            // The GUI clicking the back arrow will return
            InventoryHolder back,
            // The player opening this menu
            Player player,
            // The maximum level the enchantment can be
            int max,
            // The value that will be effected by enchantment level
            double value,
            // The name of the enchantment
            String name,
            // The lore that the enchantment will have
            List<String> description,
            // Which enchantments conflict with this one
            List<String> conflicts,
            // The components that each tier of enchantment requires to unlock the enchantment
            List<List<ItemStack>> materials,
            // The components that each tier of enchantment requires to unlock the enchantment
            List<List<Integer>> stackSize,
            // What item type(s) can this enchantment be applied to
            String applicable
    ) {
        // Define a main and create a gui
        main = Bukkit.createInventory(this, 54, name);
        String[] enchantments = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentsAvailable"), new stringList());
        int[] power = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentsLevel"), PersistentDataType.INTEGER_ARRAY);

        for (int i = 0; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }
        ItemStack item;
        ItemMeta meta;
        int xp = 0;
        ArrayList<String> lore = new ArrayList<>();
        for (int i = 1; i < max + 1; i++) {
            boolean filled = false;
            switch (i) {
                case 1:
                    xp = 3;
                    break;
                case 2:
                    xp = 8;
                    break;
                case 3:
                    xp = 15;
                    break;
                case 4:
                    xp = 24;
                    break;
                case 5:
                    xp = 30;
                    break;
            }
            item = new ItemStack(Material.ENCHANTED_BOOK);
            meta = item.getItemMeta();
            lore = new ArrayList<>();
            meta.setDisplayName(ChatColor.BLUE + name + " " + i);
            lore.add(ChatColor.DARK_GRAY + "Applicable to: " + applicable);
            lore.add(" ");
            for (int j = 0; j < description.size(); j++) {
                if (description.get(j).contains("[value]")) {
                    lore.add(description.get(j).replace("[value]", value * i + ""));
                } else {
                    lore.add(description.get(j));
                }
            }
            lore.add(" ");
            if (!conflicts.isEmpty()) {
                lore.add(ChatColor.GRAY + "Conflicts with:");
                for (int j = 0; j < conflicts.size(); j++) {
                    lore.add(ChatColor.BLUE + " · " + description.get(j));
                }
                lore.add(" ");
            }
            int index = Arrays.asList(enchantments).indexOf(name);
            int indexValue = 0;
            if (index != -1) {
                indexValue = power[index];
            }
            if (indexValue == i - 1 && !filled) {
                lore.add(ChatColor.RED + "You do not have this enchantment");
                lore.add(ChatColor.RED + "unlocked! Provide these resources");
                lore.add(ChatColor.RED + "to unlock it.");
                for (int j = 0; j < materials.get(i - 1).size(); j++) {
                    ChatColor color = ChatColor.GRAY;
                    switch (materials.get(i - 1).get(j).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                            PersistentDataType.STRING)) {
                        case "COMMON":
                            color = ChatColor.WHITE;
                            break;
                        case "UNCOMMON":
                            color = ChatColor.GREEN;
                            break;
                        case "RARE":
                            color = ChatColor.BLUE;
                            break;
                        case "EPIC":
                            color = ChatColor.DARK_PURPLE;
                            break;
                        case "LEGENDARY":
                            color = ChatColor.GOLD;
                            break;
                        case "MYTHIC":
                            color = ChatColor.LIGHT_PURPLE;
                            break;
                    }
                    lore.add(ChatColor.DARK_GRAY + " · " + color + materials.get(i - 1).get(j).getItemMeta().getDisplayName() + ChatColor.GRAY + " x" + stackSize.get(i - 1).get(j));
                }
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to unlock!");
                filled = true;
            }
            if (indexValue + 1 < i && !filled) {
                lore.add(ChatColor.RED + "You do not have the previous tier");
                lore.add(ChatColor.RED + "of this enchantment unlocked!");
                lore.add(ChatColor.RED + "Unlock it to see the");
                lore.add(ChatColor.RED + "requirements for this tier.");
                filled = true;
            }
            if (indexValue >= i && !filled) {
                lore.add(ChatColor.YELLOW + "Click to apply to the selected");
                lore.add(ChatColor.YELLOW + "item. " + ChatColor.DARK_GRAY + "(This will override");
                lore.add(ChatColor.DARK_GRAY + "conflicting enchantments present");
                lore.add(ChatColor.DARK_GRAY + "on the item)");
                lore.add(" ");
                lore.add(ChatColor.GRAY + "Cost: " + ChatColor.DARK_AQUA + xp + " XP levels");
                filled = true;
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            main.setItem(10 + i, item);
        }
        main.setItem(31, new ItemStack(Material.AIR));
        main.setItem(49, Items.BACK_ARROW.getItem(plugin));

        backArrow = back.getInventory();
        returnMaterials = materials;
        returnSize = stackSize;
        returnName = name;
        returnType = applicable;
        elements = new ArrayList<>();
        elements.add(plugin);
        elements.add(back);
        elements.add(player);
        elements.add(max);
        elements.add(value);
        elements.add(name);
        elements.add(description);
        elements.add(conflicts);
        elements.add(materials);
        elements.add(stackSize);
        elements.add(applicable);
    }

    @Override
    public Inventory getInventory() {
        return main;
    }

    public Inventory getBackArrow() {
        return backArrow;
    }

    public List<List<ItemStack>> getMaterials() {
        return returnMaterials;
    }

    public List<List<Integer>> getStackSize() {
        return returnSize;
    }

    public String getEnchantment() {return returnName;}

    public String getReturnType() {return returnType;}

    public void reloadInventory() {
        Plugin plugin = (Plugin) elements.get(0);
        Player player = (Player) elements.get(2);
        int max = (int) elements.get(3);
        double value = (double) elements.get(4);
        String name = (String) elements.get(5);
        List<String> description = (List<String>) elements.get(6);
        List<String> conflicts = (List<String>) elements.get(7);
        List<List<ItemStack>> materials = (List<List<ItemStack>>) elements.get(8);
        List<List<Integer>> stackSize = (List<List<Integer>>) elements.get(9);
        String applicable = (String) elements.get(10);
        String[] enchantments = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentsAvailable"), new stringList());
        int[] power = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "enchantmentsLevel"), PersistentDataType.INTEGER_ARRAY);
        ItemStack item;
        ItemMeta meta;
        int xp = 0;
        ArrayList<String> lore = new ArrayList<>();
        for (int i = 1; i < max + 1; i++) {
            boolean filled = false;
            switch (i) {
                case 1:
                    xp = 3;
                    break;
                case 2:
                    xp = 8;
                    break;
                case 3:
                    xp = 15;
                    break;
                case 4:
                    xp = 24;
                    break;
                case 5:
                    xp = 30;
                    break;
            }
            item = new ItemStack(Material.ENCHANTED_BOOK);
            meta = item.getItemMeta();
            lore = new ArrayList<>();
            meta.setDisplayName(ChatColor.BLUE + name + " " + i);
            lore.add(ChatColor.DARK_GRAY + "Applicable to: " + applicable);
            lore.add(" ");
            for (int j = 0; j < description.size(); j++) {
                if (description.get(j).contains("[value]")) {
                    lore.add(description.get(j).replace("[value]", value * i + ""));
                } else {
                    lore.add(description.get(j));
                }
            }
            lore.add(" ");
            if (!conflicts.isEmpty()) {
                lore.add(ChatColor.GRAY + "Conflicts with:");
                for (int j = 0; j < conflicts.size(); j++) {
                    lore.add(ChatColor.BLUE + " · " + conflicts.get(j));
                }
                lore.add(" ");
            }
            int index = Arrays.asList(enchantments).indexOf(name);
            int indexValue = 0;
            if (index != -1) {
                indexValue = power[index];
            }
            if (indexValue == i - 1 && !filled) {
                lore.add(ChatColor.RED + "You do not have this enchantment");
                lore.add(ChatColor.RED + "unlocked! Provide these resources");
                lore.add(ChatColor.RED + "to unlock it.");
                for (int j = 0; j < materials.get(i - 1).size(); j++) {
                    ChatColor color = ChatColor.GRAY;
                    switch (materials.get(i - 1).get(j).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"),
                            PersistentDataType.STRING)) {
                        case "COMMON":
                            color = ChatColor.WHITE;
                            break;
                        case "UNCOMMON":
                            color = ChatColor.GREEN;
                            break;
                        case "RARE":
                            color = ChatColor.BLUE;
                            break;
                        case "EPIC":
                            color = ChatColor.DARK_PURPLE;
                            break;
                        case "LEGENDARY":
                            color = ChatColor.GOLD;
                            break;
                        case "MYTHIC":
                            color = ChatColor.LIGHT_PURPLE;
                            break;
                    }
                    lore.add(ChatColor.DARK_GRAY + " · " + color + materials.get(i - 1).get(j).getItemMeta().getDisplayName() + ChatColor.GRAY + " x" + stackSize.get(i - 1).get(j));
                }
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to unlock!");
                filled = true;
            }
            if (indexValue + 1 < i && !filled) {
                lore.add(ChatColor.RED + "You do not have the previous tier");
                lore.add(ChatColor.RED + "of this enchantment unlocked!");
                lore.add(ChatColor.RED + "Unlock it to see the");
                lore.add(ChatColor.RED + "requirements for this tier.");
                filled = true;
            }
            if (indexValue >= i && !filled) {
                lore.add(ChatColor.YELLOW + "Click to apply to the selected");
                lore.add(ChatColor.YELLOW + "item. " + ChatColor.DARK_GRAY + "(This will override");
                lore.add(ChatColor.DARK_GRAY + "conflicting enchantments present");
                lore.add(ChatColor.DARK_GRAY + "on the item)");
                lore.add(" ");
                lore.add(ChatColor.GRAY + "Cost: " + ChatColor.DARK_AQUA + xp + " XP levels");
                filled = true;
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            main.setItem(10 + i, item);
        }
    }

    // Efficiency Enchantment GUI
    public static FormatEnchantmentGUI newEfficiencyGUI(Plugin plugin, Player player, InventoryHolder back) {
        List<List<ItemStack>> listMat = new ArrayList<>();
        List<List<Integer>> listInt = new ArrayList<>();
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_REDSTONE.getItem(plugin),
                Items.ENCHANTED_PAPER.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                16,
                3)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin),
                Items.ENCHANTED_PAPER.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                4,
                8)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_REDSTONE_BLOCK.getItem(plugin),
                Items.NECRONOMICON_PAGE.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                10,
                2)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.MINERAL_CLUSTER.getItem(plugin),
                Items.POLISHED_SLATED_HANDLE.getItem(plugin),
                Items.NECRONOMICON_PAGE.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                3,
                3,
                5)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.MINERAL_CLUSTER.getItem(plugin),
                Items.STONK.getItem(plugin),
                Items.BOUND_BOOK.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                5,
                1,
                1)));
        return new FormatEnchantmentGUI(plugin, back, player, 5, 1, "Efficiency",
        new ArrayList<>(Arrays.asList(ChatColor.GRAY + "Increase block breaking speed", ChatColor.GRAY + "by " + ChatColor.GREEN + "1 + [value]²")), new ArrayList<>(),
        listMat, listInt, "Tools");
    }

    // Smelt Enchantment GUI
    public static FormatEnchantmentGUI newSmeltGUI(Plugin plugin, Player player, InventoryHolder back) {
        List<List<ItemStack>> listMat = new ArrayList<>();
        List<List<Integer>> listInt = new ArrayList<>();
        List<String> conflicts = new ArrayList<>();
        conflicts.add("Silk Touch");
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.COMPACTED_COAL_LUMP.getItem(plugin),
                Items.ENCHANTED_MAGMA_BLOCK.getItem(plugin),
                Items.NECRONOMICON_PAGE.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                1,
                3,
                2)));
        return new FormatEnchantmentGUI(plugin, back, player, 1, 1, "Smelt",
                new ArrayList<>(Arrays.asList(ChatColor.GRAY + "Smelt blocks that you", ChatColor.GRAY + "break")), conflicts,
                listMat, listInt, "Tools");
    }

    // Cubism Enchantment GUI
    public static FormatEnchantmentGUI newCubismGUI(Plugin plugin, Player player, InventoryHolder back) {
        List<List<ItemStack>> listMat = new ArrayList<>();
        List<List<Integer>> listInt = new ArrayList<>();
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_PUMPKIN.getItem(plugin),
                Items.ENCHANTED_PAPER.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                9,
                3)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_PUMPKIN.getItem(plugin),
                Items.ENCHANTED_PAPER.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                36,
                9)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_PUMPKIN.getItem(plugin),
                Items.BAMBOO_BUNDLE.getItem(plugin),
                Items.NECRONOMICON_PAGE.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                128,
                5,
                2)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_SHULKER_SHELL.getItem(plugin),
                Items.NECRONOMICON_PAGE.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                6,
                4)));
        listMat.add(new ArrayList<>(Arrays.asList(
                Items.ENCHANTED_SHULKER_SHELL.getItem(plugin),
                Items.ENCHANTED_SLIME_BLOCK.getItem(plugin),
                Items.BOUND_BOOK.getItem(plugin))));
        listInt.add(new ArrayList<>(Arrays.asList(
                10,
                3,
                1)));
        return new FormatEnchantmentGUI(plugin, back, player, 5, 12, "Cubism",
                new ArrayList<>(Arrays.asList(ChatColor.GRAY + "Deal " + ChatColor.GREEN + "+[value]% " + ChatColor.GRAY + "to " + ChatColor.GREEN + "Slimes" + ChatColor.GRAY + ",", ChatColor.GOLD + "Magma Cubes" + ChatColor.GRAY + ", " + ChatColor.GREEN + "Creepers" + ChatColor.GRAY + ", and " + ChatColor.LIGHT_PURPLE + "Shulkers")), new ArrayList<>(),
                listMat, listInt, "Swords");
    }
}
