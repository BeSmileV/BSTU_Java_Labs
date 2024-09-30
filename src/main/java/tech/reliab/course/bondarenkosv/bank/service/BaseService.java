package main.java.tech.reliab.course.bondarenkosv.bank.service;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class BaseService<T extends BaseEntity> {
    protected List<T> entityList = new ArrayList<>();

    public int create(T entity) {
        int id = entityList.size() + 1;
        entity.setId(id);
        entityList.add(entity);
        return id;
    }

    public T read(int id) {
        return entityList.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(int id, T updatedEntity) {
        for (int i = 0; i < entityList.size(); i++) {
            if (entityList.get(i).getId() == id) {
                entityList.set(i, updatedEntity);
                updatedEntity.setId(id); // сохраняем идентификатор
                break;
            }
        }
    }

    public void delete(int id) {
        entityList.removeIf(entity -> entity.getId() == id);
    }

    public List<T> list() {
        return new ArrayList<>(entityList); // возвращаем копию списка
    }
}
