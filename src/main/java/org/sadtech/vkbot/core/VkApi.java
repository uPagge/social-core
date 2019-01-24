package org.sadtech.vkbot.core;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserXtrCounters;

import java.util.List;

public class VkApi {

    private VkApiClient vk;
    private GroupActor actor;

    public VkApi(VkConnect vkConnect) {
        vk = vkConnect.getVkApiClient();
        actor = vkConnect.getGroupActor();
    }

    public UserXtrCounters getUserVk(Integer id) {
        List<UserXtrCounters> temp = null;
        try {
            temp = vk.users().get(actor).userIds(String.valueOf(id)).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return temp.get(0);
    }

}
