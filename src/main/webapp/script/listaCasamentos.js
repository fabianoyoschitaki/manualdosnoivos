(function(){
	var app = angular.module('listaCasamento', []);

	app.controller('CasamentoController', function(){
		this.casamentos = getListaCasamentos();
	});
	
	
	function getListaCasamentos(){
		var casamentos = [];
		
		var soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.manualdosnoivos.com.br/\">"+
					   "<soapenv:Header/>"+
					  "<soapenv:Body>"+
						  "<ser:listarCasamentos>"+
							 "<data>?</data>"+
						  "</ser:listarCasamentos>"+
					   "</soapenv:Body>"+
					"</soapenv:Envelope>";
		
		var xhr = $.ajax({
			url: "http://manualdosnoivos-manualdosnoivos.rhcloud.com:80/Casamento",
			type: "POST",
			data: soap,
			timeout: 15000,
			//dataType: "text",
			contentType: "text/xml;charset=UTF-8;SOAPAction=\"\"",
			success: function(data) {
			},
			error: function(data) {
			}
		});
		return casamentos;
	}
})()