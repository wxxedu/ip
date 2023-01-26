package domain.entities.core;

/**
 * The interface that can registers its executables to the event loop. This
 * will allow us to keep the business logic inside the relevant class,
 * instead of leaving it in the main method.
 */
public interface ExecutableRegisterable {
    /**
     * Registers the executables related to this interface to the nestable.
     *
     * @param nestable the root executable to which the executable of this
     *                 interface shall be registered.
     */
    void register(NestableExecutableObject nestable);
}
