<%@page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/sample/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>ログイン画面</title>
 </head>

 <body>
  <div class="top">
  	<h1>クオンツ市場　商品マスタ管理</h1>
	  <h1 class="second-head">管理者ログイン</h1>
  </div>
  
  <div class="login_container">
  
    <div class="login_error">
      <%
        String mes1 = (String)request.getAttribute("message1");
        String mes2 = (String)request.getAttribute("message2");
        String mes3 = (String)request.getAttribute("message3");
        if(mes1 != null || mes2 != null || mes3 != null) {
      %>
      エラー
      <%}%>
      <% if(mes1 != null){ %>
      <p>・<%=mes1%></p>
      <% } %>
   
      <% if(mes2 != null){ %>
      <p>・<%=mes2%></p>
      <% } %>
  
      <% if(mes3 != null){ %>
      <p>・<%=mes3%></p>
      <% } %>
    </div>

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
　<div class="login_container">
 </body>
</html>