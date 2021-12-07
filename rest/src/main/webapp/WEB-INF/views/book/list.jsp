<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../includes/header.jsp" %>
 <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">code</th>
      <th scope="col">title</th>
      <th scope="col">writer</th>
      <th scope="col">price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="dto">
    <tr>
      <th>${dto.code}</th>
      <td><a href="${dto.code}" class="move">${dto.title}</a></td>
      <td>${dto.writer}</td>
      <td>${dto.price}</td>
    </tr>
    </c:forEach>
    
    
    
  </tbody>
</table>
<div id="result">

</div>
<div>
	<button type="button" id="delete">삭제</button>
	<button type="button" id="update">수정</button>
</div>


<script src="/resources/js/list.js"></script>
  <%@include file="../includes/footer.jsp" %>