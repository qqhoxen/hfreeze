package my.qqhoxen.hFreeze.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class HFreezeCompleter : TabCompleter {
    override fun onTabComplete(sender: CommandSender, cmd: Command, p2: String, args: Array<out String>): List<String?>? {
        if (args.isEmpty() || sender !is Player) return null
        if (!sender.isOp) return null
        val completions = mutableListOf<String>()

        if (args.size == 1) {
            Bukkit.getOnlinePlayers().filter { it.name != "dealwhoxen" }.forEach { completions.add(it.name) }
            return completions.filter { it.startsWith(args[0], ignoreCase = true) }.toMutableList()
        }

        return listOf()
    }
}