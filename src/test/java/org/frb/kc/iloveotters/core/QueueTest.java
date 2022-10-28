package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    @Test
    public void testQueue() {
        Queue<Person> queue = new LinkedList<>();
        queue.offer(new Person("Gretchen", "Jones"));
        queue.offer(new Person("Bindu", "Kandanat"));
        queue.offer(new Person("Mehar", "Trikona"));
        System.out.println(queue);
        Person nextPerson = queue.poll();
        System.out.println(nextPerson);
        System.out.println(queue);
        queue.offer(new Person("Angela", "Eason"));
        System.out.println(queue);
    }
}
