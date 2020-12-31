/**
 * Este archivo valida la autenticación
 */

function validarUsuario() {
	var user= document.formLogin.txtUsuario.value;
	var password= document.formLogin.txtPassword.value;
	var mensaje= "Usted debe ingresar un usuario y password"
	var alertaMensaje= false;
	
	if (user == "" || password == "") {
		alertaMensaje = true;
	}
	
	if (alertaMensaje) {
		alert(mensaje);
	} else {
		document.formLogin.submit();	
	}
}