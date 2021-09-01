/**
 * Confirmação de exclusão
 */

function excluir(id){
	let confirmar = confirm("Confirmar exclusão deste container?")
	if(confirmar === true){
		//alert(id)
		window.location.href ="delete?id=" + id
	}
}