package astra.amalgam.common.init;

import astra.amalgam.AstralAmalgam;
import astra.amalgam.common.item.AstraArmorMaterials;
import astra.amalgam.common.item.AstraFoods;
import astra.amalgam.common.item.EventCalendarItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.EnchantedGoldenAppleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static astra.amalgam.AstralAmalgam.MODID;

public class AstraItems {

	public static RegistryKey<ItemGroup> ITEMGROUP_KEY;
	public static ItemGroup AMALGAM_ITEMGROUP;

	// Event stuff
	public static Item EVENT_CROWN;
	public static Item EVENT_CALENDAR;
	public static Item SHIFTING_RUNE;

	// Ocean stuff
	public static Item OCEAN_CROWN;
	public static Item OCEAN_RUNE;

	// Soaring sets
	public static Item GLIDING_HELMET;
	public static Item GLIDING_CHESTPLATE;
	public static Item GLIDING_LEGGINGS;
	public static Item GLIDING_BOOTS;
	public static Item CLOUD_RUNE;

	public static Item SOARING_CHESTPLATE;
	public static Item SOARING_CROWN;
	public static Item SOARING_LEGGINGS;
	public static Item SOARING_BOOTS;
	public static Item WINGED_INGOT;

	// Candy!!!
	public static Item CARAMEL;
	public static Item CANDY_SHELL;
	public static Item HONEY_CANDY;
	public static Item GLOW_BERRY_COOKIE;
	public static Item SWEET_BERRY_COOKIE;
	public static Item GLOW_BERRY_THORN;
	public static Item SWEET_BERRY_THORN;
	public static Item OBSIDIAN_JAWBREAKER;
	public static Item CRYING_OBSIDIAN_JAWBREAKER;
	public static Item CARAMEL_APPLE;
	public static Item GOLDEN_CARAMEL_APPLE;
	public static Item ENCHANTED_GOLDEN_CARAMEL_APPLE;

	public static void init() {

		ITEMGROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(AstralAmalgam.MODID, "item_group"));
		AMALGAM_ITEMGROUP = FabricItemGroup.builder()
				.icon(() -> new ItemStack(Items.CHORUS_FRUIT))
				.displayName(Text.translatable("astral_amalgam.itemgroup.name"))
				.build();
		Registry.register(Registries.ITEM_GROUP, ITEMGROUP_KEY, AMALGAM_ITEMGROUP);

		EVENT_CROWN = registerItem(
				new ArmorItem(AstraArmorMaterials.EVENT, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)),
				"event_crown");
		EVENT_CALENDAR = registerItem(new EventCalendarItem(new FabricItemSettings().maxCount(1)),
				"event_calendar");
		SHIFTING_RUNE = registerItem(new Item(new FabricItemSettings()), "shifting_rune");

		OCEAN_CROWN = registerItem(
				new ArmorItem(AstraArmorMaterials.OCEAN, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)),
				"ocean_crown");
		OCEAN_RUNE = registerItem(new Item(new FabricItemSettings()), "ocean_rune");

		GLIDING_HELMET = registerItem(
				new ArmorItem(AstraArmorMaterials.GLIDING, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)),
				"gliding_helmet");
		GLIDING_CHESTPLATE = registerItem(new ArmorItem(AstraArmorMaterials.GLIDING, ArmorItem.Type.CHESTPLATE,
				new FabricItemSettings().maxCount(1)), "gliding_chestplate");
		GLIDING_LEGGINGS = registerItem(new ArmorItem(AstraArmorMaterials.GLIDING, ArmorItem.Type.LEGGINGS,
				new FabricItemSettings().maxCount(1)), "gliding_leggings");
		GLIDING_BOOTS = registerItem(
				new ArmorItem(AstraArmorMaterials.GLIDING, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1)),
				"gliding_boots");
		CLOUD_RUNE = registerItem(new Item(new FabricItemSettings()), "cloud_rune");

		SOARING_CROWN = registerItem(new ArmorItem(AstraArmorMaterials.SOARING, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)),
				"soaring_crown");
		SOARING_CHESTPLATE = registerItem(new ArmorItem(AstraArmorMaterials.SOARING, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1)),
				"soaring_chestplate");
		SOARING_LEGGINGS = registerItem(new ArmorItem(AstraArmorMaterials.SOARING, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1)),
				"soaring_leggings");
		SOARING_BOOTS = registerItem(new ArmorItem(AstraArmorMaterials.SOARING, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1)),
				"soaring_boots");
		WINGED_INGOT = registerItem(new Item(new FabricItemSettings()), "winged_ingot");

		CARAMEL = registerItem(new Item(new FabricItemSettings().food(AstraFoods.CARAMEL)), "caramel");
		CANDY_SHELL = registerItem(new Item(new FabricItemSettings().food(AstraFoods.CANDY_SHELL)), "candy_shell");
		HONEY_CANDY = registerItem(new Item(new FabricItemSettings().food(AstraFoods.HONEY_CANDY)), "honey_candy");
		GLOW_BERRY_COOKIE = registerItem(new Item(new FabricItemSettings().food(AstraFoods.GLOW_BERRY_COOKIE)),
				"glow_berry_cookie");
		SWEET_BERRY_COOKIE = registerItem(new Item(new FabricItemSettings().food(AstraFoods.SWEET_BERRY_COOKIE)),
				"sweet_berry_cookie");
		GLOW_BERRY_THORN = registerItem(new Item(new FabricItemSettings().food(AstraFoods.GLOW_BERRY_THORN)),
				"glow_berry_thorn");
		SWEET_BERRY_THORN = registerItem(new Item(new FabricItemSettings().food(AstraFoods.SWEET_BERRY_THORN)),
				"sweet_berry_thorn");
		OBSIDIAN_JAWBREAKER = registerItem(new Item(new FabricItemSettings().food(AstraFoods.OBSIDIAN_JAWBREAKER)),
				"obsidian_jawbreaker");
		CRYING_OBSIDIAN_JAWBREAKER = registerItem(new Item(new FabricItemSettings().food(AstraFoods.CRYING_OBSIDIAN_JAWBREAKER)),
				"crying_obsidian_jawbreaker");
		CARAMEL_APPLE = registerItem(new Item(new FabricItemSettings().food(AstraFoods.CARAMEL_APPLE).maxCount(64)), "caramel_apple");
		GOLDEN_CARAMEL_APPLE = registerItem(new Item(new FabricItemSettings().food(AstraFoods.CARAMEL_GOLDEN_APPLE).maxCount(64)), "caramel_golden_apple");
		ENCHANTED_GOLDEN_CARAMEL_APPLE = registerItem(new EnchantedGoldenAppleItem(new FabricItemSettings().food(AstraFoods.ENCHANTED_CARAMEL_GOLDEN_APPLE).maxCount(64)), "enchanted_caramel_golden_apple");
	}

	public static Item registerItem(Item item, String name) {
		Registry.register(Registries.ITEM, MODID + ":" + name, item);
		ItemGroupEvents.modifyEntriesEvent(ITEMGROUP_KEY).register(content -> {
			content.add(item);
		});
		return item;
	}
}
