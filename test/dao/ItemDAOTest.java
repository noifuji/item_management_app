package ao.app.productmaster.dao;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import ao.app.productmaster.bean.Item;
import javax.naming.NamingException;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.sql.DataSource;

import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.Context;
import com.mysql.cj.jdbc.MysqlDataSource;

import org.apache.naming.java.javaURLContextFactory;

public class ItemDAOTest {
    
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
    
    private final int itemNo[] = {1, 2, 3, 4, 5};
    private final String itemCategoryCode[] = {"001", "002", "003", "004", "005"};
    private final String itemName[] = {"もものかんづめ", "ローマの休日", "ヘアドライヤー", "どら焼き", "入浴剤"}; 
    private final String Explanation[] = {"さくらももこの名作", "不朽の名作", "マイナスイオンドライヤー", "北海道産あずき使用",  "アロマの香り"};
    private final int Price[] = {1000, 2000, 3000, 500, 700}; 
    private final String recommendFlg[] = {"0", "1", "0", "1", "0"};
    private final String lastUpdateDateTime[] = {"2020/12/24 23:59:59", "2020/12/24 23:59:59", "2020/12/24 23:59:59"
    , "2020/12/24 23:59:59", "2020/12/24 23:59:59"}; 
    
    //テストケース1：Itemテーブルに保存されている情報の一覧をList<Item> selectAll()で表示できることを確認する
    @Test
    public void testCase1() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        List<Item> itemList = dao.selectAll(); //メソッド実行
        
        //assertEquals(想定される値, 実際に得られた値)
        //一致していればテストはパスし、一致しなければテストは失敗する。
        for(int i = 0; i < itemList.size(); i++) {
            assertEquals(itemNo[i], itemList.get(i).getItemNo());
            assertEquals(itemCategoryCode[i], itemList.get(i).getItemCategoryCode());
            assertEquals(itemName[i], itemList.get(i).getItemName());
            assertEquals(Explanation[i], itemList.get(i).getExplanation());
            assertEquals(Price[i], itemList.get(i).getPrice());
            assertEquals(recommendFlg[i], itemList.get(i).getRecommendFlg());
            String strDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(itemList.get(i).getLastUpdateDateTime());
            assertEquals(lastUpdateDateTime[i], strDate);
        }
        
        
    }
    
    //テストケース2：商品分類コードが一致する商品をList<Item> selectByItemCategoryCode(String itemCategoryCode)で取得できることを確認する
    @Test
    public void testCase2() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        List<Item> itemList  = dao.selectByItemCategoryCode(itemCategoryCode[0]); //メソッド実行
        
        int i = 0;
        assertEquals(itemNo[0],  itemList.get(0).getItemNo());
        assertEquals(itemCategoryCode[0], itemList.get(0).getItemCategoryCode());
        assertEquals(itemName[0], itemList.get(0).getItemName());
        assertEquals(Explanation[0], itemList.get(0).getExplanation());
        assertEquals(Price[0], itemList.get(0).getPrice());
        assertEquals(recommendFlg[0], itemList.get(i).getRecommendFlg());
        String strDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(itemList.get(0).getLastUpdateDateTime());
        assertEquals(lastUpdateDateTime[0], strDate);
    
  }
  
  //テストケース3: selectByItemCategoryCodeテーブルに登録していない商品分類コー入力した場合
  @Test
    public void testCase3() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        List<Item> itemList  = dao.selectByItemCategoryCode("009");
        
        //どういう結果が想定されますか?
        assertEquals(0, itemList.size());
        
  }
  
  //テストケース4:selectByItemNameで該当する商品が取得できる
  @Test
    public void testCase4() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        List<Item> itemList  = dao.selectByItemName("ローマ");
        
        assertEquals(itemNo[1],             itemList.get(0).getItemNo());
        assertEquals(itemCategoryCode[1],   itemList.get(0).getItemCategoryCode());
        assertEquals(itemName[1],           itemList.get(0).getItemName());
        assertEquals(Explanation[1],        itemList.get(0).getExplanation());
        assertEquals(Price[1],              itemList.get(0).getPrice());
        assertEquals(recommendFlg[1],       itemList.get(0).getRecommendFlg());
        String strDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(itemList.get(0).getLastUpdateDateTime());
        assertEquals(lastUpdateDateTime[1], strDate);
    
  }
  //テストケース5:selectByItemNameでテーブルに登録していない商品名を入力した場合
  @Test
    public void testCase5() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        List<Item> itemList  = dao.selectByItemName("ののののののの");
        
        assertEquals(0, itemList.size());
  }
  
  //テストケース6:selectByItemCategoryCodeAndItemNameで該当する商品が取得できる。
  @Test
    public void testCase6() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        List<Item> itemList  = dao.selectByItemCategoryCodeAndItemName("002", "ローマ");
        
        assertEquals(itemNo[1],             itemList.get(0).getItemNo());
        assertEquals(itemCategoryCode[1],   itemList.get(0).getItemCategoryCode());
        assertEquals(itemName[1],           itemList.get(0).getItemName());
        assertEquals(Explanation[1],        itemList.get(0).getExplanation());
        assertEquals(Price[1],              itemList.get(0).getPrice());
        assertEquals(recommendFlg[1],       itemList.get(0).getRecommendFlg());
        String strDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(itemList.get(0).getLastUpdateDateTime());
        assertEquals(lastUpdateDateTime[1], strDate);
    
  }
  
  //テストケース7:selectByItemCategoryCodeAndItemNameでテーブルに登録していない商品名を入力した場合
  @Test
    public void testCase7() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        List<Item> itemList  = dao.selectByItemCategoryCodeAndItemName("002", "ああああああ");
        
        assertEquals(0, itemList.size());
  }
  
  //テストケース8:selectByItemNoで正常に取得できる
  @Test
    public void testCase8() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        Item item  = dao.selectByItemNo(1);
        
        assertEquals("もものかんづめ", item.getItemName());
  }
  
  //テストケース9:selectByItemNoで登録してないやつでNULLになる
  @Test
    public void testCase9() throws NamingException, SQLException {
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        Item item  = dao.selectByItemNo(9999);
        
        assertEquals(null, item);
  }
  
  //テストケース10:selectByItemNoで登録してないやつでNULLになる
  @Test
    public void testCase10() throws NamingException, SQLException {
        Item item = new Item();
        item.setItemName("あああ");
        item.setItemCategoryCode("001");
        item.setExplanation("ていてすいすは");
        item.setPrice(10000000);
        item.setRecommendFlg("0");
        item.setLastUpdateDateTime(new Date());
        ItemDAO dao = new ItemDAO();//テスト対象であるItemDAOクラスのインスタンスを生成
        int line  = dao.insert(item);
        
        assertEquals(1, line);
  }
  
  
}