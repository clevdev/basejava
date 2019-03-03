package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;


public class ArrayStorage extends AbstractArrayStorage {
    private static final int NOT_FOUND = -1;

    @Override
    protected void insert(Resume resume, int index) {
        System.out.println("index=" +index);
        storage[size] = resume;
    }

    @Override
    protected void deleteByIndex(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    protected boolean isMember(int index){
        return index != NOT_FOUND;
    }
}
