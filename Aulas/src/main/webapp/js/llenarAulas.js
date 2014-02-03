var tipoAula;
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
$(document).ready(function() {
    var idAula = $GET['idAulaString'];
    $("#modalDesocupado").attr("status", "add");
    $.post("ActualizarInfoAula.xx", {idAula: idAula}, function(infoAula) {
        var id = infoAula.idAula;
        var ed = infoAula.nombreEdificio;
        var au = infoAula.nombreAula;
        tipoAula = infoAula.tipoAula;
        $.ajax({
            type: "GET",
            url: "ObtenerListaAulas.xx",
            data: {
                nombreEdificio: ed
            },
            success: function(data) {
                $("#aula").html(data);
                $("#idAula").text(id);
                $("#idAula").attr("value", id);
                $("#edificio").val(ed);
                $("#aula").val(id);
                $("#aulaModal").text(au);
                $("#edificioModal").text(ed);
                if (tipoAula === '0') {
                    $("#tipoAulaModal").text("práctica");
                } else {
                    $("#tipoAulaModal").text("teórica");
                }
            },
            error: function(error) {
                alert(error);
            }
        });
    });
    $("#dialog").hide();
    actualizaIdAula();
});

$("#cancelarPopup").click(function() {
    $("#dialog").dialog('close');
});
$("#cambiarPopup").click(function() {
    $("#dialog").dialog('close');
    $("#modalDesocupado").modal('toggle');
    $("#modalDesocupado").attr("status", 'change');
});
$("#removerPopup").click(function() {
    $("#dialog").dialog('close');
    var idHorario = $("#dialog").attr("idH");
    var tipoHorario = $("#dialog").attr("tipoH");
    eliminarHorario(idHorario, tipoHorario);
});

$(".editable").click(function() {
    var ocupado = $(this).attr("ocupado");
    var hora = $(this).attr("fil");
    var dia = $(this).attr("col");
    var id = $(this).attr("id");
    var tipoH = $(this).attr("tipoHorario");
    $("#horaModal").text(hora);
    $("#diaModal").text(dia);
    if (ocupado === "false") {
        $("#modalDesocupado").modal('toggle');
    } else {
        $("#dialog").dialog({title: "grupo con id: ".concat(id)});
        $("#dialog").attr("idH", id);
        $("#dialog").attr("tipoH", tipoH);

        console.log(title);
    }
    obtenerGrupos("All");
});
$("#edificio").change(
        function() {
            cambioEdificio();
        }
);
$("#aula").change(
        function() {
            cambioAula();
        }
);
$("#grupoModal").change(
        function() {
            var grupo = $("#grupoModal").val();
            obtenerInformacionGrupo(grupo, tipoAula);
        }
);

$("#aceptarModal").click(
        function() {
            if ($("#modalDesocupado").attr("status") === "change") {
                cambiarGrupo();
            }
            if ($("#modalDesocupado").attr("status") === "add") {
                agregarGrupo();
            }
        }
);

$("#materiaModal").change(
        function() {
            var idMateria = $(this).val();
            var tipoHorario = $("#tipoHorario").attr("tipo");
//            alert(idMateria);
            obtenerGruposPorMateria(tipoHorario, idMateria);
        }
);

function obtenerInformacionGrupo(idGrupo,
//tipoGrupo,
        tipoAula) {
//            alert(tipoAula);
    $.ajax({
        type: "GET",
        url: "ActualizarGrupo.xx",
        data: {
            idGrupo: idGrupo,
//            tipoGrupo: tipoGrupo,
            tipoAula: tipoAula
        },
        success: function(data) {
            $("#tablaModal").html(data);
        }
    });
}

function actualizaIdAula() {
    var edificio = $("#edificio").val();
    var aula = $("#aula").val();
    $.ajax({
        type: "GET",
        url: "ActualizarIdAula.xx",
        data: {
            edificio: edificio,
            aula: aula
        },
        success: function(data) {
            $("#idAula").text(data);
            $("#idAula").attr("value", data);
        }, error: function(err) {
            alert(err);
        }
    });
}
function actualizarAula() {
    var idAula = $("#aula").val();
    $(location).attr("href", "LlenarAula.xx?idAulaString=".concat(idAula));
}

function cambioEdificio() {
    var ed = $("#edificio").val();
    $.ajax({
        type: "GET",
        url: "ObtenerListaAulas.xx",
        data: {
            nombreEdificio: ed
        },
        success: function(data) {
            $("#aula").html(data);
            actualizaIdAula();
            actualizarAula();
        },
        error: function(error) {
            alert(error);
        }
    });
}
;

function cambioAula() {
    actualizaIdAula();
    actualizarAula();
}

function eliminarHorario(idHorario, tipoHorario) {
    console.log(tipoHorario); //    alert(tipoHorario);
    $.ajax({
        type: "GET",
        url: "EliminarHorario.xx",
        data: {
            idHorario: idHorario,
            tipoHorario: tipoHorario
        },
        success: function(data) {
//            $("#aula").html(data);
            actualizarAula();
        },
        error: function(error) {
            alert(error);
        }
    });
}

$("#botonPracticos").click(function() {
    $("#tipoHorario").attr("tipo", "P");
    $("#botonTeoricos").attr("class", "btn btn-default");
    $("#botonTodos").attr("class", "btn btn-default");
    $("#botonPracticos").attr("class", "btn btn-success");
    var idMateria = $("#materiaModal").val();
    if (idMateria === '-1') {
        obtenerGrupos("P");
    } else {
        obtenerGruposPorMateria("P", idMateria);
    }
});
$("#botonTodos").click(function() {
    $("#tipoHorario").attr("tipo", "All");
    $("#botonTodos").attr("class", "btn btn-success");
    $("#botonTeoricos").attr("class", "btn btn-default");
    $("#botonPracticos").attr("class", "btn btn-default");
    var idMateria = $("#materiaModal").val();
    if (idMateria === '-1') {
        obtenerGrupos("All");
    } else {
        obtenerGruposPorMateria("All", idMateria);
    }
});
$("#botonTeoricos").click(function() {
    $("#tipoHorario").attr("tipo", "T");
    $("#botonTeoricos").attr("class", "btn btn-success");
    $("#botonPracticos").attr("class", "btn btn-default");
    $("#botonTodos").attr("class", "btn btn-default");
    var idMateria = $("#materiaModal").val();
    if (idMateria === '-1') {
        obtenerGrupos("T");
    } else {
        obtenerGruposPorMateria("T", idMateria);
    }

});

function obtenerGrupos(tipoHorario) {
    $.ajax({
        type: "GET",
        url: "ObtenerListaGrupos.xx",
        data: {
            tipoHorario: tipoHorario
        },
        success: function(data) {
            $("#grupoModal").html(data);
            var grupo = $("#grupoModal").val();
            obtenerInformacionGrupo(grupo, tipoAula);
        },
        error: function(error) {
            alert(error);
        }
    });
}
function obtenerGruposPorMateria(tipoHorario, idMateria) {
//    alert(idMateria);
    $.ajax({
        type: "GET",
        url: "ObtenerListaGruposPorMateria.xx",
        data: {
            idMateria: idMateria,
            tipoHorario: tipoHorario
        },
        success: function(data) {
            if (data) {
                $("#grupoModal").html(data);
                var grupo = $("#grupoModal").val();
                obtenerInformacionGrupo(grupo, tipoAula);
            }else{
                $("#grupoModal").html("");
                $("#tablaModal").html('<h1>There are not groups to show</h1>');
            }
        },
        error: function(error) {
            alert("Error al filtrar por materia");
            alert(error);
        }
    });
}


function agregarGrupo() {
    var idGrupo = $("#grupoModal").val();
    var idAula = $("#idAula").text();
    var horario = $("#horaModal").text();
    var dia = $("#diaModal").text();
    var tipoHorario = $("#tipoHorario").attr("tipo");
    $.ajax({
        type: "GET",
        url: "NuevoHorario.xx",
        data: {
            idAula: idAula,
            idGrupo: idGrupo,
            dia: dia,
            horario: horario,
            tipoHorario: tipoHorario
        },
        success: function(data) {
            actualizaIdAula();
            actualizarAula();
        },
        error: function(data) {
            alert('Error al in sertar horario');
        }
    });
}

function cambiarGrupo() {
    var idHorario = $("#dialog").attr("idH");
    var tipoHorario = $("#dialog").attr("tipoH");
    $.ajax({
        type: "GET",
        url: "EliminarHorario.xx",
        data: {
            idHorario: idHorario,
            tipoHorario: tipoHorario
        },
        success: function(data) {
            agregarGrupo();
        },
        error: function(error) {
            alert(error);
        }
    });
}