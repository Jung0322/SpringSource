/**
 * list.jsp 스크립트
 */
$(function(){
   checkModal(result);
   
   
   history.replaceState({},null,null);
   
   function checkModal(result){
      if(result===''|| history.state){
         return;
      }
      
      
      if(parseInt(result)>0){
         $(".modal-body").html("게시글"+parseInt(result)+"번이 등록되었씁니다");
      }
      
      $("#myModal").modal("show");
      
   }
   
   //페이지 나누기 스크립트
   let actionForm = $("#actionForm");
   
   //번호 클릭 시 클릭된 번호 값 가져오기
   $(".paginate_button a").click(function(e){
      //a 태그의 속성을 중지
      e.preventDefault();
      //번호 값 가져오기
      let pageNum = $(this).attr("href");
      
      //가져온 번호를 actionForm 안의 pageNum 값으로 대체
      actionForm.find("input[name='pageNum']").val(pageNum);

	  //action 수정
		actionForm.attr("action","/board/list");
		//bno제거
		actionForm.find("input[name='bno']").remove();	
		
      //폼 전송
      actionForm.submit();
      
   })
   
   
   //amount 클릭이 되면 
	$("#amount").change(function(){
		
   		//amount 값 가져오기
		let amount = $(this).val();
		
		//가져온 값을 actionForm의 amount 값 수정하기
		actionForm.find("input[name='amount']").val(amount);
		
		//amountForm 보내기
     	 actionForm.submit();
	})

	//글제목 클릭시 
	$(".move").click(function(e){
	//a태그 속성 중지
	e.preventDefault();
	//actionForm에 bno값을 추가한다
	
	let bno = $(this).attr('href');
	actionForm.find("input[name='bno']").val(bno);
	
	//actionForm action 설정 /board/read
	actionForm.attr("action","/board/read");
	//actionForm 보내기
	actionForm.submit();
	})
	
	
	//검색버튼 클릭시
	
	$(".btn-default").click(function(e){
		e.preventDefault();
		
		let type = $("select[name='type']").val();
		let keyword= $("input[name='keyword']").val();
		

		if(type===''){
			alert("검색 기준을 입력 해주세요");
			return;
		}else if(keyword===''){
			alert("검색어를 입력하세요.");
			return;
		}
		
		//pageNum의 값을 1로 변경하기
		$("#searchForm").find("input[name='pageNum']").val("1");
		
		//검색 폼 보내기
		$("#searchForm").submit();
	})

})


