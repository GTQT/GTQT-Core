package keqing.gtqtcore.loaders.recipes.chain;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.items.MetaItems;
import keqing.gtqtcore.common.items.GTQTMetaItems;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.*;
import static keqing.gtqtcore.api.unification.GTQTMaterials.*;
import static keqing.gtqtcore.common.items.GTQTMetaItems.*;

public class SolarPanels {
    public static void init() {
        // -------------------------------------------- Solar Core -------------------------------------------
        //阳光化合物 + 太阳能核心
        //阳光化合物
        MOLECULAR_TRANSFORMER_RECIPES.recipeBuilder()
                .input(gemExquisite, Glowstone)
                .output(SUN_MATTER)
                .EUt(VA[EV])
                .CWUt(VA[EV])
                .Tier(1)
                .duration(400)
                .buildAndRegister();

        //阳光透镜
        CHEMICAL_RECIPES.recipeBuilder()
                .input(SUN_MATTER)
                .input(lens, Diamond)
                .output(SUNLINSE)
                .fluidInputs(DistilledWater.getFluid(1000))
                .EUt(VA[IV])
                .duration(400)
                .buildAndRegister();

        //日光金属
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .notConsumable(SUNLINSE)
                .input(SUN_MATTER)
                .output(SUNNARIUM)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(400).EUt(VA[LuV]).buildAndRegister();

        //日光金属板
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(SUNNARIUM)
                .input(plate, Tungsten, 2)
                .input(plate, Titanium, 4)
                .output(SUNNARIUM_PLATE)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //日光偏振片
        LATHE_RECIPES.recipeBuilder()
                .input(SUNNARIUM)
                .output(SUNNARIUMPART)
                .fluidInputs(DistilledWater.getFluid(1000))
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

        //耀光金属
        LASER_FUSION_RECIPES.recipeBuilder()
                .input(SUNNARIUM)
                .output(SUNNARIUM_ENRICHED)
                .duration(400).EUt(VA[UHV]).buildAndRegister();

        //耀光金属板
        FORMING_PRESS_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(SUNNARIUM_ENRICHED)
                .input(plate, Naquadah, 2)
                .input(plate, Tungsten, 4)
                .output(SUNNARIUM_ENRICHED_PLATE)
                .EUt(VA[UV])
                .duration(10 * SECOND)
                .buildAndRegister();

        //太阳能核心
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SUN_MATTER)
                .input(CIRCUIT_GOOD_I)
                .input(MetaItems.ADVANCED_SMD_TRANSISTOR, 4)
                .input(MetaItems.ADVANCED_SMD_RESISTOR, 4)
                .input(MetaItems.ADVANCED_SMD_DIODE, 4)
                .input(MetaItems.ADVANCED_SMD_INDUCTOR, 4)
                .output(SOLAR_CORE_I)
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SUNNARIUM)
                .input(CIRCUIT_GOOD_II)
                .input(GTQTMetaItems.OPTICAL_TRANSISTOR, 4)
                .input(GTQTMetaItems.OPTICAL_RESISTOR, 4)
                .input(GTQTMetaItems.OPTICAL_DIODE, 4)
                .input(GTQTMetaItems.OPTICAL_INDUCTOR, 4)
                .output(SOLAR_CORE_II)
                .EUt(VA[LuV])
                .duration(5 * SECOND)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SUNNARIUM_PLATE)
                .input(CIRCUIT_GOOD_III)
                .input(GTQTMetaItems.SPINTRONIC_TRANSISTOR, 4)
                .input(GTQTMetaItems.SPINTRONIC_RESISTOR, 4)
                .input(GTQTMetaItems.SPINTRONIC_DIODE, 4)
                .input(GTQTMetaItems.SPINTRONIC_INDUCTOR, 4)
                .output(SOLAR_CORE_III)
                .EUt(VA[ZPM])
                .duration(5 * SECOND)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SUNNARIUM_ENRICHED)
                .input(CIRCUIT_GOOD_IV)
                .input(GTQTMetaItems.COSMIC_TRANSISTOR, 4)
                .input(GTQTMetaItems.COSMIC_RESISTOR, 4)
                .input(GTQTMetaItems.COSMIC_DIODE, 4)
                .input(GTQTMetaItems.COSMIC_INDUCTOR, 4)
                .output(SOLAR_CORE_IV)
                .EUt(VA[UV])
                .duration(5 * SECOND)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SUNNARIUM_ENRICHED_PLATE)
                .input(CIRCUIT_GOOD_V)
                .input(GTQTMetaItems.SUPRACAUSAL_TRANSISTOR, 4)
                .input(GTQTMetaItems.SUPRACAUSAL_RESISTOR, 4)
                .input(GTQTMetaItems.SUPRACAUSAL_DIODE, 4)
                .input(GTQTMetaItems.SUPRACAUSAL_INDUCTOR, 4)
                .output(SOLAR_CORE_V)
                .EUt(VA[UHV])
                .duration(5 * SECOND)
                .buildAndRegister();
        // -------------------------------------------- Solar Panels -------------------------------------------

        //  Basic Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(SILICON_WAFER, 2)
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(plate, Glass)
                .input(CARBON_FIBER_PLATE)
                .input(SOLAR_CORE_I)
                .fluidInputs(RedAlloy.getFluid(L))
                .output(COVER_SOLAR_PANEL)
                .EUt(VA[ULV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  ULV Solar Panel (8A Solar Panel)
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL, 2)
                .input(SILICON_WAFER)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(plate, GalliumArsenide)
                .input(SOLAR_CORE_I)
                .fluidInputs(Tin.getFluid(L))
                .output(COVER_SOLAR_PANEL_ULV)
                .EUt(VA[LV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  LV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_ULV, 2)
                .input(SILICON_WAFER)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(plate, GalliumArsenide, 2)
                .input(SOLAR_CORE_I)
                .fluidInputs(TinAlloy.getFluid(L))
                .output(COVER_SOLAR_PANEL_LV)
                .EUt(VA[MV])
                .duration(5 * SECOND)
                .buildAndRegister();

        //  MV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_LV, 2)
                .input(PHOSPHORUS_WAFER)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(plate, GalliumArsenide, 4)
                .input(SOLAR_CORE_II)
                .fluidInputs(CobaltBrass.getFluid(L))
                .output(COVER_SOLAR_PANEL_MV)
                .EUt(VA[HV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  HV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_MV, 2)
                .input(PHOSPHORUS_WAFER)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(plate, GalliumArsenide, 8)
                .input(SOLAR_CORE_II)
                .fluidInputs(BlackSteel.getFluid(L))
                .output(COVER_SOLAR_PANEL_HV)
                .EUt(VA[EV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  EV Solar Panel
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(18)
                .input(COVER_SOLAR_PANEL_HV, 2)
                .input(NAQUADAH_WAFER)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(plate, GalliumArsenide, 16)
                .input(SOLAR_CORE_II)
                .fluidInputs(BlueSteel.getFluid(L))
                .output(COVER_SOLAR_PANEL_EV)
                .EUt(VA[IV])
                .duration(5 * SECOND)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  IV Solar Panel

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSE)
                .input(COVER_SOLAR_PANEL_EV, 2)
                .input(NAQUADAH_WAFER, 2)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(plate, IndiumGalliumPhosphide)
                .input(VOLTAGE_COIL_IV, 2)
                .input(POWER_INTEGRATED_CIRCUIT, 4)
                .input(foil, NiobiumTitanium, 8)
                .input(SOLAR_CORE_III, 2)
                .input(wireGtDouble, HSSG, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9))
                .fluidInputs(BorosilicateGlass.getFluid(3000))
                .fluidInputs(HSSE, L * 4)
                .output(COVER_SOLAR_PANEL_IV)
                .EUt(VA[LuV])
                .duration(10 * SECOND)
                .scannerResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_EV.getStackForm())
                        .EUt(VA[LuV])
                        .duration(30 * SECOND))
                .buildAndRegister();


        //  LuV Solar Panel

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(COVER_SOLAR_PANEL_IV, 2)
                .input(NAQUADAH_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(plate, IndiumGalliumPhosphide, 2)
                .input(VOLTAGE_COIL_LuV, 2)
                .input(POWER_INTEGRATED_CIRCUIT, 8)
                .input(foil, VanadiumGallium, 16)
                .input(SOLAR_CORE_III, 2)
                .input(wireGtDouble, Trinium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 2))
                .fluidInputs(BorosilicateGlass.getFluid(6000))
                .fluidInputs(HSSS, L * 4)
                .output(COVER_SOLAR_PANEL_LUV)
                .EUt(VA[ZPM])
                .duration(15 * SECOND)
                .scannerResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_IV.getStackForm())
                        .EUt(VA[ZPM])
                        .duration(MINUTE))
                .buildAndRegister();


        //  ZPM Solar Panel

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Duranium)
                .input(COVER_SOLAR_PANEL_LUV, 2)
                .input(EUROPIUM_WAFER)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(plate, IndiumGalliumPhosphide, 4)
                .input(VOLTAGE_COIL_ZPM, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(foil, YttriumBariumCuprate, 16)
                .input(SOLAR_CORE_III, 2)
                .input(wireGtDouble, Tritanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 4))
                .fluidInputs(BPAPolycarbonate.getFluid(9000))
                .fluidInputs(NiobiumTitanium, L * 4)
                .output(COVER_SOLAR_PANEL_ZPM)
                .EUt(VA[UV])
                .duration(20 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_LUV.getStackForm())
                        .CWUt(CWT[UV])
                        .EUt(VA[UV]))
                .buildAndRegister();


        //  UV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(COVER_SOLAR_PANEL_ZPM, 2)
                .input(EUROPIUM_WAFER, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(plate, IndiumGalliumPhosphide, 8)
                .input(VOLTAGE_COIL_UV, 2)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(foil, Europium, 32)
                .input(SOLAR_CORE_IV, 2)
                .input(wireGtDouble, Adamantium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 8))
                .fluidInputs(BPAPolycarbonate.getFluid(12000))
                .fluidInputs(FluxedElectrum.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UV)
                .EUt(VH[UHV])
                .duration(25 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_ZPM.getStackForm())
                        .CWUt(CWT[UHV])
                        .EUt(VH[UHV]))
                .buildAndRegister();

        //  UHV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Vibranium)
                .input(COVER_SOLAR_PANEL_UV, 2)
                .input(EUROPIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 4)
                .input(plate, Solarium)
                .input(VOLTAGE_COIL_UHV, 2)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(foil, PedotTMA, 32)
                .input(SOLAR_CORE_IV, 2)
                .input(wireGtDouble, Ichorium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 16))
                .fluidInputs(PMMA.getFluid(15000))
                .fluidInputs(HastelloyX78.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UHV)
                .EUt(VA[UEV])
                .duration(30 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UV.getStackForm())
                        .CWUt(CWT[UEV])
                        .EUt(VA[UEV]))
                .buildAndRegister();

        //  UEV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackTitanium)
                .input(COVER_SOLAR_PANEL_UHV, 2)
                .input(AMERICIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.UIV, 4)
                .input(plate, Solarium, 2)
                .input(VOLTAGE_COIL_UEV, 2)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 8)
                .input(foil, Seaborgium, 48)
                .input(SOLAR_CORE_IV, 2)
                .input(wireGtDouble, Astralium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 32))
                .fluidInputs(PMMA.getFluid(18000))
                .fluidInputs(HastelloyK243.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UEV)
                .EUt(VH[UIV])
                .duration(35 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UHV.getStackForm())
                        .CWUt(CWT[UIV])
                        .EUt(VH[UIV]))
                .buildAndRegister();

        //  UIV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackPlutonium)
                .input(COVER_SOLAR_PANEL_UEV, 2)
                .input(DUBNIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.UXV, 4)
                .input(EMITTER_UIV, 2)
                .input(SENSOR_UIV, 2)
                .input(plate, Solarium, 4)
                .input(plate, AstralTitanium, 4)
                .input(gear, CelestialTungsten, 2)
                .input(VOLTAGE_COIL_UIV, 2)
                .input(NANO_POWER_IC, 16)
                .input(foil, Hypogen, 64)
                .input(SOLAR_CORE_V, 4)
                .input(wireGtDouble, Hikarium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 64))
                .fluidInputs(CBDOPolycarbonate.getFluid(21000))
                .fluidInputs(SuperheavyHAlloy.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UIV)
                .EUt(VA[UXV])
                .duration(40 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UEV.getStackForm())
                        .CWUt(512)
                        .EUt(VA[UIV]))
                .buildAndRegister();

        /*
        //  UXV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Octiron)
                .input(COVER_SOLAR_PANEL_UIV, 2)
                .input(NEUTRONIUM_WAFER, 4)
                .input(circuit, MarkerMaterials.Tier.OpV, 4)
                .input(EMITTER_UXV, 2)
                .input(SENSOR_UXV, 2)
                .input(plateDouble, Solarium, 4)
                .input(plateDouble, HeavyQuarkDegenerateMatter, 4)
                .input(gear, QuantumchromodynamicallyConfinedMatter, 2)
                .input(VOLTAGE_COIL_UXV, 2)
                .input(PICO_POWER_IC, 32)
                .input(foil, CosmicNeutronium, 64)
                .input(SOLAR_CORE_V, 4)
                .input(wireGtDouble, Arcanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 128))
                .fluidInputs(CBDOPolycarbonate.getFluid(24000))
                .fluidInputs(Arcanium.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_UXV)
                .EUt(VZ[UXV])
                .duration(80 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UIV.getStackForm())
                        .CWUt(1024)
                        .EUt(VA[UXV]))
                .buildAndRegister();

        //  OpV Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Spacetime)
                .input(COVER_SOLAR_PANEL_UXV, 2)
                .input(NEUTRONIUM_WAFER, 8)
                .input(circuit, MarkerMaterials.Tier.MAX, 4)
                .input(EMITTER_OpV, 2)
                .input(SENSOR_OpV, 2)
                .input(plateDouble, Solarium, 8)
                .input(plateDouble, Shirabon, 8)
                .input(gear, Edenium, 2)
                .input(VOLTAGE_COIL_OpV, 2)
                .input(FEMTO_POWER_IC, 64)
                .input(foil, Universium, 64)
                .input(SOLAR_CORE_V, 4)
                .input(wireGtDouble, Galaxium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 256))
                .fluidInputs(Infinity.getFluid(48000))
                .fluidInputs(Galaxium.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_OpV)
                .EUt(VZ[OpV])
                .duration(160 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_UXV.getStackForm())
                        .CWUt(2048)
                        .EUt(VA[OpV]))
                .buildAndRegister();

        //  MAX Solar Panel
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Eternity)
                .input(COVER_SOLAR_PANEL_OPV, 2)
                .input(NEUTRONIUM_WAFER, 16)
                .input(circuit, MarkerMaterials.Tier.MAX, 16)
                .input(EMITTER_MAX, 2)
                .input(SENSOR_MAX, 2)
                .input(plateDouble, Solarium, 16)
                .input(plateDouble, Magmatter, 16)
                .input(gear, Aetherium, 2)
                .input(ULTIMATE_BATTERY_MK5)
                .input(FEMTO_POWER_IC, 64)
                .input(foil, Spacetime, 64)
                .input(wireGtDouble, PrimordialMatter, 4)
                .input(CHARGED_HYPERCUBE)
                .fluidInputs(SolderingAlloy.getFluid(L * 9 * 512))
                .fluidInputs(Infinity.getFluid(128000))
                .fluidInputs(Universium.getFluid(L * 4))
                .output(COVER_SOLAR_PANEL_MAX)
                .EUt(VZ[MAX])
                .duration(320 * SECOND)
                .stationResearch(b -> b
                        .researchStack(COVER_SOLAR_PANEL_OPV.getStackForm())
                        .CWUt(4096)
                        .EUt(VA[MAX]))
                .buildAndRegister();

         */
    }
}
