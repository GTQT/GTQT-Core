package keqing.gtqtcore.common.items.behaviors;

import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.common.blocks.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class FindOreStickBehavior implements IItemBehaviour {

    public FindOreStickBehavior() {
    }

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        if (world.isRemote) return EnumActionResult.SUCCESS;
        for (int h = Math.max(pos.getY(), 0); h >= 0; h--) {
            BlockPos currentPos = new BlockPos(pos.getX(), h, pos.getZ());
            Block block = world.getBlockState(currentPos).getBlock();

            if(block instanceof BlockOre ore){
                player.sendStatusMessage(new TextComponentTranslation("！发现矿物！"), true);
                player.sendMessage(new TextComponentString("==============================="));
                player.sendMessage(new TextComponentString("坐标 X：" + pos.getX() + " Y：" + pos.getY() + " Z：" + pos.getZ()));
                player.sendMessage(new TextComponentString("发现矿物："+ore.material.getLocalizedName()));
                player.sendMessage(new TextComponentString("==============================="));
                return EnumActionResult.SUCCESS;
            }

            if(h==0){
                player.sendStatusMessage(new TextComponentTranslation("！没有发现矿物"), true);
            }
        }

        return EnumActionResult.SUCCESS;
    }
}
