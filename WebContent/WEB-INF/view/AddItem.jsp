<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ao.app.productmaster.bean.ItemCategory" %>
<%@ page import="ao.app.productmaster.bean.Item" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>商品情報新規登録入力画面</title>
 </head>

  <body>
 	<div class="header">
 		<h1 class="page-title">商品情報新規登録入力</h1>
	</div>
	
	<%
	String itemName = "";
 String itemCategoryCode = "";
 String itemExplanation =  "";
 String price = "";
 String itemRecommendFlg = "";
	
	if(session.getAttribute("add_item") != null) {
	  Item addItem = (Item)session.getAttribute("add_item");
	  itemName = addItem.getItemName() != null ? addItem.getItemName() : "";
	  itemCategoryCode = addItem.getItemCategoryCode() != null ? addItem.getItemCategoryCode() : "";
   itemExplanation =  addItem.getExplanation() != null ? addItem.getExplanation() : "";
   price = addItem.getPrice() != null ? addItem.getPrice() : "";
   itemRecommendFlg = addItem.getRecommendFlg().equals("1") ? "checked" : "";
	}
	%>
	
	<div class="error_message">
      <% if(request.getAttribute("message") != null){ %>
      <p>エラー</p>
      <p>・<%= request.getAttribute("message") %></p>
      <% } %>
  </div>
  
	<div class="main">
  <form id="item_info" action="ProduceAddItemConfirmView.action" method="post">
	 <table class="new-table">
		<tr>
		 <td class="left-side">商品分類<span class="mandatory_text">※必須</span></td><td class="right-side">
		   <select class="pulldown" name="item_category_code">
 			   <option value=""></option>
 			   <%
 			         List<ItemCategory> itemCategories = (List)request.getAttribute("item_category_list");
 			         for (int i =0; i < itemCategories.size(); i++) {%>
 			             <option value="<%=itemCategories.get(i).getItemCategoryCode()%>" 
 			             <%
 			             if (itemCategories.get(i).getItemCategoryCode().equals(itemCategoryCode)) {
 			             %>
 			               <%="selected"%>
 			             <%}%>
 			             ><%=itemCategories.get(i).getItemCategoryName()%></option>
 			   <%    }%>
 		  </select>
		 </td>
		</tr>
		<tr>
  		 <td class="left-side">商品名<span class="mandatory_text">※必須</span></td><td class="right-side"><input class="goods"  name="item_name" type="text" value="<%=itemName%>"></td>
		</tr>
		<tr>
		 <td class="left-side">説明<span class="mandatory_text">※必須</span></td><td class="right-side"><textarea rows="10"  name="item_explanation" cols="60"><%=itemExplanation%></textarea></td>
		</tr>
		<tr>
		 <td class="left-side">価格<span class="mandatory_text">※必須</span></td><td class="right-side"><input class="price" name ="item_price" type="text" value="<%=price%>">円</td>
		</tr>
		<tr>
		 <td class="left-side">おすすめ</td><td class="right-side"><input class="recommend" type="checkbox" name="item_recommend_flg" value="1" <%=itemRecommendFlg%>>おすすめ商品にする</td>
		</tr>
	</table>
	</form>
  </div>

  <div class="choice">
   <form action="ProduceSearchView.action" class="form_back" method="post">
    <input class="back submit_button" type="submit" value="戻る">
   </form>
   <div class="form_register">
    <input class="submit_button" type="submit" form="item_info" value="確認">
   </div>
  </div>
  </body>
</html>