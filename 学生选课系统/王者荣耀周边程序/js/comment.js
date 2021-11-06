/*留言板块*/

function checkData(){    /*checkData()的JS脚本函数，以便我们在将表单数据提交到服务器前，能对表单中填写的部分数据的合法性进行必要的检验*/
		var n = document.getElementById("n").value;/*var obj = document.getElementById(页面元素id)*/
		var x = document.getElementById("x").value;
		var t = document.getElementById("t").value;
		var txt = document.getElementById("txt").value;
		if(!n)
		{
			alert("请输入用户名！");
			return false;
		}
		else if(!x)
		{
			alert("请输入wechat!");
			return false;
		}
		else if(!t)
		{
			alert("请输入留言时间");
			return false;
		}
		else if(!txt)
		{
			alert("请输入留言内容");
			return false;
		}
		
		return true;
}
function check(){
		var r = checkData(); 
		return r;
}