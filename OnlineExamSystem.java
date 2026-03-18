import java.util.*;
import java.util.concurrent.*;

class Question {
    String questionText;
    List<String> options;
    int correctAnswer;

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class OnlineExamSystem {
    static boolean isSubmitted = false;
    static int score = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Creating questions
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("Java is a ?",
                Arrays.asList("Language", "OS", "Hardware", "Browser"), 1));

        questions.add(new Question("Which keyword is used for inheritance?",
                Arrays.asList("this", "super", "extends", "implements"), 3));

        questions.add(new Question("Which method is entry point?",
                Arrays.asList("start()", "main()", "run()", "init()"), 2));

        questions.add(new Question("Which is not primitive type?",
                Arrays.asList("int", "float", "String", "char"), 3));

        // 2. Shuffle questions
        Collections.shuffle(questions);

        // 3. Timer
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.schedule(() -> {
            if (!isSubmitted) {
                System.out.println("\n⏰ Time's up! Auto-submitting...");
                isSubmitted = true;
                System.out.println("Your score: " + score);
                System.exit(0);
            }
        }, 30, TimeUnit.SECONDS);

        // 4. Asking questions
        for (int i = 0; i < questions.size(); i++) {

            if (isSubmitted) break;

            Question q = questions.get(i);

            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);

            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (answer == q.correctAnswer) {
                score++;
            }
        }

        // 5. Submit exam
        submitExam();
        scheduler.shutdown();
    }

    public static void submitExam() {
        if (isSubmitted) {
            System.out.println("You have already submitted the exam.");
            return;
        }

        isSubmitted = true;
        System.out.println("\n✅ Exam submitted successfully!");
        System.out.println("Your final score: " + score);
    }
}