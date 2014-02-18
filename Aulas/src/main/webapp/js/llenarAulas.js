var tipoAula;
//var idAula;
//var tipoGrupoModal;
//var idMateria;

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
    var idA;
    var idG;
    var tG;
    var idM;
    if ((!$GET['idAulaString'] || !$GET['tgM'] || !$GET['idG'] || !$GET['idM'])) {
        $.post("InicializarVariables.xx", {}, function(variables) {
            if ($GET['idAulaString']) {
                idA = $GET['idAulaString'];
            } else {
                idA = variables.idAula;
            }
            idG = variables.idGrupo;
            tG = variables.tipoGrupo;
            idM = variables.idMateria;
            $(location).attr('href', "LlenarAula.xx?idAulaString=".concat(idA + "&tgM=" + tG + "&idG=" + idG + "&idM=" + idM));
            constructor();
//            alert("Entro");
        });
    } else {
        idA = $GET['idAulaString'];
        idG = $GET['idG'];
        tG = $GET['tgM'];
        constructor();
    }
    function constructor() {
//        idAula = $GET['idAulaString'];
        $("#modalDesocupado").attr("status", "add");
        $.post("ActualizarInfoAula.xx", {idAula: $GET['idAulaString']}, function(infoAula) {
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
//                    $("#idAula").text(id);
//                    $("#idAula").attr("value", id);
                    $("#edificio").val(ed);
                    $("#aula").val(id);
                    $("#aulaModal").text(au);
                    $("#edificioModal").text(ed);
//--------------------------------------------INICIO---------------------------------------------------\\
                    $("#materiaModal").val($GET['idM']);
                    $("#grupoModal").val($GET['idG']);
                    var tg = ($GET['tgM'] === '1') ? "T" : "P";
                    $("#tipoHorario").attr("tipo", tg);
                    if ($GET['tgM'] === '1') {
//                        alert('entro');
                        $("#tipoHorario").attr("tipo", "T");
                        $("#botonTeoricos").attr("class", "btn btn-success");
                        $("#botonPracticos").attr("class", "btn btn-default");
                        var idMateria = $("#materiaModal").val();
                        if (idMateria === '-1') {
                            obtenerGrupos("T");
                        } else {
                            obtenerGruposPorMateria("T", idMateria);
                        }
                    } else {
                        $("#tipoHorario").attr("tipo", "P");
                        $("#botonTeoricos").attr("class", "btn btn-default");
                        $("#botonPracticos").attr("class", "btn btn-success");
                        var idMateria = $("#materiaModal").val();
//                        alert(idMateria);
                        if (idMateria === '-1') {
                            obtenerGrupos("P");
                        } else {
                            obtenerGruposPorMateria("P", idMateria);
                        }
                    }
//-------------------------------------------------FIN----------------------------------------------\\                    
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

//        actualizaIdAula();
    }
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
//    obtenerGrupos("P");
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

//function actualizaIdAula() {
//    var edificio = $("#edificio").val();
//    var aula = $("#aula").val();
//    $.ajax({
//        type: "GET",
//        url: "ActualizarIdAula.xx",
//        data: {
//            edificio: edificio,
//            aula: aula
//        },
//        success: function(data) {
//            $("#idAula").text(data);
//            $("#idAula").attr("value", data);
//        }, error: function(err) {
//            alert(err);
//        }
//    });
//}
function actualizarAula() {
    var idAula = $("#aula").val();
    var idMat = $("#materiaModal").val();//??
    var idG = $("#grupoModal").val();
    var tgM = $("#tipoHorario").attr("tipo");
    $(location).attr('href', "LlenarAula.xx?idAulaString=".concat(idAula + "&tgM=" + ((tgM === 'T') ? '1' : '0') + "&idG=" + idG + "&idM=" + idMat));
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
//            actualizaIdAula();
            actualizarAula();
        },
        error: function(error) {
            alert(error);
        }
    });
}
;

function cambioAula() {
//    actualizaIdAula();
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
    $("#botonPracticos").attr("class", "btn btn-success");
    var idMateria = $("#materiaModal").val();
    if (idMateria === '-1') {
        obtenerGrupos("P");
    } else {
        obtenerGruposPorMateria("P", idMateria);
    }
});

$("#botonTeoricos").click(function() {
    $("#tipoHorario").attr("tipo", "T");
    $("#botonTeoricos").attr("class", "btn btn-success");
    $("#botonPracticos").attr("class", "btn btn-default");
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
//    alert(tipoHorario);
    $.ajax({
        type: "GET",
        url: "ObtenerListaGruposPorMateria.xx",
        data: {
            idMateria: idMateria,
            tipoHorario: tipoHorario
        },
        success: function(data) {
//            alert(data);
            if (data) {
                $("#grupoModal").html(data);
                var grupo = $("#grupoModal").val();
                var tH = ((tipoHorario === "T") ? 0 : 1);
                obtenerInformacionGrupo(grupo, tH);
//                alert("hay datos");
            } else {
                $("#grupoModal").html("");
                $("#tablaModal").html('<h1>No hay grupos para mostrar</h1>');
//                alert("No hay datos recibidos desde el controlador");
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
//    var idAula = $("#idAula").text();
    var idAula = $GET['idAulaString'];
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
//            actualizaIdAula();
            actualizarAula();
        },
        error: function(error) {
            alert('Error al insertar horario');
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