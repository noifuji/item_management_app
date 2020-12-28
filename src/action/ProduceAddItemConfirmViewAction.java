package ao.app.productmaster.action;

import java.util.List;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.app.productmaster.bean.Item;
import ao.app.productmaster.dao.ItemDAO;
import ao.app.productmaster.action.Action;

/**
 * 新規商品登録の確認画面を表示する。
 * 
 */
public class ProduceAddItemConfirmViewAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException {
            
            Item item = new Item();
            item.setItemName(request.getParameter("item_name"));
            item.setItemCategoryCode(request.getParameter("item_category_code"));
            item.setExplanation(request.getParameter("item_explanation"));
            item.setPrice(Integer.parseInt(request.getParameter("item_price")));
            if (request.getParameter("item_recommend_flg") != null) {
              item.setRecommendFlg("1");
            } else {
              item.setRecommendFlg("0");
            }
            
            request.setAttribute("add_item", item);
             
             return "AddItemConfirm.jsp";
        }
}
