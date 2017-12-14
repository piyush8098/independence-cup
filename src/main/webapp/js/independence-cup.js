$(document).ready(function(){
    $('.defaultOpen').click();
});

function openTab(tabId) {
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
    $(this).addClass('active');
}