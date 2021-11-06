/*手办商城购物板块*/

var result=""; //存放选购信息
var price=new Array(257.00,299.00,389.00,69.00,59.00,69.00);
var product=new Array("幻纱之灵西施Q版手办		只要￥257.00","仲夏夜之梦貂蝉Q版手办 只要￥299.00","地狱火非洲猴Q版手办 只要￥389.00","超级薄荷黑旋风李白薄荷糖 只要￥69.00","99万毫安的鲁班充电宝 只要￥ 59.00","一生所爱露娜Q版手办 只要￥699.00");
var isSelected=new Array(0,0,0,0,0,0);
function clearAll(){
	isSelected=[0,0,0,0,0,0];  //选择状态全部置0
	//所以复选框状态变为未选中状态
	lzjForm.sp0.checked=false;
	lzjForm.sp1.checked=false;
	lzjForm.sp2.checked=false;
	lzjForm.sp3.checked=false;
	lzjForm.sp4.checked=false;
	lzjForm.sp5.checked=false;
}
function checkOut(){
	var total=0;//存放小计金额
	var count=0;//存放选购产品件数
	for(var i=0;i < isSelected.length; i++){
		count=count+isSelected[i];
	}
	for(var i=0;i< price.length; i++){
		total=total+price[i]*isSelected[i]  //累计金额
	}
	alert("您所选的"+count+"件,产品总价="+total+"\n"+"请去支付!");
}
function shoppingCart(){
	//判断有多少个复选框被选中
	var selectList=""; //保存所选产品清单
	for(var j=0;j<product.length; j++){
		if(isSelected[j]){		//分行显示
			selectList=selectList+(j+1)+"-"+product[j]+",价值="+price[j]+"\n"
		}
	}
	var info=(selectList=="") ? "您的购物车为空,请选购!":selectList;
	alert(info);	//生成一个结算清单,显示输出
}
function checkSelect(number) {
	var temp; //暂存复选框状态
	switch(number){
		case 0:
			temp=lzjForm.sp0.checked;break;
		case 1:
			temp=lzjForm.sp1.checked;break;
		case 2:
			temp=lzjForm.sp2.checked;break;
		case 3:
			temp=lzjForm.sp3.checked;break;
		case 4:
			temp=lzjForm.sp4.checked;break;
		case 5:
			temp=lzjForm.sp5.checked;break;
	}
	isSelected[number]=(temp) ? 1:0;  //记录选中产品,1-选中,0-未选
}