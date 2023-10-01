package astra.amalgam.common.init;

import astra.amalgam.AstralAmalgam;
import astra.amalgam.common.item.EventCalendarItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static astra.amalgam.AstralAmalgam.MODID;

public class AstraItems {

	public static RegistryKey<ItemGroup> ITEMGROUP_KEY;
	public static ItemGroup AMALGAM_ITEMGROUP;

	public static Item EVENT_CROWN;
	public static Item EVENT_CALENDAR;
	public static Item SHIFTING_RUNE;

	// Add in 0.2.0
	// public static Item OCEAN_CROWN;
	// public static Item OCEAN_RUNE;

	public static void init() {

		ITEMGROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(AstralAmalgam.MODID, "item_group"));
		AMALGAM_ITEMGROUP = FabricItemGroup.builder()
				.icon(() -> new ItemStack(Items.CHORUS_FRUIT))
				.displayName(Text.translatable("astral_amalgam.itemgroup.name"))
				.build();
		Registry.register(Registries.ITEM_GROUP, ITEMGROUP_KEY, AMALGAM_ITEMGROUP);

		EVENT_CROWN = registerItem(
				new ArmorItem(ArmorMaterials.TURTLE, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)),
				"event_crown");
		EVENT_CALENDAR = registerItem(new EventCalendarItem(new FabricItemSettings().maxCount(1)),
				"event_calendar");
		SHIFTING_RUNE = registerItem(new Item(new FabricItemSettings()), "shifting_rune");
	}

	public static Item registerItem(Item item, String name) {
		Registry.register(Registries.ITEM, MODID + ":" + name, item);
		ItemGroupEvents.modifyEntriesEvent(ITEMGROUP_KEY).register(content -> {
			content.add(item);
		});
		return item;
	}
}
