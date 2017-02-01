# Github4J

[![Build Status](https://travis-ci.org/Mr-Dai/Github4J.svg?branch=master)](https://travis-ci.org/Mr-Dai/Github4J) [![codecov](https://codecov.io/gh/Mr-Dai/Github4J/branch/master/graph/badge.svg)](https://codecov.io/gh/Mr-Dai/Github4J)

Github libraries for Java.

## Future Tasks

Module `core`:

- [ ] Implement all Github entities.
- [ ] Write test cases.

Module `webhook-standalone`:

- [ ] Implement `EventListener` dynamic registration for Groovy scripts.
- [ ] Implement `EventListener` dynamic registration for `.jar` files.
- [ ] Add common `EventListener` implementations.
- [ ] Implement Groovy DSL for customized `EventListener` building.

Whole project:

- [ ] Deploy to [https://jitpack.io/](https://jitpack.io/).
- [ ] Add `webhook-servlet` module.
- [ ] Implement `client-retrofit` module.
- [ ] Implement `client-httpclient` module.