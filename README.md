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

## チームのル入力

- 一時間に（最低）一回の進捗報告
- コミット名などのルール厳守
- テストケースの検討を重ねる（ダブルチェック）

## コーディング規約

### 基本規約

本システムのコーディング規約は基本的には[オブジェクト倶楽部版 Java コーディング規約](http://objectclub.jp/community/codingstandard/CodingStd.pdf)に準ずる

### URL一覧
画面ID|画面名|コントローラー|メソッド|ビュー
---|---|---|---|---
BP01|メニュー画面(http://localhost8080/admin)|adminController|admin|admin/admin.html
BP02|担当者ログイン画面(http://localhost8080/admin/login)|adminController|login|admin/login.html
BP03|担当者アカウント登録(入力)画面(http://localhost8080/admin/account/form)|accountController|form|admin/account/form.html
BP04|担当者アカウント登録(確認)画面(http://localhost8080/admin/account/confirm)|accountController|confirm|admin/account/confirm.html
BP05|担当者アカウント登録(完了)画面(http://localhost8080/admin/account/complete)|accountController|complete|admin/account/complete.html
BP06|商品検索画面(http://localhost8080/admin/product)|productController|product|admin/product/product.html
BP07|商品削除(確認)画面(http://localhost8080/admin/product/delete/{productId})|productController|delete|admin/product/delete/check.html
BP08|商品削除(完了)画面(http://localhost8080/admin/product/delete/complete)|productController|deletecomplete|admin/product/delete/complete.html
BP09|商品修正(入力)画面(http://localhost8080/admin/product/edit/{productId})|productController|edit|admin/product/edit/input.html
BP10|商品修正(確認)画面(http://localhost8080/admin/product/edit/confirm)|productController|editconfirm|admin/product/edit/confirm.html
BP11|商品修正(完了)画面(http://localhost8080/admin/product/edit/complete)|productController|editcomplete|admin/product/edit/complete.html
BP12|新商品登録(入力)画面(http://localhost8080/admin/product-add)|productController|productadd|admin/new/add.html
BP13|新商品登録(確認)画面(http://localhost8080/admin/product/add/confirm)|productController|productaddconfirm|admin/product/new/confirm.html
BP14|新商品登録(完了)画面(http://localhost8080/admin/product/add/complete)|productController|productaddcomplete|admin/product/new/complete.html
BP19|商品カテゴリ登録(入力)画面(http://localhost8080/admin/product-category-add)|productcategoryController|categoryadd|admin/productcategory/add.html
BP20|商品カテゴリ登録(確認)画面(http://localhost8080/admin/product-category-add/confirm)|productcategoryController|categoryaddconfirm|admin/productcategory/confirm.html
BP21|商品カテゴリ登録(完了)画面(http://localhost8080/admin/aproduct-category-add/complete)|productcategoryController|categoryaddcomplete|admin/productcategory/complete.html


