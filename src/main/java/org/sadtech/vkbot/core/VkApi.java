package org.sadtech.vkbot.core;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserMin;
import com.vk.api.sdk.objects.users.UserXtrCounters;

import java.util.List;

public class VkApi {

//    public static final Logger log = Logger.getLogger(String.valueOf(VkApi.class));

    private VkApiClient vk;
    private GroupActor actor;

    public VkApi(VkConnect vkConnect) {
        vk = vkConnect.getVkApiClient();
        actor = vkConnect.getGroupActor();
    }

    public UserMin getUserMini(Integer id) {
        UserMin userMin = null;
        Gson gson = new Gson();
        try {
            List<UserXtrCounters> temp = vk.users().get(actor).userIds(String.valueOf(id)).execute();
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(temp.get(0).toString().substring(15)).getAsJsonObject();
            object.add("last_name", object.get("lastName"));
            object.add("first_name", object.get("firstName"));
            userMin = gson.fromJson(object, UserMin.class);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return userMin;
    }

}
