package keqing.gtqtcore.loaders.recipes.chain;


import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static keqing.gtqtcore.api.unification.GTQTMaterials.DimethylCarbonate;

import gregtech.api.recipes.GTRecipeHandler;
import keqing.gtqtcore.api.unification.GTQTMaterials;

import static gregtech.common.items.MetaItems.*;


public class PetrochemRecipes {

    public static void init() {
        removeOvercostRecipes();
        addLowCostRecipes();
        renewablePropene();
        catalysts();
    }

    public static void removeOvercostRecipes() {
        //TODO cannot remove this GCYS recipe
//        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, RareEarthChloridesSolution.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, CharcoalByproducts.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, WoodGas.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, FermentedBiomass.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, WoodVinegar.getFluid(1000));
        GTRecipeHandler.removeRecipesByInputs(DISTILLATION_RECIPES, WoodTar.getFluid(1000));
    }

    public static void addLowCostRecipes() {
       /* DISTILLATION_RECIPES.recipeBuilder()
                .duration(150)
                .EUt(VA[EV])
                .fluidInputs(RareEarthChloridesSolution.getFluid(1000))
                .fluidOutputs(ErTmYbLuOxidesSolution.getFluid(250))
                .fluidOutputs(LaPrNdCeOxidesSolution.getFluid(250))
                .fluidOutputs(ScEuGdSmOxidesSolution.getFluid(250))
                .fluidOutputs(YTbDyHoOxidesSolution.getFluid(250))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .chancedOutput(dust, Thorium, 2500, 1000)
                .buildAndRegister();

        */

        DISTILLATION_RECIPES.recipeBuilder()
                .duration(175)
                .EUt(VA[MV])
                .fluidInputs(CharcoalByproducts.getFluid(1000))
                .fluidOutputs(WoodVinegar.getFluid(450))
                .fluidOutputs(WoodTar.getFluid(250))
                .fluidOutputs(WoodGas.getFluid(250))
                .fluidOutputs(Dimethylbenzene.getFluid(100))
                .chancedOutput(dust, Charcoal, 5000, 1000)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .duration(125)
                .EUt(VA[MV])
                .fluidInputs(WoodTar.getFluid(1000))
                .fluidOutputs(Benzene.getFluid(350))
                .fluidOutputs(Creosote.getFluid(300))
                .fluidOutputs(Dimethylbenzene.getFluid(200))
                .fluidOutputs(Phenol.getFluid(75))
                .fluidOutputs(Toluene.getFluid(75))
                .chancedOutput(STICKY_RESIN.getStackForm(), 5000, 1000)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .duration(150)
                .EUt(VA[MV])
                .fluidInputs(WoodVinegar.getFluid(1000))
                .fluidOutputs(Water.getFluid(400))
                .fluidOutputs(Methanol.getFluid(300))
                .fluidOutputs(AceticAcid.getFluid(200))
                .fluidOutputs(Acetone.getFluid(50))
                .fluidOutputs(MethylAcetate.getFluid(10))
                .fluidOutputs(Ethanol.getFluid(10))
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .duration(150)
                .EUt(VA[MV])
                .fluidInputs(WoodGas.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(500))
                .fluidOutputs(CarbonMonoxide.getFluid(350))
                .fluidOutputs(Methane.getFluid(150))
                .fluidOutputs(Hydrogen.getFluid(50))
                .fluidOutputs(Ethylene.getFluid(50))
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .duration(100)
                .EUt(VA[MV])
                .fluidInputs(FermentedBiomass.getFluid(1000))
                .fluidOutputs(Water.getFluid(500))
                .fluidOutputs(Methane.getFluid(400))
                .fluidOutputs(CarbonDioxide.getFluid(350))
                .fluidOutputs(Ethanol.getFluid(200))
                .fluidOutputs(Methanol.getFluid(150))
                .fluidOutputs(Ammonia.getFluid(100))
                .fluidOutputs(AceticAcid.getFluid(50))
                .output(FERTILIZER)
                .buildAndRegister();

    }

    public static void catalysts() {
        CVD_RECIPES.recipeBuilder()
                .duration(550)
                .EUt(VA[EV])
                .input(dust, GTQTMaterials.CubicZirconia)
                .input(dust, Iridium)
                .output(dust, GTQTMaterials.IridiumOnCubicZirconia)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .duration(100)
                .EUt(VA[MV])
                .input(dust, SodiumHydroxide)
                .input(dust, SiliconDioxide)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(GTQTMaterials.SodiumHydroxideSilica.getFluid(1000))
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .duration(85)
                .EUt(VA[MV])
                .input(dust, SodiumHydroxide, 2)
                .input(dust, GTQTMaterials.Alumina)
                .notConsumable(plate, Nickel)
                .output(dust, GTQTMaterials.SodiumAluminate, 2)
                .fluidOutputs(Water.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[MV])
                .input(dust, GTQTMaterials.SodiumAluminate)
                .fluidInputs(GTQTMaterials.SodiumHydroxideSilica.getFluid(1000))
                .fluidOutputs(GTQTMaterials.SodiumAluminumSilicaSolution.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(2000))
                .output(dust, SodiumHydroxide)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(55)
                .EUt(VA[MV])
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(Methanol.getFluid(2000))
                .fluidOutputs(DimethylCarbonate.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(80)
                .EUt(VA[HV])
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(DimethylCarbonate.getFluid(2000))
                .input(dust, AmmoniumChloride, 2)
                .output(dust, GTQTMaterials.TetramethylammoniumChloride, 2)
                .fluidOutputs(Oxygen.getFluid(6000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(145)
                .EUt(VA[HV])
                .fluidInputs(GTQTMaterials.TetramethylammoniumHydroxide.getFluid(1000))
                .fluidInputs(GTQTMaterials.HydrobromicAcid.getFluid(1000))
                .output(dust, GTQTMaterials.TetramethylammoniumBromide)
                .fluidOutputs(Water.getFluid(1000))
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[EV])
                .fluidInputs(GTQTMaterials.SodiumAluminumSilicaSolution.getFluid(1000))
                .notConsumable(dust, GTQTMaterials.TetramethylammoniumBromide)
                .output(dust, GTQTMaterials.ZSM_5_ZEOLITE)
                .buildAndRegister();
    }

    public static void renewablePropene() {
        BLAST_RECIPES.recipeBuilder()
                .duration(185)
                .EUt(VA[HV])
                .notConsumable(dust, GTQTMaterials.IridiumOnCubicZirconia)
                .fluidInputs(Glycerol.getFluid(1000))
                .fluidOutputs(GTQTMaterials.OnePropanol.getFluid(1000))
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[HV])
                .notConsumable(dust, GTQTMaterials.ZSM_5_ZEOLITE)
                .fluidInputs(GTQTMaterials.OnePropanol.getFluid(1000))
                .fluidOutputs(Propene.getFluid(1000))
                .buildAndRegister();
    }

}
