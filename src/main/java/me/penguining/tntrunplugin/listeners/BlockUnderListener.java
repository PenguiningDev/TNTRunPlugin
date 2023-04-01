package me.penguining.tntrunplugin.listeners;

import me.penguining.tntrunplugin.TNTRunPlugin;
import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlockUnderListener implements Listener {

    private TNTRunPlugin plugin;

    public BlockUnderListener(TNTRunPlugin plugin) {
        this.plugin = plugin;
    }

    private GameManager gameManager;

    public BlockUnderListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Location blockUnder = player.getLocation();
        blockUnder.setY(blockUnder.getY() - 1);

        Location blockUnder2 = player.getLocation();
        blockUnder2.setY(blockUnder2.getY() - 2);


        if (gameManager.getGameState().equals(GameState.ACTIVE) && !gameManager.getGameState().equals(GameState.WON)) {
            if (player.getGameMode() == GameMode.ADVENTURE) {
                if (gameManager.getBlockManager().canFallIfBlockUnder(blockUnder.getBlock())) {
                    blockUnder.getBlock().setType(Material.AIR);
                    blockUnder2.getBlock().setType(Material.AIR);
                }

            }
        }
    }
}


