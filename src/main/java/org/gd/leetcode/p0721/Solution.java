package org.gd.leetcode.p0721;

import java.util.*;

/**
 * TODO: https://leetcode.com/problems/accounts-merge/
 *
 * @author Gorkhover D.
 * @since 2018-10-23
 */
class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<User>> map = new HashMap<>();

        for (List<String> account : accounts) {
            final User user = User.of(account);
            for (String mail : user.mails)
                map.computeIfAbsent(mail, s -> new ArrayList<>()).add(user);
        }

        Set<User> list = new TreeSet<>();
        for (Map.Entry<String, List<User>> entry : map.entrySet()) {
            List<User> users = entry.getValue();
            User       user  = users.get(0);
            for (int i = 1; i < users.size(); i++)
                user.merge(users.get(i));
            list.add(user);
        }

        ArrayList<List<String>> newList = new ArrayList<>(list.size());
        for (User user : new HashSet<>(list))
            newList.add(user.toList());

        return newList;
    }

    static class User implements Comparable<User> {

        final String          name;
        final TreeSet<String> mails;

        User(String name) {
            this.name = name;
            mails = new TreeSet<>();
        }

        static User of(List<String> account) {
            if (account instanceof RandomAccess) {
                final User user = new User(account.get(0));
                for (int i = 1; i < account.size(); i++)
                    user.mails.add(account.get(i));
                return user;
            } else {
                final Iterator<String> iterator = account.iterator();
                final User             user     = new User(iterator.next());
                while (iterator.hasNext())
                    user.mails.add(iterator.next());
                return user;
            }
        }

        User merge(User user) {
            mails.addAll(user.mails);
            return this;
        }

        List<String> toList() {
            ArrayList<String> str = new ArrayList<>(1 + mails.size());
            str.add(name);
            str.addAll(mails);
            return str;
        }

        @Override
        public int compareTo(User o) {
            if (this == o)
                return 0;
            if (o == null)
                return -1;
            for (String mail : o.mails) {
                if (mails.contains(mail)) {
                    mails.addAll(o.mails);
                    o.mails.addAll(mails);
                    return 0;
                }
            }
            return mails.first().compareTo(o.mails.first());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return Objects.equals(name, user.name) &&
                    Objects.equals(mails, user.mails);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + mails.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", mails=" + mails +
                    '}';
        }
    }
}
