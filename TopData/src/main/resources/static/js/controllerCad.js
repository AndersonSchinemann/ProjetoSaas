var app = angular.module('CadastroApp',  []);

app.controller('CadastroController', function($scope, $http) {
    $scope.usuario = {};

    $scope.cadastrarUsuario = function() {
        // Aqui você pode enviar os dados para o backend (Spring Boot) usando $http.post
      $http.post('/api/usuarios/cad', $scope.usuario)
           .then(function(response) {
		        console.log(response.data);
		        // Exibir mensagem de sucesso
		        alert('Usuário cadastrado com sucesso!');
		        
		    })
		    .catch(function(error) {
		        console.log(error);
		        // Exibir mensagem de erro
		        alert('Erro ao cadastrar usuário. Por favor, tente novamente.');
			});
	  
	} 
	     
});



