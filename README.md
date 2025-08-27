
# Fullness Stationary社 文具/雑貨販売システム

## チームメンバー

- リーダー：井上　稜土
- サブリーダー：飯干　凜子
- メンバー：齋藤　愛子
- メンバー：柚木　哲太
- メンバー：池田　唯

## チーム目標

- チーム内コミュニケーションを図る
- 品質管理を徹底する
- テストカバレッジ80％以上

## チームのルール入力

- 一時間に（最低）一回の進捗報告
- コミット名などのルール厳守
- テストケースの検討を重ねる（ダブルチェック）

## 開発ルール

はやくまとめなよ。

## コーディング規約

### 基本規約

本システムのコーディング規約は基本的には[オブジェクト倶楽部版 Java コーディング規約](http://objectclub.jp/community/codingstandard/CodingStd.pdf)に準ずる

### URL一覧
画面ID|画面名|コントローラー|HTTPメソッド|メソッド|ビュー
---|---|---|---|---|---
BP01|メニュー画面(http://localhost8080/admin)|MenuController|GET|menu()|admin/index.html
BP02|担当者ログイン画面(http://localhost8080/admin/login)|LoginController|GET|login()|admin/login.html
BP03|担当者アカウント登録(入力)画面(http://localhost8080/admin/account/form)|AccountController|GET|input()|admin/account/input.html
BP04|担当者アカウント登録(確認)画面(http://localhost8080/admin/account/confirm)|AccountController|POST|confirm()|admin/account/confirm.html
BP05|担当者アカウント登録(完了)画面(http://localhost8080/admin/account/complete)|AccountController|GET|complete()|admin/account/complete.html
BP06|商品検索画面(http://localhost8080/admin/product)|ProductController|GET|search()|admin/product/search.html
BP07|商品削除(確認)画面(http://localhost8080/admin/product/delete/{productId})|ProductDeleteController|POST|confirm()|admin/product/delete/confirm.html
BP08|商品削除(完了)画面(http://localhost8080/admin/product/delete/complete)|ProductDeleteController|GET|complete()|admin/product/delete/complete.html
BP09|商品修正(入力)画面(http://localhost8080/admin/product/edit/{productId})|ProductEditController|GET|input()|admin/product/edit/input.html
BP10|商品修正(確認)画面(http://localhost8080/admin/product/edit/confirm)|ProductEditController|POST|confirm()|admin/product/edit/confirm.html
BP11|商品修正(完了)画面(http://localhost8080/admin/product/edit/complete)|ProductEditController|GET|complete()|admin/product/edit/complete.html
BP12|新商品登録(入力)画面(http://localhost8080/admin/product/register/input)|ProductRegisterController|GET|input()|admin/product/register/input.html
BP13|新商品登録(確認)画面(http://localhost8080/admin/product/register/confirm)|ProductRegisterController|POST|confirm()|admin/product/register/confirm.html
BP14|新商品登録(完了)画面(http://localhost8080/admin/product/register/complete)|ProductRegisterController|GET|complete()|admin/product/register/complete.html
BP19|商品カテゴリ登録(入力)画面(http://localhost8080/admin/productcategory/register/input)|ProductCategoryRegisterController|GET|input()|admin/productcategory/input.html
BP20|商品カテゴリ登録(確認)画面(http://localhost8080/admin/productcategory/register/confirm)|ProductCategoryRegisterController|POST|confirm()|admin/productcategory/confirm.html
BP21|商品カテゴリ登録(完了)画面(http://localhost8080/admin/productcategory/register/complete)|ProductCategoryRegisterController|GET|complete()|admin/productcategory/complete.html


