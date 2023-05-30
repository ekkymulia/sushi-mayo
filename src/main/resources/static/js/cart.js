function addToCart(productId) {
    // Get the product details based on the productId
    var product = getProductDetails(productId);
    console.log("done")
}

function getProductDetails(productId) {
    $.ajax({
        url: "http://127.0.0.1:8080/shop/getProductDetails", // Replace with the actual URL of your server endpoint
        type: "GET",
        data: {
            id: productId
        }, // Replace with any additional parameters required by your server endpoint
        success: function(response) {
            var cartItems = localStorage.getItem("cartItems");
            var parsedCartItems = cartItems ? JSON.parse(cartItems) : [];
            parsedCartItems.push(response);
            cartItems = JSON.stringify(parsedCartItems);
            localStorage.setItem("cartItems", cartItems);
        },
        error: function(xhr, status, error) {
            console.error("Error fetching product details:", error);
            // Handle any error scenarios or display error messages
        }
    });
}
