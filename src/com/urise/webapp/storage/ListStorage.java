package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private static final int NOT_FOUND = -1;
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isMember(Object key) {
        return (Integer) key >= 0;
    }

    @Override
    protected Object getKeyOfElement(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
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
        storage.remove(((Integer) key).intValue());
    }

    @Override
    protected List<Resume> getResumeList() {
        return new ArrayList<Resume>(storage);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}

