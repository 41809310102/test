// 获取元素
var options = document.getElementsByClassName("option");
var button = document.getElementsByClassName("five")[0];
// 所有奖项下标的值
var arr = [0,1,2,5,8,7,6,3];
// 数组的下标的初始值
var num = 0;
// 转动的次数
var count = 0;
button.addEventListener("click",function () {
	// 获取的随机数   转动的次数
	var time = Math.ceil(Math.random()*16+16);
	// 定时器来抽奖
	var timer = setInterval(function () {
		// 遍历arr数组      目的：如果不设置这个循环，那么一次走过的奖项都会变色，变不回原来的颜色
		for(var i=0;i<arr.length;i++){
			options[arr[i]].style.backgroundColor = "green";
		}
		// 走到的奖项
		options[arr[num]].style.backgroundColor = "red";
		num++;
		// 如果上面数组的下标值为8时，要重新赋值为0
		if(num == 8){
			num = 0;
		}
		// 走的div的个数
		count++;
		// 如果转动的次数与获取的随机数一致的情况下，清除定时器
		if(count==time){
			clearInterval(timer);
			// 转动的次数清零
			count = 0;
		}
	},100)
})
