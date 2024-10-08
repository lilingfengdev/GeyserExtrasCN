package dev.letsgoaway.geyserextras.spigot.parity.java.tablist;

import dev.letsgoaway.geyserextras.spigot.BedrockPlayer;
import dev.letsgoaway.geyserextras.spigot.form.BedrockForm;
import dev.letsgoaway.geyserextras.spigot.form.elements.TextInput;
import org.bukkit.entity.Player;

public class TabListMessageUI extends BedrockForm {
    public TabListMessageUI(Player recipient, BedrockPlayer bedrockPlayer){
        super("");
        onClose = ()->{
            new TabListPlayerDetails(bedrockPlayer, recipient);
        };
        add(new TextInput("信息发送: " + recipient.getName(), (s)->{
            bedrockPlayer.player.performCommand("msg "+recipient.getName()+" "+s);
        }));
    }
}
