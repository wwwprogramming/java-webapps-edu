<html>

<head>
        <meta charset="UTF-8" >
	<title>DHTML Harkka</title>

	<script src="/resources/media/js/jquery-2.1.4.js"></script>
	<script src="/resources/media/js/lodash.js"></script>
	<script src="/resources/media/js/moment.js"></script>
	<script src="/resources/media/js/bootstrap.js"></script>

        <!--
        react. and babel to do inline jsx
        -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.1.0/react.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.1.0/react-dom.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>

        <link rel="stylesheet" type="text/css" href="/resources/media/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/resources/media/css/bootstrap-theme.css">


</head>

<body>

<h1>Template for dynamic table application in React</h1>

<pre>
Tee seuraavat toiminnot.

Lisäää rivi painike avaa rivin, jossa on lomake-elementtejä.
 Lomakkeella kysytään title ja pvm ja aika.
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
	<div id="application" class="row">
		<!-- <div class="col-md-4">

                    <button id="savebtn1" class="btn btn-default" type="button">Tallenna Taulukko</button>
		</div>

		<div class="col-md-8" >

                </div>
		-->
	</div>
    <!--
        <script type="text/javascript" src="app.es5.js"></script>
    -->
        <script type="text/babel" >
            var ExampleApplication = React.createClass({
                displayName: 'ExampleApplication',
                getInitialState: function() {
                    return {rows: this.props.rows};
                },
                handleSaveTable: function(e) {
                    //this.setState({author: e.target.value});
                    console.log("handleSaveTable");
                    console.log(this.state.rows);
                    // TODO save table to server or what ever.

                },
                handleRemoveRow: function(row) {
                    console.log("TOP LEVEL: handleRemoveRow");
                    console.log(row);
                    var remains = _.filter(this.state.rows, function(_row) {
                        return parseInt(_row.id) !== parseInt(row.id);
                    });
                    console.log(remains);
                    // these are the new state
                    this.setState({rows: remains});
                },
                handleAddRow: function(row) {
                    var rows = this.state.rows;
                    rows.push(row);
                    this.setState({rows: rows});
                },
                render: function() {
                  return (
                    <div>
                        <div className="col-md-4">
                            <SaveButton save={this.handleSaveTable} />
                        </div>
                        <div className="col-md-8" >
                            <ExampleTable rows={this.state.rows} handleAddRow={this.handleAddRow} handleRemoveRow={this.handleRemoveRow}/>
                        </div>
                    </div>
                    )
                }
              });

              var SaveButton = React.createClass({
                displayName: 'SaveButton',

                render: function() {
                  return (
                      <button onClick={this.props.save} id="savebtn1" className="btn btn-default" type="button">Tallenna Taulukko</button>
                    )
                }
              });

////////////////////////////////////////////////////////////////////////////////

             var TrForm = React.createClass({
                displayName: 'TrForm',
                getInitialState: function() {
                    return {id: this.props.ndx, title:"notitle", dt: moment().format("DD.MM.YYYY 12:00")};
                },

                handleTitleChange: function(e) {
                    console.log(e.target.value);
                    this.setState({title: e.target.value});
                },
                handleDtChange: function(e) {
                    console.log(e.target.value);
                    this.setState({dt: moment(e.target.value, "DD.MM.YYYY HH:mm")})
                },
                handleSave: function() {
                    this.props.handleSave({
                        id: this.state.id,
                        title: this.state.title,
                        dt: this.state.dt
                    });
                },

                render: function() {

                  return (
                      <tr>
                      <td>{this.props.ndx}</td>
                      <td><input type="text" onChange={this.handleTitleChange} /></td>
                      <td><input type="text" onChange={this.handleDtChange} /></td>
                      <td>
                        <span onClick={this.handleSave} className="btn glyphicon glyphicon-plus"></span>
                        <span onClick={this.props.handleCancel} className="btn glyphicon glyphicon-remove-sign"></span></td>
                        </tr>
                    )
                }
              });

              var TrNode = React.createClass({
                displayName: 'TrNode',

                render: function() {
                  return (
                        <tr >
                            <td>{this.props.data.id}</td>
                            <td>{this.props.data.title}</td>
                            <td>{this.props.data.dt.format("DD.MM.YYYY HH:mm")}</td>
                            <td><span onClick={() => this.props.handleRemove(this.props.data)} className="btn glyphicon glyphicon-remove-sign"></span></td>
                        </tr>
                    )
                }
              });

////////////////////////////////////////////////////////////////////////////////

              var ExampleTable = React.createClass({
                displayName: 'ExampleTable',
                getInitialState: function() {
                    return { showForm: false };
                },
                handleRemove: function(e) {
                    console.log("1... about to remove ");
                    console.log(e);
                    console.log(this.state);
                    console.log(this.props);
                    this.props.handleRemoveRow(e);

                },
                openForm: function(e) {
                    this.setState({showForm: true});
                },
                saveForm: function(e) {
                    this.setState({showForm: false});
                },
                cancelForm: function(e) {
                    this.setState({showForm: false});
                },
                handleSaveForm: function(e) {
                    //this.setState({author: e.target.value});
                    console.log("handleSaveForm");
                    console.log(e);
                    // TODO SAVE FORM aka ADD ROW TO STATE
                    this.props.handleAddRow(e);
                    this.setState({showForm: false});
                },
                handleCancelForm: function(e) {
                    //this.setState({author: e.target.value});
                    console.log("handleCancelForm");
                    this.setState({showForm: false});
                },
                render: function() {
                    console.log("render table");
                    console.log(this.props);
                    console.log(this.state);

                    var ndx = this.props.rows.length ? (_.maxBy(this.props.rows, "id").id +1) : 0;

                    var rowNodes = this.props.rows.map(function(row) {
                    return (
                        <TrNode key={row.id} data={row} handleRemove={this.handleRemove}/>
                    );
                  },
                    this);
                  return (
                    <div>
                    <table className="table table-striped"><thead><tr><th>Id</th><th>Title</th><th>Date</th><th>#</th></tr></thead>
                        <tbody>
                            {rowNodes}
                            { this.state.showForm ? <TrForm handleSave={this.handleSaveForm} handleCancel={this.handleCancelForm} ndx={ndx}   /> : null }

                        </tbody>
                      </table>
                      <button onClick={this.openForm} disabled={this.state.showForm ? "disabled": ""} className="btn btn-default glyphicon glyphicon-edit" type="button">Add Row</button>
                      </div>
                    )
                }
              });


            var rows = [
                {key:1, id:1, title: "A1", dt: moment()},
                {key:2, id:2, title: "A2", dt: moment()}
            ];

            ReactDOM.render(
                <ExampleApplication rows={rows} />,
                document.getElementById('application')
            );

        </script>

</div>

</body>

</html>