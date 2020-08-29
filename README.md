# Lab 4 - Feature Flags

There is a new implementation of the ProductRepository named _HardcodedProductRepository_.
The CatalogApplication loads the proper implementation based on the `foo.bar` feature flag.

Change this feature flag from `InMemory` to `Hardcoded` and see how the implementation is
changed without making any code modifications.
