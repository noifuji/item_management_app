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
 * 
 * 
 */
public class UpdateItemAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException, ItemManagementException {
            HttpSession session=request.getSession(false);
            if(session == null) {
                throw new ItemManagementException(Constants.ERROR_MESSAGE_401);
            }
            
            Item item = (Item)session.getAttribute("update_item");
            item.setLastUpdateDateTime(new Date());
            
            ItemDAO dao = new ItemDAO();
            int line  = dao.update(item);
            
            session.removeAttribute("update_item");
            
            request.setAttribute("update_item", item);
             
             return Constants.PATH_UPDATEITEMCOMPLETED_JSP;
        }
}
