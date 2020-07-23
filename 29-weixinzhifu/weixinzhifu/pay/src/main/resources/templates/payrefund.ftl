<html>
<head>
    <meta charset="utf8">
    <title>微信支付</title>
</head>

<body>
<h2>微信申请退款</h2>
<form action="/payrefund" method="post">
    <div>
        <label>商户单号</label>
        <input name="orderNo" value=""/>
    </div>

    <div>
        <label>商户退单号</label>
        <input name="refundNo" value=""/>
        <span>商户退单号，是由我们业务系统生成一个退货单号</span>
    </div>

    <div>
        <label>退款金额</label>
        <input name="price" value=""/>
        <span>退款金额,不能大于用户支付金额，可以分批退款</span>
    </div>

    <input type="submit"/>
</form>

<h3>
    退款结果
</h3>

<span>${payrefundMap?if_exists}</span>


<div>
    <a href="/index">返回首页</a>
</div>

</body>
</html>
