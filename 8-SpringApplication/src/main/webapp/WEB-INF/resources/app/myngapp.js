
var myApp = angular.module('myApp', ['ui.calendar', 'ui.bootstrap']);

myApp.controller('MyApplicationController', function($scope,$http) {
    console.log("MyApplicationController");

    $scope.state = {
        "greeting": "Hello",
        "greeting2": "Hello2"
    };


  });

  myApp.run(function($templateCache) {
    $templateCache.put('pregreeting.html', '<span>{{state.greeting}}</span>');
  });