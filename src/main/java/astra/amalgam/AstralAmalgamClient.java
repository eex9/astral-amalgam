package astra.amalgam;

import astra.amalgam.client.render.CrownModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class AstralAmalgamClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(CrownModel.MODEL_LAYER, CrownModel::getTexturedModelData);
	}
}
