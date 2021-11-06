var app = getApp();
var QQMapWX = require('../../../../../qqmap-wx-jssdk.min');
var qqmapsdk;
Page({
  data: {
    id: '先生',
    user_id:'',
    city: '点击选择',
    name: '',
    phone: '',
    cityDetail: '',
    address: '',   //当前定位的城市
    nothing: false
  },
  onLoad:function(){
    var that = this;
    that.setData({
      user_id: app.globalData.user_id,
    })
  },
  getAddress: function () {
    var that = this;
    wx.chooseLocation({
      success: function (res) {
        that.setData({
          address: res.address
        })
        if (res.address.length > 10) {
          res.address = res.address
        }
        that.setData({
          city: res.address
        })
      },
    })
  },
  chooseId: function(e) {
    var type = e.currentTarget.dataset.id;
    this.setData({
      id: type
    })
  },
  toEditAddress: function() {
    this.setData({
      pageType: 2
    })
  },
  noChoose: function() {
    this.setData({
      pageType: 1,
      city: '点击选择',
    })
  },
  setName: function (e) {
    this.setData({
      name: e.detail.value
    })
  },
  setPhone: function (e) {
    this.setData({
      phone: e.detail.value
    })
  },
  setCityDetail: function(e) {
    this.setData({
      cityDetail: e.detail.value
    })
  },
  // saveAddress: function() {
  //   console.log(this.data)
  //   wx.navigateBack({
  //     url: '../address/address',
  //   })   
  //   wx.request({
  //     url: '',
  //     data: this.data,
  //     success: function(res) {
  //       console.log(res)
  //     }
  //   })
  // },
  formSubmit: function (e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value)
       wx.request({
       url: app.globalData.ip+'addaddress',
       data: this.data,
      success: function(res) {
       console.log(res)
       if(res.data=='ok'){
        wx.showToast({
          title: '添加成功',
          icon: 'none'
        },3000)
       }
     wx.navigateTo({
       url: '../address',
     })
       }
     })
  },
  formReset: function () {
    console.log('form发生了reset事件')
  }
})