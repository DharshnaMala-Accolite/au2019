package com.accolite.au;

import java.util.Scanner;

public class HashMapCustom<K, V> {
	Entry<K, V>[] bucket;
	int capacity;
	Entry<K, V> head;
	Entry<K, V> tail;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;
		Entry<K, V> before;
		Entry<K, V> after;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public HashMapCustom(int cap) {
		capacity=cap;
		bucket = new Entry[capacity];
	}

	public void put(K key, V value) {
		if (key == null) {
			return;
		}
		boolean replace = false;
		int hash = hash(key);
		Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
		Entry<K, V> curr = bucket[hash];

		if (curr == null) {
			bucket[hash] = newEntry;
		} else {
			Entry<K, V> prev = null;
			while (curr != null) {
				if (curr.key.equals(key)) {
					replace = true;
					curr.value = value;
					break;
				}
				prev = curr;
				curr = curr.next;
			}
			if (prev != null)
				prev.next = newEntry;
		}

		if (replace == false)
			insertInList(newEntry);
	}

	private void insertInList(Entry<K, V> newEntry) {
		if (head == null) {
			head = newEntry;
			tail = newEntry;
		} else {
			tail.after = newEntry;
			newEntry.before = tail;
			tail = newEntry;
		}
	}

	public V get(K key) {
		int hash = hash(key);
		Entry<K, V> curr = bucket[hash];
		while (curr != null) {
			if (curr.key.equals(key)) {
				return curr.value;
			}
			curr = curr.next;
		}
		return null;
	}

	public void display() {
		Entry<K, V> curr = head;
		while (curr != null) {
			System.out.println("key : val ---> " + curr.key + " : " + curr.value);
			curr = curr.after;
		}
	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public void remove(K key) {
		int r = -1;
		int hash = hash(key);
		Entry<K, V> curr = bucket[hash];
		if (curr == null) {
			System.out.println("entry not found\n");
			return;
		}
		Entry<K, V> p = null;
		Entry<K, V> n;
		while (curr != null) {
			n = curr.next;
			if (curr.key.equals(key)) {
				r = 0;
				if (p == null) {
					bucket[hash] = bucket[hash].next;
				} else {
					p.next = n;
				}
				adjustList(curr);
				break;
			}
			p = curr;
			curr = n;
		}
		if (r == -1) {
			System.out.println("Value not found!\n");
		}
	}

	private void adjustList(Entry<K, V> curr) {
		if (curr == head) {
			head = head.after;
			if (head == null) {
				tail = null;
			}
		} else if (curr == tail) {
			tail = tail.before;
			tail.after = null;
		} else {
			curr.before.after = curr.after;
			curr.after.before = curr.before;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter capacity of the HashMap");
		int cap = sc.nextInt();
		HashMapCustom<Integer, Integer> lhm = new HashMapCustom<Integer, Integer>(cap);
		System.out.println("Following can be done using a LinkedHashMap,");
		System.out.println("1)Put\n2)Delete\n3)Get\n4)Display");
		int option = sc.nextInt();
		while (option != 0) {
			switch (option) {
			case 1:
				System.out.println("Enter key and value to put:");
				int key = sc.nextInt();
				int val = sc.nextInt();
				lhm.put(key, val);
				break;
			case 2:
				System.out.println("Enter key to remove:");
				key = sc.nextInt();
				lhm.remove(key);
				break;
			case 3:
				System.out.println("Get value coresponding to key:");
				key = sc.nextInt();
				System.out.println(lhm.get(key));
				break;
			case 4:
				System.out.println("LinkedHashMap:");
				lhm.display();
				break;
			default:
				System.out.println("Wrong Input:Choose the correct menu");
			}
			System.out.println("What do you want to do?");
			option = sc.nextInt();
		}
	}
}
