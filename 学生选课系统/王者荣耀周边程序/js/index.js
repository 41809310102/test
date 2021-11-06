/*主页登录版块*/

window.onload=function(){
    if(document.getElementById("fo") != null){
        document.getElementById("fo").onsubmit=function(){
            var yhm = document.getElementById("user01");
            var mm = document.getElementById("password01");

            if(!(/^1\d{10}$/.test(yhm.value))){          /*用正则表达式，检查输入的用户名格式是否为以1开头的11位数*/
                alert("输入用户名格式错误，请重新输入以1开头的11位数用户名！");
                return false;
            }

            if (mm.value != 12345) {
                alert("密码输入错误，请重新输入！");
                return false;
            }
           /* return ture;*/
        }
    }
}


