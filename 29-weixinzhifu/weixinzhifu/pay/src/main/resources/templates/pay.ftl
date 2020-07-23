<html>
    <head>
        <meta charset="utf8">
        <title>微信支付</title>
    </head>

    <body>
        <h2>微信订单支付</h2>
        <form action="/pay" method="post">
            <div>
                <label>商户单号</label>
                <input name="orderNo" value=""/>
            </div>

            <div>
                <label>商品描述</label>
                <input name="body" value=""/>
            </div>

            <div>
                <label>商品价格</label>
                <input name="price" value=""/>
                <span style="color:red">在生产环境中，商品价格必须从数据库中读取，而不是从页面上传入参数给后台处理</span>
            </div>

            <input type="submit"/>
        </form>
    </body>
</html>
