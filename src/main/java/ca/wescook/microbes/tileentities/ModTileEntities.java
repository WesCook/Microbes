package ca.wescook.microbes.tileentities;

import ca.wescook.microbes.Microbes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TEBacteria.class, Microbes.MODID + "bacteria");
	}
}
