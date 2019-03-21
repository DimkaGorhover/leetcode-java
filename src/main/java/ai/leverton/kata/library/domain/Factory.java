package ai.leverton.kata.library.domain;

public interface Factory<T extends Entity> {

    T create(String line);
}
