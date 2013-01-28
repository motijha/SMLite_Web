<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@page import="com.assignment.vendor.dao.OrderType"%>

<%@page import="com.assignment.vendor.dao.Vendor"%>
<%@page import="com.assignment.vendor.helper.DBHelper"%>
<%@page import="java.util.List"%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spend Management System</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/vendor.js"></script>
</head>
<body>
Spend Management!
	<div style="margin: 100px 0 0 100px;">
	<div id="divAddEditVendor" style="display: none;">
			<div id="addUpdateFormTitle"
				style="margin-bottom: 10px; text-decoration: underline; font-weight: bold;"></div>
			<div id="divErrMsg" style="margin-bottom: 10px; color: #FF0000"></div>
			<form id="addUpdateVendor" name="addUpdateVendor" action="#">
				<td><input type="hidden" id="id" name="id" value="" /></td>
				<table cellpadding="5">
					<tr valign="middle">
						<td>Name</td>
						<td><input type="text" id="name" name="name" value="" /></td>
					</tr>
					<tr valign="top">
						<td>Purchase Order</td>
						<td><input type="radio" name="purchaseOrderAvailable"
							value="true" onchange="enablePurchaseDetails(true)">&nbsp;&nbsp;Available
							<br> <input type="radio" name="purchaseOrderAvailable"
							value="false" onchange="enablePurchaseDetails(false)">&nbsp;&nbsp;Not
							Available</td>
					</tr>
					<tr valign="top">
						<td>Purchase Number</td>
						<td><input type="text" id="purchaseNumber"
							name="purchaseNumber" value="" /></td>
					</tr>
					<tr valign="top">
						<td>Purchase Order Type</td>
						<td><select id="orderType" name="orderType">
							
						</select></td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="btn" type="button" id="btnSave"
								onclick="saveVendor()">Add/Update</button>
							<button class="btn" type="button" id="btnReset"
								onclick="resetVendorForm()">Reset</button>
							<button class="btn" type="button" id="btnCancel"
								onclick="hideVendorForm()">Cancel</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div> 
</body>
</html>