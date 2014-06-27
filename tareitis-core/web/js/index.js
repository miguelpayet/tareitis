(function ($, undefined) {
	
	tareitis = {
		
		login: function( evento ) {
			console.log('tareitis.login');
			var _f = document.forms[0];
			var _url = 'http://localhost:8080/login';
			var _data = 'username=' + _f.user.value + '&password=' + _f.password.value + '&remember=false';
			console.log(_data);
			$.ajax({url: _url, statusCode: {302: tareitis.loginExito}, error: tareitis.loginError, complete: tareitis.loginFin, type: 'POST', data: _data});
			return false;
		},
	
		loginError: function(jqXHR, textStatus, errorThrown ) {
			console.log('tareitis.loginError');
			console.log(jqXHR);
		},
		
		loginExito: function(data, textStatus, jqXHR ) {
			console.log('tareitis.loginExito');
		},

		loginFin: function(jqXHR, textStatus) {
			console.log('tareitis.loginFin');
		}
		
	};
	
	console.log('hola');
	
})(jQuery, undefined);

$(document).ready( function() {
	console.log($('#login'));
	$('#login').click(tareitis.login);
})