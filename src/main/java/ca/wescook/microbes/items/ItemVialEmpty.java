package ca.wescook.microbes.items;

import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import ca.wescook.microbes.fluids.ModFluids;
import ca.wescook.microbes.tileentities.TEBacteria;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
			TEBacteria te = (TEBacteria)worldIn.getTileEntity(blockPos); // Get TileEntity (if it exists)

			if (te != null && te.getBlockType() == ModFluids.blockFluidBacteria) {
				if (te.population >= 101) { // Requires at least 101, so colony never runs out completely
					// Extract vial
					--itemStackIn.stackSize; // Delete item
					playerIn.inventory.addItemStackToInventory(new ItemStack(ModItems.itemVialFilled, 1)); // Spawn filled vial
					te.population -= 100; // Reduce population
					worldIn.playSound(playerIn, blockPos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 0.4F, 1.2F); // Play sound
				}
				else
					playerIn.addChatMessage(new TextComponentString("Missing population: " + te.population + "/100 required")); // Not enough population to fill vial
			}
		}
		return new ActionResult(EnumActionResult.PASS, itemStackIn);
	}
}
