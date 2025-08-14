package keqing.gtqtcore.api.recipes.builder;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import keqing.gtqtcore.api.recipes.properties.CircuitPatternProperty;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CircuitAssemblyLineRecipeBuilder extends RecipeBuilder<CircuitAssemblyLineRecipeBuilder> {

    public CircuitAssemblyLineRecipeBuilder() {
    }

    public CircuitAssemblyLineRecipeBuilder(Recipe recipe, RecipeMap<CircuitAssemblyLineRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public CircuitAssemblyLineRecipeBuilder(RecipeBuilder<CircuitAssemblyLineRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public CircuitAssemblyLineRecipeBuilder copy() {
        return new CircuitAssemblyLineRecipeBuilder(this);
    }

    public ItemStack getCircuit() {
        if (this.recipePropertyStorage == null) {
            return null;
        } else {
            return this.recipePropertyStorage.get(CircuitPatternProperty.getInstance(), null);
        }
    }

    @Override
    public boolean applyPropertyCT(String key, Object value) {
        if (key.equals(CircuitPatternProperty.getInstance().getKey())) {
            this.circuit((ItemStack) value);
            return true;
        }
        return super.applyPropertyCT(key, value);
    }

    public CircuitAssemblyLineRecipeBuilder circuit(ItemStack stack) {
        this.applyProperty(CircuitPatternProperty.getInstance(), stack);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(CircuitPatternProperty.getInstance().getKey(), this.getCircuit())
                .toString();
    }
}
