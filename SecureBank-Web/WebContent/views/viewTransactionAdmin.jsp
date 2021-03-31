<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th , td  {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>
<body>
<h3>View Transaction</h3>
<table>
<th>Sr.No</th>
<th>Bank Name</th>
<th>Trasaction Type</th>
<th>city</th>
<th>state</th>

<th>City</th>
<th>amount</th>
<th>User Account Number</th>
<th>Benificiary Account Number</th>
<th>Benificiary IFSC Code</th>
<th>Trasaction Date</th>

  <tr ng-repeat="x in transactionList">
     <td>{{ $index + 1 }}</td>
    <td>{{ x.bankName }}</td>
    <td>{{ x.trasactionType}}</td>
     <td>{{ x.city}}</td>
     <td>{{ x.state}}</td>
  
      <td>{{ x.city}}</td>
        <td>{{ x.amount}}</td>
        <td>{{ x.userAccountNumber}}</td>
         <td>{{ x.benificiaryAccountNumber}}</td>
         <td>{{ x.benificiaryIFSCCode}}</td>
          <td>{{ x.trasactionDate}}</td>
         
      
     
  </tr>
</table>
</body>
</html>