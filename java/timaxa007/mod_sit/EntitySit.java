package timaxa007.mod_sit;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySit extends Entity {

	public EntitySit(World world) {
		super(world);
	}

	@Override
	public void entityInit() {
		/*У нашего Entity нет своего рендера, если размер не задать по 0F, то
		будет рендриться белый */
		setSize(0F, 0F);
		/*Не знаю точно зачем это нужно, но я написал.
		Знаю что оно используеться для трекера Entity и ещё какого-то пакета*/
		myEntitySize = Entity.EnumEntitySize.SIZE_1;
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (riddenByEntity == null) {//Если не кто не оседал этот Entity
			setDead();//... то этот Entity умерает.
			/* Это надо если игрок/моб сощёл/выпал с этого Entity, 
			или иначе этот Entity остаёться жить и захламлять своим прибытием в мире.
			Так как его повторно не оседлать. */
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize() {
		return 0.0F;//Чтобы не было тени от этого Entity.
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
	}

}
