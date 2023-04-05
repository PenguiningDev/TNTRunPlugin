package me.penguining.tntrunplugin.listeners;

import me.penguining.tntrunplugin.managers.GameManager;
import me.penguining.tntrunplugin.managers.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FullHealthListener implements Listener {

    private final GameManager gameManager;

    public FullHealthListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerLoseHealth(EntityDamageEvent event) {
        Player player = null;
        //Check to see whether the entity is a player first before initializing player
        if(event.getEntity() instanceof Player)  player = (Player) event.getEntity();

//        if (gameManager.getGameState() == GameState.ACTIVE || gameManager.getGameState() == GameState.STARTING) {

        event.setCancelled(true);
//                player.setHealth(player.getMaxHealth());
            }

//    }

    @EventHandler
    public void onPlayerHunger(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();

//        if (gameManager.getGameState() == GameState.ACTIVE || gameManager.getGameState() == GameState.STARTING) {
        event.setCancelled(true);
//                player.setFoodLevel(20);
            }
        }
//    }

