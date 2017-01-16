package ca.wescook.microbes.blocks;

import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockMicroscope extends Block {

	protected static AxisAlignedBB boundingBox = new AxisAlignedBB(0.315D, 0.0D, 0.25D, 0.622D, 0.581D, 0.624D);

	public BlockMicroscope() {
		super(Material.IRON);
		setRegistryName("microscope"); // Registration name with Forge
		setUnlocalizedName(getRegistryName().toString()); // Used for setting language name among other things
		GameRegistry.register(this); // Register block
		GameRegistry.register(new ItemBlock(this), getRegistryName()); // Register item drop
		setCreativeTab(ModCreativeTabs.microbesTab); // Creative tab
		setSoundType(SoundType.METAL); // Item sound when placing/walking
		setHarvestLevel("pickaxe", 2); // Tool to break with, and its tier
		setHardness(1.5F); // Breaking speed with pickaxe
		setResistance(1.0F); // Resistance to explosions
	}

	@SideOnly(Side.CLIENT)
	public void render() {
		// Maps item to blockstate json of same name
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	// Actual collision box
	@Override
	@Deprecated
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
	{
		addCollisionBoxToList(pos, entityBox, collidingBoxes, boundingBox);
	}

	// Visual bounding box
	@Override
	@Deprecated
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return boundingBox;
	}

	// Skips the block for ambient occlusion, so it draws what's behind it
	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	//Also used for collision detection
	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
}
