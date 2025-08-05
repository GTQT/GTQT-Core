package keqing.gtqtcore.common.items.behaviors;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
public class TravelStickBehavior implements IItemBehaviour {
    private static final long VOLTAGE_FACTOR = 16L;
    int tier;
    boolean blockMode;

    public TravelStickBehavior(int tier) {
        this.tier = tier;
    }

    private static boolean drainEnergy(@NotNull ItemStack stack, long amount, boolean simulate) {
        IElectricItem electricItem = stack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
        if (electricItem == null) return false;

        return electricItem.discharge(amount, Integer.MAX_VALUE, true, false, simulate) >= amount;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!world.isRemote) {
            if(player.isSneaking()){
                blockMode = !blockMode;
                // 发送模式切换消息
                String mode = blockMode ? "阻挡模式" : "穿透模式";
                player.sendMessage(new TextComponentTranslation(mode));
            } else {
                if (checkCanUseTrans(heldItem, player, false)) {
                    Vec3d endPos = getVec3d(player, world); // 需要传入world进行射线检测

                    // 在blockMode开启时进行碰撞检测
                    if (blockMode) {
                        RayTraceResult result = world.rayTraceBlocks(
                                new Vec3d(player.posX, player.posY + player.getEyeHeight(), player.posZ), // 从眼睛位置开始
                                endPos,
                                false, true, false
                        );

                        // 如果检测到碰撞，使用碰撞点作为传送终点（稍微回退避免卡墙）
                        if (result != null && result.typeOfHit == RayTraceResult.Type.BLOCK) {
                            endPos = result.hitVec.subtract(player.getLookVec().scale(0.2));
                        }
                    }

                    // 消耗能量并传送
                    checkCanUseTrans(heldItem, player, true);
                    player.setPositionAndUpdate(endPos.x, endPos.y, endPos.z);

                    // 传送粒子效果
                    world.playSound(null, player.prevPosX, player.prevPosY, player.prevPosZ,
                            SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                } else {
                    player.sendMessage(new TextComponentTranslation("behavior.prospector.not_enough_energy"));
                }
            }
        }
        return this.pass(player.getHeldItem(hand));
    }

    // 添加world参数用于射线检测
    private @NotNull Vec3d getVec3d(EntityPlayer player, World world) {
        double distance = tier * 16.0;
        Vec3d lookVec = player.getLookVec();
        Vec3d startPos = new Vec3d(player.posX, player.posY, player.posZ);
        return startPos.add(
                lookVec.x * distance,
                lookVec.y * distance,
                lookVec.z * distance
        );
    }

    private boolean checkCanUseTrans(ItemStack stack, @NotNull EntityPlayer player, boolean simulate) {
        return player.isCreative() || drainEnergy(stack, GTValues.V[tier] / VOLTAGE_FACTOR, simulate);
    }
}