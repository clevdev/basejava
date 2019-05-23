package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

public class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        storage.clear();
        try {
            for (int n = 0; n < AbstractArrayStorage.STORAGE_LIMIT; n++) {
                storage.save(new Resume("test name"));
            }
        } catch (StorageException e) {
            fail("Storage overflow");
        }
        storage.save(new Resume("last name"));
    }
}
