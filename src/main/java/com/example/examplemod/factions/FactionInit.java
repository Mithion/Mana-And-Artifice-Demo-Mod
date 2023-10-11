package com.example.examplemod.factions;

import com.example.examplemod.ExampleMod;
import com.mna.api.faction.BaseFaction;
import com.mna.api.faction.IFaction;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FactionInit {
    public static final BaseFaction EXAMPLE_FACTION = new ExampleFaction();

    @SubscribeEvent
    public static void registerFactions(RegistryEvent.Register<IFaction> event) {
        event.getRegistry().register(EXAMPLE_FACTION);
    }
}
