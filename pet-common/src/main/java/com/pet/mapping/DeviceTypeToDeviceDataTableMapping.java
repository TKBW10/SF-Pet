package com.pet.mapping;

import com.pet.constant.DeviceTypeConstants;

import java.util.HashMap;
import java.util.Map;

public class DeviceTypeToDeviceDataTableMapping {

    public static final Map<String, String> TYPE_TO_TABLE_MAP = new HashMap<>();

    static {
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.AIR_PURIFIER, "air_purifier_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.CAMERA, "camera_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.FEEDER, "feeder_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.HUMIDITY, "humidity_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.LIGHT, "light_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.LOCATOR, "locator_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.SMART_TOILET, "smart_toilet_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.TEMPERATURE, "temperature_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.THERMOSTAT, "thermostat_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.WATER_DISPENSER, "water_dispenser_data");
        TYPE_TO_TABLE_MAP.put(DeviceTypeConstants.WEIGHT_SCALE, "weight_scale_data");
    }

    public static String getTableNameByDeviceType(String deviceType) {
        return TYPE_TO_TABLE_MAP.get(deviceType);
    }
}
