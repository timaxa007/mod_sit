package timaxa007.mod_sit;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSit extends ModelBase {
/*Просто построил в Techne и немного подправил для примера.*/
	ModelRenderer sit, right, left, back;

	public ModelSit() {
		
		textureWidth = 128;
		textureHeight = 64;

		sit = new ModelRenderer(this, 0, 0);
		sit.addBox(-8F, 0F, -8F, 16, 6, 16);
		sit.setRotationPoint(0F, 18F, 0F);
		sit.setTextureSize(128, 64);
		sit.mirror = true;
		setRotation(sit, 0F, 0F, 0F);

		right = new ModelRenderer(this, 36, 22);
		right.addBox(-8F, -8F, -8F, 2, 8, 14);
		right.setRotationPoint(0F, 18F, 0F);
		right.setTextureSize(128, 64);
		right.mirror = true;
		setRotation(right, 0F, 0F, 0F);

		left = new ModelRenderer(this, 68, 22);
		left.addBox(6F, -8F, -8F, 2, 8, 14);
		left.setRotationPoint(0F, 18F, 0F);
		left.setTextureSize(128, 64);
		left.mirror = true;
		setRotation(left, 0F, 0F, 0F);

		back = new ModelRenderer(this, 0, 22);
		back.addBox(-8F, -12F, 6F, 16, 12, 2);
		back.setRotationPoint(0F, 18F, 0F);
		back.setTextureSize(128, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	public void render(float f5) {
		sit.render(f5);
		right.render(f5);
		left.render(f5);
		back.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
