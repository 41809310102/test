 Page({
    data: {
      schooltype:"语文",
      dataObj:"",
      typeObj:""
    },
    // 事件处理函数
    bindViewTap() {
      wx.navigateTo({
        url: '../logs/logs'
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
    clicks:function(e){
      var num = e.currentTarget.dataset.id;
      console.log(num)
      console.log(this.data.typeObj[num])
      var schooltype=this.data.typeObj[num]
      console.log(schooltype)
      var that=this;
      wx.request({
        url:'http://49.232.127.127:8080/xskc/findSchoolBySchooltype',
        data: {
          schooltype:schooltype
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
        }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    ////////////////////
    wx.request({
      url:'http://49.232.127.127:8080/xskc/findSchooltype',
      data: {
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
              typeObj:res.data.data
            })
            console.log(that.data.typeObj)
        }else {
         console.log("获取数据失败！")
        }
      },
    fail:function(res) {
      console.log("获取失败")
    }
    })
    /////////////////////
    wx.request({
      url:'http://49.232.127.127:8080/xskc/findSchoolBySchooltype',
      data: {
        schooltype:this.data.schooltype
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