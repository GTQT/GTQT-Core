package keqing.gtqtcore.loaders.recipes.chain;

import gregtech.api.GTValues;
import keqing.gtqtcore.api.unification.GTQTMaterials;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.BURNER_REACTOR_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static keqing.gtqtcore.api.unification.ore.GTQTOrePrefix.seedCrystal;
import static supercritical.api.unification.material.SCMaterials.BoronTrioxide;

public class MagneticsChain {

    public static void init() {
        plutoniumPhosphide();
        neptuniumAluminide();
        bismuthFerrite();
        thalliumCopperChloride();
    }

    private static void plutoniumPhosphide() {
        //TODO radioactive safe reactor?
        // Pu + 3H -> PuH3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Plutonium239)
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(dust, GTQTMaterials.PlutoniumTrihydride, 4)
                .duration(60).EUt(VA[IV]).buildAndRegister();

        // Pu + PH3 -> PuP + 6H
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, GTQTMaterials.PlutoniumTrihydride, 4)
                .fluidInputs(GTQTMaterials.Phosphine.getFluid(1000))
                .output(ingot, GTQTMaterials.PlutoniumPhosphide, 2)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .blastFurnaceTemp(4500)
                .duration(60).EUt(VA[IV]).buildAndRegister();
    }

    private static void neptuniumAluminide() {
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Neptunium)
                .input(dust, Aluminium, 3)
                .output(dust, GTQTMaterials.NeptuniumAluminide, 4)
                .duration(400).EUt(VA[IV]).buildAndRegister();
    }

    private static void bismuthFerrite() {
        // 2Bi + 3H2O -> Bi2O3 + 6H
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Bismuth, 2)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, GTQTMaterials.BismuthTrioxide, 5)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(50).EUt(60).buildAndRegister();

        // 2Fe + 3O -> Fe2O3
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Iron, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, GTQTMaterials.FerricOxide, 5)
                .blastFurnaceTemp(1800)
                .duration(50)
                .EUt(120).buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, GTQTMaterials.Hematite)
                .output(dust, GTQTMaterials.FerricOxide)
                .duration(200).EUt(8).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, GTQTMaterials.BismuthTrioxide, 20)
                .input(dust, BoronTrioxide, 5)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(seedCrystal, GTQTMaterials.BismuthFerrite)
                .duration(1000).EUt(VA[LuV]).buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, GTQTMaterials.BismuthFerrite)
                .output(plate, GTQTMaterials.BismuthFerrite)
                .duration(400).EUt(2).buildAndRegister();
    }

    private static void thalliumCopperChloride() {
        // Tl + Cu + 3Cl -> TlCuCl3
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Thallium)
                .input(dust, Copper)
                .fluidInputs(Chlorine.getFluid(3000))
                .fluidOutputs(GTQTMaterials.ThalliumCopperChloride.getFluid(GTValues.L * 5))
                .blastFurnaceTemp(1570)
                .duration(700).EUt(VA[EV]).buildAndRegister();
    }
}
