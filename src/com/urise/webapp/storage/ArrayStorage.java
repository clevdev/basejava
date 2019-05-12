package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;


public class ArrayStorage extends AbstractArrayStorage {
    private static final int NOT_FOUND = -1;

//    @Override
//    public List<Resume> getAllSorted() {
//        Resume[] sortedArray = new Resume[this.size()];
//        System.arraycopy(storage,0,sortedArray,0,this.size());
//        Arrays.sort(sortedArray, RESUME_COMPARATOR);
//        return Arrays.asList(sortedArray);
//    }

    @Override
    protected void insertElement(Resume resume, int index) {
        if (isMember(index)) {
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
        return NOT_FOUND;
    }

}
