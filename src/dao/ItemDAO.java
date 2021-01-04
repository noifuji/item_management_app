package ao.app.productmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import ao.app.productmaster.bean.Item;
import ao.app.productmaster.dao.DAO;

/**Itemテーブルに対する処理を行う
 * 商品検索
 * 商品情報の新規登録
 * 商品情報変更
 * 商品情報削除
 */
 
 public class ItemDAO extends DAO {
 	private String ITEM_NO_COLUMN_NAME = "item_no";
 	private String ITEM_CATEGORY_CODE_COLUMN_NAME = "item_category_code";
 	private String ITEM_CATEGORY_NAME_COLUMN_NAME = "item_category_name";
 	private String ITEM_NAME_COLUMN_NAME = "item_name";
 	private String EXPLANATION_COLUMN_NAME = "explanation";
 	private String PRICE_COLUMN_NAME = "price";
 	private String RECOMMEND_FLG_COLUMN_NAME = "recommend_flg";
 	private String LAST_UPDATE_DATE_TIME_COLUMN_NAME= "last_update_date_time";
 	
 	//Itemの情報をデータベースに問い合わせて結果を返却する(検索機能)
 	
	public List<Item> selectByItemCategoryCodeAndItemName(String itemCategoryCode, String itemName) 
	 throws NamingException, SQLException {
	 	List<Item> list = new ArrayList<>();

	 	Connection con = getConnection();
	 	
	 	/**
	 	SELECT ITEM.ITEM_NO, 
	 			ITEM.ITEM_CATEGORY_CODE, 
	 			ITEM.ITEM_NAME, 
	 			ITEM.EXPLANATION,
	 			ITEM.PRICE, 
	 			ITEM.RECOMMEND_FLG, 
	 			ITEM.LAST_UPDATE_DATE_TIME,
	 			ITEM_CATEGORY.ITEM_CATEGORY_NAME,
	 			FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE
	 			WHERE ITEM_CATEGORY.ITEM_CATEGORY_CODE = "XXX" AND ITEM.ITEM_NAME LIKE "%YYY%"
	 			
	 			  "select * from " + ADMIN_USER_TABLE_NAME + " where " + ADMIN_ID_COLUMN_NAME + "=? and " + PASSWORD_COLUMN_NAME + "=?");
	 	*/
	 	
	 	PreparedStatement st;
	 	st=con.prepareStatement(
	 		"SELECT ITEM.ITEM_NO AS ITEM_NO, "+
	 		"ITEM.ITEM_CATEGORY_CODE AS ITEM_CATEGORY_CODE, "+
	 		"ITEM.ITEM_NAME AS ITEM_NAME, "+
	 		"ITEM.EXPLANATION AS EXPLANATION, "+
	 		"ITEM.PRICE AS PRICE, "+
	 		"ITEM.RECOMMEND_FLG AS RECOMMEND_FLG, "+
	 		"ITEM.LAST_UPDATE_DATE_TIME AS LAST_UPDATE_DATE_TIME," +
	 		"ITEM_CATEGORY.ITEM_CATEGORY_NAME AS ITEM_CATEGORY_NAME " + 
	 		"FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE "+
	 		"WHERE ITEM_CATEGORY.ITEM_CATEGORY_CODE = ? AND ITEM.ITEM_NAME LIKE ?");
	 		
	 		st.setString(1, itemCategoryCode);
	 		st.setString(2, "%" + itemName + "%");
	 		System.out.println(st.toString());
	 		ResultSet rs=st.executeQuery();
	 		
	 		while (rs.next()) {
	 			Item item=new Item();
	 			item.setItemNo(String.valueOf(rs.getInt(ITEM_NO_COLUMN_NAME)));
	 			item.setItemCategoryCode(rs.getString(ITEM_CATEGORY_CODE_COLUMN_NAME));
	 			item.setItemName(rs.getString(ITEM_NAME_COLUMN_NAME));
	 			item.setExplanation(rs.getString(EXPLANATION_COLUMN_NAME));
	 			item.setPrice(String.valueOf(rs.getInt(PRICE_COLUMN_NAME)));
	 			item.setRecommendFlg(rs.getString(RECOMMEND_FLG_COLUMN_NAME));
	 			item.setLastUpdateDateTime(rs.getTimestamp(LAST_UPDATE_DATE_TIME_COLUMN_NAME));
	 			item.setItemCategoryName(rs.getString(ITEM_CATEGORY_NAME_COLUMN_NAME));
	 			list.add(item);
	 		}
	 		st.close();
	 		con.close();
	 		return list; 
	 }	
	 	
	public List<Item> selectByItemName(String itemName)
	 throws NamingException, SQLException {
	 	List<Item> list = new ArrayList<>();
	 	
	 	Connection con = getConnection();
	 	
	 	PreparedStatement st;
	 	st=con.prepareStatement(
	 		"SELECT ITEM.ITEM_NO AS ITEM_NO, "+
	 		"ITEM.ITEM_CATEGORY_CODE AS ITEM_CATEGORY_CODE, "+
	 		"ITEM.ITEM_NAME AS ITEM_NAME, "+
	 		"ITEM.EXPLANATION AS EXPLANATION, "+
	 		"ITEM.PRICE AS PRICE, "+
	 		"ITEM.RECOMMEND_FLG AS RECOMMEND_FLG, "+
	 		"ITEM.LAST_UPDATE_DATE_TIME AS LAST_UPDATE_DATE_TIME," +
	 		"ITEM_CATEGORY.ITEM_CATEGORY_NAME AS ITEM_CATEGORY_NAME " + 
	 		"FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE "+
	 		"WHERE ITEM.ITEM_NAME LIKE ?");
	 		
	 		st.setString(1, "%" + itemName + "%");
	 		ResultSet rs=st.executeQuery();
	 		
	 		while (rs.next()) {
				Item item=new Item();
	 			item.setItemNo(String.valueOf(rs.getInt(ITEM_NO_COLUMN_NAME)));
	 			item.setItemCategoryCode(rs.getString(ITEM_CATEGORY_CODE_COLUMN_NAME));
	 			item.setItemName(rs.getString(ITEM_NAME_COLUMN_NAME));
	 			item.setExplanation(rs.getString(EXPLANATION_COLUMN_NAME));
	 			item.setPrice(String.valueOf(rs.getInt(PRICE_COLUMN_NAME)));
	 			item.setRecommendFlg(rs.getString(RECOMMEND_FLG_COLUMN_NAME));
	 			item.setLastUpdateDateTime(rs.getTimestamp(LAST_UPDATE_DATE_TIME_COLUMN_NAME));
	 			item.setItemCategoryName(rs.getString(ITEM_CATEGORY_NAME_COLUMN_NAME));
	 			list.add(item);
	 		}
	 		st.close();
	 		con.close();
	 		return list; 
		}	
	
	public List<Item> selectByItemCategoryCode(String itemCategoryCode)
	throws NamingException, SQLException {
	 	List<Item> list = new ArrayList<>();
	 	
	 	Connection con = getConnection();
	 	
	 	/**
	 	 * 	SELECT ITEM.ITEM_NO, 
	 			ITEM.ITEM_CATEGORY_CODE, 
	 			ITEM.ITEM_NAME, 
	 			ITEM.EXPLANATION,
	 			ITEM.PRICE, 
	 			ITEM.RECOMMEND_FLG, 
	 			ITEM.LAST_UPDATE_DATE_TIME,
	 			ITEM_CATEGORY.ITEM_CATEGORY_NAME,
	 			FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE
	 			WHERE ITEM_CATEGORY.ITEM_CATEGORY_CODE = "XXX"
	 			*/
	 			
	 	PreparedStatement st;
	 	st=con.prepareStatement(
	 		"SELECT ITEM.ITEM_NO AS ITEM_NO, "+
	 		"ITEM.ITEM_CATEGORY_CODE AS ITEM_CATEGORY_CODE, "+
	 		"ITEM.ITEM_NAME AS ITEM_NAME, "+
	 		"ITEM.EXPLANATION AS EXPLANATION, "+
	 		"ITEM.PRICE AS PRICE, "+
	 		"ITEM.RECOMMEND_FLG AS RECOMMEND_FLG, "+
	 		"ITEM.LAST_UPDATE_DATE_TIME AS LAST_UPDATE_DATE_TIME," +
	 		"ITEM_CATEGORY.ITEM_CATEGORY_NAME AS ITEM_CATEGORY_NAME " + 
	 		"FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE "+
	 		"WHERE ITEM_CATEGORY.ITEM_CATEGORY_CODE = ?");
	 		
	 		st.setString(1, itemCategoryCode);
	 		ResultSet rs=st.executeQuery();
	 		
	 		while (rs.next()) {
	 			Item item=new Item();
	 			item.setItemNo(String.valueOf(rs.getInt(ITEM_NO_COLUMN_NAME)));
	 			item.setItemCategoryCode(rs.getString(ITEM_CATEGORY_CODE_COLUMN_NAME));
	 			item.setItemName(rs.getString(ITEM_NAME_COLUMN_NAME));
	 			item.setExplanation(rs.getString(EXPLANATION_COLUMN_NAME));
	 			item.setPrice(String.valueOf(rs.getInt(PRICE_COLUMN_NAME)));
	 			item.setRecommendFlg(rs.getString(RECOMMEND_FLG_COLUMN_NAME));
	 			item.setLastUpdateDateTime(rs.getTimestamp(LAST_UPDATE_DATE_TIME_COLUMN_NAME));
	 			item.setItemCategoryName(rs.getString(ITEM_CATEGORY_NAME_COLUMN_NAME));
	 			list.add(item);
	 		}
	 		st.close();
	 		con.close();
	 		return list; 
	}
	
	public List<Item> selectAll()
	throws NamingException, SQLException {
	 	List<Item> list = new ArrayList<>();
	 	
	 	Connection con = getConnection();
	 	
	 	 /**
	 	 * 	SELECT ITEM.ITEM_NO, 
	 			ITEM.ITEM_CATEGORY_CODE, 
	 			ITEM.ITEM_NAME, 
	 			ITEM.EXPLANATION,
	 			ITEM.PRICE, 
	 			ITEM.RECOMMEND_FLG, 
	 			ITEM.LAST_UPDATE_DATE_TIME,
	 			ITEM_CATEGORY.ITEM_CATEGORY_NAME,
	 			FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE 
	 			*/
	 	
	 	PreparedStatement st;
	 	st=con.prepareStatement(
	 		"SELECT ITEM.ITEM_NO AS ITEM_NO, "+
	 		"ITEM.ITEM_CATEGORY_CODE AS ITEM_CATEGORY_CODE, "+
	 		"ITEM.ITEM_NAME AS ITEM_NAME, "+
	 		"ITEM.EXPLANATION AS EXPLANATION, "+
	 		"ITEM.PRICE AS PRICE, "+
	 		"ITEM.RECOMMEND_FLG AS RECOMMEND_FLG, "+
	 		"ITEM.LAST_UPDATE_DATE_TIME AS LAST_UPDATE_DATE_TIME," +
	 		"ITEM_CATEGORY.ITEM_CATEGORY_NAME AS ITEM_CATEGORY_NAME " + 
	 		"FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE");
	 		
	 		
	 		
	 		ResultSet rs=st.executeQuery();
	 		
	 		while (rs.next()) {
	 			Item item=new Item();
	 			item.setItemNo(String.valueOf(rs.getInt(ITEM_NO_COLUMN_NAME)));
	 			item.setItemCategoryCode(rs.getString(ITEM_CATEGORY_CODE_COLUMN_NAME));
	 			item.setItemName(rs.getString(ITEM_NAME_COLUMN_NAME));
	 			item.setExplanation(rs.getString(EXPLANATION_COLUMN_NAME));
	 			item.setPrice(String.valueOf(rs.getInt(PRICE_COLUMN_NAME)));
	 			item.setRecommendFlg(rs.getString(RECOMMEND_FLG_COLUMN_NAME));
	 			item.setLastUpdateDateTime(rs.getTimestamp(LAST_UPDATE_DATE_TIME_COLUMN_NAME));
	 			item.setItemCategoryName(rs.getString(ITEM_CATEGORY_NAME_COLUMN_NAME));
	 			list.add(item);
	 		}
	 		st.close();
	 		con.close();
	 		return list; 
	}
	
	public Item selectByItemNo(int itemNo)
	throws NamingException, SQLException {
		Connection con = getConnection();
	 	
	 	PreparedStatement st;
	 	st=con.prepareStatement(
	 		"SELECT ITEM.ITEM_NO AS ITEM_NO, "+
	 		"ITEM.ITEM_CATEGORY_CODE AS ITEM_CATEGORY_CODE, "+
	 		"ITEM.ITEM_NAME AS ITEM_NAME, "+
	 		"ITEM.EXPLANATION AS EXPLANATION, "+
	 		"ITEM.PRICE AS PRICE, "+
	 		"ITEM.RECOMMEND_FLG AS RECOMMEND_FLG, "+
	 		"ITEM.LAST_UPDATE_DATE_TIME AS LAST_UPDATE_DATE_TIME," +
	 		"ITEM_CATEGORY.ITEM_CATEGORY_NAME AS ITEM_CATEGORY_NAME " + 
	 		"FROM ITEM JOIN ITEM_CATEGORY ON ITEM.ITEM_CATEGORY_CODE = ITEM_CATEGORY.ITEM_CATEGORY_CODE " +
	 		"WHERE ITEM.ITEM_NO = ?");
	 	
	 	st.setInt(1, itemNo);
	 	System.out.println(st.toString());
	 	ResultSet rs=st.executeQuery();
	 	
	 	Item item = null;
	 		while (rs.next()) {
	 			item=new Item();
	 			item.setItemNo(String.valueOf(rs.getInt(ITEM_NO_COLUMN_NAME)));
	 			item.setItemCategoryCode(rs.getString(ITEM_CATEGORY_CODE_COLUMN_NAME));
	 			item.setItemName(rs.getString(ITEM_NAME_COLUMN_NAME));
	 			item.setExplanation(rs.getString(EXPLANATION_COLUMN_NAME));
	 			item.setPrice(String.valueOf(rs.getInt(PRICE_COLUMN_NAME)));
	 			item.setRecommendFlg(rs.getString(RECOMMEND_FLG_COLUMN_NAME));
	 			item.setLastUpdateDateTime(rs.getTimestamp(LAST_UPDATE_DATE_TIME_COLUMN_NAME));
	 			item.setItemCategoryName(rs.getString(ITEM_CATEGORY_NAME_COLUMN_NAME));
	 		}
	 		st.close();
	 		con.close();
	 		return item; 
		
	}
	
	
	public int insert(Item item) throws NamingException, SQLException  {
		Connection con = getConnection();
	 	PreparedStatement st;
		int line=0;
		
		st = con.prepareStatement("insert into ITEM values(null, ?, ?, ?, ? ,? ,?)");
		st.setString(1, item.getItemCategoryCode());
		st.setString(2, item.getItemName());
		st.setString(3, item.getExplanation());
		st.setInt(4, item.getPriceInt());
		st.setString(5, item.getRecommendFlg());
		st.setDate(6, new java.sql.Date(item.getLastUpdateDateTime().getTime()));
		line = st.executeUpdate();
		
		
		st.close();
		con.close();
		return line;
	}
	
	
	public int update(Item item) throws NamingException, SQLException {
		Connection con = getConnection();
	 	PreparedStatement st;
		int line=0;
		String sql = "UPDATE ITEM SET " + 
		  "ITEM_CATEGORY_CODE=?, " + 
		  "ITEM_NAME=?, " +
		  "EXPLANATION=?, " +
		  "PRICE=?, " +
		  "RECOMMEND_FLG=?, " +
		  "LAST_UPDATE_DATE_TIME=? " +
		  "WHERE ITEM_NO=?";
		st = con.prepareStatement(sql);
		st.setString(1, item.getItemCategoryCode());
		st.setString(2, item.getItemName());
		st.setString(3, item.getExplanation());
		st.setInt(4, item.getPriceInt());
		st.setString(5, item.getRecommendFlg());
		st.setDate(6, new java.sql.Date(item.getLastUpdateDateTime().getTime()));
		st.setInt(7, item.getItemNoInt());
		line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	
	public int deleteByItemNo (int itemNo) throws NamingException, SQLException  {
		Connection con = getConnection();
	 	PreparedStatement st;
		int line=0;
		String sql = "DELETE FROM ITEM WHERE ITEM_NO=?";
		st = con.prepareStatement(sql);
		st.setInt(1, itemNo);
		line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}