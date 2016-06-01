<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page isELIgnored="false" %>
<html>

<head>

	<title>DHTML Harkka</title>

	<script src="/resources/media/js/jquery-2.1.4.js"></script>
	<script src="/resources/media/js/lodash.js"></script>
	<script src="/resources/media/js/moment.js"></script>
	<script src="/resources/media/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/media/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/resources/media/css/bootstrap-theme.css">

<script type="text/javascript">

jQuery(document).ready(function() {
	console.log("initialize your app");


	var app1 = (function() {
		var formopen = false;
		var rows = [
		//{id:1, name:"name-1", dt: moment()},
		//{id:2, name:"name-2", dt: moment()}
		];
		var counter = 0;

		var rowSkeleton = "<tr :id><td>:id</td><td>:name</td><td>:dt</td></tr>";
		var emptyTableSkeleton = "<tr><td colspan=\"4\">Taulukko on tyhj&auml;</td></tr>";


		var formSkeleton = "<tr><td>:id</td><td>:name</td><td>:dt</td></tr>";
		var table = jQuery("#dynamictable");
		var addBtn = jQuery("#addrowbtn");
		var saveBtn = jQuery("#savebtn1");
		var dtFormat = "DD.MM.YYYY";

		var app = {};

		app.init = function(initialRows) {
			if (initialRows) rows = initialRows;
			app.renderTable();
			addBtn.click(app.toggleForm);
			addBtn.attr("disabled",false);
			saveBtn.click(app.saveTable);
			counter =  rows.length;
		};

		app.saveTable = function() {
			console.log("--table--");
			console.log(rows);
			console.log(JSON.stringify(rows));
			$.ajax({
                    type:"POST",
                    //headers:
                    //    {"Content-type":"application/json"}
                    // ,
                    contentType: "application/json",
                    url: "/dhtml/post",
                    data: JSON.stringify(rows),
                    //processData: false,
                    success: function(msg) {
                        console.log(msg);
                    }
                });
               // CONTROLLERISSA:
               // public String a(@RequestBody List<HashMap<String,String> items) {
               // .....
               //}
			console.log("----table--");
		};

		app.renderTable = function() {
			console.log("renderTable");
			table.children().remove();
			var _newRows = [];
			localStorage.setItem("rows", JSON.stringify(rows));
			_.each(rows, function(row) {
				console.log(row);
				var _row = rowSkeleton.replace(":id", "id_" + row.id);
				_row = _row.replace(":id", row.id);
				_row = _row.replace(":name", row.name);
				_row = _row.replace(":dt", row.dt.format(dtFormat));
				var removeBtn = jQuery("<span class=\"glyphicon glyphicon-remove-sign\"></span>");
				removeBtn.css("cursor", "pointer");
				var node = jQuery(_row);
				var actionTd = jQuery("<td></td>");
				actionTd.append(removeBtn);
				node.append(actionTd);

				// closure to close row.id value on each iteration
				// function closure or with es6 could use let

				(function(node,app,i) {
					console.log("remove will be clicked at " + i);
					node.click(function() { app.removeRow.apply(node, [i]); });
				})(node,app,row.id);

				_newRows.push(node);

			});
			if (_newRows.length === 0) {
				_newRows.push(jQuery(emptyTableSkeleton));
			}
			table.append("<tr><th>ID</th><th>TITLE</th><th>DATE</th><th>-</th></tr>");
			table.append(_newRows);
		};

		app.toggleForm = function() {
			console.log("toggleForm");
			console.log(formopen);
			if (formopen) {
				app.removeForm();
				addBtn.attr("disabled", false);
				formopen=false;
			} else {
				app.renderForm();
				addBtn.attr("disabled", true);
				formopen=true;
			}
		};

		app.renderForm = function() {
			console.log("renderForm");
			var _form = formSkeleton.replace(":name", "<input type='text' id='formname' value='name...' />")
			_form = _form.replace(":dt", "<input type='text' id='formdt' value='"+ (moment().format(dtFormat)) +"' />");

			_form = _form.replace(":id", "<input type='text' id='formid' value='" +( counter ) + "' />");
			var form = jQuery(_form);

			var saveBtn = jQuery("<span class='glyphicon glyphicon-plus'></span>");
			saveBtn.click(function() {app.addRow(form)});
			saveBtn.css("cursor", "pointer");
			var cancelBtn = jQuery("<span class='glyphicon glyphicon-remove-sign'></span>");
			cancelBtn.click(function() {app.cancelAddRow()});
			cancelBtn.css("cursor", "pointer");
			var actionTd = jQuery("<td></td>");
			actionTd.append(saveBtn);
			actionTd.append(cancelBtn);

			form.append(actionTd);
			console.log(form);
			table.append(form);
		};

		app.removeForm = function() {
			console.log("removeForm");
			console.log(table.find("tr").last());
			table.find("tr").last().remove();
		};

		app.addRow = function(form) {
			console.log("addRow");
			// save the added row
			// SHOULD VALIDATE
			var id = form.find("#formid").val();
			var name = form.find("#formname").val();
			var dt = moment(form.find("#formdt").val(), dtFormat);
			rows.push({
			"id": id,
			"name":name,
			"dt": dt
			})
			// THEN REMOVE THE FORM
			app.toggleForm();
			// THEN RENDER THE TABLE
			app.renderTable();
			counter++;
		};

		app.cancelAddRow = function() {
			// remove the last element of the table
			app.toggleForm();
		};

		app.removeRow = function(index) {
			console.log("removeRow("+index+")");
			console.log(rows);
			var remobedRows = _.remove(rows, function(row) {
				return parseInt(row.id) === parseInt(index);
			});
			app.renderTable();
		};

		return {
			init: app.init,
			getRows: function() {return app.rows}
		}



})();

    var rowsFromStorage = JSON.parse( localStorage.getItem("rows") || "[]" ) ;

    _.forEach(rowsFromStorage, function(row) {
        row.dt = moment(row.dt);
    });
    console.log(rowsFromStorage);
	app1.init(rowsFromStorage);


}); // end ready()

</script>

</head>

<body>

<h1>Template for dynamic table application</h1>

<pre>
Tee seuraavat toiminnot.

Lisää rivi painike avaa rivin, jossa on lomake-elementtejä.
 Lomakkeella kysytään id ja nimi.
 Painike Ok lisää annetut tiedot viimeiseksi riviksi taulukkoon.
 Vain yksi lomake voi olla auki kerrallaan.
 Lomakkeen voi sulkea täyttämättä ja tallentamatta.

Jokaisen rivin perässä on poista -painike, josta rivin voi poistaa.

Taulukon datan pitää olla javascript muuttujassa, josta taulukko sivun latauksen yhteydessä luodaaan,
 ja johon myös uudet lisätyt rivit talletetaan.

Tallenna taulukko kerää datan, joka talletettaisin ja tulostaa sen konsoliin.
 Tallennus tapahtuisi tietysti ajax kutsulla.
</pre>

<div class="container">
	<div class="row">
		<div class="col-md-4">

			<button id="savebtn1" class="btn btn-default" type="button">Tallenna Taulukko</button>
		</div>

		<div class="col-md-8">
			<table id="dynamictable" class="table table-striped">
				<tr><td>id-1</td><td>name-1</td><td>1.1.2013</td>
				<td><span class="glyphicon glyphicon-remove-sign"></span></td>
				</tr>
				<tr><td>id-2</td><td>name-2</td><td>1.1.2013</td>
				<td><span class="glyphicon glyphicon-remove-sign"></span></td>
				</tr>
				<tr><td><input /></td>
				<td><input /></td>
				<td><input /></td>
				<td>
				<span class="glyphicon glyphicon-plus"></span>
				<span class="glyphicon glyphicon-remove-sign"></span></td>
				</tr>
			</table>

			<button id="addrowbtn" class="btn btn-default glyphicon glyphicon-edit" type="button">Lis&auml;&auml; Rivi</button>
		</div>

	</div>

</div>

</body>


</html>