package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private static final int NOT_FOUND = -1;
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isMember(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    protected Integer getKeyOfElement(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    protected void saveElement(Resume resume, Integer searchKey) {
        storage.add(resume);
    }

    @Override
    protected Resume getElementByKey(Integer searchKey) {
        return storage.get( searchKey);
    }

    @Override
    protected void updateElement(Resume resume, Integer searchKey) {
        storage.set( searchKey, resume);
    }

    @Override
    protected void deleteElementByKey(Integer SearchKey) {
        storage.remove(SearchKey.intValue());
    }

    @Override
    protected List<Resume> getListOfResumes() {
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

