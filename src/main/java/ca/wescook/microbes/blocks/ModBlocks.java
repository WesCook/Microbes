package ca.wescook.microbes.blocks;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	//public static microscope itemMicroscope;

	public static void registerBlocks() {
		//itemMicroscope = new ItemMicroscope();
	}

	@SideOnly(Side.CLIENT)
	public static void renderBlocks() {
		//itemMicroscope.render();
	}
}
