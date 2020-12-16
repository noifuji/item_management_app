package ao.app.productmaster.bean;

import java.util.Date;

public class Product implements java.io.Serializable {

    private int item_no;
    private char item_category_code;
    private String item_name;
    private String explanation;
    private int price;
    private char recommend_flg;
    private Date last_update_date_time;

	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public char getItem_category_code() {
		return item_category_code;
	}
	public void setItem_category_code(char item_category_code) {
		this.item_category_code = item_category_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getRecommend_flg() {
		return recommend_flg;
	}
	public void setRecommend_flg(char recommend_flg) {
		this.recommend_flg = recommend_flg;
	}
	public Date getLast_update_date_time() {
		return last_update_date_time;
	}
	public void setLast_update_date_time(Date last_update_date_time) {
		this.last_update_date_time = last_update_date_time;
	}
}
