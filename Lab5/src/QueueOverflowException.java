public class QueueOverflowException extends QueueException {
    QueueOverflowException(){
        super("Failed to add to a full queue!");
    }
}
