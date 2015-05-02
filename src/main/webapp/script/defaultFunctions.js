var Utils = {
	
	callService : function($scope, $http, url, soap, callback){
		
		var responsePromise;
		
		if(soap) {
			responsePromise = $http.post("http://manualdosnoivos-manualdosnoivos.rhcloud.com:80/services/Casamento",soap);
		} else {
			responsePromise = $http.get("http://manualdosnoivos-manualdosnoivos.rhcloud.com/rest/servicoscasamento/servicos");
		}
		
		responsePromise.success(function(data, status, headers, config) {
			callback(data);
		});
		responsePromise.error(function(data, status, headers, config) {
			console.log(status);
		});
	}
}
