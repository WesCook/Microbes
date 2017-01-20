package ca.wescook.microbes.entities;

import ca.wescook.microbes.Microbes;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	public static void registerEntities() {
		EntityRegistry.registerModEntity(EntityMoldyBread.class, Microbes.MODID + "moldy_bread", 5, Microbes.instance, 64, 10, true);
	}
}
