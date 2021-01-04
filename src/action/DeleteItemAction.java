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
public class DeleteItemAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException , ItemManagementException{
            HttpSession session=request.getSession(false);
            if(session == null) {
                throw new ItemManagementException(Constants.ERROR_MESSAGE_401);
            }
            
            String item_no = request.getParameter("item_no");
            
            ItemDAO dao = new ItemDAO();
            int line  = dao.deleteByItemNo(Integer.parseInt(item_no));
             
             return "DeleteItemCompleted.jsp";
        }
}
