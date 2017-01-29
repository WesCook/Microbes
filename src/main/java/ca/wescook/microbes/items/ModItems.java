package ca.wescook.microbes.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	public static ItemMagnifyingGlass itemMagnifyingGlass;
	public static ItemVialEmpty itemVialEmpty;
	public static ItemVialFilled itemVialFilled;
	public static ItemMoldyBread itemMoldyBread;

	public static void registerItems() {
		itemMagnifyingGlass = new ItemMagnifyingGlass();
		itemMoldyBread = new ItemMoldyBread(4, 0.5F, false);
		itemVialEmpty = new ItemVialEmpty();
		itemVialFilled = new ItemVialFilled(0, 0F, false);
	}

	@SideOnly(Side.CLIENT)
	public static void renderItems() {
		itemMagnifyingGlass.render();
		itemMoldyBread.render();
		itemVialEmpty.render();
		itemVialFilled.render();
	}
}
