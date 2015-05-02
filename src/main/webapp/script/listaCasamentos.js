(function(){
	var app = angular.module('listaCasamento', []);

	app.controller('CasamentoController', function($scope, $http){
		this.casamentos = [];
		
		Utils.callService($scope, $http);
	});
})()	
