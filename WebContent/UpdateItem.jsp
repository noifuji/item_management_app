<!DOCTYPE html>
<html lang="ja">
 <head>
  <meta charset="utf-8">
  <title>商品情報変更入力画面</title>
  <link rel="stylesheet" href="css/A01-1.css">
 </head>

  <body>
 	<div class="header">
 		<h1>商品情報変更入力</h1>
	</div>

	<div>
	  <table class="new-table">
		<tr>
		 <td class="left-side">商品分類<span>※必須</span></td><td class="right-side"><select class="pulldown" name="商品分類"></select></td>
		</tr>
		<tr>
  		 <td class="left-side">商品名<span>※必須</span></td><td class="right-side"><input class="goods" type="text"></td>
		</tr>
		<tr>
		 <td class="left-side">説明<span>※必須</span></td><td class="right-side"><textarea rows="10" cols="60"></textarea></td>
		</tr>
		<tr>
		 <td class="left-side">価格<span>※必須</span></td><td class="right-side"><input class="price" type="text">円</td>
		</tr>
		<tr>
		 <td class="left-side">おすすめ</td><td class="right-side"><input class="recommend" type="checkbox">おすすめ商品にする</td>
		</tr>
	</table>
  </div>

  <div class="choice">
   <input class="back" type="submit" value="戻る">
   <input class="register" type="submit" value="確認">
  </div>
　</body>
</html>