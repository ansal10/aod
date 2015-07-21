package models.posts.Enum;

/**
 * Created by amd on 7/21/15.
 */
public enum CommentType {

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
