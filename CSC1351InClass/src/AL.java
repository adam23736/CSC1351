import java.util.ArrayList;

public class AL {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		System.out.println(words);
		words.add("Jessie's");
		words.add("gorl");
		System.out.println(words);
		words.set(1, "girl");
		System.out.println(words);
		System.out.println(words.get(0));
		words.add("is");
		words.add("Jessie");
		System.out.println(words);

		words.remove(3);
		System.out.println(words);
		words.add("Jessie");
		words.remove("Jessie");
		System.out.println(words);
		words.add("Jessie");
		words.set(0, "Jessie");
		System.out.println(words);
		words.remove("Jessie");
		System.out.println(words);

		for (String word : words) {
			System.out.println(word);
		}
		System.out.println();
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i));
		}
		
		ArrayList<String> otherwords = new ArrayList<>(words); //copies the ArrayList
		//ArrayList<String> otherwords = words; //points to the same object
		
		words.add(0, "Jessies");
		
		System.out.println(words);
		System.out.println(otherwords);
		
		//ArrayList<int> try; <-cant use as name bc its a java keyword
		
		//byte   - Byte
		//boolean - Boolean
		//char,  -Character
		//long,  -Long
		//short,  -Short
		//int,   -Integer
		//float,  -Float
		//double  -Double
		//8 primitive data type   Class name
		ArrayList<Integer> vals = new ArrayList<>();
		int i = 4;
		vals.add(i); //or add(new Integer(i));
		vals.add(vals.size(),2);  //range is 0 to length/size-1
		vals.add(6);
		vals.add(9);
		vals.add(0);
		System.out.println(vals);
		
		vals.remove(1);
		// vals.remove(2); //removes the 6
		vals.remove(new Integer(2)); //removes the 2
		System.out.println(vals.indexOf(6));
		System.out.println(vals.indexOf(2));
		/*
		 * .add(value) appends to list
		 * .add(index,val) 0<=index<=size()
		 * .remove(value)
		 * .remove(index);
		 * .set(index,value);
		 * .get(index)
		 * .size()
		 * .indexOf(value)
		 */
	}
}
