public class VNA02 implements Runnable {
  private static volatile int testVal; 
//main method creates two threads and calls run function with both. 
public static void main(String [] args)
{
Thread thread1 = new Thread(new VNA02());
Thread thread2 = new Thread(new VNA02());

testVal = 50; 
System.out.println(testVal);

thread1.start();
thread2.start(); 

try {
    thread1.join();
    thread2.join();
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
}
/** 
* incrementing using multithreading
* prints value of testVal once thread exists for loop
*/
public void run()
{
    for (int i = 0; i < 100; i++)
    {
        testVal = increment(testVal);
    }
      System.out.println(testVal); 
}
/**
* increments argument using prefix operator value and returns 
* synchronized to avoid issues with multithreading doing compound operation at same time
* @param val - integer value to be incremented
* @return incremented val 
*/
public static synchronized int increment(int val)
{
    return ++val;
}
}
