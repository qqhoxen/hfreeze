package my.qqhoxen.hFreeze.events

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerGameModeChangeEvent

class PlayerGamemodeHandler : Listener {
    @EventHandler
    fun onPlayerGamemodeChange(e: PlayerGameModeChangeEvent) {
        if (instance.frozePlayers.contains(e.player.uniqueId)) e.isCancelled = true
    }
}