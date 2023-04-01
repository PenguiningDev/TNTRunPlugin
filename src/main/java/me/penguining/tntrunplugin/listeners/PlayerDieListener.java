package me.penguining.tntrunplugin.listeners;

import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class PlayerDieListener implements Listener {

    private final GameManager gameManager;

    public PlayerDieListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getY() < 85) {
            if (gameManager.getGameState() == GameState.ACTIVE) {
                if (player.getGameMode() == GameMode.ADVENTURE) {

                    Location playerLocationOnDeath = new Location(Bukkit.getServer().getWorld("world"), 61.4, 102, 67.5);
                    player.teleport(playerLocationOnDeath);

                    player.setGameMode(GameMode.SPECTATOR);
                    Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + "DEATH! " + ChatColor.RESET + ChatColor.WHITE + player.getName() + " has died!");
                }

                if (player.getGameMode() == GameMode.SPECTATOR) {

                    Location playerLocationOnDeath = new Location(Bukkit.getServer().getWorld("world"), 61.4, 102, 67.5);
                    player.teleport(playerLocationOnDeath);
                }
            }
//                  Activate when game is fully done:

//                if (!gameManager.getGameState().equals(GameState.ACTIVE)) {
//                    Location playerLocationOnDeath = new Location(Bukkit.getServer().getWorld("world"), 61.4, 102, 67.5);
//                    player.teleport(playerLocationOnDeath);
//                }


                if (gameManager.getGameState() == GameState.ACTIVE) {

                    for (Player online : Bukkit.getOnlinePlayers()) {
                            ArrayList<Player> alivePlayers = new ArrayList<>();

                            if (online.getGameMode() == GameMode.SPECTATOR) {
                                alivePlayers.add(online);

                                if (alivePlayers.size() == Bukkit.getOnlinePlayers().size() - 1) {
                                    gameManager.setGameState(GameState.WON);


                                }
                            }
                        }
                    }
                }
            }
        }

