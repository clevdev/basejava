package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public abstract class AbstractStorage implements Storage {

    protected abstract boolean isMember(Object searchKey);

    protected abstract Object getKeyOfElement(String uuid);

    protected abstract void saveElement(Resume resume, Object searchKey);

    protected abstract Resume getElementByKey(Object key);

    protected abstract void updateElement(Resume resume, Object searchKey);

    protected abstract void deleteElementByKey(Object SearchKey);

    protected abstract List<Resume> getResumeList();

    protected final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName)
            .thenComparing(Resume::getUuid);

    @Override
    public void update(Resume resume) {
        Object searchKey = getExistSearchKey(resume.getUuid());
        updateElement(resume, searchKey);
    }

    @Override
    public void save(Resume resume) {
        Object searchKey = getNotExistSearchKey(resume.getUuid());
        saveElement(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        return getElementByKey(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        deleteElementByKey(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = getResumeList();
        Collections.sort(resumeList, RESUME_COMPARATOR);
        return resumeList;
    }

    private Object getExistSearchKey(String uuid) {
        Object searchKey = getKeyOfElement(uuid);
        if (isMember(searchKey)) {
            return searchKey;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getNotExistSearchKey(String uuid) {
        Object searchKey = getKeyOfElement(uuid);
        if (!isMember(searchKey)) {
            return searchKey;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

}
