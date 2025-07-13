package keqing.gtqtcore.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;

public class GrindBallTierProperty extends RecipeProperty<Integer> {
    public static final String KEY = "grindball_tier";
    private static GrindBallTierProperty INSTANCE;
    private GrindBallTierProperty() {
        super(KEY, Integer.class);
    }

    public static GrindBallTierProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GrindBallTierProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(getGrindBallTier(castValue(value)), x, y, color);
    }

    private static String getGrindBallTier(int grind_ball_tier) {
        if (grind_ball_tier == 1) {
            return I18n.format("gtqtcore.recipe.grind_ball_soapstone") ;
        }else {
            return I18n.format("gtqtcore.recipe.grind_ball_aluminium");
        }
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