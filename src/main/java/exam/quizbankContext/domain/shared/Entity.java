package exam.quizbankContext.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
