package keqing.gtqtcore.api.utils;

import appeng.api.AEApi;
import appeng.api.config.SecurityPermissions;
import appeng.api.features.ILocatable;
import appeng.api.features.IWirelessTermHandler;
import appeng.api.features.IWirelessTermRegistry;
import appeng.api.networking.IGrid;
import appeng.api.networking.IGridNode;
import appeng.api.networking.security.ISecurityGrid;
import appeng.api.networking.storage.IStorageGrid;
import appeng.api.storage.channels.IItemStorageChannel;
import appeng.api.storage.data.IAEItemStack;
import appeng.container.implementations.ContainerCraftAmount;
import appeng.core.localization.PlayerMessages;
import appeng.core.sync.GuiBridge;
import appeng.core.sync.network.NetworkHandler;
import appeng.core.sync.packets.PacketCraftRequest;
import appeng.helpers.WirelessTerminalGuiObject;
import appeng.tile.misc.TileSecurityStation;
import appeng.util.Platform;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.util.Iterator;

public class CraftingHandler {

    public static void openWirelessCraft(EntityPlayer player, ItemStack exItem, IGridNode gridNode, int i, boolean isBauble) {
        IGrid grid = gridNode.getGrid();
        if (securityCheck(player, grid, SecurityPermissions.CRAFT)) {
            IStorageGrid storageGrid = grid.getCache(IStorageGrid.class);
            var iItemStorageChannel = storageGrid.getInventory(AEApi.instance().storage().getStorageChannel(IItemStorageChannel.class));

            Iterator<IAEItemStack> iterator = iItemStorageChannel.getStorageList().iterator();
            boolean isCraftable = false;
            IAEItemStack aeItem = null;
            while (iterator.hasNext()) {
                aeItem = iterator.next();
                if (aeItem.isCraftable()) {
                    if (aeItem.equals(exItem)) {
                        aeItem = aeItem.copy().setStackSize(1);
                        isCraftable = true;
                        break;
                    }
                }
            }

            if (!isCraftable) {
                player.sendMessage(new TextComponentTranslation("非法合成"));
                return;
            }

            Platform.openGUI(player, i, GuiBridge.GUI_CRAFTING_AMOUNT, isBauble);

            Container container = player.openContainer;
            if (container instanceof ContainerCraftAmount cca) {
                cca.getCraftingItem().putStack(aeItem.asItemStackRepresentation());
                cca.setItemToCraft(aeItem);
                cca.detectAndSendChanges();
                player.sendMessage(new TextComponentTranslation("------------------"));
                player.sendMessage(new TextComponentTranslation("正在处理下单任务："+ exItem.getDisplayName()+" * "+aeItem.getStackSize()).setStyle(new Style().setColor(TextFormatting.GREEN)));
                NetworkHandler.instance().sendToServer(new PacketCraftRequest(exItem.getCount(), true));
                player.sendMessage(new TextComponentTranslation("成功下单，请等待请求完毕后再次构建，自动跳过当前方块放置！").setStyle(new Style().setColor(TextFormatting.GREEN)));
                player.sendMessage(new TextComponentTranslation("------------------"));
            }
        }
    }

    private static boolean securityCheck(final EntityPlayer player, IGrid gridNode, final SecurityPermissions requiredPermission) {
        final ISecurityGrid sg = gridNode.getCache(ISecurityGrid.class);
        return sg.hasPermission(player, requiredPermission);
    }


    // 获取终端GUI对象
    private static WirelessTerminalGuiObject getTerminalGuiObject(ItemStack item, EntityPlayer player, int slotIndex) {
        if (Platform.isClient()) return null;

        IWirelessTermRegistry registry = AEApi.instance().registries().wireless();
        if (!registry.isWirelessTerminal(item)) {
            return null;
        }

        IWirelessTermHandler handler = registry.getWirelessTerminalHandler(item);
        String encryptionKey = handler.getEncryptionKey(item);
        if (encryptionKey.isEmpty()) {
            return null;
        }

        try {
            long key = Long.parseLong(encryptionKey);
            ILocatable securityStation = AEApi.instance().registries().locatable().getLocatableBy(key);
            if (!(securityStation instanceof TileSecurityStation)) {
                return null;
            }

            if (!handler.hasPower(player, 1000F, item)) {
                return null;
            }

            return new WirelessTerminalGuiObject(handler, item, player, player.world, slotIndex, 0, 0);
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public static IStorageGrid getStorage(EntityPlayer player) {
        IGrid gridNode = getGridNode(player).getGrid();
        return gridNode.getCache(IStorageGrid.class);
    }

    public static int getSlot(EntityPlayer player) {
        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            ItemStack ii = player.inventory.getStackInSlot(i);

            IWirelessTermRegistry registry = AEApi.instance().registries().wireless();
            if (registry.isWirelessTerminal(ii)) {
                return i;
            }
        }
        return -1;
    }

    public static IGridNode getGridNode(EntityPlayer player) {
        int i = getSlot(player);
        if (i == -1) {
            return null;
        }
        ItemStack ii = player.inventory.getStackInSlot(i);
        if (ii.isEmpty()) {
            return null;
        }
        WirelessTerminalGuiObject obj = getTerminalGuiObject(ii, player, i);
        if (obj == null || !obj.rangeCheck()) {
            player.sendMessage(PlayerMessages.OutOfRange.get());
            return null;
        }
        return obj.getActionableNode();
    }

    public static IGridNode getGridNode(EntityPlayer player, int i) {
        if (i < 0 || i >= player.inventory.getSizeInventory()) {
            return null;
        }
        ItemStack ii = player.inventory.getStackInSlot(i);
        if (ii.isEmpty()) {
            return null;
        }
        WirelessTerminalGuiObject obj = getTerminalGuiObject(ii, player, i);
        if (obj == null || !obj.rangeCheck()) {
            player.sendMessage(PlayerMessages.OutOfRange.get());
            return null;
        }
        return obj.getActionableNode();
    }

}