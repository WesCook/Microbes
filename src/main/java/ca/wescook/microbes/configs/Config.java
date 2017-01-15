package ca.wescook.microbes.configs;

import ca.wescook.microbes.Microbes;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

public class Config {
	public static boolean configExample;

	public static void registerConfigs(FMLPreInitializationEvent event) {
		// Create or load from file
		Configuration configFile = new Configuration(new File(event.getModConfigurationDirectory().getPath(), Microbes.MODID + ".cfg"));
		configFile.load();

		// Get Values
		configExample = configFile.getBoolean("configExample", CATEGORY_GENERAL, true, "This doesn't do anything yet, but it's a great template for later features.");

		// Update file
		if (configFile.hasChanged())
			configFile.save();
	}
}
