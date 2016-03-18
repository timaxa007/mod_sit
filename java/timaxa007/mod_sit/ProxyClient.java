package timaxa007.mod_sit;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ProxyClient extends ProxyCommon {

	public void preInit() {
		super.preInit();

		//Рендер для TileEntitySit в мире.
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySit.class, new RenederTileEntitySit());
		//Рендер как Item для block_sit
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModSit.block_sit), new RenederItemBlockSit());

	}

}
