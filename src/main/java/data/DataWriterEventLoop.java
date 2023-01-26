package data;

import domain.entities.core.EventLoop;
import domain.entities.core.Executable;
import domain.entities.core.StringReadable;
import domain.entities.core.Writable;

public class DataWriterEventLoop extends EventLoop {
    private DataWriterEventLoop(Executable rootExecutable, StringReadable reader,
                               Writable errorWriter) {
        super(rootExecutable, reader, errorWriter);
    }
}
