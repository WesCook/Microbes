package ca.wescook.microbes.configs;

import net.minecraft.item.ItemStack;

public class Catalyst {

	public ItemStack itemStack;
	public String property;
	public int amount;

	Catalyst(ItemStack item, String property, int amount) {
		this.itemStack = item; // Item + Metadata
		this.property = property; // Property/Trait being modified
		this.amount = amount; // Modified by this amount
	}
}
