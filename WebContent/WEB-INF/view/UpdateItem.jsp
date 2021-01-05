<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ao.app.productmaster.bean.ItemCategory" %>
<%@ page import="ao.app.productmaster.bean.Item" %>
<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <link href="/ItemManagement/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>商品情報変更入力画面</title>
 </head>

  <body>
 	<div class="header">
 		<h1 class="page-title">商品情報変更入力</h1>
	</div>
	
	<div class="error_message">
      <% if(request.getAttribute("message") != null){ %>
      <p>エラー</p>
      <p>・<%= request.getAttribute("message") %></p>
      <% } %>
    </div>

	<div class="main">
	<%
	String itemNo = "";
	String itemName = "";
    String itemCategoryCode = "";
    String itemExplanation =  "";
    String price = "";
    String itemRecommendFlg = "";
	
	if(session.getAttribute("update_item") != null) {
	  Item updateItem = (Item)session.getAttribute("update_item");
	  itemNo = updateItem.getItemNo() != null ? updateItem.getItemNo() : "";
	  itemName = updateItem.getItemName() != null ? updateItem.getItemName() : "";
	  itemCategoryCode = updateItem.getItemCategoryCode() != null ? updateItem.getItemCategoryCode() : "";
      itemExplanation =  updateItem.getExplanation() != null ? updateItem.getExplanation() : "";
      price = updateItem.getPrice() != null ? updateItem.getPrice() : "";
      itemRecommendFlg = updateItem.getRecommendFlg().equals("1") ? "checked" : "";
	}

	%>
      <form id="item_info" action="ProduceUpdateItemConfirmView.action" method="post">
	    <table class="new-table">
		  <tr>
		    <td class="left-side">商品No</td><td><%=itemNo%></td>
            <input type="hidden" name="item_no" value="<%=itemNo%>">
		  </tr>
		  <tr>
		    <td class="left-side">商品分類<span class="mandatory_text">※必須</span></td><td class="right-side">
		      <select class="pulldown" name="item_category_code">
 			    <option value=""></option>
 			    <%
 			         List<ItemCategory> itemCategories = (List)request.getAttribute("item_category_list");
 			         for (int i =0; i < itemCategories.size(); i++) {%>
 			             <option value="<%=itemCategories.get(i).getItemCategoryCode()%>" 
 			             <%
 			              if(itemCategories.get(i).getItemCategoryCode().equals(itemCategoryCode)) {
 			              %>
 			               <%="selected"%>
 			             <%}%>
 			             
 			             ><%=itemCategories.get(i).getItemCategoryName()%></option>
 			    <%    }%>
 		      </select>
		    </td>
		  </tr>
		  <tr>
  		    <td class="left-side">商品名<span class="mandatory_text">※必須</span></td><td class="right-side"><input class="goods" type="text" name="item_name" value="<%=itemName%>"></td>
		  </tr>
		  <tr>
		    <td class="left-side">説明<span class="mandatory_text">※必須</span></td><td class="right-side"><textarea rows="10" cols="60" name="item_explanation"><%=itemExplanation%></textarea></td>
		  </tr>
		  <tr>
		    <td class="left-side">価格<span class="mandatory_text">※必須</span></td><td class="right-side"><input class="price" type="text" name="item_price" value="<%=price%>">円</td>
		  </tr>
		  <tr>
		    <td class="left-side">おすすめ</td><td class="right-side"><input class="recommend" name="item_recommend_flg" type="checkbox" value="1" <%=itemRecommendFlg%>>おすすめ商品にする</td>
	  	  </tr>
	    </table>
	  </form>
    </div>

  <div class="choice">
    <form method="post" class="form_back" action="ProduceItemDetailView.action">
      <input type="hidden" name="item_no" value="<%=itemNo%>">
      <input class="submit_button" type="submit" value="戻る">
    </form>
    <div class="form_register">
      <input class="submit_button" type="submit" form="item_info" value="確認">
    </div>
  </div>
  
　</body>
</html>