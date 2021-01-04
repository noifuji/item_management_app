package ao.app.productmaster.controller;

import java.io.IOException;
import java.io.PrintWriter;
import ao.app.productmaster.action.Action;
import ao.app.productmaster.action.LoginAction;
import ao.app.productmaster.action.ProduceSearchViewAction;
import ao.app.productmaster.action.ProduceItemDetailViewAction;
import ao.app.productmaster.action.SearchAction;
import ao.app.productmaster.action.ProduceAddItemViewAction;
import ao.app.productmaster.action.ProduceAddItemConfirmViewAction;
import ao.app.productmaster.action.AddItemAction;
import ao.app.productmaster.action.ProduceUpdateItemViewAction;
import ao.app.productmaster.action.ProduceUpdateItemConfirmViewAction;
import ao.app.productmaster.action.UpdateItemAction;
import ao.app.productmaster.action.ProduceDeleteItemConfirmViewAction;
import ao.app.productmaster.action.DeleteItemAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTTPリクエストを受け取る
 * Actionの取得
 * Actionの実行
 * JSPへのフォワード
 */
@WebServlet(urlPatterns={"*.action"}) //http://AAAAAAAAAAAA/ItemManagement/XXXXXX.actionというURLにアクセスされると、このサーブレットが動く
public class FrontController extends HttpServlet {

    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try {
            String path=request.getServletPath().substring(1); //getServletでリクエストされたURLを取得する。
            String name=path.replace(".a", "A").replace('/', '.'); //replaceでpath変数の.aをAに、/を.に置き換えている
            
            //ここでnameの内容を出力してください
            System.out.println("Action Name = [" + name + "]");//こう変更しました。見えないスペースなどがはいっていてもこれならわかります。
            
            //アクション名に応じて分岐する
            //アクション名がLoginのとき、ActionLoginインスタンスを生成する、
            //actionに生成したインスタンスを格納する。
            Action action = null; //初期化
            
            
            if (name.equals("LoginAction")) {//ログイン機能
                action = new LoginAction();
            } else if (name.equals("ProduceSearchViewAction")) {
                action = new ProduceSearchViewAction();
            } else if (name.equals("SearchAction")) {//商品検索機能
                action = new SearchAction();
            } else if (name.equals("ProduceItemDetailViewAction")){
                action = new ProduceItemDetailViewAction();
            } else if (name.equals("ProduceAddItemViewAction")){
                action = new ProduceAddItemViewAction();
            } else if (name.equals("ProduceAddItemConfirmViewAction")){
                action = new ProduceAddItemConfirmViewAction();
            } else if (name.equals("AddItemAction")){
                action = new AddItemAction();
            } else if (name.equals("ProduceUpdateItemViewAction")){
                action = new ProduceUpdateItemViewAction();
            } else if (name.equals("ProduceUpdateItemConfirmViewAction")){
                action = new ProduceUpdateItemConfirmViewAction();
            } else if (name.equals("UpdateItemAction")){
                action = new UpdateItemAction();
            } else if (name.equals("ProduceDeleteItemConfirmViewAction")){
                action = new ProduceDeleteItemConfirmViewAction();
            } else if (name.equals("DeleteItemAction")){
                action = new DeleteItemAction();
            }
            
            String url=action.execute(request, response);
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    public void doGet(
    	HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
    	ServletContext context = getServletContext();
    	RequestDispatcher dispatcher = context.getRequestDispatcher("/Login.jsp");
    	dispatcher.forward(request, response);

    }
}