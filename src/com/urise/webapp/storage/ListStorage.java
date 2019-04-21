package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {


    ListStorage() {
        super(new ArrayList<Resume>());
    }

    
}

