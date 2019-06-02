package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isMember(Object searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected Object getKeyOfElement(String uuid) {
        return uuid;
    }

    @Override
    protected void saveElement(Resume resume, Object searchKey) {
        storage.put((String) searchKey, resume);
    }

    @Override
    protected Resume getElementByKey(Object key) {
        return storage.get(key);
    }

    @Override
    protected void updateElement(Resume resume, Object searchKey) {
        saveElement(resume, searchKey);
    }

    @Override
    protected void deleteElementByKey(Object SearchKey) {
        storage.remove((String) SearchKey);
    }

    @Override
    protected List<Resume> getListOfResumes() {
        return new ArrayList<Resume>(storage.values());
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
