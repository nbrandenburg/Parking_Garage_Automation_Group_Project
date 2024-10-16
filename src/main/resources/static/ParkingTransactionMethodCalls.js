/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

function submitForm() {
    var formData = {
        startDate: document.getElementById('startdate').value,
        startTime: document.getElementById('startime').value,
        endDate: document.getElementById('enddate').value,
        endTime: document.getElementById('endtime').value,
        recurring: {
            sun: document.getElementById('reservSun').checked,
            mon: document.getElementById('reservMon').checked,
            tue: document.getElementById('reservTues').checked,
            wed: document.getElementById('reservWed').checked,
            thu: document.getElementById('reservThu').checked,
            fri: document.getElementById('reservFri').checked,
            sat: document.getElementById('reservSat').checked
        }
    };

    fetch('/createReservation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (response.ok) {
                if (response.redirected) {
                    window.location.href = response.url; // This should be the payment URL.
                } else {
                    console.log("Success:", response.statusText);
                }
            } else {
                throw new Error(`Request failed: ${response.status}`);
            }
        })
        .catch(error => console.error('Error:', error));
}
