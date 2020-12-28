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
  
  <title>商品情報変更確認画面</title>
  <link rel="stylesheet" href="css/A01-1.css">
 </head>

<body>
 	<div class="header">
 		<h1>商品情報変更確認</h1>
	</div>

	<p class="confirmation">以下の商品情報を変更します。よろしいですか？</p>

	<div>
	  <table class="stock">
		<tr>
		 <td class="left-side">商品No</td><td>S000000001</td>
		</tr>
		<tr>
		 <td class="left-side">商品分類</td><td>書籍</td>
		</tr>
		<tr>
  		 <td class="left-side">商品名</td><td class="product-name">XXXXXXXXXX</td>
		</tr>
		<tr>
		 <td class="left-side">説明</td><td class="explanation">説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明
		 説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明
		 説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明説明</td>
		</tr>
		<tr>
		 <td class="left-side">価格</td><td class="price">2,500円</td>
		</tr>
		<tr>
		 <td class="left-side">おすすめ</td><td>おすすめ商品</td>
		</tr>
	</table>
  </div>

  <div class="choice">
   <input class="back" type="submit" value="戻る">
   <input class="register" type="submit" value="変更">
  </div>