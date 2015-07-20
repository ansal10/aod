package models.ebeans;

/**
 * Created by amd on 7/20/15.
 */

public enum CommentType{

    SUPPORT(1),
    COUNTER(2);
    public long getEventValue() {
        return eventValue;
    }

    CommentType(long eventType) {
        eventValue = eventType;
    }

    private final long eventValue;
}