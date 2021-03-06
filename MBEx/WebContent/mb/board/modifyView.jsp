<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_board.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectBoard}/script.js"></script>
<h2>${page_modify}</h2>
<c:if test="${result eq 0}">
	<script type="text/javascript">
		erroralert(passerror);
	</script>
</c:if>
<c:if test="${result ne 0}">
	<body onload="modifyfocus()">
		<form method="post" action="modifyPro.do" name="modifyform" onsubmit="return modifycheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
			<table>
				<tr>
					<th colspan="2">
						${msg_modify}
					</th>
				</tr>
				<tr>
					<th>${str_writer}</th>
					<td>${boardDto.writer}</td>
				</tr>
				<tr>
					<th>${str_email}</th>
					<td>
						<c:if test="${boardDto.email eq null or boardDto.email eq ''}">
							<input class="input" type="text" name="email" maxlength="30">
						</c:if>
						<c:if test="${boardDto.email ne null and boardDto.email ne ''}">
							<input class="input" type="text" name="email" value="${email}" maxlength="30">
						</c:if>
					</td>
				</tr>
				<tr>
					<th>${str_subject}</th>
					<td>
						<input class="input" type="text" name="subject" maxlength="50" value="${boardDto.subject}">
					</td>
				</tr>
				<tr>
					<th>${str_content}</th>
					<td>
						<textarea class="input" name="content" rows="10" cols="40" >${boardDto.content}</textarea>
					</td>
				</tr>
				<tr>
					<th>${str_passwd}</th>
					<td>
						<input class="input" type="password" name="passwd" maxlength="12" value="${boardDto.passwd}">
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input class="inputbutton" type="submit" value="${btn_mod}">
						<input class="inputbutton" type="reset" value="${btn_cancel}">
						<input class="inputbutton" type="button" value="${btn_mod_cancel}" onclick="location='list.do?pageNum=${pageNum}'"> 
					</th>
				</tr>
			</table>
		</form>
	</body>
	</c:if>