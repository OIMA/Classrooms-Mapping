
$(document).ready(function() {
    var paneles = new Array($("#materias"), $("#gruposPorAcomodar"), $("#gruposAcomodados"), $("#aulas"), $("#profesores"), $("#totalGrupos"));
    function ocultar(speed,except) {
        for (i = 0; i < paneles.length; i++) {
            paneles[i].hide(speed);
        }
        except.show('slow');
    }
    ocultar(0,$("#aulas"));
    $(".btnAula").click(function() {
        var idAula = $(this).attr("idBotonAula");
        $(location).attr('href', "LlenarAula.xx?idAulaString=".concat(idAula));
    });

    $("#botonMaterias").click(function() {
        ocultar('slow',$("#materias"));
    });
    $("#botonGruposPorAcomodar").click(function() {
        ocultar('slow',$("#gruposPorAcomodar"));
    });
    $("#botonTotalGrupos").click(function() {
        ocultar('slow',$("#totalGrupos"));
    });
    $("#botonProfesores").click(function() {
        ocultar('slow',$("#profesores"));
    });
    $("#botonAulas").click(function() {
        ocultar('slow',$("#aulas"));
    });
    $("#botonGruposAcomodados").click(function() {
        ocultar('slow',$("#gruposAcomodados"));
    });
});
//function {




