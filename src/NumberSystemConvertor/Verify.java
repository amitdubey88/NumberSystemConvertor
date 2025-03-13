package NumberSystemConvertor;

public class Verify {
   boolean BinV(long bin) {
      long i;
      for(i = bin; i > 0L && (i % 10L == 1L || i % 10L == 0L); i /= 10L) {
      }

      return i == 0L;
   }

   boolean OctV(long oct) {
      long i;
      for(i = oct; i > 0L && i % 10L >= 0L && i % 10L <= 7L; i /= 10L) {
      }

      return i == 0L;
   }

   boolean DecV(long dec) {
      long i;
      for(i = dec; i > 0L && i % 10L >= 0L && i % 10L <= 9L; i /= 10L) {
      }

      return i == 0L;
   }

   boolean HexaV(String hex) {
      int s = hex.length();

      int i;
      for(i = 0; i < s; ++i) {
         char a = hex.charAt(i);
         if ((a < '0' || a > '9') && (a < 'A' || a > 'F')) {
            break;
         }
      }

      return i == s;
   }

   public static void main(String[] args) {
      Verify a = new Verify();
      System.out.println(a.BinV(101L));
      System.out.println(a.OctV(108L));
      System.out.println(a.HexaV("17F9"));
      System.out.println(a.DecV(101L));
   }
}
