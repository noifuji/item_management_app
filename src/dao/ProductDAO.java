package ao.app.productmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ao.app.productmaster.bean.Product;
import ao.app.productmaster.dao.DAO;

public class ProductDAO extends DAO {

	public List<Product> search(String keyword) throws Exception {
		List<Product> list = new ArrayList<>();
		Connection con=null;
		PreparedStatement st=null;
		try {
			con = getConnection();
			st = con.prepareStatement("select * from item where name like ?");
			st.setString(1, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setItem_no(rs.getInt("item_no"));
				char[] ch = rs.getString("item_category_code").toCharArray();
				p.setItem_category_code(ch[0]);
				p.setItem_name(rs.getString("item_name"));
				p.setExplanation(rs.getString("explanation"));
				p.setPrice(rs.getInt("price"));
				ch = rs.getString("recommend_flg").toCharArray();
				p.setRecommend_flg(ch[0]);
				p.setLast_update_date_time(rs.getDate("last_update_date_time"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}
		return list;
	}

	public int insert(Product product) throws Exception {
		Connection con=null;
		PreparedStatement st=null;
		int line=0;
		try {
			con = getConnection();
			st = con.prepareStatement("insert into item values(null, ?, ?, ?, ? ,? ,? ,?)");

			st.setInt(1, product.getItem_no());
			st.setString(2, String.valueOf(product.getItem_category_code()));
			st.setString(3, product.getItem_name());
			st.setString(4, product.getExplanation());
			st.setInt(5, product.getPrice());
			st.setString(6, String.valueOf(product.getRecommend_flg()));
			st.setDate(7, (java.sql.Date) product.getLast_update_date_time());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}
		return line;
	}

	public void update(Product product) throws Exception {
		Connection con=null;
		PreparedStatement st=null;
		try {
			con = getConnection();
			st = con.prepareStatement("UPDATE item values(null, ?, ?, ?, ? ,? ,? ,?)");

			st.setInt(1, product.getItem_no());
			st.setString(2, String.valueOf(product.getItem_category_code()));
			st.setString(3, product.getItem_name());
			st.setString(4, product.getExplanation());
			st.setInt(5, product.getPrice());
			st.setString(6, String.valueOf(product.getRecommend_flg()));
			st.setDate(7, (java.sql.Date) product.getLast_update_date_time());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}
		return;
	}

	public void deleteOne (Product product) {
		Connection con=null;
        PreparedStatement st=null;
        try {
        	try {
				con = getConnection();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        	st = con.prepareStatement("DELETE item values(null, ?, ?, ?, ? ,? ,? ,?)");

		st.setInt(1, product.getItem_no());
    	st.setString(2, String.valueOf(product.getItem_category_code()));
        st.setString(3, product.getItem_name());
        st.setString(4, product.getExplanation());
        st.setInt(5, product.getPrice());
        st.setString(6, String.valueOf(product.getRecommend_flg()));
        st.setDate(7, (java.sql.Date)product.getLast_update_date_time());
        st.executeUpdate();

       } catch (SQLException e) {
    	   e.printStackTrace();
       } finally {
    	   try {
			st.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	   try {
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
       }
	}
}