package ao.app.productmaster.dao;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import ao.app.productmaster.bean.ItemCategory;
import javax.naming.NamingException;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;

import javax.naming.InitialContext;
import javax.naming.Context;
import com.mysql.cj.jdbc.MysqlDataSource;

import org.apache.naming.java.javaURLContextFactory;

public class ItemCategoryDAOTest {
    
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
            tempDs.setUrl("jdbc:mysql://localhost:3306/myapptest");//このへんでデータベースの情報を設定しています。
            tempDs.setUser("root");
            tempDs.setPassword("secret");
            tmpIc.bind("java:comp/env/jdbc/myapp", tempDs);
        }catch(Exception e) {
            e.printStackTrace();
            assertTrue(false); //例外が発生したらテスト失敗とする。
        }
    }
    
    //テストケース1: ItemCategoryテーブルに保存されている情報の一覧をList<ItemCategoryCode> selectAll()で表示できることを確認する
    
    @Test
    public void testCase1() throws NamingException, SQLException {
        String Item_Category_Code[] = {"001", "002", "003", "004", "005"}; 
        String Item_Category_Name[] = {"書籍", "DVD", "家電", "食品", "その他"}; 
        
        ItemCategoryDAO dao = new ItemCategoryDAO();
        List<ItemCategory> itemList = dao.selectAll();
        //itemListの各要素を確認していく
        //1.itemListから要素を1つ取り出す
        //2.取り出した要素が事前につめこんだものといっちしているかかくにんする

        assertEquals(Item_Category_Code[0], itemList.get(0).getItemCategoryCode());//です
        assertEquals(Item_Category_Name[0], itemList.get(0).getItemCategoryName());
        assertEquals(Item_Category_Code[1], itemList.get(1).getItemCategoryCode());
        assertEquals(Item_Category_Name[1], itemList.get(1).getItemCategoryName());
        assertEquals(Item_Category_Code[2], itemList.get(2).getItemCategoryCode());
        assertEquals(Item_Category_Name[2], itemList.get(2).getItemCategoryName());
        assertEquals(Item_Category_Code[3], itemList.get(3).getItemCategoryCode());
        assertEquals(Item_Category_Name[3], itemList.get(3).getItemCategoryName());
        assertEquals(Item_Category_Code[4], itemList.get(4).getItemCategoryCode());
        assertEquals(Item_Category_Name[4], itemList.get(4).getItemCategoryName());
    }
    
}