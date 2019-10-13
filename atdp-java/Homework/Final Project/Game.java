import java.util.Scanner;
/**
 * Write a description of class QuizToTake here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class Game
{
    private QuestionBank[] questionBanks;
    private int level;
    private boolean wonLevel;
    private boolean lifelineUsed;
    public static final int MAX_LEVEL = 10;
    private int[] money;
    private Scanner kboard;
    
    final EasySound startGame = new EasySound("intro.wav"); //done
    final EasySound answerCorrect = new EasySound("right.wav"); //done
    final EasySound answerWrong = new EasySound("wrong.wav"); //done
    final EasySound newQuestion = new EasySound("newquestion.wav"); //done
    final EasySound finishGame = new EasySound("outro.wav"); //done
    
    public Game()
    {
        questionBanks = new QuestionBank[MAX_LEVEL];
        for(int i = 0; i < MAX_LEVEL;i++)
        {
            questionBanks[i] = new QuestionBank();
        }
        level = 0;
        wonLevel = false;
        lifelineUsed = false;
        kboard = new Scanner(System.in);
        money = new int[] {0, 7500, 10000, 15000, 25000, 50000, 75000, 150000, 250000, 500000, 1000000};
        
        System.out.println("\f\n\n\nWelcome to WHO WANTS TO BE MILLIONAIRE!!!");
        System.out.println("\n\nGet Ready for a Big Showdown in Berkeley California!!");
        
        System.out.println("\n\nDesigned by Anshul Patil for ATDP 2017");
        System.out.println("RULES: \n1. Answer the question using numbers 1-4\n2. You can use one life-line or 50:50 by pressing 0 and you can only use it once");
        System.out.println("3. Don't type anything while you are READING THIS");
        System.out.println("\nGood Luck!!!");
        System.out.println("\n\nWAIT... for game to load....");
    }
    
    public int getMoneyForLevel()
    {
        return money[level];
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void gotoNextLevel()
    {
        if(wonLevel)
        {
           level++; 
        }
    }
    
    public void setWonLevel(boolean input)
    {
        wonLevel = input;
    }
    
    public int getPrizeMoney()
    {
        if(wonLevel)
        {
            return getMoneyForLevel();
        }
        else
        {
            // after level 5 you leave with atleast that much money
            if (level >= 5) 
            {
                return money[5];
            }
            else
            {
                return 0;
            }
        }
    }
    
    public void loadQuestions()
    {
        startGame.play();
        
        //Level 1 questions(Presidents)
        QuestionBank level1 = questionBanks[0];
        
        //Q1
        ChoiceQuestion b = new ChoiceQuestion();
        b.setText("Where does the President live?");
        b.addChoice("The Twin Towers", false);
        b.addChoice("The White House", true);
        b.addChoice("A Hotel", false);
        b.addChoice("The Black House", false);
        
        level1.addQuestion(b);
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("What is the name of the first President?");
        b.addChoice("John Adams", false);
        b.addChoice("George Washington", true);
        b.addChoice("Donald Trump", false);
        b.addChoice("Abraham Lincoln", false);

        level1.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("Who was the first U.S. president to resign from that office?");
        b.addChoice("Richard Nixon", true);
        b.addChoice("George W. Bush", false);
        b.addChoice("Franklin Roosavelt", false);
        b.addChoice("Abraham Lincoln", false);

        level1.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("What was Richard Nixon's middle name?");
        b.addChoice("Walter", false);
        b.addChoice("William", false);
        b.addChoice("Milhous", true);
        b.addChoice("Steward", false);

        level1.addQuestion(b);
        
        //Level 2 Questions(Countries)
        QuestionBank level2 = questionBanks[1];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("In what country did Magic Johnson play professional basketball during the 1999 Season?");
        b.addChoice("USA", false);
        b.addChoice("Canada", false);
        b.addChoice("Spain", false);
        b.addChoice("Sweden", true);

        level2.addQuestion(b);
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("Where is fireworks first known to have been develop?");
        b.addChoice("USA", false);
        b.addChoice("China", true);
        b.addChoice("Germany", false);
        b.addChoice("Japan", false);

        level2.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("Which of these countries is not in Europe?");
        b.addChoice("Israel", true);
        b.addChoice("Hungary", false);
        b.addChoice("Austria", false);
        b.addChoice("Norway", false);

        level2.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("What country is famous for making wooden shoes?");
        b.addChoice("China", false);
        b.addChoice("Japan", false);
        b.addChoice("The Netherlands", true);
        b.addChoice("Mongolia", false);

        level2.addQuestion(b);
        
        //Level 3 Questions(Basketball)
        QuestionBank level3 = questionBanks[2];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("Which player has the most championship rings in the history of the NBA\n(National Basketball Association)?");
        b.addChoice("LeBron James", false);
        b.addChoice("Micheal Jordan", false);
        b.addChoice("Stephen Curry", false);
        b.addChoice("Bill Russel", true);

        level3.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("Which player was NOT in the Warriors starting lineup in the 2017 season?");
        b.addChoice("Andre Iguodala ", true);
        b.addChoice("Zaza Pachulia", false);
        b.addChoice("Stephen Curry", false);
        b.addChoice("Draymond Green", false);

        level3.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("Which player is known for scoring 100 points in one nba game?");
        b.addChoice("Wilt Chamberlain", true);
        b.addChoice("Kobe Bryant", false);
        b.addChoice("Stephen Curry", false);
        b.addChoice("Micheal Jordan", false);

        level3.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("Which player in the NBA had the triple-double record before the current MVP broke it?");
        b.addChoice("LeBron James", false);
        b.addChoice("Kobe Bryant", false);
        b.addChoice("Oscar Roberson", true);
        b.addChoice("Micheal Jordan", false);

        level3.addQuestion(b);
        
        //level4 question(food)
        QuestionBank level4 = questionBanks[3];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("The first Mcdonald's opened in which U.S state?");
        b.addChoice("Massachusetts", false);
        b.addChoice("Texas", false);
        b.addChoice("New York", false);
        b.addChoice("California", true);

        level4.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("Roquefort is a French blue cheese made from the milk of what animal?");
        b.addChoice("Goat ", false);
        b.addChoice("Sheep", true);
        b.addChoice("Cow", false);
        b.addChoice("Llama", false);

        level4.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("What fast food franchise has the most locations worldwide?");
        b.addChoice("KFC", false);
        b.addChoice("Subway", true);
        b.addChoice("McDonald's", false);
        b.addChoice("Taco Bell", false);

        level4.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("Dijon mustand originated in the city of Dijon, located in what country??");
        b.addChoice("France", true);
        b.addChoice("Spain", false);
        b.addChoice("Ireland", false);
        b.addChoice("Whales", false);

        level4.addQuestion(b);
        
        //level5 question(words)
        QuestionBank level5 = questionBanks[4];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("Which word means 'to attach to?");
        b.addChoice("antiseptic", false);
        b.addChoice("annex", true);
        b.addChoice("antediluvian", false);
        b.addChoice("anathema", false);

        level5.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("Which word means 'discontented as toward authority'?");
        b.addChoice("dirge ", false);
        b.addChoice("disaffected", true);
        b.addChoice("didactic", false);
        b.addChoice("discomfit", false);

        level5.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("Which word means 'someone who attacks cherished ideas or institutions'?");
        b.addChoice("iconoclast", true);
        b.addChoice("idiosyncratic", false);
        b.addChoice("impecunious", false);
        b.addChoice("impetuous", false);

        level5.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("Which word means 'a speech of violent denunciation'?");
        b.addChoice("wily", true);
        b.addChoice("tirade", true);
        b.addChoice("zephyr", false);
        b.addChoice("winsome", false);

        level5.addQuestion(b);
        
        //level6 question(java)
        QuestionBank level6 = questionBanks[5];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("(In java)If A=10, then after B=++A, the value of B is _______.");
        b.addChoice("10", false);
        b.addChoice("11", true);
        b.addChoice("12", false);
        b.addChoice("13", false);

        level6.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("Which of the following is an invalid variable declaration in Java");
        b.addChoice("int NumberOfStudents =", false);
        b.addChoice("double Salary =", false);
        b.addChoice("String NAME =", false);
        b.addChoice("Char CivilStatus =", true);

        level6.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("(Java)Using the declaration below, what will be the final element of the array?\n int [ ] grades = new int[35];");
        b.addChoice("grades[0]", false);
        b.addChoice("grades[34]", true);
        b.addChoice("grades[35]", false);
        b.addChoice("Not possible to tell", false);

        level6.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("(In Java)It defines the common variables and methods of a set of objects.");
        b.addChoice("Objects", false);
        b.addChoice("Method", false);
        b.addChoice("Function", false);
        b.addChoice("Class", true);

        level6.addQuestion(b);
        
        //level7 question(phones)
        QuestionBank level7 = questionBanks[6];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("Which was the first iPhone with the fingerprint reader");
        b.addChoice("iPhone 1", false);
        b.addChoice("iPhone 6", false);
        b.addChoice("iPhone 5c", false);
        b.addChoice("iPhone 5s", true);

        level7.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("The iPhone comes from which company?");
        b.addChoice("Apples", false);
        b.addChoice("Apple", true);
        b.addChoice("Samsung", false);
        b.addChoice("Sony", false);

        level7.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("Which was the first apple product ever made?");
        b.addChoice("The Apple-1", true);
        b.addChoice("The iPhone 1", false);
        b.addChoice("A Lamp", false);
        b.addChoice("None of the above", false);

        level7.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("Who were the CEO's of Apple");
        b.addChoice("Steve Jobs and Steve Wozniak", true);
        b.addChoice("Bill Gates and Steve Jobs", false);
        b.addChoice("Steve Wozniak and Bill Gates", false);
        b.addChoice("Steve Jobs, Bill Gates, and Steve Wozniak", false);

        level7.addQuestion(b);
        
        //level8 question(colors)
        QuestionBank level8 = questionBanks[7];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("What was the original color of The Statue of Liberty");
        b.addChoice("Aqua", false);
        b.addChoice("Brown", true);
        b.addChoice("Green", false);
        b.addChoice("Silver", false);

        level8.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("What is the color of a greenhouse");
        b.addChoice("green", false);
        b.addChoice("transparent", true);
        b.addChoice("yellow", false);
        b.addChoice("any color", false);

        level8.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("What color(s) did the first Golden State Warriors logo have?");
        b.addChoice("blue and yellow", false);
        b.addChoice("black and yellow", false);
        b.addChoice("orange and blue", true);
        b.addChoice("None of the above", false);

        level8.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("The Canadian flag has most of which color?");
        b.addChoice("black", false);
        b.addChoice("white", false);
        b.addChoice("blue", false);
        b.addChoice("red", true);

        level8.addQuestion(b);
        
        //level9 question(TV/Movies)
        QuestionBank level9 = questionBanks[8];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("Which TV show first started being filmed in 1999 and has a main character that looks square?");
        b.addChoice("Spongebob Squarepants", true);
        b.addChoice("Jonny Test", false);
        b.addChoice("Squidward Tentacles", false);
        b.addChoice("The Hoopers", false);

        level9.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("Which actor was famous in the 1900s and had a mustache with a cane?");
        b.addChoice("Charlie Chaplin", true);
        b.addChoice("Leonardo DiCaprio", false);
        b.addChoice("Brad Pitt", false);
        b.addChoice("Will Smith", false);

        level9.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("Which movie has a main character as an elephant with big ears?");
        b.addChoice("Gumbo", false);
        b.addChoice("Dumbo", true);
        b.addChoice("Zootopia", false);
        b.addChoice("None of the above", false);

        level9.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("Which movie has a plot of going to the moon?");
        b.addChoice("Apollo 13", true);
        b.addChoice("Dunkirk", false);
        b.addChoice("Spiderman", false);
        b.addChoice("Wish Upon", false);

        level9.addQuestion(b);
        
        //level10 question(Famous People)
        QuestionBank level10 = questionBanks[9];
        
        //Q1
        b = new ChoiceQuestion();
        b.setText("Which of these was a philosopher during the Renaissance period?");
        b.addChoice("Jean-Paul Sarte", false);
        b.addChoice("Charles Darwin", false);
        b.addChoice("Karl Popper", false);
        b.addChoice("Erasmus", true);

        level10.addQuestion(b);
        
        
        //Q2
        b = new ChoiceQuestion();
        b.setText("What was American abolitionist Harriet Tubman’s original name?");
        b.addChoice("Arainta Ross", true);
        b.addChoice("Harriet Jones", false);
        b.addChoice("Chloe Abernathy", false);
        b.addChoice("Anges Tubman", false);

        level10.addQuestion(b);
        
        //Q3
        b = new ChoiceQuestion();
        b.setText("Who was the 15th president?");
        b.addChoice("John Adams", false);
        b.addChoice("Abraham Lincoln", false);
        b.addChoice("James Buchanan", true);
        b.addChoice("None of the above", false);

        level10.addQuestion(b);
        
        //Q4
        b = new ChoiceQuestion();
        b.setText("Who is the prime minister of Canada");
        b.addChoice("John Turner", false);
        b.addChoice("Paul Martin", false);
        b.addChoice("John Abbot", false);
        b.addChoice("Justin Trudeau", true);

        level10.addQuestion(b);
    }
    
    public boolean playLevel()
    {
        QuestionBank qb = questionBanks[level];
        Question q = qb.getQuestion();
        
        q.display();
        newQuestion.play();
        int input1 = q.getUserAnswer(kboard);
        
        // lifeline is option 0. Only allowed if not already used
        if (input1 == 0 && lifelineUsed == false)
        {
            lifelineUsed = true;
            q.applyLifeLine();
            System.out.printf("\n\n");
            newQuestion.play();
            q.display();
            input1 = q.getUserAnswer(kboard);
        }
        
        if (q.checkAnswer(input1))
        {
            answerCorrect.play();
            wonLevel = true;
            gotoNextLevel();
            System.out.printf("\n\nYou're correct. Your current winnings are : $%d\n", getPrizeMoney());
        }
        else
        {
            answerWrong.play();
            wonLevel = false;
            System.out.println("\n\nYou lost, the right answer is " + q.getAnswer());
        }
        return wonLevel;
    }
    
    public boolean play()
    {
        boolean continuePlaying = true;
        boolean won = false;
        while (continuePlaying) 
        {
            System.out.printf("\fYou are playing level: %-15d  Your winnings are: $%-15d  Used 50:50: %b\n\n", level+1, getPrizeMoney(), lifelineUsed);
            won = playLevel();
            if(getLevel() == MAX_LEVEL)
            {
                continuePlaying = false;
            }
            else if (won) 
            {
                System.out.printf("Do you want to (C)ontinue or (W)alk out with your balance of $%d?  ", getPrizeMoney());
                String answer = kboard.next();
                if(answer.equals("W") || answer.equals("w"))
                {
                    continuePlaying = false;
                }
            }
            else
            {
                continuePlaying = false;
            }
        }
        if (!won) 
        {
            System.out.printf("\n\nYou would've had $%d, but you leave with $%d\n", getMoneyForLevel(), getPrizeMoney());
        }
        else
        {
            System.out.printf("\f\n\nCongraulations! Your final winnings are $%d\n", getPrizeMoney());
        }
        finishGame.play();
        System.out.println("\n\nYou may now leave the game.");
        return won;
    }

    public static void main(String[] args)
    {
        Game g = new Game();
        g.loadQuestions();
        boolean won = g.play();
    }
}
