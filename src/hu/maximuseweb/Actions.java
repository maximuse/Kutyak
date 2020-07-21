package hu.maximuseweb;

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
}