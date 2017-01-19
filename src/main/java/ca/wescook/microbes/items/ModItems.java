package ca.wescook.microbes.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	public static ItemVial itemVial;
	public static ItemMoldyBread itemMoldyBread;

	public static void registerItems() {
		itemVial = new ItemVial();
		itemMoldyBread = new ItemMoldyBread(4, 0.5F, false);
	}

	@SideOnly(Side.CLIENT)
	public static void renderItems() {
		itemVial.render();
		itemMoldyBread.render();
	}
}
