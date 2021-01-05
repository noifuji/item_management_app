<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ao.app.productmaster.bean.Item" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>商品情報削除確認画面</title>
  <link rel="stylesheet" href="css/A01-1.css">
 </head>
 
 <%
  Item item = (Item)request.getAttribute("delete_item");
  String price = String.format("%,d", item.getPriceInt());
  String recommendFlg = item.getRecommendFlg().equals("1") ? "おすすめ商品" : "通常商品";
  String explanation = item.getExplanation();
  explanation = explanation.replaceAll("\\r\\n|\\n\\r|\\n|\r", "<br>");
 %>

 <body>
   <div class="header">
 		  <h1 class="page-title">商品情報削除確認</h1>
	  </div>
	  
	<div class="guide_message">
	  <p class="confirmation">以下の商品情報を削除します。よろしいですか？</p>
	</div>
	
	<div class="main">
	  <table class="stock">
		<tr>
		 <td class="left-side">商品No</td><td><%=item.getItemNo()%></td>
		</tr>
		<tr>
		 <td class="left-side">商品分類</td><td><%=item.getItemCategoryName()%></td>
		</tr>
		<tr>
  		 <td class="left-side">商品名</td><td class="product-name"><%=item.getItemName()%></td>
		</tr>
		<tr>
		 <td class="left-side">説明</td><td class="explanation"><%=explanation%></td>
		</tr>
		<tr>
		 <td class="left-side">価格</td><td class="price"><%=price%>円</td>
		</tr>
		<tr>
		 <td class="left-side">おすすめ</td><td><%=recommendFlg%></td>
		</tr>
	</table>

  </div>
  <div class="choice">
  <form method="post" class="form_back" action="ProduceItemDetailView.action">
     <input type="hidden" name="item_no" value="<%=item.getItemNo()%>">
     <input class="submit_button" type="submit" value="戻る">
   </form>
   <form action="DeleteItem.action" class="form_register" method="post">
     <input type="hidden" name="item_no" value="<%=item.getItemNo()%>">
     <input class="submit_button" type="submit" value="削除">
   </form>
  </div>

</body>
</html>