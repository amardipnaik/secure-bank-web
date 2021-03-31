app.config(function($routeProvider, $locationProvider)
{
	/*alert("config called");*/
	$routeProvider.when('/', {
		templateUrl : 'views/myProfile.jsp',
		controller : 'detailsControllers'
	}).when('/viewUser.htm', {
		templateUrl : 'views/viewUser.jsp',
		controller : 'detailsControllers'
	})
	.when('/aboutUser.htm', {
		templateUrl : 'views/aboutUser.jsp',
		controller : 'detailsControllers'
	})
		.when('/myProfile.htm', {
		templateUrl : 'views/myProfile.jsp',
		controller : 'detailsControllers'
	}).when('/myTransaction.htm', {
		templateUrl : 'views/transaction.jsp',
		controller : 'detailsControllers'
	}).when('/viewTransaction.htm', {
		templateUrl : 'views/viewTransaction.jsp',
		controller : 'detailsControllers'
	}).when('/viewTransactionAdmin.htm', {
		templateUrl : 'views/viewTransactionAdmin.jsp',
		controller : 'detailsControllers'
	})

});

