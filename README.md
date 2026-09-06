## How to run tests

### From IDE

1. Open the project in IntelliJ IDEA.
2. Make sure the project is imported as a Gradle project.
3. Open the test class:
   `src/test/java/tests/BuyingAccessories.java`
4. Click the green Run icon next to the test method or test class.
5. Select `Run 'BuyingAccessories'`.

### From command line

Open Terminal in the project root directory and run:

./gradlew test --tests "tests.BuyingAccessories"
