package me.penguining.tntrunplugin.commands;

import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameStateCommand implements CommandExecutor {

    private final GameManager gameManager;

    public GameStateCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gamestate")) {
            String gameStateString = gameManager.getGameState().toString();

            Player player = (Player) sender;
            player.sendMessage(ChatColor.WHITE + "The current Game State is: " + ChatColor.GREEN + gameStateString);
        }
        return true;
    }
}
