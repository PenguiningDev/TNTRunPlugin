package me.penguining.tntrunplugin;

import me.penguining.tntrunplugin.commands.EndCommand;
import me.penguining.tntrunplugin.commands.GameStateCommand;
import me.penguining.tntrunplugin.commands.StartCommand;
import me.penguining.tntrunplugin.listeners.BlockUnderListener;
import me.penguining.tntrunplugin.listeners.FullHealthListener;
import me.penguining.tntrunplugin.listeners.PlayerDieListener;
import me.penguining.tntrunplugin.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TNTRunPlugin extends JavaPlugin {

    private GameManager gameManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();

        this.gameManager = new GameManager(this);

        getServer().getPluginManager().registerEvents(new BlockUnderListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new PlayerDieListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new FullHealthListener(gameManager), this);

        Objects.requireNonNull(getCommand("start")).setExecutor(new StartCommand(gameManager));
        Objects.requireNonNull(getCommand("end")).setExecutor(new EndCommand(gameManager));
        Objects.requireNonNull(getCommand("gamestate")).setExecutor(new GameStateCommand(gameManager));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        gameManager.cleanup();
    }
}
