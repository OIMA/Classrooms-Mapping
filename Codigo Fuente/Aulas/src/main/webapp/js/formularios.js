(function() {
    window.$GET = [];
    if (location.search) {
        var params = decodeURIComponent(location.search).match(/[a-z_]\w*(?:=[^&]*)?/gi);
        if (params) {
            var pm, i = 0;
            for (; i < params.length; i++) {
                pm = params[i].split('=');
                $GET[pm[0]] = pm[1] || '';
            }
        }
    }
})();
$("#formularioUsuario").hide(0);
$("#formularioCarrera").hide(0);
$("#formularioEspecialidad").hide(0);
$("#formularioProfesor").hide(0);
$("#formularioMateria").hide(0);
$("#formularioPlan").hide(0);
$("#formularioAula").hide(0);
$("#formularioCicloEscolar").hide(0);
$("#formularioGrupo").hide(0);

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
$("#checkForzar").change(function(event) {
    if ($(this).is(':checked')) {
        $("#divForzar").attr('class', "col-sm-offset-1 col-sm-4");
        $("#selectForzar").show("slow");
    } else {
        $("#selectForzar").hide("slow");
        $("#divForzar").attr("class", "col-sm-offset-1 col-sm-1");
        $("#selectForzar").val('null');
    }
});

$(document).ready(
        function() {
            var idMateria = $("#selectMaterias").val();
            $.ajax({
                type: "GET",
                url: "InfoHorasTeoricasMateria.xx",
                data: {
                    idMateria: idMateria
                },
                success: function(data) {
                    $("#horasTeoricasGrupo").attr("value", data);
                }
            });
            $.ajax({
                type: "GET",
                url: "InfoHorasPracticasMateria.xx",
                data: {
                    idMateria: idMateria
                },
                success: function(data) {
                    $("#horasPracticasGrupo").attr("value", data);
                }
            });
            var sw = $GET["edF"];
            switch (sw) {
                case "esp":
                    $("#formularioEspecialidad").show();
                    break;
                case "car":
                    $("#formularioCarrera").show();
                    break;
                case "usr":
                    $("#formularioUsuario").show();
                    break;
                case "mat":
                    $("#formularioMateria").show();
                    break;
                case "grp":
                    $("#formularioGrupo").show();
                    break;
                case "pfr":
                    $("#formularioProfesor").show();
                    break;
                case "pln":
                    $("#formularioPlan").show();
                    break;
                case "ces":
                    $("#formularioCicloEscolar").show();
                    break;
                case "aul":
                    $("#formularioAula").show();
                    break;
            }
            changeClass(sw);
        });
function changeClass(nombreTabla){
    $("#botonEspecialidades").attr('class','btn btn-default');
    $("#botonCarreras").attr('class','btn btn-default');
    $("#botonMaterias").attr('class','btn btn-default');
    $("#botonGrupos").attr('class','btn btn-default');
    $("#botonProfesores").attr('class','btn btn-default');
    $("#botonAulas").attr('class','btn btn-default');
    $("#botonPlanes").attr('class','btn btn-default');
    $("#botonCicloEscolar").attr('class','btn btn-default');
    $("#botonUsuarios").attr('class','btn btn-default');
    switch (nombreTabla) {
                case "esp": $("#botonEspecialidades").attr('class','btn btn-primary');
                    break;
                case "car": $("#botonCarreras").attr('class','btn btn-primary');
                    break;
                case "usr": $("#botonUsuarios").attr('class','btn btn-primary');
                    break;
                case "mat": $("#botonMaterias").attr('class','btn btn-primary');
                    break;
                case "grp": $("#botonGrupos").attr('class','btn btn-primary');
                    break;
                case "pfr": $("#botonProfesores").attr('class','btn btn-primary');
                    break;
                case "pln": $("#botonPlanes").attr('class','btn btn-primary');
                    break;
                case "ces": $("#botonCicloEscolar").attr('class','btn btn-primary');
                    break;
                case "aul": $("#botonAulas").attr('class','btn btn-primary');
                    break;
            }
}

$("#botonCarreras").click(function() {
    changeClass('car');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioCarrera").show("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").hide("slow");
});
$("#botonUsuarios").click(function() {
    changeClass('usr');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").show("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").hide("slow");
});
$("#botonEspecialidades").click(function() {
    changeClass('esp');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").show("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").hide("slow");
});
$("#botonProfesores").click(function() {
    changeClass('pfr');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").show("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").hide("slow");
});
$("#botonMaterias").click(function() {
    changeClass('mat');
    $("#formularioMateria").show("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").hide("slow");
});
$("#botonPlanes").click(function() {
    changeClass('pln');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").show("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").hide("slow");
});

$("#botonAulas").click(function() {
    changeClass('aul');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioAula").show("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").hide("slow");
});

$("#botonGrupos").click(function() {
    changeClass('grp');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").hide("slow");
    $("#formularioGrupo").show("slow");
});
$("#botonCicloEscolar").click(function() {
    changeClass('ces');
    $("#formularioMateria").hide("slow");
    $("#formularioPlan").hide("slow");
    $("#formularioProfesor").hide("slow");
    $("#formularioCarrera").hide("slow");
    $("#formularioEspecialidad").hide("slow");
    $("#formularioUsuario").hide("slow");
    $("#formularioAula").hide("slow");
    $("#formularioCicloEscolar").show("slow");
    $("#formularioGrupo").hide("slow");
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

$("#selectMaterias").change(
        function() {
            var idMateria = $("#selectMaterias").val();
            $.ajax({
                type: "GET",
                url: "InfoHorasTeoricasMateria.xx",
                data: {
                    idMateria: idMateria
                },
                success: function(data) {
                    $("#horasTeoricasGrupo").attr("value", data);
                },
                error: function(error){
                    alert("error ajax");
                }
            });
            $.ajax({
                type: "GET",
                url: "InfoHorasPracticasMateria.xx",
                data: {
                    idMateria: idMateria
                },
                success: function(data) {
                    $("#horasPracticasGrupo").attr("value", data);
                },
                error: function(error){
                    alert("error ajax");
                }
            });
        }
);