<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<link rel="stylesheet" href="/resources/css/upload.css" />
<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Modify</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>            
            <div class="row">
                <div class="col-lg-12">
                	<div class="panel panel-default">
                        <div class="panel-heading">
                           Board Modify Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                			<form action="" method="post" role="form">
                				<div class="form-group">
                					<label>Bno</label>
                					<input class="form-control" name="bno" readonly="readonly" value = "${row.bno}">                				
                				</div> 
                				<div class="form-group">
                					<label>Title</label>
                					<input class="form-control" name="title" value = "${row.title}">                				
                				</div>  
                				<div class="form-group">
                					<label>Content</label>
                					<textarea class="form-control" rows="3" name="content">${row.content}</textarea>               				
                				</div> 
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer" readonly="readonly"value = "${row.writer}">                				
                				</div>  
                				
                				<sec:authentication property="principal" var="info"/>
                					<sec:authorize access="isAuthenticated()">
                						<c:if test="${info.username == row.writer}">
			                				<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>              			
			                				<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>              			
                						</c:if>
                					</sec:authorize>
                				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                				<button type="submit" data-oper='list' class="btn btn-info">List</button>              			
                			</form>
                		</div>
                	</div>
                </div>
            </div>

<!-- 첨부파일 등록 --> 
<div class="bigPictureWrapper">
	<div class="bigPicture"></div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading"><i class="fa fa-files-o"></i>파일 첨부</div>
			<div class="panel-body">
			<div class="form-group uploadDiv">
					<input type="file" name="uploadFile" id="" multiple/>
				</div>
				<div class="uploadResult">
					<ul></ul>
				</div>
			</div>
		</div>
	</div>
</div>      
      
<%-- remove와 list를 위한 폼--%>
<form action="" id="actionForm">
	<input type="hidden" name="pageNum" value="${cri.pageNum}"/>
	<input type="hidden" name="amount" value="${cri.amount}"/>
	<input type="hidden" name="type" value="${cri.type}"/>
	<input type="hidden" name="keyword" value="${cri.keyword}"/>
	<input type="hidden" name="bno" value="${row.bno}"/>
	<%-- 시큐리티 적용으로 인한 추가 --%>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" name="writer" value="${row.writer}" />
</form> 
<%-- 스크립트 --%>
<script>
	//현재 글번호 가져오기
	let bno = ${row.bno};   
	
	//ajax 동작시 헤더 값에 포함해서 보낼 csrf 토큰 값 설정
	let csrfHeaderName = "${_csrf.headerName}";
	let csrfTokenValue= "${_csrf.token}";
</script>
<script src="/resources/js/modify.js"></script>
<%@include file="../includes/footer.jsp" %>       