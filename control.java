public class control {
    public static void main(String args[]) {
        // Scanner greeting = new Scanner(System.in);
        // System.out.println("Say something");
        // String user_input = greeting.nextLine();

        // if (user_input.equalsIgnoreCase("hello") || user_input.equalsIgnoreCase("hi")) {
        //     System.out.println("Chatbot: Hello! How can I help you today?");


        // } else if (user_input.equalsIgnoreCase("how are you") || user_input.equalsIgnoreCase("how’s it going")) {
        //     System.out.println("Chatbot: I'm just a bot, but I'm here to help you!");
        // } else if (user_input.equalsIgnoreCase("what’s the weather like") || user_input.equalsIgnoreCase("weather")) {
        //     System.out.println("Chatbot: I don’t have real-time weather data, but it's always sunny in the digital world!");
        // } else if (user_input.equalsIgnoreCase("bye") || user_input.equalsIgnoreCase("goodbye")) {
        //     System.out.println("Chatbot: Goodbye! Have a great day!");
        // } else {
        //     System.out.println("Chatbot: I'm sorry, I don't understand that.");
        // }
 
        // // Step 4: Close Scanner
        // greeting.close();
        //format condition ? expression1 : expression2;
        // int age = 16;
        // double discount = (age<18) ? 0.10 : 0;
        // System.out.println(discount);

        int score = 70;
        char grade = (score >= 90) ? 'A' 
                : (score >= 80) ? 'B'
                : (score >= 70) ? 'C' 
                : 'D';

        System.out.println(grade);

    }
}

