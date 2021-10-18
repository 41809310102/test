Page({
  /**
   * 页面的初始数据
   */
  data: {
    stuId: '',
    password: ''
  },
  
  login:function(e){
   var that=this;
    this.setData({
      stuId:e.detail.value.stuId,
      password:e.detail.value.password
    })
    wx.setStorageSync('stuId', this.data.stuId)
    wx.setStorageSync('password', this.data.password)
    console.log(this.data.stuId+this.data.password)
       wx.showLoading({
        title: '正在登录...'
      })
      wx.request({
        url: 'http://localhost:8080/jspservlet_war/loginServlet',
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
         wx.setStorageSync('username', res.data.data.username)
        var name= wx.getStorageSync('username')
         console.log(name)
          console.log(res.data);
          console.log(res.data.flag)
          console.log(res.errMsg)
          if (res.data.flag==true) {
                wx.showLoading({
                  title: '登录成功...'
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
              console.log('用户密码错误，请重新输入密码！');
              wx.showToast({
                title: '用户密码错误，请重新输入密码！',
                icon: 'none'
              })
            } else {
              console.log('登录失败，请稍后再试！');
              wx.showToast({
                title: '登录失败，请稍后再试！',
                icon: 'none'
              })
            }
          }
        }
        } )},
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