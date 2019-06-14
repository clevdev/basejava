package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteByIndex(int index);

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void updateElement(Resume resume, Integer searchKey) {
        storage[searchKey] = resume;
    }

    @Override
    public void saveElement(Resume resume, Integer searchKey) {
        if (size < STORAGE_LIMIT) {
            insertElement(resume, searchKey);
            size++;
        } else {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
    }

    @Override
    public void deleteElementByKey(Integer SearchKey) {
        deleteByIndex( SearchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getElementByKey(Integer index) {
        return storage[index];
    }

    @Override
    protected boolean isMember(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    protected List<Resume> getListOfResumes() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

}
