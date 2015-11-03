window.onload = function () {
    var cargarDataPoints = function () {
        $.ajax({
            async: false,
            url: "Grafico_Dos",
            dataType: "json",
            success: function (resultadoJsonData) {
                dataPoints = [];
                for (i = 0; i < resultadoJsonData.length; i++) { 
                    dataPoints.push({y: resultadoJsonData[i].total, label: '' + resultadoJsonData[i].label});
                }
            }
        });
        return dataPoints;
    };

    var chart = new CanvasJS.Chart("chartContainer", {
        title: {
            text: "Gráfico"
        },
        animationEnabled: true,
        axisX: {
            interval: 1,
            gridThickness: 0,
            labelFontSize: 10,
            labelFontStyle: "normal",
            labelFontWeight: "normal",
            labelFontFamily: "Lucida Sans Unicode"
        },
        axisY2: {
            interlacedColor: "rgba(1,77,101,.2)",
            gridColor: "rgba(1,77,101,.1)"
        },
        data: [
            {
                type: "bar",
                name: "companies",
                axisYType: "secondary",
                color: "#014D65",
                dataPoints: cargarDataPoints()
            }
        ]
    });

    chart.render();
}