package com.hardik.otp.id.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Data
public class UniqueID {

    private long epochTime;
    private int counter;
    private byte machineID;

    private UniqueID() { }

    private static byte counterValue;

    static {
        counterValue = Byte.MIN_VALUE;
    }

    public static UniqueID generateUniqueId(byte machineID) {
        Instant instant = Instant.now();

        if (counterValue == Byte.MAX_VALUE) {
            counterValue = Byte.MIN_VALUE;
        }

        UniqueID uniqueID = new UniqueID();
        uniqueID.epochTime = instant.getEpochSecond();
        uniqueID.counter = counterValue++;
        uniqueID.machineID = machineID;

        return  uniqueID;
    }

    public String getUniqueId() {
        StringBuilder sb = new StringBuilder();
        sb.append(epochTime);
        sb.append(counter);
        sb.append(machineID);
        return sb.toString();
    }
}
