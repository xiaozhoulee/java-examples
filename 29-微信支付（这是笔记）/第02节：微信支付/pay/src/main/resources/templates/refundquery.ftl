<html>
<head>
    <meta charset="utf8">
    <title>微信支付</title>
</head>

<body>
<h2>微信退款查询 </h2>
<form action="/refundquery" method="post">
    <div>
        <label>商户单号</label>
        <input name="orderNo" value=""/>
    </div>

    <input type="submit"/>
</form>

<h3>
    退款查询结果
</h3>

<span>${refundqueryMap?if_exists}</span>


<div>
    <a href="/index">返回首页</a>
</div>

</body>
</html>
