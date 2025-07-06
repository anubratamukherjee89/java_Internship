import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to represent a quiz question
class Question {
    String questionText;
    String[] options;
    int correctOptionIndex;

    public Question(String questionText, String[] options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctOptionIndex;
    }

    public void displayQuestion() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

// Main class to run the quiz
public class onlineQuizApp {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Sample questions
        questions.add(new Question("What is the capital of India?",
                new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 1));

        questions.add(new Question("Which language is used for Android Development?",
                new String[]{"Python", "Swift", "Kotlin", "PHP"}, 2));

        questions.add(new Question("Who is the founder of Microsoft?",
                new String[]{"Steve Jobs", "Bill Gates", "Mark Zuckerberg", "Elon Musk"}, 1));

        questions.add(new Question("What is the value of 7 * 6?",
                new String[]{"42", "36", "48", "40"}, 0));

        // Quiz loop
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.displayQuestion();

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt() - 1;

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.options[q.correctOptionIndex]);
            }
        }

        // Final score
        System.out.println("\n🎯 Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        scanner.close();
    }
}
