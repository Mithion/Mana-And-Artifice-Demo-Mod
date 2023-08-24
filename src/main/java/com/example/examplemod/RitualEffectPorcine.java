package com.example.examplemod;

import com.mna.api.rituals.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;


public class RitualEffectPorcine extends RitualEffect{

	public RitualEffectPorcine(ResourceLocation ritualName) {
		super(ritualName);
	}

	@Override
	protected boolean applyRitualEffect(IRitualContext context) {
		Pig pig = new Pig(EntityType.PIG, context.getWorld());
		pig.setPos(context.getCenter().getX(), context.getCenter().above().getY(), context.getCenter().getZ());
		context.getWorld().addFreshEntity(pig);
		
		return true;
	}
	
	@Override
	protected int getApplicationTicks(IRitualContext context) {
		return 10;
	}
}
