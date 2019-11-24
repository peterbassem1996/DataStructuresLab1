public class QueueUnderflowException extends QueueException{
    QueueUnderflowException(){
        super("Filed to remove form an empty queue!");
    }
}
