package org.gd.leetcode.p1233;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.requireNonNull;

class Folder {

    private final String name;
    private final Folder parent;
    private final boolean exists;
    private final Set<Folder> subFolders;

    Folder(String name, Folder parent, boolean exists) {
        this.name = name;
        this.parent = parent;
        this.exists = exists;
        this.subFolders = new HashSet<>();
    }

    static Folder root() {

        return new Folder(null, null, false) {

            @Override
            public String toString() { return ""; }
        };
    }

    static Folder ofPath(String path) {

        requireNonNull(path, "\"path\" cannot be null");

        Folder parent = null;
        Folder root = null;
        String[] split = path.split("/");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            Folder folder = new Folder(s, parent, i == (split.length - 1));
            if (root == null) {
                root = folder;
            }
            parent = folder;
        }
        return root;
    }

    void add(Folder folder) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Folder)) return false;
        Folder folder = (Folder) o;
        return Objects.equals(name, folder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return (parent == null ? "" : parent.toString()) + "/" + name;
    }
}
