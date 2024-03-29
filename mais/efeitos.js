	$(document).ready(function() {
		$("#button-1").click(form1);
		$("#button-2").click(form2);
		$("#button-3").click(form3);
	});
	function form1() {
		$("#div-1").show("slow");
		$("#div-2").hide("fast");		
		$("#div-3").hide("fast");
	}
	function form2() {
		$("#div-1").hide("fast");
		$("#div-2").show("slow");
		$("#div-3").hide("fast");
	}
	function form3() {
		$("#div-1").hide("fast");
		$("#div-2").hide("fast");
		$("#div-3").show("slow");
	}
	
	$(function() {
    	$(".data").datepicker({
			dateFormat: 'dd-mm-yy',
		    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
      		dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
   		    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
  		    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
 		    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
			});
  	});