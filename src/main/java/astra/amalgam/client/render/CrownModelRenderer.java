package astra.amalgam.client.render;

import java.util.List;
import java.util.UUID;

import astra.amalgam.AstralAmalgam;
import astra.amalgam.common.component.AstraComponent;
import astra.amalgam.common.init.AstraItems;
import astra.amalgam.common.init.ComponentImpl;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CrownModelRenderer<T extends PlayerEntity, M extends PlayerEntityModel<T>> extends FeatureRenderer<T, M> {
	public static CrownModel CROWN_MODEL;
	public static Identifier TEXTURE;

	public CrownModelRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
		super(context);
		CROWN_MODEL = new CrownModel(loader.getModelPart(CrownModel.MODEL_LAYER));
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
			PlayerEntity player, float limbAngle, float limbDistance, float tickDelta,
			float animationProgress, float headYaw, float headPitch) {
		if (!player.isInvisible()) {
			ItemStack item = player.getEquippedStack(EquipmentSlot.HEAD);
			if (item.isOf(AstraItems.EVENT_CROWN)) {
				matrices.push();
				getContextModel().head.rotate(matrices);
				Identifier texture = new Identifier(AstralAmalgam.MODID, "textures/models/crowns/none.png");
				ComponentImpl.PlayerAstraComponent.sync(player);
				AstraComponent component = ComponentImpl.PlayerAstraComponent.get(player);
				List<String> events = component.getEventsWon();
				if (!events.isEmpty()) {
					int activeEvent = component.getActiveEvent();
					if ((activeEvent >= 0) && (activeEvent < events.size())) {
						texture = new Identifier(AstralAmalgam.MODID,
								"textures/models/crowns/" + events.get(activeEvent) + ".png");
					} else if (player.getUuid().equals(UUID.fromString("4ed936ce-525a-47e8-9960-be9d34714f07"))) {
						texture = new Identifier(AstralAmalgam.MODID,
								"textures/models/crowns/midnight__sun.png");
					}
				}
				CROWN_MODEL.render(matrices,
					vertexConsumers.getBuffer(RenderLayer.getEntityCutout(texture)), light,
					OverlayTexture.DEFAULT_UV, 1f, 1f, 1f, 1f);
				matrices.pop();
			}
		}
	}
}
