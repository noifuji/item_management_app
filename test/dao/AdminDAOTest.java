package ao.app.productmaster.dao;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import ao.app.productmaster.bean.Admin;
import javax.naming.NamingException;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import javax.naming.InitialContext;
import javax.naming.Context;
import com.mysql.cj.jdbc.MysqlDataSource;

import org.apache.naming.java.javaURLContextFactory;

public class AdminDAOTest {
    
    @BeforeClass //テスト実施前に1度だけ実行されるメソッドという意味です。
    public static void initialize() {
        try{
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
            "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES,
                "org.apache.naming");
            InitialContext tmpIc = new InitialContext();

            tmpIc.createSubcontext("java:");
            tmpIc.createSubcontext("java:comp");
            tmpIc.createSubcontext("java:comp/env");
            tmpIc.createSubcontext("java:comp/env/jdbc");

            final MysqlDataSource tempDs = new MysqlDataSource();
            tempDs.setUrl("jdbc:mysql://localhost:3306/myapp");//このへんでデータベースの情報を設定しています。
            tempDs.setUser("root");
            tempDs.setPassword("secret");
            tmpIc.bind("java:comp/env/jdbc/myapp", tempDs);
        }catch(Exception e) {
            e.printStackTrace();
            assertTrue(false); //例外が発生したらテスト失敗とする。
        }
    }
    
    /**
     * テストケース1:Adminテーブルに一致するデータがあるとき、正常にデータを取得できることを確認する。
     * admin_id = admin
     * password = 00000000
     * 
     */
    @Test
    public void testCase1() throws NamingException, SQLException {
        String ADMIN_ID = "admin"; //正解の情報を定義しています
        String PASSWORD = "00000000"; //正解の情報を定義しています
        
        AdminDAO dao = new AdminDAO();//テスト対象であるAdminDAOクラスのインスタンスを生成
        Admin admin = dao.selectByIdAndPassword(ADMIN_ID, PASSWORD); //メソッド実行
        
        //assertEquals(想定される値, 実際に得られた値)
        //一致していればテストはパスし、一致しなければテストは失敗する。
        assertEquals(ADMIN_ID, admin.getAdminId()); //データベースから得られた結果が想定した値と一致するか確認
        assertEquals(PASSWORD, admin.getPassword()); //データベースから得られた結果が想定した値と一致するか確認
    }
    
    /**
     * テストケース2:IDとパスワード両方が一致していないとき、selectByIdAndPasswordからnullが返却されることを確認する。
     * admin_id = xxx
     * password = yyy
     * 
     */
    @Test
    public void testCase2() throws NamingException, SQLException {
        String ADMIN_ID = "xxx";
        String PASSWORD = "yyy";
        
        AdminDAO dao =new AdminDAO();
        Admin admin = dao.selectByIdAndPassword(ADMIN_ID, PASSWORD);
        
        assertEquals(null, admin);
    }
    
    /**
     * テストケース3:IDのみ一致し、パスワードが一致しないとき、selectByIdAndPasswordからnullが返却されることを確認する。
     * admin_id = admin
     * password = 22222222
     * 
     */
    @Test
    public void testCase3() throws NamingException, SQLException {
        String ADMIN_ID = "admin";
        String PASSWORD = "22222222";
        
        AdminDAO dao =new AdminDAO();
        Admin admin = dao.selectByIdAndPassword(ADMIN_ID, PASSWORD);
        
        assertEquals(null, admin);
    }
    
    /**
     * テストケース4:IDが一致しないで、パスワードのみが一致する場合、selectByIdAndPasswordからnullが返却されることを確認する。
     * admin_id = doraemon
     * password = 11111111
     * 
     */
     @Test
     public void testCase4() throws NamingException, SQLException {
         String ADMIN_ID = "doraemon";
         String PASSWORD = "11111111";
         
         AdminDAO dao =new AdminDAO();
         Admin admin = dao.selectByIdAndPassword(ADMIN_ID, PASSWORD);
         
         assertEquals(null, admin);
    }
}