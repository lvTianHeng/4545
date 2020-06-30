var userName = null;
var userCode = null;
var phone = null;
var job = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	userName = $("#userName");
	userCode = $("#loginname");
	phone = $("#tel");
	job = $("#job");
	saveBtn = $("#save");
	backBtn = $("#back");
	
	userName.next().html("*");
	phone.next().html("*");


	userCode.on("focus",function () {
        validateTip(userCode.next(),{"color":"#666666"},"* 用户名长度必须是大于1小于10的字符",false);
    }).on("blur",function () {
        if(userCode.val() != null && userCode.val().length > 1
            && userCode.val().length < 10){
            validateTip(userCode.next(),{"color":"green"},imgYes,true);
            $.ajax({
                type:"GET",//请求类型
                url:path+"/user/check",//请求的url
                data:{userCode:userCode.val()},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    if(data.userCode == "exist"){//账号已存在，错误提示
                        validateTip(userCode.next(),{"color":"red"},imgNo+ " 该用户账号已存在",false);
                    } else{//账号可用，正确提示
                        validateTip(userCode.next(),{"color":"green"},imgYes+" 该账号可以使用",true);
                    }
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    validateTip(userCode.next(),{"color":"red"},imgNo+" 您访问的页面不存在",false);
                }
            });
        }else{
            validateTip(userCode.next(),{"color":"red"},imgNo+" 用户名长度必须是大于1小于10的字符",false);}

    });


	// 姓名验证
	userName.on("focus",function(){
		validateTip(userName.next(),{"color":"#666666"},"* 用户名长度必须是大于1小于10的字符",false);
	}).on("blur",function(){
		if(userName.val() != null && userName.val().length > 1 
				&& userName.val().length < 10){
			validateTip(userName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userName.next(),{"color":"red"},imgNo+" 用户名输入的不符合规范，请重新输入",false);
		}
		
	});

	phone.on("focus",function(){
		validateTip(phone.next(),{"color":"#666666"},"* 请输入手机号",false);
	}).on("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(phone.val().match(patrn)){
			validateTip(phone.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(phone.next(),{"color":"red"},imgNo + " 您输入的手机号格式不正确",false);
		}
	});

	
	saveBtn.on("click",function(){
		userCode.blur();
		userName.blur();
		phone.blur();
		if(userName.attr("validateStatus") == "true" 
			&& phone.attr("validateStatus") == "true"
			&& userCode.attr("validateStatus") == "true"
			){
			if(confirm("是否确认要提交数据？")){;
				$("#userForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});