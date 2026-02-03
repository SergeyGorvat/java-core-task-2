package filter;

import java.util.Arrays;

public class ArrayFilterUtil {
    public <T> T[] filter(T[] array, Class<? extends FilterIml<T>> filterIml) {

        Filter<T> filterI;
        try {
            filterI = filterIml.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании экземпляра фильтра: \" + e.getMessage(), e");
        }

//        T[] result = array.clone();
//
//        for (int i = 0; i < result.length; i++) {
//            result[i] = filterI.apply(result[i]);
//        }

//        return result;

        return Arrays.stream(array)
                .map(filterI::apply)
                .toArray(length -> Arrays.copyOf(array, length));
    }
}
