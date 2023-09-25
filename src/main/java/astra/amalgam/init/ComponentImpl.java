package astra.amalgam.init;

import astra.amalgam.AstralAmalgam;
import astra.amalgam.component.AstraComponent;
import astra.amalgam.component.PlayerComponents;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class ComponentImpl implements EntityComponentInitializer {
	public static final ComponentKey<AstraComponent> PlayerAstraComponent =
    ComponentRegistry.getOrCreate(new Identifier(AstralAmalgam.MODID, "astra_component"), AstraComponent.class);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.beginRegistration(PlayerEntity.class, PlayerAstraComponent).respawnStrategy(RespawnCopyStrategy.ALWAYS_COPY).end(PlayerComponents::new);
	}
}
