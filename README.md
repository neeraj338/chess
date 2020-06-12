chess assignment
=====================================
A step-by-step introduction.

System Requirements:
--------------------
- OpenJDK for Java 1.8
- Git
- Gradle
- Project Lombok https://projectlombok.org

Building the example project:
-----------------------------

To build the fat JAR and run tests:

    ./gradlew build test

Run:

    java -jar build/libs/chess-1.0-SNAPSHOT.jar

Jacoco tst coverage:
    
    ./gradlew jacocoTestReport


Assumptions:
-------------------------
- Assume that the board is empty. This means that the pawn cannot move diagonally.
- JUnit coverage using jacoco-plugin.

References:
-----------


