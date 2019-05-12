package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
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
        storage.remove(((Integer) key).intValue());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> sortedlist = new ArrayList<Resume>(storage);
        Collections.sort(sortedlist, RESUME_COMPARATOR);
        return sortedlist;

    }

    @Override
    public int size() {
        return storage.size();
    }
}

