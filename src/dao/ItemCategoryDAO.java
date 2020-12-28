package ao.app.productmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import ao.app.productmaster.bean.ItemCategory;
import ao.app.productmaster.dao.DAO;

/**ItemCategoryテーブルに対する処理を行う
 * ItemCategoryテーブルに入力された値をSQLで取得する
 * List<ItemCategory>のオブジェクトに詰め込んで返却する
 */
public class ItemCategoryDAO extends DAO {
 private String ITEM_CATEGORY_CODE_COLUMN_NAME = "ITEM_CATEGORY_CODE";
 private String ITEM_CATEGORY_NAME_COLUMN_NAME = "ITEM_CATEGORY_NAME";
 private String ITEM_CATEGORY_TABLE_NAME = "ITEM_CATEGORY";
 
 public List<ItemCategory> selectAll() 
  throws NamingException, SQLException {
   List<ItemCategory> list = new ArrayList<>();
   
   
   Connection con = getConnection();
   
   PreparedStatement st;
   st=con.prepareStatement("SELECT " + ITEM_CATEGORY_CODE_COLUMN_NAME+ ", " + ITEM_CATEGORY_NAME_COLUMN_NAME + " FROM " + ITEM_CATEGORY_TABLE_NAME);
   
	 	ResultSet rs=st.executeQuery();
	 		
	 	while (rs.next()) {
	 	 ItemCategory itemCategory =new ItemCategory();
	 		itemCategory.setItemCategoryCode(rs.getString(ITEM_CATEGORY_CODE_COLUMN_NAME));
	 		itemCategory.setItemCategoryName(rs.getString(ITEM_CATEGORY_NAME_COLUMN_NAME));
	 		list.add(itemCategory);
	 	}
	 	st.close();
	 	con.close();
	 	return list; 
 }
}
