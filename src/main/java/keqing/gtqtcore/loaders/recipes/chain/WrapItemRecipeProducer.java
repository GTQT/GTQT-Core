package keqing.gtqtcore.loaders.recipes.chain;

import com.google.common.collect.HashBiMap;
import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import keqing.gtqtcore.common.items.GTQTMetaItems;


public class WrapItemRecipeProducer {

    private static final HashBiMap<MetaItem<?>.MetaValueItem, MetaItem<?>.MetaValueItem> wrapItems = HashBiMap.create();

    public static void register() {
        // Boards
        wrapItems.put(MetaItems.COATED_BOARD, GTQTMetaItems.WRAP_COATED_BOARD);
        wrapItems.put(MetaItems.PHENOLIC_BOARD, GTQTMetaItems.WRAP_PHENOLIC_BOARD);
        wrapItems.put(MetaItems.PLASTIC_BOARD, GTQTMetaItems.WRAP_PLASTIC_BOARD);
        wrapItems.put(MetaItems.EPOXY_BOARD, GTQTMetaItems.WRAP_EPOXY_BOARD);
        wrapItems.put(MetaItems.FIBER_BOARD, GTQTMetaItems.WRAP_FIBER_BOARD);
        wrapItems.put(MetaItems.MULTILAYER_FIBER_BOARD, GTQTMetaItems.WRAP_MULTILAYER_FIBER_BOARD);
        wrapItems.put(MetaItems.WETWARE_BOARD, GTQTMetaItems.WRAP_WETWARE_BOARD);
        wrapItems.put(GTQTMetaItems.GOOWARE_BOARD, GTQTMetaItems.WRAP_GOOWARE_BOARD);
        wrapItems.put(GTQTMetaItems.OPTICAL_BOARD, GTQTMetaItems.WRAP_OPTICAL_BOARD);
        wrapItems.put(GTQTMetaItems.SPINTRONIC_BOARD, GTQTMetaItems.WRAP_SPINTRONIC_BOARD);

        // Circuit Boards
        wrapItems.put(MetaItems.BASIC_CIRCUIT_BOARD, GTQTMetaItems.WRAP_BASIC_CIRCUIT_BOARD);
        wrapItems.put(MetaItems.GOOD_CIRCUIT_BOARD, GTQTMetaItems.WRAP_GOOD_CIRCUIT_BOARD);
        wrapItems.put(MetaItems.PLASTIC_CIRCUIT_BOARD, GTQTMetaItems.WRAP_PLASTIC_CIRCUIT_BOARD);
        wrapItems.put(MetaItems.ADVANCED_CIRCUIT_BOARD, GTQTMetaItems.WRAP_ADVANCED_CIRCUIT_BOARD);
        wrapItems.put(MetaItems.EXTREME_CIRCUIT_BOARD, GTQTMetaItems.WRAP_EXTREME_CIRCUIT_BOARD);
        wrapItems.put(MetaItems.ELITE_CIRCUIT_BOARD, GTQTMetaItems.WRAP_ELITE_CIRCUIT_BOARD);
        wrapItems.put(MetaItems.WETWARE_CIRCUIT_BOARD, GTQTMetaItems.WRAP_WETWARE_CIRCUIT_BOARD);
        wrapItems.put(GTQTMetaItems.GOOWARE_CIRCUIT_BOARD, GTQTMetaItems.WRAP_GOOWARE_CIRCUIT_BOARD);
        wrapItems.put(GTQTMetaItems.OPTICAL_CIRCUIT_BOARD, GTQTMetaItems.WRAP_OPTICAL_CIRCUIT_BOARD);
        wrapItems.put(GTQTMetaItems.SPINTRONIC_CIRCUIT_BOARD, GTQTMetaItems.WRAP_SPINTRONIC_CIRCUIT_BOARD);

        // SMDs
        wrapItems.put(MetaItems.SMD_TRANSISTOR, GTQTMetaItems.WRAP_SMD_TRANSISTOR);
        wrapItems.put(MetaItems.SMD_RESISTOR, GTQTMetaItems.WRAP_SMD_RESISTOR);
        wrapItems.put(MetaItems.SMD_CAPACITOR, GTQTMetaItems.WRAP_SMD_CAPACITOR);
        wrapItems.put(MetaItems.SMD_DIODE, GTQTMetaItems.WRAP_SMD_DIODE);
        wrapItems.put(MetaItems.SMD_INDUCTOR, GTQTMetaItems.WRAP_SMD_INDUCTOR);
        wrapItems.put(MetaItems.ADVANCED_SMD_TRANSISTOR, GTQTMetaItems.WRAP_ADVANCED_SMD_TRANSISTOR);
        wrapItems.put(MetaItems.ADVANCED_SMD_RESISTOR, GTQTMetaItems.WRAP_ADVANCED_SMD_RESISTOR);
        wrapItems.put(MetaItems.ADVANCED_SMD_CAPACITOR, GTQTMetaItems.WRAP_ADVANCED_SMD_CAPACITOR);
        wrapItems.put(MetaItems.ADVANCED_SMD_DIODE, GTQTMetaItems.WRAP_ADVANCED_SMD_DIODE);
        wrapItems.put(MetaItems.ADVANCED_SMD_INDUCTOR, GTQTMetaItems.WRAP_ADVANCED_SMD_INDUCTOR);
        wrapItems.put(GTQTMetaItems.GOOWARE_SMD_TRANSISTOR, GTQTMetaItems.WRAP_GOOWARE_SMD_TRANSISTOR);
        wrapItems.put(GTQTMetaItems.GOOWARE_SMD_RESISTOR, GTQTMetaItems.WRAP_GOOWARE_SMD_RESISTOR);
        wrapItems.put(GTQTMetaItems.GOOWARE_SMD_CAPACITOR, GTQTMetaItems.WRAP_GOOWARE_SMD_CAPACITOR);
        wrapItems.put(GTQTMetaItems.GOOWARE_SMD_DIODE, GTQTMetaItems.WRAP_GOOWARE_SMD_DIODE);
        wrapItems.put(GTQTMetaItems.GOOWARE_SMD_INDUCTOR, GTQTMetaItems.WRAP_GOOWARE_SMD_INDUCTOR);
        wrapItems.put(GTQTMetaItems.OPTICAL_SMD_TRANSISTOR, GTQTMetaItems.WRAP_OPTICAL_SMD_TRANSISTOR);
        wrapItems.put(GTQTMetaItems.OPTICAL_SMD_RESISTOR, GTQTMetaItems.WRAP_OPTICAL_SMD_RESISTOR);
        wrapItems.put(GTQTMetaItems.OPTICAL_SMD_CAPACITOR, GTQTMetaItems.WRAP_OPTICAL_SMD_CAPACITOR);
        wrapItems.put(GTQTMetaItems.OPTICAL_SMD_DIODE, GTQTMetaItems.WRAP_OPTICAL_SMD_DIODE);
        wrapItems.put(GTQTMetaItems.OPTICAL_SMD_INDUCTOR, GTQTMetaItems.WRAP_OPTICAL_SMD_INDUCTOR);
        wrapItems.put(GTQTMetaItems.SPINTRONIC_SMD_TRANSISTOR, GTQTMetaItems.WRAP_SPINTRONIC_SMD_TRANSISTOR);
        wrapItems.put(GTQTMetaItems.SPINTRONIC_SMD_RESISTOR, GTQTMetaItems.WRAP_SPINTRONIC_SMD_RESISTOR);
        wrapItems.put(GTQTMetaItems.SPINTRONIC_SMD_CAPACITOR, GTQTMetaItems.WRAP_SPINTRONIC_SMD_CAPACITOR);
        wrapItems.put(GTQTMetaItems.SPINTRONIC_SMD_DIODE, GTQTMetaItems.WRAP_SPINTRONIC_SMD_DIODE);
        wrapItems.put(GTQTMetaItems.SPINTRONIC_SMD_INDUCTOR, GTQTMetaItems.WRAP_SPINTRONIC_SMD_INDUCTOR);
        wrapItems.put(GTQTMetaItems.COSMIC_SMD_TRANSISTOR, GTQTMetaItems.WRAP_COSMIC_SMD_TRANSISTOR);
        wrapItems.put(GTQTMetaItems.COSMIC_SMD_RESISTOR, GTQTMetaItems.WRAP_COSMIC_SMD_RESISTOR);
        wrapItems.put(GTQTMetaItems.COSMIC_SMD_CAPACITOR, GTQTMetaItems.WRAP_COSMIC_SMD_CAPACITOR);
        wrapItems.put(GTQTMetaItems.COSMIC_SMD_DIODE, GTQTMetaItems.WRAP_COSMIC_SMD_DIODE);
        wrapItems.put(GTQTMetaItems.COSMIC_SMD_INDUCTOR, GTQTMetaItems.WRAP_COSMIC_SMD_INDUCTOR);
        wrapItems.put(GTQTMetaItems.SUPRACAUSAL_SMD_TRANSISTOR, GTQTMetaItems.WRAP_SUPRACAUSAL_SMD_TRANSISTOR);
        wrapItems.put(GTQTMetaItems.SUPRACAUSAL_SMD_RESISTOR, GTQTMetaItems.WRAP_SUPRACAUSAL_SMD_RESISTOR);
        wrapItems.put(GTQTMetaItems.SUPRACAUSAL_SMD_CAPACITOR, GTQTMetaItems.WRAP_SUPRACAUSAL_SMD_CAPACITOR);
        wrapItems.put(GTQTMetaItems.SUPRACAUSAL_SMD_DIODE, GTQTMetaItems.WRAP_SUPRACAUSAL_SMD_DIODE);
        wrapItems.put(GTQTMetaItems.SUPRACAUSAL_SMD_INDUCTOR, GTQTMetaItems.WRAP_SUPRACAUSAL_SMD_INDUCTOR);

        // Chips
        wrapItems.put(MetaItems.CENTRAL_PROCESSING_UNIT, GTQTMetaItems.WRAP_CPU_CHIP);
        wrapItems.put(MetaItems.RANDOM_ACCESS_MEMORY, GTQTMetaItems.WRAP_RAM_CHIP);
        wrapItems.put(MetaItems.INTEGRATED_LOGIC_CIRCUIT, GTQTMetaItems.WRAP_ILC_CHIP);
        wrapItems.put(MetaItems.NANO_CENTRAL_PROCESSING_UNIT, GTQTMetaItems.WRAP_NANO_CPU_CHIP);
        wrapItems.put(MetaItems.QUBIT_CENTRAL_PROCESSING_UNIT, GTQTMetaItems.WRAP_QUBIT_CPU_CHIP);
        wrapItems.put(MetaItems.SIMPLE_SYSTEM_ON_CHIP, GTQTMetaItems.WRAP_SIMPLE_SOC_CHIP);
        wrapItems.put(MetaItems.SYSTEM_ON_CHIP, GTQTMetaItems.WRAP_SOC_CHIP);
        wrapItems.put(MetaItems.ADVANCED_SYSTEM_ON_CHIP, GTQTMetaItems.WRAP_ADVANCED_SOC_CHIP);
        wrapItems.put(MetaItems.HIGHLY_ADVANCED_SOC, GTQTMetaItems.WRAP_HIGHLY_ADVANCED_SOC_CHIP);
        wrapItems.put(MetaItems.NAND_MEMORY_CHIP, GTQTMetaItems.WRAP_NAND_CHIP);
        wrapItems.put(MetaItems.NOR_MEMORY_CHIP, GTQTMetaItems.WRAP_NOR_CHIP);
        wrapItems.put(MetaItems.ULTRA_LOW_POWER_INTEGRATED_CIRCUIT, GTQTMetaItems.WRAP_ULPIC_CHIP);
        wrapItems.put(MetaItems.LOW_POWER_INTEGRATED_CIRCUIT, GTQTMetaItems.WRAP_LPIC_CHIP);
        wrapItems.put(MetaItems.POWER_INTEGRATED_CIRCUIT, GTQTMetaItems.WRAP_PIC_CHIP);
        wrapItems.put(MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT, GTQTMetaItems.WRAP_HPIC_CHIP);
        wrapItems.put(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, GTQTMetaItems.WRAP_UHPIC_CHIP);
        wrapItems.put(GTQTMetaItems.NANO_POWER_IC, GTQTMetaItems.WRAP_NPIC_CHIP);
        wrapItems.put(GTQTMetaItems.PICO_POWER_IC, GTQTMetaItems.WRAP_PPIC_CHIP);
        wrapItems.put(GTQTMetaItems.FEMTO_POWER_IC, GTQTMetaItems.WRAP_FPIC_CHIP);
        wrapItems.put(GTQTMetaItems.ATTO_PIC_CHIP, GTQTMetaItems.WRAP_APIC_CHIP);
        wrapItems.put(GTQTMetaItems.ZEPTO_PIC_CHIP, GTQTMetaItems.WRAP_ZPIC_CHIP);
        wrapItems.put(GTQTMetaItems.UHASOC_CHIP, GTQTMetaItems.WRAP_UHASOC_CHIP);
        wrapItems.put(GTQTMetaItems.CRYSTAL_INTERFACE_CHIP, GTQTMetaItems.WRAP_CRYSTAL_INTERFACE_CHIP);

        // Engraved Chips
        wrapItems.put(MetaItems.ENGRAVED_LAPOTRON_CHIP, GTQTMetaItems.WRAP_ENGRAVED_LAPOTRON_CHIP);
        wrapItems.put(GTQTMetaItems.ENGRAVED_DIAMOND_CRYSTAL_CHIP, GTQTMetaItems.WRAP_ENGRAVED_DIAMOND_CHIP);
        wrapItems.put(GTQTMetaItems.ENGRAVED_RUBY_CRYSTAL_CHIP, GTQTMetaItems.WRAP_ENGRAVED_RUBY_CHIP);
        wrapItems.put(GTQTMetaItems.ENGRAVED_SAPPHIRE_CRYSTAL_CHIP, GTQTMetaItems.WRAP_ENGRAVED_SAPPHIRE_CHIP);

        // Circuit Components
        wrapItems.put(MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT, GTQTMetaItems.WRAP_CRYSTAL_CPU);
        wrapItems.put(MetaItems.CRYSTAL_SYSTEM_ON_CHIP, GTQTMetaItems.WRAP_CRYSTAL_SOC);
        wrapItems.put(MetaItems.NEURO_PROCESSOR, GTQTMetaItems.WRAP_NEURO_PROCESSOR);
        wrapItems.put(GTQTMetaItems.NONLINEAR_CHEMICAL_OSCILLATOR, GTQTMetaItems.WRAP_NONLINEAR_CHEMICAL_OSCILLATOR);
        wrapItems.put(GTQTMetaItems.OPTICAL_LASER_CONTROL_UNIT, GTQTMetaItems.WRAP_OPTICAL_LASER_CONTROL_UNIT);
        wrapItems.put(GTQTMetaItems.OPTOELECTRONIC_SYSTEM_ON_CHIP, GTQTMetaItems.WRAP_OPTOELECTRONIC_SYSTEM_ON_CHIP);
        wrapItems.put(GTQTMetaItems.ESR_COMPUTATION_UNIT, GTQTMetaItems.WRAP_ESR_COMPUTATION_UNIT);
        wrapItems.put(GTQTMetaItems.EXOTIC_SOC, GTQTMetaItems.WRAP_EXOTIC_SYSTEM_ON_CHIP);

        // Add all Wrap Items
        wrapItems.forEach(WrapItemRecipeProducer::addRecipe);

        // Circuits
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.ULV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_ULV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_LV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.MV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_MV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.HV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_HV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.EV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_EV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.IV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_IV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.LuV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_LuV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.ZPM, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_ZPM)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.UV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_UV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.UHV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_UHV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.UEV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_UEV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.UIV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_UIV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.UXV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_UXV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.OpV, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_OpV)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.MAX, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(GTQTMetaItems.WRAP_CIRCUIT_MAX)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();

    }

    private static void addRecipe(MetaItem<?>.MetaValueItem originalItem, MetaItem<?>.MetaValueItem wrappedItem) {
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(16)
                .input(originalItem, 16)
                .fluidInputs(Materials.Polyethylene.getFluid(GTValues.L / 2))
                .output(wrappedItem)
                .EUt(GTValues.VA[GTValues.LV])
                .duration(5 * GTValues.SECOND)
                .buildAndRegister();
    }
}