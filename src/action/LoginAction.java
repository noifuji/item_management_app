package ao.app.productmaster.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ao.app.productmaster.bean.Admin;
import ao.app.productmaster.dao.AdminDAO;
import ao.app.productmaster.action.Action;

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

    private String LOGIN_PAGE_NAME = "Login.jsp";
    private String SEARCH_PAGE_NAME = "ProduceSearchView.action";

	public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        HttpSession session=request.getSession();
        String adminId=request.getParameter("admin_id"); //<input type="text" name="admin_id">に入力された値を取得する。
        String password=request.getParameter("password"); //input type="text" name="password">に入力された値を取得する。
		
		if(adminId=="" && password=="") {
            request.setAttribute("message1", "ユーザIDを入力してください。");
            request.setAttribute("message2", "パスワードを入力してください。");
            return LOGIN_PAGE_NAME;
        }
        
		if(adminId==null || adminId=="") {
        	request.setAttribute("message1", "ユーザIDを入力してください。");
        	return LOGIN_PAGE_NAME;
        }  
        
        if(password==null || password=="") {
        	 request.setAttribute("message2", "パスワードを入力してください。");
        	 request.setAttribute("admin_id", adminId);
        	 return LOGIN_PAGE_NAME;
        }

        AdminDAO dao=new AdminDAO();
        Admin admin=dao.selectByIdAndPassword(adminId, password); 

        if(admin==null) {
        	request.setAttribute("message3", "ユーザID・パスワードが間違っています。");
        	request.setAttribute("admin_id", adminId);
        	return LOGIN_PAGE_NAME;
        }
        
        
        
        session.setAttribute("admin", admin);
		
        return SEARCH_PAGE_NAME;
    }
}