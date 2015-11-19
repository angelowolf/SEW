var cargarDataPoints = function () {
    $.ajax({
        async: false,
        url: "Grafico_Uno",
        dataType: "json",
        success: function (resultadoJsonData) {
//            alert(resultadoJsonData.resultado_escrutado);
            dataPoints = [{
                    y: resultadoJsonData[0].resultado_escrutado, name: "Escrutado", legendMarkerType: "triangle"
                }, {
                    y: resultadoJsonData[0].resultado_restante, name: "Sin Escrutar", legendMarkerType: "square"
                }];
        }
    });
    return dataPoints;
};

var crearGrafico = function () {
    var chart = new CanvasJS.Chart("chartContainer2",
            {
                title: {
                    text: "Porcentaje Participacion",
                    fontFamily: "arial black"
                },
                animationEnabled: true,
                legend: {
                    verticalAlign: "bottom",
                    horizontalAlign: "center"
                },
                theme: "theme1",
                data: [
                    {
                        type: "pie",
                        indexLabelFontFamily: "Garamond",
                        indexLabelFontSize: 20,
                        indexLabelFontWeight: "bold",
                        startAngle: 0,
                        indexLabelFontColor: "MistyRose",
                        indexLabelLineColor: "darkgrey",
                        indexLabelPlacement: "inside",
                        toolTipContent: "{name}: {y} votantes",
                        showInLegend: true,
                        indexLabel: "#percent%",
                        dataPoints: cargarDataPoints()
                    }
                ]
            });
    chart.render();
};


$(document).ready(function () {
    crearGrafico();
    setInterval(function () {
        crearGrafico();
    }, 5000);
});