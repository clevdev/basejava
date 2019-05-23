package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isMember(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Object getKeyOfElement(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void saveElement(Resume resume, Object searchKey) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElementByKey(Object key) {
        return (Resume) key;
    }

    @Override
    protected void updateElement(Resume resume, Object searchKey) {
        saveElement(resume, ((Resume) searchKey).getUuid());
    }

    @Override
    protected void deleteElementByKey(Object SearchKey) {
        storage.remove(((Resume) SearchKey).getUuid());
    }

    @Override
    protected List<Resume> getResumeList() {
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
