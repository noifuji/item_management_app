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

  <div class="login-form">
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
	   <!--サーバー側でrequest.getParameter("admin_id")でとりだせる-->
	   <p>パスワード<input type="password" name="password"></p>
	   <!--サーバー側でrequest.getParameter("password")でとりだせる-->
	   <button class="login" type="submit" value="ログイン">ログイン</button>
	   <!--submit指定があるので、form内のinputに入力された情報をサーバーへ送る。-->
   </form>
　</div>

  <div class="error">
   
  <% if(request.getAttribute("message1") != null){ %>
  <%= request.getAttribute("message1") %>
  <% } %>
   
  <% if(request.getAttribute("message2") != null){ %>
  <%= request.getAttribute("message2") %>
  <% } %>
  
  <% if(request.getAttribute("message3") != null){ %>
  <%= request.getAttribute("message3") %>
  <% } %>
  </div>
 </body>
</html>