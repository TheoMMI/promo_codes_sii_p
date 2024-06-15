This is the program that I've coded from friday noon to saturday 7pm
It sadly does not implement H2, the data is stored in an ArrayList.

To access the API open either postman or curl, here is the list of all the endpoints:\
* ### (POST) createProduct
 #### Variables
    String name
    Float price
    String currency
#### Description
Creates a product from a name, price and currency

* ### (GET) getProducts
### Variables
    None
### Description
Returns all the products registered

* ### (PUT) updateProducts
### Variables
    String name
### Description
Updates a product with a given name

* ### (POST) createPromoCode
#### Variables
    String name
    int year
    int month
    int day
    Float discount
    int usesLeft
    String currency
#### Description
Creates a product from the given parameters

* ### (GET) getPromoCodes
### Variables
    None
### Description
Returns all the promo codes registered

* ### (GET) getPromoCode
### Variables
    String name
### Description
Returns a specific promo code with the given name

* ### (GET) getDiscountPrice
### Variables
    String productName
    String promoCodeName
### Description
Returns the calculated price with a discount applied

* ### (GET) purchase
### Variables
    String productName
    String promoCodeName
### Description
Calculates the discounted price of a product with a promo code and stores the resulting sale in an array. 
Functions similarly as getDiscountPrice.

