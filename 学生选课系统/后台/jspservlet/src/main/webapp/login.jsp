<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2021/03/30
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width"/>
    <title>Login</title>
    <link rel="stylesheet" href="css/font_43d7u1qkxvp/iconfont.css">
    <script src="js/jquery-3.3.1.js"></script>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        body{
            width: 100%;
            height: 100%;
            background:black ;
            background-repeat:no-repeat;
        }
        .container{
            width: 100%;
            height: 100vh;
            margin: auto;
            display: flex;
        }
        .login{
            width: 300px;
            height: 300px;
            margin: auto;
            text-align: center;
            justify-content: center;
            align-items: center;
            background-color: rgba(0,0,0,0.5);
            border-radius: 10px;
        }
        h1{
            color: white;
            margin-bottom: 20px;
            margin-top:20px ;
        }
        p{
            width: 30px;
            line-height:30px;
            font-size: 28px;
            margin-bottom: 20px;
            display: flex;
            margin-left: 55px;
        }
        span{
            color: white;
        }
        input{
            background-color: transparent;
            height: 30px;
            width: 150px;
            border-radius: 5px;
            border: none;
            border-bottom: 1 px solid white;
            outline-color: white;
            color: white;
            margin-left: 5px;
        }
        button{
            width: 150px;
            height: 30px;
            margin-bottom: 10px;
            border: none;
            border-radius: 15px;
            cursor: pointer;
            background: linear-gradient(to right,#edb8b0,#016db4);
        }
    </style>
</head>
<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                type: "POST",
                url:"jsp/login",
                data:$('#myForm').serialize(),
                error: function() {
                    alert("用户名密码错误!");
                },
                success: function() {
                    location.href="index.jsp";
                }
            });
        });
    });
</script>
<body>
<div class="container">
    <div class="login">
        <h1>LOGIN</h1>
        <form target="targetIfr"id="myForm">
            <p>
                <span class="iconfont icon-yonghu"></span>
                <input id="Account"type="text"name="username"placeholder="请输入您的账号"  />
            </p>
            <p>
                <span class="iconfont icon-mima"></span>
                <input id="Password" type="password" name="password" placeholder="请输入密码"/>
            </p>
            <button type="button" id="btn">确认</button>
            <button type="reset">重置</button>
        </form>

    </div>
</div>
</body>
