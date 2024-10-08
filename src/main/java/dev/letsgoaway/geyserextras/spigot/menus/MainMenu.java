package dev.letsgoaway.geyserextras.spigot.menus;

import dev.letsgoaway.geyserextras.spigot.BedrockPlayer;
import dev.letsgoaway.geyserextras.spigot.Config;
import dev.letsgoaway.geyserextras.spigot.GeyserExtras;
import dev.letsgoaway.geyserextras.spigot.api.APIType;
import dev.letsgoaway.geyserextras.spigot.form.BedrockContextMenu;
import dev.letsgoaway.geyserextras.spigot.form.elements.Button;
import dev.letsgoaway.geyserextras.spigot.menus.quickmenu.QuickMenu;
import dev.letsgoaway.geyserextras.spigot.parity.java.tablist.TabList;
import org.geysermc.cumulus.util.FormImage;

public class MainMenu extends BedrockContextMenu {
    public MainMenu(BedrockPlayer bplayer) {
        super("Geyser扩展");
        if (bplayer.player.hasPermission("geyser.command.offhand")) {
            add(new Button("副手", FormImage.Type.PATH, "textures/ui/move.png", () -> {
                bplayer.player.performCommand("geyser offhand");
            }));
        }
        add(new Button("重新连接", FormImage.Type.PATH, "textures/ui/refresh_hover.png", () -> {
            GeyserExtras.bedrockAPI.reconnect(bplayer.player.getUniqueId());
        }));
        if (bplayer.player.hasPermission("geyser.command.tooltips")) {
            add(new Button("高级工具提示", FormImage.Type.PATH, "textures/ui/infobulb.png", () -> {
                bplayer.player.performCommand("geyser tooltips");
            }));
        }
        if (bplayer.player.hasPermission("geyser.command.advancements")) {
            add(new Button("成就", FormImage.Type.PATH, "textures/ui/achievements.png", () -> {
                bplayer.player.performCommand("geyser advancements");
            }));
        }
        if (bplayer.player.hasPermission("geyser.command.statistics")) {
            add(new Button("统计", FormImage.Type.PATH, "textures/ui/world_glyph_color_2x_black_outline.png", () -> {
                bplayer.player.performCommand("geyser statistics");
            }));
        }
        if (bplayer.player.hasPermission("geyserextras.playerlist")) {
            add(new Button("玩家列表", FormImage.Type.PATH, "textures/ui/Local.png", () -> {
                new TabList(bplayer);
            }));
        }
        if (GeyserExtras.bedrockAPI.supports(APIType.GEYSER) || Config.proxyMode) {
            add(new Button("快速菜单", FormImage.Type.PATH, "textures/ui/emote_wheel_updated_base.png", () -> {
                new QuickMenu(bplayer).show(bplayer);
            }));
        }
        if (GeyserExtras.bedrockAPI.supports(APIType.GEYSER) && !Config.packsArray.isEmpty()) {
            add(new Button("资源包", FormImage.Type.PATH, "textures/ui/glyph_resource_pack.png", () -> {
                new OptionalPacks(bplayer).show(bplayer);
            }));
        }
        add(new Button("设置", FormImage.Type.PATH, "textures/ui/settings_glyph_color_2x.png", () -> {
            new SettingsMenu(bplayer).show(bplayer);
        }));
        this.show(bplayer);
    }

}
