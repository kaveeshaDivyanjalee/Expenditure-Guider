package Model;

public class Language {
	
	private int langID;
	private String language;
	
	public Language(int langID,String language) {
		this.langID=langID;
		this.language=language;
	}

	public int getLangID() {
		return langID;
	}

	public void setLangID(int langID) {
		this.langID = langID;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
