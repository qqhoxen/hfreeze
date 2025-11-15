package my.qqhoxen.hFreeze

import my.qqhoxen.hFreeze.commands.HFreezeCompleter
import my.qqhoxen.hFreeze.commands.HFreezeExecutor
import my.qqhoxen.hFreeze.commands.HUnFreezeCompleter
import my.qqhoxen.hFreeze.commands.HUnFreezeExecutor
import my.qqhoxen.hFreeze.events.PlayerChatHandler
import my.qqhoxen.hFreeze.events.PlayerGamemodeHandler
import my.qqhoxen.hFreeze.events.PlayerInteractHandler
import my.qqhoxen.hFreeze.events.PlayerInventoryHandler
import my.qqhoxen.hFreeze.events.PlayerItemsHandler
import my.qqhoxen.hFreeze.events.PlayerMoveHandler
import my.qqhoxen.hFreeze.events.PlayerTeleportHandler
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class HFreeze : JavaPlugin() {

    val frozePlayers = mutableListOf<UUID>()
    val frozePlayersNames = mutableMapOf<UUID, String>()

    companion object { lateinit var instance: HFreeze}

    override fun onEnable() {
        instance = this
        getCommand("freeze")?.setExecutor(HFreezeExecutor())
        getCommand("freeze")?.tabCompleter = HFreezeCompleter()
        getCommand("unfreeze")?.setExecutor(HUnFreezeExecutor())
        getCommand("unfreeze")?.tabCompleter = HUnFreezeCompleter()
        Bukkit.getPluginManager().registerEvents(PlayerTeleportHandler(), this)
        Bukkit.getPluginManager().registerEvents(PlayerMoveHandler(), this)
        Bukkit.getPluginManager().registerEvents(PlayerGamemodeHandler(), this)
        Bukkit.getPluginManager().registerEvents(PlayerChatHandler(), this)
        Bukkit.getPluginManager().registerEvents(PlayerInventoryHandler(), this)
        Bukkit.getPluginManager().registerEvents(PlayerItemsHandler(), this)
        Bukkit.getPluginManager().registerEvents(PlayerInteractHandler(), this)
    }
}
