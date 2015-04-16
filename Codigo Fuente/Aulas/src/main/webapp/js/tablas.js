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
$("#tablaEspecialidades").hide(0);
$("#tablaCarreras").hide(0);
$("#tablaUsuarios").hide(0);
$("#tablaMaterias").hide(0);
$("#tablaGrupos").hide(0);
$("#tablaProfesores").hide(0);
$("#tablaPlanes").hide(0);
$("#tablaCicloEscolar").hide(0);
$("#tablaHorarios").hide(0);
$("#tablaAulas").hide(0);

//$(location).attr("href","Tablas.xx?idT=esp");

$(document).ready(function() {
    var sw = $GET["edT"];
    switch (sw) {
        case "esp":
            $("#tablaEspecialidades").show();
            break;
        case "car":
            $("#tablaCarreras").show();
            break;
        case "usr":
            $("#tablaUsuarios").show();
            break;
        case "mat":
            $("#tablaMaterias").show();
            break;
        case "grp":
            $("#tablaGrupos").show();
            break;
        case "pfr":
            $("#tablaProfesores").show();
            break;
        case "pln":
            $("#tablaPlanes").show();
            break;
        case "ces":
            $("#tablaCicloEscolar").show();
            break;
        case "hrs":
            $("#tablaHorarios").show();
            break;
        case "aul":
            $("#tablaAulas").show();
            break;
    }

    $('#tAula').dataTable();
    $('#tGrupo').dataTable();
    $('#tMateria').dataTable();
    $('#tCicloEscolar').dataTable();
    $('#tPlan').dataTable();
    $('#tProfesor').dataTable();
    $('#tUsuario').dataTable();
    $('#tCarrera').dataTable();
    $('#tEspecialidad').dataTable();
});
//
//$('.hover').mouseenter(function() {
//    $('#toolBar').delay(500);
//    $('#toolBar').hide("fast");
//    
//}).mouseleave(function() {
//    $('#toolBar').clearQueue();
//    $('#toolBar').show("fast");
//});

$(".deleteButton").click(function() {
    var idEl = $(this).attr("idButton");
    var nombre = $(this).attr("tabla");
    eliminar(nombre, idEl);
});

$(".editButton").click(function() {
    var idEd = $(this).attr("idButton");
    var nombreTabla = $(this).attr("tabla");
    $("#tituloModal").text("Editar "+nombreTabla)
    $("#modalEditar").modal('toggle');
    editar(nombreTabla, idEd);
});

function editar(nombreFormulario, idEd) {
    var url = "ObtenerFormulario".concat(nombreFormulario + ".xx");
    $.ajax({
        type: "GET",
        url: "" + url + "",
        data: {
            idEd: idEd
        },
        success: function(data) {
            if (data) {
                $("#cuerpoModal").html(data);
//                alert(data);
            } else {
                alert("no hay datos del controlador editar");
            }
        },
        error: function(error) {
            alert(error);
        }
    });
}

function eliminar(nombre, idEl) {
    var url = "Eliminar".concat(nombre + ".xx");
    $.ajax({
        type: "GET",
        url: "" + url + "",
        data: {
            idEl: idEl
        },
        success: function(data) {
            redirect(nombre);
            if (data) {
                alert(data);
            } else {
                alert("no hay datos del controlador editar");
            }
        },
        error: function(error) {
            alert(error);
        }
    });
}

function redirect(nombre){
    var get;
    switch (nombre) {
        case "Especialidad":
            get = "esp";
            break;
        case "Carrera":
            get = "car";
            break;
        case "Usuario":
            get = "usr";
            break;
        case "Materia":
            get = "mat";
            break;
        case "Grupo":
            get = "grp";
            break;
        case "Profesor":
            get = "pfr";
            break;
        case "Plan":
            get = "pln";
            break;
        case "CicloEscolar":
            get = "ces";
            break;
        case "Aula":
            get = "aul";
            break;
    }
    $(location).attr("href","Tablas.xx?edT="+get);
}

function changeClass(nombreTablaPlural){
    $("#botonEspecialidades").attr("class","btn btn-danger");
    $("#botonCarreras").attr("class","btn btn-danger");
    $("#botonUsuarios").attr("class","btn btn-danger");
    $("#botonMaterias").attr("class","btn btn-danger");
    $("#botonGrupos").attr("class","btn btn-danger");
    $("#botonProfesores").attr("class","btn btn-danger");
    $("#botonPlanes").attr("class","btn btn-danger");
    $("#botonCicloEscolar").attr("class","btn btn-danger");
    $("#botonHorarios").attr("class","btn btn-danger");
    $("#botonAulas").attr("class","btn btn-danger");
    $("#boton"+nombreTablaPlural).attr("class","btn btn-default");
}

$("#botonEspecialidades").click(function() {
    changeClass("Especialidades");
    $("#tablaEspecialidades").show("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonCarreras").click(function() {
    changeClass("Carreras");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").show("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonUsuarios").click(function() {
    changeClass("Usuarios");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").show("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonMaterias").click(function() {
    changeClass("Materias");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").show("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonGrupos").click(function() {
    changeClass("Grupos");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").show("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonProfesores").click(function() {
    changeClass("Profesores");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").show("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonPlanes").click(function() {
    changeClass("Planes");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").show("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonCicloEscolar").click(function() {
    changeClass("CicloEscolar");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").show("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").hide("slow");
});

$("#botonAulas").click(function() {
    changeClass("Aulas");
    $("#tablaEspecialidades").hide("slow");
    $("#tablaCarreras").hide("slow");
    $("#tablaUsuarios").hide("slow");
    $("#tablaMaterias").hide("slow");
    $("#tablaGrupos").hide("slow");
    $("#tablaProfesores").hide("slow");
    $("#tablaPlanes").hide("slow");
    $("#tablaCicloEscolar").hide("slow");
    $("#tablaHorarios").hide("slow");
    $("#tablaAulas").show("slow");
});