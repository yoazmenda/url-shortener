/*
 * This Java source file was generated by the Gradle 'init' task.
 */



import static spark.Spark.*;

public class Klix {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {

        get("/hello", (req, res) -> "Hello World");
    }
}