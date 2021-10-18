var app = getApp();

Page({
  data: {
    block: false,
    restaurant: false,
    check: true,
    foodorder:[],
    totalMoney: 0
  },

  onLoad: function() {
    var that = this;
    this.setData({
      foodorder: app.globalData.selected_crats,
      totalMoney: this.options.totalMoney,
    })
  },

  calling: function() {
    wx.makePhoneCall({
      phoneNumber: '18316588252', 
      success: function () {
        console.log("拨打电话成功！")
      },
      fail: function () {
        console.log("拨打电话失败！")
      }
    })
  },
  Block: function() {
    this.setData({
      block: true
    })
  },
  takeOut: function(){
    this.setData({
      restaurant: false
    })
  },
  Cancel: function() {
    this.setData({
      block: false,
      check: true,
      restaurant: false
    })
  },
  Ok: function () {
    var that = this; 
    this.setData({
      block: false,
    })
    wx.scanCode({
      onlyFromCamera: true,
      success: (res) => {
        console.log(res);
        that.setData({                    
          restaurant: true
        })
      },
      fail: (res) => {
        that.setData({
          restaurant: false,
          check: true
        });    
      }
    })
  },
  toMyPackage: function() {
    wx.navigateTo({
      url: '../myPackage/myPackage',
    })
  },
  toMyAddress: function () {
    wx.navigateTo({
      url: '../address/address',
    })
  },
  submitOrder: function() {
    wx.requestPayment({
      'timeStamp': '',
      'nonceStr': '',
      'package': '',
      'signType': 'MD5',
      'paySign': '',
      'success': function (res) {
      },
      'fail': function (res) {
      }
    })
  }
})