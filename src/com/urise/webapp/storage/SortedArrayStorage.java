package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

//    @Override
//    public List<Resume> getAllSorted() {
//        Resume[] sortedArray = new Resume[this.size()];
//        System.arraycopy(storage,0,sortedArray,0,this.size());
//        Arrays.sort(sortedArray, RESUME_COMPARATOR);
//        return Arrays.asList(sortedArray);
//    }

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
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR_BY_UUID);
    }

    private static final Comparator<Resume> RESUME_COMPARATOR_BY_UUID = new Comparator<Resume>() {
        @Override
        public int compare(Resume resume1, Resume resume2) {
                return resume1.getUuid().compareTo(resume2.getUuid());
        }
    };

}