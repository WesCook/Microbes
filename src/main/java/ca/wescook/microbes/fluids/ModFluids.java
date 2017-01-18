package ca.wescook.microbes.fluids;

public class ModFluids {
	public static FluidBacteria fluidBacteria;
	public static BlockFluidBacteria blockFluidBacteria;

	public static void registerFluids() {
		fluidBacteria = new FluidBacteria();
		blockFluidBacteria = new BlockFluidBacteria();
	}

	public static void renderFluids() {
		blockFluidBacteria.render();
	}
}
