# Lab 2 - TDD

This lab is divided in two parts, the goal is to apply Domain Driven Design and 
Test Driven Development to solve them.

## Part 1 - ShoppingCart

Write the in-memory implementation of the ShoppingCart service. The interface
has already been defined in the domain services package. **Note:** The cart 
must allow a maximum of 10 products to be added.

## Part 2 - Sku Generation

Implement a new mechanism to generate product _Skus_ based on the product name
and category. There is a new function in the _Sku_ class that you need to 
modify to change the implementation. Use Test Driven Development to do it. 

Example sku generation:   
**Product Name**: Instant Pot Cooker   
**Category**: Kitchen Accessories

Expected output:  
**Sku**: KITC-INSTANTPOT-5836