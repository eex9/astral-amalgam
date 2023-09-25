package astra.amalgam;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import astra.amalgam.command.EventCommand;
import astra.amalgam.init.AstraItems;

public class AstralAmalgam implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "astral_amalgam";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("hello quilt world from {} :3", mod.metadata().name());
		AstraItems.init();
		CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, environment) -> {
			EventCommand.init(dispatcher, commandBuildContext);
		});
	}
}
