document.getElementById('sendEmailButton').addEventListener('click', function() {
    const notesInput = document.getElementById('notesInput').value;

    if (!notesInput) {
        alert('Please enter some notes or questions before sending.');
        return;
    }

    const email = "recipient@example.com"; // Replace with your email
    const subject = "Notes/Questions";
    const body = encodeURIComponent(notesInput);
    window.location.href = `mailto:${email}?subject=${subject}&body=${body}`;
});
