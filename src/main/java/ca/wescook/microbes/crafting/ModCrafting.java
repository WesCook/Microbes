package ca.wescook.microbes.crafting;

import ca.wescook.microbes.blocks.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	public static void registerCrafting() {
		// Microscope
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.itemMicroscope),
				" G ",
				"RIR",
				"III",
				'G', Blocks.GLASS_PANE, 'I', Items.IRON_INGOT, 'R', Items.REDSTONE
		);
	}
}
