package com.example.examplemod.factions.castingresources;

import com.example.examplemod.factions.FactionRIDs;
import com.example.examplemod.items.ItemInit;
import com.mna.api.capabilities.resource.ICastingResourceGuiProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ExampleManaGui implements ICastingResourceGuiProvider {
    public ResourceLocation getTexture() {
        return FactionRIDs.FACTION_HUD_TEXTURE;
    }

    public ItemStack getBadgeItem() {
        return new ItemStack(ItemInit.EXAMPLE_MANA_GUI_BADGE.get());
    }

    public int getXPBarColor() {
        return 0xdaa520;
    }

    public int getBarColor() {
        return 0xdaa520;
    }

    public int getBarManaCostEstimateColor() {
        return 0xffd700;
    }

    public int getResourceNumericTextColor() {
        return 0xffd700;
    }

    public int getBadgeItemOffsetY() {
        return 10;
    }

    public int getBadgeSize() {
        return 64;
    }

    public int getFrameU() {
        return 0;
    }

    public int getFrameV() {
        return 0;
    }

    public int getFrameWidth() {
        return 153;
    }

    public int getFrameHeight() {
        return 24;
    }

    public int getLevelDisplayY() {
        return this.getFrameHeight() - 2;
    }
}
