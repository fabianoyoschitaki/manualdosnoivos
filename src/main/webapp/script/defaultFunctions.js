var Utils = {
	
	callService : function($scope, $http, url, callback){
		var soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.manualdosnoivos.com.br/\">"+
					   "<soapenv:Header/>"+
					  "<soapenv:Body>"+
						  "<ser:listarCasamentos>"+
							 "<data>?</data>"+
						  "</ser:listarCasamentos>"+
					   "</soapenv:Body>"+
					"</soapenv:Envelope>";
		
		var responsePromise = $http.post("http://manualdosnoivos-manualdosnoivos.rhcloud.com:80/services/Casamento",soap);
		// var responsePromise = $http.get("http://manualdosnoivos-manualdosnoivos.rhcloud.com/rest/servicoscasamento/servicos");

		responsePromise.success(function(data, status, headers, config) {
			// console.log(data);
			callback(data);
			// var xml = $.parseXML(data);
			// var casamentos = [];
			// $("casamento", xml).each(function(){
				// var casamento = {};
				// casamento.casal = $(this).text();
				// casamentos.push(casamento);
			// });
			// $scope.casamento.casamentos = casamentos;
		});
		responsePromise.error(function(data, status, headers, config) {
			console.log(data);
		});
	}
}
