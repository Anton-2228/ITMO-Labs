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
}
echo $responsePage="</table";
?>