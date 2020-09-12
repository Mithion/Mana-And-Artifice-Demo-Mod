package com.example.examplemod;

import com.ma.api.recipes.IRitualRecipe;
import com.ma.api.rituals.RitualEffect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class RitualEffectPorcine extends RitualEffect{

	public RitualEffectPorcine(ResourceLocation ritualName) {
		super(ritualName);
	}

	@Override
	protected boolean applyRitualEffect(PlayerEntity caster, ServerWorld world, BlockPos ritualCenter, IRitualRecipe recipe, NonNullList<ItemStack> reagents) {
		PigEntity pig = new PigEntity(EntityType.PIG, world);
		pig.setPositionAndRotation(ritualCenter.getX(), ritualCenter.up().getY(), ritualCenter.getZ(), 0, 0);
		world.addEntity(pig);
		
		return true;
	}

	@Override
	protected int getApplicationTicks(ServerWorld arg0, BlockPos arg1, IRitualRecipe arg2, NonNullList<ItemStack> arg3) {
		return 10;
	}

}
