package pl.yshop.plugin.tasks;

import org.bukkit.Server;
import pl.yshop.plugin.Main;

public class CommandsExecutionTask extends ShopExecutionTask {
    private final Main plugin;
    private final Server server;

    public CommandsExecutionTask(Main plugin) {
        this.plugin = plugin;
        this.server = plugin.getServer();
    }

    @Override
    public void executeCommand(String command) {
        this.server.getScheduler().runTask(this.plugin, () -> this.server.dispatchCommand(this.server.getConsoleSender(), command));
    }
}