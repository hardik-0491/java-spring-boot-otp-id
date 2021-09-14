package com.hardik.otp.id.services;

import com.hardik.otp.id.model.UniqueID;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class IdGeneratorService {

    //This id should be fetched from services such as ZooKeeper
    private static final byte MACHINE_ID = 1;

    public String generateId() {
        return UniqueID.generateUniqueId(MACHINE_ID).getUniqueId();
    }

}
