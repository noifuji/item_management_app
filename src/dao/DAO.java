package ao.app.productmaster.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.NamingException;
import java.sql.SQLException;

/**
 * データベースへのコネクションを生成する
 * 
 */
 
public class DAO {
    static DataSource ds;

    public Connection getConnection() throws NamingException, SQLException {
        if (ds==null) {
            InitialContext ic=new InitialContext();
            // java:/compの/ 必要かどうかチェック
            ds=(DataSource)ic.lookup("java:comp/env/jdbc/myapp");
        }
        
        return ds.getConnection();
    }
}