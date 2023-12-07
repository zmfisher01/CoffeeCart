# Group 29: "Coffee-Shop" Shopping Cart

This is a Java shopping cart application with a Swing UI. It logs in Customers, who can add a selection of products to a cart, and then purchase those items. Customers can even view more detailed information about a product before adding it. In the Cart, they can adjust item quantity or remove unwanted items. Merchants can also log in. Merchants may view products similarly to customers, alongside being able to edit product details, add products, and remove products.

## Team Members

 - Zee Fisher
 - Edwin Gomez
 - Charles Fernandez-Hamoui

## Glossary

 - Java : The Java programming language, compiler, and respective software platform.
 - Swing UI: GUI toolkit for Java.
 - Customer : User who purchases products from the Coffee-Shop.
 - Merchant : User who lists products to be sold on the Coffee-Shop.
 - System : Abstract component of the shop that manages its functionality.
 - Product : Purchasable item composed of a price, quantity, description, image, and name.
 - Cart : Collection of products a user wants to purchase.
 - Product Database : Database of products that can be purchased on Coffee-Shop.

## Functional Specification

 1. Registers new Customers and Merchants.
 2. Logs in new Customers and Merchants.
 3. Displays purchasable Products to Buyers.
 4. Displays currently listed Products to Merchants.
 5. Tracks Products a Buyer wants to purchase in a Cart.
 6. Reduces quantity of Products after Purchases.
 7. Adds new Products to be sold by Merchants.
 8. Increases quantity of currently listed Products.
 9. Displays revenue, sales, and profit to Merchants.

## Use Cases

### Customer Logs In

 1. System displays Login page with option to sign in or create account.

 2. Customer enters username and Password

 3. Customer selects "Submit"

 4. System compares login info to database and finds matching username and hashed password

 5. System displays home page: a list of purchasable items, each with a picture, name, and price

 6. System displays options to view details, add to cart, and view cart

### Customer Logs In -- Variations

__Customer Enters Incorrect Login Info__

 1. 1 After step 1 Customer enters bad Login username/password combination
 
 1. 2 Customer selects "Submit"
 
 1. 3 System compares login information to database
 
 1. 4 System informs customer that login information was incorrect and to try again

__Customer Clicks Register__

 2. 1 After Step 1 Customer selects "Register"

 2. 2 System directs customer to the account creation page

 2. 3 Customer enters a username, password, the same password again, and a type

 2. 4 System validates password and if the username isn't already used

 2. 5 System redirects to login page

__Customer Enters Bad Register info__

 3. 1 After step 2.2 Customer enters already used information or mismatched passwords

 3. 2 System updates registration page to inform customer of the mistake

### Customer Reviews Product Details

 1. Customer carries out __Customer Logs In__

 2. Customer selects item name from list

 3. System directs customer to product page: display of a products name, picture, price, merchant, and description.

 4. System displays options to "Return" to product list or to "Add to Cart"

 5. Customer selects "Return" and returns to hope page.

### Customer Adds Items to Shopping Cart

 1. Customer carries out __Customer Logs In__

 2. Customer selects "Add to cart" next to item

 3. System adds item to cart

### Customer Adds Items to Shopping Cart -- Variations

__Customer Is In Product Details__

 1. 1 Customer carries out __Customer Reviews Product Details__

 1. 2 Customer selects "Add to cart"

 1. 3 System adds item to cart

__Item already in cart.__

 2. 1 After step 2 OR 1.2 System finds item already in cart

 2. 2 System increases quantity of item in cart

### Customer Reviews/Updates Shopping Cart

 1. Customer carries out __Customer Logs In__ OR __Customer Adds Items to Shopping Cart__

 2. System displays shopping cart, a list of unique items the user wants to purchase and the quantity

 3. System displays options to return to homepage, delete item from cart, change quantity, and to checkout

 4. Customer Selects "Return to Homepage"

 5. System displays homepage

### Customer Reviews/Updates Shopping Cart -- Variations

__User Selects "Delete Item From Cart"__

 1. 1 After step 3 Customer selects "Delete Item From Cart" next to the item to delete.

 1. 2 System removes that unique item from the Customer's cart and updates the page.

__Customer Selects "Change quantity"__

 2. 1 After step 3 Customer selects "Change quantity"

 2. 2 Customer enters new quantity between 1 and the available quantity. 

 2. 3 System updates new quantity in cart and page

__Customer Selects "Checkout"__

 3. 1 After step 3 Customer selects "Checkout"

 3. 2 System displays checkout page with fields for payment info and address.

 3. 3 System displays options to "Complete Checkout" or "Cancel Checkout".

### Customer Checks Out

 1. Customer carries out __Customer Reviews/Updates Shopping Cart__ variation __Customer Selects "Checkout"__

 2. Customer enters payment and address information

 3. Customer selects "Complete Checkout" which submits payment, address, and cart.

 4. System deducts each purchased Product's quantity by the amount purchased.

### Customer Checks Out -- Variations

__Customer Selects "Cancel Checkout"__

 1. 1 After step 1 OR step 2, customer selects "Cancel Checkout"

 1. 2 System returns to Cart page

### Merchant Logs In

 1. System displays Login page with option to sign in or create account.

 2. Merchant enters username and Password

 3. Merchant selects "Submit"

 4. System compares login info to database and finds matching username and hashed password

 5. System displays merchant page: a list of items up for sale, each with a picture, name, and price

 6. System displays options to view details, remove product, and add product.

### Merchant Logs In -- Variations

__Merchant Enters Incorrect Login Info__

 1. 1 After step 1 Merchant enters bad Login username/password combination

 1. 2 Merchant selects "Submit"

 1. 3 System compares login information to database

 1. 4 System informs merchant that login information was incorrect and to try again

__Merchant Clicks Register__

 2. 1 After Step 1 Merchant selects "Register"

 2. 2 System directs Merchant to the account creation page

 2. 3 Merchant enters a username, password, the same password again, and a type

 2. 4 System validates password and if the username isn't already used

 2. 5 System redirects to login page

__Merchant Enters Bad Register info__

 3. 1 After step 2.2 Merchant enters already used information or mismatched passwords

 3. 2 System updates registration page to inform Merchant of the mistake


### Merchant Reviews/Updates Inventory

 1. Merchant carries out __Merchant Logs In__

 2. Merchant selects a product name to view details

 3. System displays product details, an option to go back, and an option to edit details.

 4. Merchant selects "Edit Details" and submits new/changed details

 5. System updates product in database and for the display

### Merchant Reviews/Updates Inventory -- Variations

__Merchant Selects "Remove Product"__

 1. 1 After step 1. Merchant selects "Remove Product"

 1. 2 System prompts merchant for a confirmation

 1. 3 Merchant selects "OK"

 1. 4 System removes product

__Merchant Cancels Removing Product__

 2. 1 After step 1.2 Merchant selects "Cancel"

 2. 2 No product is removed

__Merchant edits Product Quantity__

 3. 1 After step 1. merchant selects "Edit Quantity"

 3. 2 Merchant types in a new quantity and confirms.

 3. 3 System updates quantity in Product Database.

### Merchant Adds New Product

 1. Merchant carries out  __Merchant Logs In__

 2. Merchant selects "Add Product"

 3. System displays add product page with space for product details

 4. Merchant enters product information

 5. Merchant selects "Submit"

 6. System adds product to product database

### Merchant Reviews Revenue, Sales, and Profit

 1. Merchant completes __Merchant Logs In__

 2. Merchant selects "View Stats"

 3. System displays the Merchant's Revenue, Sales, and Profit

 4. Merchant selects "Close"

 5. System hides the stats
