package me.penguining.tntrunplugin.tasks;

import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdownTask extends BukkitRunnable {

    private GameManager gameManager;

    public GameStartCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private int timeLeft = 11;

    @Override
    public void run() {
        timeLeft--;
        if (timeLeft == 10) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("" + ChatColor.RED + "10", "", 10, 20, 10));
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 5, 5));
        }

        if (timeLeft == 5) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("" + ChatColor.RED + "5", "", 10, 20, 10));
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 5, 5));
        }

        if (timeLeft == 4) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("" + ChatColor.RED + "4", "", 10, 20, 10));
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 5, 5));
        }

        if (timeLeft == 3) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("" + ChatColor.GOLD + "3", "", 10, 20, 10));
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 5, 5));
        }
        if (timeLeft == 2) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("" + ChatColor.GOLD + "2", "", 10, 20, 10));
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 5, 5));
        }

        if (timeLeft == 1) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("" + ChatColor.GREEN + timeLeft, "", 10, 20, 10));
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 5, 5));

        }
        if (timeLeft == 0) {
            Bukkit.getOnlinePlayers().forEach(player -> player.setGameMode(GameMode.ADVENTURE));
            cancel();
            gameManager.setGameState(GameState.ACTIVE);
        }

    }
}
