package keqing.gtqtcore.loaders.recipes.chain;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.SCANNER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES;
import static keqing.gtqtcore.api.unification.GTQTMaterials.Adamantium;
import static keqing.gtqtcore.common.items.GTQTMetaItems.*;

public class CircuitAssemblyLineRecipeProducer {
    // @formatter:off

    static final String INFO_NBT_NAME = "CircuitInfo";

    public static void init()
    {
        addCircuit(VACUUM_TUBE);
        addCircuit(NAND_CHIP_ULV);

        addCircuit(ELECTRONIC_CIRCUIT_LV);
        addCircuit(INTEGRATED_CIRCUIT_LV);
        addCircuit(MICROPROCESSOR_LV);

        addCircuit(ELECTRONIC_CIRCUIT_MV);
        addCircuit(INTEGRATED_CIRCUIT_MV);
        addCircuit(PROCESSOR_MV);

        addCircuit(INTEGRATED_CIRCUIT_HV);
        addCircuit(PROCESSOR_ASSEMBLY_HV);
        addCircuit(NANO_PROCESSOR_HV);

        addCircuit(WORKSTATION_EV);
        addCircuit(NANO_PROCESSOR_ASSEMBLY_EV);
        addCircuit(QUANTUM_PROCESSOR_EV);

        addCircuit(MAINFRAME_IV);
        addCircuit(NANO_COMPUTER_IV);
        addCircuit(QUANTUM_ASSEMBLY_IV);
        addCircuit(CRYSTAL_PROCESSOR_IV);

        addCircuit(NANO_MAINFRAME_LUV);
        addCircuit(QUANTUM_COMPUTER_LUV);
        addCircuit(CRYSTAL_ASSEMBLY_LUV);
        addCircuit(WETWARE_PROCESSOR_LUV);

        addCircuit(QUANTUM_MAINFRAME_ZPM);
        addCircuit(CRYSTAL_COMPUTER_ZPM);
        addCircuit(WETWARE_PROCESSOR_ASSEMBLY_ZPM);
        addCircuit(GOOWARE_PROCESSOR_ZPM);

        addCircuit(CRYSTAL_MAINFRAME_UV);
        addCircuit(WETWARE_SUPER_COMPUTER_UV);
        addCircuit(GOOWARE_ASSEMBLY_UV);
        addCircuit(OPTICAL_PROCESSOR_UV);

        addCircuit(WETWARE_MAINFRAME_UHV);
        addCircuit(GOOWARE_COMPUTER_UHV);
        addCircuit(OPTICAL_ASSEMBLY_UHV);
        addCircuit(SPINTRONIC_PROCESSOR_UHV);

        addCircuit(GOOWARE_MAINFRAME_UEV);
        addCircuit(OPTICAL_COMPUTER_UEV);
        addCircuit(SPINTRONIC_ASSEMBLY_UEV);
        addCircuit(COSMIC_PROCESSOR_UEV);

        addCircuit(OPTICAL_MAINFRAME_UIV);
        addCircuit(SPINTRONIC_COMPUTER_UIV);
        addCircuit(COSMIC_ASSEMBLY_UIV);
        addCircuit(SUPRACAUSAL_PROCESSOR_UIV);

        addCircuit(SPINTRONIC_MAINFRAME_UXV);
        addCircuit(COSMIC_COMPUTER_UXV);
        addCircuit(SUPRACAUSAL_ASSEMBLY_UXV);

        addCircuit(COSMIC_MAINFRAME_OpV);
        addCircuit(SUPRACAUSAL_COMPUTER_OpV);

        addCircuit(SUPRACAUSAL_MAINFRAME_MAX);

        addCircuit(ENERGY_LAPOTRONIC_ORB);
        addCircuit(CRYSTAL_MODULATOR_DIAMOND);
        addCircuit(CRYSTAL_MODULATOR_RUBY);
        addCircuit(CRYSTAL_MODULATOR_SAPPHIRE);
        addCircuit(CRYSTAL_SYSTEM_ON_CHIP_SOCKET);

        /* ---------------------------------------------------------------------------------------------------------- */

        // T1: Electronic

        // Electronic Circuit
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_BASIC_CIRCUIT_BOARD)
                .input(WRAP_SMD_RESISTOR, 2)
                .input(VACUUM_TUBE, 32)
                .input(wireGtHex, RedAlloy, 2)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(ELECTRONIC_CIRCUIT_LV, 64)
                .EUt(VH[LV])
                .duration(1 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(ELECTRONIC_CIRCUIT_LV))
                .buildAndRegister();

        // Good Electronic Circuit
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOD_CIRCUIT_BOARD)
                .input(ELECTRONIC_CIRCUIT_LV, 32)
                .input(WRAP_SMD_DIODE, 2)
                .input(wireGtHex, Copper, 2)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(ELECTRONIC_CIRCUIT_MV, 32)
                .EUt(VH[LV])
                .duration(1 * MINUTE + 20 * SECOND) // Original: 15s, Wrapped: 15s * 16 = 240s
                .circuit(getCircuit(ELECTRONIC_CIRCUIT_MV))
                .buildAndRegister();

        // T2: Integrated

        // Integrated Circuit
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_BASIC_CIRCUIT_BOARD)
                .input(WRAP_ILC_CHIP)
                .input(WRAP_SMD_RESISTOR, 2)
                .input(WRAP_SMD_RESISTOR, 2)
                .input(wireGtQuadruple, Copper, 2)
                .input(bolt, Tin, 32)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(INTEGRATED_CIRCUIT_LV, 64)
                .EUt(VH[LV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(INTEGRATED_CIRCUIT_LV))
                .buildAndRegister();

        // Good Integrated Circuit
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOD_CIRCUIT_BOARD)
                .input(INTEGRATED_CIRCUIT_LV, 64)
                .input(WRAP_SMD_RESISTOR, 2)
                .input(WRAP_SMD_DIODE, 2)
                .input(wireGtQuadruple, Gold, 4)
                .input(bolt, Silver, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(INTEGRATED_CIRCUIT_MV, 48)
                .EUt(24) // LV
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(INTEGRATED_CIRCUIT_MV))
                .buildAndRegister();

        // Advanced Integrated Circuit
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(INTEGRATED_CIRCUIT_MV, 48)
                .input(WRAP_ILC_CHIP, 2)
                .input(WRAP_RAM_CHIP, 2)
                .input(WRAP_SMD_TRANSISTOR, 4)
                .input(wireGtQuadruple, Electrum, 8)
                .input(bolt, AnnealedCopper, 64)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(INTEGRATED_CIRCUIT_HV, 32)
                .EUt(VA[LV])
                .duration(8 * MINUTE) // Original: 40s, Wrapped: 40s * 16 = 640s
                .circuit(getCircuit(INTEGRATED_CIRCUIT_HV))
                .buildAndRegister();

        // T3: Processor

        // NAND Chip
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOD_CIRCUIT_BOARD)
                .input(WRAP_SIMPLE_SOC_CHIP)
                .input(bolt, RedAlloy, 32)
                .input(wireGtQuadruple, Tin, 2)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(NAND_CHIP_ULV, 64)
                .output(NAND_CHIP_ULV, 64)
                .EUt(VA[MV])
                .duration(3 * MINUTE) // Original: 15s, Wrapped: 15s * 16 = 240s
                .circuit(getCircuit(NAND_CHIP_ULV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(WRAP_SIMPLE_SOC_CHIP)
                .input(bolt, RedAlloy, 32)
                .input(wireGtQuadruple, Tin, 2)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(NAND_CHIP_ULV, 64)
                .output(NAND_CHIP_ULV, 64)
                .output(NAND_CHIP_ULV, 64)
                .output(NAND_CHIP_ULV, 64)
                .EUt(VA[MV])
                .duration(3 * MINUTE) // Original: 15s, Wrapped: 15s * 16 = 240s
                .circuit(getCircuit(NAND_CHIP_ULV))
                .buildAndRegister();;

        // Microprocessor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(WRAP_CPU_CHIP)
                .input(WRAP_SMD_RESISTOR, 2)
                .input(WRAP_SMD_CAPACITOR, 2)
                .input(WRAP_SMD_TRANSISTOR, 2)
                .input(wireGtQuadruple, Copper)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(MICROPROCESSOR_LV, 64)
                .EUt(VHA[MV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(MICROPROCESSOR_LV))
                .buildAndRegister();;

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(WRAP_SOC_CHIP)
                .input(wireGtQuadruple, Copper, 2)
                .input(bolt, Tin, 32)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(MICROPROCESSOR_LV, 64)
                .output(MICROPROCESSOR_LV, 64)
                .EUt(600) // EV
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(MICROPROCESSOR_LV))
                .buildAndRegister();;

        // Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(WRAP_CPU_CHIP)
                .input(WRAP_SMD_RESISTOR, 4)
                .input(WRAP_SMD_CAPACITOR, 4)
                .input(WRAP_SMD_TRANSISTOR, 4)
                .input(wireGtQuadruple, RedAlloy, 4)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(PROCESSOR_MV, 64)
                .EUt(VHA[MV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(PROCESSOR_MV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(WRAP_SOC_CHIP)
                .input(wireGtQuadruple, RedAlloy, 4)
                .input(bolt, AnnealedCopper, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(PROCESSOR_MV, 64)
                .output(PROCESSOR_MV, 64)
                .EUt(2400) // IV
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(PROCESSOR_MV))
                .buildAndRegister();

        // Processor Assembly
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(PROCESSOR_MV, 64)
                .input(WRAP_SMD_INDUCTOR, 4)
                .input(WRAP_SMD_CAPACITOR, 8)
                .input(WRAP_RAM_CHIP, 4)
                .input(wireGtQuadruple, RedAlloy, 8)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(PROCESSOR_ASSEMBLY_HV, 48)
                .EUt(90) // MV
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(PROCESSOR_ASSEMBLY_HV))
                .buildAndRegister();

        // Workstation
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(PROCESSOR_ASSEMBLY_HV, 48)
                .input(WRAP_SMD_DIODE, 4)
                .input(WRAP_RAM_CHIP, 4)
                .input(wireGtQuadruple, Electrum, 16)
                .input(bolt, BlueAlloy, 64)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(WORKSTATION_EV, 32)
                .EUt(VA[MV])
                .duration(5 * MINUTE) // Original: 20s, Wrapped: 20ss * 16 = 320s
                .circuit(getCircuit(WORKSTATION_EV))
                .buildAndRegister();

        // Mainframe
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium, 32)
                .input(WORKSTATION_EV, 32)
                .input(WRAP_SMD_INDUCTOR, 8)
                .input(WRAP_SMD_CAPACITOR, 16)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtHex, AnnealedCopper, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(MAINFRAME_IV, 16)
                .EUt(VA[HV])
                .duration(8 * MINUTE) // Original: 40s, Wrapped: 40s * 16 = 640s
                .circuit(getCircuit(MAINFRAME_IV))
                .buildAndRegister();

        // T4: Nano

        // Nano Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(WRAP_NANO_CPU_CHIP)
                .input(WRAP_SMD_RESISTOR, 8)
                .input(WRAP_SMD_CAPACITOR, 8)
                .input(WRAP_SMD_TRANSISTOR, 8)
                .input(wireGtQuadruple, Electrum, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(NANO_PROCESSOR_HV, 64)
                .EUt(600) // EV
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(NANO_PROCESSOR_HV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(WRAP_NANO_CPU_CHIP)
                .input(WRAP_ADVANCED_SMD_RESISTOR, 2)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 2)
                .input(WRAP_ADVANCED_SMD_TRANSISTOR, 2)
                .input(wireGtQuadruple, Electrum, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(NANO_PROCESSOR_HV, 64)
                .EUt(600) // EV
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(NANO_PROCESSOR_HV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(WRAP_ADVANCED_SOC_CHIP)
                .input(wireGtQuadruple, Electrum, 4)
                .input(bolt, Platinum, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(NANO_PROCESSOR_HV, 64)
                .output(NANO_PROCESSOR_HV, 64)
                .EUt(9600) // LuV
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(NANO_PROCESSOR_HV))
                .buildAndRegister();

        // Nano Processor Assembly
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_HV, 64)
                .input(WRAP_SMD_INDUCTOR, 4)
                .input(WRAP_SMD_CAPACITOR, 8)
                .input(WRAP_RAM_CHIP, 8)
                .input(wireGtQuadruple, Electrum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(NANO_PROCESSOR_ASSEMBLY_EV, 48)
                .EUt(600) // EV
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(NANO_PROCESSOR_ASSEMBLY_EV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_HV, 64)
                .input(WRAP_ADVANCED_SMD_INDUCTOR)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 2)
                .input(WRAP_RAM_CHIP, 8)
                .input(wireGtQuadruple, Electrum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(NANO_PROCESSOR_ASSEMBLY_EV, 48)
                .EUt(600) // EV
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(NANO_PROCESSOR_ASSEMBLY_EV))
                .buildAndRegister();

        // Nano Computer
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 48)
                .input(WRAP_SMD_DIODE, 8)
                .input(WRAP_NOR_CHIP, 4)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtQuadruple, Electrum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(NANO_COMPUTER_IV, 32)
                .EUt(600) // EV
                .duration(5 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(NANO_COMPUTER_IV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 48)
                .input(WRAP_ADVANCED_SMD_DIODE, 2)
                .input(WRAP_NOR_CHIP, 4)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtQuadruple, Electrum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(NANO_COMPUTER_IV, 32)
                .EUt(600) // EV
                .duration(2 * MINUTE + 30 * SECOND) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(NANO_COMPUTER_IV))
                .buildAndRegister();

        // Nano Mainframe
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel, 32)
                .input(NANO_COMPUTER_IV, 32)
                .input(WRAP_SMD_INDUCTOR, 16)
                .input(WRAP_SMD_CAPACITOR, 32)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtHex, AnnealedCopper, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(NANO_MAINFRAME_LUV, 16)
                .EUt(VA[EV])
                .duration(8 * MINUTE) // Original: 40s, Wrapped: 40s * 16 = 640s
                .circuit(getCircuit(NANO_MAINFRAME_LUV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel, 32)
                .input(NANO_COMPUTER_IV, 32)
                .input(WRAP_ADVANCED_SMD_INDUCTOR, 4)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 8)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtHex, AnnealedCopper, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(NANO_MAINFRAME_LUV, 16)
                .EUt(VA[EV])
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(NANO_MAINFRAME_LUV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, VanadiumSteel, 32)
                .input(NANO_COMPUTER_IV, 32)
                .input(WRAP_GOOWARE_SMD_INDUCTOR)
                .input(WRAP_GOOWARE_SMD_CAPACITOR, 2)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtHex, AnnealedCopper, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(NANO_MAINFRAME_LUV, 16)
                .EUt(VA[EV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(NANO_MAINFRAME_LUV))
                .buildAndRegister();

        // T5: Quantum

        // Quantum Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(WRAP_QUBIT_CPU_CHIP)
                .input(WRAP_NANO_CPU_CHIP)
                .input(WRAP_SMD_CAPACITOR, 12)
                .input(WRAP_SMD_TRANSISTOR, 12)
                .input(wireGtQuadruple, Platinum, 12)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(QUANTUM_PROCESSOR_EV, 64)
                .EUt(2400) // IV
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(QUANTUM_PROCESSOR_EV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(WRAP_QUBIT_CPU_CHIP)
                .input(WRAP_NANO_CPU_CHIP)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 3)
                .input(WRAP_ADVANCED_SMD_TRANSISTOR, 3)
                .input(wireGtQuadruple, Platinum, 12)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(QUANTUM_PROCESSOR_EV, 64)
                .EUt(2400) // IV
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(QUANTUM_PROCESSOR_EV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(WRAP_ADVANCED_SOC_CHIP)
                .input(wireGtQuadruple, Platinum, 12)
                .input(bolt, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(QUANTUM_PROCESSOR_EV, 64)
                .output(QUANTUM_PROCESSOR_EV, 64)
                .EUt(38400) // ZPM
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(QUANTUM_PROCESSOR_EV))
                .buildAndRegister();

        // Quantum Processor Assembly
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_PROCESSOR_EV, 64)
                .input(WRAP_SMD_INDUCTOR, 8)
                .input(WRAP_SMD_CAPACITOR, 16)
                .input(WRAP_RAM_CHIP, 4)
                .input(wireGtQuadruple, Platinum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(QUANTUM_ASSEMBLY_IV, 48)
                .EUt(2400) // IV
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(QUANTUM_ASSEMBLY_IV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_PROCESSOR_EV, 64)
                .input(WRAP_ADVANCED_SMD_INDUCTOR, 2)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 4)
                .input(WRAP_RAM_CHIP, 4)
                .input(wireGtQuadruple, Platinum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(QUANTUM_ASSEMBLY_IV, 48)
                .EUt(2400) // IV
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(QUANTUM_ASSEMBLY_IV))
                .buildAndRegister();

        // Quantum Supercomputer
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_ASSEMBLY_IV, 48)
                .input(WRAP_SMD_DIODE, 8)
                .input(WRAP_NOR_CHIP, 4)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtQuadruple, Platinum, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(QUANTUM_COMPUTER_LUV, 32)
                .EUt(2400) // IV
                .duration(5 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(QUANTUM_COMPUTER_LUV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_ASSEMBLY_IV, 48)
                .input(WRAP_ADVANCED_SMD_DIODE, 2)
                .input(WRAP_NOR_CHIP, 4)
                .input(WRAP_RAM_CHIP, 16)
                .input(wireGtQuadruple, Platinum, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(QUANTUM_COMPUTER_LUV, 32)
                .EUt(2400) // IV
                .duration(2 * MINUTE + 30 * SECOND) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(QUANTUM_COMPUTER_LUV))
                .buildAndRegister();

        // Quantum Mainframe
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSG, 32)
                .input(QUANTUM_COMPUTER_LUV, 32)
                .input(WRAP_SMD_INDUCTOR, 24)
                .input(WRAP_SMD_CAPACITOR, 48)
                .input(WRAP_RAM_CHIP, 24)
                .input(wireGtHex, AnnealedCopper, 48)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(QUANTUM_MAINFRAME_ZPM, 16)
                .EUt(VA[IV])
                .duration(8 * MINUTE) // Original: 40s, Wrapped: 40s * 16 = 640s
                .circuit(getCircuit(QUANTUM_MAINFRAME_ZPM))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSG, 32)
                .input(QUANTUM_COMPUTER_LUV, 32)
                .input(WRAP_ADVANCED_SMD_INDUCTOR, 6)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 12)
                .input(WRAP_RAM_CHIP, 24)
                .input(wireGtHex, AnnealedCopper, 48)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .output(QUANTUM_MAINFRAME_ZPM, 16)
                .EUt(VA[IV])
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(QUANTUM_MAINFRAME_ZPM))
                .buildAndRegister();

        // T6: Crystal

        // Crystal Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ELITE_CIRCUIT_BOARD)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_NANO_CPU_CHIP, 2)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 4)
                .input(WRAP_ADVANCED_SMD_TRANSISTOR, 4)
                .input(wireGtQuadruple, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(CRYSTAL_PROCESSOR_IV, 64)
                .EUt(9600) // LuV
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(CRYSTAL_PROCESSOR_IV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ELITE_CIRCUIT_BOARD)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_NANO_CPU_CHIP, 2)
                .input(WRAP_GOOWARE_SMD_CAPACITOR)
                .input(WRAP_GOOWARE_SMD_TRANSISTOR)
                .input(wireGtQuadruple, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(CRYSTAL_PROCESSOR_IV, 64)
                .EUt(9600) // LuV
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(CRYSTAL_PROCESSOR_IV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ELITE_CIRCUIT_BOARD)
                .input(WRAP_CRYSTAL_SOC)
                .input(wireGtQuadruple, NiobiumTitanium, 8)
                .input(bolt, YttriumBariumCuprate, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(CRYSTAL_PROCESSOR_IV, 64)
                .output(CRYSTAL_PROCESSOR_IV, 64)
                .EUt(86000) // ZPM
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(CRYSTAL_PROCESSOR_IV))
                .buildAndRegister();

        // Crystal Processor Assembly
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_PROCESSOR_IV, 64)
                .input(WRAP_ADVANCED_SMD_INDUCTOR, 4)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 8)
                .input(WRAP_RAM_CHIP, 24)
                .input(wireGtQuadruple, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(CRYSTAL_ASSEMBLY_LUV, 48)
                .EUt(9600) // LuV
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(CRYSTAL_ASSEMBLY_LUV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_PROCESSOR_IV, 64)
                .input(WRAP_GOOWARE_SMD_INDUCTOR)
                .input(WRAP_GOOWARE_SMD_CAPACITOR, 2)
                .input(WRAP_RAM_CHIP, 24)
                .input(wireGtQuadruple, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(CRYSTAL_ASSEMBLY_LUV, 48)
                .EUt(9600) // LuV
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(CRYSTAL_ASSEMBLY_LUV))
                .buildAndRegister();

        // Crystal Supercomputer
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_ASSEMBLY_LUV, 48)
                .input(WRAP_RAM_CHIP, 4)
                .input(WRAP_NOR_CHIP, 32)
                .input(WRAP_NAND_CHIP, 64)
                .input(wireGtQuadruple, NiobiumTitanium, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(CRYSTAL_COMPUTER_ZPM, 32)
                .EUt(9600) // LuV
                .duration(5 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(CRYSTAL_COMPUTER_ZPM))
                .buildAndRegister();

        // T7: Wetware

        // Wetware Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_NEURO_PROCESSOR)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_QUBIT_CPU_CHIP)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 8)
                .input(WRAP_ADVANCED_SMD_TRANSISTOR, 8)
                .input(wireGtQuadruple, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(WETWARE_PROCESSOR_LUV, 64)
                .EUt(38400) // ZPM
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(WETWARE_PROCESSOR_LUV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_NEURO_PROCESSOR)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_QUBIT_CPU_CHIP)
                .input(WRAP_GOOWARE_SMD_CAPACITOR, 2)
                .input(WRAP_GOOWARE_SMD_TRANSISTOR, 2)
                .input(wireGtQuadruple, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(WETWARE_PROCESSOR_LUV, 64)
                .EUt(38400) // ZPM
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(WETWARE_PROCESSOR_LUV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_NEURO_PROCESSOR)
                .input(WRAP_HIGHLY_ADVANCED_SOC_CHIP)
                .input(wireGtQuadruple, YttriumBariumCuprate, 8)
                .input(bolt, Naquadah, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(WETWARE_PROCESSOR_LUV, 64)
                .output(WETWARE_PROCESSOR_LUV, 64)
                .EUt(150_000) // UV
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(WETWARE_PROCESSOR_LUV))
                .buildAndRegister();

        // Wetware Processor Assembly
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_LUV, 64)
                .input(WRAP_ADVANCED_SMD_INDUCTOR, 8)
                .input(WRAP_ADVANCED_SMD_CAPACITOR, 16)
                .input(WRAP_RAM_CHIP, 24)
                .input(wireGtQuadruple, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 48)
                .EUt(38400) // ZPM
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(WETWARE_PROCESSOR_ASSEMBLY_ZPM))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_LUV, 64)
                .input(WRAP_GOOWARE_SMD_INDUCTOR, 2)
                .input(WRAP_GOOWARE_SMD_CAPACITOR, 4)
                .input(WRAP_RAM_CHIP, 24)
                .input(wireGtQuadruple, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 48)
                .EUt(38400) // ZPM
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(WETWARE_PROCESSOR_ASSEMBLY_ZPM))
                .buildAndRegister();

        // Wetware Supercomputer
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 48)
                .input(WRAP_RAM_CHIP, 8)
                .input(WRAP_NOR_CHIP, 64)
                .input(WRAP_NAND_CHIP, 64)
                .input(wireGtQuadruple, YttriumBariumCuprate, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(WETWARE_SUPER_COMPUTER_UV, 32)
                .EUt(38400) // ZPM
                .duration(5 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(WETWARE_SUPER_COMPUTER_UV))
                .buildAndRegister();

        // Wetware Mainframe

        // T8: Gooware

        // Gooware Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOWARE_CIRCUIT_BOARD)
                .input(WRAP_NONLINEAR_CHEMICAL_OSCILLATOR)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_GOOWARE_SMD_CAPACITOR, 16)
                .input(WRAP_GOOWARE_SMD_TRANSISTOR, 16)
                .input(wireGtQuadruple, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(GOOWARE_PROCESSOR_ZPM, 64)
                .EUt(VHA[UV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(GOOWARE_PROCESSOR_ZPM))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOWARE_CIRCUIT_BOARD)
                .input(WRAP_NONLINEAR_CHEMICAL_OSCILLATOR)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_OPTICAL_SMD_CAPACITOR, 4)
                .input(WRAP_OPTICAL_SMD_TRANSISTOR, 4)
                .input(wireGtQuadruple, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(GOOWARE_PROCESSOR_ZPM, 64)
                .EUt(VHA[UV])
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(GOOWARE_PROCESSOR_ZPM))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOWARE_CIRCUIT_BOARD)
                .input(WRAP_NONLINEAR_CHEMICAL_OSCILLATOR)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_SPINTRONIC_SMD_CAPACITOR)
                .input(WRAP_SPINTRONIC_SMD_TRANSISTOR)
                .input(wireGtQuadruple, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(GOOWARE_PROCESSOR_ZPM, 64)
                .EUt(VHA[UV])
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(GOOWARE_PROCESSOR_ZPM))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOWARE_CIRCUIT_BOARD)
                .input(WRAP_NONLINEAR_CHEMICAL_OSCILLATOR)
                .input(WRAP_UHASOC_CHIP)
                .input(wireGtQuadruple, Europium, 8)
                .input(bolt, Neutronium, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(GOOWARE_PROCESSOR_ZPM, 64)
                .output(GOOWARE_PROCESSOR_ZPM, 64)
                .EUt(VHA[UHV])
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(GOOWARE_PROCESSOR_ZPM))
                .buildAndRegister();

        // Gooware Processor Assembly
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOWARE_CIRCUIT_BOARD)
                .input(GOOWARE_PROCESSOR_ZPM, 64)
                .input(WRAP_GOOWARE_SMD_INDUCTOR, 16)
                .input(WRAP_GOOWARE_SMD_CAPACITOR, 32)
                .input(WRAP_RAM_CHIP, 32)
                .input(wireGtQuadruple, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(GOOWARE_ASSEMBLY_UV, 48)
                .EUt(VHA[UV])
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(GOOWARE_ASSEMBLY_UV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOWARE_CIRCUIT_BOARD)
                .input(GOOWARE_PROCESSOR_ZPM, 64)
                .input(WRAP_OPTICAL_SMD_INDUCTOR, 4)
                .input(WRAP_OPTICAL_SMD_CAPACITOR, 8)
                .input(WRAP_RAM_CHIP, 32)
                .input(wireGtQuadruple, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(GOOWARE_ASSEMBLY_UV, 48)
                .EUt(VHA[UV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(GOOWARE_ASSEMBLY_UV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_GOOWARE_CIRCUIT_BOARD)
                .input(GOOWARE_PROCESSOR_ZPM, 64)
                .input(WRAP_SPINTRONIC_SMD_INDUCTOR)
                .input(WRAP_SPINTRONIC_SMD_CAPACITOR, 2)
                .input(WRAP_RAM_CHIP, 32)
                .input(wireGtQuadruple, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(GOOWARE_ASSEMBLY_UV, 48)
                .EUt(VHA[UV])
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(GOOWARE_ASSEMBLY_UV))
                .buildAndRegister();

        // Gooware Supercomputer

        // Gooware Mainframe

        // T9: Optical

        // Optical Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_OPTICAL_LASER_CONTROL_UNIT)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_OPTICAL_SMD_RESISTOR, 16)
                .input(WRAP_OPTICAL_SMD_CAPACITOR, 16)
                .input(WRAP_OPTICAL_SMD_TRANSISTOR, 16)
                .input(OPTICAL_FIBER, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(OPTICAL_PROCESSOR_UV, 64)
                .EUt(VA[UHV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(OPTICAL_PROCESSOR_UV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_OPTICAL_LASER_CONTROL_UNIT)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_SPINTRONIC_SMD_RESISTOR, 4)
                .input(WRAP_SPINTRONIC_SMD_CAPACITOR, 4)
                .input(WRAP_SPINTRONIC_SMD_TRANSISTOR, 4)
                .input(OPTICAL_FIBER, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(OPTICAL_PROCESSOR_UV, 64)
                .EUt(VA[UHV])
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(OPTICAL_PROCESSOR_UV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_OPTICAL_LASER_CONTROL_UNIT)
                .input(WRAP_CRYSTAL_CPU)
                .input(WRAP_COSMIC_SMD_RESISTOR)
                .input(WRAP_COSMIC_SMD_CAPACITOR)
                .input(WRAP_COSMIC_SMD_TRANSISTOR)
                .input(OPTICAL_FIBER, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(OPTICAL_PROCESSOR_UV, 64)
                .EUt(VA[UHV])
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(OPTICAL_PROCESSOR_UV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_OPTICAL_LASER_CONTROL_UNIT)
                .input(WRAP_OPTOELECTRONIC_SYSTEM_ON_CHIP)
                .input(OPTICAL_FIBER, 64)
                .input(bolt, Adamantium, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(OPTICAL_PROCESSOR_UV, 64)
                .output(OPTICAL_PROCESSOR_UV, 64)
                .EUt(VA[UEV])
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(OPTICAL_PROCESSOR_UV))
                .buildAndRegister();

        // Optical Processor Assembly
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_PROCESSOR_UV, 64)
                .input(WRAP_OPTICAL_SMD_INDUCTOR, 16)
                .input(WRAP_OPTICAL_SMD_CAPACITOR, 32)
                .input(WRAP_HIGHLY_ADVANCED_SOC_CHIP, 32)
                .input(OPTICAL_FIBER, 64)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(OPTICAL_ASSEMBLY_UHV, 48)
                .EUt(VA[UHV])
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .circuit(getCircuit(OPTICAL_ASSEMBLY_UHV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_PROCESSOR_UV, 64)
                .input(WRAP_SPINTRONIC_SMD_INDUCTOR, 4)
                .input(WRAP_SPINTRONIC_SMD_CAPACITOR, 8)
                .input(WRAP_HIGHLY_ADVANCED_SOC_CHIP, 32)
                .input(OPTICAL_FIBER, 64)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(OPTICAL_ASSEMBLY_UHV, 48)
                .EUt(VA[UHV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(OPTICAL_ASSEMBLY_UHV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_PROCESSOR_UV, 64)
                .input(WRAP_COSMIC_SMD_INDUCTOR)
                .input(WRAP_COSMIC_SMD_CAPACITOR, 2)
                .input(WRAP_HIGHLY_ADVANCED_SOC_CHIP, 32)
                .input(OPTICAL_FIBER, 64)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(OPTICAL_ASSEMBLY_UHV, 48)
                .EUt(VA[UHV])
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(OPTICAL_ASSEMBLY_UHV))
                .buildAndRegister();

        // Optical Computer

        // Optical Mainframe

        /*
        // T10: Spintronic

        // Spintronic Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ESR_COMPUTATION_UNIT)
                .input(WRAP_CRYSTAL_SOC)
                .input(WRAP_SPINTRONIC_SMD_RESISTOR, 16)
                .input(WRAP_SPINTRONIC_SMD_CAPACITOR, 16)
                .input(WRAP_SPINTRONIC_SMD_TRANSISTOR, 16)
                .input(wireFine, CarbonNanotube, 64)
                .fluidInputs(MutatedLivingSolder.getFluid(L / 2))
                .output(SPINTRONIC_PROCESSOR_UHV, 64)
                .EUt(VA[UEV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(SPINTRONIC_PROCESSOR_UHV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ESR_COMPUTATION_UNIT)
                .input(WRAP_CRYSTAL_SOC)
                .input(WRAP_COSMIC_SMD_RESISTOR, 4)
                .input(WRAP_COSMIC_SMD_CAPACITOR, 4)
                .input(WRAP_COSMIC_SMD_TRANSISTOR, 4)
                .input(wireFine, CarbonNanotube, 64)
                .fluidInputs(MutatedLivingSolder.getFluid(L / 2))
                .output(SPINTRONIC_PROCESSOR_UHV, 64)
                .EUt(VA[UEV])
                .duration(1 * MINUTE) // Original: 5s, Wrapped: 5s * 16 = 80s
                .circuit(getCircuit(SPINTRONIC_PROCESSOR_UHV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ESR_COMPUTATION_UNIT)
                .input(WRAP_CRYSTAL_SOC)
                .input(WRAP_SUPRACAUSAL_SMD_RESISTOR)
                .input(WRAP_SUPRACAUSAL_SMD_CAPACITOR)
                .input(WRAP_SUPRACAUSAL_SMD_TRANSISTOR)
                .input(wireFine, CarbonNanotube, 64)
                .fluidInputs(MutatedLivingSolder.getFluid(L / 2))
                .output(SPINTRONIC_PROCESSOR_UHV, 64)
                .EUt(VA[UEV])
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(SPINTRONIC_PROCESSOR_UHV))
                .buildAndRegister();

        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ESR_COMPUTATION_UNIT)
                .input(WRAP_EXOTIC_SYSTEM_ON_CHIP)
                .input(wireFine, CarbonNanotube, 64)
                .input(bolt, Vibranium, 64)
                .fluidInputs(MutatedLivingSolder.getFluid(L / 2))
                .output(SPINTRONIC_PROCESSOR_UHV, 64)
                .output(SPINTRONIC_PROCESSOR_UHV, 64)
                .EUt(VA[UIV])
                .duration(30 * SECOND) // Original: 2.5s, Wrapped: 2.5s * 16 = 40s
                .circuit(getCircuit(SPINTRONIC_PROCESSOR_UHV))
                .buildAndRegister();

        // Spintronic Processor Assembly

        // Spintronic Computer

        // Spintronic Mainframe

         */

        // ---------------------------------------------------------------------------------------------------------

        // Lapotronic Orb
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(WRAP_PIC_CHIP, 4)
                .input(WRAP_ENGRAVED_LAPOTRON_CHIP, 24)
                .input(WRAP_NANO_CPU_CHIP, 2)
                .input(wireGtQuadruple, Platinum, 16)
                .input(plate, Platinum, 64)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(ENERGY_LAPOTRONIC_ORB, 16)
                .EUt(VH[EV])
                .duration(6 * MINUTE) // Original: 25.6s, Wrapped: 25.6s * 16 = 409.6s
                .circuit(getCircuit(ENERGY_LAPOTRONIC_ORB))
                .buildAndRegister();

        // Data Stick
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ADVANCED_CIRCUIT_BOARD)
                .input(circuit, MarkerMaterials.Tier.HV, 32)
                .input(WRAP_RAM_CHIP, 4)
                .input(WRAP_NOR_CHIP, 16)
                .input(WRAP_NAND_CHIP, 32)
                .input(wireGtQuadruple, Platinum, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(TOOL_DATA_STICK, 16)
                .EUt(1200) // EV
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .buildAndRegister();

        // Data Orb
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_EXTREME_CIRCUIT_BOARD)
                .input(circuit, MarkerMaterials.Tier.IV, 32)
                .input(WRAP_RAM_CHIP, 8)
                .input(WRAP_NOR_CHIP, 32)
                .input(WRAP_NAND_CHIP, 48)
                .input(wireGtQuadruple, NiobiumTitanium, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(TOOL_DATA_ORB, 16)
                .EUt(9600) // LuV
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .buildAndRegister();

        // Data Module
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_WETWARE_CIRCUIT_BOARD)
                .input(circuit, MarkerMaterials.Tier.ZPM, 32)
                .input(WRAP_RAM_CHIP, 32)
                .input(WRAP_NOR_CHIP, 64)
                .input(WRAP_NAND_CHIP, 64)
                .input(wireGtQuadruple, YttriumBariumCuprate, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(TOOL_DATA_MODULE, 16)
                .EUt(38400) // ZPM
                .duration(4 * MINUTE) // Original: 20s, Wrapped: 20s * 16 = 320s
                .buildAndRegister();

        // Diamond Modulator
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ENGRAVED_DIAMOND_CHIP)
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 64)
                .input(bolt, Platinum, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(CRYSTAL_MODULATOR_DIAMOND, 64)
                .output(CRYSTAL_MODULATOR_DIAMOND, 64)
                .EUt(VA[IV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(CRYSTAL_MODULATOR_DIAMOND))
                .buildAndRegister();

        // Ruby Modulator
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ENGRAVED_RUBY_CHIP)
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 64)
                .input(bolt, Platinum, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(CRYSTAL_MODULATOR_RUBY, 64)
                .output(CRYSTAL_MODULATOR_RUBY, 64)
                .EUt(VA[IV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(CRYSTAL_MODULATOR_RUBY))
                .buildAndRegister();

        // Sapphire Modulator
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_ENGRAVED_SAPPHIRE_CHIP)
                .input(WRAP_PLASTIC_CIRCUIT_BOARD)
                .input(wireFine, Palladium, 64)
                .input(bolt, Platinum, 64)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(CRYSTAL_MODULATOR_SAPPHIRE, 64)
                .output(CRYSTAL_MODULATOR_SAPPHIRE, 64)
                .EUt(VA[IV])
                .duration(2 * MINUTE) // Original: 10s, Wrapped: 10s * 16 = 160s
                .circuit(getCircuit(CRYSTAL_MODULATOR_SAPPHIRE))
                .buildAndRegister();

        // Crystal SoC Socket
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_CRYSTAL_INTERFACE_CHIP)
                .input(CRYSTAL_MODULATOR_DIAMOND, 16)
                .input(CRYSTAL_MODULATOR_RUBY, 16)
                .input(CRYSTAL_MODULATOR_SAPPHIRE, 16)
                .input(wireGtQuadruple, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L / 2))
                .output(CRYSTAL_SYSTEM_ON_CHIP_SOCKET, 16)
                .EUt(VA[LuV])
                .duration(20 * SECOND) // Original: 5s, Wrapped: 5s * 16 = 40s
                .circuit(getCircuit(CRYSTAL_SYSTEM_ON_CHIP_SOCKET))
                .buildAndRegister();

        // Neuro Processor
        LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(WRAP_WETWARE_CIRCUIT_BOARD)
                .input(STEM_CELLS, 64)
                .input(pipeTinyFluid, Polybenzimidazole, 32)
                .input(plate, Electrum, 64)
                .input(foil, SiliconeRubber, 64)
                .input(bolt, HSSE, 64)
                .fluidInputs(SterileGrowthMedium.getFluid(250))
                .output(NEURO_PROCESSOR, 32)
                .EUt(80000) // ZPM
                .duration(6 * MINUTE) // Original: 30s, Wrapped: 30s * 16 = 480s
                .circuit(getCircuit(NEURO_PROCESSOR))
                .buildAndRegister();

    }

    private static void addCircuit(MetaItem.MetaValueItem circuit)
    {
        // Circuit Pattern with NBT {"CircuitInfo": "${circuit.unlocalizedName}"}.
        ItemStack circuitPattern = CIRCUIT_PATTERN.getStackForm();
        circuitPattern.setTagInfo(INFO_NBT_NAME, new NBTTagString(circuit.unlocalizedName));
        // Add Scanning recipes of Circuit Pattern.
        SCANNER_RECIPES.recipeBuilder()
                .input(CIRCUIT_PATTERN)
                .input(circuit)
                .outputs(circuitPattern)
                .EUt(VA[LV])
                .duration(2 * SECOND + 10 * TICK)
                .buildAndRegister();;
    }

    private static ItemStack  getCircuit(MetaItem.MetaValueItem circuit)
    {
        ItemStack circuitPattern = CIRCUIT_PATTERN.getStackForm();
        circuitPattern.setTagInfo(INFO_NBT_NAME,new NBTTagString(circuit.unlocalizedName));
        return circuitPattern;
    }

    // @formatter:on
}
