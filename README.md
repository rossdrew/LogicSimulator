[![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)](MIT/Apache 2.0)
[![Build Status](https://travis-ci.org/rossdrew/LogicSimulator.svg?branch=master)](https://travis-ci.org/rossdrew/LogicSimulator)
[![codecov](https://codecov.io/gh/rossdrew/LogicSimulator/branch/master/graphs/badge.svg)](https://codecov.io/gh/rossdrew/LogicSimulator)

#LogicSimulator

Simple logic circuit simulator in order to play around with TDD, Mockito, [Pitest](http://pitest.org/), [Travis CI](https://travis-ci.com/) and [codecov](https://codecov.io/)

## Pitest

A mutation testing framework developed by [Henry Coles](https://github.com/hcoles), essentially mutates your code to see if your unit tests can pick it up.  Effectively unit testing your unit tests.

### Running

For a complete mutation test with [Pitest](http://pitest.org/) the command is normally
```
mvn org.pitest:pitest-maven:mutationCoverage
```
However, I have included it in my test phase so it is run as part of
```
mvn test
```

# Future

 - Add some UI for creating gate configurations.
