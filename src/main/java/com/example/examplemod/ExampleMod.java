package com.example.examplemod;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mna.api.guidebook.RegisterGuidebooksEvent;
import com.mna.api.rituals.RitualEffect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BuildConfig.MODID)
public class ExampleMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    private static final HashMap<String, ResourceLocation> resourceCache = new HashMap<>();

    public ExampleMod() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRegisterGuidebooks(RegisterGuidebooksEvent event) {
        LOGGER.warn("Register guidebook");
        ResourceLocation guidebook_rl = asResource("guide");
        event.getRegistry().addGuidebookPath(guidebook_rl);
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }

        @SubscribeEvent
        public static void onRitualsRegistry(final RegistryEvent.Register<RitualEffect> event) {
            ResourceLocation ritual_rl = asResource("rituals/porcine");
            ResourceLocation name_rl = asResource("porcine-ritual-effect");
            event.getRegistry().register(new RitualEffectPorcine(ritual_rl).setRegistryName(name_rl));
        }
    }

    public static ResourceLocation asResource(String pPath){
		return resourceCache.computeIfAbsent(pPath, k -> new ResourceLocation(BuildConfig.MODID, k));
	}
}
