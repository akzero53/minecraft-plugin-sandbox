package com.github.akzero53;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * plugin.yml設定一覧ページ: http://minecraftjp.info/modding/index.php/Plugin.ymlの設定一覧
 */
public class SandboxPlugin extends JavaPlugin {

    private Logger logger = getLogger();

    @Override
    public void onEnable() {
        logger.info("Minecraft Sandbox Plugin Enabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return false;
    }

    @Override
    public void onDisable() {
        logger.info("Minecraft Sandbox Plugin Disabled.");
    }
}
