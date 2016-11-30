import java.util.Random;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class Generator {
   private static final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
         'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
         'x', 'y', 'z'};
   private static final char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7',
         '8', '9'};
   private static final char[] symbols = {'~', '`', '!', '@', '#', '$', '%', '^',
         '&', '*', '(', ')', '-', '_', '+', '=', '|', '\\', ']', '}', '{', '[', '\'',
         '\"', ':', ';', '?', '/', '>', '.', '<', ','};
   private static final char[][] characterSet = {letters, numbers, symbols};

   private static final int DEFAULT_LENGTH = 10;
   private static final int LETTERS = 0;
   private static final int UPPERCASE = 1;

   public static void main(String[] args) throws NoSuchAlgorithmException {
      Random random = SecureRandom.getInstanceStrong();
      int length = 0;
      StringBuilder builder = new StringBuilder(length);
      int randomSetChoice = 0, randomCharChoice = 0;
      char currentChar = ' ';

      length = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_LENGTH;

      for (int index = 0; index < length; index++) {
         randomSetChoice = random.nextInt(characterSet.length);
         randomCharChoice = random.nextInt(characterSet[randomSetChoice].length);
         currentChar = characterSet[randomSetChoice][randomCharChoice];

         currentChar = randomSetChoice == LETTERS && random.nextInt(2)
               == UPPERCASE ? Character.toUpperCase(currentChar) : currentChar;

         builder.append(currentChar);
      }

      System.out.println(builder.toString());
   }
}
