package org.azavea.otm.data;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Model {
    protected JSONObject data;

    protected String safeGetString(String key) {
        try {
            return data.isNull(key) ? null : data.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }

    protected long getLongOrDefault(String key, Long defaultValue) throws JSONException {
        if (data.isNull(key)) {
            return defaultValue;
        } else {
            return data.getLong(key);
        }
    }

    protected double getDoubleOrDefault(String key, Double defaultValue) throws JSONException {
        if (data.isNull(key)) {
            return defaultValue;
        } else {
            return data.getDouble(key);
        }
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public JSONObject getData() {
        return data;
    }

    public Object getField(String key) {
        return data.isNull(key) ? null : data.opt(key);
    }
}
