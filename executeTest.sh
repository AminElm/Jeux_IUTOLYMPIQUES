# execute les test
java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls -javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp bin:lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path --class-path bin
# produit le rapport jacoco
java -jar lib/jacococli.jar report jacoco.exec --classfiles bin --sourcefiles src/main/java --html report