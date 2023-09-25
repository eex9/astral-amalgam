package astra.amalgam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import astra.amalgam.common.command.EventCommand;
import astra.amalgam.common.init.AstraItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class AstralAmalgam implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "astral_amalgam";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("hello fabric world :3");
		AstraItems.init();
		CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, environment) -> {
			EventCommand.init(dispatcher);
		});
	}
}
