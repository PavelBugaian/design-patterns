# Design Patterns Course: Creational Patterns Laboratory

## Author

Alexandru Calugari FAF-181 [@afishr](github.com/afishr)

## Topic

Structural Design Patterns. Implementation and usage.

## Introduction

This laboratory work implements an abstract financial system with accounts and transactions.

## Theory

Structural patterns are mostly concerned with object composition or in other words how the entities can use each other. Or yet another explanation would be, they help in answering "How to build a software component?"

In software engineering, structural design patterns are design patterns that ease the design by identifying a simple way to realize relationships between entities.

Some examples of this kind of design patterns are :

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

## Implementation

### Classes Diagram

![classes diagram](../.github/creational-patterns/classes.jpg)

### Used Design Patterns

This project implements the following patterns:
* Adapter
* Proxy
* Facade

#### Adapter

The adapter gets an interface `Money`, compatible with one of the existing objects `Bitcoin`
Using this interface, the existing object `Bitcoin` can safely call the adapter’s methods.
Upon receiving a call, the adapter passes the request to the second object, but in a format and order that the second object expects.


#### Proxy

Proxy is used to secure `Account` methods. If you don't have the rights to make transactions, proxy will not let you do that by verifying you have provided password, for example.

#### Facade 

Facade is used to hide the framework's complexity behind a simple interface, wrapping a set of interfaces.