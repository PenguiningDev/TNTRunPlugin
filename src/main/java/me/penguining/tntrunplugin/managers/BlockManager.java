package me.penguining.tntrunplugin.managers;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Set;

public class BlockManager {

    private GameManager gameManager;

    public BlockManager(GameManager gameManager) {
        this.gameManager = gameManager;

        fallsIfBlockUnder.add(Material.SAND);
        fallsIfBlockUnder.add(Material.GRAVEL);
        fallsIfBlockUnder.add(Material.TNT);
    }

    private Set<Material> fallsIfBlockUnder = new HashSet<>();

    public boolean canFallIfBlockUnder(Block block) {
        return fallsIfBlockUnder.contains(block.getType());
    }
}
