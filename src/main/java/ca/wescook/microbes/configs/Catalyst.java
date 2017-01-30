package ca.wescook.microbes.configs;

import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class Catalyst {

	public ItemStack itemStack;
	public HashMap<String, Integer> effects = new HashMap<>();

	Catalyst(ItemStack itemStack) {
		this.itemStack = itemStack; // Item + Metadata
	}
}
