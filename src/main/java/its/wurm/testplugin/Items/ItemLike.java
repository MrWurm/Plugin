package its.wurm.testplugin.Items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;


public interface ItemLike {

    ItemStack getItem(Plugin plugin);
}