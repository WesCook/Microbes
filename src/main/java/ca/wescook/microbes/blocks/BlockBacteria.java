package ca.wescook.microbes.blocks;

import ca.wescook.microbes.creativetabs.ModCreativeTabs;
import ca.wescook.microbes.tileentities.TEBacteria;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBacteria extends BlockContainer {
	BlockBacteria() {
		super(Material.IRON);
		setRegistryName("bacteria");
		setUnlocalizedName(getRegistryName().toString());
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		setCreativeTab(ModCreativeTabs.microbesTab);
		setSoundType(SoundType.SLIME);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TEBacteria();
	}
}