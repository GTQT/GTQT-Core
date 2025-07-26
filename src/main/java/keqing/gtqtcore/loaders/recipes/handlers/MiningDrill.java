package keqing.gtqtcore.loaders.recipes.handlers;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import keqing.gtqtcore.common.block.blocks.BlockElectrolyticBath;

import static gregtech.api.GTValues.L;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.SIFTER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.HULL;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.GRAVITY_SEPARATOR_RECIPES;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.MINING_DRILL_RECIPES;
import static keqing.gtqtcore.api.unification.GTQTMaterials.*;
import static keqing.gtqtcore.common.items.GTQTMetaItems.*;

public class MiningDrill {
    public static void init() {
        //钻头
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(HULL[1].getStackForm())
                .input(ELECTRIC_MOTOR_LV, 4)
                .input(plate, Steel, 8)
                .input(frameGt, Steel, 8)
                .fluidInputs(Polyethylene.getFluid(L * 4))
                .circuitMeta(5)
                .outputs(GTQTMetaBlocks.blockElectrolyticBath.getItemVariant(BlockElectrolyticBath.CasingType.DRILL_HEAD_LV))
                .duration(2000).EUt(30).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(HULL[2].getStackForm())
                .input(ELECTRIC_MOTOR_MV, 4)
                .input(plate, Aluminium, 8)
                .input(frameGt, Aluminium, 8)
                .fluidInputs(PolyvinylChloride.getFluid(L * 4))
                .circuitMeta(5)
                .outputs(GTQTMetaBlocks.blockElectrolyticBath.getItemVariant(BlockElectrolyticBath.CasingType.DRILL_HEAD_MV))
                .duration(200).EUt(120).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(HULL[3].getStackForm())
                .input(ELECTRIC_MOTOR_HV, 4)
                .input(plate, StainlessSteel, 8)
                .input(frameGt, StainlessSteel, 8)
                .fluidInputs(Epoxy.getFluid(L * 4))
                .circuitMeta(5)
                .outputs(GTQTMetaBlocks.blockElectrolyticBath.getItemVariant(BlockElectrolyticBath.CasingType.DRILL_HEAD_HV))
                .duration(200).EUt(480).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(HULL[4].getStackForm())
                .input(ELECTRIC_MOTOR_EV, 4)
                .input(plate, Titanium, 8)
                .input(frameGt, Titanium, 8)
                .fluidInputs(ReinforcedEpoxyResin.getFluid(L * 4))
                .circuitMeta(5)
                .outputs(GTQTMetaBlocks.blockElectrolyticBath.getItemVariant(BlockElectrolyticBath.CasingType.DRILL_HEAD_EV))
                .duration(200).EUt(1920).buildAndRegister();

        //钻头
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Diamond, 8)
                .input(toolHeadDrill, Steel, 16)
                .input(stick, Steel, 4)
                .input(ELECTRIC_PUMP_LV, 4)
                .output(DRILL_HEAD_STEEL)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(30).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Diamond, 8)
                .input(toolHeadDrill, Aluminium, 16)
                .input(stick, Aluminium, 4)
                .input(ELECTRIC_PUMP_MV, 4)
                .output(DRILL_HEAD_ALUMINIUM)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(120).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Diamond, 8)
                .input(toolHeadDrill, StainlessSteel, 16)
                .input(stick, StainlessSteel, 4)
                .input(ELECTRIC_PUMP_HV, 4)
                .output(DRILL_HEAD_STAINLESSSTEEL)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(480).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Diamond, 8)
                .input(toolHeadDrill, Titanium, 16)
                .input(stick, Titanium, 4)
                .input(ELECTRIC_PUMP_EV, 4)
                .output(DRILL_HEAD_TITANIUM)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(1960).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Diamond, 8)
                .input(toolHeadDrill, TungstenSteel, 16)
                .input(stick, TungstenSteel, 4)
                .input(ELECTRIC_PUMP_IV, 4)
                .output(DRILL_HEAD_TUNGSTENSTEEL)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(7680).buildAndRegister();

        //MiningDrillR();
        MiningDrillRecipes(1, BLANK);
        MiningDrillRecipes(1, HYDROTHERMAL);
        MiningDrillRecipes(1, MAGMATIC_HYDROTHERMAL);
        MiningDrillRecipes(1, ALLUVIAL);

        MiningDrillRecipes(2, DIAPHRAGMATIC);
        MiningDrillRecipes(2, ORTHOSTATIC);
        MiningDrillRecipes(2, METAMORPHIC);
        MiningDrillRecipes(2, DIABLANK);

        MiningDrillRecipes(3, MANTLE_XENOLITH);
        MiningDrillRecipes(3, VOLCANIC_BRECCIA);
        MiningDrillRecipes(3, HIGH_PRESSURE);
        MiningDrillRecipes(3, ANATECTIC);

        //主世界
        GRAVITY_SEPARATOR(BLANK, Tin, Cassiterite, Coal, Lignite, Diamond, Graphite);
        GRAVITY_SEPARATOR(HYDROTHERMAL, Kyanite, Mica, Lepidolite, Pollucite, Gypsum, Bentonite);
        GRAVITY_SEPARATOR(MAGMATIC_HYDROTHERMAL, Magnesite, Olivine, GlauconiteSand, Calcite,Magnetite, VanadiumMagnetite);
        GRAVITY_SEPARATOR(ALLUVIAL, BrownLimonite, YellowLimonite, BandedIron, Sphalerite, Salt, Oilsands);
        //地狱
        GRAVITY_SEPARATOR(DIAPHRAGMATIC, BlueTopaz, Topaz, Chalcocite, Bornite,  RockSalt, Trona);
        GRAVITY_SEPARATOR(ORTHOSTATIC, CertusQuartz, NetherQuartz, Quartzite, Grossular, Pyrolusite, Tantalite);
        GRAVITY_SEPARATOR(METAMORPHIC, Bastnasite, Monazite, Neodymium, Redstone, Ruby, Cinnabar);
        GRAVITY_SEPARATOR(DIABLANK, Saltpeter, Diatomite, Electrotine, Alunite, Sulfur, Pyrite);
        //地下世界
        GRAVITY_SEPARATOR(MANTLE_XENOLITH, Lazurite, Sodalite, Lapis, Calcite, GarnetRed, GarnetYellow);
        GRAVITY_SEPARATOR(VOLCANIC_BRECCIA, Amethyst, Opal, CassiteriteSand, GarnetSand, Asbestos, Chalcopyrite);
        GRAVITY_SEPARATOR(HIGH_PRESSURE, Spodumene, Zeolite, Realgar, Beryllium, Emerald, Apatite);
        GRAVITY_SEPARATOR(ANATECTIC, TricalciumPhosphate, Silver, Cryolite, Pentlandite, Garnierite, Galena);

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Steel, 16)
                .input(stick, Steel, 2)
                .input(ring, Steel, 4)
                .input(BATTERY_LV_LITHIUM, 1)
                .input(circuit, MarkerMaterials.Tier.MV, 1)
                .input(SENSOR_LV, 1)
                .output(POS_ORE_CARD)
                .circuitMeta(2)
                .duration(600).EUt(30).buildAndRegister();
    }

    private static void GRAVITY_SEPARATOR(MetaItem.MetaValueItem Item, Material material1, Material material2, Material material3, Material material4, Material material5, Material material6) {
        GRAVITY_SEPARATOR_RECIPES.recipeBuilder()
                .input(Item)
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(Lubricant.getFluid(10))
                .chancedOutput(crushed, material1, 5000, 500)
                .chancedOutput(crushed, material2, 5000, 500)
                .chancedOutput(crushed, material3, 5000, 500)
                .chancedOutput(crushed, material4, 5000, 500)
                .chancedOutput(crushed, material5, 5000, 500)
                .chancedOutput(crushed, material6, 5000, 500)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

    }

    private static void MiningDrillRecipes(int tier, MetaItem.MetaValueItem Item) {
        MINING_DRILL_RECIPES.recipeBuilder()
                .notConsumable(Item)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .chancedOutput(Item, 5000, 500)
                .tier(tier)
                .EUt(VA[tier])
                .duration(500)
                .buildAndRegister();

    }

}
