package keqing.gtqtcore.integration.theoneprobe;


import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.util.GTUtility;
import keqing.gtqtcore.GTQTCore;
import keqing.gtqtcore.common.metatileentities.multi.multiblock.standard.MetaTileEntityEvaporationPool;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import javax.annotation.Nonnull;
import java.util.Arrays;

import static keqing.gtqtcore.GTQTCore.MODID;

public class EvaporationPoolInfoProvider implements IProbeInfoProvider {

    @Override
    public String getID() {
        return GTQTCore.MODID + ":evaporation_pool_provider";
    }

    @Override
    public void addProbeInfo(@Nonnull ProbeMode mode, @Nonnull IProbeInfo probeInfo, @Nonnull EntityPlayer player,
                             @Nonnull World world, @Nonnull IBlockState blockState, @Nonnull IProbeHitData data) {
        if (GTUtility.getMetaTileEntity(world, data.getPos()) instanceof MetaTileEntityEvaporationPool evapPool) {
            probeInfo.text(TextStyleClass.INFO + "{*gtqtcore.top.evaporation_pool_heated_preface*}" + " " + (evapPool.isHeating() ?
                    (TextFormatting.GREEN + "{*gtqtcore.multiblock.evaporation_pool.is_heating*}") :
                    (TextFormatting.RED + "{*gtqtcore.multiblock.evaporation_pool.is_not_heating*}")));
            probeInfo.text(TextStyleClass.INFO + "{*gtqtcore.top.evaporation_pool.exposed_blocks*}" + " "
                    + (TextFormatting.YELLOW + String.valueOf(evapPool.getExposedBlocks())));
            probeInfo.text(TextStyleClass.INFO + "{*gtqtcore.top.evaporation_pool.average_speed*}" + " "
                    + (TextFormatting.AQUA + (String.format("%.2f", evapPool.getAverageSpeed()))) + (TextFormatting.WHITE + "x"));

        }
    }
}