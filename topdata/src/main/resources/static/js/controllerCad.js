var app = angular.module('CadastroApp', []);

app.controller('CadastroController', function($scope, $http) {
    $scope.usuario = {};

    $scope.cadastrarUsuario = function() {
        // Aqui você pode enviar os dados para o backend (Spring Boot) usando $http.post
        // Exemplo:
        // $http.post('/api/usuarios', $scope.usuario)
        //    .then(function(response) {
        //        console.log(response.data);
        //    });
        alert('Usuário cadastrado com sucesso!');
    };
});
