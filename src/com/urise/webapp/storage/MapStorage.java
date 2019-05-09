package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isMember(Object key) {
        return storage.containsKey(key);
    }

    @Override
    protected Object getKeyOfElement(String uuid) {
        return uuid;
    }

    @Override
    protected void saveElement(Resume resume, Object key) {
        storage.put((String) key, resume);

    }

    @Override
    protected Resume getElementByKey(Object key) {
        return storage.get(key);
    }

    @Override
    protected void updateElement(Resume resume, Object key) {
        saveElement(resume, key);

    }

    @Override
    protected void deleteElementByKey(Object key) {
        storage.remove((String) key);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[storage.values().size()];
        return storage.values().toArray(resumes);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
