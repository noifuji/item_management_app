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
 * ItemCategoryテーブルに登録されている商品分類コード・商品分類名の一覧を表示させる
 * 
 */
public class ProduceItemDetailViewAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException {
            
             HttpSession session=request.getSession();
             int itemNo= Integer.parseInt(request.getParameter("item_no")); 
             
             ItemDAO dao = new ItemDAO();
             Item item = dao.selectByItemNo(itemNo);
             
             request.setAttribute ("item_detail", item);
             
             return "ItemDetail.jsp";
        }
}
