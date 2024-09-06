package intuition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSelection {
    public static void main(String[] args) {
        // Sample list of users (or objects)
        List<String> users = List.of("user1", "user2");

        // Calculate the number of elements to select (approximately 33% of the total)
        int totalSize = users.size();
        int numToSelect = (int) Math.ceil(totalSize * 0.33); // Use Math.ceil to round up

        // Shuffle the list to randomize it
        List<String> shuffledUsers = new ArrayList<>(users);
        int seed = 0;
        while (true){
            Collections.shuffle(shuffledUsers,new Random(seed));
            if (users.equals(shuffledUsers)){
                System.out.println("Seed " + seed);
            }
            seed++;
        }
    }
}

//Seed 3058474
//Seed 9223149
//Seed 10964555
//Seed 11446110
//Seed 15067828
//Seed 21943200
//Seed 25806680