package keqing.gtqtcore.common.items.behaviors;

import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class CircuitPatternBehavior implements IItemBehaviour {

    @Override
    public void addInformation(ItemStack stack, List<String> lines) {
        if (stack.hasTagCompound()) {
            NBTTagCompound tagCompound = stack.getTagCompound();
            String circuitType = tagCompound.getString("circuit_pattern_type"); // 假设这是 CircuitAssemblyLineRecipeProducer.INFO_NBT_NAME 的值
            lines.add(I18n.format("metaitem.tool.circuit_pattern.type",
                    I18n.format("metaitem.tool.circuit_pattern.type." + circuitType)));
        } else {
            lines.add(I18n.format("metaitem.tool.circuit_pattern.type.empty"));
        }
    }
}
