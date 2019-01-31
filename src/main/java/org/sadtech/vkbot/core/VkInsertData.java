package org.sadtech.vkbot.core;

public class VkInsertData {

    private VkApi vkApi;
    private Integer userId;

    public VkInsertData(VkConnect vkConnect) {
        this.vkApi = new VkApi(vkConnect);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String insert(String key) {
        String string = "";
        if (key.toLowerCase().equals("%firstname%")) {
             string = vkApi.getUserMini(userId).getFirstName();
        }
        if (key.toLowerCase().equals("%lastname%")) {
            string = vkApi.getUserMini(userId).getLastName();
        }
        return string;
    }

}
