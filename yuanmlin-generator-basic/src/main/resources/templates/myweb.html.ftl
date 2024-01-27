<!DOCTYPE html>
<html>
<head>
    <title>我是菜鸟</title>
</head>
<body>
<h1> 你好 </h1>
<ul>
    <#-- 循环渲染导航条 -->
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>
<#-- 底部版权信息 -->
<footer>
    #{currentYear} World！
</footer>
</body>
</html>