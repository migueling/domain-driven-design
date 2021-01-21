# Lab 1 - DDD

You have been tasked to add a new feature to the e-commerce catalog to 
allow products to be organized into _Categories_. You are given the following
business requirements:

- A product belongs to a single _Category_.
- A product must always be part of a _Category_.
- A _Category_ is identified by its name (i.e. Electronics, Clothing, Books).

## Open Questions

- Should the _Category_ object be an Entity or a Value Object? 
- Do you need a Category repository? 

## Your tasks   

- Add _Category_ to the domain model.
- Update the _Product_ model so each product has a _Category_.
- Update the `CreateProductRequest` object to include _categoryName_.
- Update the `ProductInfo` object to include _categoryName_.


## Run locally

1. Clone the project

```
git clone https://github.com/ferdingler/domain-driven-design.git
```

2. Switch to lab1 branch

```
git checkout lab1
```

3. Run the project locally

```
./gradlew run
```

