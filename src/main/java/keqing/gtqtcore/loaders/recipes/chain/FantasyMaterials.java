package keqing.gtqtcore.loaders.recipes.chain;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.common.items.MetaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.common.items.MetaItems.*;
import static keqing.gtqtcore.api.recipes.GTQTcoreRecipeMaps.TD_PRINT_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.ingotHot;
import static keqing.gtqtcore.api.unification.GTQTMaterials.*;

public class FantasyMaterials {

    public static void init() {
        adamantium();
        orichalcum();
        vibranium();
        MetastableOganessonChain();
        Cosmic();
    }
    private static void MetastableOganessonChain() {
        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});


        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_ROD_LONG.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_RING.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(36)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_ROD.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(72)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BOLT.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(18)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_SCREW.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(18)});

        GTRecipeHandler.removeRecipesByInputs(TD_PRINT_RECIPES,
                new ItemStack[]{SHAPE_MOLD_ROUND.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(18)});

        /////////////////////////////////////////////////////////////////////

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_INGOT.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(1296)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_NUGGET.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});


        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_ROD_LONG.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(144)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_RING.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(36)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_ROD.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(72)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_BOLT.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(18)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_SCREW.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(18)});

        GTRecipeHandler.removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES,
                new ItemStack[]{SHAPE_MOLD_ROUND.getStackForm()},
                new FluidStack[]{MetastableOganesson.getFluid(18)});



        //  Metastable Oganesson liquid -> Metastable Oganesson hot ingot
        VACUUM_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(MetastableOganesson.getFluid(L))
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 500))
                .output(ingotHot, MetastableOganesson)
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 500))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();
    }
    private static void Cosmic() {
        //1.等离子体氟化裂解 (基岩粉 → 挥发性氟化物混合气 + 熔融残渣)
        // 基岩粉在超高真空环境下，被注入充满六氟化氪 (KrF6) 或二氟化二氮 (N2F2)
        // 等UHV级超强氟化剂的等离子体炬中。等离子体的极端高温（>20,000K）和活性氟自由基，
        // 将基岩中的硅、铝、碱土金属等主要成分转化为气态氟化物（如SiF4, AlF3(g)），
        // 难熔金属/超重元素富集在少量熔融残渣中。强腐蚀性！需中子素合金内衬。

        //基岩粉+六氟化氪 (KrF6) = 氟化基岩
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Krypton.getFluid(1000))
                .fluidInputs(Fluorine.getFluid(6000))
                .fluidOutputs(KryptonHexafluoride.getFluid(1000))
                .EUt(VA[IV])
                .duration(100)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust,Bedrock,10)
                .fluidInputs(KryptonHexafluoride.getFluid(1000))
                .output(dust, FluoriteBedRock,10)
                .EUt(VA[IV])
                .duration(240)
                .buildAndRegister();

        //氟化基岩 + EBF = 熔融基岩 +SiF4 + AlF3(g)
        BLAST_RECIPES.recipeBuilder()
                .input(dust, FluoriteBedRock,5)//12F
                .fluidInputs(Argon.getFluid(1000))
                .fluidOutputs(SiliconTetrafluoride.getFluid(1000)) //4F
                .output(dust,AluminiumTrifluoride,4) //3F
                .fluidOutputs(MeltedBedRock.getFluid(5000))//5F
                .blastFurnaceTemp(7200)
                .EUt(VA[ZPM])
                .duration(200)
                .buildAndRegister();

        //熔融基岩 + 蒸馏塔 = 熔融轻质金属混合物（锆石+板岩） + 熔融稀土金属混合物（独居石） + 熔融超重元素混合物（精金+宇宙素） + 氪*2000 + 液态石墨
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MeltedBedRock.getFluid(5000))//10F
                .fluidOutputs(MeltedLightMetalMixture.getFluid(1000))
                .fluidOutputs(MeltedRareMetalMixture.getFluid(1000))
                .fluidOutputs(MeltedSuperHeavyElementMixture.getFluid(3000))//10F
                .fluidOutputs(Krypton.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(240)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MeltedLightMetalMixture.getFluid(5000))
                .output(dust,Slate,4)
                .output(dust,Zircon,6)
                .EUt(VA[IV])
                .duration(80)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MeltedRareMetalMixture.getFluid(5000))
                .output(dust,Monazite,4)
                .output(dust,Graphite,6)
                .EUt(VA[IV])
                .duration(80)
                .buildAndRegister();

        //2.低温分级冷凝与捕集 (挥发性氟化物混合气 → 分离的各组分冷凝物)
        //高温混合气体急速冷却至接近绝对零度（使用液氦或更低温的磁制冷）。不同氟化物的沸点差异巨大
        // （如SiF4 -86°C, WF6 17°C, UF6 56°C升华），在精馏塔的不同层级冷凝分离。目标是分离出含有潜
        // 在超重元素氟化物的馏分（设想其沸点极高或极低）。需要精密温控。

        //熔融超重元素混合物 + 真空冷冻 = 超重元素富集残渣(精金) + 挥发性氟化物混合气（宇宙素）
        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(MeltedSuperHeavyElementMixture.getFluid(3000))//10F
                .fluidInputs(Helium.getFluid(FluidStorageKeys.LIQUID, 5000))
                .output(dust,SuperHeavyElementRichResidue,3)
                .fluidOutputs(FluorideHydrocarbonMixture.getFluid(3000))//10F
                .fluidOutputs(Helium.getFluid(FluidStorageKeys.GAS, 5000))
                .EUt(VA[ZPM])
                .duration(400)
                .buildAndRegister();

        //挥发性氟化物混合气 + 蒸馏塔 = 副产物...（氟化铀 氟化钨） + 宇宙素氟化物馏分
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(FluorideHydrocarbonMixture.getFluid(3000))//10F
                .fluidOutputs(UniverseFluorideMixture.getFluid(2000))//4F
                .fluidOutputs(HexafluorideEnrichedNaquadahSolution.getFluid(500))//3F
                .fluidOutputs(EnrichedUraniumHexafluoride.getFluid(500))//3F
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //3.超临界萃取富集 (目标氟化物馏分 + 超临界氦 → 超重元素富集液)
        //将上一步得到的目标馏分（固态或液态）置于超临界氦 (T > 5K, P > 2.5MPa) 环境中。利用超临界流体
        // 卓越的溶解和扩散能力，选择性溶解萃取其中特定的、极其稀有的超重元素络合物。通过调节压力和温度，实现选择性萃取和富集

        //宇宙素氟化物馏分 + 氡等离子体 = 宇宙素萃取液 + 氟化氡
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(UniverseFluorideMixture.getFluid(1000))//2F
                .fluidInputs(Radon.getFluid(1000))
                .fluidOutputs(RadonDifluoride.getFluid(1000))
                .fluidOutputs(UniverseExtractLiquid.getFluid(1000))
                .EUt(VA[IV])
                .duration(200)
                .buildAndRegister();

        //4.高温熔盐电解精炼 (超重元素富集液 → 粗超重金属合金锭)
        //将富集了超重元素的萃取液（需转化为合适盐类，如氯化物或氟化物）加入高温（>1500°C）熔融盐（如LiF-BeF2-ZrF4混合物）
        // 中作为电解质。使用中子素合金作为惰性阳极和阴极。在强大直流电作用下，目标超重金属离子在阴极还原沉积，形成粗合金锭。
        // 杂质元素留在熔盐中或阳极泥里。需要超高电流密度和稳定性。

        //萃取宇宙素 + LiF-BeF2-ZrF4（熔盐） = 杂质元素熔盐/阳极泥 + 粗宇宙素
        BLAST_RECIPES.recipeBuilder()
                .input(dust, LithiumFluoride,1)
                .input(dust, BerylliumFluoride,1)
                .input(dust, ZirconiumTetrafluoride,1)
                .fluidOutputs(LiBeZrFMoltenSalt.getFluid(3000))
                .blastFurnaceTemp(4000)
                .EUt(VA[EV])
                .duration(300)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(UniverseExtractLiquid.getFluid(1000))
                .fluidInputs(LiBeZrFMoltenSalt.getFluid(3000))
                .output(dust, CrudeUniverse,1)
                .output(dust, LithiumFluoride,1)
                .output(dust, BerylliumFluoride,1)
                .output(dust, ZirconiumTetrafluoride,1)
                .EUt(VA[ZPM])
                .duration(400)
                .buildAndRegister();


        //5.超临界宇宙素分离与成型 (宇宙素前体混合物 → 纯净宇宙素锭)
        // 嬗变后的产物是含有目标宇宙素同位素和其他短寿命衰变产物的混合物。将其置于充满超临界氙 (Xe) 或超临界二氧化碳 (CO2)（在UHV压力下）的腔室中。
        // 同时施加特殊的时空稳定场（抑制量子涨落和同位素衰变）。利用超临界流体在特定条件下的溶解度差异，将纯净的Cosmium原子/分子簇萃取分离出来，
        // 并在稳定场内直接沉积、压缩成型为标准的宇宙素锭。需要维持场稳定和超临界状态。

        //粗宇宙素 + 氙等离子 + EBF = 宇宙素粉 + 氙 + 残渣
        BLAST_RECIPES.recipeBuilder()
                .input(dust, CrudeUniverse,1)
                .fluidInputs(Xenon.getFluid(1000))
                .output(dust,Universe,1)
                .blastFurnaceTemp(7200)
                .EUt(VA[ZPM])
                .duration(200)
                .buildAndRegister();
    }
    private static void adamantium() {
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BedrockGas.getFluid(1000))
                .output(dust, Bedrock)
                .fluidOutputs(Helium3.getFluid(20))
                .duration(100).EUt(1024).buildAndRegister();

        /*
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Bedrock)
                .chancedOutput(dust, Slate, 7000, 0)
                .chancedOutput(dust, Adamantium, 3000, 500)
                .chancedOutput(dust, Monazite, 2, 3000, 0)
                .chancedOutput(dust, Zircon, 3, 3000, 0)
                .chancedOutput(dust, Graphite, 3, 3000, 0)
                .duration(240).EUt(VA[IV]).buildAndRegister();

         */

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, SuperHeavyElementRichResidue, 3)
                .fluidInputs(Naquadah.getFluid(L * 4))
                .output(dust, Naquadah)
                .output(dust, Uranium238)
                .fluidOutputs(AdamantiumUnstable.getFluid(L * 4))
                .duration(800).EUt(VA[LuV]).buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Europium.getFluid(16))
                .fluidInputs(AdamantiumUnstable.getFluid(16))
                .fluidOutputs(Adamantium.getPlasma(16))
                .EUToStart(300_000_000)
                .duration(32).EUt(VA[LuV]).buildAndRegister();

        // remove adamantium dust -> hot ingot
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Adamantium,1), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Adamantium,1), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Argon.getFluid(50)});

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(MetaItems.SHAPE_MOLD_INGOT)
                .fluidInputs(Adamantium.getPlasma(L))
                .output(ingotHot, Adamantium)
                .duration(200).EUt(VA[IV]).buildAndRegister();
    }

    private static void orichalcum() {
        // Remove CEu Neutronium
        GTRecipeHandler.removeRecipesByInputs(FUSION_RECIPES, Americium.getFluid(128), Naquadria.getFluid(128));

        // replace with orichalcum
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(128))
                .fluidInputs(Naquadria.getFluid(128))
                .fluidOutputs(Orichalcum.getFluid(32))
                .EUToStart(600_000_000)
                .duration(200).EUt(VA[LuV] * 3).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Orichalcum)
                .fluidInputs(Helium.getPlasma(125))
                .output(dust, OrichalcumEnergized)
                .duration(200).EUt(VA[ZPM]).buildAndRegister();

        // remove orichalcum dust -> hot ingot
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Orichalcum), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Orichalcum), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Argon.getFluid(50)});

        BLAST_RECIPES.recipeBuilder()
                .input(dust, OrichalcumEnergized)
                .notConsumable(new IntCircuitIngredient(1))
                .output(ingotHot, Orichalcum)
                .blastFurnaceTemp(9000)
                .duration(2000).EUt(VA[UV]).buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, OrichalcumEnergized)
                .notConsumable(new IntCircuitIngredient(2))
                .fluidInputs(Argon.getFluid(50))
                .output(ingotHot, Orichalcum)
                .blastFurnaceTemp(9000)
                .duration(1000).EUt(VA[UV]).buildAndRegister();
    }

    private static void vibranium() {

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, DeepIron, 4)
                .output(dust, Iron, 2)
                .output(dust, Trinium)
                .output(dust, Indium)
                .duration(600).EUt(VA[IV]).buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, AdamantiumEnriched, 4)
                .fluidInputs(NaquadahEnriched.getFluid(L * 4))
                .output(dust, NaquadahEnriched, 2)
                .output(dust, Plutonium239)
                .fluidOutputs(VibraniumUnstable.getFluid(L * 4))
                .duration(1600).EUt(VA[ZPM]).buildAndRegister();

        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Orichalcum.getFluid(L))
                .fluidInputs(VibraniumUnstable.getFluid(L))
                .fluidOutputs(Vibranium.getPlasma(L))
                .EUToStart(620_000_000)
                .duration(64).EUt(VA[ZPM] * 2).buildAndRegister();

        // remove vibranium dust -> hot ingot
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Vibranium), IntCircuitIngredient.getIntegratedCircuit(1));
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Vibranium), IntCircuitIngredient.getIntegratedCircuit(2)}, new FluidStack[]{Argon.getFluid(50)});

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(MetaItems.SHAPE_MOLD_INGOT)
                .fluidInputs(Vibranium.getPlasma(L))
                .output(ingotHot, Vibranium)
                .duration(400).EUt(500_000).buildAndRegister();
    }
}
