/**
 * Angular Controller 
 */

var app = angular.module('ipropel', []);

app.controller('ipropelController', function($scope, $http){
	
	console.log('Inside ipropelController');
	
	//$scope.fetchCompanyList();
	
	$scope.loginRole='default';
	
	$scope.registrationData={
		role: $scope.loginRole,
		firstname: $scope.firstname,
		lastname: $scope.lastname,
		username: $scope.username,
		password: $scope.password,
		email: $scope.email,
		phone: $scope.phone,
		skills: {
			skill1: $scope.skill1,
			skill2: $scope.skill2,
			skill3: $scope.skill3
		},
		aboutMe: $scope.aboutMe
			
	}
	
	$scope.registerUser=function(){
		console.log('Printing values from model -->');
		console.log('loginRole --> '+$scope.loginRole);
		console.log('Name --> '+$scope.firstname + $scope.lastname);	
		console.log('Username --> '+$scope.username);
		console.log('Email --> '+$scope.email);
		console.log('Password --> '+$scope.password);
		console.log('Phone --> '+$scope.phone);
		console.log('Skills --> '+$scope.skill1 + $scope.skill2 + $scope.skill3);
		console.log('AboutMe --> '+$scope.aboutMe);
	
		
		
		$http.post("welcome.htm", registrationData)
	    .then(function(data) {
	    	console.log('data from register user response: '+data);
	        $scope.myWelcome = data;
	    });
	}
	
	$scope.fetchingCompanies=function(){
		console.log('Inside fetchingCompanies' + $scope.loginRole);
		if($scope.loginRole=='recruiter'){
			$scope.fetchCompanyList();
		}
	}
	
	$scope.fetchCompanyList=function(){
		
		console.log('Inside fetchCompanyList');
		$http.get("getCompanies.htm")
	    .success(function(data) {
	    	console.log('data from register user response: '+data);
	        $scope.companyList = data;
	    });
	}
	
	
});