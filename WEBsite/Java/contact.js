document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    // Get form data
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const message = document.getElementById('message').value;

    // Simulate sending the data (you would usually send this to your server)
    console.log('Form submitted:', { name, email, message });

    // Show response message
    const responseMessage = document.getElementById('responseMessage');
    responseMessage.classList.remove('hidden');
    responseMessage.innerText = 'Thank you for contacting us, ' + name + '! We will get back to you shortly.';
    responseMessage.style.backgroundColor = '#dff0d8';
    responseMessage.style.color = '#3c763d';
});
