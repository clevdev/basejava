package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) == NOT_FOUND) {
            if (size < STORAGE_LIMIT) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: Storage overflow");
            }
        } else {
            System.out.println("ERROR: Resume uuid=" + resume.getUuid() + " already exist");
        }

    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != NOT_FOUND) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Resume uuid=" + resume.getUuid() + " doesn't exist");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != NOT_FOUND) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
        System.out.println("ERROR: Operation interrupted. Resume uuid=" + uuid + " doesn't exist");
    }

    public Resume[] getAll() {
        Resume[] resume = new Resume[size];
        System.arraycopy(storage, 0, resume, 0, size);
        return resume;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
