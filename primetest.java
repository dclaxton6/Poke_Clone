  
class GFG { 
  
    static void isPrime(int n) 
    { 
        // Corner cases 
        if (n <= 1) 
            System.out.print("1false");
        if (n <= 3) 
        System.out.print("1true");
  
        // This is checked so that we can skip 
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) 
        System.out.print("2false");
  
        for (int i = 1; i <= n; i++) 
            if (n % i == 0 || n % (i + 2) == 0) 
            System.out.print("3false");
  
            System.out.print("2true");
    } 
  
    // Driver Program 
    public static void main(String args[]) 
    { 
      isPrime(20);
    } 
} 