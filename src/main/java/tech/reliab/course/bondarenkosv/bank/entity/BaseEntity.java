package tech.reliab.course.bondarenkosv.bank.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class BaseEntity<T> {
    protected int id;
    protected boolean active = true;

    public abstract T copy();
}
