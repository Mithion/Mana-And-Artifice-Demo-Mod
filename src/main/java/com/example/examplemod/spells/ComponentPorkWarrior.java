package com.example.examplemod.spells;

import java.util.ArrayList;
import java.util.List;

import com.mna.api.ManaAndArtificeMod;
import com.mna.api.affinity.Affinity;
import com.mna.api.spells.ComponentApplicationResult;
import com.mna.api.spells.SpellReagent;
import com.mna.api.spells.attributes.Attribute;
import com.mna.api.spells.attributes.AttributeValuePair;
import com.mna.api.spells.base.IModifiedSpellPart;
import com.mna.api.spells.parts.SpellEffect;
import com.mna.api.spells.targeting.SpellContext;
import com.mna.api.spells.targeting.SpellSource;
import com.mna.api.spells.targeting.SpellTarget;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ComponentPorkWarrior extends SpellEffect {
	
	public static final ArrayList<SpellReagent> required_reagents = new ArrayList<SpellReagent>();
	
	static {
		required_reagents.add(new SpellReagent(new ItemStack(Items.COOKED_PORKCHOP), false, false, true));
	}

	public ComponentPorkWarrior(ResourceLocation registryName, ResourceLocation guiIcon) {
		super(registryName, guiIcon, new AttributeValuePair[] {
			new AttributeValuePair(Attribute.DURATION, 30, 10, 300, 10, 0.5f)
		});
	}

	@Override
	public int requiredXPForRote() {
		return 150;
	}

	@Override
	public ComponentApplicationResult ApplyEffect(SpellSource source, SpellTarget target, IModifiedSpellPart<SpellEffect> attributes, SpellContext context) {
		
		// First, let's make sure we are only targeting item entities of pork chops.
		if (!(target.getEntity() instanceof ItemEntity) || ((ItemEntity)target.getEntity()).getItem().getItem() != Items.PORKCHOP) {
			return ComponentApplicationResult.FAIL;
		}
		
		// Get the porkchop count
		int count = ((ItemEntity)target.getEntity()).getItem().getCount();
		
		// Let's have a little fun.
		// If the item entity has one pork chop, we are spawning a pig.
		// If two, we are spawning a zombie pigman
		// If three, we are spawning a piglin
		// If four, we are spawning a piglin brute
		// If five, we are spawning a hoglin
		
		EntityType<?> type = null;
		switch (count) {
		case 0: //probably not needed, but we include it just in case.
		case 1:
			type = EntityType.PIG;
			break;
		case 2:
			type = EntityType.ZOMBIFIED_PIGLIN;
			break;
		case 3:
			type = EntityType.PIGLIN;
			break;
		case 4:
			type = EntityType.PIGLIN_BRUTE;
			break;
		default:
			type = EntityType.HOGLIN;
			break;
		}
		
		Mob spawn = (Mob)type.create(context.getWorld()); //double check that all the EntityTypes inherit from Mob; these all do.
		if (spawn == null) {
			return ComponentApplicationResult.FAIL;
		}
		
		//move the spawn to the target's position
		spawn.setPos(target.getPosition());
		
		//remove the item
		target.getEntity().discard();
		
		//make the spawn a summon
		// this will override the mob's AI to make it act like a summon
		ManaAndArtificeMod.getSummonHelper().makeSummon(spawn, source.getCaster(), (int)attributes.getValue(Attribute.DURATION) * 20); //convert the duration into seconds by multiplying by 20 (ticks/second)
		
		//spawn it in the world!
		context.getWorld().addFreshEntity(spawn);
		
		//Set it so all further components target the summon
		target.overrideSpellTarget(spawn);
		
		return ComponentApplicationResult.SUCCESS;
	}

	@Override
	public Affinity getAffinity() {
		return Affinity.WATER;
	}
	
	@Override
	public List<SpellReagent> getRequiredReagents(Player caster, InteractionHand hand) {
		return required_reagents;
	}

	@Override
	public float initialComplexity() {
		return 10;
	}

}
