package com.fj.test;
/*自定义泛型的使用
 * 2017年7月21日 21:37:08
 * */
public class GenericParadigm {
	public static void main(String[] args) {
		A a = new A();
		Integer[] arr = {21,11,5,3};
		
		a.f(arr, 0, 3);
		for(int i:arr){
			System.out.println(i);
		}
	}
}

class A{
	//声明泛型
	public<T> void f(T[] arr,int j,int k){
		T temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
}