$(document).ready(
    function(){
var idMateria = $("#selectMaterias").val();
            $.ajax({
                type: "GET",
                url: "InfoHorasTeoricasMateria.xx",
                data: {
                    idMateria : idMateria
                },
                success: function(data) {
                $("#horasTeoricasGrupo").attr("value",data);
                }
            });
            $.ajax({
                type: "GET",
                url: "InfoHorasPracticasMateria.xx",
                data: {
                    idMateria : idMateria
                },
                success: function(data) {
                $("#horasPracticasGrupo").attr("value",data);
                }
            });

    }    
    );
$("#formularioUsuario").hide();
$("#formularioCarrera").hide();
$("#formularioEspecialidad").hide();
$("#formularioProfesor").hide();
$("#formularioMateria").hide();
$("#formularioPlan").hide();
$("#formularioAula").hide();
$("#formularioCicloEscolar").hide();
$("#formularioGrupo").hide();
$("#botonCarreras").click(function() {
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
                    idMateria : idMateria
                },
                success: function(data) {
                $("#horasTeoricasGrupo").attr("value",data);
                }
            });
            $.ajax({
                type: "GET",
                url: "InfoHorasPracticasMateria.xx",
                data: {
                    idMateria : idMateria
                },
                success: function(data) {
                $("#horasPracticasGrupo").attr("value",data);
                }
            });
        }
);