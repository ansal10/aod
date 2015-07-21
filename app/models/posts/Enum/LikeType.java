package models.posts.Enum;

/**
 * Created by amd on 7/21/15.
 */
public enum LikeType {


    LIKE(1),
    DISLIKE(2);

    public long getEventValue() {
        return eventValue;
    }

    LikeType(long eventType) {
        eventValue = eventType;
    }

    private final long eventValue;
}
