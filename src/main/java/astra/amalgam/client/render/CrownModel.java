package astra.amalgam.client.render;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

import astra.amalgam.AstralAmalgam;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CrownModel extends Model {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(new Identifier(AstralAmalgam.MODID, "crown"), "main");
	private final ModelPart crown;

	public CrownModel(ModelPart root) {
		super(RenderLayer::getEntityTranslucent);
		this.crown = root.getChild("crown");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData crown = modelPartData.addChild("crown", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, 0.0F, -8.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 16);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		matrices.scale(1.195f, 1.195f, 1.195f);
        matrices.translate(0.26f, -1.95f, 0.26f);
		crown.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}
