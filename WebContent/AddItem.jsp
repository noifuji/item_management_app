<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="ao.app.productmaster.bean.ItemCategory" %>

<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="content-Style-Type" content="text/css" />
  <link href="/ItemManagement/sample/css/A01-1.css" rel="stylesheet" type="text/css" />
  <title>商品情報新規登録入力画面</title>
 </head>

  <body>
 	<div class="header">
 		<h1>商品情報新規登録入力</h1>
	</div>
	
	
	<div>
      <form id="item_info" action="ProduceAddItemConfirmView.action" method="post">
	  <table class="new-table">
		<tr>
		 <td class="left-side">商品分類<span>※必須</span></td><td class="right-side">
		   <select class="pulldown" name="item_category_code">
 			   <option value=""></option>
 			   <%
 			         List<ItemCategory> itemCategories = (List)session.getAttribute("item_category_list");
 			         for (int i =0; i < itemCategories.size(); i++) {%>
 			             <option value="<%=itemCategories.get(i).getItemCategoryCode()%>"><%=itemCategories.get(i).getItemCategoryName()%></option>
 			   <%    }%>
 		  </select>
		 </td>
		</tr>
		<tr>
  		 <td class="left-side">商品名<span>※必須</span></td><td class="right-side"><input class="goods"  name="item_name" type="text"></td>
		</tr>
		<tr>
		 <td class="left-side">説明<span>※必須</span></td><td class="right-side"><textarea rows="10"  name="item_explanation" cols="60"></textarea></td>
		</tr>
		<tr>
		 <td class="left-side">価格<span>※必須</span></td><td class="right-side"><input class="price" name ="item_price" type="text">円</td>
		</tr>
		<tr>
		 <td class="left-side">おすすめ</td><td class="right-side"><input class="recommend" type="checkbox" name="item_recommend_flg" value="1">おすすめ商品にする</td>
		</tr>
	</table>
	</form>
  </div>

  <div class="choice">
   <form action="ProduceSearchView.action" method="post">
    <input class="back" type="submit" value="戻る">
   </form>
   <input class="register" type="submit" form="item_info" value="確認">
  </div>
  
  <div class="error-registration">
	<p>エラー</p>
	<p>・XXXXを入力してください。</p>
	<p>・XXXXを入力してください。</p>
    </div>