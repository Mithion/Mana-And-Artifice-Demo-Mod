package com.example.examplemod;

import com.mna.api.rituals.IRitualContext;
import com.mna.api.rituals.RitualEffect;

import net.minecraft.core.BlockPos;
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
		BlockPos ritualCenter = context.getCenter();
		pig.setPos(ritualCenter.getX(), ritualCenter.above().getY(), ritualCenter.getZ());
		pig.setXRot(0);
		pig.setYRot(0);
		context.getWorld().addFreshEntity(pig);

		return true;
	}

	@Override
	protected int getApplicationTicks(IRitualContext context) {
		return 10;
	}
}
