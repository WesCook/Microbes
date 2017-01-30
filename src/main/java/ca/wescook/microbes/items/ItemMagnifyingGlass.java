package ca.wescook.microbes.items;

import ca.wescook.microbes.Microbes;
import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import ca.wescook.microbes.fluids.ModFluids;
import ca.wescook.microbes.tileentities.TEBacteria;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemMagnifyingGlass extends Item {
	ItemMagnifyingGlass() {
		setRegistryName("magnifying_glass");
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
		setCreativeTab(ModCreativeTabs.microbesTab);
	}

	@SideOnly(Side.CLIENT)
	void render() {
		// Maps item to blockstate json of same name
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		// Ray trace - find block we're looking at
		RayTraceResult rayTraceResult = rayTrace(worldIn, playerIn, true);

		// If block is found
		if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
			BlockPos blockPos = rayTraceResult.getBlockPos(); // Get block position
			TEBacteria teBacteria = (TEBacteria) worldIn.getTileEntity(blockPos); // Get TileEntity (if it exists)

			if (teBacteria != null && teBacteria.getBlockType() == ModFluids.blockFluidBacteria) {
				playerIn.addChatMessage(new TextComponentString(I18n.format("message." + Microbes.MODID + ":population_update") + " " + teBacteria.population)); // Not enough population to fill vial
				return new ActionResult(EnumActionResult.PASS, itemStackIn);
			}
		}

		return new ActionResult(EnumActionResult.FAIL, itemStackIn);
	}

	// Add tooltips
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format("tooltip." + Microbes.MODID + ":magnifying_glass", TextFormatting.DARK_GRAY));
	}
}
