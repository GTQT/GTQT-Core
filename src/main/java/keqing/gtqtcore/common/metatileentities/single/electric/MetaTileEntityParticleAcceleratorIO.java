package keqing.gtqtcore.common.metatileentities.single.electric;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityParticleAcceleratorIO extends SimpleMachineMetaTileEntity {
    public int circuit;
    public int tier;
    public int time;
    public boolean output;

    public MetaTileEntityParticleAcceleratorIO(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, ICubeRenderer renderer, int tier, boolean hasFrontFacing) {
        super(metaTileEntityId, recipeMap, renderer, tier, hasFrontFacing);
        this.tier = tier;
    }

    public void update() {
        super.update();
        circuit = circuitInventory.getCircuitValue();
        time++;
        if (isActive() && time == 1200) {
            output = true;
            time = 0;
        } else output = false;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityParticleAcceleratorIO(this.metaTileEntityId, this.workable.getRecipeMap(), this.renderer, this.getTier(), this.hasFrontFacing());
    }

}
