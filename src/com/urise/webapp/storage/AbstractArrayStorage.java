package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
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
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isMember(index)) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Resume uuid=" + resume.getUuid() + " doesn't exist");
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (!isMember(index)) {
            if (size < STORAGE_LIMIT) {
                insert(resume, index);
                size++;
            } else {
                System.out.println("ERROR: Storage overflow");
                throw new StorageException("Storage overflow", resume.getUuid());
            }
        } else {
            System.out.println("ERROR: Resume uuid=" + resume.getUuid() + " already exist");
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (isMember(index)) {
            deleteByIndex(index);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: Operation interrupted. Resume uuid=" + uuid + " doesn't exist");
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (isMember(index)) {
            return storage[index];
        }
        System.out.println("ERROR: Resume uuid=" + uuid + " doesn't exist");
        throw new NotExistStorageException(uuid);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insert(Resume resume, int index);

    protected abstract void deleteByIndex(int index);

    protected abstract boolean isMember(int index);

}
