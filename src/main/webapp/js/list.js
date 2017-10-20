$(function(){
	loadList();
	$(".xx").click(function(){
		var s = this.value;
		if(s=="上一页"){
			if(page<=1){
				alert("已经是第一页了，别再点了，都抽筋了")
				page = 1;
			}else{
				page--;
			}
		}else{
			var maxPage = $("span input:last").val();
			if(page>=maxPage){
				alert("已经不能再大了");
				page = maxPage;
			}else{
				page++;
			}
		}
		loadList();
	});
	$("#go").click(function(){
		page = $(".in").val();
		var maxPage = $("span input:last").val();
		alert(page>maxPage)
		if(page<1){
			alert("已经是第一页了，别再点了，都抽筋了");
			page = 1;
		}else if(page>maxPage){
			alert("已经不能再大了");
			page = maxPage;
		}
		$(".in").val(page);
		loadList();
	});
});
var page = 1;

/*function loadPage(){
	$.ajax({
		type:"post",
		url:"pageSize.do",
		data:{},
		dataType:"json",
		success:function(data){
			var str = "";
			for(var i=1;i<=data;i++){
				str += "<input type='button' value='"+i+"'>";
			}
			$(".ym").html(str);
			$("input").click(function(){
				page = this.value;
				loadList();
				loadPage();
			});
		}
	});
}*/
function loadList(){//方便复用
	$("tr").not(".oo").remove();//filter(".oo")
	$.ajax({
		type:"post",
		url:"list.do",
		data:{"page":page},
		dataType:"json",
		success:function(data){
			var list = data.list;
			for(var i=0;i<list.length;i++){
				var str = "<tr>"+
				"<td>"+list[i].userName+"</td>"+
				"<td>"+list[i].gender+"</td>"+
				"<td>"+list[i].price+"</td>"+
				"<td>"+list[i].amount+"</td>"+
				"<td><img src='"+list[i].display+"'></td>"+
				"</tr>";
				$(".ta").append(str);
			}
			var str = "";
			for(var i=1;i<=data.pages;i++){
				str += "<input type='button' value='"+i+"'>";
			}
			$(".ym").html(str);
			$("span input").click(function(){
				page = this.value;
				loadList();
			});
		}
	});
}