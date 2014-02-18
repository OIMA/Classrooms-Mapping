$(".btnAula").click(function() {
    var idAula = $(this).attr("idBotonAula");
    $(location).attr('href', "LlenarAula.xx?idAulaString=".concat(idAula));
});

