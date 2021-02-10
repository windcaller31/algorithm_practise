package String;

import java.util.LinkedList;
import java.util.Queue;

public class AcNode {
	public char data;
	public AcNode[] children = new AcNode[26];// 字符集只包含a--z
	public boolean isEndingChar = false; // 结尾字符为true
	public int length = -1; // 当isEndingChar为true时候记录字符串长度
	public AcNode fail; // 失败指针

	public AcNode(char data) {
		this.data = data;
	}

	public AcNode root = new AcNode('\\');

	// 在trie树的基础上构建fail的节点
	public void buildFailurePointer() {
		Queue<AcNode> queue = new LinkedList<AcNode>();
		root.fail = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			AcNode p = queue.remove(); // 从队首取一个元素
			for (int i = 0; i < 26; i++) {
				// pc为p的child
				AcNode pc = p.children[i];
				if (pc == null) {// 这个child 没有 下一个child
					continue;
				}
				// 已经走到根节点，p的child的fail指针指向root
				if (pc == root) {
					pc.fail = root;
				} else {// p的child pc的fail指针不为root
						// q为p的fail指针
					AcNode q = p.fail;
					// 在p的fail节点中寻找
					while (q != null) {
						// 在q的fail节点中的同位置取得节点qc
						AcNode qc = q.children[pc.data - 'a'];
						// 如果qc等于p的child，那么pc的fail节点就是qc
						if (qc != null && qc.data == pc.data) {
							pc.fail = qc;
							break;
						}
						// 如果q的child qc不等于pc ，则q为q.fail继续寻找
						q = q.fail;
					}
					// 如果q为空，即执行了47行 ,那么pc.fail指向root
					if (q == null) {
						pc.fail = root;
					}
				}
				// pc作为p的节点已经寻找到fail节点，则pc入queue，继续qc的children
				queue.add(pc);
			}
		}
	}

	public void match(char[] text) {
		int n = text.length;
		AcNode p = root;
		//遍历模式串text
		for (int i = 0; i < n; ++i) {
			//找到字母位置
			int index = text[i] - 'a';
			//如果字母位置不存在同时也不是第一次遍历
			while (p.children[index] == null && p != root) {
				p = p.fail; //p移到fail指针，继续针对text[i]位置字母的比较
			}
			p = p.children[index];
			if(p==null) {
				//如果ac机中没有相应的匹配字符则从root从新开始匹配
				p = root;
			}
			AcNode temp = p;
			while(temp!=root) {//打印出可以匹配的模式串
				//匹配到了末尾
				if(temp.isEndingChar==true) {
					int pos = i-temp.length+1;
					System.out.print("匹配到了从"+pos+"到"+pos+temp.length);
				}
				//未到末尾，则temp->temp.fail
				temp =temp.fail;
			}
		}
	}
}
