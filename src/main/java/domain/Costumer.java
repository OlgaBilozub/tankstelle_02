package domain;

import java.util.Objects;

public class Costumer {

    private long id;
    private String name;
    private boolean isActive;


    public Costumer() {
    }

    public Costumer(long id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costumer costumer = (Costumer) o;
        return id == costumer.id && isActive == costumer.isActive && Objects.equals(name, costumer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isActive);
    }

    @Override
    public String toString() {
        return String.format(
                "Costumer Information:\n" +
                        "---------------------\n" +
                        "ID      : %d\n" +
                        "Name    : %s\n" +
                        "Active  : %s\n",
                id, name, isActive ? "Yes" : "No");
    }
}

