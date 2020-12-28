package ao.app.productmaster.action;

import java.util.List;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.app.productmaster.bean.ItemCategory;
import ao.app.productmaster.dao.ItemCategoryDAO;
import ao.app.productmaster.action.Action;

/**
 * ItemCategoryテーブルに登録されている商品分類コード・商品分類名の一覧を表示させる
 * 
 */
public class ProduceSearchViewAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException {
            
             HttpSession session=request.getSession();
             
             ItemCategoryDAO dao = new ItemCategoryDAO();
             List<ItemCategory> itemCategory = null;
             
             itemCategory = dao.selectAll();
             
             session.setAttribute ("item_category_list", itemCategory);
             
             return "Search.jsp";
        }
}
