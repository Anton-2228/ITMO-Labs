<?php

echo $responsePage="<h2>Результаты</h2>
                    <table>
                    <tr>
                    <td><p>R</p></td>
                    <td><p>X</p></td>
                    <td><p>Y</p></td>
                    <td><p>Текущее время</p></td>
                    <td><p>Время выполнения</p></td>
                    <td><p>Результат</p></td>
                    </tr>";

$ST = microtime(true);
$x = $_POST["x"];
$y = $_POST["y"];
$r = $_POST["r"];
$y_all = explode(".", $y);

$res = 'успех';
date_default_timezone_set('Europe/Moscow');
$time = date('H:i:s', time());

// if (count($y_all) == 2 and ($y_all[0] > -3 and $y_all[0] < 5 or (($y_all = -3 or $y_all = 5) and $y_all[1] === 0))) {
//     ma();
//     print("124");
// } else {
//     ma();
// }
if (in_array($x, range(-4,4)) and 
    $y_all[0] >= -3 and $y_all[0] <= 5 and
    in_array($r, range(1, 3))) {
        $pass = 1;
        if (count($y_all) != 1) {
            if (($y_all[0] == -3 or $y_all[0] == 5) and $y_all[1][-1] > 0) {
                $pass = 0;
            }
        }
        if ($pass == 1) {
            if ($y < -$r or $y > $r or $x > $r or $x < -$r/2) {
                $res = "мимо";
            } else if ($y > 0 and $x > 0 and $y**2+$x**2 > $r**2) {
                $res = "мимо";
            } else if ($x < 0 and $y > 0) {
                $res = "мимо";
            } else if ($x < 0 and $y < 0 and $x+$y < -$r) {
                $res = "мимо";
            }
            $FT = microtime(true);
            $execTime = $FT - $ST;
            echo $responsePage="<tr>
                <td><p>$r</p></td>
                <td><p>$x</p></td>
                <td><p>$y</p></td>
                <td><p>$time</p></td>
                <td><p>$execTime</p></td>
                <td><p>$res</p></td>
                </tr>";
            if (isset($_COOKIE["count"])) {
                $count = urldecode($_COOKIE["count"]) + 1;
                setcookie("count", $count, time() + 100000, '/');
            } else {
                $count = 0;
                setcookie("count", $count, time() + 100000, '/');
            }
            setcookie("cook$count", "$r;$x;$y;$time;$execTime;$res", time() + 100000, '/');
        }
    };
if (isset($_COOKIE["count"])) {
    $count = urldecode($_COOKIE["count"]);
    for($i=$count; $i>=0; $i--) {
        $cook = explode(";", urldecode($_COOKIE["cook$i"]));
        $rAct = $cook[0];
        $xAct = $cook[1];
        $yAct = $cook[2];
        $timeAct = $cook[3];
        $execTimeAct =  $cook[4];
        $resAct = $cook[5];
        echo $responsePage="<tr>
        <td><p>$rAct</p></td>
        <td><p>$xAct</p></td>
        <td><p>$yAct</p></td>
        <td><p>$timeAct</p></td>
        <td><p>$execTimeAct</p></td>
        <td><p>$resAct</p></td>
        </tr>";
    };
};
echo $responsePage="</table";
?>