function sub(){
	var name = $(".admin").val();
	var pwd = $(".pwd").val();
	if(name == null || name == "" || pwd == null || pwd == ""){
		$(".error").text("用户名或者密码不能为空！");
		return false;
	}
	$(".form2").submit();
}