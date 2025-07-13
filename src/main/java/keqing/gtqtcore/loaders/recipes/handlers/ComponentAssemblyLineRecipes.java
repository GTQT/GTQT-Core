package keqing.gtqtcore.loaders.recipes.handlers;

import gregtech.api.unification.material.MarkerMaterials;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import keqing.gtqtcore.common.block.blocks.BlockComponentAssemblyLineCasing;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.multiblocks.api.unification.GCYMMaterials.Zeron100;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.COMPONENT_ASSEMBLY_LINE_RECIPES;
import static keqing.gtqtcore.api.unification.GTQTMaterials.*;
import static keqing.gtqtcore.common.items.GTQTMetaItems.*;
import static net.minecraft.init.Items.*;

public class ComponentAssemblyLineRecipes {
    public static void init() {
        Motor();
        Piston();
        Conveyor();
        Pump();
        RobotArm();
        Emitter();
        Sensor();
        FieldGen();
        ComponentAssemblyCasings();
    }
    private static void ComponentAssemblyCasings() {
        //  Component Assembly Line Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Steel, 1)
                .input(plateDense, Steel, 4)
                .input(ROBOT_ARM_LV, 4)
                .input(ELECTRIC_PISTON_LV, 8)
                .input(ELECTRIC_MOTOR_LV, 10)
                .input(gear, Steel, 4)
                .input(wireGtQuadruple, Tin, 6)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LV, 4))
                .EUt(VA[LV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium, 1)
                .input(plateDense, Aluminium, 4)
                .input(ROBOT_ARM_MV, 4)
                .input(ELECTRIC_PISTON_MV, 8)
                .input(ELECTRIC_MOTOR_MV, 10)
                .input(gear, Aluminium, 4)
                .input(wireGtQuadruple, Copper, 6)
                .input(circuit, MarkerMaterials.Tier.MV, 8)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.MV, 4))
                .EUt(VA[MV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel, 1)
                .input(plateDense, StainlessSteel, 4)
                .input(ROBOT_ARM_HV, 4)
                .input(ELECTRIC_PISTON_HV, 8)
                .input(ELECTRIC_MOTOR_HV, 10)
                .input(gear, StainlessSteel, 4)
                .input(wireGtQuadruple, Gold, 6)
                .input(circuit, MarkerMaterials.Tier.HV, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.HV, 4))
                .EUt(VA[HV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium, 1)
                .input(plateDense, Titanium, 4)
                .input(ROBOT_ARM_EV, 4)
                .input(ELECTRIC_PISTON_EV, 8)
                .input(ELECTRIC_MOTOR_EV, 10)
                .input(gear, Titanium, 4)
                .input(wireGtQuadruple, Aluminium, 6)
                .input(circuit, MarkerMaterials.Tier.EV, 8)
                .input(circuit, MarkerMaterials.Tier.HV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.EV, 4))
                .EUt(VA[EV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel, 1)
                .input(plateDense, TungstenSteel, 4)
                .input(ROBOT_ARM_IV, 4)
                .input(ELECTRIC_PISTON_IV, 8)
                .input(ELECTRIC_MOTOR_IV, 10)
                .input(gear, TungstenSteel, 4)
                .input(wireGtQuadruple, Tungsten, 6)
                .input(circuit, MarkerMaterials.Tier.IV, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.IV, 4))
                .EUt(VA[IV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(plateDense, RhodiumPlatedPalladium, 6)
                .input(ROBOT_ARM_LuV, 8)
                .input(ELECTRIC_PISTON_LUV, 10)
                .input(ELECTRIC_MOTOR_LuV, 16)
                .input(gear, RhodiumPlatedPalladium, 4)
                .input(gearSmall, RhodiumPlatedPalladium, 16)
                .input(cableGtQuadruple, NiobiumTitanium, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(Zeron100.getFluid(1728))
                .fluidInputs(TanmolyiumBetaC.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LuV, 4))
                .EUt(VA[LuV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.IV))
                        .EUt(VA[IV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(plateDense, NaquadahAlloy, 6)
                .input(ROBOT_ARM_ZPM, 8)
                .input(ELECTRIC_PISTON_ZPM, 10)
                .input(ELECTRIC_MOTOR_ZPM, 16)
                .input(gear, NaquadahAlloy, 4)
                .input(gearSmall, NaquadahAlloy, 16)
                .input(cableGtQuadruple, VanadiumGallium, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(MARM200CeSteel.getFluid(1728))
                .fluidInputs(HastelloyC59.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.ZPM, 4))
                .EUt(VA[ZPM])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.LuV))
                        .EUt(VA[LuV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plateDense, Darmstadtium, 6)
                .input(ROBOT_ARM_UV, 8)
                .input(ELECTRIC_PISTON_UV, 10)
                .input(ELECTRIC_MOTOR_UV, 16)
                .input(gear, Darmstadtium, 4)
                .input(gearSmall, Darmstadtium, 16)
                .input(cableGtQuadruple, YttriumBariumCuprate, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(HMS1J79Alloy.getFluid(1728))
                .fluidInputs(Pikyonium64B.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UV, 4))
                .EUt(VA[UV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.ZPM))
                        .EUt(VA[ZPM])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plateDense, Orichalcum, 6)
                .input(ROBOT_ARM_UHV, 8)
                .input(ELECTRIC_PISTON_UHV, 10)
                .input(ELECTRIC_MOTOR_UHV, 16)
                .input(gear, Orichalcum, 4)
                .input(gearSmall, Orichalcum, 16)
                .input(cableGtQuadruple, Europium, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(TitanSteel.getFluid(1728))
                .fluidInputs(Cinobite.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UHV, 4))
                .EUt(VA[UHV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UV))
                        .EUt(VA[UV])
                        .CWUt(64))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plateDense, Adamantium, 6)
                .input(ROBOT_ARM_UEV, 8)
                .input(ELECTRIC_PISTON_UEV, 10)
                .input(ELECTRIC_MOTOR_UEV, 16)
                .input(gear, Adamantium, 4)
                .input(gearSmall, Adamantium, 16)
                .input(cableGtQuadruple, PedotTMA, 8)
                .input(circuit, MarkerMaterials.Tier.UEV, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(BlackTitanium.getFluid(1728))
                .fluidInputs(Abyssalloy.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UEV, 4))
                .EUt(VA[UEV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UHV))
                        .EUt(VA[UHV])
                        .CWUt(128))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(plateDense, Infinity, 6)
                .input(ROBOT_ARM_UIV, 8)
                .input(ELECTRIC_PISTON_UIV, 10)
                .input(ELECTRIC_MOTOR_UIV, 16)
                .input(gear, Infinity, 4)
                .input(gearSmall, Infinity, 16)
                .input(cableGtQuadruple, Solarium, 8)
                .input(circuit, MarkerMaterials.Tier.UIV, 8)
                .input(circuit, MarkerMaterials.Tier.UEV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(BlackPlutonium.getFluid(1728))
                .fluidInputs(SuperheavyHAlloy.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UIV, 4))
                .EUt(VA[UIV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UEV))
                        .EUt(VA[UEV])
                        .CWUt(256))
                .buildAndRegister();

        /*
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(plateDense, CosmicNeutronium, 6)
                .input(ROBOT_ARM_UXV, 8)
                .input(ELECTRIC_PISTON_UXV, 10)
                .input(ELECTRIC_MOTOR_UXV, 16)
                .input(gear, CosmicNeutronium, 4)
                .input(gearSmall, CosmicNeutronium, 16)
                .input(cableGtQuadruple, Hypogen, 8)
                .input(circuit, MarkerMaterials.Tier.UXV, 8)
                .input(circuit, MarkerMaterials.Tier.UIV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(QuantumchromodynamicallyConfinedMatter.getFluid(1728))
                .fluidInputs(HeavyQuarkDegenerateMatter.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UXV, 4))
                .EUt(VA[UXV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UIV))
                        .EUt(VA[UIV])
                        .CWUt(512))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Spacetime)
                .input(plateDense, Spacetime, 6)
                .input(ROBOT_ARM_OpV, 8)
                .input(ELECTRIC_PISTON_OpV, 10)
                .input(ELECTRIC_MOTOR_OpV, 16)
                .input(gear, Spacetime, 4)
                .input(gearSmall, Spacetime, 16)
                .input(cableGtQuadruple, Galaxium, 8)
                .input(circuit, MarkerMaterials.Tier.OpV, 8)
                .input(circuit, MarkerMaterials.Tier.UXV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(WhiteDwarfMatter.getFluid(1728))
                .fluidInputs(BlackDwarfMatter.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.OpV, 4))
                .EUt(VA[OpV])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.UXV))
                        .EUt(VA[UXV])
                        .CWUt(1024))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Eternity)
                .input(plateDense, Eternity, 6)
                .input(ROBOT_ARM_MAX, 8)
                .input(ELECTRIC_PISTON_MAX, 10)
                .input(ELECTRIC_MOTOR_MAX, 16)
                .input(gear, Eternity, 4)
                .input(gearSmall, Eternity, 16)
                .input(cableGtQuadruple, Universium, 8)
                .input(circuit, MarkerMaterials.Tier.MAX, 8)
                .input(circuit, MarkerMaterials.Tier.OpV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(Arcanium.getFluid(1728))
                .fluidInputs(Shirabon.getFluid(864))
                .fluidInputs(AdvancedLubricant.getFluid(4000))
                .outputs(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.MAX, 4))
                .EUt(VA[MAX])
                .duration(600)
                .stationResearch(b -> b
                        .researchStack(GTQTMetaBlocks.blockComponentAssemblyLineCasing.getItemVariant(BlockComponentAssemblyLineCasing.CasingTier.OpV))
                        .EUt(VA[OpV])
                        .CWUt(2048))
                .buildAndRegister();
        */
    }

    private static void Motor() {
        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Iron, 64)
                .input(stickLong, IronMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Steel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Copper, 8)
                .input(stickLong, Aluminium, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Cupronickel, 32)
                .output(ELECTRIC_MOTOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Silver, 16)
                .input(stickLong, StainlessSteel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Electrum, 32)
                .output(ELECTRIC_MOTOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Aluminium, 16)
                .input(stickLong, Titanium, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Kanthal, 32)
                .output(ELECTRIC_MOTOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(cableGtHex, Tungsten, 16)
                .input(stickLong, TungstenSteel, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Graphene, 32)
                .output(ELECTRIC_MOTOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(AdvancedLubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(8704))
                .fluidInputs(Ruridit.getFluid(L * 8 * 64))
                .output(ELECTRIC_MOTOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(17408))
                .fluidInputs(Europium.getFluid(L * 12 * 64))
                .output(ELECTRIC_MOTOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(17408))
                .fluidInputs(Americium.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(17408))
                .fluidInputs(SiliconCarbide.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(cableGtHex, PedotTMA, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(17408))
                .fluidInputs(Seaborgium.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();
    }

    private static void Piston() {
        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, Steel, 64)
                .input(cableGtHex, Tin, 8)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 32)
                .input(gearSmall, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .output(ELECTRIC_PISTON_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, Aluminium, 64)
                .input(cableGtHex, Copper, 8)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 32)
                .input(gearSmall, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .output(ELECTRIC_PISTON_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, StainlessSteel, 64)
                .input(cableGtHex, Gold, 8)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 32)
                .input(gearSmall, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .output(ELECTRIC_PISTON_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, Titanium, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 32)
                .input(gearSmall, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .output(ELECTRIC_PISTON_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(stickLong, TungstenSteel, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 32)
                .input(gearSmall, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .output(ELECTRIC_PISTON_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(AdvancedLubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(80896))
                .output(ELECTRIC_PISTON_LUV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(80896))
                .output(ELECTRIC_PISTON_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(plateDouble, Tritanium, 64) // plate
                .input(plateDouble, Tritanium, 64)
                .input(stickLong, Tritanium, 64) // stick
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(25600))
                .fluidInputs(NaquadahAlloy.getFluid(L * 4 * 64 + L * 2 * 64))
                .output(ELECTRIC_PISTON_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(25600))
                .fluidInputs(Orichalcum.getFluid(L * 4 * 64 + L * 2 * 64)) // gear + small gear
                .output(ELECTRIC_PISTON_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(cableGtHex, PedotTMA, 8) // cable
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(25600))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64 + L * 2 * 64)) // gear + small gear
                .output(ELECTRIC_PISTON_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();
    }

    private static void Conveyor() {
        //  LV (15s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Tin, 4)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV, 64)
                    .EUt(VA[LV])
                    .duration(300)
                    .CasingTier(LV)
                    .buildAndRegister();
        }

        //  MV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Copper, 4)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV, 64)
                    .EUt(VA[MV])
                    .duration(600)
                    .CasingTier(MV)
                    .buildAndRegister();
        }

        //  HV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Gold, 4)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV, 64)
                    .EUt(VA[HV])
                    .duration(600)
                    .CasingTier(HV)
                    .buildAndRegister();
        }

        //  EV (45s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Aluminium, 4)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV, 64)
                    .EUt(VA[EV])
                    .duration(900)
                    .CasingTier(EV)
                    .buildAndRegister();
        }

        //  IV (45s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(cableGtHex, Tungsten, 4)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_IV, 64)
                    .EUt(VA[IV])
                    .duration(900)
                    .CasingTier(IV)
                    .buildAndRegister();
        }

        //  LuV (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 8 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 8 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(plateDouble, HSSS, 64)
                    .input(stickLong, HSSS, 32)
                    .input(cableGtHex, NiobiumTitanium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(16000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(HSSS.getFluid(25600))
                    .output(CONVEYOR_MODULE_LuV, 64)
                    .EUt(VA[LuV])
                    .duration(1200)
                    .CasingTier(LuV)
                    .buildAndRegister();
        }

        //  ZPM (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 16 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 16 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(plateDouble, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 32)
                    .input(cableGtHex, VanadiumGallium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(32000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Osmiridium.getFluid(25600))
                    .output(CONVEYOR_MODULE_ZPM, 64)
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .CasingTier(ZPM)
                    .buildAndRegister();
        }

        //  UV (75s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 24 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 24 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(plateDouble, Tritanium, 64)
                    .input(stickLong, Tritanium, 32)
                    .input(cableGtHex, YttriumBariumCuprate, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(64000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                    .fluidInputs(Tritanium.getFluid(25600))
                    .output(CONVEYOR_MODULE_UV, 64)
                    .EUt(VA[UV])
                    .duration(1500)
                    .CasingTier(UV)
                    .buildAndRegister();
        }

        //  UHV (75s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 32 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UHV, 64)
                    .input(ELECTRIC_MOTOR_UHV, 64)
                    .input(plateDouble, Adamantium, 64)
                    .input(stickLong, Adamantium, 32)
                    .input(cableGtHex, Europium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(192000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Vibranium.getFluid(L * 64))
                    .fluidInputs(Adamantium.getFluid(25600))
                    .output(CONVEYOR_MODULE_UHV, 64)
                    .EUt(VA[UHV])
                    .duration(1500)
                    .CasingTier(UHV)
                    .buildAndRegister();
        }

        //  UEV (90s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 40 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 40 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(3)
                    .input(ELECTRIC_MOTOR_UEV, 64)
                    .input(ELECTRIC_MOTOR_UEV, 64)
                    .input(plateDouble, Hdcs, 64)
                    .input(stickLong, Hdcs, 32)
                    .input(cableGtHex, PedotTMA, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(320000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Ichorium.getFluid(L * 2 * 64))
                    .fluidInputs(Hdcs.getFluid(25600))
                    .output(CONVEYOR_MODULE_UEV, 64)
                    .EUt(VA[UEV])
                    .duration(1800)
                    .CasingTier(UEV)
                    .buildAndRegister();
        }
    }

    private static void Pump() {

        //  LV (15s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Tin, 4)
                    .input(stickLong, Tin, 8)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .fluidInputs(Bronze.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Tin.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_LV, 64)
                    .EUt(VA[LV])
                    .duration(300)
                    .CasingTier(LV)
                    .buildAndRegister();
        }

        //  MV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Copper, 4)
                    .input(stickLong, Bronze, 8)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .fluidInputs(Steel.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Bronze.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_MV, 64)
                    .EUt(VA[MV])
                    .duration(600)
                    .CasingTier(MV)
                    .buildAndRegister();
        }

        //  HV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Gold, 4)
                    .input(stickLong, Steel, 8)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .fluidInputs(StainlessSteel.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Steel.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_HV, 64)
                    .EUt(VA[HV])
                    .duration(600)
                    .CasingTier(HV)
                    .buildAndRegister();
        }

        //  EV (45s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Aluminium, 4)
                    .input(stickLong, StainlessSteel, 8)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .fluidInputs(Titanium.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(StainlessSteel.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_EV, 64)
                    .EUt(VA[EV])
                    .duration(900)
                    .CasingTier(EV)
                    .buildAndRegister();
        }

        //  IV (45s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(cableGtHex, Tungsten, 4)
                    .input(stickLong, TungstenSteel, 8)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .fluidInputs(TungstenSteel.getFluid(L * 3 * 64 + L * 4 * 64)) // PipeNormalFluid + Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_IV, 64)
                    .EUt(VA[IV])
                    .duration(900)
                    .CasingTier(IV)
                    .buildAndRegister();
        }

        //  LuV (60s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 64),
                NitrileButadieneRubber.getFluid(L * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(plateDouble, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(cableGtHex, NiobiumTitanium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(16000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(NiobiumTitanium.getFluid(L * 64)) // PipeSmallFluid
                    .fluidInputs(HSSS.getFluid(L * 4 * 64)) //  Rotor
                    .output(ELECTRIC_PUMP_LuV, 64)
                    .EUt(VA[LuV])
                    .duration(1200)
                    .CasingTier(LuV)
                    .buildAndRegister();
        }

        //  ZPM (60s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 128),
                NitrileButadieneRubber.getFluid(L * 128)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(plateDouble, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(cableGtHex, VanadiumGallium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(32000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Polybenzimidazole.getFluid(L * 3 * 64)) // pipeNormalFluid
                    .fluidInputs(Osmiridium.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_ZPM, 64)
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .CasingTier(ZPM)
                    .buildAndRegister();
        }

        //  UV (75s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 256),
                NitrileButadieneRubber.getFluid(L * 256)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(plateDouble, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(cableGtHex, YttriumBariumCuprate, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(64000))
                    .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Naquadah.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(NaquadahAlloy.getFluid(L * 4 * 64)) //  Rotor
                    .output(ELECTRIC_PUMP_UV, 64)
                    .EUt(VA[UV])
                    .duration(1500)
                    .CasingTier(UV)
                    .buildAndRegister();
        }

        //  UHV (75s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 512),
                NitrileButadieneRubber.getFluid(L * 512)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UHV, 64)
                    .input(plateDouble, Adamantium, 64)
                    .input(stickLong, Adamantium, 64)
                    .input(cableGtHex, Europium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(192000))
                    .fluidInputs(Vibranium.getFluid(L * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Duranium.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(Orichalcum.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_UHV, 64)
                    .EUt(VA[UHV])
                    .duration(1500)
                    .CasingTier(UHV)
                    .buildAndRegister();
        }

        //  UEV (90s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 1024),
                NitrileButadieneRubber.getFluid(L * 1024)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .circuitMeta(4)
                    .input(ELECTRIC_MOTOR_UEV, 64)
                    .input(plateDouble, Hdcs, 64)
                    .input(stickLong, Hdcs, 64)
                    .input(cableGtHex, PedotTMA, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                    .fluidInputs(AdvancedLubricant.getFluid(320000))
                    .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                    .fluidInputs(Ichorium.getFluid(L * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Lafium.getFluid(L * 6 * 64)) // PipeLargeFluid
                    .fluidInputs(Adamantium.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_UEV, 64)
                    .EUt(VA[UEV])
                    .duration(1800)
                    .CasingTier(UEV)
                    .buildAndRegister();
        }
    }

    private static void RobotArm() {

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tin, 12)
                .input(stickLong, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_PISTON_LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .output(ROBOT_ARM_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tin, 12)
                .input(stickLong, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_PISTON_LV, 64)
                .input(WRAP_CIRCUIT_LV, 1) // 4 * 16
                .output(ROBOT_ARM_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Copper, 12)
                .input(stickLong, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_PISTON_MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .output(ROBOT_ARM_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Copper, 12)
                .input(stickLong, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_PISTON_MV, 64)
                .input(WRAP_CIRCUIT_MV, 1) // 4 * 16
                .output(ROBOT_ARM_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Gold, 12)
                .input(stickLong, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_PISTON_HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .output(ROBOT_ARM_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Gold, 12)
                .input(stickLong, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_PISTON_HV, 64)
                .input(WRAP_CIRCUIT_HV, 1) // 4 * 16
                .output(ROBOT_ARM_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Aluminium, 12)
                .input(stickLong, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_PISTON_EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .output(ROBOT_ARM_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Aluminium, 12)
                .input(stickLong, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_PISTON_EV, 64)
                .input(WRAP_CIRCUIT_EV, 1) // 4 * 16
                .output(ROBOT_ARM_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tungsten, 12)
                .input(stickLong, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_PISTON_IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .output(ROBOT_ARM_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(cableGtHex, Tungsten, 12)
                .input(stickLong, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_PISTON_IV, 64)
                .input(WRAP_CIRCUIT_IV, 1) // 4 * 16
                .output(ROBOT_ARM_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(ELECTRIC_PISTON_LUV, 64)
                .input(WRAP_CIRCUIT_LuV, 1) // 4 * 16
                .input(WRAP_CIRCUIT_IV, 2) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_EV, 4) // 16 * 16
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Osmiridium,  64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(ELECTRIC_PISTON_ZPM, 64)
                .input(WRAP_CIRCUIT_ZPM, 1) // 4 * 16
                .input(WRAP_CIRCUIT_LuV, 2) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_IV, 4) // 16 * 16 = 4 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Tritanium,  64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(ELECTRIC_PISTON_UV, 64)
                .input(WRAP_CIRCUIT_UV, 1) // 4 * 16
                .input(WRAP_CIRCUIT_ZPM, 2) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_LuV, 4) // 16 * 16 = 4 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 12 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_PISTON_UHV, 64)
                .input(WRAP_CIRCUIT_UHV, 1) // 4 * 16
                .input(WRAP_CIRCUIT_UV, 2) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_ZPM, 4) // 16 * 16 = 4 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64 + L * 3 * 64)) // Gear + 3 Small Gear
                .output(ROBOT_ARM_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_PISTON_UEV, 64)
                .input(WRAP_CIRCUIT_UEV, 1) // 4 * 16
                .input(WRAP_CIRCUIT_UHV, 2) // 8 * 16 = 2 * 64
                .input(WRAP_CIRCUIT_UV, 4) // 16 * 16 = 4 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 20 * 64))
                .fluidInputs(AdvancedLubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(L * 4 * 64 + L * 3 * 64)) // Gear + 3 Small Gear
                .output(ROBOT_ARM_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();
    }

    private static void Emitter() {
        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Brass, 64)
                .input(stickLong, Brass, 64)
                .input(cableGtHex, Tin, 8)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(gem, Quartzite, 64)
                .output(EMITTER_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Brass, 64)
                .input(stickLong, Brass, 64)
                .input(cableGtHex, Tin, 8)
                .input(WRAP_CIRCUIT_LV, 2) // 8 * 16 = 2 * 64
                .input(gem, Quartzite, 64)
                .output(EMITTER_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Electrum, 64)
                .input(stickLong, Electrum, 64)
                .input(cableGtHex, Copper, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(gemFlawless, Emerald, 64)
                .output(EMITTER_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Electrum, 64)
                .input(stickLong, Electrum, 64)
                .input(cableGtHex, Copper, 8)
                .input(WRAP_CIRCUIT_MV, 2) // 8 * 16 = 2 * 64
                .input(gemFlawless, Emerald, 64)
                .output(EMITTER_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Chrome, 64)
                .input(stickLong, Chrome, 64)
                .input(cableGtHex, Gold, 8)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(ENDER_EYE, 64)
                .output(EMITTER_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Chrome, 64)
                .input(stickLong, Chrome, 64)
                .input(cableGtHex, Gold, 8)
                .input(WRAP_CIRCUIT_HV, 2) // 8 * 16 = 2 * 64
                .input(ENDER_EYE, 64)
                .output(EMITTER_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Platinum, 64)
                .input(stickLong, Platinum, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(QUANTUM_EYE, 64)
                .output(EMITTER_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Platinum, 64)
                .input(stickLong, Platinum, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(WRAP_CIRCUIT_EV, 2) // 8 * 16 = 2 * 64
                .input(QUANTUM_EYE, 64)
                .output(EMITTER_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Iridium, 64)
                .input(stickLong, Iridium, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(QUANTUM_STAR, 64)
                .output(EMITTER_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Iridium, 64)
                .input(stickLong, Iridium, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(WRAP_CIRCUIT_IV, 2) // 8 * 16 = 2 * 64
                .input(QUANTUM_STAR, 64)
                .output(EMITTER_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_LuV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Ruridit.getFluid(L * 4 * 64)) //  4 * Long Stick
                .fluidInputs(Palladium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(EMITTER_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, NaquadahAlloy, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(QUANTUM_STAR, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_ZPM, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64)) //  4 * Long Stick
                .fluidInputs(Trinium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(EMITTER_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Naquadria.getFluid(L * 24 * 64 + L * 4 * 64)) // foil + recipe fluids
                .fluidInputs(Tritanium.getFluid(L * 4 * 64)) //  4 * long stick
                .output(EMITTER_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UHV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 24 * 64 + L * 64)) // foil + recipe fluids
                .fluidInputs(Adamantium.getFluid(L * 4 * 64)) // long stick
                .output(EMITTER_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(frameGt, Hdcs, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UEV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 24 * 64 + L * 64)) // foil + recipe fluids
                .fluidInputs(Hdcs.getFluid(L * 4 * 64)) // long stick
                .output(EMITTER_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();
    }

    private static void Sensor() {

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Brass, 32)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(gem, Quartzite, 64)
                .output(SENSOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Brass, 32)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 64)
                .input(WRAP_CIRCUIT_LV, 1) // 4 * 16
                .input(gem, Quartzite, 64)
                .output(SENSOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Electrum, 32)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(gemFlawless, Emerald, 64)
                .output(SENSOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Electrum, 32)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 64)
                .input(WRAP_CIRCUIT_MV, 1) // 4 * 16
                .input(gemFlawless, Emerald, 64)
                .output(SENSOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Chrome, 32)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(ENDER_EYE, 64)
                .output(SENSOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Chrome, 32)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(WRAP_CIRCUIT_HV, 1) // 4 * 16
                .input(ENDER_EYE, 64)
                .output(SENSOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Platinum, 32)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(QUANTUM_EYE, 64)
                .output(SENSOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Platinum, 32)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(WRAP_CIRCUIT_EV, 1) // 4 * 16
                .input(QUANTUM_EYE, 64)
                .output(SENSOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Iridium, 32)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(QUANTUM_STAR, 64)
                .output(SENSOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(stickLong, Iridium, 32)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(WRAP_CIRCUIT_IV, 1) // 4 * 16
                .input(QUANTUM_STAR, 64)
                .output(SENSOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(plateDouble, Ruridit, 64)
                .input(plateDouble, Ruridit, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_LuV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Palladium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, NaquadahAlloy, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(QUANTUM_STAR, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_ZPM, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Trinium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Naquadria.getFluid(L * 24 * 64 + L * 4 * 64)) // foil + recipe fluids
                .output(SENSOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UHV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64)) // recipe fluids
                .fluidInputs(Orichalcum.getFluid(L * 24 * 64)) // foil
                .output(SENSOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .circuitMeta(7)
                .input(frameGt, Hdcs, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UEV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64)) // recipe fluids
                .fluidInputs(Seaborgium.getFluid(L * 24 * 64)) // foil
                .output(SENSOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();
    }

    private static void FieldGen() {
        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_PEARL, 64)
                .input(plateDouble, Steel, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(wireGtHex, ManganesePhosphide, 64)
                .output(FIELD_GENERATOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_PEARL, 64)
                .input(plateDouble, Steel, 64)
                .input(WRAP_CIRCUIT_LV, 2) // 8 * 16 = 2 * 64
                .input(wireGtHex, ManganesePhosphide, 64)
                .output(FIELD_GENERATOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_EYE, 64)
                .input(plateDouble, Aluminium, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(wireGtHex, MagnesiumDiboride, 64)
                .output(FIELD_GENERATOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_EYE, 64)
                .input(plateDouble, Aluminium, 64)
                .input(WRAP_CIRCUIT_MV, 2) // 8 * 16 = 2 * 64
                .input(wireGtHex, MagnesiumDiboride, 64)
                .output(FIELD_GENERATOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_EYE, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(wireGtHex, MercuryBariumCalciumCuprate, 64)
                .output(FIELD_GENERATOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_EYE, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(WRAP_CIRCUIT_HV, 2) // 8 * 16 = 2 * 64
                .input(wireGtHex, MercuryBariumCalciumCuprate, 64)
                .output(FIELD_GENERATOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(NETHER_STAR, 64)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(wireGtHex, UraniumTriplatinum, 64)
                .output(FIELD_GENERATOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(NETHER_STAR, 64)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(WRAP_CIRCUIT_EV, 2) // 8 * 16 = 2 * 64
                .input(wireGtHex, UraniumTriplatinum, 64)
                .output(FIELD_GENERATOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(wireGtHex, SamariumIronArsenicOxide, 64)
                .output(FIELD_GENERATOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(WRAP_CIRCUIT_IV, 2) // 8 * 16 = 2 * 64
                .input(wireGtHex, SamariumIronArsenicOxide, 64)
                .output(FIELD_GENERATOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(QUANTUM_STAR, 64)
                .input(EMITTER_LuV, 64)
                .input(EMITTER_LuV, 64)
                .input(WRAP_CIRCUIT_LuV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(IndiumTinBariumTitaniumCuprate.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(QUANTUM_STAR, 64)
                .input(EMITTER_ZPM, 64)
                .input(EMITTER_ZPM, 64)
                .input(WRAP_CIRCUIT_ZPM, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(UraniumRhodiumDinaquadide.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UV, 64)
                .input(EMITTER_UV, 64)
                .input(WRAP_CIRCUIT_UV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 12 * 64))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(EnrichedNaquadahTriniumEuropiumDuranide.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UHV, 64)
                .input(EMITTER_UHV, 64)
                .input(WRAP_CIRCUIT_UHV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(PedotPSS.getFluid(L * 16 * 64)) // wire fine
                .output(FIELD_GENERATOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Hdcs, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UEV, 64)
                .input(EMITTER_UEV, 64)
                .input(WRAP_CIRCUIT_UEV, 2) // 8 * 16 = 2 * 64
                .input(cableGtHex, PedotTMA, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 20 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(Ichorium.getFluid(L * 64))
                .fluidInputs(QuantumAlloy.getFluid(L * 16 * 64)) // wire fine
                .output(FIELD_GENERATOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();
    }
}