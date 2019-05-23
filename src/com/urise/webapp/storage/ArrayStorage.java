package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        if (index >= 0) {
            storage[index] = resume;
        } else {
            storage[size] = resume;
        }

    }

    @Override
    protected void deleteByIndex(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected Integer getKeyOfElement(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
