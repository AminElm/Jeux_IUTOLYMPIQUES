#permet de compiler les tests
javac -Xlint:unchecked --module-path /usr/share/openjfx/lib --add-modules javafx.controls -d bin -cp lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar src/main/java/com/cdal/*.java src/test/java/com/cdal/*.java