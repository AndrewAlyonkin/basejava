package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    // own methods
    @Override
    public void update(Resume resume) {
        setResume(mustExistIndex(resume.getUuid()), resume);
    }

    @Override
    public void save(Resume resume) {
        addResume(mustNotExistIndex(resume.getUuid()), resume);
    }

    @Override
    public Resume get(String uuid) {
        return getResume(mustExistIndex(uuid), uuid);
    }

    @Override
    public void delete(String uuid) {
        deleteResume(mustExistIndex(uuid), uuid);
    }

    // own util methods
    private int mustExistIndex(String uuid) throws NotExistStorageException {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private int mustNotExistIndex(String uuid) throws ExistStorageException {
        int index = getIndex(uuid);
        if (index >= 0) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }

    // child util methods

    protected abstract void deleteResume(int index, String uuid);

    protected abstract int getIndex(String uuid);

    protected abstract void setResume(int index, Resume resume);

    protected abstract void addResume(int index, Resume resume);

    protected abstract Resume getResume(int index, String uuid);


}
