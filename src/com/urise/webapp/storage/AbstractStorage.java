package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;


public abstract class AbstractStorage implements Storage {

    protected abstract boolean isMember(Object key);

    protected abstract Object getKeyOfElement(String uuid);

    protected abstract void saveElement(Resume resume, Object key);

    protected abstract Resume getElementByKey(Object key);

    protected abstract void updateElement(Resume resume, Object key);

    protected abstract void deleteElementByKey(Object key);

    protected abstract List<Resume> getSortedList();

    protected final Comparator<Resume> RESUME_COMPARATOR = (resume1, resume2) -> {
        if (resume1.getFullName().equals(resume2.getFullName())) {
            return resume1.getUuid().compareTo(resume2.getUuid());
        } else {
            return resume1.getFullName().compareTo(resume2.getFullName());
        }
    };

    @Override
    public void update(Resume resume) {
        Object key = getExistKey(resume.getUuid());
        updateElement(resume, key);
    }

    @Override
    public void save(Resume resume) {
        Object key = getNotExistKey(resume.getUuid());
        saveElement(resume, key);
    }

    @Override
    public Resume get(String uuid) {
        Object key = getExistKey(uuid);
        return getElementByKey(key);
    }

    @Override
    public void delete(String uuid) {
        Object key = getExistKey(uuid);
        deleteElementByKey(key);
    }

    private Object getExistKey(String uuid) {
        Object key = getKeyOfElement(uuid);
        if (isMember(key)) {
            return key;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getNotExistKey(String uuid) {
        Object key = getKeyOfElement(uuid);
        if (!isMember(key)) {
            return key;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        return getSortedList();
    }

}
