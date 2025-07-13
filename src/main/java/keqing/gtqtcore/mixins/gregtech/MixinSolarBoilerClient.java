package keqing.gtqtcore.mixins.gregtech;

import gregtech.common.metatileentities.steam.boiler.SteamSolarBoiler;
import keqing.gtqtcore.api.nerf.INerfed;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(SteamSolarBoiler.class)
public abstract class MixinSolarBoilerClient implements INerfed {
    
    @Override
    public boolean isNerfed() {
        return true;
    }


    public void addInformation(ItemStack stack, World player, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gtqtcore.mixin.nerf.steam.solar.detail"));
    }
}
