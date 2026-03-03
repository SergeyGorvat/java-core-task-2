package filter;

@FunctionalInterface
public interface Filter<T> {
    T apply(T o);
}
