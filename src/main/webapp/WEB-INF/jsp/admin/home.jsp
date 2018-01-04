<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Independence cup home</title>
    <link href="<c:url value="/css/independence-cup.css" />" rel="stylesheet"/>
    <script type="text/javascript" src="<c:url value='/js/jquery-3.2.1.min.js' />"></script>
</head>
<body>

<!-- Tab links -->
<div class="tab">
    <button class="tablinks defaultOpen" id="tournament-tab" onclick="openTab('tournament', this)">Tournaments</button>
    <button class="tablinks" id="team-tab" onclick="openTab('team', this)">Teams</button>
    <button class="tablinks" id="player-tab" onclick="openTab('player')">Players</button>
    <button class="tablinks" id="score-tab" onclick="openTab('score', this)">Score</button>
</div>

<!-- Tab content -->
<div id="tournament" class="tabcontent">
    <h2>Tournaments:</h2>
    <div class="row-container">
        <div class="row-item header">Tournament Name</div>
        <div class="row-item header">Year</div>
        <div class="row-item header">Format</div>
        <div class="row-item header">Action</div>
    </div>
    <c:forEach items="${tournaments}" var="tournament">
        <div class="row-container">
            <div class="row-item">${tournament.tournamentName}</div>
            <div class="row-item">${tournament.year}</div>
            <div class="row-item">${tournament.format}</div>
            <div class="row-item">
                <div class="link" id="${tournament.id}" onclick="addTeamsToTournament(${tournament.id})">Add teams</div>
            </div>
        </div>
    </c:forEach>

    <br><br>
    <h3>Add a Tournament</h3>
    <form method="post" action="addTourney">
        Tournament Name : <input type="text" name="name"/>
        Year: <input type="text" name="year">
        Format: <select name="format">
        <option value="Group">Group</option>
        <option value="Rounds">Rounds</option>
    </select>
        <input type="submit" value="Submit">
    </form>
</div>

<div id="team" class="tabcontent">
    <h2>Teams:</h2>
    <c:forEach items="${tournaments}" var="tournament">
        <div class="hidden" id="teams-in-tourney-${tournament.id}">
            <div class="row-container">
                <div class="row-item header">Team Name</div>
                <div class="row-item header">Action</div>
                <%--<div class="row-item">Win</div>
                <div class="row-item">Loss</div>
                <div class="row-item">Draw</div>
                <div class="row-item">Points</div>
                <div class="row-item">NRR</div>--%>
            </div>
            <c:forEach items="${tournament.teams}" var="team">
                <div class="row-container">
                    <div class="row-item">${team.name}</div>
                    <div class="row-item"><div class="link" onclick="addPlayer(${team.id},'${team.name}')">Add players</div></div>
                    <%--<div class="row-item">${team.won}</div>
                    <div class="row-item">${team.loss}</div>
                    <div class="row-item">${team.draw}</div>
                    <div class="row-item">${team.points}</div>
                    <div class="row-item">${team.nrr}</div>--%>
                </div>
            </c:forEach>
            <br><br>
            <h2>Add Team:</h2>
            <form method="post" action="addTeam">
                <input type="hidden" id="tourney-id" name="tournamentId"  />
                Team Name : <input type="text" name="name"/>
                Group Name: <input type="text" name="groupName">
                <input type="submit" value="Submit">
            </form>
        </div>
    </c:forEach>


</div>
<div id="player" class="tabcontent">
    <div class="player-container">
        <h2>Player List:</h2>
        <input type="hidden" />
        <div class="row-container">
            <div class="row-item header">Player Name</div>
            <div class="row-item header">Dob</div>
            <div class="row-item header">Role</div>
        </div>
        <%--<c:forEach items="${tournaments}" var="tournament">
            <c:forEach items="${tournament.teams}" var="team">
                <c:forEach items="${team.players}" var="player">
                    <div class="row-container">
                        <div class="row-item">${player.name}</div>
                        <div class="row-item">${player.dob}</div>
                        <div class="row-item">${player.role}</div>
                    </div>
                </c:forEach>
            </c:forEach>
        </c:forEach>--%>

        <p>Enter Players for team: <span class="players_team-name"></span></p>
        <div class="row-container">
            <form method="post" action="addPlayer">
                <label>Name :</label><input type="text" name="name"/>
                <label>Dob [ dd/mm/yyyy ] :</label><input type="text" name="dob"/>
                <label>Role :</label>
                <select name="role">
                    <option value="Batsman">Batsman</option>
                    <option value="Batsman/Captain">Batsman/Captain</option>
                    <option value="Bowler">Bowler</option>
                    <option value="Bowler/Captain">Bowler/Captain</option>
                    <option value="AllRounder">AllRounder</option>
                    <option value="AllRounder/Captain">AllRounder/Captain</option>
                    <option value="WicketKeeper">WicketKeeper</option>
                    <option value="WicketKeeper/Batsman">WicketKeeper/Batsman</option>
                    <option value="WicketKeeper/Batsman/Captain">WicketKeeper/Batsman/Captain</option>
                </select>
                <input type="hidden" name="teamId" id="teamId" />
                <input type="submit" value="Submit">
            </form>
        </div>

    </div>
</div>

<div id="score" class="tabcontent">
    <h3>Tokyo</h3>
    <p>Tokyo is the capital of Japan.</p>
</div>
<script type="text/javascript" src="<c:url value='/js/independence-cup.js' />"></script>
</body>
</html>