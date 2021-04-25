package Exceptions;

import java.time.LocalDateTime;

public class DirectMessage extends Message {
    private User from;
    private User to;

    public DirectMessage(String text, User from,User to) throws MessageToSelfException {
        super(text);
        if (from.getName().equals(to.getName())) {
            throw new MessageToSelfException("You cannot send Messages to your self");
        }
        this.from = from;
        this.to = to;

    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "DirectMessage{" + "from=" + from + ", to=" + to +  ", text=" + super.toString() +'}';
    }
}
