package ao.app.productmaster.bean;

/**
 * ItemCategoryテーブルから取得したデータを格納
 */
public class ItemCategory implements java.io.Serializable {

//データベースの列に合わせて、商品分類コード・商品分類名を保存するフィールドを宣言する
	private String itemCategoryCode;
	private String itemCategoryName;

//各フィールドの値を取得するためのゲッタとセッタを設定する
	public String getItemCategoryCode() {
		return itemCategoryCode;
	}
	public void setItemCategoryCode(String itemCategoryCode) {
		this.itemCategoryCode = itemCategoryCode;
	}
	public String getItemCategoryName() {
		return itemCategoryName;
	}
	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}
}