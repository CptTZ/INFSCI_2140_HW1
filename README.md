# INFSCI 2140 Homework 1

## How to Build

In your console, type:

```bash
./mvnw package
```

Then it will run all the tests and if all passed, you can find the output **runnable** JAR file in the `target` folder.

### Build environment

- Windows 10 x64
- OpenJDK 1.8.181
- Maven 3.5.4 (With wrapper)

## Unit Test

It is enforced and this project is test-driven, by using JUnit 5.3.

## Information on external libraries

Although there is a `pom.xml` and there seems to be a lot of dependencies, in the packed file there are only classes that are covered in this source code. Therefore that means it **DOES NOT** use any external libraries.

## Notes

This homework relies heavily on specifications of **Java 1.8**, so JDK8 is a must!

## Reference

- Delimiters come from WEKA - <https://github.com/Waikato/weka-trunk/blob/master/weka/src/main/java/weka/core/tokenizers/CharacterDelimitedTokenizer.java>
