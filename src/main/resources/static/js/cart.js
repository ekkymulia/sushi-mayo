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
            var totalPrice = parseFloat(localStorage.getItem("totalPrice"));
            var cartCount = parseInt(localStorage.getItem("cartCount"));

            var product = response;

            if (!product.quantity || isNaN(product.quantity)) {
                product.quantity = 1; // Set a default quantity value if it's missing or invalid
            }

            if (cartItems) {
                var parsedCartItems = JSON.parse(cartItems);
                var existingProduct = parsedCartItems.find(item => item.idMenu === product.idMenu);

                if (existingProduct) {
                    // Product already exists in the cart, update the quantity
                    existingProduct.quantity += product.quantity;
                } else {
                    // Product is not in the cart, add it
                    parsedCartItems.push(product);
                }

                // Update the total price and cart count
                if (isNaN(totalPrice)) {
                    totalPrice = 0; // Set totalPrice to 0 if it's not a valid number
                }
                totalPrice += parseFloat(product.hargaMenu.replace(",", "")) * product.quantity;
                cartCount += product.quantity;

                // Update the cart items, total price, and cart count in the local storage
                localStorage.setItem("cartItems", JSON.stringify(parsedCartItems));
                localStorage.setItem("totalPrice", totalPrice);
                localStorage.setItem("cartCount", cartCount);
            } else {
                // No cart items yet, create a new cart
                var newCartItems = [product];

                // Update the total price and cart count
                totalPrice = parseFloat(product.hargaMenu.replace(",", "")) * product.quantity;
                cartCount = product.quantity;

                // Update the cart items, total price, and cart count in the local storage
                localStorage.setItem("cartItems", JSON.stringify(newCartItems));
                localStorage.setItem("totalPrice", totalPrice);
                localStorage.setItem("cartCount", cartCount);
            }
        },
        error: function(xhr, status, error) {
            console.error("Error fetching product details:", error);
            // Handle any error scenarios or display error messages
        }
    });
}


function getAllItemsFromCart() {
    var cartItems = localStorage.getItem("cartItems");
    if (cartItems) {
        return JSON.parse(cartItems);
    } else {
        return [];
    }
}

function displayCartItems() {
    var cartItems = localStorage.getItem("cartItems");
    var totalPrice = localStorage.getItem("totalPrice");
    var tableBody = document.querySelector(".cart-table tbody");
    var totalBox = document.querySelector("#total-box");

    totalBox.innerHTML = "";
    tableBody.innerText = "";

    if (cartItems) {
        var parsedCartItems = JSON.parse(cartItems);
        parsedCartItems.forEach(function(item) {
            var idMenu = item.idMenu;
            var namaMenu = item.namaMenu;
            var hargaMenu = item.hargaMenu;
            var quantity = item.quantity;
            var totalHarga = parseInt(item.hargaMenu.replace(",", "")) * parseInt(quantity);

            // Format totalHarga as "Rp 30,000" format
            var formattedHarga = "Rp " + totalHarga.toLocaleString();

            // Create a new table row
            var newRow = document.createElement("tr");
            newRow.classList.add("table-body-row");

            // Create and append table cells with menu item details
            newRow.innerHTML = `
            <td class="product-remove"><a href="" onclick="removeFromCart(${idMenu})"><i class="far fa-window-close"></i></a></td>
            <td class="product-image"><img src="img/products/product-img-1.jpg" alt=""></td>
            <td class="product-name">${namaMenu}</td>
            <td class="product-price">Rp ${hargaMenu}</td>
            <td class="product-quantity"><input type="number" name="quantity" onchange="updateQuantity(${idMenu}, this.value)" value="${quantity}" placeholder="0"></td>
            <td class="product-total">${formattedHarga}</td>
        `;

            // Append the new row to the table body
            tableBody.appendChild(newRow);
        });

        var formattedTotalPrice = "Rp " + totalPrice.toLocaleString();
        // Update the total box with the formatted total price
        totalBox.innerText = formattedTotalPrice;
    }
}

function updateQuantity(menuId, newQuantity) {
    var cartItems = localStorage.getItem("cartItems");
    var totalHarga = localStorage.getItem("totalPrice");
    var cartCount = localStorage.getItem("cartCount");

    if (cartItems) {
        var parsedCartItems = JSON.parse(cartItems);

        // Find the menu item in the cartItems array based on menuId
        var menuItem = parsedCartItems.find(item => item.idMenu === menuId);
        if (menuItem) {
            if (newQuantity === "0") {
                removeFromCart(menuId);
                return;
            }
            // Calculate the price difference caused by the quantity change
            var oldTotalPrice = parseFloat(menuItem.hargaMenu.replace(",", "")) * parseInt(menuItem.quantity);
            var priceDifference = (parseFloat(menuItem.hargaMenu.replace(",", "")) * newQuantity) - oldTotalPrice;

            // Update the quantity and total price of the menu item
            menuItem.quantity = parseInt(newQuantity);
            menuItem.totalPrice = parseFloat(menuItem.hargaMenu.replace(",", "")) * menuItem.quantity;

            // Update the totalPrice and cartCount values accordingly
            totalHarga = totalHarga - oldTotalPrice + menuItem.totalPrice;
            if(totalHarga < 0){
                totalHarga = 0
            }
            cartCount = parseInt(cartCount) + (newQuantity - menuItem.quantity);
        }

        // Update the modified values in the local storage
        localStorage.setItem("cartItems", JSON.stringify(parsedCartItems));
        localStorage.setItem("totalPrice", totalHarga);
        localStorage.setItem("cartCount", cartCount);

        displayCartItems();
    }
}

function removeFromCart(idMenu) {
    var cartItems = localStorage.getItem("cartItems");
    if (cartItems) {
        var parsedCartItems = JSON.parse(cartItems);

        // Find the index of the item with the matching idMenu
        var itemIndex = parsedCartItems.findIndex(function(item) {
            return item.idMenu === idMenu;
        });

        // Remove the item from the array
        if (itemIndex !== -1) {
            // Get the removed item's details
            var removedItem = parsedCartItems[itemIndex];

            parsedCartItems.splice(itemIndex, 1);
            cartItems = JSON.stringify(parsedCartItems);
            localStorage.setItem("cartItems", cartItems);

            // Update the total price and cart count
            var totalPrice = parseFloat(localStorage.getItem("totalPrice"));
            var cartCount = parseInt(localStorage.getItem("cartCount"));

            totalPrice -= removedItem.totalPrice;
            cartCount -= removedItem.quantity;

            localStorage.setItem("totalPrice", totalPrice);
            localStorage.setItem("cartCount", cartCount);

            // Refresh the displayed cart items
            displayCartItems();
        }
    }

}


