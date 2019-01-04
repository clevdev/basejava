import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        if(get(r.uuid) == null) {
            if(size < storage.length){
                storage[size] = r;
                size++;
            }
        }
    }

    Resume get(String uuid) {
        if(size!=0){

            for( int i=0; i<= (size-1); i++){
                if (storage[i].uuid.equals(uuid)){
                    return storage[i];
                }
            }
        }

        return null;
    }

    void delete(String uuid) {
        if(size!=0) {
            for (int i = 0; i < (size-1); i++) {
                if (storage[i].uuid.equals(uuid)) {
                    if (i != (size - 1)){
                        System.arraycopy(storage, i + 1, storage, i, size - i);
                    }
                    storage[size-1]= null;
                    size--;

                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        if(size>0){
            Resume rArr[] = new Resume[size];
            System.arraycopy(storage,0, rArr, 0, size );
            return rArr;
        }

        return new Resume[0];
    }

    int size() {
        return size;
    }
}
