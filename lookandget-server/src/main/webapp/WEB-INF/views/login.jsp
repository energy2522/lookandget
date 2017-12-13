<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Start Page</title>


    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">


</head>

<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <div class="sign-in-htm">
                <form action="${contextPath}/login" method="post">
                <div class="group">
                    <label for="username" class="label">Username</label>
                    <input id="username" name="username" type="text" class="input">
                </div>
                <div class="group">
                    <label for="password" class="label">Password</label>
                    <input id="password" name="password" type="password" class="input" data-type="password">
                </div>
                <div class="group">
                    <%--<input id="check" type="checkbox" class="check" checked>--%>
                    <%--<label for="check"><span class="icon"></span> Keep me Signed in</label>--%>
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign In">
                </div>
                </form>
                <c:if test="${error != null}">
                    <h2 style="color: darkred; text-align: center">${error}</h2>
                </c:if>
                <div class="hr"></div>
<%--                <div class="foot-lnk">
                    <a href="#forgot">Forgot Password?</a>
                </div>--%>
            </div>
            <div class="sign-up-htm">

                <form action="${contextPath}/registration" method="post">
                <div class="group">
                    <label for="username" class="label">Username</label>
                    <input id="username" name ="username" type="text" class="input">
                </div>
                <div class="group">
                    <label for="password" class="label">Password</label>
                    <input id="password" name="password" type="password" class="input" data-type="password">
                </div>
<%--                <div class="group">
                    <label for="password-repit" class="label">Repeat Password</label>
                    <input id="password-repit" type="password" class="input" data-type="password">
                </div>--%>
                <div class="group">
                    <label for="email" class="label">Email Address</label>
                    <input id="email" name="password" type="text" class="input">
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign Up">
                </div>
                </form>
                <div class="hr"></div>
<%--                <div class="foot-lnk">
                    <label for="tab-1">Already Member?</a>
                </div>--%>
            </div>
        </div>
    </div>
</div>


</body>
</html>

