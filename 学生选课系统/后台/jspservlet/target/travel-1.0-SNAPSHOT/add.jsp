<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2021/03/30
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 管理系统大布局 - Layui</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学生选课后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">管理操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="subject.jsp">课程管理</a></dd>
                        <dd><a href="student.jsp">学生管理</a></dd>
                        <dd><a href="add.jsp">课程添加</a></dd>
                    </dl>
                </li>

            </ul>
        </div>
    </div>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#btn_from").click(function () {

                $.post("jsp/addSchool",$("#frm").serialize(),function (data) {
                    if (data.flag){
                        location.href="add.jsp";
                    }else{
                        alert("添加失败");
                    }

                },'json');
            });
        });
    </script>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div>
            <form class="layui-form" id="frm"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">科类</label>
                    <div class="layui-input-block">
                        <input type="text" name="schooltype" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">科目</label>
                    <div class="layui-input-block">
                        <input type="text" name="schoolname" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">授课老师</label>
                    <div class="layui-input-block">
                        <input type="text" name="schoolteachername" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">老师简介</label>
                    <div class="layui-input-block">
                        <input type="text" name="schoolteacherinfo" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">图片地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="schoolimg" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">视频地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="schoolurl" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">科目简介</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" class="layui-textarea"name="schoolinfo"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn"type="submit" id="btn_from" lay-submit lay-filter="*">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
                <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
            </form>
            <script src="layui/layui.js"></script>
            <script>
                layui.use('form', function(){
                    var form = layui.form;
                    //各种基于事件的操作，下面会有进一步介绍
                });
            </script>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>
<script src="layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>



