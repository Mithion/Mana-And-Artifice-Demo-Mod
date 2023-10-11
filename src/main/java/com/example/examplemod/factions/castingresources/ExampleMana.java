package com.example.examplemod.factions.castingresources;

import com.example.examplemod.factions.FactionRIDs;
import com.mna.api.capabilities.resource.SimpleCastingResource;
import com.mna.config.GeneralModConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;

public class ExampleMana extends SimpleCastingResource {
    public ExampleMana() {
        super(GeneralModConfig.MANA_TICKS_FOR_REGEN.get());
    }

    public int getRegenerationRate(LivingEntity caster) {
        return (int)((float) GeneralModConfig.MANA_TICKS_FOR_REGEN.get() * this.getRegenerationModifier(caster));
    }

    public ResourceLocation getRegistryName() {
        return FactionRIDs.EXAMPLE_MANA;
    }

    public void setMaxAmountByLevel(int level) {
        this.setMaxAmount((float)(100 + 20 * level));
    }
}
