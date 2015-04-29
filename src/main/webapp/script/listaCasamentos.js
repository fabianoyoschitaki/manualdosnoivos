(function(){
	var app = angular.module('listaCasamento', []);

	app.controller('CasamentoController', function($scope, $http){
		this.casamentos = getListaCasamentos($http);
		
	});
	
	
	function getListaCasamentos($http){
		var casamentos = [];
		
		var soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.manualdosnoivos.com.br/\">"+
					   "<soapenv:Header/>"+
					  "<soapenv:Body>"+
						  "<ser:listarCasamentos>"+
							 "<data>?</data>"+
						  "</ser:listarCasamentos>"+
					   "</soapenv:Body>"+
					"</soapenv:Envelope>";
		
		// var xhr = $.ajax({
			// url: "http://manualdosnoivos-manualdosnoivos.rhcloud.com:80/Casamento",
			// type: "POST",
			// data: soap,
			// timeout: 15000,
			// //dataType: "text",
			// contentType: "text/xml;charset=UTF-8;SOAPAction=\"\"",
			// success: function(data) {
			// },
			// error: function(data) {
			// }
		// });
		
		var responsePromise = $http.post("http://manualdosnoivos-manualdosnoivos.rhcloud.com:80/Casamento",soap);

		responsePromise.success(function(data, status, headers, config) {
			console.log(data);
		});
		responsePromise.error(function(data, status, headers, config) {
			console.log(data);
		});
		return casamentos;
	}
})()