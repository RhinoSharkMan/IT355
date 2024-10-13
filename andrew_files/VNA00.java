package andrew_files;

public class VNA00 implements Runnable {
private static volatile int value = 0; 
//main methods creates two threads, starting them calls run function
public static void main(String [] args)
{
Thread thread1 = new Thread(new VNA00());
Thread thread2 = new Thread(new VNA00());

thread1.start();
thread2.start();
}

//run function for threads, first thread gets interrupted after call, 2nd thread continues
//by adding 10 to value again and printing
@Override
public void run()
{
  value = addition(value,10);
  System.out.println(value);  
 Thread.currentThread().interrupt();
}

/**
* adds two integers together
* @param val - integer value used to represent value variable
* @param add - integer value used to represent what is being added to value
* @return integer value resulting from addition of val and add.   
*/  
public int addition(int val, int add)
{
   return val + add; 
}
}
