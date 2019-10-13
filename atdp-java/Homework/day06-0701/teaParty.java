
/**
 * Write a description of class teaParty here.
 *
 * @author Anshul Patil
 * @version 1.0
 */
public class teaParty
{
public int teaParty(int tea, int candy) {
if (tea < 5 || candy < 5){ 

    return 0;
}

  if ((tea >= 2 * candy) || (candy >= 2 * tea)){

    return 2;
  }
  else{

    return 1;
  }
}
}
