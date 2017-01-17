package ca.wescook.microbes.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TEBacteria extends TileEntity implements ITickable {
	public TEBacteria() {
		// Tile entity constructed
		System.out.println("Tile entity constructed");
	}

	@Override
	public void update() {
		// Ticking update
		System.out.println("Tile entity updated");
	}
}
