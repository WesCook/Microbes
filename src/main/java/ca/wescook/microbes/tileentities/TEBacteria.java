package ca.wescook.microbes.tileentities;

import ca.wescook.microbes.configs.Catalyst;
import ca.wescook.microbes.configs.CatalystData;
import ca.wescook.microbes.utilities.UsefulMath;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;
import java.util.Map;

public class TEBacteria extends TileEntity implements ITickable {

	// Based on growth rate, how often the tile updates
	private long delay;

	// Properties/Traits
	public int population;
	public int growthRate;
	public int resistance;
	public int age;
	public NBTTagCompound traits;

	public TEBacteria() {
		// Initial property values
		population = 1;
		growthRate = 0;
		resistance = 0;
		age = 1;
		traits = new NBTTagCompound();
		calculateDelay();
	}

	@Override
	public void update() {

		// Only run on server
		if (worldObj.isRemote)
			return;

		// Bail out if not a valid tick
		if (worldObj.getTotalWorldTime() % delay != 0)
			return;

		// Look for catalysts in bacteria
		List<EntityItem> entityItemsFound = worldObj.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos, pos.add(1, 1, 1))); // Get item list from bacteria pool

		if (entityItemsFound.size() > 0) {
			EntityItem entityItem = entityItemsFound.get(0); // Get first item from list
			Catalyst catalyst = CatalystData.find(entityItem.getEntityItem()); // Fetch catalyst from ItemStack if available, return null if not

			// Act on items
			if (catalyst != null) {
				// Loop through effects from this catalyst
				for (Map.Entry<String, Integer> entry : catalyst.effects.entrySet())
					applyCatalystEffect(entry.getKey(), entry.getValue());

				// Remove one from stack size until gone
				--entityItem.getEntityItem().stackSize;
			} else
				entityItem.addVelocity(worldObj.rand.nextGaussian() * 0.13D, 0.6D, worldObj.rand.nextGaussian() * 0.13D); // Eject item from bacteria
		}

		// Population doubles each update, up to its limit
		if (population < 1000)
			population = Math.min(population * 2, 1000);
	}

	private void applyCatalystEffect(String property, int amount) {
		switch(property) {
			case "population": population = UsefulMath.range(1, population + amount, 1000); break;
			case "growthrate": growthRate = UsefulMath.range(-100, growthRate + amount, 100); calculateDelay(); break;
			case "resistance": resistance = UsefulMath.range(-100, resistance + amount, 100); break;
		}
	}

	private void calculateDelay() {
		/*
		Calculating slope - linear scaling
		x: -100, 100   (config limits)
		y:   40, 1000  (tick limits)
		slope  = (y2 - y1) / (x2 - x1)  == 4.8
		offset = (slope * x1) + n = y1  == 520
		delay = (growthRate * 4.8) + 520

		Calculating least squares fit - exponential scaling
		https://www.wolframalpha.com/input/?i=(-100,+40),+(0,+200),+(100,+1000)+exponential+fit
		delay = Math.round(200 * Math.exp(0.0160944 * (growthRate * -1)))
		delay = Math.round(200 * Math.pow(2, 0.0232193 * (growthRate * -1)))
		*/

		this.delay = Math.round(200 * Math.exp(0.0160944 * (growthRate * -1)));
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		// Get bacteria properties
		population = compound.getInteger("population");
		growthRate = compound.getInteger("growthRate");
		resistance = compound.getInteger("resistance");
		age = compound.getInteger("age");
		traits = compound.getCompoundTag("traits");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		// Set bacteria properties
		compound.setInteger("population", population);
		compound.setFloat("growthRate", growthRate);
		compound.setInteger("resistance", resistance);
		compound.setInteger("age", age);
		compound.setTag("traits", traits);
		return compound;
	}
}
