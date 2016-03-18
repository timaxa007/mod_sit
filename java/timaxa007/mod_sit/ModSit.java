package timaxa007.mod_sit;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModSit.MODID, name = ModSit.NAME, version = ModSit.VERSION)
public class ModSit {

	public static final String
	MODID = "mod_sit",
	NAME = "On a chair to sit (Alpha)",
	VERSION = "0.001a"
	;

	@Mod.Instance(value = ModSit.MODID)
	public static ModSit instance;

	@SidedProxy(modId = ModSit.MODID, serverSide = "timaxa007.mod_sit.ProxyCommon", clientSide = "timaxa007.mod_sit.ProxyClient")
	public static ProxyCommon proxy;

	public static Block block_sit;

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {

		block_sit = new BlockSit().setBlockName("sit").setBlockTextureName(MODID + ":sit").setHardness(0.15F).setCreativeTab(CreativeTabs.tabBlock);
		//Регистрируем наш блок.
		GameRegistry.registerBlock(block_sit, "block_sit");
		//Регистрируем наш TileEntity для рендера. Рендер для TileEntity в ProxyClient.
		GameRegistry.registerTileEntity(TileEntitySit.class, "TileEntitySit");
		//Регистрируем нашего Entity.
		EntityRegistry.registerModEntity(EntitySit.class, "EntitySit", 0, instance, 10, 1, true);

		proxy.preInit();

	}

}
