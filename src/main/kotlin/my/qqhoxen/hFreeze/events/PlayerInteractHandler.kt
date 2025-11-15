package my.qqhoxen.hFreeze.events

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent

class PlayerInteractHandler {
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (instance.frozePlayers.contains(e.player.uniqueId)) e.isCancelled = true
    }
}