<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>ログイン画面</title>
 </head>

 <body>
  <div class="login_header">
  	<h1>クオンツ市場　商品マスタ管理</h1>
	  <h1>管理者ログイン</h1>
  </div>
  
  <div class="login_main">
    <%
      List<String> mes = (List)request.getAttribute("message");
      if(mes != null && mes.size() > 0) {
    %>
      <div class="login_error">
      
        <p>エラー<p>
        <% for(String error : mes){ %>
        <p>・<%=error%></p>
        <% } %>
      
      
      </div>
    <%}%>

    <div class="login_form">
      <form action="Login.action" method="post">
        <!--Login.actionはFrontController.javaのurlPatternsで定めたURL -->
        <!--methodをpostで指定しておく。HTTPのPOST方式でリクエストが送られる。FrontController.javaでは、doPostで処理が行われる。-->
        <%
        String lastAdminId = "";
        if(request.getAttribute("admin_id") != null) {
          lastAdminId = request.getAttribute("admin_id").toString();
        }
        %>
        <p>ユーザID<input type="text" name="admin_id" value="<%= lastAdminId %>"></p>
	       <p>パスワード<input type="password" name="password"></p> 
	       <button class="submit_button" type="submit" value="ログイン">ログイン</button> 
      </form>
　  </div>
　</div>
 </body>
</html>