package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (get(r.getUuid()) == null) {
            if (size < storage.length) {
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    public void delete(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                size--;

            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        if (size > 0) {
            Resume resume[] = new Resume[size];
            System.arraycopy(storage, 0, resume, 0, size);
            return resume;
        }

        return new Resume[0];
    }

    public int size() {
        return size;
    }
}
