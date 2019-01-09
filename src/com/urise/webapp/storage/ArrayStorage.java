package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;
    private static final int NOT_FOUND = -1;

    private int getResumePosition(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (getResumePosition(r.getUuid()) == NOT_FOUND) {
            if (size < storage.length) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("ERROR: Не возможно сохранить новый элемент. Переполнение");
            }
        } else {

            System.out.println("ERROR: Resume c uuid=" + r.getUuid() + " уже существует");
        }

    }

    public void update(Resume r) {
        int position = getResumePosition(r.getUuid());
        if (position != NOT_FOUND) {
            storage[position] = r;
        } else {
            System.out.println("ERROR: Обновление не выполнено. Resume c uuid=" + r.getUuid() + " не существует");
        }
    }

    public Resume get(String uuid) {
        int position = getResumePosition(uuid);
        if (position != NOT_FOUND) {
            return storage[position];
        }
        System.out.println("ERROR: Resume c uuid=" + uuid + " не существует");
        return null;
    }

    public void delete(String uuid) {
        int position = getResumePosition(uuid);
        if (position != NOT_FOUND) {
            storage[position] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
        System.out.println("ERROR: Удаление не выполнено. Resume c uuid=" + uuid + " не существует");

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
