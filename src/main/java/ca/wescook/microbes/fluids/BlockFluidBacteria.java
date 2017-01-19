package ca.wescook.microbes.fluids;

import ca.wescook.microbes.tileentities.TEBacteria;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFluidBacteria extends BlockFluidClassic implements ITileEntityProvider {
	BlockFluidBacteria() {
		super(ModFluids.fluidBacteria, Material.WATER);
		setRegistryName("bacteria");
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
		setQuantaPerBlock(1); // Fluid length
	}

	// Map to blockstate and render the appropriate fluid level
	@SideOnly(Side.CLIENT)
	void render() {
		ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(LEVEL).build());
	}

	// Connects fluid block to tile entity
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TEBacteria();
	}

	// Remove TE if broken
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		super.breakBlock(world, pos, state);
		world.removeTileEntity(pos);
	}

	// Passes events to TE
	@Override
	@Deprecated
	public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
	{
		super.eventReceived(state, worldIn, pos, id, param);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
	}

	// Don't render TE
	//@Override
	//@Deprecated
	//public EnumBlockRenderType getRenderType(IBlockState state)
	//{
	//	return EnumBlockRenderType.INVISIBLE;
	//}
}
