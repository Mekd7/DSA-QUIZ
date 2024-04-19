package quiz;
    public class CircularQueue {
        private int capacity;
        private int[] queue;
        private int front;
        private int rear;

        public CircularQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = -1;
            this.rear = -1;
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is full!");
            } else {
                if (isEmpty()) {
                    front = 0;
                }
                rear = (rear + 1) % capacity;
                queue[rear] = item;
                System.out.println("Enqueued item: " + item);
            }
        }

        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
            } else {
                int item = queue[front];
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } else {
                    front = (front + 1) % capacity;
                }
                System.out.println("Dequeued item: " + item);
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
            } else {
                System.out.print("Queue: ");
                int i = front;
                while (i != rear) {
                    System.out.print(queue[i] + " ");
                    i = (i + 1) % capacity;
                }
                System.out.println(queue[rear]);
            }
        }

        public static void main(String[] args) {
            CircularQueue queue = new CircularQueue(5);
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.display();
            queue.dequeue();
            queue.display();
        }
    }

