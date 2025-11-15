package my.qqhoxen.hFreeze.events

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent

class PlayerItemsHandler : Listener {
    @EventHandler
    fun onPickup(e: EntityPickupItemEvent) {
        val player = e.entity as? Player ?: return
        if (instance.frozePlayers.contains(player.uniqueId)) e.isCancelled = true
    }

    @EventHandler
    fun onDrop(e: PlayerDropItemEvent) {
        if (instance.frozePlayers.contains(e.player.uniqueId)) e.isCancelled = true
    }
}