// pages/pwdUd/pwdUd.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    stuId:'',
    oldpassword:'',
    password:''
  },
  revise:function (e) {
    this.setData({
      stuId:e.detail.value.stuId,
      password:e.detail.value.password,
      oldpassword:e.detail.value.oldpassword,
    })
    console.log(this.data.stuId)
    var studentid=wx.getStorageSync('stuId')
    var pwd=wx.getStorageSync('password')
    if(this.data.stuId!=studentid){
      wx.showLoading({
        title: '请输入您的学号...'
      })
      setTimeout(() => {
        wx.hideLoading();
        wx.reLaunch({
          url: '../pwdUd/pwdUd',
        })
      }, 1500)
    }
    else if(this.data.oldpassword!=pwd){
      wx.showLoading({
        title: '请输入正确的旧密码...'
      })
      setTimeout(() => {
        wx.hideLoading();
        wx.reLaunch({
          url: '../pwdUd/pwdUd',
        })
      }, 1500)
    }
   else if(this.data.oldpassword==this.data.password){
    wx.showLoading({
      title: '密码重复...'
    })
    setTimeout(() => {
      wx.hideLoading();
      wx.reLaunch({
        url: '../pwdUd/pwdUd',
      })
    }, 1500)
   }
   else{
    wx.request({
      url: 'http://49.232.127.127:8080/xskc/password',
      data: {
        studentid:this.data.stuId,
        password:this.data.password
      },
      header: {
        // 'content-type': 'application/json'
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
        console.log(res.data.flag)
        console.log(res.errMsg)
        if (res.data.flag==true) {
              wx.showLoading({
                title: '修改成功...'
              })
              setTimeout(() => {
                wx.hideLoading();
                wx.reLaunch({
                  url: '../index/index',
                })
              }, 1000)
        }else {
          wx.hideLoading();
          if (res.data.flag==false) {
            console.log('修改失败！');
            wx.showToast({
              title: '修改失败！',
              icon: 'none'
            })
          } else {
            console.log('修改失败！');
            wx.showToast({
              title: '修改失败！',
              icon: 'none'
            })
          }
        }
      }
    })
  }
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
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