package javaproject.test.example1;

public class A {
	public static void main(String[] args) {
		String originRecipeVideo = "www.youtube.com/watch?v=38AFNvoXP-U";
		if(originRecipeVideo.length() != 0) {
			String recipeVideo = originRecipeVideo.replace("watch?v=","embed/");
			if(recipeVideo.length() >= recipeVideo.indexOf("embed/")+17) {
				System.out.println(recipeVideo.substring(0, recipeVideo.indexOf("embed/")+17));
			}
		}
	}
}
