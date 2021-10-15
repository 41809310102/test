<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2021/03/30
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 管理系统大布局 - Layui</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="js/jquery-3.3.1.js"></script>
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
                    <a class="" href="javascript:;">操作管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="subject.jsp">课程管理</a></dd>
                        <dd><a href="student.jsp">学生管理</a></dd>
                        <dd><a href="add.jsp">课程添加</a></dd>
                    </dl>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div >
            <table id="student" lay-filter="test"></table>
            <script src="layui/layui.js" charset="utf-8"></script>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
            <script>
                layui.use('table', function(){
                    var table = layui.table;
                    //温馨提示：默认由前端自动合计当前行数据。从 layui 2.5.6 开始： 若接口直接返回了合计行数据，则优先读取接口合计行数据。
                    //详见：https://www.layui.com/doc/modules/table.html#totalRow
                    table.render({
                        elem: '#student'
                        ,url:'jsp/findUserAll'
                        ,toolbar: '#toolbarDemo'
                        ,title: '学生数据表'
                        ,totalRow: true
                        ,height:'full-150'
                        ,cols: [[
                            {type: 'checkbox', fixed: 'left'}
                            ,{field:'username', title:'姓名', width:120,}
                            ,{field:'studentid', title:'学号', width:120,}
                            ,{field:'password', title:'修改密码', width:120,edit: 'text'}
                            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
                        ]]
                        ,page: true
                    });
                    //工具栏事件
                    table.on('toolbar(test)', function(obj){
                        var checkStatus = table.checkStatus(obj.config.id);
                        switch(obj.event){
                            case 'getCheckData':
                                var data = checkStatus.data;
                                layer.alert(JSON.stringify(data));
                                break;
                            case 'getCheckLength':
                                var data = checkStatus.data;
                                layer.msg('选中了：'+ data.length + ' 个');
                                break;
                            case 'isAll':
                                layer.msg(checkStatus.isAll ? '全选': '未全选')
                                break;
                        };
                    });
                    table.on('edit(test)',function(obj){
                        //修改学生密码
                        $.post("password",
                            {'studentid':obj.data.studentid,'password':obj.data.password},function(res) {
                                console.log("删除成功");
                            });
                    });
                    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                        var data = obj.data; //获得当前行数据
                        var layEvent = obj.event; //获得 lay-event 对应的值
                        if(layEvent === 'detail'){
                            layer.msg('查看操作');
                        } else if(layEvent === 'del'){
                            layer.confirm('真的删除行么', function(index){
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                                //向服务端发送删除指令
                                $.post("jsp/delUser", {'studentid':obj.data.studentid}, function(res) {
                                    console.log("删除成功");
                                });
                            });

                        } else if(layEvent === 'edit'){
                            layer.msg('双击密码进行修改');
                        }
                    });
                });
            </script>

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>