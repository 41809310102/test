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
</head>
<body class="layui-layout-body">
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<script src="js/jquery-3.3.1.js"></script>
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
            <script src="layui/layui.js" charset="utf-8"></script>
            <table class="layui-hide" id="test" lay-filter="test"></table>
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
                        elem: '#test'
                        ,url:'jsp/findSchoolAll'
                        ,toolbar: '#toolbarDemo'
                        ,title: '科目数据表'
                        ,totalRow: true
                        ,page: false
                        ,cols: [[
                            {type: 'checkbox', fixed: 'left'}
                            ,{field:'schoolid', title:'ID', width:80, fixed: 'left'}
                            ,{field:'schoolname', title:'科目', width:120}
                            ,{field:'schooltype', title:'课程类别', width:120}
                            ,{field:'schoolteachername', title:'老师姓名', width:120,edit: 'text'}
                            ,{field:'schoolteacherinfo', title:'老师简介', width:120,edit: 'text'}
                            ,{field:'schoolurl', title:'视频地址', width:120,edit: 'text'}
                            ,{field:'schoolimg', title:'图片地址', width:120,edit: 'text'}
                            ,{field:'schoolcount', title:'收藏次数', width:120}
                            ,{field:'schoolinfo', title:'课程简介', width:120,edit: 'text'}
                            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
                        ]]
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

                        //修改科目
                        $.post("jsp/updateSchool", {'schoolid':obj.data.schoolid,
                            'schoolname':obj.data.schoolname,
                            'schoolteachername':obj.data.schoolteachername,
                            'schoolteacherinfo':obj.data.schoolteacherinfo,
                            'schoolcount':obj.data.schoolcount,
                            'schooltype':obj.data.schooltype,
                            'schoolinfo':obj.data.schoolinfo,
                            "schoolurl":obj.data.schoolurl,
                            "schoolimg":obj.data.schoolimg
                        }, function(res) {
                            console.log("删除成功");
                        }, 'json');

                    });
                    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                        var data = obj.data; //获得当前行数据
                        var layEvent = obj.event; //获得 lay-event 对应的值
                        if(layEvent === 'detail'){
                            layer.msg('查看操作');
                        } else if(layEvent === 'del'){
                            layer.confirm('真的删除行么',function(index){
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.close(index);
                                //向服务端发送删除指令
                                $.post("jsp/delSchool", {'schoolid':obj.data.schoolid}, function(res) {
                                    console.log("删除成功");
                                }, 'json');
                            });
                        } else if(layEvent === 'edit'){
                            layer.msg('双击进行修改');
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
<script src="../src/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>