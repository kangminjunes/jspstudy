<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <c:set var="str" value="Hello World" />
  
  <!-- 문자열의 총길이   -->
  <h4>${fn:length(str)}</h4>
  <!-- 문자열의 0부터 5까지 출력  -->
  <h4>${fn:substring(str, 0, 5)}</h4>
  <!-- 문자열의 띄어쓰기 이전 글자 출력  -->
  <h4>${fn:substringBefore(str, ' ')}</h4>
  <!-- 문자열의 띄어쓰기 이후 글자 출력 -->
  <h4>${fn:substringAfter(str, ' ')}</h4>
  <!-- 문자열의 공백문자 위치를 숫자로 표현  -->
  <h4>${fn:indexOf(str, ' ')}</h4>
  <!-- 문자열의 공백문자 대신 _해당으로 대체 -->
  <h4>${fn:replace(str, ' ', '_')}</h4>

  <!-- 해당 문자열의 표기 여부확인  -->
  <c:if test="${fn:startsWith(str, 'H')}">
    <h4>H로 시작한다.</h4>
  </c:if>
  <!-- 해당 문자열의 표기 여부확인 -->
  <c:if test="${fn:endsWith(str, 'H')}">
    <h4>H로 끝난다.</h4>
  </c:if>
  <!-- 해당 문자열의 표기 여부확인 -->
  <c:if test="${fn:contains(str, 'H')}">
    <h4>H를 포함한다.</h4>
  </c:if>
  <!--해당 문자열의 표기 여부확인 -->
  <c:if test="${fn:containsIgnoreCase(str, 'h')}">
    <h4>H, h를 포함한다.</h4>
  </c:if>

  <!--  스크립트 문자열로 입력시 실행되지 않도록 막는다. -->
  <c:set var="words" value="${fn:split(str, ' ')}" />
  <c:forEach var="word" items="${words}">
    <h4>${word}</h4>
  </c:forEach>
  <h4>${fn:join(words, ' ')}</h4>

  <c:set var="str2" value="<script>alert('hahaha')</script>" />
  ${fn:escapeXml(str2)}

</body>
</html>