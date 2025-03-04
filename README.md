# Clean Code
## Appendix A - Concurrency  - Client Server Example
Full code implementation of an example of the topic concurrency from the book Clean Code by Robert C. Martin.

This example ilustrates a client/server application. At first, it does not have any type of concurrency (nonthreaded pkg), but when dealing with
several concurrent requests it may not be enough. The tests in nonthreaded pkg will simulate multiple simultaneous requests and they will fail.

At the `threaded` pkg it is implemented a multi-threaded approach, in which the tests will pass. 