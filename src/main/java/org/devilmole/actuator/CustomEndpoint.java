package org.devilmole.actuator;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
@Component
public class CustomEndpoint implements Endpoint<List<String>> {

    public String getId() {
        return "customEndpoint";
    }

    public boolean isEnabled() {
        return true;
    }

    public boolean isSensitive() {
        return true;
    }

    public List<String> invoke() {
        // Custom logic to build the output
        List<String> messages = new ArrayList<String>();
        messages.add("This is message 1");
        messages.add("This is message 2");
        return messages;
    }
}
