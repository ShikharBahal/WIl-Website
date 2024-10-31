document.getElementById("paymentForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const fullName = document.getElementById("fullName").value;
    const email = document.getElementById("email").value;
    const address = document.getElementById("address").value;
    const cardNumber = document.getElementById("cardNumber").value;
    const expiry = document.getElementById("expiry").value;
    const cvv = document.getElementById("cvv").value;

    const orderNumber = Math.floor(Math.random() * 1000000);

    sendEmailConfirmation(email, orderNumber);

    const confirmationMessage = document.getElementById("confirmationMessage");
    confirmationMessage.innerHTML = `Thank you for your purchase, ${fullName}!<br>Your order number is: ${orderNumber}`;
    confirmationMessage.classList.remove("hidden");

    this.reset();
});

function sendEmailConfirmation(email, orderNumber) {
    console.log(`Email sent to ${email} with order number: ${orderNumber}`);
}

document.addEventListener("DOMContentLoaded", () => {
    const finalInvoiceAmount = document.getElementById("finalInvoiceAmount");
    const finalAmount = localStorage.getItem("finalAmount");

    if (finalAmount) {
        finalInvoiceAmount.textContent = `Final Amount: R${finalAmount}`;
    } else {
        finalInvoiceAmount.textContent = `Final Amount: R0.00`; // Default if no amount is found
    }
});
