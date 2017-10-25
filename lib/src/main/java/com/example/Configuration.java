package com.example;

import com.google.gson.annotations.SerializedName;

public class Configuration {
    @SerializedName("current_version")
    private Integer version;

    @SerializedName("force_update")
    private Boolean update;

    @SerializedName("error")
    private String error;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer pVersion) {
        version = pVersion;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(final Boolean pUpdate) {
        update = pUpdate;
    }

    public String getError() {
        return error;
    }

    public void setError(final String pError) {
        error = pError;
    }
}
