<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/10/24
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my app</title>
  <link rel="stylesheet" type="text/css" href="../extjs/resources/css/ext-all.css">
  <script type="text/javascript" src="../extjs/ext-all-debug.js"></script>
</head>
<body>
<script type="text/javascript">
  Ext.Loader.setConfig({
    enabled: true,
    paths: {
      'APP': '<c:url value="/login-app"/>'
    }
  });
</script>
<script type="text/javascript">
  Ext.require( "APP.view.AppViewPort");
  Ext.QuickTips.init();

  Ext.onReady(function() {
    Ext.create("APP.view.AppViewPort",{});
  });
</script>
</body>
</html>
