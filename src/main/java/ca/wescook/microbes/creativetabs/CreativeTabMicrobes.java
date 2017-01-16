package ca.wescook.microbes.creativetabs;

import ca.wescook.microbes.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMicrobes extends CreativeTabs {
	public CreativeTabMicrobes(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.blockMicroscope);
	}
}
