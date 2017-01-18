package ca.wescook.microbes.fluids;

import ca.wescook.microbes.Microbes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidBacteria extends Fluid {
	FluidBacteria() {
		super("bacteria", new ResourceLocation(Microbes.MODID, "fluids/bacteria_still"), new ResourceLocation(Microbes.MODID, "fluids/bacteria_flow"));
		FluidRegistry.registerFluid(this);
		FluidRegistry.addBucketForFluid(this);
	}
}
