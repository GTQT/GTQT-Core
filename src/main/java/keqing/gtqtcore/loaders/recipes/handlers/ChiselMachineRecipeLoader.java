package keqing.gtqtcore.loaders.recipes.handlers;

import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import net.minecraftforge.oredict.OreDictionary;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.loaders.recipe.CraftingComponent.GLASS;
import static keqing.gtqtcore.api.utils.GTQTUtil.getItemById;
import static keqing.gtqtcore.common.metatileentities.GTQTMetaTileEntities.AUTO_CHISEL;


public class ChiselMachineRecipeLoader {

    public static void init() {

        OreDictionary.registerOre("craftingChisel", getItemById("chisel", "chisel_iron"));
        OreDictionary.registerOre("craftingChisel", getItemById("chisel", "chisel_diamond"));
        OreDictionary.registerOre("craftingChisel", getItemById("chisel", "chisel_hitech"));

        MetaTileEntityLoader.registerMachineRecipe(true, AUTO_CHISEL,
                "GYG", "CHX", "WMW",
                'H', HULL,
                'M', MOTOR,
                'W', CABLE,
                'C', CONVEYOR,
                'X', "craftingChisel",
                'Y', CIRCUIT,
                'G', GLASS);


    }
}