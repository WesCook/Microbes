package ca.wescook.microbes.items;

import ca.wescook.microbes.Microbes;
import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import ca.wescook.microbes.fluids.ModFluids;
import ca.wescook.microbes.tileentities.TEBacteria;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVialEmpty extends Item {
	ItemVialEmpty() {
		setRegistryName("vial_empty");
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
		setCreativeTab(ModCreativeTabs.microbesTab);
		setMaxStackSize(16);
	}

	@SideOnly(Side.CLIENT)
	void render() {
		// Maps item to blockstate json of same name
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	// On right click
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		// Ray trace - find block we're looking at
		RayTraceResult rayTraceResult = rayTrace(worldIn, playerIn, true);

		// If block is found
		if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {

			BlockPos blockPos = rayTraceResult.getBlockPos(); // Get block position
			TEBacteria teBacteria = (TEBacteria)worldIn.getTileEntity(blockPos); // Get TileEntity (if it exists)

			if (teBacteria != null && teBacteria.getBlockType() == ModFluids.blockFluidBacteria) {
				if (teBacteria.population >= 101 || playerIn.isCreative()) { // Requires at least 101, so colony never runs out completely

					// Get NBT
					NBTTagCompound compound = new NBTTagCompound();
					compound.setInteger("age", teBacteria.age);
					compound.setInteger("growthRate", teBacteria.growthRate);
					compound.setInteger("resistance", teBacteria.resistance);
					compound.setTag("traits", teBacteria.traits);

					// Attach NBT to ItemStack
					ItemStack stack = new ItemStack(ModItems.itemVialFilled);
					stack.setTagCompound(compound);

					// Extract vial
					--itemStackIn.stackSize; // Delete item
					playerIn.inventory.addItemStackToInventory(stack); // Spawn filled vial
					if (!playerIn.isCreative())
						teBacteria.population -= 100; // Reduce population
					worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F); // Play sound
				}
				else
					playerIn.addChatMessage(new TextComponentString(I18n.format("message." + Microbes.MODID + ":missing_population"))); // Not enough population to fill vial
			}
		}
		return new ActionResult(EnumActionResult.PASS, itemStackIn);
	}
}
