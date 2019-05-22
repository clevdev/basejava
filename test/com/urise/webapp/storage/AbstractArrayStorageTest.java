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
}
