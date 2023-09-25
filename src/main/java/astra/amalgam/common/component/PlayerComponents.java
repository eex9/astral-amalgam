package astra.amalgam.common.component;

import java.util.ArrayList;
import java.util.List;

import astra.amalgam.common.init.ComponentImpl;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class PlayerComponents implements AstraComponent, AutoSyncedComponent{
	private PlayerEntity player;
	private List<String> eventsWon;
	private int activeEvent;

	public PlayerComponents(PlayerEntity _player) {
		this.player = _player;
		this.eventsWon = new ArrayList<String>();
		this.activeEvent = -1;
	}

	@Override
	public void readFromNbt(NbtCompound tag) {
		NbtList eventsList = (NbtList) tag.get("eventsWon");
		if (eventsList == null) {
			eventsWon = new ArrayList<String>();
			activeEvent = -1;
			return;
		}
		List<String> out = new ArrayList<String>();
		for (int i = 0; i < eventsList.size(); i++) {
			NbtCompound eventTag = eventsList.getCompound(i);
			String event = eventTag.getString("id");
			out.add(event);
		}
		eventsWon = out;

		activeEvent = tag.getInt("activeEvent");
	}

	@Override
	public void writeToNbt(NbtCompound tag) {
        NbtList eventsList = new NbtList();
		for (String event : eventsWon) {
			NbtCompound eventNbt = new NbtCompound();
			eventNbt.putString("id", event);
			eventsList.add(eventNbt);
		}
		tag.put("eventsWon", eventsList);
		tag.putInt("activeEvent", activeEvent);
	}

	@Override
	public List<String> getEventsWon() {
		return eventsWon;
	}

	@Override
	public int getActiveEvent() {
		return activeEvent;
	}

	@Override
	public void addEvent(String id) {
		eventsWon.add(id);
		ComponentImpl.PlayerAstraComponent.sync(this.player);
	}

	@Override
	public void revokeEvent(String id) {
		for (int i = 0; i < eventsWon.size(); i++) {
			if (eventsWon.get(i).equals(id)) {
				eventsWon.remove(i);
				break;
			}
		}
		this.setActiveEvent(this.getActiveEvent());
		ComponentImpl.PlayerAstraComponent.sync(this.player);
	}

	@Override
	public void setActiveEvent(int idx) {
		if ((idx >= eventsWon.size()) || (idx < 0)) {
			idx = -1;
		}
		this.activeEvent = idx;
		ComponentImpl.PlayerAstraComponent.sync(this.player);
	}
}
