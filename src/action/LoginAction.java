package ao.app.productmaster.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import ao.app.productmaster.bean.Admin;
import ao.app.productmaster.dao.AdminDAO;
import ao.app.productmaster.action.Action;
import ao.app.productmaster.tool.ItemManagementException;
import ao.app.productmaster.tool.Constants;

/**
 * ユーザー名とパスワードの組み合わせをチェックする
 * 
 * ・ログイン成功の場合は商品検索画面に遷移させる。
 * ・URLにログイン情報を入れないようにする。
 * 
 * [ログイン失敗の処理仕様]
 * F1.ID未入力の場合→IDを入力してください。とJSPに表示する。
 * F2.パスワード未入力の場合→パスワードを入力してください。とJSPに表示する。
 * F3.どちらも入力されたが、組み合わせがDBに存在しない場合→ID・パスワードが間違っています。とJSPに表示する。
 * F4.エラーメッセージとともに画面を再表示する場合、ユーザIDのみ入力されていたものを保持する。
 */
 
public class LoginAction extends Action {

    private String LOGIN_PAGE_NAME = Constants.PATH_LOGIN_JSP;
    private String SEARCH_PAGE_NAME = "ProduceSearchView.action";

	public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        String adminId=request.getParameter("admin_id"); 
        String password=request.getParameter("password"); 
        
        ArrayList<String> errorMessages = new ArrayList<String>();
        
        
        //入力チェック
		if(adminId==null || adminId=="") {
		    errorMessages.add(Constants.ERROR_MESSAGE_301);
        }  
        
        if(password==null || password=="") {
		    errorMessages.add(Constants.ERROR_MESSAGE_302);
		    request.setAttribute("admin_id", adminId);
        }
        
        if(errorMessages.size() > 0) {
        	request.setAttribute("message", errorMessages);
        	return LOGIN_PAGE_NAME;
        }
        
        
        AdminDAO dao=new AdminDAO();
        Admin admin=dao.selectByIdAndPassword(adminId, password);
        
        //登録チェック
        if(admin==null) {
            errorMessages.add(Constants.ERROR_MESSAGE_303);
        	request.setAttribute("message", errorMessages);
        	request.setAttribute("admin_id", adminId);
        	return LOGIN_PAGE_NAME;
        }
        
        HttpSession session=request.getSession(true);
        session.setAttribute("admin", admin);
		
        return SEARCH_PAGE_NAME;
    }
}