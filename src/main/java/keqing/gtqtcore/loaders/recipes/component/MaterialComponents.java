package keqing.gtqtcore.loaders.recipes.component;

import gregtech.api.recipes.crafting.Component;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import keqing.gtqtcore.common.block.blocks.BlockTransparentCasing;
import keqing.gtqtcore.common.items.GTQTMetaItems;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.GTValues.*;
import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.LuV;
import static gregtech.api.GTValues.UHV;
import static gregtech.api.GTValues.UV;
import static gregtech.api.GTValues.ZPM;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static keqing.gtqtcore.api.unification.GTQTMaterials.*;

public class MaterialComponents {
    public static void init() {

        WIRE_ELECTRIC.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.wireGtSingle, Tritanium)
                .entry(UIV, OrePrefix.wireGtSingle, Adamantium)
                .entry(UXV, OrePrefix.wireGtSingle, Ichorium)
                //.entry(OpV, OrePrefix.wireGtSingle, Astralium)
                //.entry(MAX, OrePrefix.wireGtSingle, Hikariu)
                .build());


        WIRE_QUAD.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.wireGtQuadruple, PedotTMA)
                .entry(UIV, OrePrefix.wireGtQuadruple, Solarium)
                .entry(UXV, OrePrefix.wireGtQuadruple, Hypogen)
                //.entry(OpV, OrePrefix.wireGtQuadruple, Galaxium)
                //.entry(MAX, OrePrefix.wireGtQuadruple, Universium)
                .build());

        WIRE_OCT.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.wireGtOctal, PedotTMA)
                .entry(UIV, OrePrefix.wireGtOctal, Solarium)
                .entry(UXV, OrePrefix.wireGtOctal, Hypogen)
                //.entry(OpV, OrePrefix.wireGtOctal, Galaxium)
                //.entry(MAX, OrePrefix.wireGtOctal, Universium)
                .build());

        WIRE_HEX.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.wireGtHex, PedotTMA)
                .entry(UIV, OrePrefix.wireGtHex, Solarium)
                .entry(UXV, OrePrefix.wireGtHex, Hypogen)
                //.entry(OpV, OrePrefix.wireGtHex, Galaxium)
                //.entry(MAX, OrePrefix.wireGtHex, Universium)
                .build());

        CABLE.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.cableGtSingle, PedotTMA)
                .entry(UIV, OrePrefix.cableGtSingle, Solarium)
                .entry(UXV, OrePrefix.cableGtSingle, Hypogen)
                //.entry(OpV, OrePrefix.cableGtSingle, Galaxium)
                //.entry(MAX, OrePrefix.cableGtSingle, Universium)
                .build());

        CABLE_QUAD.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.cableGtQuadruple, PedotTMA)
                .entry(UIV, OrePrefix.cableGtQuadruple, Solarium)
                .entry(UXV, OrePrefix.cableGtQuadruple, Hypogen)
                //.entry(OpV, OrePrefix.cableGtQuadruple, Galaxium)
                //.entry(MAX, OrePrefix.cableGtQuadruple, Universium)
                .build());

        CABLE_OCT.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.cableGtOctal, PedotTMA)
                .entry(UIV, OrePrefix.cableGtOctal, Solarium)
                .entry(UXV, OrePrefix.cableGtOctal, Hypogen)
                //.entry(OpV, OrePrefix.cableGtOctal, Galaxium)
                //.entry(MAX, OrePrefix.cableGtOctal, Universium)
                .build());

        CABLE_HEX.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.cableGtHex, PedotTMA)
                .entry(UIV, OrePrefix.cableGtHex, Solarium)
                .entry(UXV, OrePrefix.cableGtHex, Hypogen)
                //.entry(OpV, OrePrefix.cableGtHex, Galaxium)
                //.entry(MAX, OrePrefix.cableGtHex, Universium)
                .build());

        CABLE_TIER_UP.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.cableGtSingle, PedotTMA)
                .entry(UEV, OrePrefix.cableGtSingle, Solarium)
                .entry(UIV, OrePrefix.cableGtSingle, Hypogen)
                //.entry(UXV, OrePrefix.cableGtSingle, Galaxium)
                //.entry(OpV, OrePrefix.cableGtSingle, Universium)
                .build());

        PIPE_NORMAL.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.pipeNormalFluid, Duranium)
                .entry(UEV, OrePrefix.pipeNormalFluid, Lafium)
                .entry(UIV, OrePrefix.pipeNormalFluid, CrystalMatrix)
                //.entry(UXV, OrePrefix.pipeNormalFluid, QuantumchromodynamicallyConfinedMatter)
                //.entry(OpV, OrePrefix.pipeNormalFluid, Fatalium)
                //.entry(MAX, OrePrefix.pipeNormalFluid, Aetherium)
                .build());

        PIPE_LARGE.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.pipeLargeFluid, Duranium)
                .entry(UEV, OrePrefix.pipeLargeFluid, Lafium)
                .entry(UIV, OrePrefix.pipeLargeFluid, CrystalMatrix)
                //.entry(UXV, OrePrefix.pipeLargeFluid, QuantumchromodynamicallyConfinedMatter)
                //.entry(OpV, OrePrefix.pipeLargeFluid, Fatalium)
                //.entry(MAX, OrePrefix.pipeLargeFluid, Aetherium)
                .build());

        GLASS.updateIngredients(new Component.Builder()
                .entry(7, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.BPA_POLYCARBONATE_GLASS))
                .entry(8, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.BPA_POLYCARBONATE_GLASS))
                .entry(9, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.PMMA_GLASS))
                .entry(UEV, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.PMMA_GLASS))
                .entry(UIV, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.CBDO_POLYCARBONATE_GLASS))
                .entry(UXV, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.CBDO_POLYCARBONATE_GLASS))
                .entry(OpV, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.INFINITY_GLASS))
                .entry(MAX, GTQTMetaBlocks.blockTransparentCasing.getItemVariant(BlockTransparentCasing.CasingType.INFINITY_GLASS))
                .build());

        PLATE.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.plate, Orichalcum)
                .entry(UEV, OrePrefix.plate, Adamantium)
                .entry(UIV, OrePrefix.plate, Infinity)
                .entry(UXV, OrePrefix.plate, Spacetime)
                .entry(OpV, OrePrefix.plate, Eternity)
                .entry(MAX, OrePrefix.plate, Magmatter)
                .build());

        HULL_PLATE.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.plate, Polyetheretherketone)
                .entry(UEV, OrePrefix.plate, Polyetheretherketone)
                .entry(UIV, OrePrefix.plate, Kevlar)
                .entry(UXV, OrePrefix.plate, Kevlar)
                //.entry(OpV, OrePrefix.plate, CosmicFabric)
                //.entry(MAX, OrePrefix.plate, CosmicFabric)
                .build());

        DOUBLE_PLATE.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.plateDouble, Orichalcum)
                .entry(UEV, OrePrefix.plateDouble, Adamantium)
                .entry(UIV, OrePrefix.plateDouble, Infinity)
                .entry(UXV, OrePrefix.plateDouble, CosmicNeutronium)
                //.entry(OpV, OrePrefix.plateDouble, Spacetime)
                //.entry(MAX, OrePrefix.plateDouble, Eternity)
                .build());

        ROTOR.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.rotor, Orichalcum)
                .entry(UEV, OrePrefix.rotor, Adamantium)
                .entry(UIV, OrePrefix.rotor, Infinity)
                .entry(UXV, OrePrefix.rotor, CosmicNeutronium)
                //.entry(OpV, OrePrefix.rotor, Spacetime)
                //.entry(MAX, OrePrefix.rotor, Eternity)
                .build());

        GRINDER.updateIngredients(new Component.Builder()
                .entry(6, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm())
                .entry(7, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm())
                .entry(8, MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm())
                .entry(9, GTQTMetaItems.COMPONENT_GRINDER_BORON_NITRIDE.getStackForm())
                .entry(UEV, GTQTMetaItems.COMPONENT_GRINDER_BORON_NITRIDE.getStackForm())
                .entry(UIV, GTQTMetaItems.COMPONENT_GRINDER_BORON_NITRIDE.getStackForm())
                //.entry(UXV, GTQTMetaItems.COMPONENT_GRINDER_BLACK_PLUTONIUM.getStackForm())
                //.entry(OpV, GTQTMetaItems.COMPONENT_GRINDER_BLACK_PLUTONIUM.getStackForm())
                //.entry(MAX, GTQTMetaItems.COMPONENT_GRINDER_BLACK_PLUTONIUM.getStackForm())
                .build());

        SAWBLADE.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.toolHeadBuzzSaw, CubicBoronNitride)
                .entry(UEV, OrePrefix.toolHeadBuzzSaw, BlackTitanium)
                .entry(UIV, OrePrefix.toolHeadBuzzSaw, BlackPlutonium)
                //.entry(UXV, OrePrefix.toolHeadBuzzSaw, Octiron)
                //.entry(OpV, OrePrefix.toolHeadBuzzSaw, Edenium)
                .build());

        COIL_HEATING.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.wireGtDouble, Trinium)
                .entry(UEV, OrePrefix.wireGtDouble, Tritanium)
                .entry(UIV, OrePrefix.wireGtDouble, Adamantium)
                .entry(UXV, OrePrefix.wireGtDouble, Ichorium)
                //.entry(OpV, OrePrefix.wireGtDouble, Astralium)
                //.entry(MAX, OrePrefix.wireGtDouble, Hikarium)
                .build());

        COIL_HEATING_DOUBLE.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.wireGtQuadruple, Trinium)
                .entry(UEV, OrePrefix.wireGtQuadruple, Tritanium)
                .entry(UIV, OrePrefix.wireGtDouble, Adamantium)
                .entry(UXV, OrePrefix.wireGtDouble, Ichorium)
                //.entry(OpV, OrePrefix.wireGtDouble, Astralium)
                //.entry(MAX, OrePrefix.wireGtDouble, Hikarium)
                .build());

        COIL_ELECTRIC.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.wireGtOctal, SiliconCarbide)
                .entry(UEV, OrePrefix.wireGtOctal, Seaborgium)
                .entry(UIV, OrePrefix.wireGtOctal, Abyssalloy)
                //.entry(UXV, OrePrefix.wireGtOctal, BlackDwarfMatter)
                //.entry(OpV, OrePrefix.wireGtOctal, Shirabon)
                //.entry(MAX, OrePrefix.wireGtOctal, Magmatter)
                .build());

        STICK_MAGNETIC.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.stickLong, ChromiumGermaniumTellurideMagnetic)
                .entry(UEV, OrePrefix.stickLong, ChromiumGermaniumTellurideMagnetic)
                //.entry(UIV, OrePrefix.stickLong, PhosphorusDopedEuropiumIronArsenideMagnetic)
                //.entry(UXV, OrePrefix.stickLong, PhosphorusDopedEuropiumIronArsenideMagnetic)
                //.entry(OpV, OrePrefix.stickLong, BismuthLawrenciumStrontiumCuprateMagnetic)
                //.entry(MAX, OrePrefix.stickLong, BismuthLawrenciumStrontiumCuprateMagnetic)
                .build());

        STICK_DISTILLATION.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.spring, Trinium)
                .entry(UEV, OrePrefix.spring, Tritanium)
                .entry(UIV, OrePrefix.spring, Adamantium)
                .entry(UXV, OrePrefix.spring, Ichorium)
                //.entry(OpV, OrePrefix.spring, Astralium)
                //.entry(MAX, OrePrefix.spring, Hikarium)
                .build());

        STICK_ELECTROMAGNETIC.updateIngredients(new Component.Builder()
                .entry(5, OrePrefix.stick, VanadiumGallium)
                .entry(6, OrePrefix.stick, VanadiumGallium)
                .entry(7, OrePrefix.stick, VanadiumGallium)
                .entry(8, OrePrefix.stickLong, VanadiumGallium)
                .entry(9, OrePrefix.stickLong, VanadiumGallium)
                .entry(UEV, OrePrefix.stick, CarbonNanotube)
                .entry(UIV, OrePrefix.stick, CarbonNanotube)
                .entry(UXV, OrePrefix.stickLong, CarbonNanotube)
                //.entry(OpV, OrePrefix.stickLong, CarbonNanotube)
                .build());

        STICK_RADIOACTIVE.updateIngredients(new Component.Builder()
                .entry(8, OrePrefix.stick, Dubnium)
                .entry(9, OrePrefix.stick, Livermorium)
                .entry(UEV, OrePrefix.stick, MetastableFlerovium)
                .entry(UIV, OrePrefix.stick, MetastableHassium)
                .entry(UXV, OrePrefix.stick, SuperheavyLAlloy)
                //.entry(OpV, OrePrefix.stick, SuperheavyHAlloy)
                //.entry(MAX, OrePrefix.stick, Periodicium)
                .build());

        PIPE_REACTOR.updateIngredients(new Component.Builder()
                .entry(9, OrePrefix.pipeNormalFluid, Polybenzimidazole)
                .entry(UEV, OrePrefix.pipeLargeFluid, Polybenzimidazole)
                .entry(UIV, OrePrefix.pipeHugeFluid, Polybenzimidazole)
                .entry(UXV, OrePrefix.pipeNormalFluid, Polyetheretherketone)
                //.entry(OpV, OrePrefix.pipeLargeFluid, Polyetheretherketone)
                //.entry(MAX, OrePrefix.pipeHugeFluid, Polyetheretherketone)
                .build());

        POWER_COMPONENT.updateIngredients(new Component.Builder()
                .entry(9, GTQTMetaItems.NANO_POWER_IC)
                .entry(UEV, GTQTMetaItems.NANO_POWER_IC)
                .entry(UIV, GTQTMetaItems.PICO_POWER_IC)
                .entry(UXV, GTQTMetaItems.PICO_POWER_IC)
                //.entry(OpV, GTQTMetaItems.FEMTO_POWER_IC)
                //.entry(MAX, GTQTMetaItems.FEMTO_POWER_IC)
                .build());

        VOLTAGE_COIL.updateIngredients(new Component.Builder()
                .entry(9, GTQTMetaItems.VOLTAGE_COIL_UHV)
                .entry(UEV, GTQTMetaItems.VOLTAGE_COIL_UEV)
                .entry(UIV, GTQTMetaItems.VOLTAGE_COIL_UIV)
                .entry(UXV, GTQTMetaItems.VOLTAGE_COIL_UXV)
                //.entry(OpV, GTQTMetaItems.VOLTAGE_COIL_OpV)
                //.entry(MAX, GTQTMetaItems.VOLTAGE_COIL_MAX)
                .build());

        SPRING.updateIngredients(new Component.Builder()
                .entry(UEV, OrePrefix.spring, CarbonNanotube)
                .entry(UIV, OrePrefix.spring, RutheniumTriniumAmericiumNeutronate)
                //.entry(UXV, OrePrefix.spring, WhiteDwarfMatter)
                //.entry(OpV, OrePrefix.spring, Edenium)
                //.entry(MAX, OrePrefix.spring, Aetherium)
                .build());
    }
}

