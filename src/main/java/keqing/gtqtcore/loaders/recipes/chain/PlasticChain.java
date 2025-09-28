package keqing.gtqtcore.loaders.recipes.chain;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.BLAST_RECIPES;
import static gregtech.api.recipes.RecipeMaps.WIREMILL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.ingot;
public class PlasticChain {

    public static void init() {
        // Polycaprolactam
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[] {
                        OreDictUnifier.get(dust, Caprolactam, 1)
                },
                new FluidStack[] {
                        Nitrogen.getFluid(1000)
                });

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Caprolactam, 1)
                .fluidInputs(Nitrogen.getFluid(100))
                .output(ingot, Polycaprolactam, 1)
                .EUt(VA[MV])
                .blastFurnaceTemp(2700)
                .duration(7 * SECOND + 10 * TICK)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(WIREMILL_RECIPES,
                OreDictUnifier.get(ingot, Polycaprolactam, 1));

        WIREMILL_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(ingot, Polycaprolactam, 1)
                .outputs(new ItemStack(Items.STRING, 32))
                .EUt(48) // MV
                .duration(4 * SECOND)
                .buildAndRegister();

    }
}
