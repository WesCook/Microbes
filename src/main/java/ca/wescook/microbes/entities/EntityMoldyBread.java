package ca.wescook.microbes.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMoldyBread extends EntityItem {
	public EntityMoldyBread(World worldIn, Entity entity, ItemStack stack) {
		super(worldIn, entity.posX, entity.posY, entity.posZ, stack);
		setPickupDelay(40); // Must set pickup delay, else item can't be thrown
		setVelocity(entity.motionX, entity.motionY, entity.motionZ); // Set velocity to that of original item, else it drops at our feet
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (inWater)
			System.out.println("Oh god save me I'm drowning");
	}
}
