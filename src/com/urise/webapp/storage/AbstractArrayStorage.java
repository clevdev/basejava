package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected static final int NOT_FOUND = -1;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != NOT_FOUND) {
            return storage[index];
        }
        System.out.println("ERROR: Resume uuid=" + uuid + " doesn't exist");
        return null;
    }

    protected abstract int getIndex(String uuid);

}
