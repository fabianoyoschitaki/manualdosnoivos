(function(){
	var app = angular.module('listaCasamento', []);

	app.controller('CasamentoController', function($scope, $http){
		this.casamentos = [];
		
		var soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.manualdosnoivos.com.br/\">"+
					   "<soapenv:Header/>"+
					  "<soapenv:Body>"+
						  "<ser:listarCasamentos>"+
							 "<data>?</data>"+
						  "</ser:listarCasamentos>"+
					   "</soapenv:Body>"+
					"</soapenv:Envelope>";
		
		var url = "http://manualdosnoivos-manualdosnoivos.rhcloud.com:80/services/Casamento";
		Utils.callService($scope, $http, url, soap, function(data){
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
