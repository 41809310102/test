/*装备切换板块*/

function $(id){return document.getElementById(id);}/*获取元素*/
function changeImage(){
	var o=$("game");
	var index=o.selectedIndex;//获取下拉框中的选择项
	$("show").src=$("game").options[index].value;  //更改图片
}