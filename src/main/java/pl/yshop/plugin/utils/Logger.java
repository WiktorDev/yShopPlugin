package pl.yshop.plugin.utils;

import org.bukkit.Bukkit;
import java.util.Date;

public class Logger {
    public static void logInfo(String text){
        Bukkit.getConsoleSender().sendMessage("§b[INFO] - [" + new Date() +"] - " + text);
    }
    public static void logWarning(String text){
        Bukkit.getConsoleSender().sendMessage("§e[WARNING] - [" + new Date() +"] - " + text);
    }
    public static void logError(String text){
        Bukkit.getConsoleSender().sendMessage("§c[ERROR] - [" + new Date() +"] - " + text);
    }
}