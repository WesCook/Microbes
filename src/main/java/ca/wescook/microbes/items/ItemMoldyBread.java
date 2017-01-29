package ca.wescook.microbes.items;

import ca.wescook.microbes.Microbes;
import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import ca.wescook.microbes.entities.EntityMoldyBread;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemMoldyBread extends ItemFood {
	ItemMoldyBread(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName("moldy_bread");
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
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if (!worldIn.isRemote)
		{
			// Apply potion effects
			playerIn.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 400, 3));
		}
	}

	// Mark the item as having a custom entity when dropped
	@Override
	public boolean hasCustomEntity(ItemStack stack)
	{
		return true;
	}

	// Return a copy of our custom thrown entity
	@Override
	public Entity createEntity(World worldIn, Entity entityIn, ItemStack itemStackIn) {
		return new EntityMoldyBread(worldIn, entityIn, itemStackIn);
	}

	// Add tooltips
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format("tooltip." + Microbes.MODID + ":moldy_bread", TextFormatting.DARK_GRAY));
	}
}
