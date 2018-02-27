package pl.codewise.internships;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class MessageReceiver implements MessageQueue {

    public void add(Message message) {
        if (message.getTime().plusMinutes(5).isAfter(LocalDateTime.now())) {
            Snapshot.addToQueue(message);
        }
    }

    public Snapshot snapshot() {
        LinkedList<Message> currentMessageQueue = Snapshot.getMessageQueue();
        Snapshot snapshot;
        if (currentMessageQueue.size() > 100) {
            LinkedList shortMessageQueue = new LinkedList();
            for (int i = currentMessageQueue.size() - 100; i < currentMessageQueue.size(); i++) {
                shortMessageQueue.add(currentMessageQueue.get(i));
            }
            snapshot = new Snapshot(shortMessageQueue);
        } else {
            snapshot = new Snapshot(currentMessageQueue);
        }
        return snapshot;
    }

    public long numberOfErrorMessages() {
        return snapshot().getMessageQueue().stream()
                .filter(m -> m.getErrorCode() == -1)
                .count();
    }
}
