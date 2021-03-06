 <%@page import="com.cisco.assignment.vendor.model.OrderType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.cisco.assignment.vendor.model.Vendor"%>
<%@page import="com.cisco.assignment.vendor.helper.DBSupportHelper"%> 
<%@page import="java.util.List"%>
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
	<div style="margin: 100px 0 0 100px;">
		<div id="vendorOperation" class="dropdown clearfix">
			<a id="drop1" href="#" role="button" class="dropdown-toggle"
				data-toggle="dropdown">Vendor Operation<b class="caret"></b></a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
				<li style="background: #5CB3FF; font-weight: bold;"><a tabindex="-1"
					href="javascript:showAddUpdateVendor(-1, true)">New</a></li>
				<li style="background: #5CB3FF; font-weight: bold;"><a tabindex="-1" href="javascript:location.reload();">Refresh</a></li>
			</ul>
			
		</div>
		<br><br>
		<div id="divVendorProjectionReportLink" style="margin-bottom: 5px;"><b><u><a tabindex="-1" href="javascript:showVendorReport()">Vendor Projection Report</a></u></b></div>			
		
		<br>
		<div id="divListOfVendors">
			<div style="margin-bottom: 5px;"><b><u>List of Vendors:</u></b></div>
			<table id="vendors" border="2" cellpadding="5px"
				style="font-size: 12px;">
				<thead>
					<tr style="background: #5CB3FF; font-weight: bold;">
						<td>ID</td>
						<td>Name</td>
						<td>Is Purchase Order Available?</td>
						<td>Purchase Number</td>
						<td>Purchase Type</td>
						<td>Purchase Cost</td>
						<td>Actions</td>
					</tr>
				</thead>
				<%
					DBSupportHelper dbSupportHelper = DBSupportHelper.getInstance();
				    dbSupportHelper.init();
					List<OrderType> listOrderTypes = dbSupportHelper.getOderTypes();				    
					List<Vendor> vendors = dbSupportHelper.getVendors();					
					if (vendors.size() == 0) {
				%>
				<tr>
					<td colspan="6" align="center">There are no vendors to
						display.</td>
				</tr>
				<%
					 } else {
						for (int i = 0; i < vendors.size(); i++) {
							Vendor vendor = vendors.get(i);
			%>
				  <tr>
					<td><%=vendor.getId()%></td>
					<td><%=vendor.getName()%></td>
					<td><%=vendor.isPurchaseOrderAvailable() ? "Yes" : "No"%></td>
					<td><%=vendor.isPurchaseOrderAvailable() ? vendor
							.getPurchaseNumber() : "N/A"%></td>
					<td><%=vendor.isPurchaseOrderAvailable() ? listOrderTypes
							.get(vendor.getOrderType() - 1).getName() : "N/A"%></td>
					<td><%= vendor.getCost()%></td>
					<td>
						<button class="btn" id="btnEdit<%=vendor.getId()%>"
							onclick="showAddUpdateVendor(<%=vendor.getId()%>, false)">Edit</button>
						<button class="btn" id="btnDelete<%=vendor.getId()%>"
							onclick="deleteVendor(<%=vendor.getId()%>, '<%=vendor.getName()%>')">Delete</button>
					</td>
				</tr> 
				 <%
					}
					}
				%>
			</table>
		</div>

        <div id="divVendorProjectionReport" style="display: none;">
			<div id="vendorProjectionReportFormTitle"
				style="margin-bottom: 10px; text-decoration: underline; font-weight: bold;"></div>
			<div id="divErrMsg" style="margin-bottom: 10px; color: #FF0000"></div>
			<form id="vendorProjectionReportForm" name="vendorProjectionReportForm" action="#">
				<table id="vendors" border="2" cellpadding="5px"
				style="font-size: 12px;">
				<thead>
					<tr style="background: #5CB3FF; font-weight: bold;">
						<td>ID</td>
						<td>Vendor</td>						
						<td>Purchase Type</td>
						<td>Purchase Cost</td>
						<td>Purchase Month</td>					
					</tr>
				</thead>
				<%
					/* DBSupportHelper dbSupportHelper = DBSupportHelper.getInstance();
				    dbSupportHelper.init();
					List<OrderType> listOrderTypes = dbSupportHelper.getOderTypes();				    
					List<Vendor> vendors = dbSupportHelper.getVendors();					
					if (vendors.size() == 0) { */
				%>
				<tr>
					<td colspan="6" align="center">There are no vendors to
						display.</td>
				</tr>
				<%
					 /* } else {
						for (int i = 0; i < vendors.size(); i++) {
							Vendor vendor = vendors.get(i);
		 */	%>
				  <%-- <tr>
					<td><%=vendor.getId()%></td>
					<td><%=vendor.getName()%></td>
					<td><%=vendor.isPurchaseOrderAvailable() ? "Yes" : "No"%></td>
					<td><%=vendor.isPurchaseOrderAvailable() ? vendor
							.getPurchaseNumber() : "N/A"%></td>
					<td><%=vendor.isPurchaseOrderAvailable() ? listOrderTypes
							.get(vendor.getOrderType() - 1).getName() : "N/A"%></td>
					<td><%= vendor.getCost()%></td>
					<td>
						<button class="btn" id="btnEdit<%=vendor.getId()%>"
							onclick="showAddUpdateVendor(<%=vendor.getId()%>, false)">Edit</button>
						<button class="btn" id="btnDelete<%=vendor.getId()%>"
							onclick="deleteVendor(<%=vendor.getId()%>, '<%=vendor.getName()%>')">Delete</button>
					</td>
				</tr>  --%>
				 <%
					//}
					//}
				%>
			</table>
			</form>
		</div>
	




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
						<td>Purchase Cost</td>
						<td><input type="text" id="cost"
							name="cost" value="" /></td>
					</tr>
					<tr valign="top">
						<td>Purchase Order Type</td>
						<td><select id="orderType" name="orderType">
							<% for (int i = 0; i < listOrderTypes.size(); i++) {
								%>
								<option value="<%= listOrderTypes.get(i).getId() %>"><%= listOrderTypes.get(i).getName()%></option>
							<%} %>
						</select></td>
					</tr>
					<tr>
						<td colspan="2">
							<button style="background: #5CB3FF; font-weight: bold; class="btn" type="button" id="btnSave"
								onclick="saveVendor()">Add/Update</button>
							<button style="background: #5CB3FF; font-weight: bold; class="btn" type="button" id="btnReset"
								onclick="resetVendorForm()">Reset</button>
							<button style="background: #5CB3FF; font-weight: bold; class="btn" type="button" id="btnCancel"
								onclick="hideVendorForm()">Cancel</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>