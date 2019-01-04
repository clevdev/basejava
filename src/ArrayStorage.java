import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size - 1, null);
        size = 0;
    }

    void save(Resume r) {
        if (get(r.uuid) == null) {
            if (size < storage.length) {
                storage[size] = r;
                size++;
            }
        }
    }

    Resume get(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size - i);
                storage[size - 1] = null;
                size--;

            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        if (size > 0) {
            Resume resume[] = new Resume[size];
            System.arraycopy(storage, 0, resume, 0, size);
            return resume;
        }

        return new Resume[0];
    }

    int size() {
        return size;
    }
}
