package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage,null);
        size = 0;
    }

    public void update(Resume resume) {
        int resumeIndex = getResumeIndex(resume.getUuid());
        // check if resume present
        if (resumeIndex == -1) {
            System.out.println("Error: resume doesn't present");
            return;
        }
        storage[resumeIndex] = resume;
    }

    public void save(Resume resume) {
        // check if storage not overflow
        if (size == storage.length) {
            System.out.println("Error: storage overflow");
            return;
        }
        // check if resume not present
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                System.out.println("Error: resume already present");
                return;
            }
        }
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        int resumeIndex = getResumeIndex(uuid);
        // check if resume present
        if (resumeIndex == -1) {
            System.out.println("Error: resume doesn't present");
            return null;
        }
        return storage[resumeIndex];
    }

    private int getResumeIndex(String uuid) {
        int resumeIndex = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                resumeIndex = i;
                break;
            }
        }
        return resumeIndex;
    }

    public void delete(String uuid) {
        int resumeIndex = getResumeIndex(uuid);
        // check if resume present
        if (resumeIndex == -1) {
            System.out.println("Error: resume doesn't present");
            return;
        }

        // move the last element to the position of deleted one
        storage[resumeIndex] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage,size);
    }

    public int size() {
        return size;
    }
}
