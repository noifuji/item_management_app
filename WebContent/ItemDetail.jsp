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
 		<h1 class="page-title">商品情報詳細</h1>
	</div>

	<div class="main">
	<% 
	  Item item = (Item)request.getAttribute("item_detail");
	  if (item != null) {
 	        String price = String.format("%,d", item.getPriceInt());
 	        String recommendFlg = item.getRecommendFlg().equals("1") ? "おすすめ商品" : "通常商品";
 	        String explanation = item.getExplanation();
            explanation = explanation.replaceAll("\\r\\n|\\n\\r|\\n|\r", "<br>");
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
		 <td class="left-side">説明</td><td class="explanation"><%=explanation%></td>
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
  　<form method="post" class="form_back" action="ProduceSearchView.action">
  　　<input class="submit_button" type="submit" value="戻る">
  　</form>
  　
  　<form method="post" class="form_delete" action="ProduceDeleteItemConfirmView.action">
      <input type="hidden" name="item_no" value="<%=item.getItemNo()%>">
      <input type="hidden" name="item_category_code" value="<%=item.getItemCategoryCode()%>">
      <input type="hidden" name="item_category_name" value="<%=item.getItemCategoryName()%>">
      <input type="hidden" name="item_name" value="<%=item.getItemName()%>">
      <input type="hidden" name="item_explanation" value="<%=item.getExplanation()%>">
      <input type="hidden" name="item_price" value="<%=item.getPrice()%>">
      <input type="hidden" name="item_recommend_flg" value="<%=item.getRecommendFlg()%>">
      <input class="submit_button" type="submit" value="削除">
    </form>
    
    
  　<form method="post" class="form_modify" action="ProduceUpdateItemView.action">
      <input type="hidden" name="item_no" value="<%=item.getItemNo()%>">
      <input class="submit_button"  type="submit" value="変更">
    </form>
  　
  </div>

 </body>
</html>