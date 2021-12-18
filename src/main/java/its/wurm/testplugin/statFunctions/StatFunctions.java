package its.wurm.testplugin.statFunctions;

import its.wurm.testplugin.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StatFunctions {

    public static void CheckHealth(Entity entity, Main plugin) {

        //Check if the entity is a creature (you are not giving health to things like arrows for example
        if (entity instanceof Creature) {

            //Check that they do not have a container for health
            if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                    PersistentDataType.DOUBLE) == null) {

                org.bukkit.entity.Creature creature = (Creature) entity;

                creature.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,
                        9999999, 5, true, false));

                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE, ((Creature) entity).getHealth());
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE, ((Creature) entity).getHealth());
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Defense"),
                        PersistentDataType.DOUBLE, 0.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealMod"),
                        PersistentDataType.DOUBLE, 0.0);
                entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Name"),
                        PersistentDataType.STRING, "" + entity.getType());

                String Name = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Name"),
                        PersistentDataType.STRING);
                Double Health = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE);
                Double MaxHealth = entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE);

                entity.setCustomName(ChatColor.GOLD + "" + Name + "" + ChatColor.RED + " ❤" +
                        Health + "/" + MaxHealth);
            }
        }
        //Check if the entity does not have a damage container and add one if it does not have it
        if (entity.getPersistentDataContainer().get(new NamespacedKey(plugin, "Damage"),
                PersistentDataType.DOUBLE) == null) {
            entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "Damage"),
                    PersistentDataType.DOUBLE, 2.0);
            entity.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageMod"),
                    PersistentDataType.DOUBLE, 0.0);
        }
    }

    public static void ShowStat(Player player, Main plugin) {
        String message = String.format(
                "§c %.1f/%.1f ❤",

                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                        PersistentDataType.DOUBLE),
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                        PersistentDataType.DOUBLE)

        );

        String message2 = String.format(
                "§b %.1f/%.1f ✎",

                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                        PersistentDataType.DOUBLE),
                player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                        PersistentDataType.DOUBLE)

        );
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message + "  " + message2));
        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Health"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                PersistentDataType.DOUBLE)) {

            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Health"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxHealth"),
                            PersistentDataType.DOUBLE));
        }

        if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "Mana"),
                PersistentDataType.DOUBLE) > player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                PersistentDataType.DOUBLE)) {

            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "Mana"),
                    PersistentDataType.DOUBLE, player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MaxMana"),
                            PersistentDataType.DOUBLE));
        }
    }


    public static void DamageDisplay(Entity entity, Main plugin) {}
}
