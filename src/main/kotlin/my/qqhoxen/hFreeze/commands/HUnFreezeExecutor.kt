package my.qqhoxen.hFreeze.commands

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HUnFreezeExecutor : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>): Boolean {
        if (args.isEmpty() || sender !is Player) return true
        val player = args[0].let { Bukkit.getPlayer(it) } ?: return true
        instance.frozePlayers.find { it == player.uniqueId }?.let { instance.frozePlayers.remove(it) }
        instance.frozePlayersNames.contains(player.uniqueId).let { instance.frozePlayersNames.remove(player.uniqueId) }
        return true
    }
}