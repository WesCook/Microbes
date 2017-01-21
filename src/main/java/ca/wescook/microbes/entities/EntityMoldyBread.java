package ca.wescook.microbes.entities;

import ca.wescook.microbes.fluids.ModFluids;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static net.minecraftforge.fluids.BlockFluidBase.LEVEL;

public class EntityMoldyBread extends EntityItem {

	public EntityMoldyBread(World worldIn, Entity entity, ItemStack stack) {
		super(worldIn, entity.posX, entity.posY, entity.posZ, stack);
		setVelocity(entity.motionX, entity.motionY, entity.motionZ); // Set velocity to that of original item, else it drops at our feet
		setPickupDelay(40); // Must set pickup delay, else item can't be thrown
		setNoDespawn(); // In-world interaction required, so disable despawning
	}

	public EntityMoldyBread(World worldIn) {
		super(worldIn);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		// When thrown in water, randomly replace water source with bacteria
		if (worldObj.getBlockState(getPosition()) == Blocks.WATER.getDefaultState().withProperty(LEVEL, 0) && rand.nextInt(500) == 0) { // If in water source block
			worldObj.setBlockState(getPosition(), ModFluids.blockFluidBacteria.getDefaultState()); // Set bacteria block
			setDead(); // Destroy moldy bread
		}
	}
}
