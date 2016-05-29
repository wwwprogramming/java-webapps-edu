<html>

<head>
        <meta charset="UTF-8" >
	<title>DHTML Harkka</title>

	<script src="/resources/media/js/jquery-2.1.4.js"></script>
	<script src="/resources/media/js/lodash.js"></script>
	<script src="/resources/media/js/moment.js"></script>
	<script src="/resources/media/js/bootstrap.js"></script>

        <script src="/resources/media/js/angular.js"></script>
        <script src="/resources/media/js/ui-bootstrap-tpls-1.3.2.js"></script>

        <link rel="stylesheet" type="text/css" href="/resources/media/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/resources/media/css/bootstrap-theme.css">


        <script src="/resources/ng/application.js"></script>


<script type="text/javascript">

jQuery(document).ready(function() {
    console.log("initialize your app");
}); // end ready()

</script>

</head>

<body ng-app="myApp">

<h1>Template for dynamic table application in NG 1.4</h1>

<pre>
Tee seuraavat toiminnot.

Lisäää rivi painike avaa rivin, jossa on lomake-elementtejä.
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

<div class="container" ng-controller="AppController" >
	<div class="row">
		<div class="col-md-4">
                    <!-- managed by root application controller -->
                    <button ng-click="saveTable()" id="savebtn1" class="btn btn-default" type="button">Tallenna Taulukko</button>
		</div>

		<div class="col-md-8" data-example-table="" ng-model="rows" >
			<!-- directive -->
		</div>

	</div>

</div>

</body>


</html>