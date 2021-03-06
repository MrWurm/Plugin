package its.wurm.testplugin.Inventories;

import dev.dbassett.skullcreator.SkullCreator;
import its.wurm.testplugin.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class RecipeSelectGUI implements InventoryHolder {

    private Inventory main;

    Plugin plugin;

    public RecipeSelectGUI(Plugin plugin) {
        this.plugin = plugin;
        main = Bukkit.createInventory(this, 54, "Recipe categories");
        init();
    }

    private void init()
    {
        ItemStack item;
        //Setting in menu glass (filler) for first half of the GUI
        for (int i = 0; i < 20; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }

        //Setting all the categories (with lore and stuff) in the center
        List<String> lore = new ArrayList<>();

        //Weapons category
        lore.add("§8Contains");
        lore.add("§7 · Swords");
        lore.add("§7 · Bows");
        lore.add("§7 · Wands");
        lore.add("§7 · Shields");
        item = createItem("§4Weapons", Material.IRON_SWORD, lore);
        main.setItem(20, item);
        //Clear the lore list so the next item can use it
        lore.clear();

        //Armor category
        lore.add("§8Contains");
        lore.add("§7 · Helmets");
        lore.add("§7 · Chestplates");
        lore.add("§7 · Leggings");
        lore.add("§7 · Boots");
        item = createItem("§aArmor", Material.CHAINMAIL_CHESTPLATE, lore);
        main.setItem(21, item);
        //Clear the lore list so the next item can use it
        lore.clear();

        //Misc Items category
        lore.add("§8Contains");
        lore.add("§7 · Items that do");
        lore.add("§7   not fit in other");
        lore.add("§7   categories");
        item = createItem("§3Misc Items", Material.POWDER_SNOW_BUCKET, lore);
        main.setItem(22, item);
        //Clear the lore list so the next item can use it
        lore.clear();

        //Materials category
        lore.add("§8Contains");
        lore.add("§7 · Compacted forms");
        lore.add("§7   of items");
        lore.add("§7 · Ingredients only");
        lore.add("§7   used to craft items");
        lore.add("§7 · Other assorted");
        lore.add("§7   raw materials");
        item = createItem("§1Materials", Material.COAL, lore);
        main.setItem(23, item);
        //Clear the lore list so the next item can use it
        lore.clear();

        //Reforge Stones category
        lore.add("§8Contains");
        lore.add("§7 · Reforge Stones");
        ItemStack skull = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBmOGRmYTVlZmM3NTYzMGNlMGRmNDBhNDliOGY1OWJjMjIyMTRkZTk3ZTNmYjQ0YjNjNTZlOGE5YzhhNTZiNiJ9fX0=");
        ItemMeta meta = skull.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Reforge Stones");
        meta.setLore(lore);
        skull.setItemMeta(meta);
        main.setItem(24, skull);
        //Clear the lore list so the next item can use it
        lore.clear();

        //Setting in menu glass (filler) for last half of the GUI
        for (int i = 25; i < 54; i++) {
            main.setItem(i, Items.MENU_GLASS.getItem(plugin));
        }

        main.setItem(49, Items.BACK_ARROW.getItem(plugin));
    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }

    @Override
    public Inventory getInventory() {
        return main;
    }
}
