/**
 *	Confirmação de Exclusão de Usuário 
 *	@author Jonatan Simão
 */

function confirmar(id) {
	let resposta = confirm("Você quer excluir esse usuário ?")
	if (resposta === true) {
		//alert(id)
		//encaminhar requisição ao servlet
		window.location.href = "delete?id=" + id
	}
}