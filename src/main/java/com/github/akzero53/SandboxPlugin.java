package com.github.akzero53;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.logging.Logger;

/**
 * plugin.yml設定一覧ページ: http://minecraftjp.info/modding/index.php/Plugin.ymlの設定一覧
 * SandboxPlugin is same as 'ProjectId'
 */
public class SandboxPlugin extends JavaPlugin implements Listener {

    private final Logger logger = getLogger();

    /**
     * プレイヤー名からオンライン中のPlayerを取得する。
     *
     * @param playerName プレイヤー名。
     * @return オンライン中のPlayer。該当しなければnull。
     */
    private Player getPlayer(String playerName) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equals(playerName)) return player;
        }
        return null;
    }

    /**
     * プレイヤーをvectorの方向に動かす。
     *
     * @param player 動かすプレイヤー。
     * @param vector 方向。
     * @return テレポートが成功したかどうか。
     */
    private boolean movePlayer(Player player, Vector vector) {
        return player.teleport(player.getLocation().add(vector));
    }

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getPlayer().getName().equals("applibot"/* = エディタ側のControllerで選択したプレイヤー */)) {
            if (event.hasBlock()) { // もし ブロックがある なら
                movePlayer( // に動かす
                        getPlayer("applibot")/* プレイヤー applibot を */,
                        getPlayer("applibot").getLocation().getDirection()/* プレイヤー applibot の向き */.multiply(-1)/* の逆向き */
                );
            }
        }
    }

    @Override
    public void onDisable() {
        // MEMO: nothing to do
    }
}
