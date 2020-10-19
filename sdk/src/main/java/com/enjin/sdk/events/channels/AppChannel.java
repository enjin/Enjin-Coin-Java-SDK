package com.enjin.sdk.events.channels;

import com.enjin.sdk.models.Platform;
import lombok.NonNull;

/**
 * Represents a channel to subscribe to for Enjin Cloud application events.
 *
 * @see com.enjin.sdk.events.NotificationsService
 */
public class AppChannel implements Channel {

    private final Platform platform;
    private final int app;

    /**
     * Constructs a channel for the given network and application.
     *
     * @param platform the platform
     * @param app the app ID
     */
    public AppChannel(@NonNull Platform platform, int app) {
        this.platform = platform;
        this.app = app;
    }

    @Override
    public String channel() {
        return String.format("enjincloud.%s.app.%s",
                             platform.getNetwork().toLowerCase(),
                             app);
    }

}