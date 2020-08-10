# Domain Driven Design - Lab

This project contains the backend for an e-commerce product catalog. 

## Domain Model

The domain model is very simple. The catalog has _Products_ and each 
product has a _name_ and a unique identifier _Sku_.   

### Entities

- Product

### Value Objects

- Sku

## Project Structure

The structure of the source code is based on the DDD layers: 

- **API**: Entry-point for incoming user requests.
- **Application**: Orchestration layer, translates API objects <-> Domain models.
- **Domain**: Entities, Value Objects and all the business logic goes here.
- **Infrastructure**: Interacts with low level external services like databases.




