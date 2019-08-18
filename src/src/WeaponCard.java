//Authored by Ben Hanson and Matt Edmundson
public enum WeaponCard implements Card{
	Candlestick("c"),
	Dagger("d"),
	Leadpipe("l"),
	Revolver("r"),
	Rope("o"),
	Spanner("s");
	
	private String text;
	
	WeaponCard(String text){
		this.text = text;
	}
	
    public static WeaponCard fromString(String text) {
        for (WeaponCard c : WeaponCard.values()) {
            if (c.text.equalsIgnoreCase(text)) {
                return c;
            }
        }
        return null;
    }
    
    public String toString() {
    	return this.text + " = " + this.name();
    }
    
    public String stringCheck() {
    	return this.text;
    }
	
}

