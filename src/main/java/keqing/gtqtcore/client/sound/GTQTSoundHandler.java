package keqing.gtqtcore.client.sound;

import keqing.gtqtcore.GTQTCore;
import net.minecraft.util.SoundEvent;

public class GTQTSoundHandler {

    public static SoundEvent STELLAR_FORGE;

    public static void register() {
        STELLAR_FORGE = GTQTCore.soundManager.registerSound("tick.stellar_forge");
    }
}
