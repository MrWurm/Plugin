package its.wurm.testplugin.Inventories;

import its.wurm.testplugin.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaterialsSelectGUI implements InventoryHolder {

    private Inventory main;

    public MaterialsSelectGUI() {
        main = Bukkit.createInventory(this, 54, "Materials - 1");
        init();
    }

    private void init()
    {
        ItemStack item;
        List<String> lore = new ArrayList<>();

        //Adding in all instances of the materials
        main.setItem(0, ItemManager.edripstone);
        main.setItem(1, ItemManager.sedripstone);
        main.setItem(2, ItemManager.ecoal);
        main.setItem(3, ItemManager.secoal);
        main.setItem(4, ItemManager.edeepslate);
        main.setItem(5, ItemManager.sedeepslate);
        main.setItem(6, ItemManager.vsedeepslate);
        main.setItem(7, ItemManager.ebamboo);
        main.setItem(8, ItemManager.sebamboo);
        main.setItem(9, ItemManager.eiron);
        main.setItem(10, ItemManager.seiron);
        main.setItem(11, ItemManager.efeather);
        main.setItem(12, ItemManager.emembrane);
        main.setItem(13, ItemManager.egold);
        main.setItem(14, ItemManager.segold);
        main.setItem(15, ItemManager.esand);
        main.setItem(16, ItemManager.sesand);
        main.setItem(17, ItemManager.vsesand);
        main.setItem(18, ItemManager.ecopper);
        main.setItem(19, ItemManager.secopper);
        main.setItem(20, ItemManager.vsecopper);
        main.setItem(21, ItemManager.equartz);
        main.setItem(22, ItemManager.sequartz);
        main.setItem(23, ItemManager.vsequartz);
        main.setItem(24, ItemManager.ecobble);
        main.setItem(25, ItemManager.ediamond);
        main.setItem(26, ItemManager.eemerald);
        main.setItem(27, ItemManager.alloy);
        main.setItem(28, ItemManager.echicken);
        main.setItem(29, ItemManager.ebeef);
        main.setItem(30, ItemManager.epork);
        main.setItem(31, ItemManager.erabbit);
        main.setItem(32, ItemManager.emutton);
        main.setItem(33, ItemManager.ewool);
        main.setItem(34, ItemManager.ecod);
        main.setItem(35, ItemManager.secod);
        main.setItem(36, ItemManager.esalmon);
        main.setItem(37, ItemManager.sesalmon);
        main.setItem(38, ItemManager.ekelp);
        main.setItem(39, ItemManager.sekelp);
        main.setItem(40, ItemManager.vsekelp);
        main.setItem(41, ItemManager.eclown);
        main.setItem(42, ItemManager.epuffer);
        main.setItem(43, ItemManager.elapis);
        main.setItem(44, ItemManager.selapis);

        //Bottom Row with options to change pages and a go back and next page button
        for (int i = 45; i < 54; i++) {
            main.setItem(i, ItemManager.menu_glass);
        }
        main.setItem(49, ItemManager.back_arrow);
        main.setItem(53, ItemManager.next_arrow);

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