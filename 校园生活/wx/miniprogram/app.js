App({
  onLaunch: function() {
    if (!wx.cloud) {
      console.error('请使用 2.2.3 或以上的基础库以使用云能力')
    } else {
      wx.cloud.init({
        env: "hujunjie-59uot",
        // database: "cloud1-8gr4hxwk549472b2",
        // storage:"cloud1-8gr4hxwk549472b2",
        // functions:"cloud1-8gr4hxwk549472b2"
      })
      this.openid();
    }
  },
  onShow: function() {
    
    
  },
  onHide: function() {
    
  },
  globalData: {
    crats_value: [],
    new_product:[],
    selected_crats: [],//保存选好的信息
    selected_crats1: [],
    hasLogin: false,
    openid:'',
    Users:false,
    userInfo: null,
    location: "",
    city: '',
    address: '',
    buycar_num: 0,
    totalMoney: 0,
    totalSecond: 899
  },
  
  openid() {
  
  },
  _time() {
    var date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours();
    const minute = date.getMinutes();
    const second = date.getSeconds();
    var time = year + '/' + month + '/' + day + '/' + hour + '/' + minute + second;
    return time;
  },
  time() {
    var date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours();
    const minute = date.getMinutes();
    const second = date.getSeconds();
    var time = year + '-' + month + '-' + day + ' ' + hour + '时' + minute +'分'+ second+'秒';
    return time;
  },
  getWidth_height() {
    let windowHeight = wx.getSystemInfoSync().windowHeight; // 屏幕的高度  
    let windowWidth = wx.getSystemInfoSync().windowWidth; // 屏幕的宽度    
    return windowHeight * 750 / windowWidth;
  }
})