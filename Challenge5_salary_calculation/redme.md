Thread Management in Java
Java provides built-in support for multithreading through the java.util.concurrent package. This package includes several classes and interfaces that can be used to manage threads in a Java application.

In this guide, we will discuss two different methods for thread management in Java:

Method 1: Extending the Thread Class
One way to create a new thread in Java is to extend the Thread class. To do this, you must override the run() method, which is where the code for your new thread will be executed. 

Method 2: Implementing the Runnable Interface
Another way to create a new thread in Java is to implement the Runnable interface. To do this, you must implement the run() method, which is where the code for your new thread will be executed.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

What is this program?
This program is a simple example of using threads in Java to calculate the final salary of an employee, including allowances and EPF (Employees Provident Fund) contributions.
It demonstrates how multiple threads can be used to perform different calculations concurrently and how the results can be combined to obtain the final salary.


Execution :
1. This program calculates the final salary of an employee based on their per day payment and number of days worked.
2. The program uses two additional threads, AllowancesThread and EPFThread, to calculate the allowances and EPF (Employee Provident Fund) respectively.
3. The MainThread class creates and starts the AllowancesThread and EPFThread, and then waits for them to complete using the join() method.
4. Once both threads have completed, the MainThread calculates the final salary by adding the basic salary, allowances and EPF.
5. The results are then printed out showing the final salary, allowances, EPF, and employer contribution.
