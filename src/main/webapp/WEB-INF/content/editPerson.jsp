<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:head />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Struts 2 Form Tags - Edit Person</title>
</head>
<body>
<h1>Update Information</h1>

<p>Use the form below to edit your information.</p>

<s:form action="saveOrUpdatePerson" method="post" theme="KUTheme">
    <s:hidden name="personBean.id" />
    <s:textfield key="personBean.firstName" />
    <s:textfield key="personBean.lastName" />
    <s:textfield key="personBean.email" />
    <s:textfield key="personBean.phoneNumber" />
    <s:textfield key="personBean.age" />
    <s:select key="personBean.sport" list="sports" />
    <s:radio key="personBean.gender" list="genders" />
    <s:select key="personBean.residency" list="states" listKey="stateAbbr" listValue="stateName" />
    <s:checkbox key="personBean.over21" />
    <s:checkboxlist key="personBean.carModels" list="carModelsAvailable" />
    <s:submit key="submit" />
</s:form>

</body>
</html>