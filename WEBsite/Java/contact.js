// Initialize Google Map
function initMap() {
    const location = { lat: -26.1031, lng: 27.8924 }; // Replace with actual latitude and longitude
    const map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: location,
    });
    const marker = new google.maps.Marker({
        position: location,
        map: map,
    });
}

// Load the map
window.onload = initMap;

document.getElementById('emailForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    const emailInput = document.getElementById('emailInput');
    const errorMessage = document.getElementById('errorMessage');
    const emailValue = emailInput.value;

    // Simple email validation
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    if (!emailPattern.test(emailValue)) {
        errorMessage.textContent = 'Please enter a valid email address.';
        errorMessage.style.display = 'block';
    } else {
        errorMessage.style.display = 'none';
        alert('Email sent to: ' + emailValue); // Simulate sending email
        emailInput.value = ''; // Clear input after submission
    }
});
