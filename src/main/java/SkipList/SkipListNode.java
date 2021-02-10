package SkipList;

public class SkipListNode implements Comparable{

	private int value;
	//同层下一个节点
	private SkipListNode next = null;
	//下一层节点
	private SkipListNode downNext = null;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.printf("123");
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SkipListNode getNext() {
		return next;
	}

	public void setNext(SkipListNode next) {
		this.next = next;
	}

	public SkipListNode getDownNext() {
		return downNext;
	}

	public void setDownNext(SkipListNode downNext) {
		this.downNext = downNext;
	}

	@Override
    public int compareTo(Object o) {
        return this.value > ((SkipListNode)o).value ? 1 : -1;
    }
}
