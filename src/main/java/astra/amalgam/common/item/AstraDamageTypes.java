package astra.amalgam.common.item;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import static astra.amalgam.AstralAmalgam.MODID;

public class AstraDamageTypes {
	public static RegistryKey<DamageType> CRASH_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
			new Identifier(MODID, "crash_damage_type"));

	public static DamageSource of(World world, RegistryKey<DamageType> key) {
		return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
	}
}
