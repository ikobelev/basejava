/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++)
            storage[i] = null;
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            Resume resume = storage[i];
            if (resume.uuid == uuid)
                return resume;
        }
        return null;
    }

    void delete(String uuid) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete >= 0) {
            for (int i = indexToDelete; i < size; i++)
                storage[i] = storage[i + 1];
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return size;
    }
}
