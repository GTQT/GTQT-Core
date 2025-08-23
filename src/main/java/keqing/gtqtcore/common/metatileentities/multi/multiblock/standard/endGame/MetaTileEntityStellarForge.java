package keqing.gtqtcore.common.metatileentities.multi.multiblock.standard.endGame;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.properties.impl.TemperatureProperty;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.utils.TooltipHelper;
import keqing.gtqtcore.api.blocks.impl.WrappedIntTired;
import keqing.gtqtcore.api.capability.IWarpSwarm;
import keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps;
import keqing.gtqtcore.api.utils.GTQTUtil;
import keqing.gtqtcore.client.textures.GTQTTextures;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import keqing.gtqtcore.common.block.blocks.BlockMultiblockCasing4;
import keqing.gtqtcore.common.block.blocks.BlockMultiblockCasing7;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static keqing.gtqtcore.api.metatileentity.multiblock.GTQTMultiblockAbility.WARP_SWARM_MULTIBLOCK_ABILITY;
import static keqing.gtqtcore.api.predicate.TiredTraceabilityPredicate.CP_FU_CASING;
import static keqing.gtqtcore.api.unification.GTQTMaterials.CosmicNeutronium;
import static keqing.gtqtcore.common.block.blocks.BlockMultiblockCasing7.CasingType.ELECTROMAGNETIC_ACCELERATION_PIPE_BOX;
import static keqing.gtqtcore.common.block.blocks.BlockMultiblockGlass.CasingType.ANTIMATTER_CONTAINMENT_CASING;
import static keqing.gtqtcore.common.block.blocks.BlockQuantumCasing.CasingType.*;
import static net.minecraft.util.text.TextFormatting.GRAY;
import static net.minecraft.util.text.TextFormatting.GREEN;

public class MetaTileEntityStellarForge extends MultiMapMultiblockController {
    private int coilTier;

    public MetaTileEntityStellarForge(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                GTQTcoreRecipeMaps.STELLAR_FORGE_RECIPES,

        });
        this.recipeMapWorkable = new StellarForgeRecipeLogic(this);
    }

    private static IBlockState geGlassState() {
        return GTQTMetaBlocks.blockMultiblockGlass.getState(ANTIMATTER_CONTAINMENT_CASING);
    }

    private static IBlockState getCasingState() {
        return GTQTMetaBlocks.blockQuantumCasing.getState(HIGH_ENERGY_CASING);
    }

    private static IBlockState getPipeBoxState() {
        return GTQTMetaBlocks.blockMultiblockCasing7.getState(ELECTROMAGNETIC_ACCELERATION_PIPE_BOX);
    }

    private static IBlockState getFilterState() {
        return GTQTMetaBlocks.blockMultiblockCasing4.getState(BlockMultiblockCasing4.TurbineCasingType.ADVANCED_FILTER_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return GTQTMetaBlocks.blockQuantumCasing.getState(DIMENSIONAL_INJECTION_CASING);
    }

    private static IBlockState getCoilState() {
        return GTQTMetaBlocks.blockMultiblockCasing7.getState(BlockMultiblockCasing7.CasingType.PROTOMATTER_ACTIVATION_COIL);
    }

    private static IBlockState getThirdCasingState() {
        return GTQTMetaBlocks.blockQuantumCasing.getState(DIMENSIONAL_BRIDGE_CASING);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityStellarForge(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);

        Object coilTier = context.get("FUTieredStats");
        this.coilTier = GTQTUtil.getOrDefault(() -> coilTier instanceof WrappedIntTired,
                () -> ((WrappedIntTired) coilTier).getIntTier(), 0);

    }

    @Override
    public boolean checkRecipe(Recipe recipe,
                               boolean consumeIfSuccess) {
        return this.coilTier * 2500 >= recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("         SSSSSSS         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("       SSGGGGGGGSS       ", "         AAAAAAA         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("     SSGGS AGA SGGSS     ", "       AAS     SAA       ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "         S     S         ", "         SSSSSSS         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("    SGGSSS AGA SSSGGS    ", "     AA SS     SS AA     ", "         S     S         ", "         S     S         ", "         S     S         ", "         S     S         ", "         SBBBBBS         ", "         SARRRAS         ", "        SSAAAAASS        ", "       SSS     SSS       ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("   SGSS    AGA    SSGS   ", "    A               A    ", "                         ", "                         ", "                         ", "                         ", "        BBGGGGGBB        ", "        AAAAAAAAA        ", "        AAAAAAAAA        ", "     SS           SS     ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("  SGS      AGA      SGS  ", "   A        A        A   ", "                         ", "                         ", "                         ", "                         ", "      BBGG     GGBB      ", "      AAAA     AAAA      ", "      AAAA  S  AAAA      ", "    S               S    ", "                         ", "                         ", "                         ", "                         ", "            R            ", "                         ")
                .aisle("  SGS      AGA      SGS  ", "   A       AAA       A   ", "            S            ", "            S            ", "            S            ", "            S            ", "     BGG    S    GGB     ", "     AAA    S    AAA     ", "     AAA   SSS   AAA     ", "    S       S       S    ", "            S            ", "            S            ", "            S            ", "            S            ", "            D            ", "                         ")
                .aisle(" SGS       AGA       SGS ", "  A         A         A  ", "                         ", "                         ", "                         ", "                         ", "     BG           GB     ", "     AA           AA     ", "     AA     S     AA     ", "   S                 S   ", "                         ", "                         ", "                         ", "                         ", "            D            ", "                         ")
                .aisle(" SGS       AGA       SGS ", "  AS                 SA  ", "                         ", "                         ", "                         ", "                         ", "    BG             GB    ", "    AA      Q      AA    ", "   SAA     QQQ     AAS   ", "   S        Q        S   ", "                         ", "                         ", "                         ", "                         ", "           SDS           ", "                         ")
                .aisle("SGSS       AGA       SSGS", " ASS        S        SSA ", "   S                 S   ", "   S                 S   ", "   S                 S   ", "   S        Q        S   ", "   SBG     BQB     GBS   ", "   SAA    BBABB    AAS   ", "  SSAA   QQAAAQQ   AASS  ", "  SS      BBABB      SS  ", "           BQB           ", "            Q            ", "                         ", "                         ", "         SS D SS         ", "                         ")
                .aisle("SGS       AAGAA       SGS", " A          S          A ", "            S            ", "                         ", "                         ", "           BQB           ", "   BG     B A B     GB   ", "   AA    B  Z  B    AA   ", "   AA    QA Z AQ    AA   ", "  S      B  Z  B      S  ", "          B A B          ", "           BQB           ", "                         ", "                         ", "         S  D  S         ", "                         ")
                .aisle("SGAAAAAAAAAGDGAAAAAAAAAGS", " A    A    ADA    A    A ", "           SAS           ", "           SAS           ", "           SQS           ", "          BSASB          ", "   BG    B SZS B    GB   ", "   RA    B SZS B    AR   ", "   AA S QA ZZZ AQ S AA   ", "  S      B SZS B      S  ", "         B SZS B         ", "          BSASB          ", "           SQS           ", "           S S           ", "        S  SDS  S        ", "            S            ")
                .aisle("SGGGGGGGGGGDDDGGGGGGGGGGS", " A   AAA SSDDDSS AAA   A ", "      S   SADAS   S      ", "      S    ADA    S      ", "      S    QGQ    S      ", "      S  QQAGAQQ  S      ", "   BG S  QAZGZAQ  S GB   ", "   RA S QAZZGZZAQ S AR   ", "   AASSSQAZZGZZAQSSSAA   ", "  S   S QAZZGZZAQ S   S  ", "      S  QAZGZAQ  S      ", "      S  QQAGAQQ  S      ", "      S    QGQ    S      ", "      S     G     S      ", "     RDDDDDDGDDDDDDR     ", "           SSS           ")
                .aisle("SGAAAAAAAAAGDGAAAAAAAAAGS", " A    A    ADA    A    A ", "           SAS           ", "           SAS           ", "           SQS           ", "          BSASB          ", "   BG    B SZS B    GB   ", "   RA    B SZS B    AR   ", "   AA S QA ZZZ AQ S AA   ", "  S      B SZS B      S  ", "         B SZS B         ", "          BSASB          ", "           SQS           ", "           S S           ", "        S  SDS  S        ", "            S            ")
                .aisle("SGS       AAGAA       SGS", " A          S          A ", "            S            ", "                         ", "                         ", "           BQB           ", "   BG     B A B     GB   ", "   AA    B  Z  B    AA   ", "   AA    QA Z AQ    AA   ", "  S      B  Z  B      S  ", "          B A B          ", "           BQB           ", "                         ", "                         ", "         S  D  S         ", "                         ")
                .aisle("SGSS       AGA       SSGS", " ASS        S        SSA ", "   S                 S   ", "   S                 S   ", "   S                 S   ", "   S        Q        S   ", "   SBG     BQB     GBS   ", "   SAA    BBABB    AAS   ", "  SSAA   QQAAAQQ   AASS  ", "  SS      BBABB      SS  ", "           BQB           ", "            Q            ", "                         ", "                         ", "         SS D SS         ", "                         ")
                .aisle(" SGS       AGA       SGS ", "  AS                 SA  ", "                         ", "                         ", "                         ", "                         ", "    BG             GB    ", "    AA      Q      AA    ", "   SAA     QQQ     AAS   ", "   S        Q        S   ", "                         ", "                         ", "                         ", "                         ", "           SDS           ", "                         ")
                .aisle(" SGS       AGA       SGS ", "  A         A         A  ", "                         ", "                         ", "                         ", "                         ", "     BG           GB     ", "     AA           AA     ", "     AA     S     AA     ", "   S                 S   ", "                         ", "                         ", "                         ", "                         ", "            D            ", "                         ")
                .aisle("  SGS      AGA      SGS  ", "   A       AAA       A   ", "            S            ", "            S            ", "            S            ", "            S            ", "     BGG    S    GGB     ", "     AAA    S    AAA     ", "     AAA   SSS   AAA     ", "    S       S       S    ", "            S            ", "            S            ", "            S            ", "            S            ", "            D            ", "                         ")
                .aisle("  SGS      AGA      SGS  ", "   A        A        A   ", "                         ", "                         ", "                         ", "                         ", "      BBGG     GGBB      ", "      AAAA     AAAA      ", "      AAAA  S  AAAA      ", "    S               S    ", "                         ", "                         ", "                         ", "                         ", "            R            ", "                         ")
                .aisle("   SGSS    AGA    SSGS   ", "    A               A    ", "                         ", "                         ", "                         ", "                         ", "        BBGGGGGBB        ", "        AAAAAAAAA        ", "        AAAAAAAAA        ", "     SS           SS     ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("    SGGSSS AGA SSSGGS    ", "     AA SS     SS AA     ", "         S     S         ", "         S     S         ", "         S     S         ", "         S     S         ", "         SBBBBBS         ", "         SARRRAS         ", "        SSAAAAASS        ", "       SSS     SSS       ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("     SSGGS AGA SGGSS     ", "       AAS     SAA       ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "         S     S         ", "         SSSSSSS         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("       SSGGGGGGGSS       ", "         AAACAAA         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .aisle("         SSSSSSS         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ", "                         ")
                .where('C', this.selfPredicate())
                .where('D', states(getPipeBoxState()))
                .where('B', states(geGlassState()))
                .where('G', states(getFilterState()))
                .where('Q', CP_FU_CASING.get())
                .where('S', frames(CosmicNeutronium))
                .where('R', states(getSecondCasingState()))
                .where('Z', states(getThirdCasingState()))
                .where('A', states(getCasingState())
                        .or(autoAbilities())
                        .or(abilities(MultiblockAbility.INPUT_LASER)
                                .setMaxGlobalLimited(1))
                        .or(abilities(WARP_SWARM_MULTIBLOCK_ABILITY)
                                .setExactLimit(1))
                )
                .where(' ', any())
                .build();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return iMultiblockPart == null ? GTQTTextures.HIGH_ENERGY_CASING : GTQTTextures.DIMENSIONAL_INJECTION_CASING;
    }

    @SideOnly(Side.CLIENT)

    @Override
    protected @NotNull ICubeRenderer getFrontOverlay() {
        return GTQTTextures.DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_OVERLAY;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public boolean shouldShowVoidingModeButton() {
        return true;
    }

    public IWarpSwarm getAbility() {
        if (this.getAbilities(WARP_SWARM_MULTIBLOCK_ABILITY) != null)
            return this.getAbilities(WARP_SWARM_MULTIBLOCK_ABILITY).get(0);
        return null;
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, boolean advanced) {
        tooltip.add(TooltipHelper.BLINKING_RED + I18n.format("聚爆反应堆驱动，创生简并态星浆与时空拓扑元件"));
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(GREEN + I18n.format("-聚变线圈升级："));
        tooltip.add(GRAY + I18n.format("每一级聚变线圈提供2500k的温度"));
        tooltip.add(GREEN + I18n.format("-纳米蜂群仓支持："));
        tooltip.add(GRAY + I18n.format("本设备支持纳米蜂群仓，每完成一次配方会消耗一点耐久（无视并行）"));
        tooltip.add(GRAY + I18n.format("每等级纳米蜂群提供Math.pow(2,tier)*16的并行"));
        tooltip.add(GRAY + I18n.format("每等级纳米蜂群提供5%%的耗时减免"));
        tooltip.add(GREEN + I18n.format("gtqtcore.multiblock.laser_hatch.enable"));
        tooltip.add(GRAY + I18n.format("gtqtcore.multiblock.laser_hatch.tooltip"));
    }

    public class StellarForgeRecipeLogic extends MultiblockRecipeLogic {

        public StellarForgeRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity, true);
        }

        @Override
        public int getParallelLimit() {
            return getAbility().isAvailable() ? getAbility().getWarpSwarmTier() * 16 : super.getParallelLimit();
        }

        @Override
        public void setMaxProgress(int maxProgress) {
            super.setMaxProgress((int) (maxProgress * getTimeBound()));
        }

        public double getTimeBound() {
            if (getAbility().isAvailable()) return (20 - getAbility().getWarpSwarmTier()) / 20.0;
            return 1;
        }

        @Override
        public void updateRecipeProgress() {
            if (this.canRecipeProgress && this.drawEnergy(this.recipeEUt, true)) {
                this.drawEnergy(this.recipeEUt, false);
                if (++this.progressTime > this.maxProgressTime) {
                    getAbility().applyDamage(1);
                    this.completeRecipe();
                }
                if (this.hasNotEnoughEnergy && this.getEnergyInputPerSecond() > 19L * this.recipeEUt) {
                    this.hasNotEnoughEnergy = false;
                }
            } else if (this.recipeEUt > 0L) {
                this.hasNotEnoughEnergy = true;
                this.decreaseProgress();
            }
        }
    }
}
