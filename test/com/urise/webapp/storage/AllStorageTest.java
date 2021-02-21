package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapStorageTest.class,
        ResumeSearchKeyMapStorageTest.class,
        ObjectStreamPathStorageTest.class,
        ObjectStreamStorageTest.class,
        XmlStreamPathStorageTest.class,
        JsonStreamPathStorageTest.class
})
public class AllStorageTest {
}
