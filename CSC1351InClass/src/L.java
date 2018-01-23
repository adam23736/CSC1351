import java.util.Arrays;


public class L {

	private int [] data = new int[1];
	void append(int n){
		int [] newData = new int[data.length+1];
		for (int i=0; i<data.length;i++)
			newData[i] = data[i];
		newData[data.length] = n;
		data = newData; 
	}
	public static void main(String []args){
		L l =new L();
		l.append(3);
		System.out.println(Arrays.toString(l.data));
	}
}
