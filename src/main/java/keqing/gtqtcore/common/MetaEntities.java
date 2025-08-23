package keqing.gtqtcore.common;

import gregtech.api.GregTechAPI;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.handler.GTExplosiveRenderer;
import keqing.gtqtcore.GTQTCore;
import keqing.gtqtcore.common.entities.explosive.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetaEntities {

    public static void init() {

        EntityRegistry.registerModEntity(GTUtility.gregtechId("stnt"), EntityNuclearTNT.class, "STNT", 1,
                GregTechAPI.instance, 64, 3, true);

        EntityRegistry.registerModEntity(new ResourceLocation(GTQTCore.MODID, "naquadria_charge"),
                EntityNaquadriaCharge.class, "NaquadriaCharge", 2,
                GTQTCore.instance, 64, 3, true);

        EntityRegistry.registerModEntity(new ResourceLocation(GTQTCore.MODID, "taranium_charge"),
                EntityTaraniumCharge.class, "TaraniumCharge", 3,
                GTQTCore.instance, 64, 3, true);

        EntityRegistry.registerModEntity(new ResourceLocation(GTQTCore.MODID, "leptonic_charge"),
                EntityLeptonicCharge.class, "LeptonicCharge", 4,
                GTQTCore.instance, 64, 3, true);

        EntityRegistry.registerModEntity(new ResourceLocation(GTQTCore.MODID, "quantum_chromodynamic_charge"),
                EntityQuantumChromodynamicCharge.class, "QuantumChromodynamicCharge", 4,
                GTQTCore.instance, 64, 3, true);
    }

    @SideOnly(Side.CLIENT)
    public static void initRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityNuclearTNT.class, GTExplosiveRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(
                EntityNaquadriaCharge.class, GTExplosiveRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTaraniumCharge.class, GTExplosiveRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(
                EntityLeptonicCharge.class, GTExplosiveRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(
                EntityQuantumChromodynamicCharge.class, GTExplosiveRenderer::new);
    }
}