package tech.reliab.course.bondarenkosv.bank.service;

import java.util.List;

public interface BaseServiceInterface<T> {
    void init();

    T read(int id);

    void update(int id, T updatedEntity);

    void delete(int id);

    List<T> list();

    boolean isExists(int id);
}
