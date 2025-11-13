# Logger

## Basic usage
```java
// Basic logging
Logger.INFO.Log("informational message");
Logger.WARN.Log("warning message", false); // don't write to file
Logger.ERROR.Log("error message", false, true); // Bypass quiet flag
Logger.CRITICAL.Log("critical message");
Logger.DEBUG.Log("debug message");

// Thread logging. Same parameters with added Thread object
Logger.THREAD_INFO.LogThread(thread, "message from thread");
Logger.THREAD_INFO.LogThread(thread, "message from thread", false);
Logger.THREAD_INFO.LogThread(thread, "message from thread", false, true); // force

/*
    Exception logging. Same parameters now with added exception object
    In LoggerSettings enabling "enableStackTraces" will output full stacktraces
 */
Logger.CRITICAL.LogException(exception); // just exception
Logger.CRITICAL.LogException(exception, false);
Logger.CRITICAL.LogException(exception, "exception message"); // exception and message
Logger.CRITICAL.LogException(exception, "exception message", false);

// Special functions
// Log Silently, won't output to STDOUT instead will log to file
Logger.WARN.LogSilently("silently logged warning message");
Logger.ERROR.LogExceptionSilently("silently logged exception message");

// Log thread exception
// Same as LogException() except requires thread object
Logger.THREAD_ERROR.LogThreadException(thread, exception);
Logger.THREAD_ERROR.LogThreadException(thread, exception, false);
Logger.THREAD_ERROR.LogThreadException(thread, exception, "message");
Logger.THREAD_ERROR.LogThreadException(thread, exception, "message", false);
```