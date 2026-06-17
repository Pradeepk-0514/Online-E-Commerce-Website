Project ecommerce_platform {
  database_type: 'PostgreSQL'
  Note: 'Multi-vendor E-commerce Platform'
}

Table users {
  id bigint [pk, increment]
  first_name varchar
  last_name varchar
  email varchar [unique, not null]
  password varchar [not null]
  phone_number varchar
  role varchar [not null]
  status varchar
  created_at timestamp
}

Table seller_profiles {
  id bigint [pk, increment]
  user_id bigint [unique, not null]
  store_name varchar
  store_logo varchar
  business_name varchar
  contact_number varchar
  approval_status varchar
}

Table categories {
  id bigint [pk, increment]
  category_name varchar [not null]
  description text
}

Table products {
  id bigint [pk, increment]
  seller_id bigint [not null]
  category_id bigint [not null]
  product_name varchar [not null]
  description text
  price decimal
  stock_quantity integer
  image_url varchar
  created_at timestamp
}

Table carts {
  id bigint [pk, increment]
  user_id bigint [unique, not null]
}

Table cart_items {
  id bigint [pk, increment]
  cart_id bigint [not null]
  product_id bigint [not null]
  quantity integer
}

Table wishlists {
  id bigint [pk, increment]
  user_id bigint [not null]
  product_id bigint [not null]
}

Table addresses {
  id bigint [pk, increment]
  user_id bigint [not null]
  full_name varchar
  phone_number varchar
  address text
  city varchar
  state varchar
  postal_code varchar
}

Table orders {
  id bigint [pk, increment]
  user_id bigint [not null]
  total_amount decimal
  order_status varchar
  payment_status varchar
  created_at timestamp
}

Table order_items {
  id bigint [pk, increment]
  order_id bigint [not null]
  product_id bigint [not null]
  quantity integer
  price decimal
}

Table reviews {
  id bigint [pk, increment]
  user_id bigint [not null]
  product_id bigint [not null]
  rating integer
  review_text text
}

Table payments {
  id bigint [pk, increment]
  order_id bigint [unique, not null]
  payment_method varchar
  transaction_id varchar
  payment_status varchar
}

/* Relationships */

Ref: seller_profiles.user_id - users.id

Ref: products.seller_id > seller_profiles.id

Ref: products.category_id > categories.id

Ref: carts.user_id - users.id

Ref: cart_items.cart_id > carts.id

Ref: cart_items.product_id > products.id

Ref: wishlists.user_id > users.id

Ref: wishlists.product_id > products.id

Ref: addresses.user_id > users.id

Ref: orders.user_id > users.id

Ref: order_items.order_id > orders.id

Ref: order_items.product_id > products.id

Ref: reviews.user_id > users.id

Ref: reviews.product_id > products.id

Ref: payments.order_id - orders.id
