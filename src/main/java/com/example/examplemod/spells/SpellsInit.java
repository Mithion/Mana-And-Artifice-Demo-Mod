package com.example.examplemod.spells;

import com.example.examplemod.ExampleMod;
import com.mna.api.spells.parts.Shape;
import com.mna.api.spells.parts.SpellEffect;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, modid = ExampleMod.MODID)
public class SpellsInit {
	@SubscribeEvent
	public static void onShapesRegistering(RegistryEvent.Register<Shape> event) {
		event.getRegistry().register(new ShapePorkPulse(new ResourceLocation(ExampleMod.MODID, "pork_pulse"), new ResourceLocation(ExampleMod.MODID, "textures/pork_pulse.png")));
	}
	
	@SubscribeEvent
	public static void onComponentsRegistering(RegistryEvent.Register<SpellEffect> event) {
		event.getRegistry().register(new ComponentPorkWarrior(new ResourceLocation(ExampleMod.MODID, "pork_warrior"), new ResourceLocation(ExampleMod.MODID, "textures/pork_warrior.png")));
	}
}
