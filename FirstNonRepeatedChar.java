import java.util.LinkedHashMap;
import java.util.Map;

class CharInfo
{
   int charCount = 0;
   int charPosition = 0;

   public int getCount()
   {
      return charCount;
   }

   public int getPosition()
   {
      return charPosition;
   }

   public void incrementCount()
   {
      charCount = charCount + 1;
   }

   public void setPosition(int charPosition)
   {
      this.charPosition = charPosition;
   }

}

public class FirstNonRepeatedChar
{
   public static void main(String[] args)
   {

      String str = "Tools for Isolated Testing";
      Map<String, CharInfo> charList = new LinkedHashMap<String, CharInfo>();

      char[] charArray = str.toLowerCase().toCharArray();

      for (int i = 0; i < charArray.length; i++) {
         String key = String.valueOf(charArray[i]);
         if (charList.get(key) != null) {
            CharInfo kvalue = charList.get(key);
            kvalue.incrementCount();
         } else {
            CharInfo value = new CharInfo();
            value.setPosition(i);
            value.incrementCount();
            charList.put(String.valueOf(charArray[i]), value);
         }
      }

      for (Map.Entry<String, CharInfo> entry : charList.entrySet()) {
         String key = entry.getKey();
         CharInfo value = entry.getValue();

         if (value.charCount == 1) {
            System.out.println("char: " + charArray[value.getPosition()]
                     + " position: " + value.getPosition());
         }
      }
   }
}