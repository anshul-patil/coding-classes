import java.util.Scanner;
 /**
 * Write a description of class GameTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameTester 
{
    public static void main(String[] s)
    {
        ChoiceQuestion b = new ChoiceQuestion();
        b.setText("This is question 1?");
        b.addChoice("answer 1", false);
        b.addChoice("answer 2", true);
        b.addChoice("answer 3", false);
        b.addChoice("answer 4", false);
        
        b.display();
        System.out.printf("Wrong answer 1: %b\n", b.checkAnswer(1));
        System.out.printf("Right answer 2: %b\n", b.checkAnswer(2));
        
        QuestionBank qb = new QuestionBank();
        qb.addQuestion(b);
        
        b = new ChoiceQuestion();
        b.setText("This is question 2?");
        b.addChoice("answer 1", true);
        b.addChoice("answer 2", false);
        b.addChoice("answer 3", false);
        b.addChoice("answer 4", false);
        
        qb.addQuestion(b);
        System.out.printf("Bank has 2 questions = %d\n", qb.numQuestions());
        
        // see if it picks different questions randomly
        for (int i = 0; i < 10; i++)
        {
            Question q = qb.getQuestion();
            q.display();
        }
        
        Scanner kboard = new Scanner(System.in);
        System.out.println("Press any key");
        String input = kboard.nextLine();
        
        Game g = new Game();
        System.out.println("The first level " + g.getLevel());
        g.setWonLevel(true);
        g.gotoNextLevel();
        System.out.println("The second level after winning " + g.getLevel());
        System.out.println("The prize money after winning if you walk now : " + g.getPrizeMoney());
        g.setWonLevel(false);
        g.gotoNextLevel();
        System.out.println("The level after getting the question wrong " + g.getLevel());
        System.out.println("The prize money after losing : " + g.getPrizeMoney() + "\n");
        
        for (int i = 1; i <=Game.MAX_LEVEL; i++)
        {
            g.setWonLevel(true);
            System.out.println("The level is " + g.getLevel()+ " and the money for it is $" + g.getPrizeMoney());
            g.gotoNextLevel();
        }
    }
}
