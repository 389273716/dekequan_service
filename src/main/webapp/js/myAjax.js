$.extend({
	myAjax : function( url, params, method ) {
		$.ajax({
			url : url,
			data : params,
			type : method,
			success : function( data ) {
				return data;
			},
			error : function() {
				// 请求一次 go-to
			}	
		});
	},
	login : function ( url, params, method ) {
		$.ajax({
			url : url,
			data : params,
			type : method,
			success : function( data ) {
				var reponse = JSON.parse(data);
				if (reponse.re == 1) {
					window.location.href = reponse.data;
				}
			},
			error : function() {
				// 请求一次 go-to
			}	
		});
	}
});