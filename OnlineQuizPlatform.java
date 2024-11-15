import java.util.*;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;

    // Constructor
    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Display the question and options
    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Check if the answer is correct
    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswerIndex + 1;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex + 1;
    }
}
public class OnlineQuizPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        int score = 0;

        // Add questions to the quiz
        questions.add(new Question("What is the Capiatl of India?",
                new String[]{"Lucknow", "Delhi", "Mumbai", "Bihar"}, 1));
        questions.add(new Question("Where is the headquater of TCS?",
                new String[]{"Mumbai", "2.France", "US", "Paris"}, 0));
        questions.add(new Question("Who wrote 'Gaban Godan'?",
                new String[]{"Tulisdas", "Ramdhari Singh DInkar", "Premchandra", "kabirdas"}, 2));
        questions.add(new Question("Where is the headquater of Wipro?",
                new String[]{"Bengaluru", "New York", "Giraffe", "Great White Shark"}, 0));
        questions.add(new Question("How many country were there in G20?",
                new String[]{"Ten", "Six", "Seven", "Twenty"}, 3));

        // Loop through each question
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ":");
            questions.get(i).displayQuestion();
            
            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            // Check answer and give feedback
            if (questions.get(i).isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was option " + questions.get(i).getCorrectAnswerIndex() + ".\n");
            }
        }
        System.out.println("Quiz over! Your final score is: " + score + "/" + questions.size());

        // Close the scanner
        scanner.close();
    }
}