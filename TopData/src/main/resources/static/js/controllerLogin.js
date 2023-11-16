

 var app=angular.module('myLogin', []);
 

app.controller('LoginController', function($scope, $http,$window) {
    $scope.credentials = {
        username: '',
        password: ''
    };
    var config = {
    headers: {
        'Content-Type': 'application/json'
    }
};
    $scope.login = function() {
        $http.post('/api/login', $scope.credentials,config)
            .then(function(response) {
                $window.sessionStorage.token = response.data.token;
                alert('Login bem-sucedido!');
            })
            .catch(function(error) {
                console.log(error);
                alert('Credenciais inválidas.');
            });
    };
});

app.factory('AuthInterceptor', function($q, $window, $injector) {
    return {
        request: function(config) {
            config.headers = config.headers || {};
            if ($window.sessionStorage.token) {
                config.headers.Authorization = 'Bearer ' + $window.sessionStorage.token;
            }
            
            // Adicionar token CSRF se necessário
            var csrfToken = $window.document.querySelector("meta[name='_csrf']").content;
            var csrfHeader = $window.document.querySelector("meta[name='_csrf_header']").content;

            if (csrfToken && csrfHeader) {
                config.headers[csrfHeader] = csrfToken;
            }

            return config;
        },
        responseError: function(rejection) {
            // Tratar erros de autenticação ou autorização
            return $q.reject(rejection);
        }
    };
});

   