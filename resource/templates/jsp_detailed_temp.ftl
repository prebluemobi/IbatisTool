<%@page import="com.bluemobi.www.utils.PropertyReader"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = "/config.properties";
    String v = PropertyReader.getValue(path, "images.url");
 %>
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1" />
<title>${dd}{title}</title>

<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet" href="css/common.css" type="text/css"></link>
<link rel="stylesheet" href="css/layout.css" type="text/css"></link>
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" href="css/slide/apply.css" type="text/css"></link>
<link rel="stylesheet" href="css/slide/public.css" type="text/css"></link>
<link rel="stylesheet" href="css/slide/share.css" type="text/css"></link>
<script type="text/javascript" src="scripts/slide/swiper-2.1.min.js"></script>
<script type="text/javascript" src="scripts/issue/detailed.js"></script>
</head>

<body>
	<div class="w tc f20 mt10">${dd}{data.title}</div>
	<div class="w mt30 h30">
		<div class="fl pl5">${dd}{data.marineSysUnit.unitname}</div>
		<div class="fr pr5 f12 color">
			${dd}{data.issueBegtime}
		</div>
	</div>
	<c:if test="${dd}{!empty data.marinePictureInfoList && data.marinePictureInfoList.size()>0}">
	<!--焦点图开始-->
	<div class="swiper-container overflow">
		<div class="swiper-wrapper" id="swiper-wrapper">
			<c:forEach var="marinePictureInfo"
				items="${dd}{data.marinePictureInfoList}">
				<div class="swiper-slide">
					<a href="#"><img src="<%=v %>${dd}{marinePictureInfo.path}" class="wb98">
					</a>
				</div>
			</c:forEach>
		</div>
		<div class="pagination"></div>
	</div>
	</c:if>
	<div class="p10 mb30">${dd}{data.articleContent}</div>
	<c:if
		test="${dd}{!empty data.attAliasurl || !empty data.videoattAliasurl }">
		<div class="p5 download">
			<div class="pt5">
				<c:if test="${dd}{!empty data.attAliasurl}">
					<a href="dowload?fileName=${dd}{data.attAliasurl }"><img
						src="images/sys_02.gif" /> </a>
				</c:if>
				<c:if test="${dd}{!empty data.videoattAliasurl}">
					<a href="${dd}{data.videoattAliasurl }"><img
						src="images/sys_01.gif" class="ml15" /> </a>
				</c:if>
			</div>
		</div>
	</c:if>
</body>
</html>
