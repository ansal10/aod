package models.posts.Enum;

/**
 * Created by amd on 7/29/15.
 */
public enum Category {


    POLITICS(1),
    GENERAL(2),
    COLLEGE(3),
    RELIGIOUS(4),
    SCHOOL(5),
    PRODUCT(6),
    COMPANY(7),
    MOVIES(8),
    BOOKS(9),
    EXAM(10);


    public long getEventValue() {
        return eventValue;
    }

    Category(long eventType) {
        eventValue = eventType;
    }

    private final long eventValue;
}
