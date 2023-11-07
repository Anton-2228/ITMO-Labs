<%@ page import="org.example.AllHit" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <title>Lab1</title>
</head>
<body onload="start()">
<%
    HttpSession this_session = request.getSession();
    if (this_session.getAttribute("hits") == null) {
        this_session.setAttribute("hits", new AllHit());
    }
%>
<table id="body">
    <tr>
        <td>
            <table id="header">
                <tr>
                    <td><p>Группа: P3206</p></td>
                    <td><p id="name">Зинченко Антон Андреевич</p></td>
                    <td><p>Вариант: 1616</p></td>
                </tr>
            </table>
        </td>
    </tr>
    <form action="" method="post" onsubmit="return false" id="form">
        <tr>
            <td>
                <table id="main">
                    <tr>
                        <td class="field">
                            <p>Координата X:</p>
                            <div id="x-block">
                                <label for="x-4">-4<br />
                                    <button name="x" value="-4" id="x-4">-4</button></label>
                                <label for="x-3">-3<br />
                                    <button name="x" value="-3" id="x-3">-3</button></label>
                                <label for="x-2">-2<br />
                                    <button name="x" value="-2" id="x-2">-2</button></label>
                                <label for="x-1">-1<br />
                                    <button name="x" value="-1" id="x-1">-1</button></label>
                                <label for="x0">0<br />
                                    <button name="x" value="0" id="x0">0</button></label>
                                <label for="x1">1<br />
                                    <button name="x" value="1" id="x1">1</button></label>
                                <label for="x2">2<br />
                                    <button name="x" value="2" id="x2">2</button></label>
                                <label for="x3">3<br />
                                    <button name="x" value="3" id="x3">3</button></label>
                                <label for="x4">4<br />
                                    <button name="x" value="4" id="x4">4</button></label>
                            </div>
                            <p id="selectedX">Выбрано: 0</p>
                        </td>
                        <td rowspan="3" colspan="2">
                            <canvas height="500" width="500" id="graph"></canvas>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">
                            <p>Координата Y:</p>
                            <input type="text" maxlength="10" name="y" id="y" placeholder="Введите значение от -5 до 3">
                            <p id="y_error"></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="field">
                            <p>Значение R:</p>
                            <select name="r" id="r">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p id="serverError"></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button id="submit" onclick="validateValues()">Отправить</button>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </form>
    <tr>
        <td id="cellResTable">
            <table id="resTable">
            </table>
        </td>
    </tr>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="script.js"></script>
</body>
</html>