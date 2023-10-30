package org.example.models;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * The CustomPlayerSerializer is responsible for custom serialization of the Player class.
 * It removes the prefix "_" from Player fields during the serialization process.
 */
public class CustomPlayerSerializer extends StdSerializer<Player> {

    public CustomPlayerSerializer() {
        this(null);
    }

    public CustomPlayerSerializer(Class<Player> t) {
        super(t);
    }
    /**
     * Serializes the Player object to JSON, removing the prefix "_" from field names.
     *
     * @param player            the Player object to be serialized
     * @param jsonGenerator     the JSON generator used for writing JSON content
     * @param serializerProvider the provider used for accessing serializers for serializing other objects
     * @throws IOException in case of an IO-related error during the serialization process
     */
    @Override
    public void serialize(Player player, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        // use reflection to obtain all fields of the Player class dynamically
        Field[] fields = Player.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // Remove the _ prefix that was added to Player fields
            String fieldName = field.getName().substring(1);
            try {
                Object value = field.get(player);
                jsonGenerator.writeObjectField(fieldName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        jsonGenerator.writeEndObject();
    }
}
