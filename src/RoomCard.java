
public enum RoomCard implements Card {
	Kitchen("kitchen"),
	Ball_Room("ball room"),
	Conversatory("conservatory"),
	Billiard_Room("billiard room"),
	Library("library"),
	Study("study"),
	Hall("hall"),
	Lounge("lounge"),
	Dining_Room("dining room");
	
	private String text;
	
	RoomCard(String text){
		this.text = text;
	}
	
    public static RoomCard fromString(String text) {
        for (RoomCard c : RoomCard.values()) {
            if (c.text.equalsIgnoreCase(text)) {
                return c;
            }
        }
        return null;
    }
    
    public String toString() {
    	return this.text;
    }

	@Override
    public String stringCheck() {
    	return this.name();
    }
}

