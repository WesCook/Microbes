package ca.wescook.microbes.blocks;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	public static BlockMicroscope blockMicroscope;

	public static void registerBlocks() {
		blockMicroscope = new BlockMicroscope();
	}

	@SideOnly(Side.CLIENT)
	public static void renderBlocks() {
		blockMicroscope.render();
	}
}
