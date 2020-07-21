package hu.maximuseweb;

class Dog {
    private int id;
    private int breedId;
    private int nameId;
    private int age;
    private String lastMedicalExamination;

    Dog(int id, int breedId, int nameId, int age, String lastMedicalExamination) {
        this.id = id;
        this.breedId = breedId;
        this.nameId = nameId;
        this.age = age;
        this.lastMedicalExamination = lastMedicalExamination;
    }

    int getId() {
        return id;
    }

    int getBreedId() {
        return breedId;
    }

    int getNameId() {
        return nameId;
    }

    int getAge() {
        return age;
    }

    String getLastMedicalExamination() {
        return lastMedicalExamination;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", breedId=" + breedId +
                ", nameId=" + nameId +
                ", age=" + age +
                ", lastMedicalExamination='" + lastMedicalExamination + "'" +
                "}\n";
    }
}