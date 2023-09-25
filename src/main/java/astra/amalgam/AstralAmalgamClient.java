package astra.amalgam;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import astra.amalgam.render.CrownModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class AstralAmalgamClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		EntityModelLayerRegistry.registerModelLayer(CrownModel.MODEL_LAYER, CrownModel::getTexturedModelData);
	}
}
