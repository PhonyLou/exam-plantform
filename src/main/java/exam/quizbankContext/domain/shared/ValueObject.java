package exam.quizbankContext.domain.shared;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
