var valueX = 0;
var multiplier = 100;

function start() {
    listeners();
    drawCanvas();
    //getTable();
    //drawPoint();
}

function drawCanvas() {
    var graph = document.getElementById("graph");
    ctx = graph.getContext("2d");
    ctx.clearRect(0, 0, graph.width, graph.height);
    ctx.lineWidth = 4;
    ctx.strokeRect(0, 0, graph.width, graph.height);
    ctx.lineWidth = 1;

    ctx.beginPath();
    ctx.moveTo(graph.width/2-10, 10);
    ctx.lineTo(graph.width/2, 0);
    ctx.lineTo(graph.width/2+10,10);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(graph.width-10, graph.height/2-10);
    ctx.lineTo(graph.width, graph.height/2);
    ctx.lineTo(graph.width-10,graph.height/2+10);
    ctx.stroke();

    ctx.font = "24px Arial";
    ctx.fillText("y", graph.width/2-30, 20);
    ctx.fillText("x", graph.width-20, graph.height/2+30);

    ctx.beginPath();
    ctx.moveTo(graph.width/2, graph.height/2);
    ctx.lineTo(graph.width/2, graph.height/2 - 2*multiplier);
    ctx.arc(graph.width/2, graph.height/2, multiplier*2, -Math.PI/2, -Math.PI, anticlockwise=true);
    ctx.lineTo(graph.width/2 - multiplier, graph.height/2);
    ctx.lineTo(graph.width/2 - multiplier, graph.height/2 + 2*multiplier);
    ctx.lineTo(graph.width/2, graph.height/2 + 2*multiplier);
    ctx.lineTo(graph.width/2 + 2*multiplier, graph.height/2);
    ctx.lineTo(graph.width/2, graph.height/2);
    ctx.fillStyle = "rgb(255,165,0)";
    ctx.fill();
    ctx.stroke();

    ctx.strokeRect(0, graph.height/2, graph.width, graph.height/2);
    ctx.strokeRect(graph.width/2, 0, graph.width/2, graph.height);

    ctx.font = "15px Arial";
    ctx.fillStyle = "black";
    ctx.fillText("R/2", graph.width/2+multiplier, graph.height/2-10);
    ctx.fillText("R", graph.width/2+multiplier*2, graph.height/2-10);

    ctx.fillText("-R/2", graph.width/2-multiplier, graph.height/2-10);
    ctx.fillText("-R", graph.width/2-multiplier*2, graph.height/2-10);


    ctx.fillText("R/2", graph.width/2+10, graph.height/2-multiplier);
    ctx.fillText("R", graph.width/2+10, graph.height/2-multiplier*2);


    ctx.fillText("-R/2", graph.width/2+10, graph.height/2+multiplier);
    ctx.fillText("-R", graph.width/2+10, graph.height/2+multiplier*2);
}

function listeners() {
    let x_inp = document.getElementById("form:x");
    x_inp.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
        }
    });

    let y_inp = document.getElementById("form:y");
    y_inp.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
        }
    });

    let r_inp = document.getElementById("form:r");
    r_inp.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
        }
    });

    let graph = document.getElementById("graph");
    ctx = graph.getContext("2d");
    graph.addEventListener('click', (e) =>{
        let r_cur = document.getElementById("form:r").value;
        let x = (e.offsetX - graph.width/2)/multiplier/2*r_cur;
        let y = (graph.height/2 - e.offsetY)/multiplier/2*r_cur;
        document.getElementById("form:can_x").value = x;
        document.getElementById("form:can_y").value = y;
        document.getElementById("form:submit_canv").click();
    })
}

function validateY(yVal) {
    let y = parseFloat(yVal);
    if (Number.isNaN(y) || y != parseFloat(yVal)) {
        return "Значение должно быть числом";
    } else if (y < -3 || y > 3) {
        return "Значение должно быть -3 <= y <= 3";
    }
    return "";
}

function validateR(rVal) {
    let r = parseFloat(rVal);
    if (Number.isNaN(r) || r !== parseFloat(rVal)) {
        return "Значение должно быть числом";
    } else if (r < 1 || r > 4) {
        return "Значение должно быть 1 <= r <= 4";
    }
    return "";
}

function validateValues() {
    let yVal = document.getElementById("form:y").value;
    let yError = document.getElementById("y_error");
    let y_ret = validateY(yVal);
    yError.innerText = y_ret;

    let rVal = document.getElementById("form:r").value;
    let rError = document.getElementById("r_error");
    let r_ret = validateR(rVal);
    rError.innerText = r_ret;
}

function addPoint(x,y,r,res) {
    let graph = document.getElementById("graph");
    let r_cur = document.getElementById("form:r");
    if (r_cur === r.toString()) {
        ctx = graph.getContext("2d");
        ctx.beginPath();
        ctx.arc(graph.width / 2 + x / r * 2 * 100, graph.height / 2 - y / r * 2 * 100, 10, 0, Math.PI * 2, true);

        if (res === true) {
            ctx.fillStyle = "rgb(0,0,0)";
        } else {
            ctx.fillStyle = "rgb(255,255,255)";
        }
        ctx.fill();
    }
}

function draw_point(x,y,r,res) {
    let graph = document.getElementById("graph");
    let r_cur = document.getElementById("form:r").value;
    ctx = graph.getContext("2d");
    if (r === parseFloat(r_cur)) {
        ctx.beginPath();
        ctx.arc(graph.width / 2 + x / r * 2 * 100, graph.height / 2 - y / r * 2 * 100, 10, 0, Math.PI * 2, true);

        if (res === true) {
            ctx.fillStyle = "rgb(0,0,0)";
        } else {
            ctx.fillStyle = "rgb(255,255,255)";
        }
        ctx.fill();
    }
}

function end_draw() {
    let graph = document.getElementById("graph");
    ctx = graph.getContext("2d");
    ctx.fillStyle = "rgb(0,0,0)";
}
