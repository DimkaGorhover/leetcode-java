package ai.leverton.kata.library.domain;

import org.apache.commons.csv.CSVRecord;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Author implements Entity {

    private final String email;
    private final String firstName;
    private final String lastName;

    private float f = 2;
    private double d = 1;

    @lombok.Builder(builderClassName = "Builder", toBuilder = true)
    private Author(String email, String firstName, String lastName) {
        this.email = requireNonNull(email, "\"email\" cannot be null");
        this.firstName = requireNonNull(firstName, "\"firstName\" cannot be null");
        this.lastName = requireNonNull(lastName, "\"lastName\" cannot be null");
    }

    public static Author of(CSVRecord record) {
        requireNonNull(record, "\"record\" cannot be null");
        return builder()
                .email(record.get("email"))
                .firstName(record.get("firstName"))
                .lastName(record.get("lastName"))
                .build();
    }

    public String getEmail() { return email; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Float.compare(author.f, f) == 0 &&
                Double.compare(author.d, d) == 0 &&
                Objects.equals(email, author.email) &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        int  result;
        result = email != null ? email.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + Float.hashCode(f);
        result = 31 * result + Double.hashCode(d);
        return result;
    }

    static class Builder {}
}
