import java.util.Collections;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MoviesApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

//		Movie m1 = new Movie("Star Wars", "scifi");
//		Movie m2 = new Movie("E.T. The Extra-terrestrial", "scifi");
//		Movie m3 = new Movie("Halloween", "horror");
//		Movie m4 = new Movie("Saving Private Ryan", "drama");
//		Movie m5 = new Movie("Fast and Furious", "action");
//		Movie m6 = new Movie("Rush Hour", "comedy");
//		Movie m7 = new Movie("Grown Ups", "comedy");
//		Movie m8 = new Movie("Iron Man", "action");
//		Movie m9 = new Movie("Scream", "horror");
//		Movie m10 = new Movie("Titanic", "drama");
		
		ArrayList<Movie> movies = new ArrayList<>();
		ArrayList<String> scifi = new ArrayList<>();
		ArrayList<String> horror = new ArrayList<>();
		ArrayList<String> drama = new ArrayList<>();
		ArrayList<String> musical = new ArrayList<>();
		ArrayList<String> animated = new ArrayList<>();

//		Movie[] movies = new Movie[10];
//		movies[0] = m1;
//		movies[1] = m2;
//		movies[2] = m3;
//		movies[3] = m4;
//		movies[4] = m5;
//		movies[5] = m6;
//		movies[6] = m7;
//		movies[7] = m8;
//		movies[8] = m9;
//		movies[9] = m10;
		
		for ( int i = 0; i < 100; i++) {
			movies.add(Movie.getMovie(i));
		}

		for (Movie movie: movies) {
			if (movie.getCategory().equalsIgnoreCase("scifi")) {
				scifi.add(movie.getTitle());
			} else if (movie.getCategory().equalsIgnoreCase("horror")) {
				horror.add(movie.getTitle());
			} else if (movie.getCategory().equalsIgnoreCase("drama")) {
				drama.add(movie.getTitle());
			} else if (movie.getCategory().equalsIgnoreCase("musical")) {
				musical.add(movie.getTitle());
			} else if (movie.getCategory().equalsIgnoreCase("animated")) {
				animated.add(movie.getTitle());
			}
		}

		Collections.sort(scifi, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(horror, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(drama, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(musical, String.CASE_INSENSITIVE_ORDER);
		Collections.sort(animated, String.CASE_INSENSITIVE_ORDER);

		System.out.println("Welcome to the Movie List App!");
		System.out.println();
		System.out.println("There are 10 movies in the list.");

		boolean keepGoing = false;
		do {
			int userInput = 0;
			System.out.println(
					"What category are you interested in? ('1) scifi', '2) animated', '3) musical', '4) horror', '5) drama'): ");
			boolean isValid = false;
			do {
				try {
					userInput = scnr.nextInt();
				} catch (InputMismatchException ex) {
					scnr.nextLine(); // clear the scanner
					System.out.println("Try again.");
					isValid = false;
				}
			} while (isValid);

			boolean valid = false;
			do {
				String type = "";
				switch (userInput) {
				case 1:
					type = "scifi";
					System.out.println(type + " movies:");
					for (int i = 0; i < scifi.size(); i++) {
						System.out.println(scifi.get(i));
					}
					break;
				case 2:
					type = "animated";
					System.out.println(type + " movies:");
					for (int i = 0; i < animated.size(); i++) {
						System.out.println(animated.get(i));
					}
					break;
				case 3:
					type = "musical";
					System.out.println(type + " movies:");
					for (int i = 0; i < musical.size(); i++) {
						System.out.println(musical.get(i));
					}
					break;
				case 4:
					type = "horror";
					System.out.println(type + " movies:");
					for (int i = 0; i < horror.size(); i++) {
						System.out.println(horror.get(i));
					}
					break;
				case 5:
					type = "drama";
					System.out.println(type + " movies:");
					for (int i = 0; i < drama.size(); i++) {
						System.out.println(drama.get(i));
					}
					break;
				}

				if (userInput > 0 && userInput < 6) {
					valid = true;
				} else {
					System.out.println(
							"You didnt enter a proper category. Try again: ('1) scifi', '2) animated', '3) musical', '4) horror', '5) drama'): ");
					userInput = scnr.nextInt();
					valid = false;
				}

			} while (!valid);

			// clear scanner
			scnr.nextLine();
			System.out.println("Continue? ('y' / 'n')");

			String temp = scnr.nextLine();
			if (temp.equals("y") || temp.equals("Y")) {
				keepGoing = true;
			} else {
				keepGoing = false;
			}
		} while (keepGoing);

		scnr.close();
	}// main

}// class
