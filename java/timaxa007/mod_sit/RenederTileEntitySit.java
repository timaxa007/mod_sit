package timaxa007.mod_sit;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenederTileEntitySit extends TileEntitySpecialRenderer {

	//Модель
	public static final ModelSit model = new ModelSit();
	//Текстура
	public static final ResourceLocation texture = new ResourceLocation(ModSit.MODID, "textures/blocks/sit.png");

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		render((TileEntitySit)tile, x, y, z, f);
	}

	private void render(TileEntitySit tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if (tile != null) {
			switch(tile.getBlockMetadata()) {
			case 0:{GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);break;}
			case 1:{GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);break;}
			case 2:{GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);break;}
			case 3:{GL11.glRotatef(180F + 90F, 0.0F, 1.0F, 0.0F);break;}
			}
		}
		bindTexture(texture);
		model.render(0.0625F);
		GL11.glPopMatrix();
	}

}
