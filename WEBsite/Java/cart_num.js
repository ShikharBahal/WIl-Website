// Example cart count variable (this should be updated based on your actual cart logic)
let cartCount = 0;

// Function to update the cart count display
function updateCartCount() {
    // Get the cart count element
    const cartCountElement = document.getElementById('cartCount');
    // Update the displayed count
    cartCountElement.textContent = cartCount;
}

// Example function to add an item to the cart
function addToCart() {
    // Increase cart count (replace with your actual cart logic)
    cartCount++;
    // Update the displayed cart count
    updateCartCount();
}

// Initialize the cart count on page load (if needed)
document.addEventListener('DOMContentLoaded', updateCartCount);
