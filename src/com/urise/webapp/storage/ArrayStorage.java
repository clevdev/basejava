package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;
    private static final int NOT_FOUND = -1;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) == NOT_FOUND) {
            if (size < storage.length) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: Не возможно сохранить новый элемент. Переполнение");
            }
        } else {

            System.out.println("ERROR: Resume c uuid=" + resume.getUuid() + " уже существует");
        }

    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != NOT_FOUND) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Обновление не выполнено. Resume c uuid=" + resume.getUuid() + " не существует");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != NOT_FOUND) {
            return storage[index];
        }
        System.out.println("ERROR: Resume c uuid=" + uuid + " не существует");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != NOT_FOUND) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
        System.out.println("ERROR: Удаление не выполнено. Resume c uuid=" + uuid + " не существует");

    }

    public Resume[] getAll() {

        Resume[] resume = new Resume[size];
        System.arraycopy(storage, 0, resume, 0, size);
        return resume;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
