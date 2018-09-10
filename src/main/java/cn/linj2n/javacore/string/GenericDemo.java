package cn.linj2n.javacore.string;

public class GenericDemo {
    public static void main (String[] args) {
        String greeting = "Hello";
        int n = greeting.length(); // is 5
        int cpCount = greeting.codePointCount(0, greeting.length()); // is 5

        String sayHello = "Hello,world.";
        /*-----------------^^^^^^^^^^^^------*/
        /*-----------------0123456789AB------*/
        int startIndexOfello = sayHello.indexOf("ello"); // is 1
        int startIndeOfwor = sayHello.indexOf("wor"); // is 6
        int startindeOfworFrom1 = sayHello.indexOf("wor",1); // is 6
        int startindeOfworFrom7 = sayHello.indexOf("wor",7); // is -1

        String newSayHello = sayHello.replace("world", "I'm coding now");   // "Hello,I'm coding now."

    }
}
