package keqing.gtqtcore.common.block.blocks;

import gregtech.api.GTValues;
import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;
import keqing.gtqtcore.api.blocks.ITierGlassBlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class BlockMultiblockGlass extends VariantBlock<BlockMultiblockGlass.CasingType> {


    public BlockMultiblockGlass() {
        super(Material.IRON);
        this.setTranslationKey("multiblock_glass");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.GLASS);
        this.setHarvestLevel(ToolClasses.PICKAXE, 1);
        this.setDefaultState(this.getState(CasingType.ADV_MACHINE_GLASS));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state,
                                    @Nonnull IBlockAccess world,
                                    @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }


    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canRenderInLayer(@Nonnull IBlockState state, @Nonnull BlockRenderLayer layer) {
        return super.canRenderInLayer(state, layer);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(@Nonnull IBlockState state, IBlockAccess world, BlockPos pos,
                                        @Nonnull EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    public static enum CasingType  implements IStringSerializable, ITierGlassBlockState {
        ADV_MACHINE_GLASS("adv_machine_glass"),
        ADV_MACHINE_GLASS_R("adv_machine_glass_r"),
        ADV_MACHINE_GLASS_B("adv_machine_glass_b"),
        ADV_MACHINE_GLASS_G("adv_machine_glass_g"),
        ADV_MACHINE_GLASS_P("adv_machine_glass_p"),
        ADV_MACHINE_GLASS_O("adv_machine_glass_o"),
        DV_MACHINE_GLASS_PR("adv_machine_glass_pr"),
        TECH_FUSION_GLASS_IV("tech_fusion_glass_4"),
        TECH_FUSION_GLASS_V("tech_fusion_glass_5"),
        TECH_FUSION_GLASS_VI("tech_fusion_glass_6"),
        UU_GALSS("uu_glass_block"),
        COPY_GALSS("copy_glass_block"),
        ANTIMATTER_CONTAINMENT_CASING("antimatter_containment_casing"),
        ;
        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
        @Override
        public boolean isOpticalGlass() {
            return false;
        }
        public int getGlassTier() {
            return switch (getName()) {
                case ("uu_glass_block"), ("copy_glass_block") -> GTValues.ZPM;
                case ("boron_silicate_glass") -> GTValues.MV;
                case ("adv_machine_glass"), ("adv_machine_glass_r"), ("adv_machine_glass_b"), ("adv_machine_glass_g"), ("adv_machine_glass_p") , ("adv_machine_glass_o"), ("adv_machine_glass_pr")-> GTValues.UV;
                case ("tech_fusion_glass_4") -> GTValues.UHV;
                case ("tech_fusion_glass_5") -> GTValues.UEV;
                case ("tech_fusion_glass_6") -> GTValues.UIV;
                default -> GTValues.HV;
            };
        }
    }
}