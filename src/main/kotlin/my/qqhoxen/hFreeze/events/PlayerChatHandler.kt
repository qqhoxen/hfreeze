package my.qqhoxen.hFreeze.events

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class PlayerChatHandler : Listener {
    @EventHandler
    fun onPlayerChat(e: AsyncPlayerChatEvent) {
        if (instance.frozePlayers.contains(e.player.uniqueId)) e.isCancelled = true
    }
    @EventHandler
    fun onPlayerCommand(e: PlayerCommandPreprocessEvent) {
        if (instance.frozePlayers.contains(e.player.uniqueId)) {
            e.isCancelled = true
        }
    }
}