package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;


public abstract class AbstractStorage<SK> implements Storage {
    private static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract boolean isMember(SK searchKey);

    protected abstract SK getKeyOfElement(String uuid);

    protected abstract void saveElement(Resume resume, SK searchKey);

    protected abstract Resume getElementByKey(SK key);

    protected abstract void updateElement(Resume resume, SK searchKey);

    protected abstract void deleteElementByKey(SK SearchKey);

    protected abstract List<Resume> getListOfResumes();

    protected final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName)
            .thenComparing(Resume::getUuid);

    @Override
    public void update(Resume resume) {
        LOG.info("update " + resume);
        SK searchKey = getExistSearchKey(resume.getUuid());
        updateElement(resume, searchKey);
    }

    @Override
    public void save(Resume resume) {
        LOG.info("save " + resume);
        SK searchKey = getNotExistSearchKey(resume.getUuid());
        saveElement(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("get " + uuid);
        SK searchKey = getExistSearchKey(uuid);
        return getElementByKey(searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("delete " + uuid);
        SK searchKey = getExistSearchKey(uuid);
        deleteElementByKey(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted ");
        List<Resume> resumeList = getListOfResumes();
        Collections.sort(resumeList, RESUME_COMPARATOR);
        return resumeList;
    }

    private SK getExistSearchKey(String uuid) {
        SK searchKey = getKeyOfElement(uuid);
        if (isMember(searchKey)) {
            return searchKey;
        } else {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
    }

    private SK getNotExistSearchKey(String uuid) {
        SK searchKey = getKeyOfElement(uuid);
        if (!isMember(searchKey)) {
            return searchKey;
        } else {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
    }

}
