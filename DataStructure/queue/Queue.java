package queue;

public interface Queue {
    public void initQueue();
    public void destoryQueue();
    public void clearQueue();
    public boolean queueEmpty();
    public Object getHead();
    public void addQueue(Object data);
    public Object deleteQueue();
    public int queueLength();
}
