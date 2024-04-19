package quiz;
import java.util.Stack;

public class LinearQueueUsingStacks {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public LinearQueueUsingStacks() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public void enqueue(int item) {
        enqueueStack.push(item);
        System.out.println("Enqueued item: " + item);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            if (dequeueStack.isEmpty()) {
                while (!enqueueStack.isEmpty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
            }
            int item = dequeueStack.pop();
            System.out.println("Dequeued item: " + item);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue: ");
            if (!dequeueStack.isEmpty()) {
                for (int i = dequeueStack.size() - 1; i >= 0; i--) {
                    System.out.print(dequeueStack.get(i) + " ");
                }
            }
            for (Integer item : enqueueStack) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinearQueueUsingStacks queue = new LinearQueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        queue.dequeue();
        queue.display();
    }
}