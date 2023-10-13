package astra.amalgam.common.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

/*
    CARAMEL
	CANDY_SHELL
    HONEY_CANDY
    GLOW_BERRY_COOKIE
    SWEET_BERRY_COOKIE
    GLOW_BERRY_THORN
    SWEET_BERRY_THORN
    OBSIDIAN_JAWBREAKER;
    CRYING_OBSIDIAN_JAWBREAKER;
    CANDIED_PRISMARINE;
*/

public class AstraFoods {
	public static final FoodComponent CANDY_SHELL = new FoodComponent.Builder()
			.hunger(1).saturationModifier(.1f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 0), 1.0f)
			.build();

	public static final FoodComponent CARAMEL = new FoodComponent.Builder()
			.hunger(3).saturationModifier(.4f).alwaysEdible()
			.build();

	public static final FoodComponent HONEY_CANDY = new FoodComponent.Builder()
			.hunger(2).saturationModifier(.1f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), 1.0f)
			.build();

	public static final FoodComponent GLOW_BERRY_COOKIE = new FoodComponent.Builder()
			.hunger(4).saturationModifier(.2f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0), 1.0f)
			.build();

	public static final FoodComponent SWEET_BERRY_COOKIE = new FoodComponent.Builder()
			.hunger(4).saturationModifier(.2f).alwaysEdible()
			.build();

	public static final FoodComponent GLOW_BERRY_THORN = new FoodComponent.Builder()
			.hunger(1).saturationModifier(.1f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0), 1.0f)
			.build();

	public static final FoodComponent SWEET_BERRY_THORN = new FoodComponent.Builder()
			.hunger(1).saturationModifier(.1f).alwaysEdible()
			.build();

	public static final FoodComponent OBSIDIAN_JAWBREAKER = new FoodComponent.Builder()
			.hunger(6).saturationModifier(.3f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), .5f)
			.build();

	public static final FoodComponent CRYING_OBSIDIAN_JAWBREAKER = new FoodComponent.Builder()
			.hunger(6).saturationModifier(.3f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), .5f)
			.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 1), .5f)
			.build();

	public static final FoodComponent CARAMEL_APPLE = new FoodComponent.Builder()
			.hunger(8).saturationModifier(.75f)
			.statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 7, 0), 1.0f)
			.build();

	public static final FoodComponent CARAMEL_GOLDEN_APPLE = new FoodComponent.Builder()
			.hunger(8).saturationModifier(.75f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 7, 0), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0f)
			.build();

	public static final FoodComponent ENCHANTED_CARAMEL_GOLDEN_APPLE = new FoodComponent.Builder()
			.hunger(8).saturationModifier(1.2f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 7, 0), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f)
			.build();
}
