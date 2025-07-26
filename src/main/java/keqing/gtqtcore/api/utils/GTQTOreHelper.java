package keqing.gtqtcore.api.utils;

import keqing.gtqtcore.common.items.GTQTMetaItems;
import net.minecraft.item.ItemStack;

public class GTQTOreHelper {
    public static String getInfo(int dimension, int type) {
        // 交错
        if (dimension == 41) {
            if (type == 1) return "岩石种类：地下世界 地幔捕虏岩";
            if (type == 2) return "岩石种类：地下世界 火山角砾岩";
            if (type == 3) return "岩石种类：地下世界 高压相变岩";
            if (type == 4) return "岩石种类：地下世界 深熔岩";
        }
        // 主世界
        if (dimension == 0) {
            if (type == 1) return "岩石种类：主世界 变质岩";
            if (type == 2) return "岩石种类：主世界 沉积岩";
            if (type == 3) return "岩石种类：主世界 冲击岩";
            if (type == 4) return "岩石种类：主世界 热液岩";
        }
        // 地狱
        if (dimension == -1) {
            if (type == 1) return "岩石种类：地狱 岩浆冲击岩";
            if (type == 2) return "岩石种类：地狱 岩浆沉积岩";
            if (type == 3) return "岩石种类：地狱 岩浆侵入岩";
            if (type == 4) return "岩石种类：地狱 岩浆变质岩";
        }

        return "null";
    }

    public static ItemStack setOre(int dimension, int type) {
        if (dimension == -1) {
            if (type == 1) return new ItemStack(GTQTMetaItems.DIAPHRAGMATIC.getMetaItem(), 1, 185);
            if (type == 2) return new ItemStack(GTQTMetaItems.ORTHOSTATIC.getMetaItem(), 1, 186);
            if (type == 3) return new ItemStack(GTQTMetaItems.METAMORPHIC.getMetaItem(), 1, 187);
            if (type == 4) return new ItemStack(GTQTMetaItems.DIABLANK.getMetaItem(), 1, 188);
        }

        if (dimension == 0) {
            if (type == 1) return new ItemStack(GTQTMetaItems.BLANK.getMetaItem(), 1, 181);
            if (type == 2) return new ItemStack(GTQTMetaItems.HYDROTHERMAL.getMetaItem(), 1, 182);
            if (type == 3) return new ItemStack(GTQTMetaItems.MAGMATIC_HYDROTHERMAL.getMetaItem(), 1, 183);
            if (type == 4) return new ItemStack(GTQTMetaItems.ALLUVIAL.getMetaItem(), 1, 184);
        }


        if (dimension == 41) {
            if (type == 1) return new ItemStack(GTQTMetaItems.MANTLE_XENOLITH.getMetaItem(), 1, 196);
            if (type == 2) return new ItemStack(GTQTMetaItems.VOLCANIC_BRECCIA.getMetaItem(), 1, 197);
            if (type == 3) return new ItemStack(GTQTMetaItems.HIGH_PRESSURE.getMetaItem(), 1, 198);
            if (type == 4) return new ItemStack(GTQTMetaItems.ANATECTIC.getMetaItem(), 1, 199);
        }

        return ItemStack.EMPTY;
    }
}
