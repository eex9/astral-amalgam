package astra.amalgam.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;

import astra.amalgam.AstralAmalgam;
import astra.amalgam.common.component.AstraComponent;
import astra.amalgam.common.init.ComponentImpl;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.*;

public class EventCommand {
	public static void init(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(literal("event")
				.then(literal("add")
						.requires(source -> source.hasPermissionLevel(2))
						.then(argument("player", EntityArgumentType.player())
								.then(argument("id", StringArgumentType.greedyString())
										.executes(
												ctx -> addEventToPlayer(ctx,
														EntityArgumentType.getPlayer(ctx, "player"),
														StringArgumentType.getString(ctx, "id"))))))
				.then(literal("revoke")
						.requires(source -> source.hasPermissionLevel(2))
						.then(argument("player", EntityArgumentType.player())
								.then(argument("id", StringArgumentType.greedyString())
										.executes(
												ctx -> removeEventFromPlayer(ctx,
														EntityArgumentType.getPlayer(ctx, "player"),
														StringArgumentType.getString(ctx, "id"))))))
				.then(literal("activate")
						.then(argument("index", IntegerArgumentType.integer(0))
								.executes(
										ctx -> setActiveEvent(ctx, IntegerArgumentType.getInteger(ctx, "index")))))
				.executes(ctx -> listEvents(ctx)));
	}

	public static int addEventToPlayer(CommandContext<ServerCommandSource> ctx, PlayerEntity player, String event) {
		final ServerCommandSource source = ctx.getSource();
		AstraComponent component = ComponentImpl.PlayerAstraComponent.get(player);
		component.addEvent(event);
		AstralAmalgam.LOGGER.info(component.toString());
		AstralAmalgam.LOGGER.info(player.getUuidAsString());
		source.sendFeedback(() -> Text.of("Added event " + event + " to " + player.getName().toString()), true);
		return 1;
	}

	public static int removeEventFromPlayer(CommandContext<ServerCommandSource> ctx, PlayerEntity player,
			String event) {
		final ServerCommandSource source = ctx.getSource();
		AstraComponent component = ComponentImpl.PlayerAstraComponent.get(player);
		component.revokeEvent(event);
		source.sendFeedback(() -> Text.of("Removed event " + event + " from " + player.getName().toString()), true);
		return 1;
	}

	public static int setActiveEvent(CommandContext<ServerCommandSource> ctx, int idx) {
		final ServerCommandSource source = ctx.getSource();
		final PlayerEntity player = source.getPlayer();
		AstraComponent component = ComponentImpl.PlayerAstraComponent.get(player);
		component.setActiveEvent(idx - 1);
		source.sendFeedback(() -> Text.of("Set your active event to " + component.getEventsWon().get(idx - 1)), false);
		return 1;
	}

	public static int listEvents(CommandContext<ServerCommandSource> ctx) {
		final ServerCommandSource source = ctx.getSource();
		final PlayerEntity player = source.getPlayer();
		AstraComponent component = ComponentImpl.PlayerAstraComponent.get(player);
		source.sendFeedback(
				() -> Text.of(component.getEventsWon() != null ? component.getEventsWon().toString() : "No events"),
				false);
		return 1;
	}
}
