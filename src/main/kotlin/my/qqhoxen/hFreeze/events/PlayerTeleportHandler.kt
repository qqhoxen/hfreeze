package my.qqhoxen.hFreeze.events

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerTeleportEvent

class PlayerTeleportHandler : Listener {
    @EventHandler
    fun onPlayerTeleport(e: PlayerTeleportEvent) {
        if (instance.frozePlayers.contains(e.player.uniqueId)) e.isCancelled = true
    }
}