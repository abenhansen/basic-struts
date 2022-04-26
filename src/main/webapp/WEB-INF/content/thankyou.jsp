<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Registration Successful</title>
  <s:head/>
</head>
<body>
<h3><s:text name="thankyou" /></h3>

<p>Your new information: <s:property value="personBean" /> </p>

<s:if test="personBean.over21">
  <p>You are old enough to vote!</p>
</s:if>
<s:else>
  <p>You are NOT old enough to vote.</p>
</s:else>

<s:if test="personBean.carModels.length > 1">
<p>Car models
  </s:if>
  <s:else>
<p>Car model
  </s:else>

<table style="margin-left:15px">
  <s:iterator value="personBean.carModels">
    <tr><td><s:property /></td></tr>
  </s:iterator>
</table>

<p>States</p>
<table style="margin-left:15px">
  <s:iterator value="states" >
    <tr><td><s:property value="stateAbbr" /></td> <td><s:property value="stateName" /></tr>
  </s:iterator>
</table>


<s:url action="index" var="indexLink">
  <s:param name="debug">browser</s:param>
  <s:param name="object">action</s:param>
</s:url>
<p><a href="${indexLink}">Reload this page with debugging</a></p>

<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
</body>
</html>