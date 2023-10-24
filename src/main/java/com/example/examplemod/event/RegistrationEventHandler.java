package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.factions.FactionRIDs;
import com.example.examplemod.factions.castingresources.ExampleMana;
import com.example.examplemod.factions.castingresources.ExampleManaGui;
import com.mna.api.events.CastingResourceGuiRegistrationEvent;
import com.mna.api.events.CastingResourceRegistrationEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class RegistrationEventHandler {
    @Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class RegistrationEventHandlerClient {
        @SubscribeEvent
        public static void onCastingResourceRegistrationEvent(CastingResourceGuiRegistrationEvent event){
            event.getRegistry().registerResourceGui(FactionRIDs.EXAMPLE_MANA, new ExampleManaGui());
        }
    }

    @Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class RegistrationEventHandlerCommon {
        @SubscribeEvent
        public static void onCastingResourceRegistrationEvent(CastingResourceRegistrationEvent event){
            event.getRegistry().register(FactionRIDs.EXAMPLE_MANA, ExampleMana.class);
        }
    }
}
