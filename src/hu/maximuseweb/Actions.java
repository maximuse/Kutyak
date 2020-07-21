package hu.maximuseweb;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class Actions {
    private static ArrayList<DogName> dogNames;
    private static ArrayList<DogBreed> dogBreeds;
    private static ArrayList<Dog> dogs;

    private static ArrayList<DogName> getDogNames() {
        return dogNames;
    }

    private static void setDogNames(ArrayList<DogName> dogNames) {
        Actions.dogNames = dogNames;
    }

    private static ArrayList<DogBreed> getDogBreeds() {
        return dogBreeds;
    }

    private static void setDogBreeds(ArrayList<DogBreed> dogBreeds) {
        Actions.dogBreeds = dogBreeds;
    }

    private static ArrayList<Dog> getDogs() {
        return dogs;
    }

    private static void setDogs(ArrayList<Dog> dogs) {
        Actions.dogs = dogs;
    }

    static void fileToList(String fileName) {
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            String[] slice;

            switch (fileName) {
                case "KutyaNevek.csv":
                    ArrayList<DogName> dogNames = new ArrayList<>();
                    row = raf.readLine();

                    while (row != null) {
                        slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

                        dogNames.add(new DogName(Integer.parseInt(slice[0]), slice[1]));

                        row = raf.readLine();
                    }

                    setDogNames(dogNames);

                    break;
                case "KutyaFajtak.csv":
                    ArrayList<DogBreed> dogBreeds = new ArrayList<>();
                    row = raf.readLine();

                    while (row != null) {
                        slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

                        dogBreeds.add(new DogBreed(Integer.parseInt(slice[0]), slice[1], slice[2]));

                        row = raf.readLine();
                    }

                    setDogBreeds(dogBreeds);

                    break;
                case "Kutyak.csv":
                    ArrayList<Dog> dogs = new ArrayList<>();
                    row = raf.readLine();

                    while (row != null) {
                        slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

                        dogs.add(new Dog(Integer.parseInt(slice[0]), Integer.parseInt(slice[1]), Integer.parseInt(slice[2]), Integer.parseInt(slice[3]), slice[4]));

                        row = raf.readLine();
                    }

                    setDogs(dogs);

                    break;
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static String task3() {
        return "3. feladat: Kutyanevek száma: " + Actions.getDogNames().size();
    }
}