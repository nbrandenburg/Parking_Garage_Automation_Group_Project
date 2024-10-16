/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

document.addEventListener("DOMContentLoaded", function() {

    const form = document.getElementById('userCreationForm');
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submit action

        // Collect user data from form
        const userData = {
            username: document.getElementById('username').value,
            password: document.getElementById('password').value,
            email: document.getElementById('email').value,
            phoneNumber: document.getElementById('phone').value,
            firstName: document.getElementById('firstname').value,
            lastName: document.getElementById('lastname').value,
            role: 'USER',
            vehicles: [
                {
                    licensePlate: document.getElementById('licenseplate').value,
                    make: document.getElementById('make').value,
                    model: document.getElementById('model').value,
                    color: document.getElementById('color').value
                    // user will be set on the backend since it's the owner of this vehicle
                }
            ]
        };

        sendDataToServer(userData);
    });

    function sendDataToServer(data) {
        fetch('/createuser', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Handle success
        })
        .catch((error) => {
            console.error('Error:', error);
            // Handle errors
        });
    }
});
