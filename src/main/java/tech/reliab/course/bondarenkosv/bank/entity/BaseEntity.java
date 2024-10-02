package main.java.tech.reliab.course.bondarenkosv.bank.entity;

public abstract class BaseEntity<T> {
    protected int id;
    protected boolean active = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract T copy();
}
