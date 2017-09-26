![license](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)
[![Build Status](https://travis-ci.org/rossdrew/LogicSimulator.svg?branch=master)](https://travis-ci.org/rossdrew/LogicSimulator) 
[![codecov](https://codecov.io/gh/rossdrew/LogicSimulator/branch/master/graph/badge.svg)](https://codecov.io/gh/rossdrew/LogicSimulator)

# Logic Simulator

Simple logic circuit simulator in order to play around with TDD, Mockito, [Pitest](http://pitest.org/), [Travis CI](https://travis-ci.org/) and [codecov](https://codecov.io/) (using JaCoCo)

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
[JaCoCo](http://eclemma.org/jacoco/) reports are also generated in the test phase.

# Future

 - Add some UI for creating gate configurations.
 - Fix the code coverage
