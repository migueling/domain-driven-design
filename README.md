# Lab 2

## Part 1 - ShoppingCart

There is a new feature on the Product catalog that allows customers to add 
or remove products from a shopping cart and then calculate the total checkout
cost of their cart. You need to write the in-memory implementation of the ShoppingCart 
service.  

The interface has already been defined in the domain services package and the 
empty implementation is in the infrastructure package. 

## Part 2 - Sku Generation

Your job is to implement a new mechanism to generate product _Skus_ based on the product name
and category. There is a new method in the _Sku_ class that you need to 
modify to do this excercise. Use Test Driven Development to do implement the new
behavior of Sku generation. 

Example sku generation:   
**Product Name**: Instant Pot Cooker   
**Category**: Kitchen Accessories

Expected output:  
**Sku**: KITC-INSTANTPOT-5836