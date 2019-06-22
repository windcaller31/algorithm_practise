package Hash;

import java.util.LinkedList;
import java.util.List;

public class MyHashTable {
	private static List<TableValue>[] data = new LinkedList[10];
	
	public static void main(String args[]) {
		put(1,21);
		put(11,11);
		put(21,21);
		put(22,222);
		put(32,322);
		put(6,666);
		System.out.println(get(1));
		System.out.println(get(2));
		System.out.println(get(11));
		System.out.println(get(21));
		System.out.println(get(22));
		System.out.println(get(32));
		printHash();
	}
	
	static class TableValue{
		public int key;
		public int value;
		public TableValue(int key,int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public static void printHash() {
		for(int i=0;i<data.length;i++) {
			List<TableValue> thisList = data[i];
			if(thisList!=null) {
				for(int j = 0;j<thisList.size();j++) {
					TableValue tv = thisList.get(j);
					System.out.println("realKey:"+i+"key:"+tv.key+"value:"+tv.value);
				}				
			}
		}
	}
	
	public static void put(int key ,int value) {
		int realKey = hash(key);
		LinkedList<TableValue> dataList = (LinkedList<TableValue>) data[realKey];
		if(dataList==null) {
			dataList = new LinkedList<TableValue>();
			data[realKey]=dataList;
		}
		for(TableValue element:dataList) {
			if(element.key == key) {
				element.value = value;
				return;
			}
		}
		dataList.add(new TableValue(key,value));
	}
	
	public static Integer get(int key) {
		int realKey = hash(key);
		LinkedList<TableValue> dataList = (LinkedList<TableValue>) data[realKey];
		if(dataList==null) {
			dataList = new LinkedList<TableValue>();
		}
		for(TableValue element:dataList) {
			if(element.key == key) {
				return element.value;
			}
		}
		return null;
	}
	
	public static int hash(int key) {
		int realKey = key%data.length;
		return realKey;
	}
}
