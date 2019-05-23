package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isMember(Object resume) {
        return resume != null;
    }

    @Override
    protected Object getKeyOfElement(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void saveElement(Resume resume, Object key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElementByKey(Object key) {
        return (Resume) key;
    }

    @Override
    protected void updateElement(Resume resume, Object key) {
        saveElement(resume, ((Resume) key).getUuid());
    }

    @Override
    protected void deleteElementByKey(Object key) {
        storage.remove(((Resume) key).getUuid());
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
