(function(){
	var app = angular.module('listaCasamento', []);

	app.controller('CasamentoController', function($scope, $http){
		this.casamentos = [];
		
		Utils.callService($scope, $http,url, function(data){
			var xml = $.parseXML(data);
			var casamentos = [];
			$("casamento", xml).each(function(){
				var casamento = {};
				casamento.casal = $(this).text();
				casamentos.push(casamento);
			});
			$scope.casamento.casamentos = casamentos;
		});
	});
})()	
