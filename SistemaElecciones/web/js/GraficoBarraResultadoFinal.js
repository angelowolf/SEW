window.onload = function () {
    var cargarDataPoints = function () {
        $.ajax({
            async: false,
            url: "Grafico_Dos",
            dataType: "json",
            success: function (resultadoJsonData) {
                dataPoints = [
                    {y: resultadoJsonData[0].total, label: '' + resultadoJsonData[0].label},
                    {y: resultadoJsonData[1].total, label: '' + resultadoJsonData[1].label},
                    {y: resultadoJsonData[2].total, label: '' + resultadoJsonData[2].label},
                    {y: resultadoJsonData[3].total, label: '' + resultadoJsonData[3].label},
                    {y: resultadoJsonData[4].total, label: '' + resultadoJsonData[4].label}
                ];
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