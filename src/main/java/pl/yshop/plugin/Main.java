package pl.yshop.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.yshop.plugin.api.ApiRequest;
import pl.yshop.plugin.config.Configuration;
import pl.yshop.plugin.objects.ElementUtil;
import pl.yshop.plugin.tasks.CommandsExecutionTask;

public final class Main extends JavaPlugin {
    private static Main instance;
    private Configuration configuration;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        this.configuration = new  Configuration(this);
        new ElementUtil().loadElements(ApiRequest.getPendingTransactions());
        long checkEvery = 30 * 20;
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new CommandsExecutionTask(this), checkEvery, checkEvery);

        log("&a        ____  _                 ____  _             _       ");
        log("&a  _   _/ ___|| |__   ___  _ __ |  _ \\| |_   _  __ _(_)_ __  ");
        log("&a | | | \\___ \\| '_ \\ / _ \\| '_ \\| |_) | | | | |/ _` | | '_ \\ ");
        log("&a | |_| |___) | | | | (_) | |_) |  __/| | |_| | (_| | | | | |");
        log("&a  \\__, |____/|_| |_|\\___/| .__/|_|   |_|\\__,_|\\__, |_|_| |_|");
        log("&a  |___/                  |_|                  |___/         ");
        log("");
        log("&8&l>> &aPlugin enabled!");
        log("");
    }

    @Override
    public void onDisable() {
        instance = null;
        log("&c        ____  _                 ____  _             _       ");
        log("&c  _   _/ ___|| |__   ___  _ __ |  _ \\| |_   _  __ _(_)_ __  ");
        log("&c | | | \\___ \\| '_ \\ / _ \\| '_ \\| |_) | | | | |/ _` | | '_ \\ ");
        log("&c | |_| |___) | | | | (_) | |_) |  __/| | |_| | (_| | | | | |");
        log("&c  \\__, |____/|_| |_|\\___/| .__/|_|   |_|\\__,_|\\__, |_|_| |_|");
        log("&c  |___/                  |_|                  |___/         ");
        log("");
        log("&8&l>> &cPlugin disabled!");
        log("");
    }

    public static Main getInstance(){
        return instance;
    }
    public Configuration getConfiguration(){
        return configuration;
    }
    public static void log(String text){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
}