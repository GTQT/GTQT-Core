package keqing.gtqtcore.api.recipes;

import gregtech.api.GTValues;
import gregtech.api.mui.GTGuiTextures;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMapBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.*;
import gregtech.api.recipes.ui.impl.DistillationTowerUI;
import gregtech.core.sound.GTSoundEvents;
import keqing.gtqtcore.api.recipes.builder.*;
import keqing.gtqtcore.api.recipes.ui.*;
import keqing.gtqtcore.client.sound.GTQTSoundHandler;

import static gregtech.api.recipes.RecipeMaps.*;

public class GTQTcoreRecipeMaps {

    /*
    public static final RecipeMap<SimpleRecipeBuilder> PROCESSING_MODE_A = new RecipeMap<>("processing_mode_a", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.COMPRESSOR_RECIPES, RecipeMaps.LATHE_RECIPES, RecipeMaps.POLARIZER_RECIPES);
    public static final RecipeMap<SimpleRecipeBuilder> PROCESSING_MODE_B = new RecipeMap<>("processing_mode_b", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.FERMENTING_RECIPES, RecipeMaps.EXTRACTOR_RECIPES, RecipeMaps.CANNER_RECIPES );
    public static final RecipeMap<SimpleRecipeBuilder> PROCESSING_MODE_C = new RecipeMap<>("processing_mode_c", 2, 2, 1, 1, new SimpleRecipeBuilder(), RecipeMaps.LASER_ENGRAVER_RECIPES, RecipeMaps.AUTOCLAVE_RECIPES, RecipeMaps.FLUID_SOLIDFICATION_RECIPES);
     */
    public static final RecipeMap<SimpleRecipeBuilder> PROCESSING_MODE_A = new RecipeMapBuilder<>("processing_mode_a",
            new SimpleRecipeBuilder())
            .itemInputs(3)
            .fluidInputs(3)
            .itemOutputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARC_FURNACE)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> PROCESSING_MODE_B = new RecipeMapBuilder<>("processing_mode_b",
            new SimpleRecipeBuilder())
            .itemInputs(3)
            .fluidInputs(3)
            .itemOutputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARC_FURNACE)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> PROCESSING_MODE_C = new RecipeMapBuilder<>("processing_mode_c",
            new SimpleRecipeBuilder())
            .itemInputs(3)
            .fluidInputs(3)
            .itemOutputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARC_FURNACE)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> LASER_FUSION_RECIPES = new RecipeMapBuilder<>("laser_fusion",
            new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARC_FURNACE)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> SIMULATOR_RECIPES = new RecipeMapBuilder<>("simulator",
            new SimpleRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(2)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARC_FURNACE)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<FuelRecipeBuilder> LARGE_NAQUADAH_REACTOR_RECIPES = new RecipeMapBuilder<>("large_naquadah_reactor", new FuelRecipeBuilder())
            .fluidInputs(1)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .fluidSlotOverlay(GTGuiTextures.DARK_CANISTER_OVERLAY, false, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_GAS_COLLECTOR)
            )
            .allowEmptyOutputs()
            .sound(GTSoundEvents.COMBUSTION)
            .generator()
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> SPINNER_RECIPES = new RecipeMapBuilder<>("spinner",
            new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(1)
            .fluidInputs(1)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.VIAL_OVERLAY_1, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_COMPRESS)
            )
            .sound(GTSoundEvents.WIRECUTTER_TOOL)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> LARGE_MIXER_RECIPES = new RecipeMapBuilder<>("large_mixer",
            new SimpleRecipeBuilder())
            .itemInputs(9)
            .itemOutputs(1)
            .fluidInputs(6)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.DUST_OVERLAY, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MIXER)
            )
            .sound(GTSoundEvents.MIXER)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_CONDENSER_RECIPES = new RecipeMapBuilder<>("plasma_condenser_recipes", new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_REPLICATOR)
            )
            .sound(GTSoundEvents.COOLING)
            .build();

    public static final RecipeMap<FuelRecipeBuilder> HIGH_PRESSURE_STEAM_TURBINE_RECIPES = new RecipeMapBuilder<>("high_pressure_steam_turbine", new FuelRecipeBuilder())
            .fluidInputs(1)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .fluidSlotOverlay(GTGuiTextures.DARK_CANISTER_OVERLAY, false, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_GAS_COLLECTOR)
            )
            .allowEmptyOutputs()
            .sound(GTSoundEvents.TURBINE)
            .generator()
            .build();

    public static final RecipeMap<FuelRecipeBuilder> SUPERCRITICAL_STEAM_TURBINE_RECIPES = new RecipeMapBuilder<>("supercritical_steam_turbine", new FuelRecipeBuilder())
            .fluidInputs(1)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .fluidSlotOverlay(GTGuiTextures.DARK_CANISTER_OVERLAY, false, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_GAS_COLLECTOR)
            )
            .allowEmptyOutputs()
            .sound(GTSoundEvents.TURBINE)
            .generator()
            .build();

    public static final RecipeMap<SwarmTierRecipeBuilder> NEUTRAL_NETWORK_NEXUS_BREEDING_MODE = new RecipeMapBuilder<>("neutral_network_nexus_breeding_mode", new SwarmTierRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(1)
            .fluidInputs(3)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false)
                    .itemSlotOverlay(GTGuiTextures.MOLECULAR_OVERLAY_3, true, false)
                    .itemSlotOverlay(GTGuiTextures.MOLECULAR_OVERLAY_4, true, true)
                    .fluidSlotOverlay(GTGuiTextures.EXTRACTOR_OVERLAY, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_CIRCUIT)
            )
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<PrimitiveRecipeBuilder> PRIMITIVE_ROASTING_RECIPES = new RecipeMapBuilder<>("primitive_roaster", new PrimitiveRecipeBuilder())
            .itemInputs(4)
            .itemOutputs(4)
            .fluidInputs(1)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_1, false)
                    .itemSlotOverlay(GTGuiTextures.OUT_SLOT_OVERLAY, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_COKE_OVEN)
            )
            .sound(GTSoundEvents.FURNACE)
            .build();

    public static final RecipeMap<EvaporationPoolRecipeBuilder> EVAPORATION_POOL = new RecipeMapBuilder<>("evaporation_pool", new EvaporationPoolRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(4)
            .fluidInputs(1)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_SIFT)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> GRAVITY_SEPARATOR_RECIPES = new RecipeMapBuilder<>("gravity_separator", new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(6)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CRUSHED_ORE_OVERLAY, false)
                    .itemSlotOverlay(GTGuiTextures.CRUSHED_ORE_OVERLAY, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<CircuitAssemblyLineRecipeBuilder> LARGE_CIRCUIT_ASSEMBLY_LINE_RECIPES = new RecipeMapBuilder<>("large_circuit_assembly_line", new CircuitAssemblyLineRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(6)
            .fluidInputs(1)
            //.ui(LargeCircuitAssemblyLineUI::new)
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<FuelRecipeBuilder> BIOMASS_GENERATOR_RECIPES = new RecipeMapBuilder<>("biomass_generator", new FuelRecipeBuilder())
            .fluidInputs(1)
            .allowEmptyOutputs()
            .uiBuilder(builder -> builder
                .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.BATH)
            .generator()
            .build();

    public static final RecipeMap<FuelRecipeBuilder> ANTIMATTER_GENERATOR = new RecipeMapBuilder<>("antimatter_generator", new FuelRecipeBuilder())
            .itemInputs(2)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.ARC)
            .allowEmptyOutputs()
            .generator()
            .build();

    public static final RecipeMap<FuelRecipeBuilder> ACID_GENERATOR_RECIPES = new RecipeMapBuilder<>("acid_generator", new FuelRecipeBuilder())
            .fluidInputs(1)
            .allowEmptyOutputs()
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .generator()
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> AUTO_CHISEL_RECIPES = new RecipeMapBuilder<>("auto_chisel", new SimpleRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(1)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.FILE_TOOL)
            .build();

    public static final RecipeMap<PseudoMultiRecipeBuilder> LATEX_COLLECTOR_RECIPES = new RecipeMapBuilder<>("latex_collector", new PseudoMultiRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(2)
            .fluidInputs(1)
            .fluidOutputs(2)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.DRILL_TOOL)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMapBuilder<>("catalytic_reformer_recipes", new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(6)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.FURNACE)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> CONDENSER_RECIPES = new RecipeMapBuilder<>("condenser", new SimpleRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.BOX_OVERLAY, true)
                    .fluidSlotOverlay(GTGuiTextures.BOX_OVERLAY, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.COMPRESSOR)
            .build();

    public static final RecipeMap<PressureRecipeBuilder> CVD_RECIPES = new RecipeMapBuilder<>("cvd_recipes", new PressureRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.COOLING)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES = new RecipeMapBuilder<>("drill_recipes", new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CRUSHED_ORE_OVERLAY, false, true)
                    .itemSlotOverlay(GTGuiTextures.DUST_OVERLAY, true, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZER_RECIPES = new RecipeMapBuilder<>("crystallization_recipes", new BlastRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(1)
            .fluidInputs(2)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_CRYSTALLIZATION)
            )
            .sound(GTSoundEvents.FURNACE)
            .build();

    public static final RecipeMap<TemperaturePressureRecipeBuilder> CZPULLER_RECIPES = new RecipeMapBuilder<>("czpuller_recipes", new TemperaturePressureRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(1)
            .fluidInputs(1)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_CRYSTALLIZATION)
            )
            .sound(GTSoundEvents.FURNACE)
            .build();

    public static final RecipeMap<PCBFactoryRecipeBuilder> PCB_FACTORY_RECIPES = new RecipeMapBuilder<>("pcb_factory", new PCBFactoryRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(9)
            .fluidInputs(3)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, true, true)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, true, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_CIRCUIT_ASSEMBLER)
            )
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES = new RecipeMapBuilder<>("component_assembler_recipes", new SimpleRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(1)
            .fluidInputs(1)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, true, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<PressureRecipeBuilder> VACUUM_CHAMBER_RECIPES = new RecipeMapBuilder<>("vacuum_chamber_recipes", new PressureRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_COMPRESS)
            )
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<ComponentAssemblyLineRecipesTierRecipeBuilder> COMPONENT_ASSEMBLY_LINE_RECIPES = new RecipeMapBuilder<>("component_assembly_line_recipes", new ComponentAssemblyLineRecipesTierRecipeBuilder())
            .itemInputs(12)
            .itemOutputs(1)
            .fluidInputs(12)
            .fluidOutputs(0)
            .sound(GTSoundEvents.ASSEMBLER)
            .ui(ComponentAssemblyLineUI::new)
            .build();

    public static final RecipeMap<ElectronRecipeBuilder> ELECTROBATH = new RecipeMapBuilder<>("electrobath", new ElectronRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(6)
            .fluidInputs(6)
            .fluidOutputs(6)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_BATH)
            )
            .sound(GTSoundEvents.ELECTROLYZER)
            .build();

    public static final RecipeMap<SwarmTierRecipeBuilder> SWARM_GROWTH = new RecipeMapBuilder<>("swarm_growth", new SwarmTierRecipeBuilder())
            .itemInputs(16)
            .itemOutputs(1)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_HAMMER)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<SwarmTierRecipeBuilder> SWARM_ASSEMBLER = new RecipeMapBuilder<>("swarm_assembler", new SwarmTierRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(1)
            .fluidInputs(9)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_HAMMER)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<ComputationRecipeBuilder> PARTICLE_ACCELERATOR_RECIPES = new RecipeMapBuilder<>("particle_accelerator", new ComputationRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(3)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> DIGESTER_RECIPES = new RecipeMapBuilder<>("digester_recipes", new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<BioRecipeRecipeBuilder> BIOLOGICAL_REACTION_RECIPES = new RecipeMapBuilder<>("biological_reaction_recipes", new BioRecipeRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<BioRecipeRecipeBuilder> GENE_MUTAGENESIS = new RecipeMapBuilder<>("gene_mutagenesis", new BioRecipeRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(6)
            .fluidInputs(6)
            .fluidOutputs(6)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<EnzymesReactionRecipeBuilder> ENZYMES_REACTION_RECIPES = new RecipeMapBuilder<>("enzymes_reaction_recipes", new EnzymesReactionRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<PHRecipeBuilder> FERMENTATION_TANK_RECIPES = new RecipeMapBuilder<>("fermentation_tank_recipes", new PHRecipeBuilder())
            .itemInputs(4)
            .itemOutputs(4)
            .fluidInputs(4)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_EXTRACT)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> FUEL_REFINE_FACTORY_RECIPES = new RecipeMapBuilder<>("fuel_refine_factory_recipes", new SimpleRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(6)
            .fluidInputs(6)
            .fluidOutputs(6)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<ForceFieldCoilRecipeBuilder> NAQUADAH_REFINE_FACTORY_RECIPES = new RecipeMapBuilder<>("naquadah_refine_factory_recipes", new ForceFieldCoilRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(6)
            .fluidInputs(6)
            .fluidOutputs(6)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<FuelRecipeBuilder> ROCKET_RECIPES = new RecipeMapBuilder<>("rocket_engine_recipes", new FuelRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(1)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CENTRIFUGE_OVERLAY, false, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_GAS_COLLECTOR)
            )
            .sound(GTSoundEvents.TURBINE)
            .allowEmptyOutputs()
            .build();

    public static final RecipeMap<FuelRecipeBuilder> NAQUADAH_REACTOR = new RecipeMapBuilder<>("naquadah_reactor", new FuelRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(1)
            .fluidInputs(0)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.COMBUSTION)
            .allowEmptyOutputs()
            .generator()
            .build();

    public static final RecipeMap<ChemicalPlantBuilder> CHEMICAL_PLANT = new RecipeMapBuilder<>("chemical_plant", new ChemicalPlantBuilder())
            .itemInputs(6)
            .itemOutputs(6)
            .fluidInputs(6)
            .fluidOutputs(6)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> INTEGRATED_MINING_DIVISION = new RecipeMapBuilder<>("integrated_mining_division", new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<QFTRecipeBuilder> QUANTUM_FORCE_TRANSFORMER_RECIPES = new RecipeMapBuilder<>("quantum_force_transformer_recipes", new QFTRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(6)
            .fluidInputs(6)
            .fluidOutputs(6)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.SCIENCE)
            .build();

    public static final RecipeMap<FlowRateRecipeBuilder> HEAT_EXCHANGE_RECIPES = new RecipeMapBuilder<>("heat_exchanger_recipes", new FlowRateRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(2)
            .fluidOutputs(3)
            .sound(GTSoundEvents.BATH)
            .ui(HeatExchangerUI::new)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> RECYCLE_RECIPE = new RecipeMapBuilder<>("recycle_items", new SimpleRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(1)
            .fluidInputs(0)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> POLISHER_RECIPES = new RecipeMapBuilder<>("polisher", new SimpleRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(2)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.SAWBLADE_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.CUTTER_OVERLAY, true, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_BATH)
            )
            .sound(GTSoundEvents.CUT)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> PLASMA_FORGE = new RecipeMapBuilder<>("plasma_forge", new SimpleRecipeBuilder())
            .itemInputs(9)
            .itemOutputs(9)
            .fluidInputs(9)
            .fluidOutputs(9)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .build();

    public static final RecipeMap<UniversalDistillationRecipeBuilder> MOLECULAR_DISTILLATION_RECIPES = new RecipeMapBuilder<>(
            "molecular_distillation_recipes", new UniversalDistillationRecipeBuilder())
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(12)
            .ui(DistillationTowerUI::new)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<PrimitiveRecipeBuilder> PR_MIX = new RecipeMapBuilder<>("pr_mix", new PrimitiveRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<HeatRecipeBuilder> SALT_FLIED = new RecipeMapBuilder<>("salt_fish", new HeatRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<KQComputationRecipeBuilder> RESEARCH_SYSTEM_RECIPES = new RecipeMapBuilder<>("research_system_network", new KQComputationRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.SCANNER_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.RESEARCH_STATION_OVERLAY, true, false)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.COMPUTATION)
            .build();

    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK1_RECIPES = new RecipeMapBuilder<>("hyper_reactor_mk1_recipes", new FuelRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.ARC)
            .allowEmptyOutputs()
            .build();

    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK2_RECIPES = new RecipeMapBuilder<>("hyper_reactor_mk2_recipes", new FuelRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.ARC)
            .allowEmptyOutputs()
            .build();

    public static final RecipeMap<FuelRecipeBuilder> HYPER_REACTOR_MK3_RECIPES = new RecipeMapBuilder<>("hyper_reactor_mk3_recipes", new FuelRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.ARC)
            .allowEmptyOutputs()
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> DISSOLUTION_TANK_RECIPES = new RecipeMapBuilder<>("dissolution_tank_recipes", new SimpleRecipeBuilder())
            .itemInputs(4)
            .itemOutputs(4)
            .fluidInputs(4)
            .fluidOutputs(4)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> BIO_CENTRIFUGE = new RecipeMapBuilder<>("bio_centrifuge", new SimpleRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> FLOTATION_FACTORY_RECIPES = new RecipeMapBuilder<>("flotation_factory_recipes", new SimpleRecipeBuilder())
            .itemInputs(6)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_BATH)
            )
            .sound(GTSoundEvents.BATH)
            .build();

    public static final RecipeMap<BlastRecipeBuilder> VACUUM_DRYING_FURNACE_RECIPES = new RecipeMapBuilder<>("vacuum_drying_furnace_recipes", new BlastRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(9)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_SIFT)
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_1, false, false)
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_1, false, true)
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_2, true, false)
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_2, true, true)
            )
            .sound(GTSoundEvents.FURNACE)
            .build();

    public static final RecipeMap<GrindBallTierRecipeBuilder> ISA_MILL_GRINDER = new RecipeMapBuilder<>("isa_mill_recipes", new GrindBallTierRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<PrimitiveRecipeBuilder> OIL_POOL = new RecipeMapBuilder<>("oil_pool", new PrimitiveRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(2)
            .fluidOutputs(2)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<CasingComputationRecipeBuilder> PRECISE_ASSEMBLER_RECIPES = new RecipeMapBuilder<>("precise_assembler_recipes", new CasingComputationRecipeBuilder())
            .itemInputs(4)
            .itemOutputs(1)
            .fluidInputs(4)
            .ui(PreciseAssemblerUI::new)
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<CasingComputationRecipeBuilder> MOLECULAR_TRANSFORMER_RECIPES = new RecipeMapBuilder<>("molecular_transformer", new CasingComputationRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(1)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_COMPRESS)
                    .itemSlotOverlay(GTGuiTextures.MOLECULAR_OVERLAY_1, false, false)
                    .itemSlotOverlay(GTGuiTextures.MOLECULAR_OVERLAY_2, true, false)
            )
            .sound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.ARC)
            .build();

    public static final RecipeMap<MiningDrillRecipeBuilder> MINING_DRILL_RECIPES = new RecipeMapBuilder<>("mining_drill", new MiningDrillRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(9)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
                    .itemSlotOverlay(GTGuiTextures.CRUSHED_ORE_OVERLAY, false, true)
                    .itemSlotOverlay(GTGuiTextures.DUST_OVERLAY, true, true)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<HeatRecipeBuilder> DISTILLATION_KETTLE = new RecipeMapBuilder<>("distillation_kettle", new HeatRecipeBuilder())
            .fluidInputs(1)
            .fluidOutputs(9)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_SIFT)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> DESULPHURIZATION_RECIPES = new RecipeMapBuilder<>("desulphurization_recipes", new SimpleRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(2)
            .fluidOutputs(2)
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<ChemicalPlantBuilder> FLUIDIZED_BED = new RecipeMapBuilder<>("fluidized_bed_recipes", new ChemicalPlantBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .build();

    public static final RecipeMap<HeatRecipeBuilder> PYROLYSIS_TOWER = new RecipeMapBuilder<>("pyrolysis_tower", new HeatRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(6)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_SIFT)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<ComputationRecipeBuilder> LASER_ENGRAVING = new RecipeMapBuilder<>("laser_engraving", new ComputationRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(6)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, true)
            )
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<ComputationRecipeBuilder> TD_PRINT_RECIPES = new RecipeMapBuilder<>("threed_print", new ComputationRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, true)
            )
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<ComputationRecipeBuilder> PRECISION_SPRAYING = new RecipeMapBuilder<>("precision_spraying", new ComputationRecipeBuilder())
            .itemInputs(2)
            .itemOutputs(2)
            .fluidInputs(1)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, true)
            )
            .sound(GTSoundEvents.CENTRIFUGE)
            .build();

    public static final RecipeMap<ComputationRecipeBuilder> PRECISION_SPINNING = new RecipeMapBuilder<>("precision_spinning", new ComputationRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(0)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, true)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .build();

    public static final RecipeMap<BlastRecipeBuilder> ANTIMATTER_FORGE = new RecipeMapBuilder<>("antimatter_forge", new BlastRecipeBuilder())
            .itemInputs(9)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_1, false, false)
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_1, false, true)
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_2, true, false)
                    .itemSlotOverlay(GTGuiTextures.FURNACE_OVERLAY_2, true, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.ARC)
            .build();

    public static final RecipeMap<LaserComputationRecipeBuilder> STEPPER_RECIPES = new RecipeMapBuilder<>("stepper_recipes", new LaserComputationRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .uiBuilder(builder -> builder
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, false)
                    .itemSlotOverlay(GTGuiTextures.CIRCUIT_OVERLAY, false, true)
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.ASSEMBLER)
            .build();

    public static final RecipeMap<PrimitiveRecipeBuilder> CLARIFIER = new RecipeMapBuilder<>("clarifire", new PrimitiveRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_MACERATE)
            )
            .sound(GTSoundEvents.MACERATOR)
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> ELEOIL = new RecipeMapBuilder<>("ele_oil", new SimpleRecipeBuilder())
            .itemInputs(0)
            .itemOutputs(0)
            .fluidInputs(2)
            .fluidOutputs(2)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .build();

    public static final RecipeMap<SimpleRecipeBuilder> SFM = new RecipeMapBuilder<>("sfm", new SimpleRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(1)
            .fluidInputs(1)
            .fluidOutputs(12)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW_MULTIPLE)
            )
            .sound(GTSoundEvents.CHEMICAL_REACTOR)
            .ui(SFMDistillationTowerUI::new)
            .build();

    public static final RecipeMap<TargetRecipeBuilder> TARGET_CHAMBER = new RecipeMapBuilder<>("target_chamber", new TargetRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_COMPRESS)
            )
            .sound(GTSoundEvents.ARC)
            .build();
    public static final RecipeMap<TargetRecipeBuilder> NUCLEOSYNTHESIS = new RecipeMapBuilder<>("nucleosynthesis", new TargetRecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_COMPRESS)
            )
            .sound(GTSoundEvents.ARC)
            .build();

    public static final RecipeMap<NeutronActivatorIORecipeBuilder> BEAM_COLLECTION = new RecipeMapBuilder<>("beam_collection", new NeutronActivatorIORecipeBuilder())
            .itemInputs(3)
            .itemOutputs(3)
            .fluidInputs(3)
            .fluidOutputs(3)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_COMPRESS)
            )
            .sound(GTSoundEvents.ARC)
            .build();

    //超维度熔炼
    public static final RecipeMap<BlastRecipeBuilder> EXTRADIMENSIONAL_SMELTING_RECIPES = new RecipeMapBuilder<>("extradimensional_smelting_recipes", new BlastRecipeBuilder())
            .itemInputs(9)
            .itemOutputs(9)
            .fluidInputs(9)
            .fluidOutputs(9)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARC_FURNACE)
            )
            .sound(GTSoundEvents.ARC)
            .build();

    public static final RecipeMap<BlastRecipeBuilder> STELLAR_FORGE_RECIPES = new RecipeMapBuilder<>("stellar_forge_recipes", new BlastRecipeBuilder())
            .itemInputs(9)
            .itemOutputs(9)
            .fluidInputs(9)
            .fluidOutputs(9)
            .ui(StellarForgeUI::new)
            .sound(GTQTSoundHandler.STELLAR_FORGE)
            .build();


    //超维度搅拌
    public static final RecipeMap<SimpleRecipeBuilder> EXTRADIMENSIONAL_MIXING_RECIPES = new RecipeMapBuilder<>("extradimensional_mixing_recipes", new SimpleRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(0)
            .fluidInputs(12)
            .fluidOutputs(1)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARC_FURNACE)
            )
            .sound(GTSoundEvents.MINER)
            .build();

    public static RecipeMap<EOHRecipeBuilder> VIRTUAL_COSMOS_SIMULATOR_RECIPES = new RecipeMapBuilder<>("virtual_cosmos_simulator_recipes", new EOHRecipeBuilder())
            .itemInputs(1)
            .itemOutputs(81)
            .fluidInputs(2)
            .fluidOutputs(18)
            .ui(EOHUI::new)
            .build();

    public static RecipeMap<FuelRecipeBuilder> FUEL_CELL = new RecipeMapBuilder<>("fuel_cell", new FuelRecipeBuilder())
            .fluidInputs(2)
            .uiBuilder(builder -> builder
                    .progressBar(GTGuiTextures.PROGRESS_BAR_ARROW)
            )
            .sound(GTSoundEvents.COMBUSTION)
            .allowEmptyOutputs()
            .generator()
            .build();


    private GTQTcoreRecipeMaps() {
    }

    public static void init() {
        RecipeMaps.BLAST_RECIPES.setMaxFluidInputs(3);
        RecipeMaps.BLAST_RECIPES.setMaxFluidOutputs(3);
        CUTTER_RECIPES.setMaxOutputs(4);
        ELECTROLYZER_RECIPES.setMaxFluidInputs(2);
        LASER_ENGRAVER_RECIPES.setMaxOutputs(2);
        REPLICATOR_RECIPES.setMaxFluidInputs(3);
        COMBUSTION_GENERATOR_FUELS.setMaxFluidOutputs(1);
        CANNER_RECIPES.setMaxFluidInputs(1);
        EXTRACTOR_RECIPES.setMaxFluidInputs(2);
        EXTRACTOR_RECIPES.setMaxFluidOutputs(2);
        EXTRACTOR_RECIPES.setMaxInputs(2);
        EXTRACTOR_RECIPES.setMaxOutputs(2);
        CHEMICAL_RECIPES.setMaxInputs(3);
        ASSEMBLER_RECIPES.setMaxFluidInputs(3);

        FLUID_HEATER_RECIPES.setMaxFluidInputs(3);
        FLUID_HEATER_RECIPES.setMaxFluidOutputs(3);
        FLUID_HEATER_RECIPES.setMaxInputs(3);
        FLUID_HEATER_RECIPES.setMaxOutputs(3);

        CENTRIFUGE_RECIPES.setMaxFluidInputs(3);
        CENTRIFUGE_RECIPES.setMaxInputs(3);
    }

}