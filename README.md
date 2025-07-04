# E-CommerSystem-FawryAssesment

Product (abstract)
├─ ExpirableProduct
│  ├─ ShippableExpirableProduct (e.g., cheese, biscuits)
├─ NonExpirableProduct
│  ├─ ShippableNonExpirableProduct (e.g., TV, furniture)
│  ├─ NonShippableNonExpirableProduct (e.g., scratch cards)

#Key Features
Two Main Categories:

ExpirableProduct: For products with expiration dates

NonExpirableProduct: For products that don't expire

Subcategories:

Shippable variants for physical products that can be shipped

NonShippable for products that are delivered digitally or otherwise

This design allows simultaneous handling of:

Expiration logic for perishable goods

Shipping requirements for physical products

Examples
Shippable+Expirable: Food items (cheese, biscuits)

Shippable+NonExpirable: Electronics (TV), furniture

NonShippable+NonExpirable: Digital goods (scratch cards)
