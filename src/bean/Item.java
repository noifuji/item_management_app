package ao.app.productmaster.bean;

import java.util.Date;

/**
 * Itemテーブルから取得したデータを格納
 */
public class Item implements java.io.Serializable {

//データベースの列に合わせて商品ナンバー・商品分類コード・商品名・説明・単価・おすすめ・最終更新日時を保存するフィールドを宣言する
    private String itemNo;
    private String itemCategoryCode;
    private String itemCategoryName;
    private String itemName;
    private String explanation;
    private String price;
    private String recommendFlg;
    private Date lastUpdateDateTime;

//フィールドの値を取得するためのゲッタとセッタを取得する
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public int getItemNoInt() {
		return Integer.parseInt(itemNo);
	}
	
	public String getItemCategoryCode() {
		return itemCategoryCode;
	}
	public void setItemCategoryCode(String itemCategoryCode) {
		this.itemCategoryCode = itemCategoryCode;
	}
	
	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}
	public String getItemCategoryName() {
		return itemCategoryName;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	public String getPrice() {
		return price;
	}
	public int getPriceInt() {
		return Integer.parseInt(price);
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getRecommendFlg() {
		return recommendFlg;
	}
	public void setRecommendFlg(String recommendFlg) {
		this.recommendFlg = recommendFlg;
	}
	
	public Date getLastUpdateDateTime() {
		return lastUpdateDateTime;
	}
	public void setLastUpdateDateTime(Date lastUpdateDateTime) {
		this.lastUpdateDateTime = lastUpdateDateTime;
	}
}
