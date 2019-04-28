package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {


    private List<Resume> storage = new ArrayList<>();


    @Override
    protected boolean isMember(Object key) {
        return key != null;
    }

    @Override
    protected Object getKeyOfElement(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void saveElement(Resume resume, Object key) {
        storage.add(resume);

    }

    @Override
    protected Resume getElementByKey(Object key) {
        return storage.get((Integer) key);
    }

    @Override
    protected void updateElement(Resume resume, Object key) {
        storage.set((Integer) key, resume);

    }

    @Override
    protected void deleteElementByKey(Object key) {
        storage.remove((Integer) key);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}

