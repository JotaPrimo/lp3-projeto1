
function deletar_pessoa (id)
{
	swal({
		  title: "Você tem certeza ?",
		  text: " Uma vez excluído, você não será capaz de recuperar estes dados! ",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
			
	  if (OK) {
		$.ajax({			
			url:"/deletarPessoa/"+id,
			success: function(res){
				console.log(res);
			}			
		});
		
	    swal("Pessoa deletada com sucesso!", {
	      icon: "success",
	    }).then((OK) => {
		
		if(OK)
		{
			location.href="/";
		}
		
	});
	
	  } else {
	    swal("OK. Operação cancelada com sucesso!");
	  }
	});


}





