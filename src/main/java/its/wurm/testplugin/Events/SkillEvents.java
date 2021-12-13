package its.wurm.testplugin.Events;

import its.wurm.testplugin.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillEvents implements Listener {


    static Main plugin;

    public SkillEvents(Main plugin) { this.plugin = plugin;}

    Map<UUID, PlayerSkillData> skills = new HashMap<UUID, PlayerSkillData>();

    public class SkillData implements Serializable {
         int level = 0;
         double xp = 0.0;
         double xpNext = 10.0;
    }


    public class PlayerSkillData implements Serializable {

        SkillData mining = new SkillData();
        SkillData farming = new SkillData();
        SkillData foraging = new SkillData();
        SkillData excavating = new SkillData();
        SkillData combat = new SkillData();

    }

    public void SaveSkillData() {
        try {
            FileOutputStream file = new FileOutputStream("Skills.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(skills);

            out.close();
            file.close();

        }
        catch(IOException ex)
        {
            System.out.println("Say good bye to everyone's skill xp :(");
        }
    }

    public void SkillLoadData() {
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("Skills.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            skills = (HashMap)in.readObject();

            in.close();
            file.close();
        }

        catch(IOException ex)
        {
            System.out.println("Didn't load skill data (so sorry)");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("What are you asking for again?");
        }
    }

    public void checkCombat(Player player) {
        //Combat
        PlayerSkillData csd = skills.get(player.getUniqueId());
        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 0) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 1;
            csd.combat.xpNext = 50;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e0" + "§f ➡ " + "§e1");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 1) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 2;
            csd.combat.xpNext = 80;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e1" + "§f ➡ " + "§e2");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 2) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 3;
            csd.combat.xpNext = 120;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e2" + "§f ➡ " + "§e3");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 3) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 4;
            csd.combat.xpNext = 250;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e3" + "§f ➡ " + "§e4");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 4) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 5;
            csd.combat.xpNext = 500;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e4" + "§f ➡ " + "§e5");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 5) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 6;
            csd.combat.xpNext = 1200;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e5" + "§f ➡ " + "§e6");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 6) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 7;
            csd.combat.xpNext = 2000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e6" + "§f ➡ " + "§e7");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 7) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 8;
            csd.combat.xpNext = 3000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e7" + "§f ➡ " + "§e8");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 8) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 9;
            csd.combat.xpNext = 5000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e8" + "§f ➡ " + "§e9");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 9) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 10;
            csd.combat.xpNext = 6500;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e9" + "§f ➡ " + "§e10");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 10) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 11;
            csd.combat.xpNext = 8200;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e10" + "§f ➡ " + "§e11");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 11) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 12;
            csd.combat.xpNext = 10000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e11" + "§f ➡ " + "§e12");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 12) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 13;
            csd.combat.xpNext = 12500;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e12" + "§f ➡ " + "§e13");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 13) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 14;
            csd.combat.xpNext = 14000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e13" + "§f ➡ " + "§e14");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 14) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 15;
            csd.combat.xpNext = 17000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e14" + "§f ➡ " + "§e15");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 15) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 16;
            csd.combat.xpNext = 20500;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e15" + "§f ➡ " + "§e16");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 16) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 17;
            csd.combat.xpNext = 23000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e16" + "§f ➡ " + "§e17");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 17) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 18;
            csd.combat.xpNext = 25000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e17" + "§f ➡ " + "§e18");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 18) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 19;
            csd.combat.xpNext = 28000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e18" + "§f ➡ " + "§e19");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 19) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 20;
            csd.combat.xpNext = 32000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e19" + "§f ➡ " + "§e20");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 20) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 21;
            csd.combat.xpNext = 36800;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e20" + "§f ➡ " + "§e21");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 21) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 22;
            csd.combat.xpNext = 41000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e21" + "§f ➡ " + "§e22");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 22) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 23;
            csd.combat.xpNext = 50000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e22" + "§f ➡ " + "§e23");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 23) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 24;
            csd.combat.xpNext = 60000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e23" + "§f ➡ " + "§e24");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 24) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 25;
            csd.combat.xpNext = 75000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e24" + "§f ➡ " + "§e25");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 25) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 26;
            csd.combat.xpNext = 90000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e25" + "§f ➡ " + "§e26");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 26) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 27;
            csd.combat.xpNext = 115000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e22" + "§f ➡ " + "§e23");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "More than halfway there, you can do it!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 27) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 28;
            csd.combat.xpNext = 145000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e27" + "§f ➡ " + "§e28");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 28) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 29;
            csd.combat.xpNext = 200000;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_RED + "Combat " + "§e28" + "§f ➡ " + "§e29");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).combat.xp >= skills.get(player.getUniqueId()).combat.xpNext &&
                skills.get(player.getUniqueId()).combat.level == 29) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CCBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE) + 0.04;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DamageModifier"),
                    PersistentDataType.DOUBLE, stat2);
            csd.combat.level = 30;
            csd.combat.xpNext = 0;
            csd.combat.xp = 0;
            player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Combat " + "§e29" + "§f ➡ " + "§e30");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+1 ☣ Crit Chance");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Deal 4% more damage");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Great job on combat 30! You must have");
            player.sendMessage(ChatColor.GOLD + "driven at least 7 species to extintion");
            player.sendMessage(ChatColor.GOLD + "getting this");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }
    }

    public void checkSkill(Player player) {
        //Check if a player has enough xp to level up skill, if they do increase the level of the skill
        //Excavating
        PlayerSkillData csd = skills.get(player.getUniqueId());
        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 0) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 1;
            csd.excavating.xpNext = 50;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e0" + "§f ➡ " + "§e1");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 1) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 2;
            csd.excavating.xpNext = 80;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e1" + "§f ➡ " + "§e2");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 2) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 3;
            csd.excavating.xpNext = 120;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e2" + "§f ➡ " + "§e3");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 3) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 4;
            csd.excavating.xpNext = 250;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e3" + "§f ➡ " + "§e4");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 4) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 5;
            csd.excavating.xpNext = 500;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e4" + "§f ➡ " + "§e5");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 5) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 6;
            csd.excavating.xpNext = 1200;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e5" + "§f ➡ " + "§e6");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 6) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 7;
            csd.excavating.xpNext = 2000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e6" + "§f ➡ " + "§e7");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 7) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 8;
            csd.excavating.xpNext = 3000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e7" + "§f ➡ " + "§e8");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 8) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 9;
            csd.excavating.xpNext = 5000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e8" + "§f ➡ " + "§e9");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 9) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 10;
            csd.excavating.xpNext = 6500;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e9" + "§f ➡ " + "§e10");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 10) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 11;
            csd.excavating.xpNext = 8200;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e10" + "§f ➡ " + "§e11");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 11) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 12;
            csd.excavating.xpNext = 10000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e11" + "§f ➡ " + "§e12");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 12) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 13;
            csd.excavating.xpNext = 12000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e12" + "§f ➡ " + "§e13");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 13) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 14;
            csd.excavating.xpNext = 14000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e13" + "§f ➡ " + "§e14");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 14) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 15;
            csd.excavating.xpNext = 17000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e14" + "§f ➡ " + "§e15");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 15) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 16;
            csd.excavating.xpNext = 20500;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e15" + "§f ➡ " + "§e16");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 16) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 17;
            csd.excavating.xpNext = 23000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e16" + "§f ➡ " + "§e17");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 17) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 18;
            csd.excavating.xpNext = 25000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e17" + "§f ➡ " + "§e18");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 18) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 19;
            csd.excavating.xpNext = 28000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e18" + "§f ➡ " + "§e19");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 19) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 20;
            csd.excavating.xpNext = 32000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e19" + "§f ➡ " + "§e20");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 20) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 21;
            csd.excavating.xpNext = 36800;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e20" + "§f ➡ " + "§e21");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 21) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 22;
            csd.excavating.xpNext = 41000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e21" + "§f ➡ " + "§e22");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 22) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 23;
            csd.excavating.xpNext = 50000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e22" + "§f ➡ " + "§e23");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 23) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 24;
            csd.excavating.xpNext = 60000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e23" + "§f ➡ " + "§e24");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 24) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 25;
            csd.excavating.xpNext = 75000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e24" + "§f ➡ " + "§e25");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 25) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 26;
            csd.excavating.xpNext = 90000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e25" + "§f ➡ " + "§e26");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 26) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 27;
            csd.excavating.xpNext = 115000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e26" + "§f ➡ " + "§e27");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "A little over halfway there! You can do it!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 27) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 28;
            csd.excavating.xpNext = 145000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e27" + "§f ➡ " + "§e28");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can now be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 28) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 29;
            csd.excavating.xpNext = 200000;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(net.md_5.bungee.api.ChatColor.of("#B8B83C") + "Excavating " + "§e28" + "§f ➡ " + "§e29");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "New items can be dug up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).excavating.xp >= skills.get(player.getUniqueId()).excavating.xpNext &&
                skills.get(player.getUniqueId()).excavating.level == 29) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "ExcFBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.excavating.level = 30;
            csd.excavating.xpNext = 0;
            csd.excavating.xp = 0;
            player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Excavating " + "§e29" + "§f ➡ " + "§e30");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ♠ Excavating Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "YOU MADE IT TO LEVEL THIRTY YOU MADLAD! GG");
            player.sendMessage(ChatColor.GOLD + "(also why did you spend hours of your free time clicking sand?)");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }


        //Mining
        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 0) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 1;
            csd.mining.xpNext = 50;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e0" + "§f ➡ " + "§e1");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 1) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 2;
            csd.mining.xpNext = 80;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e1" + "§f ➡ " + "§e2");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 2) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 3;
            csd.mining.xpNext = 120;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e2" + "§f ➡ " + "§e3");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 3) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 4;
            csd.mining.xpNext = 250;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e3" + "§f ➡ " + "§e4");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 4) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 5;
            csd.mining.xpNext = 500;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e4" + "§f ➡ " + "§e5");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 5) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 6;
            csd.mining.xpNext = 1200;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e5" + "§f ➡ " + "§e6");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 6) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 7;
            csd.mining.xpNext = 2000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e6" + "§f ➡ " + "§e7");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 7) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 8;
            csd.mining.xpNext = 3000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e7" + "§f ➡ " + "§e8");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 8) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 9;
            csd.mining.xpNext = 5000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e8" + "§f ➡ " + "§e9");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 9) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 10;
            csd.mining.xpNext = 6500;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e9" + "§f ➡ " + "§e10");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 10) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 11;
            csd.mining.xpNext = 8200;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e10" + "§f ➡ " + "§e11");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 11) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 12;
            csd.mining.xpNext = 10000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e11" + "§f ➡ " + "§e12");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 12) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 13;
            csd.mining.xpNext = 12500;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e12" + "§f ➡ " + "§e13");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 13) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 14;
            csd.mining.xpNext = 14000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e13" + "§f ➡ " + "§e14");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 14) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 15;
            csd.mining.xpNext = 17000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e14" + "§f ➡ " + "§e15");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 15) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 16;
            csd.mining.xpNext = 20500;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e15" + "§f ➡ " + "§e16");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 16) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 17;
            csd.mining.xpNext = 23000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e16" + "§f ➡ " + "§e17");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 17) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 18;
            csd.mining.xpNext = 25000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e17" + "§f ➡ " + "§e18");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 18) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 19;
            csd.mining.xpNext = 28000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e18" + "§f ➡ " + "§e19");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 19) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 20;
            csd.mining.xpNext = 32000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e19" + "§f ➡ " + "§e20");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 20) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 21;
            csd.mining.xpNext = 36800;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e20" + "§f ➡ " + "§e21");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 21) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 22;
            csd.mining.xpNext = 41000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e21" + "§f ➡ " + "§e22");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 22) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 23;
            csd.mining.xpNext = 50000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e22" + "§f ➡ " + "§e23");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 23) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 24;
            csd.mining.xpNext = 50000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e23" + "§f ➡ " + "§e24");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 24) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 25;
            csd.mining.xpNext = 75000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e24" + "§f ➡ " + "§e25");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 25) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 26;
            csd.mining.xpNext = 90000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e25" + "§f ➡ " + "§e26");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 26) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 27;
            csd.mining.xpNext = 100000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e26" + "§f ➡ " + "§e27");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "Good job, you are more than halfway to mining 30.");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 27) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 28;
            csd.mining.xpNext = 115000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e27" + "§f ➡ " + "§e28");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 28) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 29;
            csd.mining.xpNext = 145000;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.BLUE + "Mining " + "§e28" + "§f ➡ " + "§e29");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).mining.xp >= skills.get(player.getUniqueId()).mining.xpNext &&
                skills.get(player.getUniqueId()).mining.level == 29) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "MineFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE) + 1.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "DefenseBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.mining.level = 30;
            csd.mining.xpNext = 0;
            csd.mining.xp = 0;
            player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Mining " + "§e29" + "§f ➡ " + "§e30");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ⛏ Mining Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+1 ❈ Defense");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Bro big gg on mining 30!");
            player.sendMessage(ChatColor.GOLD + "(one question tho, why did you mine this much?)");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        //Farming
        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 0) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 1;
            csd.farming.xpNext = 50;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e0" + "§f ➡ " + "§e1");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 1) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 2;
            csd.farming.xpNext = 80;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e1" + "§f ➡ " + "§e2");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 2) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 3;
            csd.farming.xpNext = 120;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e2" + "§f ➡ " + "§e3");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 3) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 4;
            csd.farming.xpNext = 250;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e3" + "§f ➡ " + "§e4");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 4) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 5;
            csd.farming.xpNext = 500;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e4" + "§f ➡ " + "§e5");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 5) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 6;
            csd.farming.xpNext = 1200;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e5" + "§f ➡ " + "§e6");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 6) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 7;
            csd.farming.xpNext = 2000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e6" + "§f ➡ " + "§e7");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 7) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 8;
            csd.farming.xpNext = 3000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e7" + "§f ➡ " + "§e8");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 8) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 9;
            csd.farming.xpNext = 5000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e8" + "§f ➡ " + "§e9");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 9) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 10;
            csd.farming.xpNext = 6500;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e9" + "§f ➡ " + "§e10");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 10) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 11;
            csd.farming.xpNext = 8200;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e10" + "§f ➡ " + "§e11");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 11) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 12;
            csd.farming.xpNext = 10000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e11" + "§f ➡ " + "§e12");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 12) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 13;
            csd.farming.xpNext = 12000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e12" + "§f ➡ " + "§e13");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 13) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 14;
            csd.farming.xpNext = 14000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e13" + "§f ➡ " + "§e14");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 14) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 15;
            csd.farming.xpNext = 17000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e14" + "§f ➡ " + "§e15");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 15) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 16;
            csd.farming.xpNext = 20500;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e15" + "§f ➡ " + "§e16");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 16) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 17;
            csd.farming.xpNext = 23000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e16" + "§f ➡ " + "§e17");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 17) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 18;
            csd.farming.xpNext = 25000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e17" + "§f ➡ " + "§e18");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 18) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 19;
            csd.farming.xpNext = 28000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e18" + "§f ➡ " + "§e19");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 19) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 20;
            csd.farming.xpNext = 32000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e19" + "§f ➡ " + "§e20");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 20) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 21;
            csd.farming.xpNext = 36800;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e20" + "§f ➡ " + "§e21");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 21) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 22;
            csd.farming.xpNext = 41000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e21" + "§f ➡ " + "§e22");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 22) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 23;
            csd.farming.xpNext = 50000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e22" + "§f ➡ " + "§e23");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 23) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 24;
            csd.farming.xpNext = 60000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e23" + "§f ➡ " + "§e24");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 24) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 25;
            csd.farming.xpNext = 75000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e24" + "§f ➡ " + "§e25");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 25) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 26;
            csd.farming.xpNext = 90000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e25" + "§f ➡ " + "§e26");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GRAY + "More than halfway there! Good job!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 26) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 27;
            csd.farming.xpNext = 115000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e26" + "§f ➡ " + "§e27");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 27) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 28;
            csd.farming.xpNext = 14500;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e27" + "§f ➡ " + "§e28");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 28) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 29;
            csd.farming.xpNext = 200000;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e28" + "§f ➡ " + "§e29");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).farming.xp >= skills.get(player.getUniqueId()).farming.xpNext &&
                skills.get(player.getUniqueId()).farming.level == 29) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE) + 4.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "FarmFBase"),
                    PersistentDataType.DOUBLE, stat1);
            Double stat2 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "HealthBase"),
                    PersistentDataType.DOUBLE, stat2);
            csd.farming.level = 30;
            csd.farming.xpNext = 0;
            csd.farming.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Farming " + "§e29" + "§f ➡ " + "§e30");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+4 ☘ Farming Fortune");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+2 ❤ Health");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Great Job on farming XXX! That is");
            player.sendMessage(ChatColor.GOLD + "pretty cool! (Except for the fact you spent");
            player.sendMessage(ChatColor.GOLD + "hours planting crops and breaking them)");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        //Foraging
        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 0) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 1;
            csd.foraging.xpNext = 50;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e0" + "§f ➡ " + "§e1");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 1) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 2;
            csd.foraging.xpNext = 80;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e1" + "§f ➡ " + "§e2");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 2) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 3;
            csd.foraging.xpNext = 120;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e2" + "§f ➡ " + "§e3");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 3) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 4;
            csd.foraging.xpNext = 250;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e3" + "§f ➡ " + "§e4");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 4) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 5;
            csd.foraging.xpNext = 500;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e4" + "§f ➡ " + "§e5");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 5) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 6;
            csd.foraging.xpNext = 1200;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e5" + "§f ➡ " + "§e6");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 6) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 7;
            csd.foraging.xpNext = 2000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e6" + "§f ➡ " + "§e7");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 7) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 8;
            csd.foraging.xpNext = 3000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e7" + "§f ➡ " + "§e8");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 8) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 9;
            csd.foraging.xpNext = 5000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e8" + "§f ➡ " + "§e9");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 9) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 10;
            csd.foraging.xpNext = 6500;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e9" + "§f ➡ " + "§e10");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 10) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 11;
            csd.foraging.xpNext = 8200;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e10" + "§f ➡ " + "§e11");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 11) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 12;
            csd.foraging.xpNext = 10000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e11" + "§f ➡ " + "§e12");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 12) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 13;
            csd.foraging.xpNext = 12500;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e12" + "§f ➡ " + "§e13");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 13) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 14;
            csd.foraging.xpNext = 14000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e13" + "§f ➡ " + "§e14");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 14) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 15;
            csd.foraging.xpNext = 17000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e14" + "§f ➡ " + "§e15");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 15) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 16;
            csd.foraging.xpNext = 20500;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e15" + "§f ➡ " + "§e16");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 16) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 17;
            csd.foraging.xpNext = 23000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e16" + "§f ➡ " + "§e17");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 17) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 18;
            csd.foraging.xpNext = 25000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e17" + "§f ➡ " + "§e18");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 18) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 19;
            csd.foraging.xpNext = 28000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e19" + "§f ➡ " + "§e20");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 19) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 20;
            csd.foraging.xpNext = 32000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e19" + "§f ➡ " + "§e20");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 20) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 21;
            csd.foraging.xpNext = 36800;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e20" + "§f ➡ " + "§e21");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 21) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 22;
            csd.foraging.xpNext = 41000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e21" + "§f ➡ " + "§e22");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 22) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 23;
            csd.foraging.xpNext = 50000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e22" + "§f ➡ " + "§e23");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 23) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 24;
            csd.foraging.xpNext = 60000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e23" + "§f ➡ " + "§e24");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 24) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 25;
            csd.foraging.xpNext = 75000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e24" + "§f ➡ " + "§e25");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 25) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 26;
            csd.foraging.xpNext = 90000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e25" + "§f ➡ " + "§e26");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 26) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 27;
            csd.foraging.xpNext = 115000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e26" + "§f ➡ " + "§e27");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 27) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 28;
            csd.foraging.xpNext = 145000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e27" + "§f ➡ " + "§e28");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 28) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 29;
            csd.foraging.xpNext = 200000;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GREEN + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.DARK_GREEN + "Foraging " + "§e28" + "§f ➡ " + "§e29");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.RED + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }

        if (skills.get(player.getUniqueId()).foraging.xp >= skills.get(player.getUniqueId()).foraging.xpNext &&
                skills.get(player.getUniqueId()).foraging.level == 29) {

            Double stat1 = player.getPersistentDataContainer().get(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE) + 2.0;
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "StrengthBase"),
                    PersistentDataType.DOUBLE, stat1);
            csd.foraging.level = 30;
            csd.foraging.xpNext = 0;
            csd.foraging.xp = 0;
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 60, 1);
            skills.put(player.getUniqueId(), csd);
            player.sendMessage(ChatColor.GOLD + "-----------------------------------");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "§lSkill Level Up!");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Foraging " + "§e29" + "§f ➡ " + "§e30");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "+2 ❁ Strength");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD + "Sorry man, too tired to make a good message for this");
            player.sendMessage(" ");
            player.sendMessage(ChatColor.GOLD+ "-----------------------------------");
        }
    }





    @EventHandler
    public void setSkill(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!skills.containsKey(player.getUniqueId())) {
            skills.put(player.getUniqueId(), new PlayerSkillData());
        }
    }

    @EventHandler
    //Block Break events and how much xp they give
    public void breakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        PlayerSkillData csd = skills.get(player.getUniqueId());
        String lastMined = "none";

        if (block.getMetadata("placed").isEmpty()) {
            //Mining xp section
            if (block.getType() == Material.BEDROCK && player.isOp() == true) {

                csd.mining.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
                csd.excavating.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
                csd.foraging.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
                csd.farming.xp += 10000000.0;
                skills.put(player.getUniqueId(), csd);
            }

            if (block.getType() == Material.STONE || block.getType() == Material.COBBLESTONE ||
                    block.getType() == Material.MOSSY_COBBLESTONE) {

                csd.mining.xp += 1.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.CALCITE || block.getType() == Material.GRANITE ||
                    block.getType() == Material.ANDESITE || block.getType() == Material.DIORITE) {

                csd.mining.xp += 4.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE || block.getType() == Material.BLACKSTONE ||
                    block.getType() == Material.BASALT || block.getType() == Material.SMOOTH_BASALT) {

                csd.mining.xp += 6.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.NETHERRACK) {

                csd.mining.xp += 0.2;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.COAL_ORE || block.getType() == Material.AMETHYST_CLUSTER) {

                csd.mining.xp += 8.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.COAL_ORE || block.getType() == Material.AMETHYST_CLUSTER) {

                csd.mining.xp += 8.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_COAL_ORE || block.getType() == Material.NETHER_QUARTZ_ORE) {

                csd.mining.xp += 12.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.COPPER_ORE) {

                csd.mining.xp += 10.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_COPPER_ORE || block.getType() == Material.AMETHYST_BLOCK) {

                csd.mining.xp += 15.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.IRON_ORE) {

                csd.mining.xp += 16.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_IRON_ORE) {

                csd.mining.xp += 24.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.LAPIS_ORE || block.getType() == Material.REDSTONE_ORE) {

                csd.mining.xp += 20.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_LAPIS_ORE || block.getType() == Material.DEEPSLATE_REDSTONE_ORE) {

                csd.mining.xp += 32.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.GOLD_ORE) {

                csd.mining.xp += 18.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_GOLD_ORE) {

                csd.mining.xp += 25.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DIAMOND_ORE) {

                csd.mining.xp += 36.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_DIAMOND_ORE) {

                csd.mining.xp += 50.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.NETHER_GOLD_ORE) {

                csd.mining.xp += 7.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.EMERALD_ORE) {

                csd.mining.xp += 40.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DEEPSLATE_EMERALD_ORE) {

                csd.mining.xp += 90.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.TUFF) {

                csd.mining.xp += 1.2;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.DRIPSTONE_BLOCK) {

                csd.mining.xp += 2.4;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.POINTED_DRIPSTONE) {

                csd.mining.xp += 0.6;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.OBSIDIAN) {

                csd.mining.xp += 60.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.MAGMA_BLOCK) {

                csd.mining.xp += 2.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.BRAIN_CORAL_BLOCK || block.getType() == Material.FIRE_CORAL_BLOCK
                    || block.getType() == Material.HORN_CORAL_BLOCK || block.getType() == Material.TUBE_CORAL_BLOCK) {

                csd.mining.xp += 0.1;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.SANDSTONE) {

                csd.mining.xp += 0.8;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }

            if (block.getType() == Material.ANCIENT_DEBRIS) {

                csd.mining.xp += 300.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "mining";
            }


            //Excavating xp section
            if (block.getType() == Material.DIRT) {

                csd.excavating.xp += 1;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.SAND || block.getType() == Material.RED_SAND) {

                csd.excavating.xp += 2;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.GRASS_BLOCK) {

                csd.excavating.xp += 1.2;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.COARSE_DIRT || block.getType() == Material.PODZOL ||
                    block.getType() == Material.MYCELIUM) {

                csd.excavating.xp += 6;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.GRAVEL) {

                csd.excavating.xp += 3;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.CLAY) {

                csd.excavating.xp += 15;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.SOUL_SAND || block.getType() == Material.SOUL_SOIL) {

                csd.excavating.xp += 5;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            if (block.getType() == Material.SNOW_BLOCK || block.getType() == Material.SNOW ||
                    block.getType() == Material.POWDER_SNOW) {

                csd.excavating.xp += 0.8;
                skills.put(player.getUniqueId(), csd);
                lastMined = "excavating";
            }

            //Foraging xp section
            if (block.getType() == Material.OAK_LOG || block.getType() == Material.BIRCH_LOG ||
                    block.getType() == Material.DARK_OAK_LOG || block.getType() == Material.ACACIA_LOG ||
                    block.getType() == Material.SPRUCE_LOG || block.getType() == Material.JUNGLE_LOG ||
                    block.getType() == Material.RED_MUSHROOM || block.getType() == Material.BROWN_MUSHROOM) {

                csd.foraging.xp += 6;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.WARPED_STEM || block.getType() == Material.CRIMSON_STEM) {

                csd.foraging.xp += 10;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.MUSHROOM_STEM || block.getType() == Material.RED_MUSHROOM_BLOCK ||
                    block.getType() == Material.BROWN_MUSHROOM_BLOCK) {

                csd.foraging.xp += 2;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.WARPED_FUNGUS || block.getType() == Material.CRIMSON_FUNGUS) {

                csd.foraging.xp += 12;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.OAK_LEAVES || block.getType() == Material.BIRCH_LEAVES ||
                    block.getType() == Material.ACACIA_LEAVES || block.getType() == Material.SPRUCE_LEAVES ||
                    block.getType() == Material.JUNGLE_LEAVES || block.getType() == Material.AZALEA_LEAVES ||
                    block.getType() == Material.FLOWERING_AZALEA_LEAVES || block.getType() == Material.TALL_GRASS ||
                    block.getType() == Material.LARGE_FERN || block.getType() == Material.TALL_SEAGRASS ||
                    block.getType() == Material.CRIMSON_ROOTS || block.getType() == Material.WARPED_ROOTS) {

                csd.foraging.xp += 0.2;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.DANDELION || block.getType() == Material.POPPY ||
                    block.getType() == Material.PINK_TULIP || block.getType() == Material.RED_TULIP ||
                    block.getType() == Material.ORANGE_TULIP || block.getType() == Material.WHITE_TULIP ||
                    block.getType() == Material.BLUE_ORCHID || block.getType() == Material.AZURE_BLUET ||
                    block.getType() == Material.CORNFLOWER || block.getType() == Material.LILY_OF_THE_VALLEY ||
                    block.getType() == Material.ALLIUM || block.getType() == Material.OXEYE_DAISY) {

                csd.foraging.xp += 1;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.DEAD_BUSH || block.getType() == Material.SEA_PICKLE ||
                    block.getType() == Material.SEAGRASS || block.getType() == Material.GRASS ||
                    block.getType() == Material.FERN || block.getType() == Material.AZALEA_LEAVES) {

                csd.foraging.xp += 0.1;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.VINE || block.getType() == Material.GLOW_LICHEN) {

                csd.foraging.xp += 0.4;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.TWISTING_VINES || block.getType() == Material.TWISTING_VINES_PLANT) {

                for (int i = 0; i > -255; --i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.TWISTING_VINES && b.getType() != Material.TWISTING_VINES_PLANT) {
                        break;
                    }
                    csd.foraging.xp += 0.4;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.WEEPING_VINES || block.getType() == Material.WEEPING_VINES_PLANT) {

                for (int i = 0; i > -255; --i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.WEEPING_VINES && b.getType() != Material.WEEPING_VINES_PLANT) {
                        break;
                    }
                    csd.foraging.xp += 0.4;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.ROSE_BUSH || block.getType() == Material.SUNFLOWER ||
                    block.getType() == Material.LILAC || block.getType() == Material.PEONY) {

                csd.foraging.xp += 1;
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.BAMBOO) {

                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.BAMBOO) {
                        break;
                    }
                    csd.foraging.xp += 3;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "foraging";
            }

            if (block.getType() == Material.SWEET_BERRY_BUSH) {
                Ageable age = (Ageable) block.getBlockData();
                if (age.getAge() == 3 || age.getAge() == 2) {
                    csd.foraging.xp += 5;
                    skills.put(player.getUniqueId(), csd);
                    lastMined = "foraging";
                }
            }

            //Farming xp section
            if (block.getType() == Material.POTATOES || block.getType() == Material.CARROTS ||
                    block.getType() == Material.BEETROOTS) {
                if (block.getBlockData() instanceof Ageable) {
                    org.bukkit.block.data.Ageable age = (Ageable) block.getBlockData();
                    if (age.getAge() == age.getMaximumAge()) {
                        csd.farming.xp += 5.0;
                        skills.put(player.getUniqueId(), csd);
                        lastMined = "farming";
                    }
                }
            }

            if (block.getType() == Material.WHEAT) {
                if (block.getBlockData() instanceof Ageable) {
                    org.bukkit.block.data.Ageable age = (Ageable) block.getBlockData();
                    if (age.getAge() == age.getMaximumAge()) {
                        csd.farming.xp += 2.0;
                        skills.put(player.getUniqueId(), csd);
                        lastMined = "farming";
                    }
                }
            }

            if (block.getType() == Material.COCOA) {
                if (block.getBlockData() instanceof Ageable) {
                    org.bukkit.block.data.Ageable age = (Ageable) block.getBlockData();
                    if (age.getAge() == age.getMaximumAge()) {
                        csd.farming.xp += 12.0;
                        skills.put(player.getUniqueId(), csd);
                        lastMined = "farming";
                    }
                }
            }

            if (block.getType() == Material.PUMPKIN || block.getType() == Material.MELON) {
                csd.farming.xp += 8.0;
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            if (block.getType() == Material.KELP_PLANT) {
                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.KELP_PLANT) {
                        break;
                    }
                    csd.farming.xp += 0.8;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            if (block.getType() == Material.CACTUS) {
                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.CACTUS) {
                        break;
                    }
                    csd.farming.xp += 8;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            if (block.getType() == Material.SUGAR_CANE) {
                for (int i = 0; i < 255; ++i) {

                    Block b = block.getLocation().add(0, i, 0).getBlock();

                    if (b.getType() != Material.SUGAR_CANE) {
                        break;
                    }
                    csd.farming.xp += 2.4;
                }
                skills.put(player.getUniqueId(), csd);
                lastMined = "farming";
            }

            checkSkill(player);

            //What message to send player
            if (lastMined == "mining") {
                String message = String.format(
                        "§3+%.1f/%.0f Mining XP",
                        skills.get(player.getUniqueId()).mining.xp,
                        skills.get(player.getUniqueId()).mining.xpNext

                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 2);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }

            if (lastMined == "excavating") {
                String message = String.format(
                        "§3+%.1f/%.0f Excavating XP",
                        skills.get(player.getUniqueId()).excavating.xp,
                        skills.get(player.getUniqueId()).excavating.xpNext
                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 2);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }

            if (lastMined == "foraging") {
                String message = String.format(
                        "§3+%.1f/%.0f Foraging XP",
                        skills.get(player.getUniqueId()).foraging.xp,
                        skills.get(player.getUniqueId()).foraging.xpNext
                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 2);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }

            if (lastMined == "farming") {
                String message = String.format(
                        "§3+%.1f/%.0f Farming XP",
                        skills.get(player.getUniqueId()).farming.xp,
                        skills.get(player.getUniqueId()).farming.xpNext
                );
                player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                        PersistentDataType.DOUBLE, 5.0);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 2);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }
        }
    }

    @EventHandler
    public void combatXP(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity().isDead()) {

            Player player = (Player) event.getDamager();
            PlayerSkillData csd = skills.get(player.getUniqueId());
            if (player.getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                    PersistentDataType.INTEGER) != null) {
                switch (event.getEntity().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"),
                        PersistentDataType.INTEGER)) {
                    case 1:
                        csd.combat.xp += 7.0;
                        break;
                    case 2:
                    case 8:
                        csd.combat.xp += 9.0;
                        break;
                    case 3:
                        csd.combat.xp += 6.0;
                        break;
                    case 4:
                        csd.combat.xp += 8.0;
                        break;
                    case 5:
                        csd.combat.xp += 0.0;
                        break;
                    case 6:
                        csd.combat.xp += 300.0;
                        break;
                    case 7:
                        csd.combat.xp += 12.0;
                        break;
                    default:
                        csd.combat.xp += 0.8;
                        break;
                }
            }
            skills.put(player.getUniqueId(), csd);

            String message = String.format(
                    "§3+%.1f/%.0f Combat XP",
                    skills.get(player.getUniqueId()).combat.xp,
                    skills.get(player.getUniqueId()).combat.xpNext
            );
            player.getPersistentDataContainer().set(new NamespacedKey(plugin, "CoolDown"),
                    PersistentDataType.DOUBLE, 5.0);
            checkCombat(player);
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
        }
    }
}

