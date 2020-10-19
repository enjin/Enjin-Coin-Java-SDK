package com.enjin.sdk.events;

import com.enjin.sdk.models.EventType;
import com.enjin.sdk.models.Platform;

/**
 * Notification service interface for subscribing to and registering for events from the Enjin Cloud.
 */
public interface NotificationsService {

    /**
     * Starts this service.
     */
    void start();

    /**
     * Starts this service with the provided platform details.
     *
     * @param platform the platform
     */
    void start(Platform platform);

    /**
     * Checks if this service is connected to the platform.
     *
     * @return true if connected, else false
     */
    boolean isConnected();

    /**
     * Shuts down this service.
     */
    void shutdown();

    /**
     * Registers a notification listener and provides the registration object used for it.
     *
     * @param listener the listener
     * @return the registration
     */
    NotificationListenerRegistration registerListener(NotificationListener listener);

    /**
     * Registers a notification listener with an event matcher and provides the registration object used for it.
     *
     * @param listener the listener
     * @param matcher the event matcher
     * @return the registration
     */
    NotificationListenerRegistration registerListenerWithMatcher(NotificationListener listener,
                                                                 EventMatcher matcher);

    /**
     * Adds a notification listener with event types to allow and provides the registration object used for it.
     *
     * @param listener the listener
     * @param types the events to listen for
     * @return the registration
     */
    NotificationListenerRegistration registerListenerIncludingTypes(NotificationListener listener,
                                                                    EventType... types);

    /**
     * Adds a notification listener with event types to ignore and provides the registration object used for it.
     *
     * @param listener the listener
     * @param types the events to ignore
     * @return the registration
     */
    NotificationListenerRegistration registerListenerExcludingTypes(NotificationListener listener,
                                                                    EventType... types);

    /**
     * Unregisters a notification listener.
     *
     * @param listener the listener
     */
    void unregisterListener(NotificationListener listener);

    /**
     * Opens a channel for the specified application, allowing listeners to receive events for that application.
     *
     * @param app the app ID
     */
    void subscribeToApp(int app);

    /**
     * Closes a channel for the specified application, preventing listeners from receiving events for that application.
     *
     * @param app the app ID
     */
    void unsubscribeToApp(int app);

    /**
     * Determines if the channel is open for the specified application.
     *
     * @param app the app ID
     * @return true if open, else false
     */
    boolean isSubscribedToApp(int app);

    /**
     * Opens a channel for the specified player, allowing listeners to receive events for that identity.
     *
     * @param app the ID of the app the player is on
     * @param player the player ID
     */
    void subscribeToPlayer(int app, String player);

    /**
     * Closes a channel for the specified player, preventing listeners from receiving events for that identity.
     *
     * @param app the ID of the app the player is on
     * @param player the player ID
     */
    void unsubscribeToPlayer(int app, String player);

    /**
     * Determines if the channel is open for the specified player.
     *
     * @param app the ID of the app the player is on
     * @param player the player ID
     * @return true if open, else false
     */
    boolean isSubscribedToPlayer(int app, String player);

    /**
     * Opens a channel for the specified token (item), allowing listeners to receive events for that token.
     *
     * @param token the token ID
     */
    void subscribeToToken(String token);

    /**
     * Closes a channel for the specified token (item), preventing listeners from receiving events for that token.
     *
     * @param token the token ID
     */
    void unsubscribeToToken(String token);

    /**
     * Determines if the channel is open for the specified token (item).
     *
     * @param token the token ID
     * @return true if open, else false
     */
    boolean isSubscribedToToken(String token);

    /**
     * Opens a channel for the specified wallet address, allowing listeners to receive events for that wallet.
     *
     * @param wallet the address
     */
    void subscribeToWallet(String wallet);

    /**
     * Closes a channel for the specified wallet address, preventing listeners from receiving events for that wallet.
     *
     * @param wallet the address
     */
    void unsubscribeToWallet(String wallet);

    /**
     * Determines if the channel is open for the specified wallet address.
     *
     * @param wallet the address
     * @return true if open, else false
     */
    boolean isSubscribedToWallet(String wallet);

}