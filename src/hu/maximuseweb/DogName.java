package hu.maximuseweb;

class DogName {
    private int id;
    private String name;

    DogName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DogName{" +
                "id=" + id +
                ", name='" + name + "'" +
                "}\n";
    }
}