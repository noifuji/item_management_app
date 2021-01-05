<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ao.app.productmaster.bean.ItemCategory" %>
<%@ page import="ao.app.productmaster.bean.Item" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>商品情報変更完了画面</title>
  <link rel="stylesheet" href="css/A01-1.css">
 </head>
 
 <%
   Item item = (Item)request.getAttribute("update_item");
 %>

 <body>
   <div class="header">
 	   <h1  class="page-title">商品情報変更完了</h1>
 	 </div>
 	 
 	 <div class="guide_message">
 	   <div class="completion">商品情報の変更が完了しました。</div>
 	 </div>
 	 
 	 <div class="choice">
 	   <form action="ProduceItemDetailView.action" method="post">
 	     <input type="hidden" name="item_no" value="<%=item.getItemNoInt()%>">
 	     <input class="submit_button" type="submit" value="詳細へ">
 	   </form>
 	 </div> 
	</body>
</html>