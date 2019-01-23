package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isMember(index)) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Resume uuid=" + resume.getUuid() + " doesn't exist");
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            if (size < STORAGE_LIMIT) {
                insert(resume, index);
            } else {
                System.out.println("ERROR: Storage overflow");
            }
        } else {
            System.out.println("ERROR: Resume uuid=" + resume.getUuid() + " already exist");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            deleteByIndex(index);
        } else {
            System.out.println("ERROR: Operation interrupted. Resume uuid=" + uuid + " doesn't exist");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("ERROR: Resume uuid=" + uuid + " doesn't exist");
        return null;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insert(Resume resume, int index);

    protected abstract void deleteByIndex(int index);

    protected abstract boolean isMember(int index);

}
