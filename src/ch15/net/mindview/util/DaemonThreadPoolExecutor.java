//: net/mindview/util/DaemonThreadPoolExecutor.java
package ch15.net.mindview.util;

import java.util.concurrent.*;

/**
 * @author coofive
 */
public class DaemonThreadPoolExecutor
        extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new DaemonThreadFactory());
    }
} ///:~
