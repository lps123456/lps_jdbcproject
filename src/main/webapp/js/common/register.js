$(function () {

    //��궪ʧ���¼�
    $("#username").blur(function () {
        //��ȡusername��valueֵ
        var username=$("#username").val();
        if(username===""){
            $("#error").text("�û���������Ϊ�գ�����")
        }else{
            //��Ϊ�վͿ���ajax�ύ����̨
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
                        $("#error").text("����ʹ��");
                    }
                }
            });
        }
    });
});