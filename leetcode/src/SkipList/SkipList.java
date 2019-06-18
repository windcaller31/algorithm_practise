package SkipList;

import java.util.Random;

public class SkipList {
	private int level = 0;
	private SkipListNode top = null;

	// 创建一个节点
	private SkipListNode createNode(int value) {
		SkipListNode node = new SkipListNode();
		node.setValue(value);
		return node;
	}

	// 随机数产生k，k层以下的索引层都需要插入
	public int randomLevel() {
		int k = 1;
		while (new Random().nextInt() % 2 == 0) {
			k++;
		}
		return k > level ? level : k;
	}

	// 构造函数
	public SkipList(int level) {
		this.level = level;
		SkipListNode skipListNode = null;
		//最左上角节点
		SkipListNode temp = top;
		//下一层两个节点
		SkipListNode tempDown = null;
		SkipListNode tempNextDown = null;
		int tempLevel = level;
		// 每层构造两个节点。产生k层
		while (tempLevel != 0) {
			tempLevel--;
			skipListNode = createNode(Integer.MIN_VALUE);
			temp = skipListNode;
			skipListNode = createNode(Integer.MAX_VALUE);
			temp.setNext(skipListNode);
			temp.setDownNext(tempDown);
			temp.getNext().setDownNext(tempNextDown);
			tempDown = temp;
			tempNextDown = tempDown.getNext();
		}
		top = temp;
	}

	// 插入一个节点
	public void insert(int value) {
		SkipListNode skipListNode = null;
		int k = randomLevel();
		SkipListNode temp = top;
		// tempLevel一开始为总层数
		int tempLevel = level;
		SkipListNode tempNode = null;
		// 当在第n行插入后，在第n - 1行插入时需要将第n行backTempNode的DownNext域指向第n - 1的域
		// 找到k层的头结点
		SkipListNode backTempNode = null;
		int flag = 1;
		// 减到k那一层确定tempNode的位置
		while (tempLevel != k) {
			tempLevel--;
			temp = temp.getDownNext();
		}
		// tempLevel回到k的上一层
		tempLevel++;
		tempNode = temp;
		// 小于k层都需要插入
		while (tempLevel != 0) {
			tempLevel--;
			// 在第k层寻找合适位置,tempNode移动到合适的位置准备 tempNode.next = node
			while (tempNode.getNext().getValue() < value) {
				tempNode = tempNode.getNext();
			}
			skipListNode = createNode(value);
			// 如果不是顶层(第一次插入的时候flag 是1) //如果是顶层 backTempNode 为空
			// backTempNode的作用是使要插入k个层的节点skipListNode由上至下每一层依次指向 k->k-1->k-2.....
			if (flag != 1) {
				backTempNode.setDownNext(skipListNode);
			}
			backTempNode = skipListNode;
			// 插入skipListNode到这一层
			skipListNode.setNext(tempNode.getNext());
			tempNode.setNext(skipListNode);
			flag = 0;
			tempNode = tempNode.getDownNext();
		}
	}

	// 查找节点
	public SkipListNode find(int value) {
		SkipListNode node = top;
		while (true) {
			// 找到前一个节点
			while (node.getNext().getValue() < value) {
				node = node.getNext();
			}
			if (node.getDownNext() == null) {
				return node.getNext();
			}
			node = node.getDownNext();
		}
	}

	// 删除节点
	public boolean delete(int value) {
		int tempLevel = level;
		SkipListNode skipListNode = top;
		SkipListNode temp = skipListNode;
		boolean flag = false;
		//一层一层的删除
		while (tempLevel != 0) {
			tempLevel--;
			//找到前一个节点删除之
			while (temp.getNext().getValue() < value) {
				temp = temp.getNext();
			}
			if (temp.getNext().getValue() == value) {
				temp.setNext(temp.getNext().getNext());
				flag = true;
			}
			//移动至下一层
			temp = skipListNode.getDownNext();
		}
		return flag;
	}
}
