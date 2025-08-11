package keqing.gtqtcore.loaders.recipes.component;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import keqing.gtqtcore.common.items.GTQTMetaItems;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static keqing.gtqtcore.api.unification.GTQTMaterials.*;


public class ComponentRecipes {

    public static void init() {
        motor();
        conveyor();
        piston();
        robotArm();
        pump();
        emitter();
        sensor();
        fieldGenerator();
        craftingComponents();
    }

    private static void motor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, CosmicNeutronium, 4)
                .input(ring, CosmicNeutronium, 4)
                .input(round, CosmicNeutronium, 8)
                .input(wireFine, SiliconCarbide, 64)
                .input(wireFine, SiliconCarbide, 64)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(4*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(200))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_MOTOR_UHV)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Infinity, 4)
                .input(ring, Infinity, 4)
                .input(round, Infinity, 8)
                .input(wireFine, Seaborgium, 64)
                .input(wireFine, Seaborgium, 64)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(16*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(800))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ELECTRIC_MOTOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }

    private static void conveyor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(plate, CosmicNeutronium, 2)
                .input(ring, CosmicNeutronium, 4)
                .input(round, CosmicNeutronium, 16)
                .input(screw, CosmicNeutronium, 4)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(16*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(800))
                .fluidInputs(StyreneButadieneRubber.getFluid(L * 24))
                .fluidInputs(Vibranium.getFluid(L))
                .output(CONVEYOR_MODULE_UHV)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(plate, Infinity, 2)
                .input(ring, Infinity, 4)
                .input(round, Infinity, 16)
                .input(screw, Infinity, 4)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(16*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(800))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 40))
                .fluidInputs(Ichorium.getFluid(L * 2))
                .output(CONVEYOR_MODULE_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }

    private static void piston() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, CosmicNeutronium, 4)
                .input(ring, CosmicNeutronium, 4)
                .input(round, CosmicNeutronium, 16)
                .input(stick, CosmicNeutronium, 4)
                .input(gear, Orichalcum)
                .input(gearSmall, Orichalcum, 2)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(4*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(200))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PISTON_UHV)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Infinity, 4)
                .input(ring, Infinity, 4)
                .input(round, Infinity, 16)
                .input(stick, Infinity, 4)
                .input(gear, CosmicNeutronium)
                .input(gearSmall, CosmicNeutronium, 2)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(16*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(800))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ELECTRIC_PISTON_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }

    private static void robotArm() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, CosmicNeutronium, 4)
                .input(gear, CosmicNeutronium)
                .input(gearSmall, CosmicNeutronium, 3)
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(ELECTRIC_PISTON_UHV)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(12*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(600))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ROBOT_ARM_UHV)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Infinity, 4)
                .input(gear, Infinity)
                .input(gearSmall, Infinity, 3)
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(ELECTRIC_PISTON_UEV)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(HighGradeSolderingAlloy.getFluid(20*L))
                .fluidInputs(MolybdeniteLubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ROBOT_ARM_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }

    private static void pump() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(pipeLargeFluid, Duranium)
                .input(plate, CosmicNeutronium, 2)
                .input(screw, CosmicNeutronium, 8)
                .input(ring, SiliconeRubber, 16)
                .input(rotor, Orichalcum)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PUMP_UHV)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(pipeLargeFluid, Lafium)
                .input(plate, Infinity, 2)
                .input(screw, Infinity, 8)
                .input(ring, NitrileButadieneRubber, 64)
                .input(rotor, CosmicNeutronium)
                .input(cableGtSingle, PedotTMA, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(ELECTRIC_PUMP_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }

    private static void emitter() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(stickLong, CosmicNeutronium, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Vibranium, 64)
                .input(foil, Vibranium, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Vibranium.getFluid(L))
                .output(EMITTER_UHV)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(ELECTRIC_MOTOR_UEV)
                .input(stickLong, Infinity, 4)
                .input(GRAVI_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, Ichorium, 64)
                .input(foil, Ichorium, 32)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(EMITTER_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }

    private static void sensor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, CosmicNeutronium, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Naquadria, 64)
                .input(foil, Naquadria, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Vibranium.getFluid(L))
                .output(SENSOR_UHV)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Infinity, 4)
                .input(GRAVI_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, Seaborgium, 64)
                .input(foil, Seaborgium, 32)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(SENSOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }

    private static void fieldGenerator() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium)
                .input(plate, CosmicNeutronium, 6)
                .input(GRAVI_STAR)
                .input(EMITTER_UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(wireFine, PedotPSS, 64)
                .input(wireFine, PedotPSS, 64)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Vibranium.getFluid(L))
                .output(FIELD_GENERATOR_UHV)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .duration(600).EUt(400000).buildAndRegister();

        //  UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(plate, Infinity, 6)
                .input(GRAVI_STAR, 4)
                .input(EMITTER_UEV, 2)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(wireFine, QuantumAlloy, 64)
                .input(wireFine, QuantumAlloy, 64)
                .input(cableGtSingle, PedotTMA, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(Ichorium.getFluid(L))
                .output(FIELD_GENERATOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UHV.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VA[UHV]))
                .buildAndRegister();

    }

    private static void craftingComponents() {
        ModHandler.addShapedRecipe("component_grinder_boron_nitride", GTQTMetaItems.COMPONENT_GRINDER_BORON_NITRIDE.getStackForm(),
                "PDP", "DGD", "PDP",
                'P', new UnificationEntry(plate, CubicBoronNitride),
                'D', new UnificationEntry(plateDouble, Vibranium),
                'G', new UnificationEntry(gem, CubicHeterodiamond));
    }
}
