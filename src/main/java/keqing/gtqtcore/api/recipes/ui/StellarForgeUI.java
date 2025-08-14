package keqing.gtqtcore.api.recipes.ui;

import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.RecipeProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.ui.RecipeMapUI;
import keqing.gtqtcore.api.gui.GTQTGuiTextures;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

public class StellarForgeUI<R extends RecipeMap<?>> extends RecipeMapUI<R> {

    public StellarForgeUI(R recipeMap) {
        super(recipeMap, true, true, true, true, false);
        setItemSlotOverlay(GuiTextures.FURNACE_OVERLAY_1, false);
        setItemSlotOverlay(GuiTextures.FURNACE_OVERLAY_1, true);
        setFluidSlotOverlay(GuiTextures.FURNACE_OVERLAY_2, false);
        setFluidSlotOverlay(GuiTextures.FURNACE_OVERLAY_2, true);
        setProgressBar(GTQTGuiTextures.PROGRESS_BAR_NOVA_EXPLOSION, ProgressWidget.MoveType.HORIZONTAL);
    }

    @Nonnull
    @Override
    public ModularUI.Builder createJeiUITemplate(@Nonnull IItemHandlerModifiable importItems,
                                                 @Nonnull IItemHandlerModifiable exportItems,
                                                 @Nonnull FluidTankList importFluids,
                                                 @Nonnull FluidTankList exportFluids,
                                                 int yOffset) {
        ModularUI.Builder builder = new ModularUI.Builder(GuiTextures.BACKGROUND, 176, 176 + 18 * 2 + 18)
                .widget(new RecipeProgressWidget(
                        200,
                        176 / 2 - 18 + 4,
                        18 * 3 - 4,
                        21,
                        21,
                        progressBarTexture(),
                        progressBarMoveType(),
                        recipeMap()
                ));
        addInventorySlotGroup(builder, importItems, importFluids, false, yOffset);
        addInventorySlotGroup(builder, exportItems, exportFluids, true, yOffset);
        return builder;
    }

    @Override
    public void addInventorySlotGroup(@Nonnull ModularUI.Builder builder,
                                      @Nonnull IItemHandlerModifiable itemHandler,
                                      @Nonnull FluidTankList fluidHandler,
                                      boolean isOutputs,
                                      int yOffset) {
        int startInputsX1 = 14;
        int startInputsY1 = 9;

        if (!isOutputs) {
            // Item input slots (3x3 grid)
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    int slotIndex = i * 3 + j;
                    addSlot(builder,
                            startInputsX1 + 18 * j,
                            startInputsY1 + 18 * i,
                            slotIndex,
                            itemHandler,
                            fluidHandler,
                            false,
                            false
                    );
                }
            }

            // Fluid input slots (3x3 grid below items)
            int startInputsY2 = startInputsY1 + 18 * 3;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    int slotIndex = i * 3 + j;
                    addSlot(builder,
                            startInputsX1 + 18 * j,
                            startInputsY2 + 18 * i,
                            slotIndex,
                            itemHandler,
                            fluidHandler,
                            true,
                            false
                    );
                }
            }
        } else {
            // Item output slots (3x3 grid, right-aligned)
            int startInputsX2 = startInputsX1 + 3 * 18 + 34;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    int slotIndex = i * 3 + j;
                    addSlot(builder,
                            startInputsX2 + 18 * j,
                            startInputsY1 + 18 * i,
                            slotIndex,
                            itemHandler,
                            fluidHandler,
                            false,
                            true
                    );
                }
            }

            // Fluid output slots (3x3 grid below items)
            int startInputsY3 = startInputsY1 + 3 * 18;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    int slotIndex = i * 3 + j;
                    addSlot(builder,
                            startInputsX2 + 18 * j,
                            startInputsY3 + 18 * i,
                            slotIndex,
                            itemHandler,
                            fluidHandler,
                            true,
                            true
                    );
                }
            }
        }
    }
}