package keqing.gtqtcore.common.entities.explosive;

import gregtech.common.entities.EntityGTExplosive;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityQuantumChromodynamicCharge extends EntityGTExplosive {

    public EntityQuantumChromodynamicCharge(World world, double x, double y, double z, EntityLivingBase exploder) {
        super(world, x, y, z, exploder);
    }

    public EntityQuantumChromodynamicCharge(World world) {
        this(world, 0.0, 0.0, 0.0, null);
    }

    @Override
    protected float getStrength() {
        return 72;
    }

    @Override
    public boolean dropsAllBlocks() {
        return false;
    }

    @Override
    protected int getRange() {
        return 26;
    }

    @Override
    public IBlockState getExplosiveState() {
        return GTQTMetaBlocks.LEPTONIC_CHARGE.getDefaultState();
    }
}
