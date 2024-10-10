---
#author: Daan de Graaf
title: REST Principles 
subtitle: and the Art of Code Generation in an API-First Approach

---

# Introduction

- **Scenario**: Imagine a guest trying to book a hotel room...
- **Expectations**: Learn about REST, API-First design, and practical implementation with OpenAPI.


# Agenda

- Introduction to REST Principles
- Understanding Resources in REST
- HTTP Methods and Responses
- API-First Approach
- Introduction to OpenAPI
- Workshop Overview
- Future Workshops
- Q&A

# What is REST?

## What is REST?
**Representational State Transfer (REST)**

_An architectural style for designing networked applications._

## What is REST?

- **Key Principles:**
  - Resource based
  - HTTP Methods
  - Stateless
  - <span class="fragment fade-in">
      <span class="fragment highlight-red">
        Hypermedia as the Engine of Application State (HATEOAS)
      </span>
    </span>


# Understanding Resources in REST

## Understanding resources
- **Resources**: Core entities in an API.
  - Examples:
    - **Rooms**: `/guests`
    - **Room**: `/rooms/{roomNumber}`
    - **Reservation**: `/room/{roomId}/reservations`
- **Representation**: JSON, XML, etc.

## Representation
- Abstraction of data or functionality
- Resources are identified by URIs
  - Uniquely addressable on the web

## State
- Changing resource state using HTTP methods
- Resource vs Endpoint

## Relationships
- Linking to other resources
- `Reservation` links to `Guest` and `Room`
  - `/rooms/123/reservations`
  - `/guests/45/reservations`

# HTTP Methods in REST

- **Common Methods**:
  - **GET**, **POST**, **PUT/PATCH**, **DELETE**

##

![Standard HTTP methods](images/http-methods.png)
<sub><sup>[Source: Logius Standaard](https://gitdocumentatie.logius.nl/publicatie/api/adr/1.0/#http-methods)</sup></sub>

##

![Standard HTTP methods](images/http-examples.png)  
<sub><sup>[Source: Logius Standaard](https://gitdocumentatie.logius.nl/publicatie/api/adr/1.0/#http-methods)</sup></sub>

<small>HTTP also defines other methods, e.g. HEAD, OPTIONS and TRACE. For the purpose of this design rule, these operations are left out of scope.</small>

## Idempotence
![Standard HTTP methods](images/http-idempotence.png)  
<sub><sup>[Source: Logius Standaard](https://gitdocumentatie.logius.nl/publicatie/api/adr/1.0/#http-methods)</sup></sub>


# HTTP Responses
- **Standard Status Codes**:
  - **200 OK**, **201 Created**, **204 No Content**, **400 Bad Request**, **404 Not Found**, **500 Internal Server Error**
- **Visual**: [Add table summarizing status codes with examples]


# Statelessness
> One of the key constraints of the REST architectural style is stateless communication between client and server. It means that every request from client to server must contain all of the information necessary to understand the request




## API-First Approach
- **Definition**: Design APIs before implementation.
- **Benefits**:
  - Clarity, Collaboration, Documentation
- **Visual**: [Flowchart of API-First design process]

---

## Pros and Cons of API-First
- **Pros**: Clarity, Flexibility, Documentation
- **Cons**: Upfront Investment, Change Management

---

# Introduction to OpenAPI
- **Definition**: A standard format for defining APIs.
- **Features**:
  - Language-agnostic, Supports code generation
- **Example**: Show an OpenAPI document snippet.

---

# Visualizing the API World
- **API Relationships**:
  - **Hotel** ↔ **Room** ↔ **Reservation**
- **Diagram**: [Insert visual diagram]

---

# Workshop Overview
- **Objective**: Develop a RESTful API for managing hotels, rooms, and reservations.
- **Focus Areas**: Code generation, Service layer implementation, Hands-on session.

---

# Code Implementation Tips
- **What to Remove**: Unused classes, Overly complex logic.
- **Best Practices**: Simplicity, Error handling.

---

# Future Workshops
- **Topics**: Client Code Generation, Error Handling, Unit Testing, HATEOAS.

---

# Conclusion
- **Key Takeaways**: [Summarize main points]
- **Call to Action**: Apply learnings to projects!

---

# Feedback
- **Questions/Feedback**: [Encourage participants to share feedback]

---

# Q&A
- Open the floor for questions.

___

## Example OpenAPI Specification
```yaml
paths:
  /hotels:
    get:
      summary: List all hotels
  /hotels/{hotelId}/rooms:
    get:
      summary: List rooms in a hotel
```
---

# Horizontal Slide 1

Content for slide 1.

## Vertical Slide 1.1

Content for vertical slide 1.1.

## Vertical Slide 1.2

Content for vertical slide 1.2.

# Horizontal Slide 2

Content for slide 2.
