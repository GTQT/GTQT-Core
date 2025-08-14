package keqing.gtqtcore.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class CircuitPatternProperty extends RecipeProperty<ItemStack> {
    public static final String KEY = "circuit";
    private static CircuitPatternProperty INSTANCE;
    private final Set<ItemStack> registeredCircuits = new HashSet<>();

    private CircuitPatternProperty() {
        super(KEY, ItemStack.class);
    }

    public static CircuitPatternProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CircuitPatternProperty();
        }
        return INSTANCE;
    }

    @Override
    public @NotNull NBTBase serialize(@NotNull Object value) {
        if (!(value instanceof ItemStack stack)) {
            return null;
        }
        NBTTagCompound nbt = new NBTTagCompound();
        stack.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public @NotNull Object deserialize(@NotNull NBTBase nbt) {
        if (!(nbt instanceof NBTTagCompound compound)) {
            return null;
        }
        return new ItemStack(compound);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void drawInfo(Minecraft mc, int x, int y, int color, Object value) {
        mc.fontRenderer.drawString(
                I18n.format("需要电路模板信息", ((ItemStack) value).getDisplayName()),
                x,
                y,
                color
        );
    }

    public void registerCircuit(ItemStack stack) {
        registeredCircuits.add(stack);
    }
}
