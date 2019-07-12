package org.sadtech.social.core.service;

import com.google.gson.JsonObject;

import java.util.Queue;

/**
 * Интерфейс для взаимодействия с событиями социальной сети.
 *
 * @author upagge [08/07/2019]
 */
public interface RawEventService {

    void cleanAll();

    void add(JsonObject jsonObject);

    Queue<JsonObject> getJsonObjects();

}