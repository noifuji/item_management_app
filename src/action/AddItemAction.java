package ao.app.productmaster.action;

import java.util.List;
import java.util.Date;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.app.productmaster.bean.Item;
import ao.app.productmaster.dao.ItemDAO;
import ao.app.productmaster.action.Action;

/**
 * ItemCategoryテーブルに登録されている商品分類コード・商品分類名の一覧を表示させる
 * 
 */
public class AddItemAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException {
            
            Item item = new Item();
            item.setItemName(request.getParameter("item_name"));
            item.setItemCategoryCode(request.getParameter("item_category_code"));
            item.setExplanation(request.getParameter("item_explanation"));
            item.setPrice(Integer.parseInt(request.getParameter("item_price")));
            item.setRecommendFlg(request.getParameter("item_recommend_flg"));
            item.setLastUpdateDateTime(new Date());
            
            ItemDAO dao = new ItemDAO();
            int line  = dao.insert(item);
             
             return "AddItemCompleted.jsp";
        }
}
