package hu.maximuseweb;

class DogBreed {
    private int id;
    private String name;
    private String originalName;

    DogBreed(int id, String name, String originalName) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getOriginalName() {
        return originalName;
    }

    @Override
    public String toString() {
        return "DogBreed{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", originalName='" + originalName + "'" +
                "}\n";
    }
}