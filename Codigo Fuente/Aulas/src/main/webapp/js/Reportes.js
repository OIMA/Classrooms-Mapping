$('#hiddenDiv').hide();
$('.botonGenerarReporte').click(function() {
    var idAula = $(this).attr("idAula");
    $.ajax({
        type: "GET",
        url: "ObtenerReporteAula.xx",
        data: {
            idAula: idAula,
        },
        success: function(objAula) {
            $('#hiddenDiv').html(objAula.tabla);
            console.log($('#hiddenDiv').html());
            $(function() {
//                var doc = new jsPDF();
                var specialElementHandlers = {
                    '#editor': function(element, renderer) {
                        return true;
                    }
                };

                var table = tableToJson($('#tablaHorarioAula').get(0));
                var doc = new jsPDF('landscape', 'pt', 'letter', true);
//                var source = "Hola mundo esta es el aula Q-1";
//                doc.fromHTML(
//                        $('#tablaHorarioAula').get(0), // HTML string or DOM elem ref.
//                        0.5, // x coord
//                        0.5, // y coord
//                        {
//                            'width': 720, // max width of content on PDF
//                            'elementHandlers':
//                                    specialElementHandlers
//                        });


                doc.setFontSize(22);
                doc.text(20, 20, 'Horarios del aula: '.concat(objAula.nombreEdificio + "-" + objAula.nombreAula));
                doc.text(20, 45, 'Carrera: '.concat(objAula.nombreCarrera))
                doc.text(20, 70, 'Tipo aula: '.concat(objAula.tipoAula))
                doc.setFontSize(8);
                doc.cellInitialize();
                $.each(table, function(i, row) {
                    console.debug(row);
                    $.each(row, function(j, cell) {
                        if (i > 0 && j !== 'horas') {
                            doc.setFontSize(8);
//                            doc.setFillColor(1.0, 0.5, 0.0, 0.0);
//                            doc.rect(i*40, 100, 120, 30, 'fill');
//                            doc.setDrawColor(1.0);
//                            doc.cell(40, 100, 120, 30, cell, i);
                        } else {
                            doc.setFontSize(12);
                        }
                        doc.cell(40, 100, 120, 30, cell, i);
                        // 2nd parameter=top margin,1st=left margin 3rd=row cell width 4th=Row height
                    });
                });

                doc.save('Reporte '.concat(objAula.nombreEdificio + "-" + objAula.nombreAula));
//                });
                function tableToJson(table) {
                    var data = [];

                    // first row needs to be headers
                    var headers = [];
                    for (var i = 0; i < table.rows[0].cells.length; i++) {
                        headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase().replace(/ /gi, '');
                    }


                    // go through cells
                    for (var i = 0; i < table.rows.length; i++) {

                        var tableRow = table.rows[i];
                        var rowData = {};
                        for (var j = 0; j < tableRow.cells.length; j++) {
                            rowData[ headers[j] ] = tableRow.cells[j].innerHTML;
//                            alert(headers[j]);
                        }

                        data.push(rowData);
                    }

                    return data;
                }
            });
        }, error: function(data) {
            alert('error de ajax');
        }
    });
});

