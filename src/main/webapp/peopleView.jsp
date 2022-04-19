<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Prize participants</title>
    <s:head/>
</head>
<body>
<h3>List of prize participants</h3>

<table style="margin-left:15px">
    <s:iterator value="people">
        <tr>
            <s:url action="editPerson" var="editUrl">
                <s:param name="id" value="id"/>
            </s:url>
            <td><s:property value="firstName"/></td>
            <td><s:property value="lastName"/></td>
            <td>
                <p><a href="<s:property value='#editUrl' />" >Edit</a></p>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>