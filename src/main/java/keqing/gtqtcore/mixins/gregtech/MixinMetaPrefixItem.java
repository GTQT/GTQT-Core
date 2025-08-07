package keqing.gtqtcore.mixins.gregtech;

import gregtech.api.damagesources.DamageSources;
import gregtech.api.items.materialitem.MetaPrefixItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.core.sound.GTSoundEvents;
import it.unimi.dsi.fastutil.shorts.ShortIterator;
import keqing.gtqtcore.GTQTCoreConfig;
import keqing.gtqtcore.api.items.IItemRenderer;
import keqing.gtqtcore.api.items.IItemRendererManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static gregtech.api.items.materialitem.MetaPrefixItem.purifyMap;

@Mixin(value = MetaPrefixItem.class, remap = false)
public abstract class MixinMetaPrefixItem extends StandardMetaItem {
    @Final
    @Shadow
    private OrePrefix prefix;

    @SuppressWarnings("rawtypes")
    @Inject(
            method = "registerModels()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/block/model/ModelBakery;registerItemVariants(Lnet/minecraft/item/Item;[Lnet/minecraft/util/ResourceLocation;)V",
                    ordinal = 0
            ),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void registerModels(CallbackInfo ci,
                                Map alreadyRegistered,
                                ShortIterator var2,
                                short metaItem,
                                MaterialIconSet materialIconSet,
                                short registrationKey,
                                ResourceLocation resourceLocation) {
        if (materialIconSet instanceof IItemRendererManager rendererManager) {
            rendererManager.onRendererRegistry(resourceLocation);
            metaItems.get(metaItem).addComponents(((IItemRenderer) materialIconSet).getRendererManager());
        }
    }
}
