package astra.amalgam.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import astra.amalgam.common.init.AstraTags;
import astra.amalgam.common.item.AstraDamageTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class CrashDamageMixin extends Entity {

	@Shadow
	public abstract boolean isFallFlying();

	protected CrashDamageMixin(EntityType<? extends LivingEntity> type, World world) {
		super(type, world);
	}

	@Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo info) {
        this.dealCrashDamage();
    }

	private void dealCrashDamage() {
		if (!this.isFallFlying()) return;
		int glidingDamageMult = 0;
		for(ItemStack item: this.getArmorItems()) {
			if (item.isIn(AstraTags.GLIDING_ARMOR)) glidingDamageMult ++;
			if (item.isIn(AstraTags.SOARING_ARMOR)) glidingDamageMult += 2;
		}
		if (glidingDamageMult == 0) return;
		List<LivingEntity> collidingEntities = this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox());
		Vec3d vel = this.getVelocity();
		double magnitude = Math.sqrt(Math.abs(vel.getX() * vel.getX()) + Math.abs(vel.getY() * vel.getY()) + Math.abs(vel.getZ() + vel.getZ()));
		for (LivingEntity entity: collidingEntities) {
			if (this.equals(entity)) continue;
			if (Double.isNaN(magnitude)) magnitude = 1.0;
			entity.damage(AstraDamageTypes.of(this.getWorld(), AstraDamageTypes.CRASH_DAMAGE_TYPE), (float)(glidingDamageMult * magnitude * 2));
			if (Float.isNaN(entity.getHealth())) entity.kill();
		}
	}
}
