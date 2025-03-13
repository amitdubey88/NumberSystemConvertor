package NumberSystemConvertor;

public class AConvertor {
   String DecBin(long decm) {
      long x = 0L;
      int[] a = new int[50];
      long i = decm;

      int j;
      for(j = 0; i > 0L; ++j) {
         a[j] = (int)i % 2;
         ++x;
         i /= 2L;
      }

      for(j = 0; (long)j <= x / 2L; ++j) {
         for(j = 0; (long)j < x / 2L; ++j) {
            long t = (long)a[j];
            a[j] = a[(int)x - j - 1];
            a[(int)x - j - 1] = (int)t;
         }
      }

      String p = "";

      for(j = 0; (long)j < x; ++j) {
         p = p + a[j];
      }

      return p;
   }

   String BinOct(long bin) {
      String p = "";
      double s = 0.0D;
      int[] a = new int[50];
      long i = bin;

      int j;
      for(j = 0; i > 0L; ++j) {
         s += Math.pow(2.0D, (double)j) * (double)(i % 10L);
         i /= 10L;
      }

      if ((int)s >= 8) {
         i = (long)((int)s);

         for(j = 0; i > 0L; ++j) {
            a[j] = (int)i % 8;
            i /= 8L;
         }

         for(i = (long)(j - 1); i >= 0L; --i) {
            p = p + Integer.toString(a[(int)i]);
         }
      } else {
         p = Integer.toString((int)s);
      }

      return p;
   }

   String BinDec(long bin) {
      double s = 0.0D;
      long i = bin;

      for(long j = 0L; i > 0L; ++j) {
         s += Math.pow(2.0D, (double)j) * (double)(i % 10L);
         i /= 10L;
      }

      return String.valueOf((int)s);
   }

   String OctDec(long Oct) {
      long s = 0L;
      long i = Oct;

      for(long j = 0L; i > 0L; ++j) {
         s += (long)((int)Math.pow(8.0D, (double)j)) * (i % 10L);
         i /= 10L;
      }

      return String.valueOf((int)s);
   }

   String OctBin(long Oct) {
      long p = Long.parseLong(this.OctDec(Oct));
      return String.valueOf(this.DecBin(p));
   }

   String DecOct(long Dec) {
      return Long.toOctalString(Dec);
   }

   String DecHexa(long dec) {
      return Long.toHexString(dec).toUpperCase();
   }

   String HexaDec(String s) {
      long[] a = new long[10];
      long c = 0L;
      String p = "";

      long i;
      for(i = 0L; i < (long)s.length(); ++i) {
         a[(int)i] = (long)Integer.parseInt(String.valueOf(s.charAt((int)i)), 16);
      }

      i = 0L;

      for(long j = (long)(s.length() - 1); i < (long)s.length(); --j) {
         c += (long)((int)Math.pow(16.0D, (double)i)) * a[(int)j];
         ++i;
      }

      return Long.toString(c);
   }

   String HexaOct(String s) {
      long de = Long.parseLong(this.HexaDec(s));
      return this.DecOct(de);
   }

   String HexaBin(String s) {
      long de = Long.parseLong(this.HexaDec(s));
      return this.DecBin(de);
   }

   String BinHexa(long bin) {
      long de = Long.parseLong(this.BinDec(bin));
      return this.DecHexa(de);
   }

   String OctHexa(long Oct) {
      Long de = Long.parseLong(this.OctDec(Oct));
      return this.DecHexa(de);
   }

   public static void main(String[] args) {
      AConvertor a = new AConvertor();
      System.out.println("Decimal to Binary=" + a.DecBin(532L));
      System.out.println("Binary to Octal=" + a.BinOct(1000L));
      System.out.println("Binary to Decimal=" + a.BinDec(101L));
      System.out.println("Octal to Decimal=" + a.OctDec(10L));
      System.out.println("Octal to Bin=" + a.OctBin(10L));
      System.out.println("Decimal to Octal=" + a.DecOct(8L));
      System.out.println("Decimal to Hexa=" + a.DecHexa(123456789L));
      System.out.println("Hexa to Decimal=" + a.HexaDec("3E9"));
      System.out.println("Hexa to Octa=" + a.HexaOct("A"));
      System.out.println("Hexa to Bin=" + a.HexaBin("2"));
      System.out.println("Bin to Hexa=" + a.BinHexa(10L));
      System.out.println("Octal to Hexa=" + a.OctHexa(12L));
   }
}
