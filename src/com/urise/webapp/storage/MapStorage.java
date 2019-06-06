package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isMember(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected String getKeyOfElement(String uuid) {
        return uuid;
    }

    @Override
    protected void saveElement(Resume resume, String searchKey) {
        storage.put( searchKey, resume);
    }

    @Override
    protected Resume getElementByKey(String key) {
        return storage.get(key);
    }

    @Override
    protected void updateElement(Resume resume, String searchKey) {
        saveElement(resume, searchKey);
    }

    @Override
    protected void deleteElementByKey(String SearchKey) {
        storage.remove( SearchKey);
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
