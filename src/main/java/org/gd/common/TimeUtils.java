package org.gd.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-15
 */
public final class TimeUtils {

    private TimeUtils() { throw new UnsupportedOperationException(); }

    public static String toPrettyDuration(Duration duration) {
        return toPrettyDuration(duration.toMillis(), TimeUnit.MILLISECONDS);
    }

    public static String toPrettyDuration(long time, TimeUnit unit) {
        final long
                durationMillis = unit.toMillis(time),
                millis = durationMillis % 1000,
                seconds = durationMillis / 1000 % 60,
                minutes = durationMillis / 1000 / 60 % 60;

        StringBuilder timeString = new StringBuilder();
        if (minutes < 10)
            timeString.append('0');
        timeString.append(minutes).append(':');
        if (seconds < 10)
            timeString.append('0');
        timeString.append(seconds).append(':');
        final int zeros = 3 - Math.max(0, (int) Math.floor(Math.log10(millis)));
        for (int i = 0; i < zeros; i++)
            timeString.append('0');
        return timeString.append(millis).toString();
    }
}
