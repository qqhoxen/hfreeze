package my.qqhoxen.hFreeze.commands

import my.qqhoxen.hFreeze.HFreeze.Companion.instance
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class HUnFreezeCompleter : TabCompleter {
    override fun onTabComplete(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>): List<String?>? {
        if (args.isEmpty() || sender !is Player) return null
        val completions = mutableListOf<String>()

        if (args.size == 1) {
            instance.frozePlayers.forEach { completions.add(instance.frozePlayersNames[it] ?: it.toString()) }
            return completions.filter { it.startsWith(args[0], ignoreCase = true) }.toMutableList()
        }

        return listOf()
    }
}

