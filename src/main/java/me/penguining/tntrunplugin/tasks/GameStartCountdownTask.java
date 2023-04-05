package me.penguining.tntrunplugin.tasks;

import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.stream.IntStream;

public class GameStartCountdownTask extends BukkitRunnable {

    private GameManager gameManager;
    private int timeLeft = 11;

    public GameStartCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        createCountdown(timeLeft--, 10,5,4,3,2,1);
    }
    public void createCountdown(int timeLeft, int... showCountdownAtInt){
        ChatColor color = switch(timeLeft){
            case 4,5,10 -> ChatColor.RED;
            case 3, 2 -> ChatColor.GOLD;
            case 0 -> {
                Bukkit.getOnlinePlayers().forEach(player -> player.setGameMode(GameMode.ADVENTURE));
                cancel();
                gameManager.setGameState(GameState.ACTIVE);
                yield null;
            }
            default -> ChatColor.GREEN;
        };
        //Checks if timeLeft matches any of the values passed into the showCountdownAtInt Array
            if(IntStream.of(showCountdownAtInt).anyMatch(n -> n == timeLeft)){
                Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("" + color + timeLeft, "", 10, 20, 10));
                Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 5, 5));

        }



        }
        }



