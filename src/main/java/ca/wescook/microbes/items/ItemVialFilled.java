package ca.wescook.microbes.items;

import ca.wescook.microbes.Microbes;
import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemVialFilled extends ItemFood {
	ItemVialFilled(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName("vial_filled");
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
		setCreativeTab(ModCreativeTabs.microbesTab);
		setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	void render() {
		// Maps item to blockstate json of same name
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	// Apply relevant potion eff ects
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if (!worldIn.isRemote)
		{
			// Apply potion effects
			// TODO: Set effect based on traits
		}
	}

	// Drink, don't eat
	public EnumAction getItemUseAction(ItemStack itemStackIn) {
		return EnumAction.DRINK;
	}

	// Add tooltips
	@Override
	public void addInformation(ItemStack itemStackIn, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		NBTTagCompound compound = itemStackIn.getTagCompound();
		if (compound != null) {
			NBTTagCompound traits = compound.getCompoundTag("traits");
			if (traits != null) {
				tooltip.add(I18n.format("tooltip." + Microbes.MODID + ":vial_filled_traits_header", TextFormatting.DARK_GRAY));
				// TODO: Generate tooltip from active traits
				return;
			}
		}

		tooltip.add(I18n.format("tooltip." + Microbes.MODID + ":vial_filled_traits_missing", TextFormatting.DARK_GRAY));
	}
}
