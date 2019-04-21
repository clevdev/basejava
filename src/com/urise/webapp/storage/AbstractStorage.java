package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;


public abstract class AbstractStorage implements Storage {

    protected Collection storage;

    AbstractStorage(Collection storage){
        this.storage = storage;
    }


    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public void save(Resume resume) {
        storage.add(resume);

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return storage.size();
    }
}
