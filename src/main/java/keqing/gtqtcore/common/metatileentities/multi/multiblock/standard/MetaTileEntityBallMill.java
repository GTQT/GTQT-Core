package keqing.gtqtcore.common.metatileentities.multi.multiblock.standard;

import gregicality.multiblocks.api.capability.impl.GCYMMultiblockRecipeLogic;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregtech.api.capability.IMultiblockController;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import keqing.gtqtcore.api.capability.IBall;
import keqing.gtqtcore.api.metatileentity.multiblock.GTQTMultiblockAbility;
import keqing.gtqtcore.api.recipes.properties.GrindBallTierProperty;
import keqing.gtqtcore.client.textures.GTQTTextures;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.ISA_MILL_GRINDER;

public class MetaTileEntityBallMill extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityBallMill(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                ISA_MILL_GRINDER,
                RecipeMaps.MACERATOR_RECIPES
        });
        this.recipeMapWorkable = new BallMillLogic(this);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("粉碎！粉碎！", new Object[0]));
    }


    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("AAAAAAAAAAAA", "            ", "            ", "  B         ", " B          ", " B          ", "            ", "            ")
                .aisle("A          A", "            ", " B          ", " CDDCDDCDDC ", " CDDCDDCDDC ", " CDDCDDCDDC ", " B          ", "            ")
                .aisle("A          A", "AB         A", "ACDDCDDCDDCA", "AD        DA", "AD        DA", "AD        DA", " CDDCDDCDDC ", " B          ")
                .aisle("A          A", " B          ", " CDDCDDCDDC ", "AD        DA", "EEEEEEEEEEEH", "AD        DA", " CDDCDDCDDC ", " B          ")
                .aisle("A          A", "AB         A", "ACDDCDDCDDCA", "AD        DA", "AD        DA", "AD        DA", " CDDCDDCDDC ", " B          ")
                .aisle("A          A", "            ", " B          ", " CDDCDDCDDC ", " CDDCDDCDDC ", " CDDCDDCDDC ", " B          ", "            ")
                .aisle("AFFFAAAAAAAA", " FSF        ", "            ", "  B         ", " B          ", " B          ", "            ", "            ")
                .where('S', selfPredicate())
                .where('A', getFramePredicate())
                .where('B', states(getPipeCasingState2()))
                .where('C', states(getPipeCasingState()))
                .where('D', states(getCasingState()))
                .where('E', states(getGrateState()))
                .where('F', states(getCasingState())
                        .or(autoAbilities())
                )
                .where('H', states(getGrateState())
                        .or(abilities(GTQTMultiblockAbility.GRINDBALL_MULTIBLOCK_ABILITY).setExactLimit(1))
                )
                .build();
    }

    private IBlockState getGrateState() {
        return MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING);
    }

    public IBall getBallHolder() {
        List<IBall> abilities = getAbilities(GTQTMultiblockAbility.GRINDBALL_MULTIBLOCK_ABILITY);
        if (abilities.isEmpty())
            return null;
        return abilities.get(0);
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    public TraceabilityPredicate getFramePredicate() {
        return frames(Materials.Steel);
    }

    protected IBlockState getPipeCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    protected IBlockState getPipeCasingState2() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
    }

    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityBallMill(metaTileEntityId);
    }

    @Override
    public void update() {
        super.update();
    }


    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GTQTTextures.ALGAE_FARM_OVERLAY;
    }


    public class BallMillLogic extends GCYMMultiblockRecipeLogic {

        private final MetaTileEntityBallMill metaTileEntity;

        private int current_grind_ball_tier;

        public BallMillLogic(MetaTileEntityBallMill tileEntity) {
            super(tileEntity);
            this.metaTileEntity = tileEntity;
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            return super.checkRecipe(recipe) && (recipe.getProperty(GrindBallTierProperty.getInstance(), 0) == metaTileEntity.getBallHolder().getGrinderTier());
        }

        @Override
        protected void setupRecipe(Recipe recipe) {
            super.setupRecipe(recipe);
            this.current_grind_ball_tier = recipe.getProperty(GrindBallTierProperty.getInstance(), 0);
        }

        protected boolean canProgressRecipe() {
            return (super.canProgressRecipe() && !((IMultiblockController) this.metaTileEntity).isStructureObstructed() && this.checkGrindBallTier());
        }

        private boolean checkGrindBallTier() {
            return this.metaTileEntity.getBallHolder().getGrinderTier() == this.current_grind_ball_tier;
        }

        @Nonnull
        @Override
        public NBTTagCompound serializeNBT() {
            NBTTagCompound tag = super.serializeNBT();
            tag.setInteger("current_grind_ball_tier", this.current_grind_ball_tier);
            return tag;
        }

        @Override
        public void deserializeNBT(@Nonnull NBTTagCompound compound) {
            super.deserializeNBT(compound);
            this.current_grind_ball_tier = compound.getInteger("current_grind_ball_tier");
        }

        @Override
        protected void completeRecipe() {
            super.completeRecipe();
            if(recipeMapWorkable.recipeMap==ISA_MILL_GRINDER) this.metaTileEntity.getBallHolder().damageGrinder(10);
        }
    }
}