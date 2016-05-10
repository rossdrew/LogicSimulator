#LogicSimulator

Simple logic circuit simulator in order to play around with TDD and [Pitest](http://pitest.org/)

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

