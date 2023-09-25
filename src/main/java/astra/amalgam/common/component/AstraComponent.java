package astra.amalgam.common.component;

import java.util.List;

import dev.onyxstudios.cca.api.v3.component.Component;

public interface AstraComponent extends Component{
	List<String> getEventsWon();
	int getActiveEvent();

	void addEvent(String eventId);
	void revokeEvent(String eventId);
	void setActiveEvent(int index);
}
