package Model;

public class Catergory {
	
	private String catID;
	private String catergoryType;
	
	public Catergory(String catID,String catergoryType) {
		this.catID=catID;
		this.catergoryType=catergoryType;
	}

	public String getCatID() {
		return catID;
	}

	public void setCatID(String catID) {
		this.catID = catID;
	}

	public String getCatergoryType() {
		return catergoryType;
	}

	public void setCatergoryType(String catergoryType) {
		this.catergoryType = catergoryType;
	}
	
	
}
