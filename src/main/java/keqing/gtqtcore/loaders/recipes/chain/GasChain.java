package keqing.gtqtcore.loaders.recipes.chain;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;

import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static keqing.gtqtcore.api.unification.GTQTMaterials.*;

public class GasChain {
    public static void init() {
        AirVacuum();
        AirProgress();
        CollectAir();
    }

    private static void AirVacuum() {
        vaccum(Ozone, 2);
        vaccum(UnderAir, 2);
        vaccum(MarsAir, 3);
        vaccum(VenusAir, 4);
    }

    private static void CollectAir() {
        //普适
        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(30)
                .fluidOutputs(Air.getFluid(FluidStorageKeys.GAS, 10000))
                .duration(200).EUt(16).buildAndRegister();

        //地下世界
        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .fluidOutputs(UnderAir.getFluid(FluidStorageKeys.GAS, 10000))
                .dimension(41)
                .duration(200).EUt(16).buildAndRegister();


        //火星
        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .fluidOutputs(MarsAir.getFluid(FluidStorageKeys.GAS, 10000))
                .dimension(52)
                .duration(200).EUt(16).buildAndRegister();


        //金星
        GAS_COLLECTOR_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .fluidOutputs(VenusAir.getFluid(FluidStorageKeys.GAS, 10000))
                .dimension(53)
                .duration(200).EUt(16).buildAndRegister();


    }

    private static void AirProgress() {
        //地下世界
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(UnderAir.getFluid(FluidStorageKeys.GAS, 10000))
                .fluidOutputs(Methane.getFluid(7200))
                .fluidOutputs(CoalGas.getFluid(1000))
                .fluidOutputs(HydrogenSulfide.getFluid(750))
                .fluidOutputs(SulfurDioxide.getFluid(750))
                .fluidOutputs(Helium3.getFluid(250))
                .fluidOutputs(Neon.getFluid(50))
                .fluidOutputs(Radon.getFluid(50))
                .duration(2000).EUt(120).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(UnderAir.getFluid(FluidStorageKeys.LIQUID, 10000))
                .fluidOutputs(Methane.getFluid(7200))
                .fluidOutputs(CoalGas.getFluid(1000))
                .fluidOutputs(HydrogenSulfide.getFluid(750))
                .fluidOutputs(SulfurDioxide.getFluid(750))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.LIQUID, 250))
                .fluidOutputs(Neon.getFluid(50))
                .fluidOutputs(Radon.getFluid(FluidStorageKeys.LIQUID, 50))
                .duration(2000).EUt(VA[MV]).buildAndRegister();

        //火星
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MarsAir.getFluid(FluidStorageKeys.GAS, 10000))
                .fluidOutputs(CarbonDioxide.getFluid(7200))
                .fluidOutputs(Argon.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(750))
                .fluidOutputs(Helium3.getFluid(750))
                .fluidOutputs(Radon.getFluid(250))
                .fluidOutputs(Hydrogen.getFluid(50))
                .fluidOutputs(Nitrogen.getFluid(50))
                .fluidOutputs(MagicGas.getFluid(50))
                .duration(2000).EUt(120).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MarsAir.getFluid(FluidStorageKeys.LIQUID, 10000))
                .fluidOutputs(CarbonDioxide.getFluid(FluidStorageKeys.LIQUID, 7200))
                .fluidOutputs(Argon.getFluid(FluidStorageKeys.LIQUID, 1000))
                .fluidOutputs(Materials.Oxygen.getFluid(FluidStorageKeys.LIQUID, 750))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.LIQUID, 750))
                .fluidOutputs(Radon.getFluid(FluidStorageKeys.LIQUID, 250))
                .fluidOutputs(Hydrogen.getFluid(FluidStorageKeys.LIQUID, 50))
                .fluidOutputs(Nitrogen.getFluid(FluidStorageKeys.LIQUID, 50))
                .fluidOutputs(MagicGas.getFluid(50))
                .duration(2000).EUt(VA[MV]).buildAndRegister();

        //金星
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(VenusAir.getFluid(FluidStorageKeys.GAS, 10000))
                .fluidOutputs(Oxygen.getFluid(7200))
                .fluidOutputs(Carbon.getFluid(1000))
                .fluidOutputs(Argon.getFluid(750))
                .fluidOutputs(Helium3.getFluid(750))
                .fluidOutputs(Radon.getFluid(250))
                .fluidOutputs(Hydrogen.getFluid(50))
                .fluidOutputs(Nitrogen.getFluid(50))
                .fluidOutputs(MagicGas.getFluid(50))
                .duration(2000).EUt(120).buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(VenusAir.getFluid(FluidStorageKeys.LIQUID, 10000))
                .fluidOutputs(Oxygen.getFluid(FluidStorageKeys.LIQUID, 7200))
                .fluidOutputs(CoalGas.getFluid(1000))
                .fluidOutputs(HydrogenSulfide.getFluid(750))
                .fluidOutputs(SulfurDioxide.getFluid(750))
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.LIQUID, 250))
                .fluidOutputs(Neon.getFluid(50))
                .fluidOutputs(Radon.getFluid(FluidStorageKeys.LIQUID, 50))
                .duration(2000).EUt(VA[MV]).buildAndRegister();
    }

    private static void vaccum(Material material, int i) {
        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(material.getFluid(FluidStorageKeys.GAS, 1000))
                .fluidOutputs(material.getFluid(FluidStorageKeys.LIQUID, 1000))
                .duration((int) (100 * Math.pow(2, i + 1))).EUt(VA[i]).buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(material.getFluid(FluidStorageKeys.LIQUID, 4000))
                .fluidOutputs(material.getFluid(FluidStorageKeys.GAS, 4000))
                .duration((int) (20 * Math.pow(2, i))).EUt(VA[i]).buildAndRegister();
    }
}
