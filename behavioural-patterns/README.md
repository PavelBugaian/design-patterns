# Design Patterns Course: Creational Patterns Laboratory

## Author

Alexandru Calugari FAF-181 [@afishr](github.com/afishr)

## Topic

Behavioural Design Patterns. Implementation and usage.

## Introduction

This laboratory work implements an abstract financial system with accounts, transactions
and global state store for accounts.

## Theory

It is concerned with assignment of responsibilities between the objects. What makes them different from structural patterns is they don't just specify the structure but also outline the patterns for message passing/communication between them. Or in other words, they assist in answering "How to run a behavior in software component?"

In software engineering, behavioral design patterns are design patterns that identify common communication patterns between objects and realize these patterns. By doing so, these patterns increase flexibility in carrying out this communication.

Some examples of this kind of design patterns are :

* Chain of Responsibility
* Command
* Iterator
* Mediator
* Memento
* Observer
* Visitor
* Strategy
* State
* Template Method

## Implementation

### Classes Diagram

![classes diagram](../.github/creational-patterns/classes.jpg)

### Used Design Patterns

This project implements the following patterns:
* Command

#### Command

Allows you to encapsulate actions in objects. The key idea behind this pattern is to provide the means to decouple client from receiver.

In object-oriented programming, the command pattern is a behavioral design pattern in which an object is used to encapsulate all information needed to perform an action or trigger an event at a later time. This information includes the method name, the object that owns the method and values for the method parameters.

In project it's used to make an `SendMoneyUseCase` that get as parameter the `SendMoneyCommand`