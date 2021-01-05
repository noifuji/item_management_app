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
import ao.app.productmaster.bean.ItemCategory;
import ao.app.productmaster.dao.ItemCategoryDAO;
import ao.app.productmaster.tool.ItemManagementException;
import ao.app.productmaster.tool.Constants;

/**
 * 新規商品登録画面を表示させる。
 * 
 */
public class ProduceUpdateItemViewAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException, ItemManagementException {
            HttpSession session=request.getSession(false);
            if(session == null) {
                throw new ItemManagementException(Constants.ERROR_MESSAGE_401);
            }
             
             String item_no=request.getParameter("item_no");
             int itemNo = Integer.parseInt(item_no);
             
             ItemCategoryDAO itemCategoryDao = new ItemCategoryDAO();
             List<ItemCategory> itemCategoryList = itemCategoryDao.selectAll();
             
             if(session.getAttribute("update_item") == null) {
               ItemDAO itemDao = new ItemDAO();
               Item item = itemDao.selectByItemNo(itemNo);
               session.setAttribute("update_item", item);
             }
             
             request.setAttribute("item_category_list", itemCategoryList);
             
             return Constants.PATH_UPDATEITEM_JSP;
        }
}
