package keqing.gtqtcore.common.entities.explosive;

import gregtech.common.entities.EntityGTExplosive;
import keqing.gtqtcore.common.block.GTQTMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityNuclearTNT extends EntityGTExplosive {

    public EntityNuclearTNT(World world, double x, double y, double z, EntityLivingBase exploder) {
        super(world, x, y, z, exploder);
    }

    @SuppressWarnings("unused")
    public EntityNuclearTNT(World world) {
        super(world);
    }

    @Override
    protected float getStrength() {
        return 12;
    }

    @Override
    public boolean dropsAllBlocks() {
        return false;
    }

    @Override
    protected int getRange() {
        return 24;
    }

    @Override
    public  IBlockState getExplosiveState() {
        return GTQTMetaBlocks.STNT.getDefaultState();
    }
}