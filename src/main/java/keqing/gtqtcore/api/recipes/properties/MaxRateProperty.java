package keqing.gtqtcore.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;

import javax.annotation.Nonnull;

public class MaxRateProperty extends RecipeProperty<Integer> {
    public static final String KEY = "max_rate";

    private static MaxRateProperty INSTANCE;

    private MaxRateProperty() {
        super("max_rate", Integer.class);
    }

    public static MaxRateProperty getInstance() {
        if (INSTANCE == null)
            INSTANCE = new MaxRateProperty();
        return INSTANCE;
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gtqtcore.recipe.max_rate", castValue(value)), x, y, color);
    }
    @Override
    public NBTBase serialize(Object value) {
        return new NBTTagInt(castValue(value));
    }

    @Override
    public Object deserialize( NBTBase nbt) {
        return ((NBTTagInt) nbt).getInt();
    }
}
