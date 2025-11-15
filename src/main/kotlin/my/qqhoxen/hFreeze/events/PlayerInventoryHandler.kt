package my.qqhoxen.hFreeze.events

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryOpenEvent

class PlayerInventoryHandler : Listener {
    @EventHandler
    fun onInventoryOpen(e: InventoryOpenEvent) {
        val player = e.player as? Player ?: return
        if (instance.frozePlayers.contains(player.uniqueId)) e.isCancelled = true
    }

    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent) {
        val player = e.whoClicked as? Player ?: return
        if (instance.frozePlayers.contains(player.uniqueId)) e.isCancelled = true
    }

    @EventHandler
    fun onInventoryDrag(e: InventoryDragEvent) {
        val player = e.whoClicked as? Player ?: return
        if (instance.frozePlayers.contains(player.uniqueId)) e.isCancelled = true
    }
}