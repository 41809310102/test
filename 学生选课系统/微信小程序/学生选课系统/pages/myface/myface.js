// pages/myface/myface.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    stuId:'测试',
    stuName:'测试',
    dataObj:""
  },
  /**
   * 生命周期函数--监听页面加载
   */
  click:function(e){
    var num = e.currentTarget.dataset.id;
    console.log(num)
    console.log(this.data.dataObj[num])
    var id=this.data.dataObj[num].schoolid
    console.log(id)
     wx.setStorageSync('schoolid',id )
     wx.navigateTo({
       url: '../subjetsOpen/subjetsOpen',
     })
  },
  onLoad: function (options) {
    var studentid= wx.getStorageSync('stuId')
    var name= wx.getStorageSync('username')
    console.log(name)
    this.setData({
      stuId:studentid,
      stuName:name
    })
    var that=this
    wx.request({
      url:'http://49.232.127.127:8080/xskc/isUserShouCang',
      data: {
        studentid:studentid
      },
      header: {
        // 'content-type': 'application/json'
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
        console.log(res.data.flag);
        if (res.data.flag==true) {
            that.setData({
              dataObj:res.data.data
            })
            console.log(that.data.dataObj)
        }else {
         console.log("获取数据失败！")
        }
      },
    fail:function(res) {
      console.log("获取失败")
    }
    })
  },
  /*
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

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
    this.onLoad()
    console.log("刷新完毕")
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

  },
  exitSy:function(){
    wx.reLaunch({
      url: '../../pages/login/login',
    })
  },
  pwdUd:function () {
    wx.navigateTo({
      url: '../../pages/pwdUd/pwdUd',
    })
  }
})