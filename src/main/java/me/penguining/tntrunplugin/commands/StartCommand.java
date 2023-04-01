package me.penguining.tntrunplugin.commands;

import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    private final GameManager gameManager;

    public StartCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (Bukkit.getOnlinePlayers().size() == 1) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.RED + "You cannot start the game with only 1 player online!");
            }
            Player player = (Player) sender;
                if (Bukkit.getOnlinePlayers().size() > 1) {
                    gameManager.setGameState(GameState.STARTING);
                    Bukkit.broadcastMessage("" + ChatColor.RED + player.getName() + ChatColor.WHITE + " has started the game!");

                    return true;
                }
            }

        return false;
    }
}