package astra.amalgam.item;

import astra.amalgam.component.AstraComponent;
import astra.amalgam.init.ComponentImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EventCalendarItem extends Item {

	public EventCalendarItem(Settings settings) {
		super(settings);
	}

	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        AstraComponent component = ComponentImpl.PlayerAstraComponent.get(player);
        MinecraftClient mc = MinecraftClient.getInstance();
		String event = component.getActiveEvent() >= 0 ? component.getEventsWon().get(component.getActiveEvent()) : "none";
        mc.inGameHud.setOverlayMessage(
                (Text.translatable("gui.astral_amalgam.event_calendar." + event.toLowerCase())),
                false);
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
