# E-CommerSystem-FawryAssesment

## 📐 Class Hierarchy Structure

```mermaid
classDiagram
    class Product{
        <<abstract>>
    }
    
    class ExpirableProduct
    class NonExpirableProduct
    class ShippableExpirableProduct
    class ShippableNonExpirableProduct
    class NonShippableNonExpirableProduct
    
    Product <|-- ExpirableProduct
    Product <|-- NonExpirableProduct
    ExpirableProduct <|-- ShippableExpirableProduct
    NonExpirableProduct <|-- ShippableNonExpirableProduct
    NonExpirableProduct <|-- NonShippableNonExpirableProduct
