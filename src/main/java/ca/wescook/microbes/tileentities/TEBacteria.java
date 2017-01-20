package ca.wescook.microbes.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

import java.util.Random;

public class TEBacteria extends TileEntity implements ITickable {

	protected String name;

	public TEBacteria() {
		// Tile entity constructed
		name = "ID" + new Random().nextInt(100); // Not saved on world load, but unique to each TE
		System.out.println("Tile entity constructed, named " + name);
	}

	@Override
	public void update() {
		// Ticking update
		System.out.println("Tile entity updated, named " + name);
	}
}
