


<h2>Add Transaction</h2>

   <b>    Bank Name:</b>
<select name="bankName"  id="bankName">
     <option>SBI Bank</option>
     <option>Kotak Bank</option>
     <option>ICICI Bank</option>
      <option>Axis Bank</option>
       <option>HDFC Bank</option>
</select>
  <b>   Trasaction Type :</b>
<select name="ttype"  id="ttype">
     <option>Net Banking</option>
     <option>NEFT</option>
     <option>IMPS</option>
</select>

    <b>    City :</b>
     <input type="text" placeholder="Enter City Name" name="ct" id="ct" /><br>
     
     <b> State :</b>
     <input type="text" placeholder="Enter State Name" name="ste" id="ste" />
        

<b> amount :</b>
     <input type="text" placeholder="Enter Amount Name" name="amt" id="amt" /><br>
     
     <b> User/My Account Number :</b>
     <input type="text" placeholder="Enter Account Number" name="uac" id="uac" /><br>
     
      <b> Beneficiary Account Number :</b>
     <input type="text" placeholder="Enter Account Number" name="bac" id="bac" /><br>
     
      <b> Benificiary IFSC Code :</b>
     <input type="text" placeholder="Enter IFSC Number" name="ifc" id="ifc" /><br>
    

     
     <button ng-click="addTrasaction()">Add Transaction</button>
     
