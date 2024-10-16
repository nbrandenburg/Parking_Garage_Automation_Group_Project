/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

$(document).ready(function() {
    updateSpaceCount();

    $("#addSpaces").click(function() {
        let amount = parseInt($("#numberOfSpaces").val());
        $.ajax({
            url: "/addSpaces",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(amount),  // sending amount directly
            success: function() {
                updateSpaceCount();
            }
        });
    });

    $("#removeSpaces").click(function() {
        let amount = parseInt($("#numberOfSpaces").val());
        $.ajax({
            url: "/removeSpaces",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(amount),  // sending amount directly
            success: function() {
                updateSpaceCount();
            }
        });
    });

    function updateSpaceCount() {
        $.get("/getSpaces", function(data) {
            $("#garageSpaces").text(data);
        });
        $.get("/getOccupants", function(data) {
                    $("#occupants").text(data);
                });
    }
});
