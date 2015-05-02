(function(){
	var app = angular.module('listaCasamento', []);

	app.controller('CasamentoController', function($scope, $http){
		this.casamentos = [];
		
		var url = "http://manualdosnoivos-manualdosnoivos.rhcloud.com:80/services/Casamento";
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
