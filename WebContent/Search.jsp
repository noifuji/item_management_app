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
  <!-- href="/ItemManagement/sample/css/A01-1.css"-->
  <title>商品情報検索画面</title>
 </head>

 <body>
 	<div class="header">
 		<h1>商品情報検索</h1>
		<form action="ProduceAddItemView.action" method="post">
 		  <input class="right" type="submit" value="新規商品追加">
 		</form>
	</div>

	<div class="main">
		<div class="search-area">
			<div class="clear"></div>
			<form action="Search.action" name="search_form" method="post">
 			 <div class="category">
 			   商品分類
 			   <select class="pulldown" name="item_category_code">
 			     <option value=""></option>
 			     <%//上記のように出力されるようにしたいのでここに、javaコードをうめこみます。
 			         List<ItemCategory> itemCategories = (List)session.getAttribute("item_category_list");
 			         for (int i =0; i < itemCategories.size(); i++) {%>
 			             <option value="<%=itemCategories.get(i).getItemCategoryCode()%>"><%=itemCategories.get(i).getItemCategoryName()%></option>
 			     <%    }%>
 			   </select>
 			 </div>
 			 <div class="item">
 			   商品名 <input type="text" name="item_name">
 			 </div>
 			 <button class="search" type="submit" value="検索">検索</button>
 	        </form>
		</div>
		<!--　検索結果を表示するようにかいてください -->
		<!-- 検索ボタンをクリックしたあと、該当する商品情報を出力させる-->
		
		<table class="first-table">
 		<tr>
 		 <th>No.</th><th>商品分類</th><th>商品名</th><th>価格</th><th>おすすめ</th>
 	    </tr>
 	    <!--　この部分を繰り返す -->
 	    <%
 	      List<Item> items = (List)request.getAttribute("item_list");
 	      if(items != null) {
 	        for (int i = 0; i < items.size(); i++) {
 	        String price = String.format("%,d", items.get(i).getPrice());
 	        String recommendFlg = items.get(i).getRecommendFlg().equals("1") ? "★" : "-";
 	        
 	      %>
 	      <tr>
 	        <td><%=items.get(i).getItemNo()%></td>
 	        <td><%=items.get(i).getItemCategoryName()%></td>
 	        <td class="product-name">
 	          <form method="post" action="ProduceItemDetailView.action">
                <input type="hidden" name="item_no" value="<%=items.get(i).getItemNo()%>">
                <a href="javascript:void(0)" onclick="this.parentNode.submit()"><%=items.get(i).getItemName()%></a>
                </form>
 	        </td>
 	        <td class="price"><%=price%>円</td>
 	        <td><%=recommendFlg%></td>
 	     </tr>
 	    <%
 	        }
 	      }
 	    %>
 	 </table>
 	 
 	 <p class="attention">
		<% if(request.getAttribute("message") != null) { %>
		<%= request.getAttribute("message") %>
		<% } %>
	 </p>
 	</div>

 </body>
</html>