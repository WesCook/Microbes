package ca.wescook.microbes.tileentities;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

public class TEBacteria extends TileEntity implements ITickable {

	// Internal tick timer
	private int updateCounter = 0;

	// Properties/Traits
	public int population;
	public float growthRate;
	public int age;
	public float resistance;
	public NBTTagCompound traits;

	public TEBacteria() {
		// Initial property values
		population = 1;
		growthRate = 1.0F;
		age = 1;
		resistance = 1.0F;
		traits = new NBTTagCompound();
	}

	@Override
	public void update() {

		// Bail out if not a valid tick
		if (worldObj.getTotalWorldTime() % (20 * 10 * growthRate) != 0) // Default: 10 seconds
			return;

		// Detect catalysts
		List<EntityItem> entitiesFound = worldObj.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)));
		if (entitiesFound.size() > 0)
			System.out.println(entitiesFound);

		// Population doubles each update, up to its limit
		if (population < 1000)
			population = Math.min(population * 2, 1000);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		// Get bacteria properties
		population = compound.getInteger("population");
		growthRate = compound.getFloat("growthRate");
		age = compound.getInteger("age");
		resistance = compound.getFloat("resistance");
		traits = compound.getCompoundTag("traits");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		// Set bacteria properties
		compound.setInteger("population", population);
		compound.setFloat("growthRate", growthRate);
		compound.setInteger("age", age);
		compound.setFloat("resistance", resistance);
		compound.setTag("traits", traits);
		return compound;
	}
}
