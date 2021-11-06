var app = getApp();
Page({
  data: {
    num: 0,
    noAddress: false,
    usre_id:'',
    arr: [
      { id: 0, name: "张三 先生", phone: "123456789", address:"启梦创业广场1A158-159"},
      { id: 1, name: "张三 先生", phone: "123456789", address: "启梦创业广场1A158-159" },
      { id: 2, name: "张三 先生", phone: "123456789", address: "启梦创业广场1A158-159" },
    ],
  },

  onLoad: function(){
    var that = this;
    this.setData({
      user_id: app.globalData.user_id,
    })
  //  console.log(user_id)
    wx.request({
      url: app.globalData.ip+'getuseraddress',
      data: {
        user_id:this.data.user_id,
      },
      header: {
        // 'content-type': 'application/json'
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
    //    console.log(res.errMsg)
       that.setData({
          arr:res.data,
        })
        if (res.data!=null) {
           console.log("加载成功")
              // 这里还可以写一些登录成功后的操作，比如登录成功后跳转到首页之类的
        }else {
          if (res.data==null) {
            console.log('当前没有事物上架');
            wx.showToast({
              title: '当前没有事物上架',
              icon: 'none'
            })
          }
        }
      }
      } )

  },

  chooseAddress: function(e) {
    var that = this;
    var i = e.currentTarget.dataset.id;
    var id = this.data.arr[i].id;
    var ismoren = this.data.arr[i].ismoren;
    console.log(id),
    console.log(ismoren),

    wx.request({
      url: app.globalData.ip+'updateismoren',
      data:{
        ismoren:!ismoren,
        id:id,

      },
      success: function(res) {
      //  var that = this;
        console.log(res)
        if(res.data=='ok'){
         console.log('默认地址修改成功！')
         wx.showToast({
          title: '修改成功',
          icon: 'none'
        },1000)
        }else{
          wx.showToast({
            title: '修改失败',
            icon: 'none'
          })
        }
        }
    })
    that.onLoad();
  },

  addAddress: function() {
    wx.navigateTo({
      url: '../address/addaddress/addaddress'
    })
  },

  delAddress: function(e) {
     var that = this;
     var i = e.currentTarget.dataset.id;
     var id = this.data.arr[i].id;
       wx.request({
         url: app.globalData.ip+"delectaddress",
         data:{
          id:id,
        },
        success:function(res){
          if(res.data=='ok'){
           wx.showToast({
             title: '删除成功！',
             icon: 'none'
           },2000)
          }else{
            wx.showToast({
              title: '删除失败！',
              icon: 'none'
            },1000)
          }
        },
       })
    that.onLoad(); 
  },

  toEdit: function(e) {
    var type = e.target.dataset.id;
    wx.navigateTo({
      url: '../addAddress/addAddress?id='+type,
    })
  }
})