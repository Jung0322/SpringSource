/**
 * read.jsp 스크립트
 */
$(function(){
	let form = $("#actionForm");
	//list를 클릭하면 전체 리스트 보여주기
	$(".btn-info").click(function(){
		form.attr("action","/board/list");
		//bno 제거
		form.find("input[name='bno']").remove();
		
		form.submit();
	})
	
	//moidify를 클릭하면 actionForm 보내기
	//GET
	$(".btn-default").click(function(){
		form.attr("action","/board/modify");
		form.submit();
	})
})