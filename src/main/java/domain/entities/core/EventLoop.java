package domain.entities.core;

import core.exceptions.DisposableException;

/**
 * This shall serve as the base for implementing an event loop. An event loop
 * loops forever unless the executable in it returns ExitStatus.terminate.
 */
public abstract class EventLoop implements Disposable {
    public EventLoop(Executable rootExecutable, StringReadable reader,
                     Writable errorWriter) {
        this.rootExecutable = rootExecutable;
        this.reader = reader;
        this.errorWriter = errorWriter;
    }

    /**
     * The root executable that shall be executed in the loop.
     */
    private final Executable rootExecutable;

    /**
     * The StringReadable that shall be used for providing the next line of
     * input to the event loop.
     */
    private final StringReadable reader;

    /**
     * The writer for writing the error messages.
     */
    private final Writable errorWriter;

    /**
     * The function for getting the tokens for each loop iteration.
     *
     * @return the array of tokens.
     */
    private String[] getTokens() {
        return reader.nextLine().trim().split(" ");
    }

    /**
     * The function that starts the event loop.
     */
    public void run() {
        ExitStatus status = ExitStatus.continueExecute;
        while (true) {
            status = rootExecutable.execute(getTokens());
            if (status == ExitStatus.terminate) {
                break;
            }
        }
        dispose();
    }

    @Override
    public void dispose() {
        if (rootExecutable instanceof Disposable) {
            try {
                ((Disposable) rootExecutable).dispose();
            } catch (DisposableException e) {
                errorWriter.writeln("Failed to dispose the root " +
                        "executable: " + e.getMessage());
            }
        }
        if (reader instanceof Disposable) {
            try {
                ((Disposable) reader).dispose();
            } catch (DisposableException e) {
                errorWriter.writeln("Failed to close the reader: "
                        + e.getMessage());
            }
        }
    }
}
