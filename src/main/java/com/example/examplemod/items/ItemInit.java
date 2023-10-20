package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.factions.FactionRIDs;
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

    public static final RegistryObject<Item> EXAMPLE_MANA_GUI_BADGE = ITEMS.register("example_mana_gui_badge", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MARK_OF_EXAMPLE_FACTION = ITEMS.register("mark_of_example_faction", () -> new TieredItem((new Item.Properties()).tab(MAItemGroups.items)));
    public static final RegistryObject<Item> GRIMOIRE_EXAMPLE_FACTION = ITEMS.register("grimoire_example_faction", () -> new ItemSpellGrimoire(FactionRIDs.FACTION_EXAMPLE_ID, true));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
