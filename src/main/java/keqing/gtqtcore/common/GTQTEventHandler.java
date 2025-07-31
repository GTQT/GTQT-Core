package keqing.gtqtcore.common;

import com.google.common.collect.Lists;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.registry.MTEManager;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.event.MaterialRegistryEvent;
import gregtech.api.util.Mods;
import gregtech.common.ConfigHolder;
import keqing.gtqtcore.GTQTCore;
import keqing.gtqtcore.GTQTCoreConfig;
import keqing.gtqtcore.api.unification.GTQTMaterials;
import keqing.gtqtcore.api.unification.OrePrefixAdditions;
import keqing.gtqtcore.api.unification.ore.GTQTStoneTypes;
import keqing.gtqtcore.api.utils.GTQTLog;
import keqing.gtqtcore.loaders.recipes.handlers.OreRecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ArrayList;
import java.util.Objects;

import static keqing.gtqtcore.GTQTCore.PACK;
import static keqing.gtqtcore.GTQTCore.VERSION;
import static net.minecraft.util.text.TextFormatting.*;


@Mod.EventBusSubscriber(
        modid = "gtqtcore"
)

public class GTQTEventHandler {

    public GTQTEventHandler() {
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMTERegistry(MTEManager.MTERegistryEvent event) {
        GregTechAPI.mteManager.createRegistry(GTQTCore.MODID);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void createMaterialRegistry(MaterialRegistryEvent event) {
        GregTechAPI.materialManager.createRegistry(GTQTCore.MODID);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(MaterialEvent event) {
        GTQTMaterials.register();
        OrePrefixAdditions.init();
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        GTQTStoneTypes.init();
    }

    @SubscribeEvent
    public static void registerRecipeHandlers(RegistryEvent.Register<IRecipe> event) {
        GTQTLog.logger.info("Registering recipe handlers...");
        OreRecipeHandler.register();
    }

    public static class PlayerLoginEventHandler {

        private static final String[] lines = {
                GOLD + "============================================",
                BOLD + "Welcome to GregTech QuantumTransition " + GREEN + PACK + LIGHT_PURPLE + "-" + VERSION,
                GRAY + "The current game is" + RED + " beta version",
                GRAY + "All content in this version is for preview only and does not guarantee that the game can be played according to the normal survival mode process.",
                GRAY + "communication Group:" + YELLOW + " 1073091808" + GRAY + " (QQ Group)",
                GRAY + "Community Link:" + GREEN + " https://www.mcmod.cn/modpack/590.html ",
                GRAY + "Github channel:" + GREEN + " https://github.com/GTQT ",
                GRAY + "Wiki Link:" + GREEN + " https://docs.qq.com/aio/DRFhDRXZ5dnV0ZEtu ",
                GRAY + "Curseforge Link:" + GREEN + " https://www.curseforge.com/minecraft/modpacks/gregtech-quantum-transition ",
                GOLD + "============================================"
        };
        private static final String[] installOpt = {
                RED + "--------------------------------------------",
                RED + "！如果你还未安装Optifine，建议安装Optifine以获得更好的游戏体验！",
                RED + "！注意安装后开启智能动态材质或关闭视频设置-地形动画选项以提升帧数！",
                RED + "--------------------------------------------"
        };
        private static final String[] removeRecipe = {
                GREEN + "--------------------------------------------",
                GREEN + "！为并避免配方书检测卡顿，正在自动解锁所有配方！",
                GREEN + "--------------------------------------------"
        };
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
            if (ConfigHolder.misc.loginMessage) {
                Objects.requireNonNull(event.player);
                for (String line : lines)
                    event.player.sendMessage(new TextComponentString(line));
            }
            if (!Mods.Optifine.isModLoaded()) {
                Objects.requireNonNull(event.player);
                for (String line : installOpt)
                    event.player.sendMessage(new TextComponentString(line));
            }
            if (GTQTCoreConfig.miscSwitch.RecipesForAll) {
                if (event.player instanceof EntityPlayerMP) {
                    for (String line : removeRecipe)
                        event.player.sendMessage(new TextComponentString(line));
                    ArrayList<IRecipe> recipes = Lists.newArrayList(CraftingManager.REGISTRY);
                    recipes.removeIf((recipe) -> recipe.getRecipeOutput().isEmpty());
                    recipes.removeIf((recipe) -> recipe.getIngredients().isEmpty());
                    event.player.unlockRecipes(recipes);
                }
            }
        }
    }
}
