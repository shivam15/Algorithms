/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DesignPatterns;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shivam
 */
public class FutureApi {

    public static void main(String args[]) {
        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            Callable call = new CallableTest();
            randomNumberTasks[i] = new FutureTask(call);
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(randomNumberTasks[i].get());
            } catch (InterruptedException ex) {
                Logger.getLogger(FutureApi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(FutureApi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);
        Thread.sleep(randomNumber * 1000);
        return randomNumber;
    }

}
