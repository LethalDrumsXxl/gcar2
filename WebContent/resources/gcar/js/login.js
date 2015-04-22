$(document).ready(function(){
	
	jQuery('#rut').keyup(function(){
		if(!$(this).val().match(/^[0-9]{8}$/)){
			$('#rutGroup').addClass('has-error');
			$('#msgRut').html('<i class="fa fa-times-circle-o"/> El Rut debe contener 8 dígitos');
			$('#msgRut').css('display','block');
		}else{
			$('#rutGroup').removeClass('has-error');
			$('#msgRut').empty();
			$('#msgRut').css('display','none');
		}
	});
	
	jQuery('#pass').keyup(function(){
		if($(this).val().match(/^\s*$/)){
			$('#passGroup').addClass('has-error');
			$('#msgLocal').html('<p>Debes ingresar tu contraseña</p>');
			$('#msgLocal').css('display','block');
		}else{
			$('#passGroup').removeClass('has-error');
			$('#msgLocal').empty();
			$('#msgLocal').css('display','none');
		}
	});
	
});