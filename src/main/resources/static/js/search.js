$(document).ready(function() {
    $('#searchbar').on('change', function() {
        var inputValue = $(this).val();
        $('#link').attr('href', inputValue);
    });
});