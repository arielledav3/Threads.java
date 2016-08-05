public class helloworld {
	public static void main(String [] args){
		String word = "hello";
		String [] array = word.split("");
		String newword = "";
		
		for(int i = 0; i < array.length; i++){
			newword += array[i] + " ";
		}
		
		System.out.println(newword);
	}
}
