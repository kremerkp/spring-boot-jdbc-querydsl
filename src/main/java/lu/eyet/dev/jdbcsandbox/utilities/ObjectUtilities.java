package lu.eyet.dev.jdbcsandbox.utilities;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public abstract class ObjectUtilities {

    /**
     *
     * @param source
     * @return All Columns of the Object, that are set to Null
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
    }

    /**
     * Combines two Objects, ignoring Null - Values
     *
     * @param <T>
     * @param a
     * @param b
     * @param destination
     * @return
     */
    public static <T> T combine2Objects2(T a, T b, T destination) {
        BeanUtils.copyProperties(a, destination, getNullPropertyNames(a));
        BeanUtils.copyProperties(b, destination, getNullPropertyNames(b));
        return destination;

    }

}