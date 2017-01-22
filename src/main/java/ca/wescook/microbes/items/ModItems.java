package ca.wescook.microbes.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	public static ItemVialEmpty itemVialEmpty;
	public static ItemVialFilled itemVialFilled;
	public static ItemMoldyBread itemMoldyBread;

	public static void registerItems() {
		itemMoldyBread = new ItemMoldyBread(4, 0.5F, false);
		itemVialEmpty = new ItemVialEmpty();
		itemVialFilled = new ItemVialFilled();
	}

	@SideOnly(Side.CLIENT)
	public static void renderItems() {
		itemMoldyBread.render();
		itemVialEmpty.render();
		itemVialFilled.render();
	}
}
