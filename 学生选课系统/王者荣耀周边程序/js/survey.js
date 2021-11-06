/*问卷板块*/

function checkData5(){    /*checkData()的JS脚本函数，以便我们在将表单数据提交到服务器前，能对表单中填写的部分数据的合法性进行必要的检验*/
	var  a= document.getElementById("a").value;   /*var obj = document.getElementById(页面元素id)*/
	var  b= document.getElementById("b").value;
	var  c= document.getElementById("c").value;
	var  q= document.getElementById("q").value;
	var  q1= document.getElementById("q1").value;
	var  q2= document.getElementById("q2").value;
	var  q3= document.getElementById("q3").value;
	var  q4= document.getElementById("q4").value;
	var  q5= document.getElementById("q5").value;
	var  q6= document.getElementById("q6").value;
	var  w= document.getElementById("w").value;
	var  w1= document.getElementById("w1").value;
	var  w2= document.getElementById("w2").value;
	var  w3= document.getElementById("w3").value;
	var  w4= document.getElementById("w4").value;
	var  h= document.getElementById("h").value;
	if((document.getElementById("boy").checked==false) && (document.getElementById("girl").checked==false))
	{
		alert("请选择性别！");
		return false;
	}
	else if(!a)
	{
		alert("请输入服务器");
		return false;
	}
	else if(q,q1,q2,q3,q4,q5,q6==null)
	{
		alert("请选择对王者荣耀的期望");
		return false;
	}
	else if(w,w1,w2w,w3,w4==null)
	{
		alert("请选择对王者荣耀的建议");
		return false;
	}
	else if(!b)
	{
		alert("请选择是否禁止小学生玩王者荣耀");
		return false;
	}
	else if(!c)
	{
		alert("请选择要重做的英雄");
		return false;
	}
	else if(!h)
	{
		alert("请填写你的建议");
		return false;
	}
	
	return true;
}
function check5(){
	var r = checkData5(); 
	return r;
}


