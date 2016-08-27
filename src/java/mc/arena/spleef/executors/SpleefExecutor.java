package mc.arena.spleef.executors;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.alk.arena.executors.CustomCommandExecutor;
import mc.alk.arena.executors.MCCommand;
import mc.alk.arena.objects.arenas.Arena;
import mc.alk.arena.util.MessageUtil;
import mc.arena.spleef.SpleefArenaEditor;
import mc.arena.spleef.SpleefException;

public class SpleefExecutor extends CustomCommandExecutor {

    @MCCommand(cmds = {"setLayer"}, admin = true)
    public boolean setLayer(Player sender, Arena arena) {
        return setLayer(sender, arena, 1);
    }

    @MCCommand(cmds = {"setLayer"}, admin = true, order = 1)
    public boolean setLayer(Player sender, Arena arena, Integer layerIndex) {
        try {
            SpleefArenaEditor sae = new SpleefArenaEditor(arena);
            sae.setLayer(sender, layerIndex);
            return MessageUtil.sendMessage(sender, "&2Spleef Layer " + layerIndex + " has been created");
        } catch (SpleefException e) {
            return MessageUtil.sendMessage(sender, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.sendMessage(sender, ChatColor.RED + "Error creating region. " + e.getMessage());
        }
    }

    @MCCommand(cmds = {"setRegen"}, admin = true)
    public boolean setRegen(CommandSender sender, Arena arena, Integer regenTime) {
        return setRegen(sender, arena, 1, regenTime);
    }

    @MCCommand(cmds = {"setRegen"}, admin = true, order = 1)
    public boolean setRegen(CommandSender sender, Arena arena, Integer layerIndex, Integer regenTime) {
        try {
            SpleefArenaEditor sae = new SpleefArenaEditor(arena);
            sae.setRegen(layerIndex, regenTime);
            return MessageUtil.sendMessage(sender, "&2Spleef Layer " + layerIndex + " now regens every " + regenTime + " seconds");
        } catch (SpleefException e) {
            return MessageUtil.sendMessage(sender, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.sendMessage(sender, ChatColor.RED + "Error setting regen. " + e.getMessage());
        }
    }

    @MCCommand(cmds = {"deleteRegen"}, admin = true)
    public boolean deleteRegen(CommandSender sender, Arena arena) {
        return deleteRegen(sender, arena, 1);
    }

    @MCCommand(cmds = {"deleteRegen"}, admin = true, order = 1)
    public boolean deleteRegen(CommandSender sender, Arena arena, Integer layerIndex) {
        try {
            SpleefArenaEditor sae = new SpleefArenaEditor(arena);
            sae.deleteRegen(layerIndex);
            return MessageUtil.sendMessage(sender, "&2Spleef Layer " + layerIndex + " now no longer regens during the match");
        } catch (SpleefException e) {
            return MessageUtil.sendMessage(sender, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.sendMessage(sender, ChatColor.RED + "Error deleting regen. " + e.getMessage());
        }
    }
}
