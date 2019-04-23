app.controller("todoController", function($scope, TodoService){  

	$scope.todos = [];
	$scope.todo = {};
	$scope.editMode = false;
	
	$scope.findAllTodos = function(){
        console.log("teste find");
		TodoService.findAllTodos().then(function(data){
            
			$scope.todos = data;
		});
	};
	
	$scope.addTodo = function(){
        console.log("teste add");
		TodoService.addTodo($scope.todo).then(function(data){
			$scope.findAllTodos();
		});
		
		$scope.todo = {};
	};
	
	$scope.deleteTodo = function(id){
		TodoService.deleteTodo(id).then(function(data){
			$scope.findAllTodos();
		});
	};
	
	$scope.editTodo = function(todo){
		TodoService.updateTodo(todo).then(function(data){
			$scope.findAllTodos();
		});
		$scope.editMode = false;
	};
	
	$scope.setCompleted = function(todo){
		todo.completed = !todo.completed;
		TodoService.updateTodo(todo).then(function(data){
			$scope.findAllTodos();
		});
	}
	
	$scope.findAllTodos();
});