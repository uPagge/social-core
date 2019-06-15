package org.sadtech.bot.core.domain.keyboard.button;

import org.sadtech.bot.core.domain.keyboard.ButtonType;
import org.sadtech.bot.core.domain.keyboard.KeyBoardButton;

import java.util.Objects;

public class KeyBoardButtonAccount extends KeyBoardButton {

    private Integer amount;
    private Integer accountId;
    private String description;

    private KeyBoardButtonAccount() {
        type = ButtonType.ACCOUNT;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public static Builder builder() {
        return new KeyBoardButtonAccount().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder amount(Integer amount) {
            KeyBoardButtonAccount.this.amount = amount;
            return this;
        }

        public Builder description(String description) {
            KeyBoardButtonAccount.this.description = description;
            return this;
        }

        public Builder accountId(Integer accountId) {
            KeyBoardButtonAccount.this.accountId = accountId;
            return this;
        }


        public KeyBoardButtonAccount build() {
            return KeyBoardButtonAccount.this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyBoardButtonAccount)) return false;
        if (!super.equals(o)) return false;
        KeyBoardButtonAccount that = (KeyBoardButtonAccount) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, description);
    }
}
