var app = getApp();
Page({
  data: {
    products:'',
    id:'',
    foodtype: 0,
    num: 0,
    buycar_num: 0,
    totalMoney: 0,
    block: false,
    price: 0,
    arr: [
      { id: 0, value: "香辣味"},
      { id: 1, value: "盐焗味"},
      { id: 2, value: "蒜香味"},
      { id: 3, value: "姜葱味"},
    ]
  },
  onLoad: function() {
    var that = this;
    this.setData({
      buycar_num: app.globalData.buycar_num,
      totalMoney: app.globalData.totalMoney,
      id:this.options.id,
    })
    wx.request({
      url: 'http://192.168.101.219:9000/getrestfooddesc',
      data: {
        id:this.data.id,
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
          products:res.data,
          price:res.data.zhekou
        })
        if (res.data!=null) {
          wx.showToast({
            title: '加载成功！',
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

  },


  resetNum: function (e) {
    var type = e.currentTarget.dataset.id;
    this.setData({
      foodtype: type
    })
  },
  
  reduce: function() {
    if(this.data.num>0){
      app.globalData.buycar_num--;
      app.globalData.totalMoney -= this.data.price;
      var totalMoney = app.globalData.totalMoney.toFixed(2)
      this.setData({
        num: this.data.num-1,
        buycar_num: app.globalData.buycar_num,
        totalMoney: totalMoney
      })
    }
  },
  add: function () {
    app.globalData.buycar_num++;
    app.globalData.totalMoney += this.data.price;
    var totalMoney = app.globalData.totalMoney.toFixed(2)
    this.setData({
      num: this.data.num+1,
      buycar_num: app.globalData.buycar_num,
      totalMoney: totalMoney
    })
  },
  close: function() {
    this.setData({
      block: false
    })
  },
  open: function () {
    this.setData({
      block: true
    })
  },
  submit: function() {
    var that = this;
    var i = this.data.foodtype;
    var id;  //哪种食物
    wx.request({
      url: '', 
      data: {
        type: that.data.arr[i].value,
        num: that.data.num
      },
      success: function (res) {
        that.setData({
          block: false
        })
        console.log(res.data)
      }
    })
  },
  buyNow: function() {
    wx.navigateTo({
      url: '../submitOrder/submitOrder'
    })
  },
  toAllEvaluate: function() {
    wx.navigateTo({
      url: '../allEvaluate/allEvaluate',
    })
  },
  toSubmit: function(res) {
    var that = this;
    var time = app.time();
    var selected_crats = [{
      url: '',//食物链接
      ago_price: '',//食物价格
      old_price:'',//老价钱
      name: '',//食物名
      details: '',//食物描述
      goods_norms: '',
      seleted_norms: '',
      total: '',//食物数
      service: '',//
      type: '',//类型
      time: '',//上传时间
      send: '',//接收
      fahuo: ''//是否发货
    }];
      selected_crats[0].url = that.data.products.picture;
      selected_crats[0].ago_price = that.data.products.zhekou;
      selected_crats[0].old_price = that.data.products.pirce;
      selected_crats[0].name = that.data.products.name;
      selected_crats[0].details = "配米饭一份";
      selected_crats[0].goods_norms = "NULL";
      selected_crats[0].seleted_norms = "NULL";
      selected_crats[0].total = that.data.num;
      selected_crats[0].service = "NULL";
      selected_crats[0].type = that.data.products.fenlei;
      selected_crats[0].time = time
      selected_crats[0].send = false,
      selected_crats[0].fahuo = false,
      app.globalData.selected_crats = selected_crats
      console.log(selected_crats)
    wx.navigateTo({
      url: '../foodsumit/foodsumit?totalMoney='+that.data.totalMoney,
    })
  }
})