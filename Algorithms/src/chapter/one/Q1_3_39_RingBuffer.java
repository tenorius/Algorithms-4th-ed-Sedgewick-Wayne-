package chapter.one;

import edu.princeton.cs.algs4.In;

public class Q1_3_39_RingBuffer<Item> {

	int head = 0;
	int tail = 0;
	int cap;
	int size = 0;
	Item[] buffer;

	public Q1_3_39_RingBuffer(int cap) {
		this.cap = cap;
		buffer = (Item[]) new Object[cap];
	}

	public void enqueue(Item item) throws Exception {
		if (size == cap) {

			throw new Exception("Buffer cheio");

		} else if (head != cap - 1) {

			buffer[++head] = item;

		} else {

			head = 0;
			buffer[head] = item;

		}
		size++;

	}

	public Item dequeue() throws Exception {

		if (size == 0) {
			throw new Exception("buffer Vazio");
		} else if (tail != cap - 1) {

			size--;
			return buffer[tail++];

		} else {
			Item retorno = buffer[tail];
			tail = 0;
			size--;
			return retorno;
		}

	}

	public static void main(String[] args) {

		Q1_3_39_RingBuffer<Integer> teste = new Q1_3_39_RingBuffer<Integer>(5);

		try {
			teste.enqueue(1);
			teste.enqueue(2);
			teste.enqueue(3);
			teste.enqueue(4);
			teste.enqueue(5);

			teste.dequeue();
			teste.enqueue(5);

			teste.dequeue();
			teste.enqueue(5);

			teste.dequeue();
			teste.enqueue(5);

			teste.dequeue();
			teste.enqueue(5);

			teste.dequeue();

			System.out.println(teste.size);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
