$("#botonCarreras").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=car');
});
$("#botonUsuarios").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=usr');
});
$("#botonMaterias").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=mat');
});
$("#botonAulas").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=aul');
});
$("#botonProfesores").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=pfr');
});
$("#botonGrupos").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=grp');
});
$("#botonPlanes").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=pln');
});
$("#botonCicloEscolar").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=ces');
});
$("#botonEspecialidades").click(function() {
    $(location).attr('href', 'Formularios.xx?edF=esp');
});
//alert($("#selectForzar").val());
$("#selectForzar").change(function(){
    if ($(this).val()==='null') {
        $("#checkForzar").prop("checked", '');
        $("#selectForzar").hide("slow");
        $("#divForzar").attr("class", "col-sm-offset-1 col-sm-1");
    } 
});
if ($("#checkForzar").is(':checked')) {
    $("#divForzar").attr('class', "col-sm-offset-1 col-sm-4");
} else {
    $("#selectForzar").hide();
}
$("#checkForzar").change(function() {
    if ($(this).is(':checked')) {
        $("#divForzar").attr('class', "col-sm-offset-1 col-sm-4");
        $("#selectForzar").show("slow");
    } else {
        $("#selectForzar").hide("slow");
        $("#divForzar").attr("class", "col-sm-offset-1 col-sm-1");
        $("#selectForzar").val('null');
    }
});
$("#b1").click(function(i) {
    $("#b1").attr("class", "btn btn-success");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 1);
});

$("#b2").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-success");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 2);
});

$("#b3").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-success");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 3);
});
$("#b4").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-success");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 4);
});
$("#b5").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-success");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 5);
});

$("#b6").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-success");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 6);
});
$("#b7").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-success");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 7);
});
$("#b8").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-success");
    $("#b9").attr("class", "btn btn-default");
    $("#bloque").attr("value", 8);
});
$("#b9").click(function(i) {
    $("#b1").attr("class", "btn btn-default");
    $("#b2").attr("class", "btn btn-default");
    $("#b3").attr("class", "btn btn-default");
    $("#b4").attr("class", "btn btn-default");
    $("#b5").attr("class", "btn btn-default");
    $("#b6").attr("class", "btn btn-default");
    $("#b7").attr("class", "btn btn-default");
    $("#b8").attr("class", "btn btn-default");
    $("#b9").attr("class", "btn btn-success");
    $("#bloque").attr("value", 9);
});