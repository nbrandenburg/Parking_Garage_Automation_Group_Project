/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

window.addEventListener('load', (event) => {
  const urlParams = new URLSearchParams(window.location.search);
  const amount = urlParams.get('amount'); // Extract the amount from the URL
  if (amount) {
    document.getElementById('amount').value = amount; // Populate the amount input field
  }
});