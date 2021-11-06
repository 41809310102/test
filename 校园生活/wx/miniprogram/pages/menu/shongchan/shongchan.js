const db = wx.cloud.database();
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    left_name:[         // {id:11,name:'可以自己再加'},
    ],
    all:[],
    product:[],
    id:0,
    num:0,
    name:''
  },

  // 跳转商品详情页
  GoToProduct(res){
    var that = this;
    var id = res.currentTarget.dataset.id;
    console.log(id);
    wx.navigateTo({
      url: '../../menu/shongchan/detail/detail?id='+id,
    })
    // for(var i = 0; i < that.data.all.length; i++){
    //   if(that.data.all[i]._id == id){

    //   }
    // }
  },

  // 显示对应分类的商品
  selectId(res){
    var that = this;
    var name = res.currentTarget.dataset.name;
    var array = [];
    console.log(name);
    that.setData({
      name:name
    })
    wx.request({
      url: app.globalData.ip+'getrestfood',
      data: {
      },
      header: {
        // 'content-type': 'application/json'
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
     //  wx.setStorageSync('username', res.data.data.username)
     //  var name= wx.getStorageSync('username')
    //   console.log(name)
        
        console.log(res.data);
        console.log(res.errMsg)
        that.setData({
          all:res.data
        })
        if (res.data!=null) {
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
        for(var j = 0; j < that.data.all.length; j++){
          if(that.data.all[j].fenlei == name){
            array.push(that.data.all[j]);
          }else if(name=='全部'){
            array.push(that.data.all[j]);
          }
        }
        console.log("all"+that.data.all)
        that.setData({
          product:array
        })
        console.log(that.data.product)
      }
      } )
    // for(var i = 0; i < that.data.left_name.length;i++){
    //   if(that.data.left_name[i].name == name){
    //     console.log("当前选择的分类是",that.data.left_name[i].name)
    //     name_1 = that.data.left_name[i].name;
    //   }
    // }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var array = [];
    var name = app.globalData.name;
    wx.showToast({
      title: '加载中',
      icon: 'none'
    })
    wx.request({
      url: app.globalData.ip+'getrestaurant',
      data: {
      },
      header: {
        // 'content-type': 'application/json'
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
     //  wx.setStorageSync('username', res.data.data.username)
     //  var name= wx.getStorageSync('username')
    //   console.log(name)
        console.log(res.data);
        console.log(res.errMsg)
        that.setData({
          left_name:res.data
        })
        if (res.data!=null) {
          wx.showToast({
            title: '更新成功...',
            icon: 'none'
          })
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

    console.log(name);
    if(name == ''){
      console.log("执行if");
    }else {
      console.log("执行else");
      that.setData({
        name:name
      })
    }
    // that.setData({
    //   id:1
    // })

    // wx.cloud.callFunction({
    //   name:'OpenId',
    //   success(res){
    //     console.log(res)
    //   }
    // })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */


  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})