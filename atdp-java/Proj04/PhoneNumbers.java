
public class PhoneNumbers
{
   /**
      Cleans a phone number.
      @param phoneNumber a phone number that should contain ten digits and possibly other characters
      @return the phone number in the form (###) ###-#### or the string "Error" if phoneNumber
      does not have ten digits
   */
   public String cleanNumber(String phoneNumber)
   {   
      int numOfNum = 0;
      String numberLetter = "";
      for (int i = 0; i < phoneNumber.length(); i++)
      {
         char ch = phoneNumber.charAt(i);
         if (Character.isDigit(ch))
         {
            numberLetter += ch;
            numOfNum++;
         }
      
        }
        
      if(numOfNum == 10){
     
      String firstThree = numberLetter.substring(0, 3);
      String nextThree = numberLetter.substring(3, 3);
      String lastFour = numberLetter.substring(7);
      
      return "(" + firstThree + ") " + nextThree + "-" + lastFour;
    }
    else{
        return "Error";
         
      }
    }
   }   
