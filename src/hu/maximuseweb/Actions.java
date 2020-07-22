package hu.maximuseweb;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

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

    static String task6() {
        double avg = 0;

        for (Dog dog : Actions.getDogs()) {
            avg += dog.getAge();
        }

        avg /= Actions.getDogs().size();

        return "6. feladat: Kutyák átlag életkora: " + String.format("%.2f", avg);
    }

    static String task7() {
        int nameId = 1;
        int breedId = 1;
        int age = Actions.getDogs().get(0).getAge();

        for (Dog dog : Actions.getDogs()) {
            if (dog.getAge() > age) {
                age = dog.getAge();
                nameId = dog.getNameId() - 1;
                breedId = dog.getBreedId() - 1;
            }
        }

        return "7. feladat: Legidősebb kutya neve és fajtája: " + Actions.getDogNames().get(nameId).getName() + ", " + Actions.getDogBreeds().get(breedId).getName();
    }

    static void task8(String date) {
        TreeSet<Integer> breeds = new TreeSet<>();
        Map<String, Integer> stat = new HashMap<>();
        int breedId = 0;
        int counter;

        for (Dog dog : Actions.getDogs()) {
            if (dog.getLastMedicalExamination().equals(date)) {
                breeds.add(dog.getBreedId());
            }
        }

        for (Integer breed : breeds) {
            counter = 0;

            for (Dog dog : Actions.getDogs()) {
                if (dog.getBreedId() == breed && dog.getLastMedicalExamination().equals(date)) {
                    breedId = dog.getBreedId() - 1;
                    counter++;
                }
            }

            stat.put(Actions.getDogBreeds().get(breedId).getName(), counter);
        }

        System.out.println("8. feladat: 2018. január 10.-én vizsgált kutya fajták:");
        stat.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach((key) -> System.out.println("\t" + key.getKey() + ": " + key.getValue() + " kutya"));
    }
}