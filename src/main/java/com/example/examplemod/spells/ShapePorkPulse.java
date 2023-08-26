package com.example.examplemod.spells;

import java.util.Arrays;
import java.util.List;

import com.mna.api.spells.attributes.Attribute;
import com.mna.api.spells.attributes.AttributeValuePair;
import com.mna.api.spells.base.IModifiedSpellPart;
import com.mna.api.spells.base.ISpellDefinition;
import com.mna.api.spells.parts.Shape;
import com.mna.api.spells.targeting.SpellSource;
import com.mna.api.spells.targeting.SpellTarget;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ShapePorkPulse extends Shape {

	public ShapePorkPulse(ResourceLocation registryName, ResourceLocation guiIcon) {
		super(registryName, guiIcon, new AttributeValuePair[] {
			new AttributeValuePair(Attribute.RADIUS, 2, 1, 5, 1, 0.5f)
		});
	}

	@Override
	public int requiredXPForRote() {
		return 150; //number of valid casts required for rote
	}

	@Override
	public List<SpellTarget> Target(SpellSource source, Level world, IModifiedSpellPart<Shape> attributes, ISpellDefinition spell) {
		
		// It's technically possible for the source to not have a caster reference, so this should be checked for.
		if (!source.hasCasterReference()) {
			return Arrays.asList(SpellTarget.NONE);
		}
		
		// Retrieve radius
		float radius = attributes.getValue(Attribute.RADIUS);
		
		// Look for item entities on the ground that are pork chops within the radius of the caster
		return world.getEntities(source.getCaster(), source.getBoundingBox().inflate(radius), 
		(candidate) -> { // This is our filter.  Return true to include an entity in the list, return false to exclude it.
			return candidate.isAlive() && // we want entities that are not in the process of despawning for any reason 
					candidate instanceof ItemEntity &&  // then we want to only look at items on the ground
					((ItemEntity)candidate).getItem().getItem() == Items.PORKCHOP; // then those items must be a porkchop
		})
		.stream() // convert the results to a stream we can operate on
		.map(porkchopItem -> new SpellTarget(porkchopItem)) // map each entity to a SpellTarget object
		.toList(); // convert the stream to a list so it's valid for the return value of the function
		
	}

	@Override
	public float initialComplexity() {
		return 5; //baseline complexity for this part before any modifiers
	}

}
