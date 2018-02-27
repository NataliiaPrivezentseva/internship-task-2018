package pl.codewise.internships;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MessageQueueTest {

    @Test
    public void shouldAddMessage(){
        Message message = new Message("Hello", 0);

        MessageReceiver messageReceiver = new MessageReceiver();
        messageReceiver.add(message);

        LinkedList<Message> expectedMessageQueue = new LinkedList<Message>();
        expectedMessageQueue.add(message);
        messageReceiver.add(message);
        //now I had problem - I add the same msg twice
        assertEquals(expectedMessageQueue, messageReceiver.snapshot().getMessageQueue());
    }
}