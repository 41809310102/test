$(function () {

    new AjaxUpload('#upload', {
        action: '../file/upload',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete: function (file, rr) {
            if (rr.code == 0) {

                $.getJSON("../sys/user/info/"+vm.qian.user,function (r) {
                    vm.code = ''
                    vm.user = r. user;
                    if(r.user ){
                        vm.qian.user = r.user.userId;
                        vm.qian.url = rr.url;
                        $.ajax({
                            type: "POST",
                            url: "../qian/save",
                            data: JSON.stringify(vm.qian),
                            success: function (r) {
                                if (r.code === 0) {
                                    layer.msg('签到成功')
                                } else {
                                    layer.msg(r.msg);
                                }
                            }
                        });
                    }else{
                        layer.msg('未查询到学生信息')
                    }
                })

            } else {
                alert(r.msg);
            }
        }
    });

});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            paike: ''
        },
        code:'',
        showAdd: false,
        showInfo: false,
        showList: true,
        title: null,


        paikes: [],


        users: [],


        qian: {},
        user: {},
    },
    created: function () {

        $.getJSON("../paike/list2", function (r) {
            vm.paikes = r.list;
        })

        $.getJSON("../sys/user/list2", function (r) {
            vm.users = r.list;
        })
        this.showAdd = true;
        this.showList = false;
        this.title = "新增";
        this.qian = {
            paike:'',
            user:''
        };

    },
    methods: {
        h:function(){
            if(!vm.qian.paike){
                layer.msg('请选择课程') ;return ;
            }
            if(!vm.qian.user){
                layer.msg('请选择需要识别的学生') ;return ;
            }

            $.getJSON("../sys/user/info/"+vm.qian.user,function (r) {
                vm.code = ''
                vm.user = r.list[0];
                if(r.list.length ){
                    vm.qian.user = r.list[0].userId;
                    $.ajax({
                        type: "POST",
                        url: "../qian/save",
                        data: JSON.stringify(vm.qian),
                        success: function (r) {
                            if (r.code === 0) {
                                layer.msg('签到成功')
                            } else {
                                layer.msg(r.msg);
                            }
                        }
                    });
                }else{
                    layer.msg('未查询到学生信息')
                }
            })
        },
        query: function () {
            vm.reload();
        }
        ,
        add: function () {
            vm.showAdd = true;
            vm.showList = false;
            vm.title = "新增";
            vm.qian = {};
        }
        ,
        update: function (event) {
            var id =
                getSelectedRow();
            if (id == null
            ) {
                return;
            }

            vm.showAdd = true;
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        }
        ,
        saveOrUpdate: function (event) {
            var url = vm
                .qian.id ==
            null ? "../qian/save" : "../qian/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.qian),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
        ,
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../qian/delete",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        }
        ,
        getInfo: function (id) {
            $.get("../qian/info/" + id, function (r) {
                vm.qian = r.qian;
            });
        }
        ,
        info: function (id) {
            if (isNaN(id)) {
                id
                    = getSelectedRow();
                if (id == null
                ) {
                    return;
                }
            }
            vm.showAdd = false;
            vm.showList = false;
            vm.showInfo = true;
            vm.title = "详情";

            vm.getInfo(id)
        }
        ,
        reload: function (event) {
            vm.showList = true;
            vm.showInfo = false;
            vm.showAdd = false;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: vm.q,
                page: page
            }).trigger("reloadGrid");
        }
    }
});