package bean;

public class ItemCategory implements java.io.Serializable {

	private char item_category_code;
	private String item_category_name;

	public char getItem_category_code() {
		return item_category_code;
	}
	public void setItem_category_code(char item_category_code) {
		this.item_category_code = item_category_code;
	}
	public String getItem_category_name() {
		return item_category_name;
	}
	public void setItem_category_name(String item_category_name) {
		this.item_category_name = item_category_name;
	}

}
