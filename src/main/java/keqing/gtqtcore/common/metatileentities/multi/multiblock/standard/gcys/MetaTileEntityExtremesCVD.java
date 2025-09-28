package keqing.gtqtcore.common.metatileentities.multi.multiblock.standard.gcys;


import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import keqing.gtqtcore.api.capability.IPressureContainer;
import keqing.gtqtcore.api.capability.IPressureMachine;
import keqing.gtqtcore.api.capability.impl.AtmosphericPressureContainer;
import keqing.gtqtcore.api.capability.impl.PressureMultiblockRecipeLogic;
import keqing.gtqtcore.api.metatileentity.multiblock.GTQTMultiblockAbility;
import keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import keqing.gtqtcore.common.block.blocks.BlockPCBFactoryCasing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class MetaTileEntityExtremesCVD extends GCYMRecipeMapMultiblockController implements IPressureMachine {
    private IPressureContainer container;
    public MetaTileEntityExtremesCVD(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                GTQTcoreRecipeMaps.CVD_RECIPES,
                GTQTcoreRecipeMaps.VACUUM_CHAMBER_RECIPES
        });
        this.recipeMapWorkable = new PressureMultiblockRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityExtremesCVD(metaTileEntityId);
    }
    @Override
    protected void initializeAbilities() {
        super.initializeAbilities();
        List<IPressureContainer> list = getAbilities(GTQTMultiblockAbility.PRESSURE_CONTAINER);
        if (list.isEmpty()) {
            this.container = new AtmosphericPressureContainer(this, 1.0);
        } else {
            this.container = list.get(0);
        }
    }
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(" K        K ", " K        K ", " K        K ", " K        K ", " K        K ", " K        K ", " K        K ", "            ")
                .aisle("NK   KK   KN", "NKKKKKKKKKKN", "NNSSSSSSSSNN", "NNSSSSSSSSNN", "NNSSSSSSSSNN", "NKSSSSSSSSKN", "NKSSSSSSSSKN", "NG        GN")
                .aisle(" K        K ", " KKKKKKKKKK ", " NSEEEEEESN ", " NS      SN ", " NS      SN ", " KJJJJJJJJK ", " KSSSSSSSSK ", " G        G ")
                .aisle(" K        K ", " KKKKKKKKKK ", " NSEEEEEESN ", " NS      SN ", " NS      SN ", " KS      SK ", " KSSSSSSSSK ", " G        G ")
                .aisle(" K        K ", " KKKKKKKKKK ", " NSEEEEEESN ", " NS      SN ", " NS      SN ", " KJJJJJJJJK ", " KSSSSSSSSK ", " G        G ")
                .aisle("NK   KK   KN", "NKKKKKKKKKKN", "NNSSSSSSSSNN", "NNSSSSSSSSNN", "NNSSSSSSSSNN", "NKSSSSSSSSKN", "NKSSSSSSSSKN", "NG        GN")
                .aisle(" K        K ", " K        K ", " K        K ", " C        K ", " K        K ", " K        K ", " K        K ", "            ")

                .where('C', selfPredicate())
                .where(' ', any())
                .where('N', getFramePredicate())
                .where('S', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS)))
                .where('G', states(GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT)))
                .where('J', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE)))
                .where('K', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING))
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('E', states(GTQTMetaBlocks.blockPCBFactoryCasing.getState(BlockPCBFactoryCasing.PCBFactoryCasingType.ADVANCED_SUBSTRATE_CASING)))
                .build();
    }

    private TraceabilityPredicate getFramePredicate() {
        return frames(Materials.NaquadahAlloy);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GCYMTextures.ENGRAVER_CASING;
    }


    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYMTextures.ALLOY_BLAST_SMELTER_OVERLAY;
    }

    @Override
    public IPressureContainer getPressureContainer() {
        return this.container;
    }
}
