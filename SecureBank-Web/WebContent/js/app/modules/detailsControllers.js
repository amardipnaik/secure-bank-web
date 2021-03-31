app.controller("detailsControllers", [
		"$scope", '$location', 'mainService', '$log', 'localStorageService', "$timeout", "toaster", "$rootScope", 
		function($scope, $location, mainService, $log, localStorageService, $timeout, toaster, $rootScope)
		{
			
			$log.info("---Inside detailsControllers---");
			
			
			
			$scope.addTrasaction = function(data)
			{
				
				$scope.TrasactionBean = {
						userCode : '',
						bankName:'',
						trasactionType:'',
						city:'',
						state:'',
						amount:'',
						userAccountNumber:'',
						benificiaryAccountNumber:'',
						benificiaryIFSCCode:''
						
						
					}
				$scope.TrasactionBean.userCode=localStorageService.get('loggedInUser');
				$scope.TrasactionBean.bankName=document.getElementById("bankName").value;
				$scope.TrasactionBean.trasactionType=document.getElementById("ttype").value;
				$scope.TrasactionBean.city=document.getElementById("ct").value;
				$scope.TrasactionBean.state=document.getElementById("ste").value;
				$scope.TrasactionBean.amount=document.getElementById("amt").value;
				$scope.TrasactionBean.userAccountNumber=document.getElementById("uac").value;
				$scope.TrasactionBean.benificiaryAccountNumber=document.getElementById("bac").value;
				$scope.TrasactionBean.benificiaryIFSCCode=document.getElementById("ifc").value;
				
				
			mainService.addTrasaction($scope.TrasactionBean)
				.then(
						function(result) {
							
							$scope.addTrasaction=result;
							
							if(addTrasaction="success")
							{
							alert("Transaction Done Successfully")
							}
						else
							{
							alert("Failure.. Kindly Check With DB ")
							}
							
						
							$log.info("---Inside $scope.webDetails---"+$scope.user);
							});

			}
			
			
		
		
			
			$scope.viewUser = function()
			{
				
			mainService.viewUser()
				.then(
						function(result) {
							$scope.userList=result;
							$log.info("---Inside $scope.userList---"+$scope.userList);
							});

			}
			$scope.viewProduct = function()
			{
				
			mainService.viewProduct()
				.then(
						function(resultProduct) {
							$scope.productList=resultProduct;
							$log.info("---Inside $scope.productList---"+$scope.productList);
							});

			}
	
			
			
			$scope.getUser = function()
			{
				
			mainService.getUser()
				.then(
						function(result) {
							$scope.user=result;
							localStorageService.set('loggedInUser',$scope.user.id)
							$log.info("---Inside $scope.webDetails---"+$scope.user);
							});

			}
			
			
			
			$scope.transactionList = function()
			{
				
			mainService.transactionList()
				.then(
						function(result) {
							$scope.transactionList=result;
							
							});

			}
			
			
			
			
			$scope.transactionListByUserId = function()
			{
				
			mainService.transactionListByUserId()
				.then(
						function(result) {
							$scope.transactionListByUserId=result;
							
							});

			}
			
			
			
		
		

			$scope.viewUser();
			$scope.getUser();
			$scope.transactionListByUserId();
			$scope.transactionList();
		
			
			

			
		}
		
		
		

		

			
])
