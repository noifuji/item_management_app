package ao.app.productmaster.action;

import java.sql.SQLException;
import javax.naming.NamingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.app.productmaster.bean.Item;
import ao.app.productmaster.bean.ItemCategory;
import ao.app.productmaster.dao.ItemDAO;
import ao.app.productmaster.dao.ItemCategoryDAO;
import ao.app.productmaster.action.Action;
import ao.app.productmaster.tool.ItemManagementException;
import ao.app.productmaster.tool.Constants;

/**
 * 検索された商品分類コード・商品名がProductテーブルに存在するかどうかチェックする
 * [データが存在する場合]
 * 商品検索画面に検索結果を出力する
 * 
 * [商品分類・商品名の両方が未入力の場合]
 * データ全件を取得し表示する。
 * 
 * [該当するデータが無い場合]
 * 「検索条件に該当する商品はありません」とSearch.jspに出力する。
 */

public class SearchAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws SQLException, NamingException, ItemManagementException {

		HttpSession session=request.getSession(false);
            if(session == null) {
                throw new ItemManagementException(Constants.ERROR_MESSAGE_401);
            }
		String itemCategoryCode=request.getParameter("entered_item_category_code"); //商品分類コードで選択された値を取得する
		String itemName=request.getParameter("entered_item_name");//商品名に入力された値を取得する
		session.setAttribute("entered_item_name", itemName);
		session.setAttribute("entered_item_category_code", itemCategoryCode);
		
		ItemCategoryDAO itemCategoryDao = new ItemCategoryDAO();
        List<ItemCategory> itemCategoryList = itemCategoryDao.selectAll();
        request.setAttribute ("item_category_list", itemCategoryList);
		
		ItemDAO dao = new ItemDAO();
		//itemsの定義だけここに移動する
		List<Item> items = null;

		//入力チェックをif文で分岐分け
		if(itemCategoryCode != "" && itemName != "") {//商品分類・商品名共に入力してある場合
			items = dao.selectByItemCategoryCodeAndItemName(itemCategoryCode, itemName);
		}
		else if(itemCategoryCode == "" && itemName != "") {//商品分類コードが空欄・商品名に入力ありの場合
			items = dao.selectByItemName(itemName);
		}
		else if(itemCategoryCode != "" && itemName == "") {//商品分類コードは選択済み・商品名が空欄の場合
			items = dao.selectByItemCategoryCode(itemCategoryCode);
		}
		else if(itemCategoryCode == "" && itemName == "") {//商品分類・商品名共に空欄の場合
			items = dao.selectAll();
		}
		
		if(items.size() == 0) {
			request.setAttribute("message", "検索条件に該当する商品がありません。");
			return Constants.PATH_SEARCH_JSP;
		}
			
		
		request.setAttribute("item_list", items);
		
		return Constants.PATH_SEARCH_JSP; 
   }
}