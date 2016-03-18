package timaxa007.mod_sit;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSit extends Block implements ITileEntityProvider {

	public BlockSit() {
		super(Material.circuits);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntitySit();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		EntitySit sit = new EntitySit(world);//Создаём объект нашего EntitySit
		//Даём ему координаты
		sit.setPosition((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D);
		if (!world.isRemote) {
			world.spawnEntityInWorld(sit);//спавним нашего EntitySit.
			player.mountEntity(sit);//Игрок оседлает нашего EntitySit
		}
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);//просто false
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		/* Изменяем метудату от 0 до 3 зависимо от положения entity.
		 * Будет использоваться для поворота нашей модели.*/
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	/* Даже не зависимо, что указали для EntitySit точные координаты,
	 * EntitySit будет пытаться встать на коллизию блока, а не будет оставаться в коллизии блока.
	 * По-этому нужно сделать правильную коллизию для блока, но мне лень писать свой, я взял от котла.*/
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		float f = 0.125F;
		setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
		setBlockBoundsForItemRender();
	}

	@Override
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

}
