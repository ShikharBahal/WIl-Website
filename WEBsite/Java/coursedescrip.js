function addToCart() {
    const item = {
        name: document.getElementById("courseName").textContent,
        price: parseFloat(document.getElementById("coursePrice").textContent.replace("R", "")),
        image: document.getElementById("courseImg").src
    };

    let cart = JSON.parse(localStorage.getItem("cart")) || [];
    cart.push(item);
    localStorage.setItem("cart", JSON.stringify(cart));

    alert("Item added to cart!");

    
    
}
