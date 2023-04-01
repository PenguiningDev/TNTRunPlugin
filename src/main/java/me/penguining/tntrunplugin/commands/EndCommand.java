package me.penguining.tntrunplugin.commands;

import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EndCommand implements CommandExecutor {

    private GameManager gameManager;

    public EndCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        gameManager.setGameState(GameState.WON);

        return false;
    }
}

