<!-- http://thisthread.blogspot.com/2017/05/showing-single-spittle.html -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="spittleView">
      <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
      <div class="spittleTime"><c:out value="${spittle.time}" /></div>
      <div class="spittlePos"><c:out value="${spittle.longitude}, ${spittle.latitude}" /></div>
    </div>
  </body>
</html>