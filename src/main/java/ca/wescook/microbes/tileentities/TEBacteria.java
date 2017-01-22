package ca.wescook.microbes.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TEBacteria extends TileEntity implements ITickable {

	public int population;
	public float growthRate;
	public int age;
	public float resistance;

	public TEBacteria() {
		// Initial property values
		population = 1;
		growthRate = 1.0F;
		age = 1;
		resistance = 1.0F;
	}

	@Override
	public void update() {
		// Ticking update
		population += 1; // Population grows steadily over time
		//System.out.println("Population: " + population);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		// Get bacteria properties
		population = compound.getInteger("population");
		growthRate = compound.getFloat("growthRate");
		age = compound.getInteger("age");
		resistance = compound.getFloat("resistance");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		// Set bacteria properties
		compound.setInteger("population", population);
		compound.setFloat("growthRate", growthRate);
		compound.setInteger("age", age);
		compound.setFloat("resistance", resistance);
		return compound;
	}
}
