package keqing.gtqtcore.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import org.apache.commons.lang3.tuple.Pair;

import java.util.TreeMap;

public class ScatteringProperty extends RecipeProperty<Integer> {
    public static final String KEY = "scattering";
    private static final TreeMap<Integer, Pair<Integer, String>> registeredFusionTiers = new TreeMap();
    private static ScatteringProperty INSTANCE;

    protected ScatteringProperty() {
        super("scattering", Integer.class);
    }

    public static ScatteringProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScatteringProperty();
        }

        return INSTANCE;
    }

    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("散射截面：%s", TextFormattingUtil.formatLongToCompactString(this.castValue(value))) , x, y, color);
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
