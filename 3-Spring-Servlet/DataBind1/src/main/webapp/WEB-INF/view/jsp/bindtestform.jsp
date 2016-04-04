<%@ include file="../init.jspf" %>


<h2>Just Bind</h2>

<form action="/binddemo/post" method="POST" enctype="application/x-www-form-urlencoded">
    <table>
    <tr>
        <th>Numbers sold</th><td><input type="text" name="numSold" value="12" /></td>
    </tr>
    <tr>
        <th>Car</th><td><input type="text" name="car" value="Ford"/></td>
    </tr>
    <tr>
<th>ExpensiveCar (ferrari or bugatti)</th><td><input type="text" name="expensiveCar" value="ferrari" /></td>
</tr>
<tr>
<th>CheapCar</th>
<td><select name="cheapCar" >
<option value="lada">Lada</option><option value="fiat">Fiat</option></select>
</td></tr>
<tr><th></th><td><input type="submit" /></td></tr>
</table>
</form>

<hr />

<h2>Valid Test</h2>

<form action="/binddemo/valid" method="POST" enctype="application/x-www-form-urlencoded">
    <table>
    <tr>
        <th>Numbers sold</th><td><input type="text" name="numSold" value="12" /></td>
    </tr>
    <tr>
        <th>Car</th><td><input type="text" name="car" value="Ford"/></td>
    </tr>
    <tr>
<th>ExpensiveCar (ferrari or bugatti)</th><td><input type="text" name="expensiveCar" value="ferrari" /></td>
</tr>
<tr>
<th>CheapCar</th>
<td><select name="cheapCar" >
<option value="lada">Lada</option><option value="fiat">Fiat</option></select>
</td></tr>
<tr><th></th><td><input type="submit" /></td></tr>
</table>
</form>

<h2>Validated Test </h2>

<form action="/binddemo/validated" method="POST" enctype="application/x-www-form-urlencoded">
    <table>
    <tr>
        <th>Numbers sold</th><td><input type="text" name="numSold" value="12" /></td>
    </tr>
    <tr>
        <th>Car</th><td><input type="text" name="car" value="Ford"/></td>
    </tr>
    <tr>
<th>ExpensiveCar (ferrari or bugatti)</th><td><input type="text" name="expensiveCar" value="ferrari" /></td>
</tr>
<tr>
<th>CheapCar</th>
<td><select name="cheapCar" >
<option value="lada">Lada</option><option value="fiat">Fiat</option></select>
</td></tr>
<tr><th></th><td><input type="submit" /></td></tr>
</table>
</form>

<h2>Me Valid Seld My</h2>

<form action="/binddemo/validmanual" method="POST" enctype="application/x-www-form-urlencoded">
    <table>
    <tr>
        <th>Numbers sold</th><td><input type="text" name="numSold" value="12" /></td>
    </tr>
    <tr>
        <th>Car</th><td><input type="text" name="car" value="Ford"/></td>
    </tr>
    <tr>
<th>ExpensiveCar (ferrari or bugatti)</th><td><input type="text" name="expensiveCar" value="ferrari" /></td>
</tr>
<tr>
<th>CheapCar</th>
<td><select name="cheapCar" >
<option value="lada">Lada</option><option value="fiat">Fiat</option></select>
</td></tr>
<tr><th></th><td><input type="submit" /></td></tr>
</table>
</form>

