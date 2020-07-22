package hu.maximuseweb;

public class Main {
    public static void main(String[] args) {
	    Actions.fileToList("KutyaNevek.csv");
        System.out.println(Actions.task3());
        Actions.fileToList("KutyaFajtak.csv");
        Actions.fileToList("Kutyak.csv");
        System.out.println(Actions.task6());
        System.out.println(Actions.task7());
        Actions.task8("2018.01.10");
        System.out.println(Actions.task9());
        Actions.task10("nevstatisztika.txt");
    }
}