<%@page contentType="text/html; charset=UTF-8" %>

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
 		<input class="right" type="submit" value="新規商品追加">
	</div>

	<div class="main">
		<div class="search-area">
			<div class="clear"></div>
 			<div class="category">商品分類<select class="pulldown" name="商品分類"></select></div>
 			<div class="item">商品名<input type="text" name="keyword"></div>
 			<input class="search" type="submit" value="検索">
		</div>
	</div>

 </body>
</html>