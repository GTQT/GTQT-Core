package keqing.gtqtcore.api.recipes.properties;
import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;

public class LaserNetProperty extends RecipeProperty<Integer> {

    public static final String KEY = "laser_tier";

    private static LaserNetProperty INSTANCE;

    private LaserNetProperty() {
        super(KEY, Integer.class);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("紫外发射器等级：%s",
                castValue(value)), x, y, color);
    }

    public static LaserNetProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LaserNetProperty();
        }
        return INSTANCE;
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
