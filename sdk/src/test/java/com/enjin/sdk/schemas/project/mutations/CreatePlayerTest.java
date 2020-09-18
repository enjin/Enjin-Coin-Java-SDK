package com.enjin.sdk.schemas.project.mutations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CreatePlayerTest {

    @Test
    void id_HasVariable() {
        // Arrange
        final String key = "id";
        final String expected = "value";
        final CreatePlayer request = new CreatePlayer();

        // Act
        request.id(expected);
        String actual = (String) request.getVariables().get(key);

        // Assert
        assertTrue(request.isSet(key));
        assertEquals(expected, actual);
    }

}