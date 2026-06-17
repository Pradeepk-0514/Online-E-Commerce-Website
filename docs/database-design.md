# Database Design

## Database Name

ecommerce_db

---

## Tables

### Users

* id
* first_name
* last_name
* email
* password
* phone_number
* role
* status
* created_at

---

### Sellers

* id
* user_id
* store_name
* store_logo
* business_name
* contact_number
* approval_status
* created_at

---

### Categories

* id
* category_name
* description

---

### Products

* id
* seller_id
* category_id
* product_name
* description
* price
* stock_quantity
* image_url
* created_at

---

### Cart

* id
* user_id

---

### Cart_Items

* id
* cart_id
* product_id
* quantity

---

### Wishlist

* id
* user_id
* product_id

---

### Addresses

* id
* user_id
* full_name
* phone_number
* address
* city
* state
* postal_code

---

### Orders

* id
* user_id
* total_amount
* order_status
* payment_status
* created_at

---

### Order_Items

* id
* order_id
* product_id
* quantity
* price

---

### Reviews

* id
* user_id
* product_id
* rating
* review_text

---

### Payments

* id
* order_id
* payment_method
* transaction_id
* payment_status

---

## Relationships

User -> Cart

User -> Wishlist

User -> Orders

Seller -> Products

Category -> Products

Order -> OrderItems

Product -> Reviews
