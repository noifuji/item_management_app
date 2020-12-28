package ao.app.productmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import ao.app.productmaster.bean.Admin;
import ao.app.productmaster.dao.DAO;


/**
 * Adminの情報をデータベースに問い合わせて結果を返却する
 * 
 */
public class AdminDAO extends DAO {
    private String ADMIN_ID_COLUMN_NAME = "ADMIN_ID";
    private String PASSWORD_COLUMN_NAME = "PASSWORD";
    private String ADMIN_USER_TABLE_NAME = "ADMIN_USER";
    public Admin selectByIdAndPassword (String adminId, String password)
        throws NamingException, SQLException {
        Admin admin = null;

        Connection con = getConnection();

        PreparedStatement st;
        st=con.prepareStatement(
            "select * from " + ADMIN_USER_TABLE_NAME + " where " + ADMIN_ID_COLUMN_NAME + "=? and " + PASSWORD_COLUMN_NAME + "=?");
            
        st.setString(1, adminId);
        st.setString(2, password);
        ResultSet rs=st.executeQuery();

        while (rs.next()) {
            admin=new Admin();
            admin.setAdminId(rs.getString(ADMIN_ID_COLUMN_NAME));
            admin.setPassword(rs.getString(PASSWORD_COLUMN_NAME));
        }

        st.close();
        con.close();
        return admin;
    }
}