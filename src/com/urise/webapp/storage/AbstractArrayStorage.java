package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

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
    public List<Resume> getAllSorted() {
        Resume[] sortedArray = new Resume[this.size()];
        System.arraycopy(storage,0,sortedArray,0,this.size());
        Arrays.sort(sortedArray, RESUME_COMPARATOR);
        return Arrays.asList(sortedArray);
    }

    @Override
    public void updateElement(Resume resume, Object index) {
        storage[(Integer) index] = resume;
    }

    @Override
    public void saveElement(Resume resume, Object index) {

        if (size < STORAGE_LIMIT) {
            insertElement(resume, (Integer) index);
            size++;
        } else {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
    }

    @Override
    public void deleteElementByKey(Object index) {

        deleteByIndex((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getElementByKey(Object index) {

        return storage[(Integer) index];
    }

    @Override
    protected boolean isMember(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract Object getKeyOfElement(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteByIndex(int index);

}
