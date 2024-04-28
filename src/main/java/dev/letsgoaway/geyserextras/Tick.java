package dev.letsgoaway.geyserextras;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class Tick {
    public static void runOnNext(Runnable task){
        Bukkit.getScheduler().scheduleSyncDelayedTask(GeyserExtras.plugin, task);
    }

    public static BukkitTask runIn(long ticks, Runnable task){
        return Bukkit.getScheduler().runTaskLater(GeyserExtras.plugin, task, ticks);
    }

    public static BukkitTask runAsync(Runnable task){
        return Bukkit.getScheduler().runTaskAsynchronously(GeyserExtras.plugin,task);
    }
    public static long secondsToTicksRounded(float seconds) {
        return Math.round(seconds * Bukkit.getServerTickManager().getTickRate());
    }
    public static float secondsToTicks(float seconds) {
        return seconds * Bukkit.getServerTickManager().getTickRate();
    }
}
