$(document).ready(function(){
    $('.defaultOpen').click();

    $('.team-list').on('change',function(){
        displayPlayerEntryTable($(this));
        /*$(this).find('option:selected').each(function(){
            alert($(this).attr("value"));
        });*/
    });
});

function openTab(tabId, thisObj) {
    // Get all elements with class='tabcontent' and hide them
    $('.tabcontent').each(function () {
        $(this).hide();
    });

    // Get all elements with class='tablinks' and remove the class 'active'
    $('.tablinks').each(function () {
        $(this).removeClass('active');
    })

    // Show the current tab, and add an 'active' class to the button that opened the tab
    $('#' + tabId).show();
    $(thisObj).addClass('active');
}

function addTeamsToTournament(tourneyId) {
    var formId = '#openteam-' + tourneyId;
    $(formId).submit();
    /*openTab('team', $('#team-tab'));
    $('#tourney-id').val(tourneyId);*/
}


function displayPlayerEntryTable(thisObj) {
    thisObj.find('option:selected').each(function(){
        if($(this).attr("value") != 'noValue') {
            $('.player-container').removeClass('hidden');
        }else {
            $('.player-container').addClass('hidden');
        }
    });
}

/* Player related function */
function addPlayer(teamId,teamName) {
    openTab('player', $('#player-tab'));
    $('#player .players_team-name').html(teamName);
    $('#player #teamId').val(teamId);
    getTeamPlayersList(teamId);
}

/* Will complete this next change */

/*function getTeamPlayersList(teamId) {
    $.ajax({
        type : "GET",
        url: "getPlayerList",
        data: {'teamId' : teamId},
        success : function(data) {
            console.log('Success');
        },
        error : function(data) {
            console.log('Failed');
        }
    });
}*/

