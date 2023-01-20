package core.injections;

import presentation.ui.SystemOut;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Injections {
    /**
     * The dependencies stored in this dependencies section.
     */
    static private Map<Class<?>, Object> dependencies = new HashMap<>();

    /**
     * The dependency suppliers, used for lazy registration.
     */
    static private Map<Class<?>, Supplier<?>> dependencySuppliers =
            new HashMap<>();

    /**
     * Registers a class as a singleton, therefore, it would only be created
     * once.
     * @param cls the class of the object.
     * @param object the object itself.
     * @param <T> the type of the object.
     */
    static public <T> void registerSingleton(Class<T> cls,
                                             T object) {
        if (dependencies.containsKey(cls) || dependencySuppliers.containsKey(cls)) {
            return;
        }
        dependencies.put(cls, object);
    }

    /**
     * Registers a class as a lazy singleton. A lazy singleton will only get
     * instantiated if it was used.
     * @param cls the class of the object
     * @param supplier the lazy singleton of the object.
     * @param <T> the type of the object.
     */
    static public <T> void registerLazySingleton(Class<T> cls,
                                                 Supplier<T> supplier) {
        if (dependencies.containsKey(cls) || dependencySuppliers.containsKey(cls)) {
            return;
        }
        dependencySuppliers.put(cls, supplier);
    }

    /**
     * Gets an instance of the specified class.
     * @param cls the class of the class.
     * @return the object that has been registered for this class.
     * @param <T> the type of the object.
     */
    static public <T> T get(Class<T> cls) {
        if (dependencies.containsKey(cls)) {
            return cls.cast(dependencies.get(cls));
        } else if (dependencySuppliers.containsKey(cls)) {
            final T object = cls.cast(dependencySuppliers.get(cls));
            dependencies.put(cls, object);
            return object;
        }
        throw new RuntimeException("Dependency for " + cls.getName() + " has " +
                "not been injected.");
    }
}
