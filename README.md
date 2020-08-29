# Lab 4 - Feature Flags

There is a new implementation of the ProductRepository named _HardcodedProductRepository_.
The CatalogApplication loads the proper implementation based on the `flags.productRepository` feature flag.

Change this feature flag from `InMemory` to `Hardcoded` and see how the implementation is
changed without making any code modifications.

## Part 2

There are 2 methods for generating a Sku. One receives 2 parameters, and the other receives none. 
Add a new feature flag `skuGeneration` to make your application choose one method vs
the other based on the value of this flag. 

**Hint**: Use the `src/main/java/com.ferdingler.infrastructure.config.FeatureFlag` class to load the configuratio properties. You can
find more information about this in the micronaut docs: 
https://guides.micronaut.io/micronaut-configuration/guide/index.html.  
