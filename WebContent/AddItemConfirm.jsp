<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ao.app.productmaster.bean.ItemCategory" %>
<%@ page import="ao.app.productmaster.bean.Item" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/sample/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>商品情報新規登録確認画面</title>
  <link rel="stylesheet" href="css/A01-1.css">
 </head>
 
 <%
  Item item = (Item)request.getAttribute("add_item");
  List<ItemCategory> itemCategories = (List)session.getAttribute("item_category_list");
  for (int i =0; i < itemCategories.size(); i++) {
    if(item.getItemCategoryCode().equals(itemCategories.get(i).getItemCategoryCode())) {
    	item.setItemCategoryName(itemCategories.get(i).getItemCategoryName());
    }
  }
  String price = String.format("%,d", item.getPrice());
  String recommendFlg = item.getRecommendFlg().equals("1") ? "★" : "-";
 %>

  <body>
 	<div class="header">
 		<h1>商品情報新規登録確認</h1>
	</div>

	<p class="confirmation">以下の商品情報を登録します。よろしいですか？</p>

	<div>
	 <table class="stock">
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
	</table>
  </div>

  <div class="choice">
  <form action="ProduceAddItemView.action" method="post">
   <input class="back" type="submit" value="戻る">
  </form>
   <form action="AddItem.action" method="post">
     <input type="hidden" name="item_category_code" value="<%=item.getItemCategoryCode()%>">
     <input type="hidden" name="item_name" value="<%=item.getItemName()%>">
     <input type="hidden" name="item_explanation" value="<%=item.getExplanation()%>">
     <input type="hidden" name="item_price" value="<%=item.getPrice()%>">
     <input type="hidden" name="item_recommend_flg" value="<%=item.getRecommendFlg()%>">
     <input class="register" type="submit" value="登録">
   </form>
  </div>
 </body>
</html>