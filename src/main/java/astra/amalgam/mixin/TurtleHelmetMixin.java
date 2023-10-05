package astra.amalgam.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import astra.amalgam.common.init.AstraItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class TurtleHelmetMixin extends LivingEntity {
    @Shadow
    @Final
    private PlayerAbilities abilities;

    protected TurtleHelmetMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void tick(CallbackInfo info) {
        this.updateOceanCrown();
    }

    private void updateOceanCrown() {
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.HEAD);
        if (itemStack.isOf(AstraItems.OCEAN_CROWN)) {
            if ((!this.isSubmergedIn(FluidTags.WATER) && (!this.canBreatheInWater()))
                    || (this.isSubmergedIn(FluidTags.WATER) && (this.canBreatheInWater()))) {
                this.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.WATER_BREATHING, 400, 0, false, false, true));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 300, 0, false, false, true));
            }
            if ((!this.abilities.creativeMode) && (!this.isSubmergedIn(FluidTags.WATER))) {
                this.abilities.allowFlying = false;
                this.abilities.flying = false;
            } else {
                this.abilities.allowFlying = true;
            }
        }
    }
}
