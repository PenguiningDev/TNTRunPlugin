package me.penguining.tntrunplugin.managers;

import me.penguining.tntrunplugin.TNTRunPlugin;
import me.penguining.tntrunplugin.listeners.PlayerDieListener;
import me.penguining.tntrunplugin.tasks.GameStartCountdownTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GameManager {

    private final TNTRunPlugin plugin;
    private GameState gameState = GameState.LOBBY;
    private final BlockManager blockManager;
    private final PlayerManager playerManager;
    private GameStartCountdownTask gameStartCountdownTask;



    public GameManager(TNTRunPlugin plugin) {
        this.plugin = plugin;

        this.blockManager = new BlockManager(this);
        this.playerManager = new PlayerManager(this);

    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        switch (gameState) {

            case STARTING:
//                getPlayerManager().giveKits();

                Bukkit.getOnlinePlayers().forEach(player -> player.setHealth(20));
                Bukkit.getOnlinePlayers().forEach(player -> player.setFoodLevel(20));
                Bukkit.getOnlinePlayers().forEach(player -> player.setGameMode(GameMode.ADVENTURE));

                this.gameStartCountdownTask = new GameStartCountdownTask(this);
                this.gameStartCountdownTask.runTaskTimer(plugin, 0, 20);

                break;

            case ACTIVE:
                if (this.gameStartCountdownTask != null) this.gameStartCountdownTask.cancel();
                Bukkit.broadcastMessage(ChatColor.GREEN + "The game has started!");

                break;




            case WON:
                for (Player adventurePlayer : Bukkit.getOnlinePlayers()) {
                    if (adventurePlayer.getGameMode() == GameMode.ADVENTURE) {
                        Bukkit.broadcastMessage("");

                        Bukkit.broadcastMessage("" +
                                ChatColor.AQUA + ChatColor.STRIKETHROUGH
                                + "                                  "
                                + ChatColor.GOLD
                                + " TNT Run "
                                + ChatColor.AQUA + ChatColor.STRIKETHROUGH
                                + "                                  "
                        );

                        Bukkit.broadcastMessage(""
                                + ChatColor.GREEN + ChatColor.BOLD
                                + "WINNER! "
                                + ChatColor.WHITE + adventurePlayer.getName()
                                + " is the winner!");
                        Bukkit.broadcastMessage("" + ChatColor.AQUA + ChatColor.STRIKETHROUGH
                                + "                                                                                "
                        );

                        Bukkit.broadcastMessage("");
                    }
                }
                    break;

        }

    }


    public void cleanup() {

    }

    public BlockManager getBlockManager() {
        return blockManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public GameState getGameState() {
        return gameState;
    }
}



