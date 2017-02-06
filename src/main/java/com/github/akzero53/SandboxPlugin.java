package com.github.akzero53;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
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
        this.getCommand("hoge").setExecutor(new HogeCommandExecutor());
        this.getCommand("fuga").setExecutor(new FugaCommandExecutor());
        this.getCommand("piyo").setExecutor(new PiyoCommandExecutor());
    }

    @EventHandler
    public void playerMoveHandler(PlayerMoveEvent event) {
        logger.info(event.getEventName());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        logger.info(cmd.getName());
        Boolean isPlayer = sender instanceof Player;
        logger.info("is sender player: " + isPlayer);
        return false;
    }

    @Override
    public void onDisable() {
        logger.info("Minecraft Sandbox Plugin Disabled.");
    }

    class HogeCommandExecutor implements CommandExecutor {
//        private final SandboxPlugin plugin;
//
//        public HogeCommandExecutor(SandboxPlugin plugin) {
//            this.plugin = plugin;
//        }

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            logger.info("hoge");
            return false;
        }
    }

    class FugaCommandExecutor implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            logger.info("fuga");
            return false;
        }
    }

    class PiyoCommandExecutor implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            logger.info("piyo");
            return false;
        }
    }
}
