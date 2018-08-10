$(function () {

    //光标丢失的事件
    $("#username").blur(function () {
        //获取username的value值
        var username=$("#username").val();
        if(username===""){
            $("#error").text("用户名不允许为空！！！")
        }else{
            //不为空就可以ajax提交到后台
            $.ajax({
                url:"/login?methodName=validateName",
                data:{
                    "username":username
                },
                type:"POST",
                dataType:"JSON",
                success:function (data) {

                  if(data.status==1){
                        $("#error").text(data.message);

                    }else {
                        $("#error").text("可以使用");
                    }
                }
            });
        }
    });
});