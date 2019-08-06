
public enum CharacterCard implements Card {
	Miss_Scarlett("S"),
	Colonel_Mustard("M"),
	Mrs_White("W"),
	Mr_Green("G"),
	Mrs_Peacock("P"),
	Professor_Plum("L");
	
	private String text;
	
	CharacterCard(String text){
		this.text = text;
	}
	
    public static CharacterCard fromString(String text) {
        for (CharacterCard c : CharacterCard.values()) {
            if (c.text.equalsIgnoreCase(text)) {
                return c;
            }
        }
        return null;
    }
    
    public String toString() {
    	return this.text + " = " + this.name();
    }
    
    @Override
    public String stringCheck() {
    	return this.text;
    }
}
