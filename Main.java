package abstractsInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static  boolean running = true;
public static void main(String[] args) throws InterruptedException {

            Thread worker = new Thread(() -> {
                while (running) {
                    // Busy-wait loop (add a tiny pause so it doesn't hammer the CPU)
                    //Thread.onSpinWait(); // Java 9+ (safe to remove if on Java 8)
                }
                System.out.println("Thread stopped.");
            });
            worker.start();
            //Thread.sleep(10_000);
            running = false;
            //worker.join(); // wait for worker to finish so program exits cleanly
        }
    }
    





    //     //boolean running = true;
//     // volatile example
//     new Thread(() -> {
//         while (running) {
//         // Busy-wait loop
//     }
//     System.out.println("Thread stopped.");
// }).start();

// try {Thread.sleep(10000);} catch (InterruptedException e) {}
//     //running = false;

//     volatile boolean running = true;
// }}

















    //BrokenCounter counter = new BrokenCounter();
//     SynchronizedCounter counter = new SynchronizedCounter();
//     int threads = 8;
//    int repeats = 50_000;

//    List<Thread> list = new ArrayList<>();
//    for (int i = 0; i < threads; i++){
//        Thread t = new Thread(
//            () -> {
//                for (int r = 0; r < repeats; r++)counter.increment();
//            }
//        );
//        list.add(t);
//        t.start(); 
//    }
//    for (Thread t : list) t.join();
//    System.out.println("Expected: 400000" + "actual successful ops = " + counter.value());




// }}

// class BrokenCounter {
//     private int count = 0;
//     void increment() { count = count + 1; } 
//     int value() { return count; }
// }

// class SynchronizedCounter {
//     private int count = 0;
//     synchronized void increment() { count = count + 1; } 
//     synchronized int value() { return count; }
// }














//     Thread a = new Thread(new Worker("A", 20));
//     Thread b = new Thread(new Worker("B", 20));

//     a.start();
//     b.start();

// }}

// class Worker implements Runnable{
//     String name;
//     int times;

//     public Worker(String name, int times){
//         this.name = name;
//         this.times = times;
//     }

//     @Override
//     public void run(){
//             for (int i = 0; i < times; i++){
//                 System.out.println("worker" + name + i);
//                 mySleep(1000);
//             }
//     }
//    void mySleep(int ms){
//         try {
//             Thread.sleep(ms);
//         } catch (InterruptedException e){
//             System.out.println("[" + name + "] interrupted");
//         }
// }}


    // Thread deamonExample = new Thread(() -> {
    //     try {
    //         while (true){
    //             System.out.println("[Deamon] running in background...");
    //             Thread.sleep(10000000);
    //         }
    //     } catch (InterruptedException e){
    //         System.out.println("[Deamon] interrupted");
    //     }
    // });

    

    // // extedning thread with run - rearly used.
    // Thread thread1 = new Thread(){@Override public void run()
    //     {System.out.println("task form thread1");}};

    // Runnable task = () -> {
    //     System.out.println("task from thread2");
    // };
    // Thread thread2 = new Thread(task);


    // deamonExample.setDaemon(true);
    // deamonExample.start();
    // thread1.start();
    // thread2.start();

    // thread1.join(); // wait for thread1 to finish
    // thread2.join(); // wait for thread2 to finish



    // System.out.println("[Main] all threads finished");

    // }}


/*
Threads:
- A pathway of execution in a program.
- Resources are shared among threads.
- Same memory space.

Why use?
- Responsiveness - keeping UI's responsive, keep code flowing. 
- heavy I/O operations - file handling, network calls etc - throw into a background thread.
- Threads can wait. 

- parallelism - perform multiple tasks simultaneously.
- concurrency - virtually simultaneous tasks.

- problems:
    - race conditions: uncoordianated access to shared resources.
    - deadlocks: 2 or more threads waiting on each other indefinitely.
    - visability issues: changes made by one thread not visible to others immediately.


    Main thread:
        - Create new threads
        - Errors here take down all threads.
        - thread.sleep()

        new thread:
            - started with .start() not .run()
            - join() - wait for thread to finish.
            - setPriority() - hint to scheduler.
            - daemon threads - background tasks. 
            - synchronization - locks, synchronized blocks/methods, volatile keyword, atomics.
        
        




*/




<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>interfaces</groupId>
    <artifactId>java</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.2.224</version>
        </dependency>
    </dependencies>
</project>

CREATTAble:
    package abstractsInterfaces;
import java.sql.*;

public class CreateTable {
    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = ""; 
    public static void main(String[] args) throws Exception{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            Statement st = conn.createStatement();{
                String ddl = """
                        CREATE TABLE IF NOT EXISTS customers (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(100) NOT NULL,
                        city VARCHAR(100) NOT NULL 
                        )
                        """;
                        st.execute(ddl);
                        System.out.println("Table created successfully.");
            }
    }
}
}

WRTIE:

package abstractsInterfaces;

import java.sql.*;

public class write {
    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASS = ""; 

    public static void main(String[] args) throws Exception {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            createTable(conn);   

            long id1 = insertCustomer(conn, "John Doe", "New York");
            long id2 = insertCustomer(conn, "Jane Smith", "Los Angeles");
            long id3 = insertCustomer(conn, "Mike Johnson", "Chicago");
            
            System.out.println("Inserted customer IDs: " + id1 + ", " + id2 + ", " + id3);

            }}
    
    static void createTable(Connection conn) throws Exception{
            try (Statement st = conn.createStatement()){
                st.execute("""
                    CREATE TABLE IF NOT EXISTS customers (
                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    city VARCHAR(100) NOT NULL 
                    )
                    """);
                   

}    }

    static long insertCustomer(Connection conn, String name, String city) throws Exception {
        String sql = "INSERT INTO customers (name, city) VALUES (?, ?)";{
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, name);
            ps.setString(2, city);
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()) {
                    return rs.getLong(1);
                } else {
                    throw new SQLException("Inserting customer failed, no ID obtained.");
                }
            }
        }
    }
    }   
}

