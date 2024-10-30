document.addEventListener("DOMContentLoaded", () => {
    const cartItemsContainer = document.getElementById("cartItems");
    const cartTotal = document.getElementById("cartTotal");
    const discountAmount = document.getElementById("discountAmount");
    const finalAmount = document.getElementById("finalAmount");
    const clearCartButton = document.getElementById("clearCartButton");
    const cartCount = document.getElementById("cartCount"); // Get the cart count element

    let cart = JSON.parse(localStorage.getItem("cart")) || [];
    let total = 0;

    function calculateDiscount(itemCount, total) {
        let discountRate = 0;

        if (itemCount === 2) discountRate = 0.05;
        else if (itemCount === 3) discountRate = 0.10;
        else if (itemCount >= 4) discountRate = 0.15;

        return total * discountRate;
    }

    function updateCartDisplay() {
        cartItemsContainer.innerHTML = "";
        total = 0;
        const itemCount = cart.length;

        // Update the cart count display
        cartCount.textContent = itemCount;

        cart.forEach((item) => {
            total += item.price;

            const cartItem = document.createElement("div");
            cartItem.classList.add("cart-item");

            cartItem.innerHTML = `
                <img src="${item.image}" alt="${item.name}" class="cart-item-image" style="width: 60px; height: auto;">
                <div class="cart-item-details" style="display: inline-block; padding-left: 10px;">
                    <h3 class="cart-item-name">${item.name}</h3>
                    <p class="cart-item-price">R${item.price.toFixed(2)}</p>
                </div>
            `;
            cartItemsContainer.appendChild(cartItem);
        });

        const discount = calculateDiscount(itemCount, total);
        const final = total - discount;

        cartTotal.textContent = `Total: R${total.toFixed(2)}`;
        discountAmount.textContent = `Discount: R -${discount.toFixed(2)}`;
        finalAmount.textContent = `Final Amount: R${final.toFixed(2)}`;

        localStorage.setItem("finalAmount", final.toFixed(2));
    }

    clearCartButton.addEventListener("click", () => {
        cart = [];
        localStorage.setItem("cart", JSON.stringify(cart));
        updateCartDisplay();
    });

    updateCartDisplay();
});
