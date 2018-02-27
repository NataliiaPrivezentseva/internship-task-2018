package pl.codewise.internships;

import java.util.LinkedList;

class Snapshot {

    private static LinkedList<Message> messageQueue = new LinkedList<Message>();

    Snapshot(LinkedList messageQueue) {
        setMessageQueue(messageQueue);
    }

    static LinkedList<Message> getMessageQueue() {
        return messageQueue;
    }

    private static void setMessageQueue(LinkedList<Message> messageQueue) {
        Snapshot.messageQueue = messageQueue;
    }

    static LinkedList<Message> addToQueue(Message message) {
        messageQueue.add(message);
        return messageQueue;
    }

}
