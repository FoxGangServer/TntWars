package nl.officialfox.tntwars;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.HashMap;
import java.util.UUID;

public class PlayerInteractions implements org.bukkit.event.Listener {
    private HashMap<UUID, Long> throwCooldown = new HashMap<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        @NotNull Action action = event.getAction();
        ItemStack item = event.getItem();

        if(action == Action.RIGHT_CLICK_AIR && item.getType() == Material.TNT){
            long cooldown = 3000;
            long lastThrow = throwCooldown.getOrDefault(player.getUniqueId(), 0L);
            long timeSinceLastThrow = System.currentTimeMillis() - lastThrow;

            if(timeSinceLastThrow > = cooldown){
                throwCooldown.put(player.getUniqueId(), System.currentTimeMillis());

            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        if(event.getEntity() instanceof TNTPrimed){
            ((TNTPrimed) event.getEntity())
        }
    }

}
