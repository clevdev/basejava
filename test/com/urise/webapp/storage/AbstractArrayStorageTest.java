package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {

    private Storage storage;// = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    AbstractArrayStorageTest( Storage storage){
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
        Assert.assertEquals(0,storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3,storage.size());
    }

    @Test
    public void update() {
        storage.update(RESUME_2);
        Assert.assertTrue(storage.get(UUID_2)==RESUME_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void save() {
        storage.save(RESUME_4 );
        Assert.assertTrue(storage.get(UUID_4).equals(RESUME_4 ));
    }

    @Test(expected = ExistStorageException.class)
    public void saveIfExist() throws Exception{
        storage.save(RESUME_3);

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
    public void getAll() {
        Assert.assertArrayEquals(storage.getAll(), new Resume[]{RESUME_1 , RESUME_2, RESUME_3});
    }

    @Test
    public void get() {
        Assert.assertEquals(storage.get(UUID_1),RESUME_1);
        Assert.assertEquals(storage.get(UUID_2),RESUME_2);
        Assert.assertEquals(storage.get(UUID_3),RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}