

//////////////
////// EXAMPLE ANGULAR APP
////// TABLE EDITOR - ADD ROWS; REMOVE ROWS; 
////////////////////////////////////


// ui-bootstrap dependency just for datepicker
var myApp = angular.module("myApp", ['ui.bootstrap','example.table']);

// just to show save button event handler in different scope than table
myApp.controller('AppController', ['$scope', function($scope) {
  
  $scope.saveTable = function() {
      console.log("saveTable");
      console.log($scope.rows);
      
  };
  // data for table given from the parent scope
  $scope.rows = [
      //{id:1, title: "A1", dt: moment()},
      //{id:2, title: "A2", dt: moment()}
  ];
}]);


// directive - "view" for table


angular.module('example.table', [])
.controller("ExampleTableController", function($scope) {
 // 
    // Find max id the rows
    $scope.idx = $scope.rows.length ? _.maxBy($scope.rows, "id").id : 0;
    
    $scope.idx += 1;
    
    $scope.form = {
        id : $scope.idx,
        title: "no-title",
        dt: moment().format("DD.MM.YYYY HH:mm")
    };
    
    $scope.showForm = false;
    
    $scope.openForm = function() {
        console.log("showForm")
        $scope.form = {
            id : $scope.idx,
            title: "title-" + $scope.idx,
            dt: moment().format("DD.MM.YYYY HH:mm")
        };
        $scope.showForm = true;
    };
    
    $scope.remove = function(id) {
       console.log("remove("+id+")");
       _.remove($scope.rows, function(row) {
            return parseInt(row.id) === parseInt(id);
	});
    };
    
    $scope.cancel = function() {
        console.log("cancel");
        $scope.showForm = false;
    };
    
    $scope.save = function() {
        console.log("save");
        $scope.idx += 1;
        var _row = {
            id: $scope.form.id,
            title: $scope.form.title,
            dt: moment($scope.form.dt, "DD.MM.YYYY HH:mm")
        };
        $scope.showForm = false;
        $scope.rows.push(_row);
    };
    
    
})
.directive('exampleTable', function() {
  return {
    templateUrl: '/resources/ng/example-table.html',
    controller: 'ExampleTableController'
  };
});

