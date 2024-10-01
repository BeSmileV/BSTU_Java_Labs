package main.java.tech.reliab.course.bondarenkosv.bank.service.impl;

import main.java.tech.reliab.course.bondarenkosv.bank.entity.BaseEntity;
import main.java.tech.reliab.course.bondarenkosv.bank.service.BaseServiceInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseService<T extends BaseEntity<T>> implements BaseServiceInterface<T> {
    protected List<T> entityList;

    public T read(int id) {
        for (T entity : entityList) {
            if (entity.getId() == id) {
                return entity.copy();
            }
        }

        return null;
    }

    public void update(int id, T updatedEntity) {
        for (int i = 0; i < entityList.size(); i++) {
            if (entityList.get(i).getId() == id) {
                T copyEntity = updatedEntity.copy();
                copyEntity.setId(id);
                entityList.set(i, copyEntity);
                break;
            }
        }
    }

    public void delete(int id) {
        entityList.removeIf(entity -> entity.getId() == id);
    }

    public List<T> list() {
        List<T> list = new ArrayList<T>();

        for (T entity : entityList) {
            list.add(entity.copy());
        }

        return list;
    }

    @Override
    public boolean isExists(int id) {
        for (T entity : entityList) {
            if (entity.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
