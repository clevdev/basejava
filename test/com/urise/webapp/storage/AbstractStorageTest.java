package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

public class AbstractStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String FULLNAME_1 = "Иванов";
    private static final String FULLNAME_2 = "Петров";
    private static final String FULLNAME_3 = "Сидоров";
    private static final String FULLNAME_4 = "Кузнецов";

    private static final Resume RESUME_1 = new Resume(UUID_1, FULLNAME_1);
    private static final Resume RESUME_2 = new Resume(UUID_2, FULLNAME_2);
    private static final Resume RESUME_3 = new Resume(UUID_3, FULLNAME_3);
    private static final Resume RESUME_4 = new Resume(UUID_4, FULLNAME_4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void update() {
        Resume resume2 = new Resume(UUID_2, FULLNAME_2);
        storage.update(resume2);
        Assert.assertSame(resume2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        Assert.assertEquals(RESUME_4, storage.get(UUID_4));
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveIfExist() throws Exception {
        storage.save(RESUME_3);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        assumeTrue(storage.getClass().getName().equals(ArrayStorage.class.getName()) || storage.getClass().getName().equals(SortedArrayStorage.class.getName()));
        storage.clear();
        try {
            for (int n = 1; n <= AbstractArrayStorage.STORAGE_LIMIT; n++) {
                storage.save(new Resume("test name"));
            }
        } catch (StorageException e) {
            fail("Storage overflow");
        }
        storage.save(new Resume("last name"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void getAllSorted() {
        List<Resume> resumeList = storage.getAllSorted();
        Assert.assertEquals(FULLNAME_1, resumeList.get(0).getFullName());
        Assert.assertEquals(FULLNAME_2, resumeList.get(1).getFullName());
        Assert.assertEquals(FULLNAME_3, resumeList.get(2).getFullName());
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME_1, storage.get(UUID_1));
        Assert.assertEquals(RESUME_2, storage.get(UUID_2));
        Assert.assertEquals(RESUME_3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}
