package keqing.gtqtcore.loaders.recipes.chain;

import keqing.gtqtcore.api.unification.GTQTMaterials;

import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

/**
 * The Rubidium Process
 *
 * <p>
 * Produces Rubidium and Caesium from Pollucite
 * </p>
 *
 * <p>Main Products: Rubidium, Caesium</p>
 * <p>Side Products: Alumina, Silicon Dioxide</p>
 *
 * <p>10 Pollucite -> 2 Caesium + 1 Rubidium</p>
 * <p>Loses 1 Tiny Tin and 111.11 Chlorine</p>
 */
public class RubidiumProcessing {

    public static void init() {
        // (Al2O3)Cs2(SiO2)2(H2O)2O + 3HCl -> RbCl(CsCl)2(H2O)2 + Al2O3 + 2SiO2 + O (lost)
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pollucite, 10)
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .output(dust, GTQTMaterials.Alumina)
                .output(dust, SiliconDioxide, 4)
                .fluidOutputs(GTQTMaterials.HeavyAlkaliChlorideSolution.getFluid(1000))
                .duration(400).EUt(VA[HV]).buildAndRegister();

        // Sn + 4Cl -> SnCl4
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Tin)
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidOutputs(GTQTMaterials.StannicChloride.getFluid(1000))
                .blastFurnaceTemp(3600)
                .duration(100).EUt(VA[HV]).buildAndRegister();

        // 2RbCl(CsCl)2(H2O)2 + 3SnCl4 -> Rb2SnCl6 + 2Cs2SnCl6 + 4H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(GTQTMaterials.HeavyAlkaliChlorideSolution.getFluid(1000))
                .fluidInputs(GTQTMaterials.StannicChloride.getFluid(1500))
                .output(dust, GTQTMaterials.RubidiumChlorostannate, 4)
                .output(dust, GTQTMaterials.CaesiumChlorostannate, 9)
                .fluidOutputs(Water.getFluid(2000))
                .duration(400).EUt(VA[EV]).buildAndRegister();
    }
}
