/*加入我们板块*/

function checkData6(){    /*checkData()的JS脚本函数，以便我们在将表单数据提交到服务器前，能对表单中填写的部分数据的合法性进行必要的检验*/
		var name = document.getElementById("txtName").value;   /*var obj = document.getElementById(页面元素id)*/
		if(!name)
		{
			alert("请输入姓名！");
			return false;
		}
		else if( (document.getElementById("boy").checked==false) && (document.getElementById("girl").checked==false) )
		{
			alert("请选择性别！");
			return false;
		}
		
		return true;
}
function check6(){
		var r = checkData6(); 
		return r;
}


function showImg(){
		var img=document.getElementById("img1");
		img.style.display="block";
}
					
function hideImg(){
		var img = document.getElementById("img1");
		img.style.display ="none";
}
