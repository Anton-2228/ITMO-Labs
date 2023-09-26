<?php

$htmlHead = '<html lang="en">
<head>
    <title>Point Checker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        
        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>';

function cookieOperations($x, $y, $R): array
{
    if (isset($_COOKIE["prevResults"])) {
        $urlData = $_COOKIE["prevResults"];
        $data = explode(";", urldecode($urlData));

        $xData = explode(",", $data[0]);
        $yData = explode(",", $data[1]);
        $rData = explode(",", $data[2]);

        $xData[] = $x;
        $yData[] = $y;
        $rData[] = $R;

        setcookie("prevResults", "$data[0],$x;$data[1],$y;$data[2],$R", time() + 86400, '/', );
        return
            [
                "x" => $xData,
                "y" => $yData,
                "R" => $rData,
            ];

    }
    else {
        setcookie("prevResults", "$x;$y;$R", time() + 86400, '/');
        return
            [
                "x" => [$x],
                "y" => [$y],
                "R" => [$R],
            ];
    }
}
$startTime = microtime(true);

if ($_SERVER["REQUEST_METHOD"] === "GET") {
    if(isset($_GET["X-radio"], $_GET["y"], $_GET["R-select"])){
        $x = $_GET["X-radio"];
        $y = $_GET["y"];
        $radius = $_GET["R-select"];
        if (in_array($x, range(-3, 6)) and
            ((-3 <= $y) and ($y <= 5)) and # поправить промежуток
            in_array($radius, [1.0, 1.5, 2.0, 2.5, 3.0])) {
            // Добавьте здесь свою логику проверки точки
            $responsePage = $htmlHead . "<h3>Results:</h3>
            <table>
                <tr> 
                    <th>X</th>
                    <th>Y</th>
                    <th>Radius</th>
                    <th>Result</th>
                </tr>";
            $cookieData = cookieOperations($x, $y, $radius);
            $xCookieData = $cookieData["x"];
            $yCookieData = $cookieData["y"];
            $rCookieData = $cookieData["R"];
            for ($i=0; $i<count($xCookieData);$i++) {
                $x_i = $xCookieData[$i];
                $y_i = $yCookieData[$i];
                $r_i = $rCookieData[$i];
                if (
                    (($y_i <= $r_i and $x_i <= $r_i) and ($x_i >= 0 and $y_i >= 0)) or
                    (($x_i**2 + $y_i**2 <= $r_i**2) and ($x_i <= 0 and $y_i >= 0)) or
                    (($y_i <= -2 * ($x_i + $r_i)) and ($x_i <= 0 and $y_i <= 0))
                ) {
                    $result = "Got!";
                }
                else {
                    $result = "Miss!";
                }
                $responsePage = $responsePage . "
                    <tr>
                        <td>" . $x_i . "</td>
                        <td>" . $y_i . "</td>
                        <td>" . $r_i . "</td>
                        <td>" . $result . "</td>
                    </tr>";
            }
            $currentTime = microtime(true);
            $dateTime = date('d F Y H:i:s', $currentTime);
            $scriptTime = $startTime - $currentTime;
            $responsePage = $responsePage . "
                    <tr>
                        <td colspan='2'> Current time: " . $dateTime . " sec</td>
                        <td colspan='2'> Script time: " . $scriptTime . " sec </td>
                    </tr>";
            echo $responsePage . "</table></body></html>";
        }
        else {
            echo $htmlHead . "<h1>Error - unexcpectable values</h1></body></html>";
        }
    }
}
?>