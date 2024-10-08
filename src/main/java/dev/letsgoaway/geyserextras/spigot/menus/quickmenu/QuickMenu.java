package dev.letsgoaway.geyserextras.spigot.menus.quickmenu;

import dev.letsgoaway.geyserextras.spigot.BedrockPlayer;
import dev.letsgoaway.geyserextras.spigot.parity.bedrock.EmoteUtils;
import dev.letsgoaway.geyserextras.spigot.form.BedrockContextMenu;
import dev.letsgoaway.geyserextras.spigot.form.elements.Button;
import org.geysermc.cumulus.util.FormImage;

public class QuickMenu extends BedrockContextMenu {
    private static String getContent(BedrockPlayer bedrockPlayer) {
        return "绑定 | 操作\n\n" +
                EmoteUtils.getEmoteName(bedrockPlayer.quickMenuList.get(0))
                + "\n\n\uF840 | " + bedrockPlayer.quickMenuActions.get(0) + "\n\n" +
                EmoteUtils.getEmoteName(bedrockPlayer.quickMenuList.get(1))
                + "\n\n\uF841 | " + bedrockPlayer.quickMenuActions.get(1) + "\n\n" +
                EmoteUtils.getEmoteName(bedrockPlayer.quickMenuList.get(2))
                + "\n\n\uF842 | " + bedrockPlayer.quickMenuActions.get(2) + "\n\n" +
                EmoteUtils.getEmoteName(bedrockPlayer.quickMenuList.get(3))
                + "\n\n\uF843 | " + bedrockPlayer.quickMenuActions.get(3) + "\n\n";

    }

    public QuickMenu(BedrockPlayer bplayer) {
        super("快速菜单", getContent(bplayer));
        add(new Button("绑定", FormImage.Type.PATH, "textures/ui/emote_wheel_updated_base.png", () -> {
            new QuickMenuBindings(bplayer).show(bplayer);
        }));
        add(new Button("操作", FormImage.Type.PATH, "textures/ui/settings_glyph_color_2x.png", () -> {
            new QuickMenuActions(bplayer).show(bplayer);
        }));
    }
}
