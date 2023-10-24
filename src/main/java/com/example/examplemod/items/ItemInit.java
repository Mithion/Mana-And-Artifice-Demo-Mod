package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import com.mna.api.items.MAItemGroups;
import com.mna.api.items.TieredItem;
//import com.mna.items.sorcery.ItemSpellGrimoire;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> MARK_OF_THE_EXAMPLE_FACTION = ITEMS.register("mark_of_the_example_faction", () -> new TieredItem((new Item.Properties()).tab(MAItemGroups.items)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
