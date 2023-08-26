package com.example.examplemod.rituals;

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
		
		// It should be noted that this entire ritual effect could be replaced using the "command" parameter
		// on the ritual's recipe.  That parameter will simply attempt to execute the command at the ritual's center
		// on success.  For example, this could be replaced with "summon minecraft:pig ~ ~ ~" meaning no code is required
		// to achieve this effect.
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
