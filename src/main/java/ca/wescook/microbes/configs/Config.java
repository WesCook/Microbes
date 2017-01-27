package ca.wescook.microbes.configs;

import ca.wescook.microbes.Microbes;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

public class Config {
	public static boolean bacteriaSpreading;
	public static Property rawCatalystData;

	public static void registerConfigs(FMLPreInitializationEvent event) {
		// Create or load from file
		Configuration configFile = new Configuration(new File(event.getModConfigurationDirectory().getPath(), Microbes.MODID + ".cfg"));
		configFile.load();

		// Get Values
		bacteriaSpreading = configFile.getBoolean("bacteriaSpreading", CATEGORY_GENERAL, true, "Should bacteria spread to neighboring blocks?");
		rawCatalystData = configFile.get("catalysts", "catalysts", new String[]{
				"minecraft:dye:15    growthrate  2",
				"minecraft:soul_sand growthrate -2"
		}, "List of catalysts and their effects on bacteria growth:  [modid:item:metadata] [property] [value]");

		// Update file
		if (configFile.hasChanged())
			configFile.save();
	}
}
