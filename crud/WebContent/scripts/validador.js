/**
 * 	Validação de formulário
 *	@author Jonatan Simão
 */

function validar() {
	let nome = forUser.nome.value
	let fone = forUser.fone.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		forUser.nome.focus()
		return false
	} else if (fone === "") {
		alert('Preencha o campo Fone')
		forUser.email.focus()
		return false
	} else {
		document.forms["forUser"].submit()
	}
}