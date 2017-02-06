package com.github.akzero53;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * plugin.yml設定一覧ページ: http://minecraftjp.info/modding/index.php/Plugin.ymlの設定一覧
 * SandboxPlugin is same as 'ProjectId'
 *
 */
public class SandboxPlugin extends JavaPlugin implements Listener {

    private final Logger logger = getLogger();

    @Override
    public void onEnable() {
        logger.info("Minecraft Sandbox Plugin Enabled.");
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("create").setExecutor(new CreateBlockExecutor());
    }

    @Override
    public void onDisable() {
        logger.info("Minecraft Sandbox Plugin Disabled.");
    }

    class CreateBlockExecutor implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            logger.info("create");

            // MEMO: falseを返すとusageが表示される。
            return true;
        }
    }
}
