<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Debugging Struts 2 - Welcome</title>
  <s:head/>
</head>
<body>
<h1>Welcome To Struts 2!</h1>
<p><a href="<s:url action='hello'/>">Hello World</a></p>
<s:url action="hello" var="helloLink">
  <s:param name="userName">Bruce Phillips</s:param>
</s:url>
<p><a href="${helloLink}">Hello Bruce Phillips</a></p>


<s:url action="registerInput" var="registerInputLink" />
<p><a href="${registerInputLink}">Please register</a> for our prize drawing.</p>

<p><a href='<s:url action="editPerson" />' >Edit your information</a></p>
<p><a href='<s:url action="people" />' >View Participants</a></p>


<h3>Registrer på dansk</h3>
<s:url action="registerInput" var="registerInputLinkDA">
  <s:param name="request_locale">da</s:param>
</s:url>
<p><s:a href="%{registerInputLinkDA}">Venligst registrere</s:a> for at deltage i vores pris udtrækning</p>

<hr />
<p><a href='<s:url action="causeexception" />'>Cause Exception</a></p>
<p><a href='<s:url action="causenullpointerexception" />'>Cause Null Pointer Exception</a></p>
<p><a href='<s:url action="causesecurityexception" />'>Cause Global Security Exception</a></p>
<p><a href='<s:url action="actionspecificexception" />'>Cause ActionSpecific Security Exception</a></p>
<p><a href="<s:url action="index" namespace="config-browser" />">Launch the configuration browser</a></p>
<s:url action="index" var="indexLink">
  <s:param name="debug">browser</s:param>
  <s:param name="object">action</s:param>
</s:url>
<p><a href="${indexLink}">Reload this page with debugging</a></p>
<hr />
<s:text name="contact" />
</body>
</html>