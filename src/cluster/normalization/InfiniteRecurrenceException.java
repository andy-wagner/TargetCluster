package cluster.normalization;

/**
 * @author EuiJin.Ham
 * @version 1.0.0
 * @description An Exception which is thrown when the synonyms or categories are in infinite recurrence
 */
public class InfiniteRecurrenceException extends Exception{
    /**
     * A Default Message
     */
    public static final String DEFAULT_MSG = "This state would be ran infinitely.";

    /**
     * A Default Constructor
     */
    public InfiniteRecurrenceException(){
        this(DEFAULT_MSG);
    }

    /**
     * Specific Constructor
     * @param msg A Custom Message
     */
    public InfiniteRecurrenceException(String msg){
        super(msg);
    }
}
