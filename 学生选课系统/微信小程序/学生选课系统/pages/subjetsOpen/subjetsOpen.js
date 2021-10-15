Page({
  data: {
    // src:"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400" ,
  imgurl:"../../images/sc0.png",
  dataObj:"",
  pinglunObj:"",
  shoucang:false,
  info:""
  },
  
  click(){
    var cc= wx.getStorageSync('schoolid')
    var studentid= wx.getStorageSync('stuId')
    if(this.data.shoucang){
      this.setData({
        imgurl:"../../images/sc0.png",
        shoucang:false
      })
    }else{
      this.setData({
        imgurl:"../../images/sc1.png",
        shoucang:true
      })
    }
    //
    wx.request({
      url:'http://49.232.127.127:8080/xskc/userShouCang', 
      data: {
        schoolid:cc,
        studentid:studentid,
        flag:this.data.shoucang
      },
      header: {
        'content-type':'application/x-www-form-urlencoded;charset=utf-8'
      },
      method: 'POST',
      success(res) {
        if (res.data.flag==true) {
          console.log('访问成功');
          console.log(res)
          wx.showToast({
            title: '收藏成功',
            icon: 'none'
          })
          }else{
            console.log('取消收藏');
            wx.showToast({
              title: '取消收藏',
              icon: 'none'
            })
          }
        },
        fail() {
          wx.hideLoading();
          console.log('数据获取失败！');
          wx.showToast({
            title: '数据获取失败！',
            icon: 'none'
          })
        }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  updata:function(e){
    var cc= wx.getStorageSync('schoolid')
    var studentid= wx.getStorageSync('stuId')
    var that=this
    this.setData({
      info:e.detail.value.info,
    })
    console.log(this.data.info)
    if(this.data.info!=""){
    wx.request({
      url:'http://49.232.127.127:8080/xskc/schoolCommentinfo', 
      data: {
        schoolid:cc,
        studentid:studentid,
        info:this.data.info
      },
      header: {
        'content-type':'application/x-www-form-urlencoded;charset=utf-8'
      },
      method: 'POST',
      success(res) {
        that.resert();
        wx.request({
          url:'http://49.232.127.127:8080/xskc/findSchoolandInfo', 
          data: {
            schoolid:cc,
          },
          header: {
            'content-type':'application/x-www-form-urlencoded;charset=utf-8'
          },
          method: 'POST',
          success(res) {
            console.log(res.data);
            that.setData({
              pinglunObj:res.data.data.user_schoolinfos
            })

            if (res.data.flag==true) {
              console.log('评论区访问成功');
              }else{
                console.log('访问失败，请稍后再试！');
                wx.showToast({
                  title: '访问失败，请稍后再试！',
                  icon: 'none'
                })
              }
            }
        })
  }
})
 }
 else{
  wx.showToast({
    title: '请输入评论内容..',
    icon: 'none'
  })
 }
 
},
resert:function () {
  this.setData({
    infos:""
  })
},
  onLoad: function (options) {
    var that=this
    var cc= wx.getStorageSync('schoolid')
    var studentid= wx.getStorageSync('stuId')
    console.log(cc)
    wx.request({
      url:'http://49.232.127.127:8080/xskc/panDuanShouCang', 
      data: {
        schoolid:cc,
        studentid:studentid
      },
      header: {
        'content-type':'application/x-www-form-urlencoded;charset=utf-8'
      },
      method: 'POST',
      success(res) {
        that.setData({
          shoucang:res.data.flag
        })
        console.log(that.data.shoucang)
        if(that.data.shoucang){
          console.log("已收藏")
          that.setData({
            imgurl:"../../images/sc1.png",
          })
        }
        else{
          console.log("已取消收藏")
          that.setData({
            imgurl:"../../images/sc0.png",
          })
        }
      }})
    wx.request({
      url:'http://49.232.127.127:8080/xskc/findSchoolandInfo', 
      data: {
        schoolid:cc,
      },
      header: {
        'content-type':'application/x-www-form-urlencoded;charset=utf-8'
      },
      method: 'POST',
      success(res) {
        console.log(res.data);
        that.setData({
          dataObj:res.data.data,
          pinglunObj:res.data.data.user_schoolinfos
        })
        wx.setStorageSync('schoolinfo', res.data.data.schoolinfo)
        wx.setStorageSync('schoolteacherinfo', res.data.data.schoolteacherinfo)
        console.log( res.data.data.schoolinfo)
        console.log(that.data.pinglunObj)
        if (res.data.flag==true) {
          console.log('评论区访问成功');
          }else{
            console.log('访问失败，请稍后再试！');
            wx.showToast({
              title: '访问失败，请稍后再试！',
              icon: 'none'
            })
          }
        },
        fail() {
          wx.hideLoading();
          console.log('数据获取失败！');
          wx.showToast({
            title: '数据获取失败！',
            icon: 'none'
          })
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
    this.onLoad();
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