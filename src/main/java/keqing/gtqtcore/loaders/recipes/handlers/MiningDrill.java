package keqing.gtqtcore.loaders.recipes.handlers;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import keqing.gtqtcore.common.block.blocks.BlockElectrolyticBath;

import static gregtech.api.GTValues.L;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.Materials.Coal;
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
                .input(dust,Diamond,8)
                .input(toolHeadDrill,Steel,16)
                .input(stick,Steel,4)
                .input(ELECTRIC_PUMP_LV,4)
                .output(DRILL_HEAD_STEEL)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(30).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust,Diamond,8)
                .input(toolHeadDrill,Aluminium,16)
                .input(stick,Aluminium,4)
                .input(ELECTRIC_PUMP_MV,4)
                .output(DRILL_HEAD_ALUMINIUM)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(120).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust,Diamond,8)
                .input(toolHeadDrill,StainlessSteel,16)
                .input(stick,StainlessSteel,4)
                .input(ELECTRIC_PUMP_HV,4)
                .output(DRILL_HEAD_STAINLESSSTEEL)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(480).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust,Diamond,8)
                .input(toolHeadDrill,Titanium,16)
                .input(stick,Titanium,4)
                .input(ELECTRIC_PUMP_EV,4)
                .output(DRILL_HEAD_TITANIUM)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(1960).buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust,Diamond,8)
                .input(toolHeadDrill,TungstenSteel,16)
                .input(stick,TungstenSteel,4)
                .input(ELECTRIC_PUMP_IV,4)
                .output(DRILL_HEAD_TUNGSTENSTEEL)
                .fluidInputs(Polyethylene.getFluid(1440))
                .duration(200).EUt(7680).buildAndRegister();

        //MiningDrillR();
        MiningDrill(1,BLANK,1);
        MiningDrill(1,HYDROTHERMAL,2);
        MiningDrill(1,MAGMATIC_HYDROTHERMAL,3);
        MiningDrill(1,ALLUVIAL,4);

        MiningDrill(2,DIAPHRAGMATIC,-3);
        MiningDrill(2,ORTHOSTATIC,-2);
        MiningDrill(2,METAMORPHIC,-1);
        MiningDrill(2,METAMORPHIC,0);

        MiningDrill(3,END1,5);
        MiningDrill(3,END2,6);
        MiningDrill(3,END3,7);
        MiningDrill(3,END4,8);

        MiningDrill(1,BET1,81);
        MiningDrill(1,BET2,82);
        MiningDrill(1,BET3,83);
        MiningDrill(1,BET4,84);

        MiningDrill(4,BNT1,11);
        MiningDrill(4,BNT2,12);
        MiningDrill(4,BNT3,13);
        MiningDrill(4,BNT4,14);

        GRAVITY_SEPARATOR(BLANK,Amblygonite,Crocoite,Coal,Lignite,Diamond,Chalcopyrite);
        GRAVITY_SEPARATOR(HYDROTHERMAL,Copper,Iron,Lead,Nickel,Cryolite,Bauxite);
        GRAVITY_SEPARATOR(MAGMATIC_HYDROTHERMAL,Ulexite,Salt,RockSalt,Almandine,Sapphire,Redstone);
        GRAVITY_SEPARATOR(ALLUVIAL,Ruby,Silver,Bentonite,Olivine,Spessartine,Soapstone);

        GRAVITY_SEPARATOR(BET1,Copper,Tin,Iron,Cobalt,Lead,Oilsands);
        GRAVITY_SEPARATOR(BET2,Apatite,Realgar,Trona,Nickel,Graphite,Calcite);
        GRAVITY_SEPARATOR(BET3,Mica,Galena,Ruby,Lapis,Sapphire,Amethyst);
        GRAVITY_SEPARATOR(BET4,Opal,Redstone,Cinnabar,GarnetSand,Bauxite,Magnetite);

        GRAVITY_SEPARATOR(DIAPHRAGMATIC,Pyrolusite,Lepidolite,VanadiumMagnetite,Cryolite,Electrotine,Emerald);
        GRAVITY_SEPARATOR(ORTHOSTATIC,CertusQuartz,NetherQuartz,Beryllium,Molybdenum,Barite,Chalcocite);
        GRAVITY_SEPARATOR(METAMORPHIC,Stibnite,Sphalerite,Molybdenite,Sulfur,Pyrite,Crocoite);

        GRAVITY_SEPARATOR(END1,Magnetite,Gold,Bauxite,Beryllium,Emerald,Thorium);
        GRAVITY_SEPARATOR(END2,Chalcopyrite,Iron,Pyrite,Copper,BrownLimonite,YellowLimonite);
        GRAVITY_SEPARATOR(END3,BandedIron,Grossular,Pyrolusite,Pyrochlore,Tantalite,Wulfenite);
        GRAVITY_SEPARATOR(END4,Molybdenite,Molybdenum,Powellite,Diamond,Sphalerite,Tin);

        GRAVITY_SEPARATOR(BNT1,Lead,Neodymium,Ilmenite,Bastnasite,Monazite,Neodymium);
        GRAVITY_SEPARATOR(BNT2,Pitchblende,Uraninite,Cooperite,Gold,Aluminium,Bauxite);
        GRAVITY_SEPARATOR(BNT3,Scheelite,Tungstate,Iron,Lithium,Rutile,Stibnite);
        GRAVITY_SEPARATOR(BNT4,NaquadahOxide,Plutonium239,Powellite,Tin,Bismuth,Thorium);

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Steel,16)
                .input(stick, Steel,2)
                .input(ring, Steel, 4)
                .input(BATTERY_LV_LITHIUM,1)
                .input(circuit, MarkerMaterials.Tier.MV, 1)
                .input(SENSOR_LV,1)
                .output(POS_ORE_CARD)
                .circuitMeta(2)
                .duration(600).EUt(30).buildAndRegister();
    }
    private static void GRAVITY_SEPARATOR(MetaItem.MetaValueItem Item, Material material1, Material material2, Material material3, Material material4, Material material5, Material material6)
    {
        SIFTER_RECIPES.recipeBuilder()
                .input(Item)
                .chancedOutput(crushed, material1, 2000,500)
                .chancedOutput(crushed, material2, 2000,500)
                .chancedOutput(crushed, material3, 2000,500)
                .chancedOutput(crushed, material4, 2000,500)
                .chancedOutput(crushed, material5, 2000,500)
                .chancedOutput(crushed, material6, 2000,500)
                .EUt(120)
                .duration(400)
                .buildAndRegister();


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
    private static void MiningDrill(int tier,MetaItem.MetaValueItem Item,int kind) {
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
                    .tier(kind)
                    .EUt(VA[tier])
                    .duration(500)
                    .buildAndRegister();

    }

}
