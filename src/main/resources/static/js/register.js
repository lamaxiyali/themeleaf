layui.use(['layer', 'element', 'form', 'layedit','jquery'], function() {
    var layer = layui.layer;
    var form = layui.form;
    var element = layui.element;
    var layedit = layui.layedit;
    var $$ = layui.jquery;
    layer.open({
        type: 1,
        title: "注册页面（*为必填项）",
        area: ['600px', '600px'],
        offset: '20px',
        content: $("#register"),
        cancel: function() {
            // 你点击右上角 X 取消后要做什么
            alert("退出注册");
            window.location="/login"
        },
        success: function () {
            $$('.demo2').on('click',function() {
                //监听提交
                username1 = $$('#username').val();
                password1 = $$('.pwd').val();
                email1 = $$('.ema').val();
                phone1 = $$('.pho').val();
                name1 = $$('.trname').val();
                cardid1 = $$('.caid').val();
                profession1 = $$('.pro').val();
                education1 = $$('.edu').val();
                major1 = $$('.maj').val();
                age1 = $$('.ag').val();
                if (username1.length<5){
                    layer.msg("用户账号至少5位");
                    return false;
                }else if (password1.length>12 || password1.length<6){
                    layer.msg("用户密码6-12位");
                    return false;
                }else if (email1.length == 0){
                    layer.msg("邮箱必须添加");
                    return false
                }
                else{
                    var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
                    if (!myReg.test(email1)){
                        layer.msg("邮箱格式不对!");
                        return false;
                    }
                    $$.ajax({
                        url: "/registeruser",
                        type: "POST",
                        data: {
                            username: username1,
                            password: password1,
                            email: email1,
                            phone: phone1,
                            name: name1,
                            cardid: cardid1,
                            profession: profession1,
                            education: education1,
                            major: major1,
                            age: age1,
                        },
                        type: "POST",
                        success: function (data) {
                            if(data ==1){
                                layer.msg("注册用户已存在");
                                return false;
                            }else if(data ==2){
                                layer.msg("注册邮箱已经存在");
                                return false;
                            }
                            else{
                                alert("注册成功");
                                window.location.href="./login"
                            }

                        }
                    })
                }

            });
        }
    });
    // 监听提交
    // form.verify({
    //     title: function(value) {
    //         if(value.length < 5) {
    //             return '标题至少得5个字符';
    //         }
    //     },
    //     pwd: [
    //         /^(\w){6,20}$/, '只能输入6-20个字母、数字、下划线'
    //     ],
    //     emails: [
    //         /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/, '请输入正确的邮箱格式：<br>如：xxx@qq.com<br>xxx@163.com等格式'
    //     ],
    //     phones: [
    //         /^$/ | /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, '您的输入有误，请重新输入(中国11位手机号)'
    //     ],
    //     truename: [
    //         /^$/ | /^[\u4e00-\u9fa5]{2,4}$/, '您的输入有误，请输入2-4位中文'
    //     ],
    //     cardId: [
    //         /^$/ | /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, '请输入正确的身份证号'
    //     ],
    //     age: [
    //         /^$/ | /^[1-100]*$/,'请填入1-100的数字'
    //     ],
    //     content: function(value) {
    //         layedit.sync(editIndex);
    //     }
    // });
});