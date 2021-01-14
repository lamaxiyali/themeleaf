
layui.use(['carousel', 'form','layer','jquery'], function(){
    var form = layui.form
        , layer = layui.layer
        , $$ = layui.jquery;
    //监听提交
    form.on('submit(demo2)', function(data){
        var email1 = $$(".emal").val();
        if(email1.length == 0){
            alert("不能为空");
            return false;
        }
        var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
        if (!myReg.test(email1)){
            alert("邮箱格式不对!");
            return false;
        }
        $$.ajax({
            url: "/checkemail",
            data: {
                email: email1
            },
            type: "POST",
            success: function(data){
                if(data == 1){
                    alert('邮箱不存在');
                }
                else {
                    alert("验证码已发送，注意查收");
                    $$.ajax({
                        url: "/getcode",
                        data: {
                            email: email1
                        },
                        success: function(data){
                            if(data == 0){
                                window.location.href = "./repass2";
                            }
                            else if(data == 2){
                                alert("email 发送失败，请确定是一个有效的邮箱")
                                return false;
                            }

                        }
                    });

                }
            }
        });
        return false;
    });
    form.on('submit(btndemo)', function(data){
        alert("验证码已发送，注意查收");
        $$.ajax({
            url: "/getcode",
            success: function(data){
                if(data == 0){
                    return true;
                }
                else{
                    window.location.href = "./repass2";
                }

            }
        });

        return false;
    });
});

