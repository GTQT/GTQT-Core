package keqing.gtqtcore.common.items.behaviors;

import gregtech.api.items.metaitem.stats.IDataItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;
import java.util.List;

public class DataItemBehavior implements IItemBehaviour, IDataItem {

    private final boolean requireDataBank;

    public DataItemBehavior() {
        this.requireDataBank = false;
    }

    public DataItemBehavior(boolean requireDataBank) {
        this.requireDataBank = requireDataBank;
    }

    @Override
    public boolean requireDataBank() {
        return requireDataBank;
    }

    @Override
    public void addInformation(@Nonnull ItemStack itemStack, List<String> lines) {

        NBTTagCompound compound = itemStack.getTagCompound();
        String name = "空";
        if (compound != null) name = compound.getString("Name");
        lines.add(I18n.format("behavior.data_item.cd_rom.title"));
        lines.add(I18n.format("behavior.data_item.cd_rom.data", name));

    }
}
