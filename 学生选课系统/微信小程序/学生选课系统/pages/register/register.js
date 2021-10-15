Page({

  /**
   * 页面的初始数据
   */
  data: {
    stuName: '',
    stuId: '',
    password: '',
    checkPassword: '',
  },
  register:function(e){
    this.setData({
      stuName:e.detail.value.stuName,
      stuId:e.detail.value.stuId,
      password:e.detail.value.password,
      checkPassword:e.detail.value.checkPassword
    })
    console.log(this.data.stuName)
 if(this.data.checkPassword !== this.data.password){
      wx.showToast({
        title: '两次输入密码不一致！',
        icon: 'none'
      })
    } else {
      wx.showLoading({
        title: '正在注册...',
      })
      let that = this;
      wx.request({
        url: 'http://49.232.127.127:8080/xskc/regServlet ', 
        data: {
          username: this.data.stuName,
          studentid: this.data.stuId,
          password: this.data.password,
        },
        header: {
          'content-type':'application/x-www-form-urlencoded;charset=utf-8'
        },
        method: 'POST',
        success(res) {
          console.log(res.data);
          if (res.data.flag==true) {
            console.log('注册成功。');
            wx.showLoading({
              title: '注册成功...'
            });
            setTimeout(()=>{
              wx.hideLoading();
              wx.reLaunch({
                url: '../login/login'
              })
            },1000)
          }  else if (res.data.flag==false) {
              console.log('学号已经被注册！');
              wx.showToast({
                title: '学号已经被注册！',
                icon: 'none'
              })
            }else{
              console.log('注册失败，请稍后再试！');
              wx.showToast({
                title: '注册失败，请稍后再试！',
                icon: 'none'
              })
            }
          }
      })
      }},
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