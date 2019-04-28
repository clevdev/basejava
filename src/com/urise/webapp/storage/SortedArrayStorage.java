package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        int indexToInsert = (-index) - 1;
        System.arraycopy(storage, indexToInsert, storage, indexToInsert + 1, size - indexToInsert);
        storage[indexToInsert] = resume;
    }

    @Override
    protected void deleteByIndex(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
    }

    @Override
    protected Integer getKeyOfElement(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}