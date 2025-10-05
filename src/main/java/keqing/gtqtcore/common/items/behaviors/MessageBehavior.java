package keqing.gtqtcore.common.items.behaviors;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.AdvancedTextWidget;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.ScrollableListWidget;
import gregtech.api.items.gui.ItemUIFactory;
import gregtech.api.items.gui.PlayerInventoryHolder;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import keqing.gtqtcore.GTQTCore;
import keqing.gtqtcore.common.textResource.GTQTTextManager;
import keqing.gtqtcore.common.textResource.TextType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageBehavior implements IItemBehaviour, ItemUIFactory {
    private TextType currentTextType = TextType.LOG;


    public MessageBehavior() {
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!world.isRemote) {
            new PlayerInventoryHolder(player, hand).openUI();
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, heldItem);
    }

    @Override
    public ModularUI createUI(PlayerInventoryHolder playerInventoryHolder, EntityPlayer entityPlayer) {
        var scroll = new ScrollableListWidget(0, 16, 240, 220);
        scroll.addWidget((new AdvancedTextWidget(8, 4, this::addDisplayText, 16777215).setMaxWidthLimit(220)));

        ModularUI.Builder ui = ModularUI.builder(GuiTextures.BACKGROUND, 300, 240)
                .label(6, 6, "消息终端 " + getCurrentTime() + " 版本：" + GTQTCore.PACK + " 最后更新时间：" + GTQTCore.VERSION);
        ui.image(4, 16, 234, 220, GuiTextures.DISPLAY)
                .widget(scroll);

        // 创建文本类型切换按钮
        int buttonX = 240;
        int buttonY = 16;
        int buttonWidth = 56;
        int buttonHeight = 22;
        int buttonSpacing = 2;

        int index = 0;
        for (TextType textType : TextType.getDisplayableTypes()) {
            int currentY = buttonY + (buttonHeight + buttonSpacing) * index;

            ui.widget(new ClickButtonWidget(buttonX, currentY, buttonWidth, buttonHeight,
                    textType.getDisplayName(),
                    clickData -> {
                        // 切换当前文本类型
                        currentTextType = textType;
                        // 刷新显示
                        scroll.addWidget((new AdvancedTextWidget(8, 4, this::addDisplayText, 16777215).setMaxWidthLimit(220)));
                    })
                    .setTooltipText("切换到" + textType.getDisplayName() + "视图"));
            index++;
        }

        // 添加重载文本按钮
        ui.widget(new ClickButtonWidget(buttonX, 216, buttonWidth, 20, "重载文本",
                clickData -> {
                    GTQTTextManager.getInstance().reloadAll();
                    // 刷新显示
                    scroll.addWidget((new AdvancedTextWidget(8, 4, this::addDisplayText, 16777215).setMaxWidthLimit(220)));
                    entityPlayer.sendMessage(new TextComponentString("§a文本资源已重载"));
                })
                .setTooltipText("重新从文件加载所有文本内容"));

        return ui.build(playerInventoryHolder, entityPlayer);
    }

    private void addDisplayText(List<ITextComponent> iTextComponents) {
        // 显示当前选择的文本类型
        iTextComponents.add(new TextComponentString("§6当前查看: §e" + currentTextType.getDisplayName()));
        iTextComponents.add(new TextComponentString(""));

        // 根据类型显示内容
        String content = GTQTTextManager.getText(currentTextType, "暂无内容");
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                iTextComponents.add(new TextComponentString(line.trim()));
            }
        }
    }

    private String getCurrentTime() {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return now.format(formatter);
        } catch (Exception e) {
            return "时间获取失败";
        }
    }
}
