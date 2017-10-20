$(function(){//页面加载完毕之后执行的代码
	var floag = true;
	$(".but").click(function(){
		var pwd2 = $(".pwd2").val();
		var pwd3 = $(".pwd3").val();
		if(pwd2==pwd3){
			if(floag)
				$(".xx").submit();
			$(".error").text("原密码错误，请确认");
		}else{
			$(".error").text("两次密码不一样");
			return false;
		}
	});
	//加载页面的值
	$.ajax({
		type:"post",
		url:"loadUpdate.do",
		data:{},
		dataType:"json",
		success:function(data){
			$(".adminName").val(data);
		}
	});
	$(".pwd").blur(function(){
		var pwd = $(".pwd").val();
		$.ajax({
			type:"post",
			url:"check.do",
			data:{"pwd":pwd},
			dataType:"json",
			success:function(data){
				if(data==1){
					floag=true;
					$(".error").text("");
				}else{
					floag = false;
					$(".error").text("原密码错误，请确认");
				}
			}
		});
	});
});