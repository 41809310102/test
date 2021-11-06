
const db = wx.cloud.database()
var app = getApp();
Page({

 

  /**

   * 页面的初始数据

   */

  data: {

    items: [{

      name: '1',

      checked: false,

      value: '记住密码'

    }],//记住密码的复选框

    isrememberpass: '',//是否记住密码

    mobile: '',//用户名或者手机号

    pass: '',//密码

  },

  // 授权登录,这里我是先让用户授权才登录的，不需要的也可以直接放个登录按钮，不授权登录

  bindGetUserInfo: function(e) {

    if (e.detail.userInfo) {

      //用户按了允许授权按钮

      wx.showLoading({

        title: '正在登录...',

      })

      if (this.data.mobile == '') {

        wx.showToast({

          title: '用户名或手机号不能为空',

          icon: 'none',

          duration: 2000

        })

      } else if (this.data.pass == '') {

        wx.showToast({

          title: '密码不能为空',

          icon: 'none',

          duration: 2000

        })

      } else {

        var that = this

        // 登录接口

        var parame = {}

        // 此处要先判断你输入的是用户名还是手机号，用户名就要用户名的字段去查，手机号就要使用手机号的字段去查

        if (!(/^1[3456789]\d{9}$/.test(this.data.mobile))) {//验证手机号码是否正确的正则表达式

          // 不是手机号，说明是输入的用户名

          parame = {

            username: this.data.mobile

          }

        } else {

          // 输入的手机号

          parame = {

            mobile: this.data.mobile

          }

        }


        var that=this;
        console.log("账号"+this.data.mobile);
        console.log("密码"+this.data.pass);
        wx.setStorageSync('stuId', this.data.mobile)
        wx.setStorageSync('password', this.data.pass)

        wx.request({
          url: app.globalData.ip+'stuoflogin',
          data: {
            studentid:this.data.mobile,
            password:this.data.pass
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
            var user_id = res.data.id;
            app.globalData.user_id = user_id;
            console.log(app.globalData.user_id);
            if (res.data!=null) {
                  wx.showLoading({
                    title: '登录成功...'
                  })
                  setTimeout(() => {
                    wx.hideLoading();
                    wx.reLaunch({
                      url: '../first/first',
                    })
                  }, 1000)

                  if (that.data.isrememberpass != '') { //判断用户是否勾选了记住密码

                    // 勾选了则存储到本地缓存

                    wx.setStorage({

                      key: 'pass',

                      data: that.data.pass,

                    })

                  } else { //不记住密码，删除缓存

                    wx.removeStorage({

                      key: 'pass',

                      success: function(res) {},

                    })

                  }

                  wx.setStorage({ //存储用户名

                    key: 'username',

                    data: that.data.mobile,

                  })

                  wx.setStorage({//存储用户的信息id，作为userId

                    key: 'userId',

                    data: res.data.id,

                  })
                  setTimeout(function() {
                    
                    setTimeout(function() {
                      app.globalData.register=true;
                     wx.navigateBack({
                     })
                    }, 3000)
                  }, 2000)
                  // 这里还可以写一些登录成功后的操作，比如登录成功后跳转到首页之类的
            }else {
              wx.hideLoading();
              if (res.data.password!=pass) {
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
          } )
      }

    } else {

      //用户按了拒绝按钮

      wx.showModal({

        title: '警告',

        content: '您点击了拒绝授权，将无法进行账号登录，请授权之后再登录!!!',

        showCancel: false,

        confirmText: '返回授权',

        success: function(res) {}

      })

    }

  },

  // 用户名失焦

  mobile(e) {

    this.setData({

      mobile: e.detail.value

    })

  },

  // 密码失焦

  pass(e) {

    this.setData({

      pass: e.detail.value

    })

  },

  // 记住密码复选框

  checkboxChange: function(e) {

    this.setData({

      isrememberpass: e.detail.value

    })

  },

  // 点击注册按钮，跳转到注册页面

  register() {

    wx.navigateTo({

      url: "/page/component/login/login"

    })

  },
 

  /**

   * 生命周期函数--监听页面加载

   */

  onLoad: function(options) {

 

  },

 

  /**

   * 生命周期函数--监听页面初次渲染完成

   */

  onReady: function() {

 

  },

 

  /**

   * 生命周期函数--监听页面显示

   */

  onShow: function () {//这一段是登录界面初始进入页面时，判断如果没有缓存密码，就说明没有记住密码，只需要显示用户名就行了，如果缓存了密码，说明是记住密码的，要从缓存中获取用户名和密码都显示出来

    if (wx.getStorageSync('pass') != '') {

      var check = 'items.[0].checked'

      this.setData({

        mobile: wx.getStorageSync('username'),

        pass: wx.getStorageSync('pass'),

        [check]: true,

        isrememberpass: ["1"]

      })

    } else {

      this.setData({

        mobile: wx.getStorageSync('username'),

      })
e
    }

  },

 

  /**

   * 生命周期函数--监听页面隐藏

   */

  onHide: function() {

 

  },

 

  /**

   * 生命周期函数--监听页面卸载

   */

  onUnload: function() {

 

  },

 

  /**

   * 页面相关事件处理函数--监听用户下拉动作

   */

  onPullDownRefresh: function() {

 

  },

 

  /**

   * 页面上拉触底事件的处理函数

   */

  onReachBottom: function() {

 

  },

 

  /**

   * 用户点击右上角分享

   */

  onShareAppMessage: function() {

 

  },
  //事件处理函数


})
