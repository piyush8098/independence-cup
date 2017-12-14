<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Independence cup home</title>
    <link href="<c:url value="/css/independence-cup.css" />" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value='/js/jquery-3.2.1.min.js' />"></script>
</head>
<body>

<!-- Tab links -->
<div class="tab">
    <button class="tablinks defaultOpen" onclick="openTab('team')">Teams</button>
    <button class="tablinks" onclick="openTab('player')">Players</button>
    <button class="tablinks" onclick="openTab('score')">Score</button>
</div>

<!-- Tab content -->
<div id="team" class="tabcontent">
    <h2>Teams:</h2>
    <div class="row-container">
        <div class="row-item">Team Name</div>
        <div class="row-item">Win</div>
        <div class="row-item">Loss</div>
        <div class="row-item">Draw</div>
        <div class="row-item">Points</div>
        <div class="row-item">NRR</div>
    </div>
    <c:forEach items="${teams}" var="team">
        <div class="row-container">
            <div class="row-item">${team.name}</div>
            <div class="row-item">${team.won}</div>
            <div class="row-item">${team.loss}</div>
            <div class="row-item">${team.draw}</div>
            <div class="row-item">${team.points}</div>
            <div class="row-item">${team.nrr}</div>
        </div>
    </c:forEach>
    <br><br>
    <h2>Add Team:</h2>
    <form method="post" action="addTeam">
        Team Name : <input type="text" name="name"/>
        Group Name: <input type="text" name="groupName">
        <input type="submit" value="Submit">
    </form>
</div>

<div id="player" class="tabcontent">
    <h3>Paris</h3>
    <p>Paris is the capital of France.</p>
</div>

<div id="score" class="tabcontent">
    <h3>Tokyo</h3>
    <p>Tokyo is the capital of Japan.</p>
</div>
<script type="text/javascript" src="<c:url value='/js/independence-cup.js' />"></script>
</body>
</html>