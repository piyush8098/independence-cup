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
    openTab('team', $('#team-button'));
    $('#tourney-id').val(tourneyId);
    $('#teams-in-tourney-' + tourneyId).show();
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

function addPlayer(teamId) {
    $(".team-list").val(teamId);
}

