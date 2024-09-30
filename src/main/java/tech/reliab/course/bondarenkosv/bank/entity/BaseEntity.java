package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public abstract class BaseEntity {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract BaseEntity copy();
}
