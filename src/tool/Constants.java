package ao.app.productmaster.tool;

public class Constants {
    public static int MAX_LENGTH_ITEM_NAME = 100;
    public static int MAX_LENGTH_ITEM_EXPLANATION = 100;
    public static int MAX_LENGTH_ITEM_PRICE = 5;
    
    public static final String ERROR_MESSAGE_001 = "商品分類を入力してください。";
    public static final String ERROR_MESSAGE_002 = "商品名を入力してください。";
    public static final String ERROR_MESSAGE_003 = "商品説明を入力してください。";
    public static final String ERROR_MESSAGE_004 = "価格を入力してください。";
    public static final String ERROR_MESSAGE_101 =  "商品名は100文字までで入力してください。";
    public static final String ERROR_MESSAGE_102 =  "商品説明は100文字までで入力してください。";
    public static final String ERROR_MESSAGE_103 =  "価格は5桁までで入力してください。";
    public static final String ERROR_MESSAGE_104 =  "価格は半角数字で入力してください。";
    public static final String ERROR_MESSAGE_201 =  "商品分類が存在しません。";
    public static final String ERROR_MESSAGE_202 =  "既にその商品は存在します。他の商品名を入力してください。";
    
    
    public static final String ERROR_MESSAGE_301 =  "ユーザIDを入力してください。";
    public static final String ERROR_MESSAGE_302 =  "パスワードを入力してください。";
    public static final String ERROR_MESSAGE_303 =  "ユーザID・パスワードが間違っています。";
    
    public static final String ERROR_MESSAGE_401 =  "セッションがありません。再度ログインしてください。";
    
    //JSPファイルパス
    public static final String PATH_LOGIN_JSP = "/WEB-INF/view/Login.jsp";
    public static final String PATH_SEARCH_JSP = "WEB-INF/view/Search.jsp";
    public static final String PATH_ITEMDETAIL_JSP = "WEB-INF/view/ItemDetail.jsp";
    
    public static final String PATH_ADDITEM_JSP = "WEB-INF/view/AddItem.jsp";
    public static final String PATH_ADDITEMCONFIRM_JSP = "WEB-INF/view/AddItemConfirm.jsp";
    public static final String PATH_ADDITEMCOMPLETED_JSP = "WEB-INF/view/AddItemCompleted.jsp";
    
    public static final String PATH_DELETEITEMCONFIRM_JSP = "WEB-INF/view/DeleteItemConfirm.jsp";
    public static final String PATH_DELETEITEMCOMPLETED_JSP = "WEB-INF/view/DeleteItemCompleted.jsp";
    
    public static final String PATH_UPDATEITEM_JSP = "WEB-INF/view/UpdateItem.jsp";
    public static final String PATH_UPDATEITEMCONFIRM_JSP = "WEB-INF/view/UpdateItemConfirm.jsp";
    public static final String PATH_UPDATEITEMCOMPLETED_JSP = "WEB-INF/view/UpdateItemCompleted.jsp";
}