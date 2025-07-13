package keqing.gtqtcore.loaders.recipes.handlers;

import gregtech.api.unification.material.Material;

import static gregtech.api.GTValues.V;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.ACID_GENERATOR_RECIPES;

public class AcidReactorRecipes {

    public static void init() {
        AcidReactorRecipes(AceticAcid,1);
        AcidReactorRecipes(HydrochloricAcid,1);
        AcidReactorRecipes(DilutedHydrochloricAcid,1);

        AcidReactorRecipes(SulfuricAcid,2);
        AcidReactorRecipes(NitricAcid,2);
        AcidReactorRecipes(HypochlorousAcid,2);

        AcidReactorRecipes(HydrofluoricAcid,3);
        AcidReactorRecipes(PhosphoricAcid,3);
        AcidReactorRecipes(FluoroantimonicAcid,3);
    }

    public static void AcidReactorRecipes(Material material, int tier)
    {
        ACID_GENERATOR_RECIPES.recipeBuilder()
                .fluidInputs(material.getFluid(200))
                .EUt((int) V[tier])
                .duration((int) (20*Math.pow(2,tier)))
                .buildAndRegister();
    }

}
