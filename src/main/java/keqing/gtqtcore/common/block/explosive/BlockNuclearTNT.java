package keqing.gtqtcore.common.block.explosive;

import gregtech.common.blocks.explosive.BlockGTExplosive;
import gregtech.common.entities.EntityGTExplosive;
import keqing.gtqtcore.common.entities.explosive.EntityNuclearTNT;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class BlockNuclearTNT extends BlockGTExplosive {

    public BlockNuclearTNT() {
        super(Material.TNT, true, true, 40);
        setHardness(0);
        setSoundType(SoundType.PLANT);
    }

    @Override
    public EntityGTExplosive createEntity(World world, BlockPos pos, EntityLivingBase exploder) {
        float x = pos.getX() + 0.5f;
        float y = pos.getY();
        float z = pos.getZ() + 0.5f;
        return new EntityNuclearTNT(world, x, y, z, exploder);
    }


    @Override
    public void addInformation( ItemStack stack,  World world,  List<String> tooltip,
                                ITooltipFlag flag) {
        tooltip.add(I18n.format("tile.stnt.drops_tooltip"));
        super.addInformation(stack, world, tooltip, flag);
    }
}