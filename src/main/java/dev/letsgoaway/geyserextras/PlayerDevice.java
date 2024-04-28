package dev.letsgoaway.geyserextras;

public enum PlayerDevice {
    UNKNOWN("Unknown"),
    ANDROID("Android"),
    IOS("iOS"),
    OSX("macOS"),
    AMAZON("Amazon"),
    GEARVR("Gear VR"),
    HOLOLENS("Hololens"),
    WINDOWS("Windows"),
    DEDICATED("Dedicated"),
    TVOS("Apple TV"),
    PLAYSTATION("PlayStation"), // Named "PlayStation" and not "PS4" due to backwards compatibility on PlayStation 5.
    SWITCH("Switch"),
    XBOX("Xbox"), // Named "Xbox" and not "Xbox One" due to backwards compatibility on Xbox Series X/S.
    WINDOWS_PHONE("Windows Phone"),
    JAVA("Java");

    public final String displayName;

    PlayerDevice(String displayName) {
        this.displayName = displayName;
    }

    public static PlayerDevice getPlayerDevice(BedrockPlayer bedrockPlayer) {
       return GeyserExtras.bedrockAPI.getPlayerDevice(bedrockPlayer);
    }
}