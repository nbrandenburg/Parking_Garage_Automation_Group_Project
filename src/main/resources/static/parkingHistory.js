/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

document.addEventListener("DOMContentLoaded", function() {
    fetchAndDisplayParkingHistory();
});

function fetchAndDisplayParkingHistory() {
    $.get("/parkingHistory", function(parkingHistory) {
        $('#parkingHistoryContainer').empty();
        parkingHistory.forEach(transaction => {
            var now = new Date();
            var endTime = new Date(transaction.endTime);
            var startTime = new Date(transaction.startTime);
            var cancelButton = '';
            const options = {style: "currency", currency: "USD"};
            const numberFormat = new Intl.NumberFormat('en-US', options);
            var amountCharged = numberFormat.format(transaction.amountCharged);
            if (endTime > now) {
                cancelButton = '<button onclick="cancelTransaction(' + transaction.transactionId + ')">Cancel</button>';
            }
            $('#parkingHistoryContainer').append(
                '<table>'
                + '<tr><th>Start Date</th>' 
                + '<th>Start Time</th>'
                + '<th>End Date</th>'
                + '<th>End Time</th>'
                + '<th>Amount</th>'
                + '<th>Cancel</th></tr>'
                + '<tr><td>' + startTime.toDateString() + '</td>'
                + '<td>' + startTime.toTimeString() + '</td>'
                + '<td>' + endTime.toDateString() + '</td>'
                + '<td>' + endTime.toTimeString() + '</td>'
                + '<td>' + amountCharged + '</td>'
                + '<td>' + cancelButton + '</td></tr>'
                + '</table>'
            );
        });
    });
}

function cancelTransaction(transactionId) {
    // Logic to cancel the transaction
}

