package my.qqhoxen.hFreeze.commands

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HFreezeExecutor : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>): Boolean {
        if (args.isEmpty() || sender !is Player) return true
        if (!sender.isOp) return true
        val player = args[0].let { Bukkit.getPlayer(it) } ?: return true
        instance.frozePlayers.add(player.uniqueId)
        instance.frozePlayersNames[player.uniqueId] = player.name
        return true
    }
}