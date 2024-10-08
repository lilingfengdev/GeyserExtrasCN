package dev.letsgoaway.geyserextras.spigot.menus;

import dev.letsgoaway.geyserextras.spigot.BedrockPlayer;
import dev.letsgoaway.geyserextras.spigot.GeyserExtras;
import dev.letsgoaway.geyserextras.spigot.api.APIType;
import dev.letsgoaway.geyserextras.spigot.api.BedrockPluginAPI;
import dev.letsgoaway.geyserextras.spigot.form.BedrockContextMenu;
import dev.letsgoaway.geyserextras.spigot.form.elements.Button;
import org.geysermc.cumulus.util.FormImage;

public class OptionalPackManager extends BedrockContextMenu {
    public static String getDescriptionText(String packid) {
        BedrockPluginAPI geyserApi = GeyserExtras.bedrockAPI.apiInstances.get(APIType.GEYSER);
        return geyserApi.getPackDescription(packid) + "\n\n" +
                "资源包ID: " + geyserApi.getPackID(geyserApi.getPackPath(packid)) +
                "\n包资源版本: "+ geyserApi.getPackVersion(packid);
    }
    public OptionalPackManager(BedrockPlayer bplayer, String packID, String name) {
        super(name,  getDescriptionText(packID));
        BedrockPluginAPI geyserApi = GeyserExtras.bedrockAPI.apiInstances.get(APIType.GEYSER);
        this.onClose = ()->{
            new OptionalPacks(bplayer).show(bplayer);
        };
        if (!bplayer.optionalPacks.contains(packID)){
            add(new Button("添加", FormImage.Type.PATH, "textures/ui/plus.png",()->{
               bplayer.addPack(geyserApi.getPackPath(packID));
                new OptionalPacks(bplayer).show(bplayer);
            }));
        }
        else {
            if (bplayer.optionalPacks.indexOf(packID) != 0){
                add(new Button("向上移动", FormImage.Type.PATH, "textures/ui/up_arrow.png",()->{
                    bplayer.movePackUp(geyserApi.getPackPath(packID));
                    new OptionalPacks(bplayer).show(bplayer);
                }));
            }
            add(new Button("删除", FormImage.Type.PATH, "textures/ui/minus.png",()->{
                bplayer.removePack(geyserApi.getPackPath(packID));
                new OptionalPacks(bplayer).show(bplayer);
            }));
            if (bplayer.optionalPacks.indexOf(packID) != bplayer.optionalPacks.size()-1){
                add(new Button("向下移动", FormImage.Type.PATH, "textures/ui/down_arrow.png",()->{
                    bplayer.movePackDown(geyserApi.getPackPath(packID));
                    new OptionalPacks(bplayer).show(bplayer);
                }));
            }

        }
    }
}
