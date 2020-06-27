<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>微信支付</title>
    <script type="text/javascript" src="/jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="/jquery-qrcode-0.14.0/jquery-qrcode-0.14.0.js"></script>


    <script>
        $(function (){
            var recommend_code = "${code_url?if_exists}";    //微信扫码关注
            $("#qrcode_div").qrcode({
                render : "canvas",        //设置渲染方式，有table和canvas，使用canvas方式渲染性能相对来说比较好
                text : recommend_code,    //扫描了二维码后的内容显示,在这里也可以直接填一个网址，扫描二维码后
                size : 150,               //大小
                background : "#ffffff"    //二维码的后景色
            });
        });
    </script>

</head>
<body>
<h2>微信支付二维码</h2>
<span>${code_url?if_exists}</span>

<div id="qrcode_div">
</div>


<div align="center" style="margin-top: 200px">
    <a href="/index">返回首页</a>
</div>

</body>
</html>

