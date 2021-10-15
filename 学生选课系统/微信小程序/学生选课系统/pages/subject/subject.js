// pages/subject/subject.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dataObj:""
  },
  resert:function () {
    this.setData({
      infos:""
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  sousuo:function(e){
    var that=this
    wx.request({
      url: 'http://localhost:8080/jspservlet_war/FindSchoolinfoByMoHuServlet',
      data: {
        schoolname:e.detail.value.guanjianci
      },
      header: {
        // 'content-type': 'application/json'
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
        console.log(res.data.flag)
        that.resert();
        if (res.data.flag==true) {
            that.setData({
              dataObj:res.data.data
            })
            console.log(that.data.dataObj)
        }else {
         console.log("获取数据失败！")
        }
      },
      complete:function(res){
      }
    })
  },
  click:function(e){
    var num = e.currentTarget.dataset.id;
    console.log(num)
    console.log(this.data.dataObj[num])
    var id=this.data.dataObj[num].schoolid
    console.log(id)
     wx.setStorageSync('schoolid',id )
     wx.navigateTo({
       url: '../../pages/subjetsOpen/subjetsOpen',
     })
  },
  onLoad: function (options) {
    var that=this
    wx.request({
      url: 'http://49.232.127.127:8080/xskc/findThree',
      data: {
      },
      header: {
        // 'content-type': 'application/json'
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data);
        console.log(res.data.flag)
        if (res.data.flag==true) {
            that.setData({
              dataObj:res.data.data
            })
            console.log(that.data.dataObj)
        }else {
         console.log("获取数据失败！")
        }
      },
      complete:function(res){
      }
    })
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