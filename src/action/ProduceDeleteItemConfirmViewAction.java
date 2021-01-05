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
import ao.app.productmaster.tool.ItemManagementException;
import ao.app.productmaster.tool.Constants;

/**
 * 新規商品登録の確認画面を表示する。
 * 
 */
public class ProduceDeleteItemConfirmViewAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException, ItemManagementException {
            HttpSession session=request.getSession(false);
            if(session == null) {
                throw new ItemManagementException(Constants.ERROR_MESSAGE_401);
            }
            
            String item_no = request.getParameter("item_no");
            Item item = new Item();
            item.setItemNo(item_no);
            item.setItemName(request.getParameter("item_name"));
            item.setItemCategoryCode(request.getParameter("item_category_code"));
            item.setItemCategoryName(request.getParameter("item_category_name"));
            item.setExplanation(request.getParameter("item_explanation"));
            item.setPrice(request.getParameter("item_price"));
            if (request.getParameter("item_recommend_flg") != null) {
              item.setRecommendFlg("1");
            } else {
              item.setRecommendFlg("0");
            }
            
            request.setAttribute("delete_item", item);
             
             return Constants.PATH_DELETEITEMCONFIRM_JSP;
        }
}
