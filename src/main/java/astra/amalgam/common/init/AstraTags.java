package astra.amalgam.common.init;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static astra.amalgam.AstralAmalgam.MODID;

public class AstraTags {
	public static TagKey<Item> GLIDING_ARMOR;
	public static TagKey<Item> SOARING_ARMOR;

	public static void init() {
		GLIDING_ARMOR = TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "gliding_armor"));
        SOARING_ARMOR = TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "soaring_armor"));
	}
}
