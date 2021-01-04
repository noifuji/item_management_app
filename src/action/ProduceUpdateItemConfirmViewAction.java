package ao.app.productmaster.action;

import java.util.List;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.app.productmaster.bean.Item;
import ao.app.productmaster.bean.ItemCategory;
import ao.app.productmaster.dao.ItemDAO;
import ao.app.productmaster.dao.ItemCategoryDAO;
import ao.app.productmaster.action.Action;
import ao.app.productmaster.tool.Util;
import ao.app.productmaster.tool.ItemManagementException;
import ao.app.productmaster.tool.Constants;

/**
 * 新規商品登録の確認画面を表示する。
 * 
 */
public class ProduceUpdateItemConfirmViewAction extends Action {
    private String ERROR_PAGE_NAME = "UpdateItem.jsp";
    private String NEXT_PAGE_NAME = "UpdateItemConfirm.jsp";
    
    public String execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws SQLException, NamingException, ItemManagementException {
            
            HttpSession session=request.getSession(false);
            if(session == null) {
                throw new ItemManagementException(Constants.ERROR_MESSAGE_401);
            }
            
            ItemCategoryDAO dao = new ItemCategoryDAO();
            List<ItemCategory> itemCategoryList = dao.selectAll();
            
            Item updateItem = new Item();
            updateItem.setItemNo(request.getParameter("item_no"));
            updateItem.setItemName(request.getParameter("item_name"));
            updateItem.setItemCategoryCode(request.getParameter("item_category_code"));
            updateItem.setExplanation(request.getParameter("item_explanation"));
            updateItem.setPrice(request.getParameter("item_price"));
            updateItem.setRecommendFlg(request.getParameter("item_recommend_flg") != null ? "1" : "0");
            
            for(ItemCategory ic : itemCategoryList) {
                if(ic.getItemCategoryCode().equals(updateItem.getItemCategoryCode())) {
                    updateItem.setItemCategoryName(ic.getItemCategoryName());
                }
            }
            
            session.setAttribute("update_item", updateItem);
            
            String validationResult = validateItem(updateItem);
            
            if(validationResult != null) {
                request.setAttribute("message", validationResult);
                request.setAttribute("item_category_list", itemCategoryList);
                return ERROR_PAGE_NAME;
            }
             
             return NEXT_PAGE_NAME;
        }
        
        private String validateItem(Item item) throws SQLException, NamingException{
            String itemNo = item.getItemNo();
            String itemName = item.getItemName();
            String itemCategoryCode = item.getItemCategoryCode();
            String itemExplanation = item.getExplanation();
            String price = item.getPrice();
            
            ItemCategoryDAO dao = new ItemCategoryDAO();
            List<ItemCategory> itemCategoryList = dao.selectAll();
            
            if (itemCategoryCode == null || itemCategoryCode.equals("")) {
                return Constants.ERROR_MESSAGE_001;
            }
            
            Boolean isItemCategoryDefined = false;
            for(ItemCategory ic : itemCategoryList) {
                if(ic.getItemCategoryCode().equals(itemCategoryCode)) {
                    isItemCategoryDefined = true;
                }
            }
            
            if(!isItemCategoryDefined) {
                return Constants.ERROR_MESSAGE_201;
            }
            
            if (itemName == null || itemName.equals("")) {
                return Constants.ERROR_MESSAGE_002;
            }
            
            
            if (itemName.length() > Constants.MAX_LENGTH_ITEM_NAME) {
                return Constants.ERROR_MESSAGE_101;
            }
            
            ItemDAO itemDao = new ItemDAO();
            List<Item> itemList = itemDao.selectByItemName(itemName);
            Boolean isItemNameDefined = false;
            for(Item i : itemList) {
                //自身のレコードは除く必要がある。
                if(i.getItemName().equals(itemName) && !i.getItemNo().equals(itemNo)) {
                    isItemNameDefined = true;
                }
            }
            
            if(isItemNameDefined) {
                return Constants.ERROR_MESSAGE_202;
            }
            
            if (itemExplanation == null || itemExplanation.equals("")) {
                return Constants.ERROR_MESSAGE_003;
            }
            
            if (itemExplanation.length() > Constants.MAX_LENGTH_ITEM_EXPLANATION) {
                return Constants.ERROR_MESSAGE_102;
            }
            
            if (price == null || price.equals("")) {
                return Constants.ERROR_MESSAGE_004;
            }
            
            if (price.length() > Constants.MAX_LENGTH_ITEM_PRICE) {
                return Constants.ERROR_MESSAGE_103;
            }
            
            if (!Util.isHalfNumeric(price)) {
                return Constants.ERROR_MESSAGE_104;
            }
            
            return null;
    }
}
