package tech.reliab.course.bondarenkosv.bank.service.impl;

import tech.reliab.course.bondarenkosv.bank.entity.BaseEntity;
import tech.reliab.course.bondarenkosv.bank.service.BaseServiceInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseService<T extends BaseEntity<T>> implements BaseServiceInterface<T> {
    protected List<T> entityList;

    public void init() {
        entityList = new ArrayList<T>();
    }

    public T read(int id) {
        for (T entity : entityList) {
            if (entity.getId() == id) {
                if (!entity.isActive())
                    return null;
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
        T entity = read(id);
        entity.setActive(false);
        update(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<T>();

        for (T entity : entityList) {
            if (entity.isActive())
                list.add(entity.copy());
        }

        return list;
    }

    @Override
    public boolean isExists(int id) {
        for (T entity : entityList) {
            if (entity.getId() == id && entity.isActive()) {
                return true;
            }
        }
        return false;
    }
}
