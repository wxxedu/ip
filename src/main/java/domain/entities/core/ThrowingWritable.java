package domain.entities.core;

import core.exceptions.WriteException;

/**
 * An interface wrapping around things that can be written to. This interface
 * can throw exceptions.
 */
public interface ThrowingWritable {
    /**
     * Write the content to the interface. This will not add a new line to the
     * method. The content's toString method will be called.
     *
     * @param content the content to be written to the interface.
     * @throws WriteException if the content could not be written to the
     *                        interface.
     */
    void write(Object content) throws WriteException;

    /**
     * Write the content to the interface. This will add a new line to the
     * method. The content's toString method will be called.
     *
     * @param content the content to be written to the interface.
     * @throws WriteException if the content could not be written to the
     *                        interface.
     */
    void writeln(Object content) throws WriteException;

    /**
     * Clear the interface.
     *
     * @throws WriteException if the interface could not be cleared.
     */
    void clear() throws WriteException;
}
