<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ao.app.productmaster.bean.Item" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/sample/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>商品情報詳細画面</title>
 </head>

 <body>
 	<div class="header">
 		<h1>商品情報詳細</h1>
	</div>

	<div>
	<% 
	  Item item = (Item)request.getAttribute("item_detail");
	  if (item != null) {
 	        String price = String.format("%,d", item.getPrice());
 	        String recommendFlg = item.getRecommendFlg().equals("1") ? "★" : "-";
	%>
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
		 <td class="left-side">説明</td><td class="explanation"><%=item.getExplanation()%></td>
		</tr>
		<tr>
		 <td class="left-side">価格</td><td class="price"><%=price%>円</td>
		</tr>
		<tr>
		 <td class="left-side">おすすめ</td><td><%=recommendFlg%></td>
		</tr>
		<tr>
		 <td class="left-side">最終更新日時</td><td><%=item.getLastUpdateDateTime()%></td>
		</tr>
	</table>
	<% } %>
  </div>

  <div class="choice">
  　<form method="post" action="ProduceSearchView.action">
  　　<input class="back" type="submit" value="戻る">
  　</form>
   <input class="modify" type="submit" value="変更">
   <input class="delete" type="submit" value="削除">
  </div>


<p><a href="A04-1.html">ここをクリックすると飛びます。</a></p>

 </body>
</html>