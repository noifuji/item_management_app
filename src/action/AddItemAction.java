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
import ao.app.productmaster.tool.ItemManagementException;
import ao.app.productmaster.tool.Constants;

/**
 * ItemCategoryテーブルに登録されている商品分類コード・商品分類名の一覧を表示させる
 * 
 */
public class AddItemAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException, ItemManagementException{
            
            HttpSession session=request.getSession(false);
            if(session == null) {
                throw new ItemManagementException(Constants.ERROR_MESSAGE_401);
            }
            
            Item item = (Item)session.getAttribute("add_item");
            item.setLastUpdateDateTime(new Date());
            
            ItemDAO dao = new ItemDAO();
            int line  = dao.insert(item);
            
            session.removeAttribute("add_item");
             
            return "AddItemCompleted.jsp";
        }
}
