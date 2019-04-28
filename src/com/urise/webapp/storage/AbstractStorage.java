package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;


public abstract class AbstractStorage implements Storage {

    protected abstract boolean isMember(Object key);

    protected abstract Object getKeyOfElement(String uuid);

    protected abstract void saveElement(Resume resume, Object key);

    protected abstract Resume getElementByKey(Object key);

    protected abstract void updateElement(Resume resume, Object key);

    protected abstract void deleteElementByKey(Object key);

    @Override
    public void update(Resume resume) {
        Object key = getKeyOfElement(resume.getUuid());
        if (isMember(key)) {
            updateElement(resume, key);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void save(Resume resume) {
        Object key = getKeyOfElement(resume.getUuid());
        if (!isMember(key)) {
            saveElement(resume, key);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        Object key = getKeyOfElement(uuid);
        return getElementByKey(key);
    }

    @Override
    public void delete(String uuid) {
        Object key = getKeyOfElement(uuid);
        deleteElementByKey(key);
    }

}
