$(function(){
	$.ajax({
		type:"post",
		url:"download.do",
		data:{},
		dataType:"json",
		success:function(data){
			var str = "";
			for(var i=0;i<data.length;i++){
				str += "<br><a href='goDown.do?fileName="+
				data[i]+"'>"+
				"下载"+data[i]+
				"</a><br>";
			}
			$("h1").append(str);
		}
	});
});