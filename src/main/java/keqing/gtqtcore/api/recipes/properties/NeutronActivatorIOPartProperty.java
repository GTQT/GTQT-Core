package keqing.gtqtcore.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class NeutronActivatorIOPartProperty extends RecipeProperty<Integer> {

    public static final String KEY = "NeutronActivatorIOPart";

    private static final TreeMap<Integer, String> registeredPart = new TreeMap<>();
    private static NeutronActivatorIOPartProperty INSTANCE;

    private NeutronActivatorIOPartProperty() {
        super(KEY, Integer.class);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("粒子种类：",
                castValue(value).toString()) + getPart(castValue(value)), x, y, color);
    }

    public static NeutronActivatorIOPartProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NeutronActivatorIOPartProperty();
        }
        return INSTANCE;
    }

    private static String getPart(Integer Part) {
        Map.Entry<Integer, String> mapEntry = registeredPart.ceilingEntry(Part);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Tier is above registered maximum Casing Tier.");
        }

        return String.format("%s", mapEntry.getValue());
    }

    public static void registeredPart(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredPart.put(tier, shortName);
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
