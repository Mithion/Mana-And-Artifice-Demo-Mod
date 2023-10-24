package com.example.examplemod.factions.castingresources;

import com.example.examplemod.factions.FactionRIDs;
import com.mna.api.capabilities.resource.SimpleCastingResource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;

public class ExampleMana extends SimpleCastingResource {
    public ExampleMana() {
        //The number should be defined by the config
        super(2400);
    }

    public int getRegenerationRate(LivingEntity caster) {
        //The number should be defined by the config
        return (int)((float) 2400 * this.getRegenerationModifier(caster));
    }

    public ResourceLocation getRegistryName() {
        return FactionRIDs.EXAMPLE_MANA;
    }

    public void setMaxAmountByLevel(int level) {
        this.setMaxAmount((float)(100 + 20 * level));
    }
}
