<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.referspark.util.ClientUtil" %>
<%
String couponCode = request.getParameter("couponcode");
String ipAddress = request.getRemoteHost();
byte[] imageBytes = new ClientUtil().getImageAsBytes("http://referspark.com/assets/images/email.jpg", ipAddress, config, couponCode); 
response.setContentType("image/jpeg");
if(imageBytes != null){
	response.setContentLength(imageBytes.length); 
	response.getOutputStream().write(imageBytes); 
}
%>